package poc_tdb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.airmalta.hip.tdbingester.filepojos.DoneFile;
import com.airmalta.hip.tdbingester.filepojos.DoneFileEntry;
import java.sql.Timestamp;
import java.time.Instant;





public class Utility {
	
	
	
	public static ArrayList<String> readFile(File file) {
		ArrayList<String> list = new ArrayList<String>();

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				list.add(line);

			}
			return list; 
		} catch (IOException e) {
			e.printStackTrace(); // Stampa eventuali errori
		}
		return list;

	}
	
	public static ArrayList<DoneFileEntry> createDoneFileEntry(ArrayList<String> lezzo) {

		ArrayList<DoneFileEntry> doneFileEntryList = new ArrayList();
		for (String element : lezzo) {
			if (element.contains("=")) {
				String[] prova = element.split("=");

				DoneFileEntry donefileentry = new DoneFileEntry(prova[0], Integer.parseInt(prova[1]));
				doneFileEntryList.add(donefileentry);
			}

		}

		return doneFileEntryList;
	}

	public static DoneFile createDoneFile(String fileName, ArrayList<String> readedFile, ArrayList<DoneFileEntry> doneFileEntryList) {
		DoneFile doneFile = new DoneFile();
		doneFile.setFileName(fileName);
		doneFile.setNumberOfBytes(Integer.parseInt(readedFile.get(0)));
		System.out.println(Integer.parseInt(readedFile.get(0)));
		doneFile.setFileEntries(doneFileEntryList);
		return doneFile;
	}
	
	public static String addProvider() {
    	BouncyCastleProvider bcProvider = new BouncyCastleProvider();
		Security.addProvider(bcProvider);
		return bcProvider.getName();
	}
	
	public static boolean compareFileEntries(ArrayList<DoneFileEntry> dotFiles, HashMap<String, String> doneFileEntries, DoneFile doneFile) throws Exception {
		int count = 0;
		int sizeDoneFileEntry = doneFileEntries.size();
		ArrayList<String> missingEntry = new ArrayList<>();
		for (String key : doneFileEntries.keySet()) {
			String baseFilename = key.split("_")[0];
			missingEntry.add(baseFilename);
			for (DoneFileEntry element : dotFiles) {
				if (baseFilename.equals(element.getFilename())) {
					count++;
					missingEntry.remove(element.getFilename());
				}	
					}
			}
		if (count == sizeDoneFileEntry) {
			return true;
			
		} else {
			throw new IOException("ERROR - The following files specified in " + doneFile.getFileName() + " have not been found: " + missingEntry);
			
 
		}
		
	}
	
	public static Timestamp nowUtcTimestamp() {
	    return Timestamp.from(Instant.now()); // Usa Instant per ottenere il tempo in UTC
	}
	
	public static String[][] processInputString(String inputString) {
	    // Separare le righe sulla base dei caratteri di nuova linea (\n)
	    String[] rows = inputString.split("\n");
	    String[][] result = new String[rows.length][];

	    // Separazione delle righe in colonne, mantenendo anche le celle vuote
	    for (int i = 0; i < rows.length; i++) {
	        result[i] = rows[i].split("\\|", -1);  // Il flag -1 mantiene anche i vuoti
	    }

	    return result;
	}
	
	public int getRecordsByFilename(String filename,ArrayList<DoneFileEntry> dotFiles) {
	    for (DoneFileEntry entry : dotFiles) {
	        if (entry.getFilename().equals(filename)) {
	            return entry.getRecords();
	        }
	    }
	    // Se non trovato, puoi restituire un valore predefinito o lanciare un'eccezione
	    return -1;  // o puoi lanciare un'eccezione come new NoSuchElementException("File not found")
	}
}
