package com.kmmaltairlines.hip.tdbingester.poc_tdb;

import java.sql.Timestamp;

import com.kmmaltairlines.hip.tdbingester.maintenance.TDB_Maintenance;

public class TDBMaintenanceProcessor {

	/**
	 * This method creates a new TDB_Maintenance object with the provided details.
	 * It sets various fields such as the run ID, file name, number of records,
	 * success flag, and timestamps for when the process started and ended.
	 * 
	 * @param run_id                    - The ID for the current run or process
	 * @param baseFilename              - The name of the file being processed
	 * @param doneFileEntryValue        - The value of the file entry after the
	 *                                  process is done
	 * @param currentIterationStartTime - The timestamp when the current iteration
	 *                                  started
	 * @param numRecords                - The number of records processed
	 * @param isExceptionThrown         - A flag indicating if an exception was
	 *                                  thrown during processing
	 * @return TDB_Maintenance - A populated TDB_Maintenance object
	 */
	@SuppressWarnings("static-access")
	public TDB_Maintenance createTDBMaintenance(String run_id, String baseFilename, String doneFileEntryValue,
			Timestamp currentIterationStartTime, Integer numRecords, boolean isExceptionThrown) {

		// Create a new instance of TDB_Maintenance
		TDB_Maintenance tdbMaintenance = new TDB_Maintenance();
		Utility utility = new Utility();

		// Set the run ID for the maintenance record
		tdbMaintenance.setRunId(run_id);

		// Set the file name being processed
		tdbMaintenance.setFileName(baseFilename);

		// Set the number of records processed
		tdbMaintenance.setNumRecords(numRecords);

		// Set the success status based on whether an exception was thrown
		tdbMaintenance.setSuccess(isExceptionThrown);

		// Set the entry value of the processed file
		tdbMaintenance.setEncFileName(doneFileEntryValue);

		// Set the timestamp for when the iteration started
		tdbMaintenance.setDateStarted(currentIterationStartTime);

		// Generate and set the timestamp for when the iteration ended
		Timestamp dateEnded = utility.nowUtcTimestamp();
		tdbMaintenance.setDateEnded(dateEnded);

		// Return the populated TDB_Maintenance object
		return tdbMaintenance;
	}
}
