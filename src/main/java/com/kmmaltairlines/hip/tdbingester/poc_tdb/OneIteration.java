package com.kmmaltairlines.hip.tdbingester.poc_tdb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mule.weave.v2.grammar.Variables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFileEntry;
import com.kmmaltairlines.hip.tdbingester.maintenance.TDB_Maintenance;
import com.kmmaltairlines.hip.tdbingester.sql.TDB_MaintenanceSql;
import com.kmmaltairlines.mail.EmailRequest;
import com.kmmaltairlines.mail.MailService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

@Component
public class OneIteration {
	
	@Autowired
	private LoadDatFileIntoPojo loadFile;

	@Autowired
	private TDB_MaintenanceSql tdbSql;

	
    // Logger for this class to log messages
    private static final Logger logger = LogManager.getLogger(OneIteration.class);

    /**
     * This method processes each entry in the done file and performs the necessary operations.
     * @param doneFileName - the list of entries in the done file.
     * @param doneFileContent - the specific entry value from the done file.
     * @param run_id - unique run identifier for the current execution.
     * @param doneFileEntryListA - the list of `DoneFileEntry` objects.
     * @param encFileName - the name of the encrypted file being processed.
     * @return String - returns the result of the operation (as a string representation of the TDB_Maintenance object).
     * @throws SQLException 
     * @throws IOException 
     */
	public ArrayList<TDB_Maintenance> processDoneFiles(String doneFileName, String doneFileContent, UUID run_id, ArrayList<DoneFileEntry> doneFileEntry, String encFileName,Connection connection,ArrayList<TDB_Maintenance> report) throws IOException, SQLException {
        // Create a utility object for timestamp and other utility methods
        Utility utility = new Utility();
        TDB_Maintenance tdbMaintenance = new TDB_Maintenance();
        // Get the start time of this iteration
        Timestamp currentIterationStartTime = utility.nowUtcTimestamp();
        
        // Extract base filename and the actual file name (without ".dat")
        String[] parts = doneFileName.split("_");
        String baseFilename;
    	if (parts.length < 3) {
    		baseFilename=parts[0];
    		
        } else{
        	baseFilename=parts[0] + "_" + parts[1]; 
        }
        String fileName = doneFileName.split(".dat")[0];
        
        // Flag to check if an exception occurs during the processing
        boolean isExceptionThrown = false;
        
        // Call the method to load the .dat file and process it
        isExceptionThrown = loadFile.loadDatFile(baseFilename, doneFileContent, doneFileEntry,connection,encFileName);

        // If no exception is thrown, populate the TDB_Maintenance object with success data
        if (isExceptionThrown == false) {
            tdbMaintenance.setRunId(run_id.toString());
            tdbMaintenance.setFileName(fileName);
            tdbMaintenance.setNumRecords(utility.getRecordsByFilename(baseFilename, doneFileEntry));  // Get number of records for the file
            tdbMaintenance.setSuccess(isExceptionThrown);  // Set success flag to false since no error occurred
            tdbMaintenance.setEncFileName(encFileName);  // Set the encrypted file name
            tdbMaintenance.setDateEnded(utility.nowUtcTimestamp());  // Set the end time of the operation
            tdbMaintenance.setDateStarted(currentIterationStartTime);  // Set the start time of the operation
            report.add(tdbMaintenance);
        } else {
            // If an exception was thrown, log the failure data in TDB_Maintenance object
            tdbMaintenance.setRunId(run_id.toString());
            tdbMaintenance.setFileName(fileName);
            tdbMaintenance.setNumRecords(utility.getRecordsByFilename(baseFilename, doneFileEntry));  // Get number of records for the file
            tdbMaintenance.setSuccess(isExceptionThrown);  // Set success flag to true since an exception occurred
            tdbMaintenance.setEncFileName(encFileName);  // Set the encrypted file name
            tdbMaintenance.setDateEnded(utility.nowUtcTimestamp());  // Set the end time of the operation
            tdbMaintenance.setDateStarted(currentIterationStartTime);  // Set the start time of the operation
            report.add(tdbMaintenance);
        }

        // Print the TDB_Maintenance object to the console for debugging/verification purposes
        logger.info("EXECUTION DETAILS------->" + tdbMaintenance.toString());
        
        
        
        tdbSql.insert(tdbMaintenance,connection);
        
       
        return report;
    }
}
