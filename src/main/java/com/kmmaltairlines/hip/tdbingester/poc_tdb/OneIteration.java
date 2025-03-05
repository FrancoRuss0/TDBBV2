package com.kmmaltairlines.hip.tdbingester.poc_tdb;

import java.util.ArrayList;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFileEntry;
import com.kmmaltairlines.hip.tdbingester.maintenance.TDB_Maintenance;

import java.sql.Timestamp;

public class OneIteration {
	@Autowired
    private SqlProperty sqlProperty;
	public OneIteration(SqlProperty sqlProperty) {
		this.sqlProperty=sqlProperty;
	}
	private static final Logger logger = LogManager.getLogger(OneIteration.class);
	public String oneIterationOverDoneFile(String doneFileEntryList, String doneFileEntryValue,UUID run_id, ArrayList<DoneFileEntry> doneFileEntryListA,String encFileName) {
		Utility utility = new Utility();
		Timestamp currentIterationStartTime = utility.nowUtcTimestamp();
		String baseFilename = doneFileEntryList.split("_")[0];
		String fileName= doneFileEntryList.split(".dat")[0];
		boolean isExceptionThrown = false;
		TDB_Maintenance tdbMaintenance= new TDB_Maintenance();

		LoadDatFileIntoPojo LoadFile = new LoadDatFileIntoPojo(sqlProperty);

		isExceptionThrown = LoadFile.LoadDatFile(baseFilename, doneFileEntryValue,doneFileEntryListA);

		if (isExceptionThrown == false) {
			tdbMaintenance.setRunId(run_id.toString());
			tdbMaintenance.setFileName(fileName);
			tdbMaintenance.setNumRecords(utility.getRecordsByFilename(baseFilename, doneFileEntryListA));
			tdbMaintenance.setSuccess(isExceptionThrown);
			tdbMaintenance.setEncFileName(encFileName);
			tdbMaintenance.setDateEnded(utility.nowUtcTimestamp());
			tdbMaintenance.setDateStarted(currentIterationStartTime);
		} else {
			tdbMaintenance.setRunId(run_id.toString());
			tdbMaintenance.setFileName(fileName);
			tdbMaintenance.setNumRecords(utility.getRecordsByFilename(baseFilename, doneFileEntryListA));
			tdbMaintenance.setSuccess(isExceptionThrown);
			tdbMaintenance.setEncFileName(encFileName);
			tdbMaintenance.setDateEnded(utility.nowUtcTimestamp());
			tdbMaintenance.setDateStarted(currentIterationStartTime);
			
			
		}
		System.out.println("SONO IL EXECUTION------->"+tdbMaintenance.toString());
		
		return tdbMaintenance.toString();
	}

}
