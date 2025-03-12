package com.kmmaltairlines.hip.tdbingester.poc_tdb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFileEntry;
import com.kmmaltairlines.hip.tdbingester.sql.ResSql;

@Component
public class PreprocessTdbBatchSubflow {

	@Autowired
	private Utility utility;

	@Autowired
	private OneIteration oneIteration;

	@Autowired
	private ResSql resSql;

	// Static list to hold parent models (Res and TktDocument files)
	static ArrayList<DoneFileEntry> parentModels = new ArrayList<>();

	// Main processing method to process the done file entry list
	public HashMap<String, String> process(HashMap<String, String> doneFileEntryList, UUID run_id,
			ArrayList<DoneFileEntry> dotFiles, String encFileName, Connection connection)
			throws IOException, SQLException {

		HashMap<String, String> doneFileModified = new HashMap<>();

		parentModels = utility.loadParentModels(dotFiles);

		// TODO Clear temporary tables
		resSql.deleteTemp(connection);
		// Stampa tutte le chiavi della mappa
		
		
		for (String key : doneFileEntryList.keySet()) {
			String baseFilename = key.split("_")[0];
			if (baseFilename.equals("Res")) {
				String result = oneIteration.processDoneFiles(baseFilename, doneFileEntryList.get(key), run_id,
						dotFiles, encFileName, connection);
			}
			
		}

		for (String key : doneFileEntryList.keySet()) {
		    // Verifica che la chiave non sia "Res" e che non contenga "TktDocument"
		    if (!key.equals("Res") && !key.equals("TktDocument")) {
		        doneFileModified.put(key, doneFileEntryList.get(key));  
		    }
		}

	

		// System.out.println(doneFileModified);
		// System.exit(0);
		return doneFileModified;
	}
}
