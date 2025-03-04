package poc_tdb;

import java.util.ArrayList;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFileEntry;
import com.kmmaltairlines.hip.tdbingester.maintenance.TDB_Maintenance;

import java.sql.Timestamp;

public class oneIteration {
	
	private static final Logger logger = LogManager.getLogger(oneIteration.class);
	
	static public String OneIterationOverDoneFile(String doneFileEntryList, String doneFileEntryValue,UUID run_id, ArrayList<DoneFileEntry> doneFileEntryListA,String encFileName) {
		Utility utility = new Utility();
		Timestamp currentIterationStartTime = utility.nowUtcTimestamp();
		String baseFilename = doneFileEntryList.split("_")[0];
		String FileName= doneFileEntryList.split(".dat")[0];
		boolean isExceptionThrown = false;
		TDB_Maintenance TDB_Maintenance= new TDB_Maintenance();

		loadDatFileIntoPojo LoadFile = new loadDatFileIntoPojo();

		isExceptionThrown = LoadFile.LoadDatFile(baseFilename, doneFileEntryValue,doneFileEntryListA);

		if (isExceptionThrown == false) {
			TDB_Maintenance.setRunId(run_id.toString());
			TDB_Maintenance.setFileName(FileName);
			TDB_Maintenance.setNumRecords(utility.getRecordsByFilename(baseFilename, doneFileEntryListA));
			TDB_Maintenance.setSuccess(isExceptionThrown);
			TDB_Maintenance.setEncFileName(encFileName);
			TDB_Maintenance.setDateEnded(utility.nowUtcTimestamp());
			TDB_Maintenance.setDateStarted(currentIterationStartTime);
		} else {
			TDB_Maintenance.setRunId(run_id.toString());
			TDB_Maintenance.setFileName(FileName);
			TDB_Maintenance.setNumRecords(utility.getRecordsByFilename(baseFilename, doneFileEntryListA));
			TDB_Maintenance.setSuccess(isExceptionThrown);
			TDB_Maintenance.setEncFileName(encFileName);
			TDB_Maintenance.setDateEnded(utility.nowUtcTimestamp());
			TDB_Maintenance.setDateStarted(currentIterationStartTime);
			
			
		}
		System.out.println("SONO IL EXECUTION------->"+TDB_Maintenance.toString());
		
		return TDB_Maintenance.toString();
	}

}
