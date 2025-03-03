package poc_tdb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.common.io.CountingInputStream;
import com.airmalta.hip.tdbingester.filepojos.ACSFlight;
import com.airmalta.hip.tdbingester.filepojos.DoneFile;
import com.airmalta.hip.tdbingester.filepojos.DoneFileEntry;
import com.airmalta.hip.tdbingester.sftp.QuerySingleFileProcessor;

import org.mule.weave.v2.runtime.DataWeaveResult;
import org.mule.weave.v2.runtime.DataWeaveScript;
import org.mule.weave.v2.runtime.DataWeaveScriptingEngine;
import org.mule.weave.v2.runtime.ExecuteResult;
import org.mule.weave.v2.runtime.ScriptingBindings;
import com.fasterxml.jackson.databind.ObjectMapper;



public class Main {

	 public static void main(String[] args) throws Exception {
		 Utility utility = new Utility();
			String filePath = "C:\\tdb"; // Modifica con il percorso desiderato
			String destinationPath = "C:\\tdb1\\";
			String fileName;
			String[] fileNameList;
			DoneFile doneFile = new DoneFile();
			String encFileName;
			QuerySingleFileProcessor querySingleFileProcessor = new QuerySingleFileProcessor();
			Decrypt decrypt = new Decrypt();
			Unzip unzip = new Unzip();
			// Creazione oggetto File
			File folder = new File(filePath);
			HashMap<String,String> filesUnzipped = new HashMap<String,String>();
			char[] passPhrase = "ESBA1rmalta.".toCharArray();
			IterateOverDoneFileEntriesToPopulateAndPersistFilePojos a= new IterateOverDoneFileEntriesToPopulateAndPersistFilePojos();

			// Controllo se il percorso è una directory
			if (folder.isDirectory()) {

				// Lista dei file nella cartella
				File[] fileList = folder.listFiles();

				if (fileList.length != 0) {
					for (File file : fileList) {
						fileName = file.getName();

						// Per ogni file controllo estensione
						if (fileName.endsWith(".done")) {
							ArrayList<String> readedFile = utility.readFile(file);

							// Array di doneFileEntry per fileEntries
							ArrayList<DoneFileEntry> doneFileEntryList = utility.createDoneFileEntry(readedFile);

							// Crezione del DoneFile
							doneFile = utility.createDoneFile(fileName, readedFile, doneFileEntryList);

							// Nome encFileName
							encFileName = doneFile.getFileName().substring(0, doneFile.getFileName().length() - 5).concat(".zip.gpg");
							
							System.out.println(encFileName);
							
							//Ciclo sui file criptati
							for (File fileEnc : fileList) {
								if (fileEnc.getName().equals(encFileName)) {
									
									//Decripta file
									byte[] decryptedFile = decrypt.decryptFile(filePath.concat("\\" + encFileName), passPhrase);
									Path path = Path.of(fileEnc.getPath());
									InputStream inputStream = Files.newInputStream(path);
									CountingInputStream countingInputStream = (CountingInputStream) querySingleFileProcessor.onCall(inputStream);
							        try {
							        	//Unzip del file
							             filesUnzipped = unzip.unzipToMemory(decryptedFile); 
							             //Controllo bytes tra DoneFileEntries e DoneFile
							            if(utility.compareFileEntries(doneFileEntryList, filesUnzipped, doneFile)) { 
							            		//Se non corrisponde, eccezione
												if(countingInputStream.available() != doneFile.getNumberOfBytes()) {
													throw new IOException("File size denoted in " + doneFile.getFileName() + " (" + doneFile.getNumberOfBytes() + " bytes) does not match " + encFileName + " file size (" + countingInputStream.available() + ")");
												}				
												}
							         a.IterateOverDoneFileEntriesToPopulateAndPersistFilePojos(filesUnzipped,doneFileEntryList);   
							        } catch (IOException e) {
							           System.out.println(e.getMessage());
							        }
								}
							}
							//Sposta il file in un'altra cartella
							//utility.moveFile(file, destinationPath);
						} else {
							System.out.println("Il file " + file.getName() + " non ha estensione '.done'");
							//utility.moveFile(file, destinationPath);
						}

					}
				}
			} else {
				System.out.println("La cartella è vuota o non accessibile.");
			}
	    }

}