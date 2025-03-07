package com.kmmaltairlines.hip.tdbingester.poc_tdb;

import java.util.ArrayList;
import java.util.Iterator;

import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFileEntry;

public class PreprocessTdbBatchSubflow {

    // Static list to hold parent models (Res and TktDocument files)
	static ArrayList<DoneFileEntry> parentModels = new ArrayList<>();

    // Method to set the parent models based on the filenames (Res and TktDocument)
	public static void setParentModel(ArrayList<DoneFileEntry> doneFileEntryList) {
        // Iterate through the done file entries
		for (DoneFileEntry entry : doneFileEntryList) {
            // Check if the filename is "Res" and add it to the parentModels list
			if (entry.getFilename().equals("Res")) {
				parentModels.add(entry);
            // Check if the filename is "TktDocument" and add it to the parentModels list
			} else if (entry.getFilename().equals("TktDocument")) {
				parentModels.add(entry);
			}
		}
        // Print out the parent models for debugging or verification
		System.out.println(parentModels);
	}

    // Method to process "Res" entries (to be implemented in the future)
	public static void processRes(ArrayList<DoneFileEntry> parentModels) {
		// TODO: Implement logic for processing "Res" entries
		// You could call a private method to handle each entry or flow.
	}

    // Method to process "TktDocument" entries (to be implemented in the future)
	public static void processTktDocument(ArrayList<DoneFileEntry> parentModels) {
		// TODO: Implement logic for processing "TktDocument" entries
		// You could call a private method to handle each entry or flow.
	}

    // Main processing method to process the done file entry list
	public ArrayList<DoneFileEntry> process(ArrayList<DoneFileEntry> doneFileEntryList) {
        // Set the parent models (Res and TktDocument) from the done file entries
		setParentModel(doneFileEntryList);
        // Process the "Res" files
		processRes(parentModels);
        // Process the "TktDocument" files
		processTktDocument(parentModels);
        
        // Create an iterator to remove "Res" and "TktDocument" files from the original list
		Iterator<DoneFileEntry> iterator = doneFileEntryList.iterator();
		while (iterator.hasNext()) {
			DoneFileEntry entry = iterator.next();
            // If the entry is "Res" or "TktDocument", remove it from the list
			if (entry.getFilename().equals("Res") || entry.getFilename().equals("TktDocument")) {
				iterator.remove();
			}
		}
        // Return the processed list without the "Res" and "TktDocument" entries
		return doneFileEntryList;
	}
}
