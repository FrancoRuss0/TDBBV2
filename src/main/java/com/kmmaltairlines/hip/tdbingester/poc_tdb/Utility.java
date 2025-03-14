package com.kmmaltairlines.hip.tdbingester.poc_tdb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFile;
import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFileEntry;
import com.kmmaltairlines.hip.tdbingester.filepojos.PNRRecord;
import com.kmmaltairlines.hip.tdbingester.filepojos.VCRRecord;
import com.kmmaltairlines.hip.tdbingester.processing.SabreDuplicateFileRecordPruner;

@Component
public class Utility {

	private static final Logger logger = LogManager.getLogger(Utility.class);

	/**
	 * Reads the content of a file and returns it as a list of strings, where each
	 * string represents one line of the file.
	 * 
	 * @param file - The file to be read.
	 * @return An ArrayList of strings where each element is a line from the file.
	 */
	public ArrayList<String> readFile(File file) {
		ArrayList<String> list = new ArrayList<String>(); // List to hold lines of the file
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) { // BufferedReader to read the file line
																					// by line
			String line;
			while ((line = reader.readLine()) != null) {
				list.add(line); // Add each line to the list
			}
			reader.close();
			return list; // Return the list of lines
		} catch (IOException e) {
			e.printStackTrace(); // Print the stack trace if an error occurs
		}
		return null; // Return null if the file can't be read
	}

	/**
	 * Moves a file from its original path to a new destination.
	 * 
	 * @param originalPath    - The path where the original file is located.
	 * @param destinationPath - The new destination where the file should be moved.
	 * @throws IOException - If an I/O error occurs during the file move operation.
	 */
	public void moveFile(File originalPath, String destinationPath) throws IOException {
		File destination = new File(destinationPath + originalPath.getName()); // Create a new file object for the
																				// destination
		Files.move(originalPath.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING); // Move the file
																										// to the new
																										// destination
	}

	/**
	 * Reads a GPG file and returns its InputStream.
	 * 
	 * @param string - The file path of the GPG file.
	 * @return InputStream - The InputStream for the GPG file.
	 * @throws FileNotFoundException - If the GPG file is not found.
	 */
	public InputStream readGpg(String string) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(string)); // BufferedReader to read the file
		return null; // Currently, this method is incomplete and returns null
	}

	/**
	 * Creates a list of DoneFileEntry objects from an array of strings.
	 * 
	 * @param arrayString - An ArrayList of strings where each string is in the
	 *                    format "key=value".
	 * @return An ArrayList of DoneFileEntry objects created from the strings.
	 */
	public ArrayList<DoneFileEntry> createDoneFileEntry(ArrayList<String> arrayString) {
		ArrayList<DoneFileEntry> doneFileEntryList = new ArrayList<>();
		for (String element : arrayString) {
			if (element.contains("=")) { // Only process elements that contain an equal sign
				String[] prova = element.split("="); // Split the string into key and value
				DoneFileEntry donefileentry = new DoneFileEntry(prova[0], Integer.parseInt(prova[1])); // Create a new
																										// DoneFileEntry
				doneFileEntryList.add(donefileentry); // Add it to the list
			}
		}
		return doneFileEntryList; // Return the list of DoneFileEntry objects
	}

	/**
	 * Creates a DoneFile object from a file name, a list of strings representing
	 * the file contents, and a list of DoneFileEntry objects.
	 * 
	 * @param fileName          - The name of the file.
	 * @param readedFile        - The contents of the file as a list of strings.
	 * @param doneFileEntryList - The list of DoneFileEntry objects.
	 * @return A DoneFile object populated with the provided data.
	 */
	public DoneFile createDoneFile(String fileName, ArrayList<String> readedFile,
			ArrayList<DoneFileEntry> doneFileEntryList) {
		DoneFile doneFile = new DoneFile();
		doneFile.setFileName(fileName); // Set the file name
		doneFile.setNumberOfBytes(Integer.parseInt(readedFile.get(0))); // Set the number of bytes (from the first
																		// element of readedFile)
		doneFile.setFileEntries(doneFileEntryList); // Set the list of DoneFileEntry objects
		return doneFile; // Return the populated DoneFile object
	}

	/**
	 * Compares the file entries in the provided DoneFileEntry list and the
	 * DoneFileEntries in the HashMap. Throws an exception if any expected file
	 * entries are missing.
	 * 
	 * @param dotFiles        - The list of DoneFileEntry objects.
	 * @param doneFileEntries - A HashMap of done file entries where keys are
	 *                        filenames and values are corresponding values.
	 * @param doneFile        - The DoneFile object that contains the expected file
	 *                        entries.
	 * @return A boolean indicating whether all file entries are present.
	 * @throws Exception If any file entries are missing, an exception is thrown.
	 */
	public boolean compareFileEntries(ArrayList<DoneFileEntry> dotFiles, HashMap<String, String> doneFileEntries,
			DoneFile doneFile) throws Exception {
		String baseFilename;
		int count = 0;
		int sizeDoneFileEntry = doneFileEntries.size();
		ArrayList<String> missingEntry = new ArrayList<>();
		// Iterate over the entries in doneFileEntries
		for (String key : doneFileEntries.keySet()) {
			String[] parts = key.split("_");
			if (parts.length < 3) {
				baseFilename = parts[0];

			} else {
				baseFilename = parts[0] + "_" + parts[1]; // Se non ci sono underscore, restituiamo l'intero nome
			}
			// String baseFilename = key.substring(0, underscoreIndex); // Extract the base
			// filename from the key
			missingEntry.add(baseFilename); // Add the base filename to the list of missing entries
			// Iterate over the DoneFileEntry list to check if the file exists
			for (DoneFileEntry element : dotFiles) {
				if (baseFilename.equals(element.getFilename())) {
					count++; // Increment count if the filename matches
					missingEntry.remove(element.getFilename()); // Remove the found filename from the missing entries
				}
			}
		}
		// If count matches the size of doneFileEntries, all entries are present
		if (count == sizeDoneFileEntry) {
			return true;
		} else {
			// If some entries are missing, throw an exception
			throw new IOException("ERROR - The following files specified in " + doneFile.getFileName()
					+ " have not been found: " + missingEntry + "Count: " + count);
		}
	}

	/**
	 * Returns the current UTC timestamp.
	 * 
	 * @return A Timestamp object representing the current UTC time.
	 */
	public Timestamp nowUtcTimestamp() {
		return Timestamp.from(Instant.now()); // Use Instant to get the current UTC timestamp
	}

	/**
	 * Processes an input string by splitting it into rows and columns based on
	 * newlines and pipe (|) delimiters.
	 * 
	 * @param inputString - The input string to be processed.
	 * @return A 2D array where each row is an array of strings representing
	 *         columns.
	 */
	public String[][] processInputString(String inputString) {
		// Split the input string into rows based on newlines
		String[] rows = inputString.split("\n");
		String[][] result = new String[rows.length][]; // Initialize a 2D array to hold the result

		// Split each row into columns based on the pipe (|) delimiter, including empty
		// cells
		for (int i = 0; i < rows.length; i++) {
			result[i] = rows[i].split("\\|", -1); // The flag -1 preserves empty cells
		}

		return result; // Return the processed 2D array
	}

	public boolean isRes(String value) {
		return value.equalsIgnoreCase("Res");
	}

	/**
	 * Gets the number of records for a given filename from the DoneFileEntry list.
	 * 
	 * @param filename - The filename to search for.
	 * @param dotFiles - The list of DoneFileEntry objects.
	 * @return The number of records for the given filename, or -1 if the file is
	 *         not found.
	 */
	public int getRecordsByFilename(String filename, ArrayList<DoneFileEntry> dotFiles) {
		// Iterate over the DoneFileEntry list to find the matching filename
		for (DoneFileEntry entry : dotFiles) {
			if (entry.getFilename().equals(filename)) {
				return entry.getRecords(); // Return the number of records for the matching filename
			}
		}
		// If the filename is not found, return -1
		return -1; // Or throw an exception if appropriate
	}

	/**
	 * Loads the SQL query from a file.
	 * 
	 * @param filePath - The path to the SQL file
	 * @return The content of the SQL file as a string
	 * @throws IOException - If an error occurs while reading the file
	 */
	public String loadSqlFromFile(String filePath) throws IOException {
		// Reads the entire content of the SQL file
		return new String(Files.readAllBytes(Paths.get(filePath)));
	}

	public ArrayList<DoneFileEntry> loadParentModels(ArrayList<DoneFileEntry> doneFileEntryList) {
		ArrayList<DoneFileEntry> parentModels = new ArrayList<>();
		for (DoneFileEntry key : doneFileEntryList) {
			if (key.getFilename().equals("Res")) {
				parentModels.add(key);
			} else if (key.getFilename().equals("TktDocument")) {
				parentModels.add(key);
			}
		}
		return parentModels;
	}

	public static List<Object> removeDuplicatesPNR(List<Object> records, String baseFilename) throws Exception {
		String className = "com.kmmaltairlines.hip.tdbingester.filepojos." + baseFilename;

		// Carica la classe dinamicamente
		Class<?> flightClass = Class.forName(className); // Es: "Res" o altre classi

		// Ottieni i metodi "get" dinamicamente per PNRLocatorID, PNRCreateDate,
		// FromDateTime
		Method getPNRLocatorID = flightClass.getMethod("getPNRLocatorID");
		Method getPNRCreateDate = flightClass.getMethod("getPNRCreateDate");
		Method getFromDateTime = flightClass.getMethod("getFromDateTime");

		// Utilizza un Set per tenere traccia dei record unici (con un identificatore
		// combinato)
		Set<String> seenIdentifiers = new HashSet<>();

		// Filtra i duplicati
		List<Object> uniqueRecords = new ArrayList<>();
		for (Object record : records) {
			try {
				// Ottieni i valori per ogni record
				Object locatorID = getPNRLocatorID.invoke(record);
				Object createDate = getPNRCreateDate.invoke(record);
				Object fromDateTime = getFromDateTime.invoke(record);

				// Crea un identificatore unico combinato
				String identifier = locatorID.toString() + createDate.toString() + fromDateTime.toString();

				// Se l'identificatore è già stato visto, ignora il record
				if (!seenIdentifiers.contains(identifier)) {
					seenIdentifiers.add(identifier); // Aggiungi l'identificatore per il futuro controllo
					uniqueRecords.add(record); // Aggiungi il record alla lista di record unici
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return uniqueRecords; // Restituisce la lista senza duplicati
	}
	
	public static List<Object> removeDuplicatesVCR(List<Object> records, String baseFilename) throws Exception {
		String className = "com.kmmaltairlines.hip.tdbingester.filepojos." + baseFilename;

		// Carica la classe dinamicamente
		Class<?> flightClass = Class.forName(className); // Es: "Res" o altre classi

		// Ottieni i metodi "get" dinamicamente per PNRLocatorID, PNRCreateDate,
		// FromDateTime
		Method getPrimaryDocNbr = flightClass.getMethod("getPrimaryDocNbr");
		Method getVCRCreateDate = flightClass.getMethod("getVCRCreateDate");
		Method getTransactionDateTime = flightClass.getMethod("getTransactionDateTime");

		// Utilizza un Set per tenere traccia dei record unici (con un identificatore
		// combinato)
		Set<String> seenIdentifiers = new HashSet<>();

		// Filtra i duplicati
		List<Object> uniqueRecords = new ArrayList<>();
		for (Object record : records) {
			try {
				// Ottieni i valori per ogni record
				Object PrimaryDocNbr = getPrimaryDocNbr.invoke(record);
				Object VCRCreateDate = getVCRCreateDate.invoke(record);
				Object TransactionDateTime = getTransactionDateTime.invoke(record);

				// Crea un identificatore unico combinato
				String identifier = PrimaryDocNbr.toString() + VCRCreateDate.toString() + TransactionDateTime.toString();

				// Se l'identificatore è già stato visto, ignora il record
				if (!seenIdentifiers.contains(identifier)) {
					seenIdentifiers.add(identifier); // Aggiungi l'identificatore per il futuro controllo
					uniqueRecords.add(record); // Aggiungi il record alla lista di record unici
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return uniqueRecords; // Restituisce la lista senza duplicati
	}

	public Map<String, Map<Date, List<Map<String, Object>>>> groupData(
			Map<String, Map<Date, List<Map<String, Object>>>> originalData) {
		Map<String, Map<Date, List<Map<String, Object>>>> grouped = new HashMap<>();

		for (Map.Entry<String, Map<Date, List<Map<String, Object>>>> entry : originalData.entrySet()) {
			String locatorId = entry.getKey(); // PNRLocatorID

			// All'interno del locatorId, raggruppiamo per PNRCreateDate
			Map<Date, List<Map<String, Object>>> createDateGroup = entry.getValue();

			// Se non esiste già una mappa per questo locatorId, creiamo una nuova
			if (!grouped.containsKey(locatorId)) {
				grouped.put(locatorId, new HashMap<>());
			}

			// Per ogni PNRCreateDate, aggiungiamo i dati al gruppo
			for (Map.Entry<Date, List<Map<String, Object>>> dateEntry : createDateGroup.entrySet()) {
				Date createDate = dateEntry.getKey(); // PNRCreateDate
				List<Map<String, Object>> records = dateEntry.getValue();

				// Aggiungiamo i dati a questa data, creando una lista se non esiste già
				Map<Date, List<Map<String, Object>>> locatorData = grouped.get(locatorId);
				if (!locatorData.containsKey(createDate)) {
					locatorData.put(createDate, new ArrayList<>());
				}
				locatorData.get(createDate).addAll(records);
			}
		}
		return grouped;
	}

	public static List<Object> filterRecordsPNR(List<Object> flights,
			Map<String, Map<Date, List<Map<String, Object>>>> recordsToKeep) {
		List<Object> filteredFlights = new ArrayList<>();

		// Log l'inizio del processo
		logger.info("Start filtering records");

		// Iterating over the flights list
		for (Object flight : flights) {
			try {

				// Assuming each flight is a PNRRecord or its subclass
				if (flight instanceof PNRRecord) {
					PNRRecord record = (PNRRecord) flight;
					String pnrLocatorID = record.getPNRLocatorID();
					Date pnrCreateDate = record.getPNRCreateDate();

					// Check if this PNRRecord exists in recordsToKeep
					Map<Date, List<Map<String, Object>>> recordsForLocator = recordsToKeep.get(pnrLocatorID);
					if (recordsForLocator != null) {
						List<Map<String, Object>> recordsForDate = recordsForLocator.get(pnrCreateDate);
						if (recordsForDate != null) {
							// If there is a match, keep this flight record
							filteredFlights.add(flight);
						} 
					} 
				}
			} catch (Exception e) {
				// Log dell'errore
				logger.error("Error processing flight record: " + flight + ", Error: " + e.getMessage());
				e.printStackTrace();
			}
		}

		// Log quando il filtraggio è completato
		logger.info("Filtering completed. " + filteredFlights.size() + " records matched.");

		return filteredFlights; // Return the filtered list of flights
	}
	
	public static List<Object> filterRecordsVCR(List<Object> flights,
			Map<String, Map<Date, List<Map<String, Object>>>> recordsToKeep) {
		List<Object> filteredFlights = new ArrayList<>();

		// Log l'inizio del processo
		logger.info("Start filtering records");

		// Iterating over the flights list
		for (Object flight : flights) {
			try {

				// Assuming each flight is a PNRRecord or its subclass
				if (flight instanceof VCRRecord) {
					VCRRecord record = (VCRRecord) flight;
					String PrimaryDocNbr = record.getPrimaryDocNbr();
					Date VCRCreateDate = record.getVCRCreateDate();

					// Check if this PNRRecord exists in recordsToKeep
					Map<Date, List<Map<String, Object>>> recordsForLocator = recordsToKeep.get(PrimaryDocNbr);
					if (recordsForLocator != null) {
						List<Map<String, Object>> recordsForDate = recordsForLocator.get(VCRCreateDate);
						if (recordsForDate != null) {
							// If there is a match, keep this flight record
							filteredFlights.add(flight);
						} 
					} 
				}
			} catch (Exception e) {
				// Log dell'errore
				logger.error("Error processing flight record: " + flight + ", Error: " + e.getMessage());
				e.printStackTrace();
			}
		}

		// Log quando il filtraggio è completato
		logger.info("Filtering completed. " + filteredFlights.size() + " records matched.");

		return filteredFlights; // Return the filtered list of flights
	}
}
