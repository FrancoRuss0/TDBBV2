package poc_tdb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import com.airmalta.hip.tdbingester.filepojos.DoneFileEntry;
import com.airmalta.hip.tdbingester.maintenance.TDB_Maintenance;

import java.sql.Timestamp;

public class OneIterationOverDoneFileEntryPrivateflow {

	static public void OneIterationOverDoneFileEntryPrivateflow(String doneFileEntryList, String doneFileEntryValue,UUID run_id,ArrayList<DoneFileEntry> doneFileEntryListA) {
		Utility utility = new Utility();
		Timestamp currentIterationStartTime = utility.nowUtcTimestamp();
		String baseFilename = doneFileEntryList.split("_")[0];
		boolean isExceptionThrown= false;

		LoadDatFileIntoPojoAndPersistPrivateflow a = new LoadDatFileIntoPojoAndPersistPrivateflow();
		
		isExceptionThrown=a.LoadDatFileIntoPojoAndPersistPrivateflow(baseFilename, doneFileEntryValue,doneFileEntryListA);
		 
		if(isExceptionThrown==false) {
			System.out.println("PROVA DEL FAlSE");
		}else {
	        //MESSAGE
		}
		
		//TODO Add TDB_Maintenance POJO to executionStatuses flowVars
	}
	
}
