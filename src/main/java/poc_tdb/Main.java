package poc_tdb;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.sql.DataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
public class Main {
	
	private static final Logger logger = LogManager.getLogger(Main.class);
	private static SqlProperty sqlProperty;
	private static DataSource ds;

	public Main(SqlProperty sqlProperty) {
		this.sqlProperty = sqlProperty;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Main.class, args);
		// Utility utility = new Utility();
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
		HashMap<String, String> filesUnzipped = new HashMap<String, String>();
		char[] passPhrase = "ESBA1rmalta.".toCharArray();
		PreprocessTdbBatchSubflow preprocess = new PreprocessTdbBatchSubflow();
		SqlQueries sqlQ = new SqlQueries(sqlProperty);
		iterateOverDoneFileEntries iterateOverDoneFile = new iterateOverDoneFileEntries();
		// Controllo se il percorso è una directory
		if (folder.isDirectory()) {

			// Lista dei file nella cartella
			File[] fileList = folder.listFiles();

			if (fileList.length != 0) {
				for (File file : fileList) {
					fileName = file.getName();

					// Per ogni file controllo estensione
					if (fileName.endsWith(".done")) {
						ArrayList<String> readedFile = Utility.readFile(file);

						// Array di doneFileEntry per fileEntries
						ArrayList<DoneFileEntry> doneFileEntryList = Utility.createDoneFileEntry(readedFile);

						// Crezione del DoneFile
						doneFile = Utility.createDoneFile(fileName, readedFile, doneFileEntryList);

						// Nome encFileName
						encFileName = doneFile.getFileName().substring(0, doneFile.getFileName().length() - 5)
								.concat(".zip.gpg");

						// Ciclo sui file criptati
						for (File fileEnc : fileList) {
							if (fileEnc.getName().equals(encFileName)) {

								// Decripta file
								byte[] decryptedFile = decrypt.decryptFile(filePath.concat("\\" + encFileName),passPhrase);
								Path path = Path.of(fileEnc.getPath());
								InputStream inputStream = Files.newInputStream(path);
								CountingInputStream countingInputStream = (CountingInputStream) querySingleFileProcessor.onCall(inputStream);
								try {
									// Unzip del file
									filesUnzipped = unzip.unzipToMemory(decryptedFile);
									// Controllo bytes tra DoneFileEntries e DoneFile
									if (Utility.compareFileEntries(doneFileEntryList, filesUnzipped, doneFile)) {

										// Se non corrisponde, eccezione
										if (countingInputStream.available() != doneFile.getNumberOfBytes()) {
											throw new IOException("File size denoted in " + doneFile.getFileName()
													+ " (" + doneFile.getNumberOfBytes() + " bytes) does not match "
													+ encFileName + " file size (" + countingInputStream.available()
													+ ")");
										} else {
											iterateOverDoneFile.iterateOverDoneFile(filesUnzipped, doneFileEntryList,encFileName);

										}
									}
								} catch (IOException e) {
									System.out.println(e.getMessage());
									logger.error(e.getMessage());
								}

							}
						}
						// Sposta il file in un'altra cartella
						// utility.moveFile(file, destinationPath);
					} else {
						// utility.moveFile(file, destinationPath);
					}

				}
			}
		} else {
			System.out.println("La cartella è vuota o non accessibile.");
			logger.error("La cartella è vuota o non accessibile.");
		}
		
	}

}