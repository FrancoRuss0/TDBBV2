package com.kmmaltairlines.hip.tdbingester.poc_tdb;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import com.google.common.io.CountingInputStream;
import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFile;
import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFileEntry;
import com.kmmaltairlines.hip.tdbingester.sftp.QuerySingleFileProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
@EnableScheduling
public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    @Autowired
    private SqlProperty sqlProperty;
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
    }

    // Metodo schedulato per il controllo dei file nella cartella e processarli
    @Scheduled(fixedRateString = "${sftp.pollingFrequency}")
    public void scheduledFileProcessing() throws Exception {
        String filePath = "C:\\tdb"; // Modifica con il percorso desiderato
        String destinationPath = "C:\\tdb1\\";

        File folder = new File(filePath);
        HashMap<String, String> filesUnzipped = new HashMap<>();
        char[] passPhrase = "ESBA1rmalta.".toCharArray();

        if (folder.isDirectory()) {
            File[] fileList = folder.listFiles();

            if (fileList != null && fileList.length > 0) {
                for (File file : fileList) {
                    String fileName = file.getName();
                    if (fileName.endsWith(".done")) {
                        ArrayList<String> readedFile = Utility.readFile(file);
                        
                        // Crea il DoneFileEntry dalla lista letta
                        ArrayList<DoneFileEntry> doneFileEntryList = Utility.createDoneFileEntry(readedFile);
                        
                        // Creazione del DoneFile
                        DoneFile doneFile = Utility.createDoneFile(fileName, readedFile, doneFileEntryList);

                        // Crea il nome del file criptato
                        String encFileName = doneFile.getFileName().substring(0, doneFile.getFileName().length() - 5)
                                .concat(".zip.gpg");

                        // Cerca il file criptato e processalo
                        for (File fileEnc : fileList) {
                            if (fileEnc.getName().equals(encFileName)) {
                                try {
                                    // Decripta il file
                                    Decrypt decrypt = new Decrypt();
                                    byte[] decryptedFile = decrypt.decryptFile(filePath.concat("\\" + encFileName), passPhrase);

                                    // Unzip e controllo della validità del file
                                    QuerySingleFileProcessor querySingleFileProcessor = new QuerySingleFileProcessor();
                                    Path path = Path.of(fileEnc.getPath());
                                    InputStream inputStream = Files.newInputStream(path);
                                    CountingInputStream countingInputStream = (CountingInputStream) querySingleFileProcessor.onCall(inputStream);

                                    Unzip unzip = new Unzip();
                                    filesUnzipped = unzip.unzipToMemory(decryptedFile);
                                    if (Utility.compareFileEntries(doneFileEntryList, filesUnzipped, doneFile)) {
                                        if (countingInputStream.available() != doneFile.getNumberOfBytes()) {
                                            throw new IOException("File size mismatch between the done file and the decrypted file.");
                                        } else {
                                            IterateOverDoneFileEntries iterateOverDoneFile = new IterateOverDoneFileEntries(sqlProperty);
                                            iterateOverDoneFile.iterateOverDoneFile(filesUnzipped, doneFileEntryList, encFileName);
                                        }
                                    }
                                } catch (IOException e) {
                                    logger.error("Error processing file: " + e.getMessage());
                                }
                            }
                        }

                        // Sposta il file nella cartella di destinazione
                        Utility utility = new Utility();
                        utility.moveFile(file, destinationPath);
                    } else {
                        // Se non è un file .done, spostalo comunque nella cartella di destinazione
                        Utility utility = new Utility();
                        utility.moveFile(file, destinationPath);
                    }
                }
            }else {
            	System.out.println("La cartella è vuota");
            	logger.info("La cartella è vuota");
            }
        } else {
            logger.error("La cartella non è accessibile.");
        }
    }
}
