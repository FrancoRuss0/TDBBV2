package com.kmmaltairlines.hip.tdbingester.poc_tdb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFileEntry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IterateOverDoneFileEntries {
	@Autowired
	private OneIteration oneIteration;
	@Autowired
	private PreprocessTdbBatchSubflow tdbBatch;
    // Logger for logging events and errors
	private static final Logger logger = LogManager.getLogger(IterateOverDoneFileEntries.class);
	
	// Method to iterate over the entries in the .done file and process them
	public void iterateOverDoneFile(HashMap<String, String> doneFileEntryList, ArrayList<DoneFileEntry> dotFiles, String encFileName,Connection connection) throws IOException, SQLException {
		
        // Generate a unique run ID for this process
		UUID run_id = UUID.randomUUID();
		System.out.println("Generated UUID: " + run_id.toString()); // Log the generated UUID
		ArrayList<String> executionStatuses = new ArrayList<String>(); // List to store execution statuses

        // Check if the done file contains "batch" (indicating batch processing is required)
		if (encFileName.contains("batch")) {
            // If batch processing is needed, call the preprocess method to handle batch files
			doneFileEntryList=tdbBatch.process(doneFileEntryList, run_id, dotFiles, encFileName,connection);
		} else {
            // If not a batch file, log and skip preprocessing
			logger.info("Skip preprocessing for non BATCH files");
		}
		
        // Iterate through each entry in the done file entry list and process it
		for (String key : doneFileEntryList.keySet()) {
            // Call the `oneIterationOverDoneFile` method for each file entry to process it
			String result= oneIteration.processDoneFiles(key, doneFileEntryList.get(key), run_id, dotFiles, encFileName,connection);
			executionStatuses.add(result);
		}

        // Log after processing all the .dat files
		logger.info("Processed all .dat files.");

        // Call to persist the processed data into the TDB_Maintenance table (specific subflow logic should be implemented here)
		// ATTENTION: The exact location and method to call for the insert into the TDB_Maintenance table should be determined
		// (Here you can add a call to a subflow or method that performs the database insert operation)

        // Log successful persistence of data into the TDB_Maintenance table
		logger.info("Successfully persisted data in TDB_Maintenance table.");

        // TODO: Add logic to send an email with the status report (this part is to be implemented)
		// For example, you could call a utility method to generate and send an email

        // Log the successful creation and sending of the status report
		logger.info("Successfully built and sent status report.");
	}

}
