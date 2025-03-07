package com.kmmaltairlines.hip.tdbingester.poc_tdb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Timestamp;
import java.time.Instant;

import org.springframework.stereotype.Component;

import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFile;
import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFileEntry;

@Component
public class Utility {

    /**
     * Reads the content of a file and returns it as a list of strings, where each string represents one line of the file.
     * @param file - The file to be read.
     * @return An ArrayList of strings where each element is a line from the file.
     */
    public static ArrayList<String> readFile(File file) {
        ArrayList<String> list = new ArrayList<String>();  // List to hold lines of the file
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {  // BufferedReader to read the file line by line
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);  // Add each line to the list
            }
            reader.close();
            return list;  // Return the list of lines
        } catch (IOException e) {
            e.printStackTrace();  // Print the stack trace if an error occurs
        }
        return null;  // Return null if the file can't be read
    }

    /**
     * Moves a file from its original path to a new destination.
     * @param originalPath - The path where the original file is located.
     * @param destinationPath - The new destination where the file should be moved.
     * @throws IOException - If an I/O error occurs during the file move operation.
     */
    public static void moveFile(File originalPath, String destinationPath) throws IOException {
        File destination = new File(destinationPath + originalPath.getName());  // Create a new file object for the destination
        Files.move(originalPath.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);  // Move the file to the new destination
    }

    /**
     * Reads a GPG file and returns its InputStream.
     * @param string - The file path of the GPG file.
     * @return InputStream - The InputStream for the GPG file.
     * @throws FileNotFoundException - If the GPG file is not found.
     */
    public static InputStream readGpg(String string) throws FileNotFoundException {
       BufferedReader br = new BufferedReader(new FileReader(string));  // BufferedReader to read the file
        return null;  // Currently, this method is incomplete and returns null
    }

    /**
     * Creates a list of DoneFileEntry objects from an array of strings.
     * @param arrayString - An ArrayList of strings where each string is in the format "key=value".
     * @return An ArrayList of DoneFileEntry objects created from the strings.
     */
    public static ArrayList<DoneFileEntry> createDoneFileEntry(ArrayList<String> arrayString) {
        ArrayList<DoneFileEntry> doneFileEntryList = new ArrayList<>();
        for (String element : arrayString) {
            if (element.contains("=")) {  // Only process elements that contain an equal sign
                String[] prova = element.split("=");  // Split the string into key and value
                DoneFileEntry donefileentry = new DoneFileEntry(prova[0], Integer.parseInt(prova[1]));  // Create a new DoneFileEntry
                doneFileEntryList.add(donefileentry);  // Add it to the list
            }
        }
        return doneFileEntryList;  // Return the list of DoneFileEntry objects
    }

    /**
     * Creates a DoneFile object from a file name, a list of strings representing the file contents, 
     * and a list of DoneFileEntry objects.
     * @param fileName - The name of the file.
     * @param readedFile - The contents of the file as a list of strings.
     * @param doneFileEntryList - The list of DoneFileEntry objects.
     * @return A DoneFile object populated with the provided data.
     */
    public static DoneFile createDoneFile(String fileName, ArrayList<String> readedFile,
                                          ArrayList<DoneFileEntry> doneFileEntryList) {
        DoneFile doneFile = new DoneFile();
        doneFile.setFileName(fileName);  // Set the file name
        doneFile.setNumberOfBytes(Integer.parseInt(readedFile.get(0)));  // Set the number of bytes (from the first element of readedFile)
        doneFile.setFileEntries(doneFileEntryList);  // Set the list of DoneFileEntry objects
        return doneFile;  // Return the populated DoneFile object
    }

    /**
     * Compares the file entries in the provided DoneFileEntry list and the DoneFileEntries in the HashMap.
     * Throws an exception if any expected file entries are missing.
     * @param dotFiles - The list of DoneFileEntry objects.
     * @param doneFileEntries - A HashMap of done file entries where keys are filenames and values are corresponding values.
     * @param doneFile - The DoneFile object that contains the expected file entries.
     * @return A boolean indicating whether all file entries are present.
     * @throws Exception If any file entries are missing, an exception is thrown.
     */
    public static boolean compareFileEntries(ArrayList<DoneFileEntry> dotFiles, HashMap<String, String> doneFileEntries,
                                              DoneFile doneFile) throws Exception {
    	String baseFilename;
        int count = 0;
        int sizeDoneFileEntry = doneFileEntries.size();
        ArrayList<String> missingEntry = new ArrayList<>();
        // Iterate over the entries in doneFileEntries
        for (String key : doneFileEntries.keySet()) {
        	String[] parts = key.split("_");
        	if (parts.length < 3) {
        		baseFilename=parts[0];
        		
            } else{
            	baseFilename=parts[0] + "_" + parts[1]; // Se non ci sono underscore, restituiamo l'intero nome
            }
            //String baseFilename = key.substring(0, underscoreIndex);  // Extract the base filename from the key
            missingEntry.add(baseFilename);  // Add the base filename to the list of missing entries
            // Iterate over the DoneFileEntry list to check if the file exists
            for (DoneFileEntry element : dotFiles) {
                if (baseFilename.equals(element.getFilename())) {
                    count++;  // Increment count if the filename matches
                    missingEntry.remove(element.getFilename());  // Remove the found filename from the missing entries
                }
            }
        }
        // If count matches the size of doneFileEntries, all entries are present
        if (count == sizeDoneFileEntry) {
            return true;
        } else {
            // If some entries are missing, throw an exception
            throw new IOException("ERROR - The following files specified in " + doneFile.getFileName()
                    + " have not been found: " + missingEntry+"Count: "+count);
        }
    }

    /**
     * Returns the current UTC timestamp.
     * @return A Timestamp object representing the current UTC time.
     */
    public static Timestamp nowUtcTimestamp() {
        return Timestamp.from(Instant.now());  // Use Instant to get the current UTC timestamp
    }

    /**
     * Processes an input string by splitting it into rows and columns based on newlines and pipe (|) delimiters.
     * @param inputString - The input string to be processed.
     * @return A 2D array where each row is an array of strings representing columns.
     */
    public static String[][] processInputString(String inputString) {
        // Split the input string into rows based on newlines
        String[] rows = inputString.split("\n");
        String[][] result = new String[rows.length][];  // Initialize a 2D array to hold the result

        // Split each row into columns based on the pipe (|) delimiter, including empty cells
        for (int i = 0; i < rows.length; i++) {
            result[i] = rows[i].split("\\|", -1);  // The flag -1 preserves empty cells
        }

        return result;  // Return the processed 2D array
    }

    /**
     * Gets the number of records for a given filename from the DoneFileEntry list.
     * @param filename - The filename to search for.
     * @param dotFiles - The list of DoneFileEntry objects.
     * @return The number of records for the given filename, or -1 if the file is not found.
     */
    public int getRecordsByFilename(String filename, ArrayList<DoneFileEntry> dotFiles) {
        // Iterate over the DoneFileEntry list to find the matching filename
        for (DoneFileEntry entry : dotFiles) {
            if (entry.getFilename().equals(filename)) {
                return entry.getRecords();  // Return the number of records for the matching filename
            }
        }
        // If the filename is not found, return -1
        return -1;  // Or throw an exception if appropriate
    }
    
	/**
	 * Loads the SQL query from a file.
	 * 
	 * @param filePath - The path to the SQL file
	 * @return The content of the SQL file as a string
	 * @throws IOException - If an error occurs while reading the file
	 */
	public static String loadSqlFromFile(String filePath) throws IOException {
		// Reads the entire content of the SQL file
		return new String(Files.readAllBytes(Paths.get(filePath)));
	}

}
