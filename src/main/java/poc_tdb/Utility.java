package poc_tdb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.security.Security;
import java.sql.Timestamp;
import java.time.Instant;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFile;
import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFileEntry;

@Component
public class Utility {

	public static ArrayList<String> readFile(File file) {
		String destinationPath = "C:\\tdb\\prova\\";
		ArrayList<String> list = new ArrayList<String>();
		File newPath = new File(destinationPath + file.getName());
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				list.add(line);

			}
			return list;
		} catch (IOException e) {
			e.printStackTrace(); // Stampa eventuali errori
		}
		return null;

	}

	public static void moveFile(File originalPath, String destinationPath) throws IOException {
		File destination = new File(destinationPath + originalPath.getName());
		Files.move(originalPath.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
	}

	public static InputStream readGpg(String string) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(string));
		return null;
	}

	public static ArrayList<DoneFileEntry> createDoneFileEntry(ArrayList<String> arrayString) {
		ArrayList<DoneFileEntry> doneFileEntryList = new ArrayList();
		for (String element : arrayString) {
			if (element.contains("=")) {
				String[] prova = element.split("=");

				DoneFileEntry donefileentry = new DoneFileEntry(prova[0], Integer.parseInt(prova[1]));
				doneFileEntryList.add(donefileentry);
			}

		}

		return doneFileEntryList;
	}

	public static DoneFile createDoneFile(String fileName, ArrayList<String> readedFile,
			ArrayList<DoneFileEntry> doneFileEntryList) {
		DoneFile doneFile = new DoneFile();
		doneFile.setFileName(fileName);
		doneFile.setNumberOfBytes(Integer.parseInt(readedFile.get(0)));
		doneFile.setFileEntries(doneFileEntryList);
		return doneFile;
	}

	public static boolean compareFileEntries(ArrayList<DoneFileEntry> dotFiles, HashMap<String, String> doneFileEntries,
			DoneFile doneFile) throws Exception {
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
			throw new IOException("ERROR - The following files specified in " + doneFile.getFileName()
					+ " have not been found: " + missingEntry);

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
			result[i] = rows[i].split("\\|", -1); // Il flag -1 mantiene anche i vuoti
		}

		return result;
	}

	public int getRecordsByFilename(String filename, ArrayList<DoneFileEntry> dotFiles) {
		for (DoneFileEntry entry : dotFiles) {
			if (entry.getFilename().equals(filename)) {
				return entry.getRecords();
			}
		}
		// Se non trovato, puoi restituire un valore predefinito o lanciare un'eccezione
		return -1; // o puoi lanciare un'eccezione come new NoSuchElementException("File not
					// found")
	}

	public Utility() {
	}
}
