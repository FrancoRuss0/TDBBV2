package com.kmmaltairlines.hip.tdbingester.poc_tdb;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import com.google.common.io.CountingInputStream;
import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFile;
import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFileEntry;
import com.kmmaltairlines.hip.tdbingester.sftp.QuerySingleFileProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
@EnableScheduling
public class Main {

	// Logger to record events and errors
	private static final Logger logger = LogManager.getLogger(Main.class);

	@Autowired
	private SqlProperty sqlProperty;

	public static void main(String[] args) throws Exception {
		// Start the Spring Boot application
		SpringApplication.run(Main.class, args);
	}

	// Scheduled method that processes files in the specified folder at regular
	// intervals
	@Scheduled(fixedRateString = "${sftp.pollingFrequency}")
	public void scheduledFileProcessing() throws Exception {
	    String filePath = "C:\\tdb"; // Specify the folder path to monitor
	    String destinationPath = "C:\\tdb1\\"; // Specify the folder path to move processed files
	    boolean shouldBreak = false;
	    String prova="a";
	    File folder = new File(filePath);
	    HashMap<String, String> filesUnzipped = new HashMap<>();
	    char[] passPhrase = "ESBA1rmalta.".toCharArray(); // Encryption passphrase for decryption

	    if (folder.isDirectory()) { // Check if the specified folder exists and is a directory
	        File[] fileList = folder.listFiles(); // List all files in the folder

	        if (fileList != null && fileList.length > 0) { // Check if there are files in the folder
	            for (File file : fileList) {
	                System.out.println("FILE IN PROCESS----> " + file);
	                String fileName = file.getName();

	                // If the file is a ".done" file, proceed with processing
	                if (fileName.endsWith(".done")) {
	                    // Read the contents of the ".done" file
	                    ArrayList<String> readedFile = Utility.readFile(file);

	                    // Create a list of DoneFileEntry objects from the read data
	                    ArrayList<DoneFileEntry> doneFileEntryList = Utility.createDoneFileEntry(readedFile);

	                    // Create a DoneFile object containing metadata and data from the ".done" file
	                    DoneFile doneFile = Utility.createDoneFile(fileName, readedFile, doneFileEntryList);

	                    // Generate the name of the encrypted file associated with the ".done" file
	                    String encFileName = doneFile.getFileName().substring(0, doneFile.getFileName().length() - 5)
	                            .concat(".zip.gpg");

	                    // Search for the encrypted file that matches the generated name
	                    for (File fileEnc : fileList) {
	                        if (fileEnc.getName().equals(encFileName)) {
	                        	try {
	                        	    // Decrypt the encrypted file using the passphrase
	                        	    Decrypt decrypt = new Decrypt();
	                        	    byte[] decryptedFile = decrypt.decryptFile(filePath.concat("\\" + encFileName), passPhrase);
	                        	    
	                        	    // Process the decrypted file (unzip and check validity)
	                        	    QuerySingleFileProcessor querySingleFileProcessor = new QuerySingleFileProcessor();
	                        	    Path path = Path.of(fileEnc.getPath());
	                        	    
	                        	    // Use try-with-resources to ensure InputStream and CountingInputStream are closed
	                        	    try (InputStream inputStream = Files.newInputStream(path);
	                        	         CountingInputStream countingInputStream = (CountingInputStream) querySingleFileProcessor.onCall(inputStream)) {
	                        	        // Unzip the decrypted file into memory
	                        	        Unzip unzip = new Unzip();
	                        	        filesUnzipped = unzip.unzipToMemory(decryptedFile);

	                        	        // Validate the file content by comparing with entries from the ".done" file
	                        	        if (Utility.compareFileEntries(doneFileEntryList, filesUnzipped, doneFile)) {
	                        	            // Check if the file size matches the expected size from the ".done" file
	                        	            if (countingInputStream.available() != doneFile.getNumberOfBytes()) {
	                        	                throw new IOException("File size mismatch between the done file and the decrypted file.");
	                        	            } else {
	                        	                // Process the unzipped files and insert into the database
	                        	                IterateOverDoneFileEntries iterateOverDoneFile = new IterateOverDoneFileEntries(sqlProperty);
	                        	                iterateOverDoneFile.iterateOverDoneFile(filesUnzipped, doneFileEntryList, encFileName);

	                        	                // Move the processed file to the destination folder
	                        	                Utility.moveFile(file, destinationPath);
	                        	            }
	                        	        }
	                        	    }
	                        	} catch (IOException e) {
	                        	    // Log any error during file processing, but continue processing the next file
	                        	    logger.error("Error processing file " + file.getName() + ": " + e.getMessage());
	                        	    Utility.moveFile(file, destinationPath);
	                        	    break;
	                        	}

	                        }
	                    }
	                } else {
	                    // If the file is not a ".done" file, move it to the destination folder
	                    System.out.println("File not .done " + file);
	                    Utility.moveFile(file, destinationPath);
	                }
	            }
	            
	        } else {
	            // Log if the folder is empty
	            System.out.println("The folder is empty.");
	            logger.info("The folder is empty.");
	        }
	        
	    } else {
	        // Log if the folder is not accessible
	        logger.error("The folder is not accessible.");
	    }
	    
	}
}
