package poc_tdb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFileEntry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class iterateOverDoneFileEntries {
	private static final Logger logger = LogManager.getLogger(iterateOverDoneFileEntries.class);
	
	static public void iterateOverDoneFile(HashMap<String, String> doneFileEntryList, ArrayList<DoneFileEntry> doneFileEntryListA,String encFileName) {
		UUID run_id = UUID.randomUUID();
		System.out.println("Generated UUID: " + run_id.toString());
		ArrayList<String> executionStatuses = new ArrayList<String>();
		oneIteration OneIteration =  new oneIteration();
		PreprocessTdbBatchSubflow TdbBatch = new PreprocessTdbBatchSubflow();
		HashMap<String, String> doneFileEntry;
		
		if (doneFileEntryList.toString().toLowerCase().contains("batch")) {
			TdbBatch.process(doneFileEntryListA);
		} else {
			System.out.println("Skip preprocessing for non BATCH files");
			logger.info("Skip preprocessing for non BATCH files");
		}

		for (String key : doneFileEntryList.keySet()) {
			executionStatuses.add(OneIteration.OneIterationOverDoneFile(key, doneFileEntryList.get(key), run_id, doneFileEntryListA,encFileName));
		}

		System.out.println("Processed all .dat files.");
		logger.info("Processed all .dat files.");

		// richiamo al metodo per il insert-into-TDB-Maintenance-table-subflow
		// ATTENZIONE
		// DOVE SCRIVERE IL RICHIAMO AL METODO

		System.out.println("Successfully persisted data in TDB_Maintenance table.");
		logger.info("Successfully persisted data in TDB_Maintenance table.");

		//TODO invio email

		System.out.println("Successfully built and sent status report.");
		logger.info("Successfully built and sent status report.");
	}

}
