package com.kmmaltairlines.hip.tdbingester.poc_tdb;

import java.sql.Timestamp;

import com.kmmaltairlines.hip.tdbingester.maintenance.TDB_Maintenance;

public class TDBMaintenanceProcessor {

	public TDB_Maintenance createTDBMaintenance(String run_id, String baseFilename, String doneFileEntryValue,
			Timestamp currentIterationStartTime, Integer numRecords, boolean isExceptionThrown) {

		TDB_Maintenance tdbMaintenance = new TDB_Maintenance();
		Utility utility = new Utility();

		tdbMaintenance.setRunId(run_id);
		tdbMaintenance.setFileName(baseFilename);
		tdbMaintenance.setNumRecords(numRecords);
		tdbMaintenance.setSuccess(isExceptionThrown);
		tdbMaintenance.setEncFileName(doneFileEntryValue);
		tdbMaintenance.setDateStarted(currentIterationStartTime);
		Timestamp dateEnded = utility.nowUtcTimestamp();
		tdbMaintenance.setDateEnded(dateEnded);

		return tdbMaintenance;
	}
}
