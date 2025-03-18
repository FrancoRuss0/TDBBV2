package com.kmmaltairlines.hip.tdbingester.poc_tdb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFileEntry;
import com.kmmaltairlines.hip.tdbingester.maintenance.TDB_Maintenance;
import com.kmmaltairlines.hip.tdbingester.sql.ResSql;
import com.kmmaltairlines.hip.tdbingester.sql.TktDocumentSql;

@Component // Marks this class as a Spring-managed component
public class PreprocessTdbBatchSubflow {

	// Autowired dependencies are injected automatically by Spring
	@Autowired
	private Utility utility; // Utility class for general utility functions
	@Autowired
	private OneIteration oneIteration; // Service to process individual file entries
	@Autowired
	private ResSql resSql; // SQL service for handling operations related to Res (reservation) data
	@Autowired
	private TktDocumentSql tktDocumentSql; // SQL service for handling operations related to TktDocument data

	// Static list to hold the parent models (Res and TktDocument files)
	static ArrayList<DoneFileEntry> parentModels = new ArrayList<>();

	// Main processing method to handle the done file entry list
	public HashMap<String, String> process(HashMap<String, String> doneFileEntryList, UUID run_id,
			ArrayList<DoneFileEntry> dotFiles, String encFileName, Connection connection,
			ArrayList<TDB_Maintenance> report) throws IOException, SQLException {

		// Load parent models (Res and TktDocument files) using a utility method
		parentModels = utility.loadParentModels(dotFiles);

		// TODO: Clear temporary tables before processing the data
		resSql.deleteTemp(connection); // Delete temporary data related to Res
		tktDocumentSql.deleteTemp(connection); // Delete temporary data related to TktDocument

		// Iterate over the done file entries to process each one
		Iterator<String> iterator = doneFileEntryList.keySet().iterator();
		while (iterator.hasNext()) {
			// Get the current entry key
			String key = iterator.next();
			// Extract the base filename (before the underscore)
			String baseFilename = key.split("_")[0];

			// If the base filename is of Res, process it using oneIteration
			if (utility.isRes(baseFilename)) {
				oneIteration.processDoneFiles(baseFilename, doneFileEntryList.get(key), run_id, dotFiles, encFileName,
						connection, report);

				// After processing, remove the file from the doneFileEntryList
				iterator.remove(); // Safely remove the current element from the list
			}

			// If the base filename is of TktDocument, process it similarly
			if (utility.isTktDocument(baseFilename)) {
				oneIteration.processDoneFiles(baseFilename, doneFileEntryList.get(key), run_id, dotFiles, encFileName,
						connection, report);

				// After processing, remove the file from the doneFileEntryList
				iterator.remove(); // Safely remove the current element from the list
			}
		}

		// Return the updated doneFileEntryList after processing
		return doneFileEntryList;
	}
}
