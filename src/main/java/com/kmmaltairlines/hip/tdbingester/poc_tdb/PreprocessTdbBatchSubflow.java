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

@Component
public class PreprocessTdbBatchSubflow {

	@Autowired
	private Utility utility;

	@Autowired
	private OneIteration oneIteration;

	@Autowired
	private ResSql resSql;
	
	@Autowired
	private TktDocumentSql tktDocumentSql;

	// Static list to hold parent models (Res and TktDocument files)
	static ArrayList<DoneFileEntry> parentModels = new ArrayList<>();

	// Main processing method to process the done file entry list
	public HashMap<String, String> process(HashMap<String, String> doneFileEntryList, UUID run_id,
			ArrayList<DoneFileEntry> dotFiles, String encFileName, Connection connection, ArrayList<TDB_Maintenance> report)
			throws IOException, SQLException {

		parentModels = utility.loadParentModels(dotFiles);

		// TODO Clear temporary tables
		resSql.deleteTemp(connection);
		// Stampa tutte le chiavi della mappa
		tktDocumentSql.deleteTemp(connection);
		
		Iterator<String> iterator = doneFileEntryList.keySet().iterator();
		while (iterator.hasNext()) {
		    String key = iterator.next();
		    String baseFilename = key.split("_")[0];
		    if (baseFilename.equals("Res")) {
		        oneIteration.processDoneFiles(baseFilename, doneFileEntryList.get(key), run_id,
		                dotFiles, encFileName, connection,report);
		        
		        // Rimuovere il file dalla doneFileEntryList dopo il processamento
		        iterator.remove();  // Rimuove in modo sicuro l'elemento corrente
		    }
		    if (baseFilename.equals("TktDocument")) {
		        oneIteration.processDoneFiles(baseFilename, doneFileEntryList.get(key), run_id,
		                dotFiles, encFileName, connection,report);
		        
		        // Rimuovere il file dalla doneFileEntryList dopo il processamento
		        iterator.remove();  // Rimuove in modo sicuro l'elemento corrente
		    }
		}
		return doneFileEntryList;
	}
}
