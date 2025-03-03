package poc_tdb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import com.airmalta.hip.tdbingester.filepojos.DoneFileEntry;

public class IterateOverDoneFileEntriesToPopulateAndPersistFilePojos {
	
	static public void IterateOverDoneFileEntriesToPopulateAndPersistFilePojos(HashMap<String, String> doneFileEntryList,ArrayList<DoneFileEntry> doneFileEntryListA) {
		 UUID run_id = UUID.randomUUID();
		 System.out.println("Generated UUID: " + run_id.toString());
		 String executionStatuses;
		 OneIterationOverDoneFileEntryPrivateflow a= new OneIterationOverDoneFileEntryPrivateflow();
		 PreprocessTdbBatchSubflow b= new PreprocessTdbBatchSubflow();
		 HashMap<String, String> doneFileEntry;
		 
		 if(doneFileEntryList.toString().toLowerCase().contains("batch")) {
			 b.PreprocessTdbBatchSubflow();
		 }else {
			 System.out.println("Skip preprocessing for non BATCH files");
		 }
		 
		 for (String key : doneFileEntryList.keySet()) {
			    a.OneIterationOverDoneFileEntryPrivateflow(key, doneFileEntryList.get(key),run_id,doneFileEntryListA);
		}
		 
		 executionStatuses="prova";
		 System.out.println("Processed all .dat files.");
		 
		 //richiamo al metodo per il insert-into-TDB-Maintenance-table-subflow  ATTENZIONE
		 //DOVE SCRIVERE IL RICHIAMO AL METODO
		 
		 System.out.println("Successfully persisted data in TDB_Maintenance table.");
		 
		 //richiamo al metodo per il build-and-send-status-report-subflow
		//DOVE SCRIVERE IL RICHIAMO AL METODO
		 
		 System.out.println("Successfully built and sent status report.");
	}
	
}
