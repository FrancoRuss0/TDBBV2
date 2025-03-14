package com.kmmaltairlines.hip.tdbingester.poc_tdb;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;

import com.google.common.io.CountingInputStream;
import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFile;
import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFileEntry;
import com.kmmaltairlines.hip.tdbingester.sftp.QuerySingleFileProcessor;
import com.kmmaltairlines.mail.EmailRequest;
import com.kmmaltairlines.mail.MailService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication(scanBasePackages = "com")
@EnableScheduling
public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    @Autowired
    private Utility utility;
    @Autowired
    private IterateOverDoneFileEntries iterateOverDoneFileEntries;
    @Autowired
    private Decrypt decrypt;
    @Autowired
    private Unzip unzip;
    @Autowired
    private MailService mailService;
    @Autowired
    private EmailRequest emailRequest;

    @Value("${storage.db.jdbcUrl}")
    private String url;
    @Value("${storage.db.user}")
    private String username;
    @Value("${storage.db.password}")
    private String password;
    @Value("${pgp.passphrase}")
    private String passphrase;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
    }

    @Scheduled(fixedRateString = "${sftp.pollingFrequency}")
    public void scheduledFileProcessing() throws Exception {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            String filePath = "C:\\tdb";
            String destinationPath = "C:\\tdb1\\";
            HashMap<String, String> filesUnzipped = new HashMap<>();
            char[] passPhrase = passphrase.toCharArray();

            try {
                File folder = new File(filePath);
                if (folder.isDirectory()) {
                    File[] fileList = folder.listFiles();
                    if (fileList != null && fileList.length > 0) {
                        for (File file : fileList) {
                            String fileName = file.getName();
                            if (fileName.endsWith(".done")) {
                            	  ArrayList<String> readedFile = utility.readFile(file);
                                  ArrayList<DoneFileEntry> doneFileEntryList = utility.createDoneFileEntry(readedFile);
                                  DoneFile doneFile = utility.createDoneFile(fileName, readedFile, doneFileEntryList);
                                  String encFileName = doneFile.getFileName().substring(0, doneFile.getFileName().length() - 5).concat(".zip.gpg");

                                  for (File fileEnc : fileList) {
                                      if (fileEnc.getName().equals(encFileName)) {
                                          try {
                                              byte[] decryptedFile = decrypt.decryptFile(filePath.concat("\\" + encFileName), passPhrase);
                                              QuerySingleFileProcessor querySingleFileProcessor = new QuerySingleFileProcessor();
                                              Path path = Path.of(fileEnc.getPath());

                                              try (InputStream inputStream = Files.newInputStream(path);
                                                   CountingInputStream countingInputStream = (CountingInputStream) querySingleFileProcessor.onCall(inputStream)) {
                                                  filesUnzipped = unzip.unzipToMemory(decryptedFile);
                                                  if (utility.compareFileEntries(doneFileEntryList, filesUnzipped, doneFile)) {
                                                      if (countingInputStream.available() != doneFile.getNumberOfBytes()) {
                                                          throw new IOException("File size mismatch between the done file and the decrypted file.");
                                                      } else {
                                                          iterateOverDoneFileEntries.iterateOverDoneFile(filesUnzipped, doneFileEntryList, encFileName, connection);
                                                          utility.moveFile(file, destinationPath);
                                                      }
                                                  }
                                              } catch (IOException e) {
                                                  if (e.getMessage().equals("File size mismatch between the done file and the decrypted file.")) {
                                                      logger.error("File size mismatch for " + file.getName() + ": " + e.getMessage());
                                                      sendErrorEmail(e.getMessage() , file.getName(), encFileName,"", Arrays.toString(e.getStackTrace())); // Nessun percorso di cartella qui
                                                      utility.moveFile(file, "C:\\tdb_error\\");
                                                  } else {
                                                      logger.error("Error processing file " + file.getName() + ": " + e.getMessage());
                                                      sendErrorEmail(e.getMessage() , file.getName(), encFileName,"", Arrays.toString(e.getStackTrace())); // Nessun percorso di cartella qui
                                                      utility.moveFile(file, destinationPath);
                                                  }
                                                  break;
                                              }
                                          } catch (Exception e) {
                                              logger.error("Error processing file " + file.getName() + ": " + e.getMessage());
                                              utility.moveFile(file, destinationPath);
                                              break;
                                          }
                                      }
                                  }
                            } else {
                                utility.moveFile(file, destinationPath);
                            }
                        }
                    } else {
                        logger.info("The folder is empty.");
                    }
                } else {
                    logger.error("The folder is not accessible.");
                    sendErrorEmail("The folder is not accessible.","", "", filePath,""); // Passa il percorso della cartella
                }
            } catch (Exception e) {
                logger.error("Error during scheduled file processing: " + e.getMessage());
                sendErrorEmail("Error during scheduled file processing: " + e.getMessage(),"", "", filePath,""); // Passa il percorso della cartella
            } finally {
                if (connection != null) {
                    connection.close();
                }
            }
        } catch (Exception e) {
            logger.error("Error during database connection: " + e.getMessage());
            sendErrorEmail(e.getMessage(),"" , "", "", Arrays.toString(e.getStackTrace())); // Nessun percorso di cartella qui
        }
    }

    private void sendErrorEmail(String errorMessage,String  donefileName,String encFileName, String folderPath,String e ) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("exceptionCause", errorMessage);
        variables.put("donefileName", donefileName);
        variables.put("encFileName", encFileName);

        String formattedFolderPath = "";
        if (folderPath != null && !folderPath.isEmpty()) {
            formattedFolderPath = "Path '" + folderPath + "' doesn't exist";
            variables.put("exceptionStackTrace", formattedFolderPath); // Usa il percorso formattato come stack trace
        }else {
        	variables.put("exceptionStackTrace", e); 
        }

        

        try {
            emailRequest.setTemplateMessage("exception_email_template", variables);
            emailRequest.setSubject("Error in Travel Data Batch Ingester");
            mailService.sendEmail(emailRequest);
            logger.info("Error email sent successfully.");
        } catch (Exception emailException) {
            logger.error("Error sending email: " + emailException.getMessage());
        }
    }
}