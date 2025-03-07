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
    private SqlProperty sqlProperty;  // Injected SqlProperty object for DB configuration
    
    // Constructor for OneIteration class
    public OneIteration(SqlProperty sqlProperty) {
        this.sqlProperty = sqlProperty;
    }
    
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
     */
    @SuppressWarnings("static-access")
	public String processDoneFiles(String doneFileName, String doneFileContent, UUID run_id, ArrayList<DoneFileEntry> dotFiles, String encFileName) {
        
        // Create a utility object for timestamp and other utility methods
        Utility utility = new Utility();
        
        // Get the start time of this iteration
        Timestamp currentIterationStartTime = utility.nowUtcTimestamp();
        
        // Extract base filename and the actual file name (without ".dat")
        String baseFilename = doneFileName.split("_")[0];
        String fileName = doneFileName.split(".dat")[0];
        
        // Flag to check if an exception occurs during the processing
        boolean isExceptionThrown = false;
        
        // Create a TDB_Maintenance object to log the processing results
        TDB_Maintenance tdbMaintenance = new TDB_Maintenance();
        
        // Load the .dat file into POJOs (Plain Old Java Objects)
        LoadDatFileIntoPojo LoadFile = new LoadDatFileIntoPojo(sqlProperty);
        
        // Call the method to load the .dat file and process it
        isExceptionThrown = LoadFile.LoadDatFile(baseFilename, doneFileContent, dotFiles);

        // If no exception is thrown, populate the TDB_Maintenance object with success data
        if (isExceptionThrown == false) {
            tdbMaintenance.setRunId(run_id.toString());
            tdbMaintenance.setFileName(fileName);
            tdbMaintenance.setNumRecords(utility.getRecordsByFilename(baseFilename, dotFiles));  // Get number of records for the file
            tdbMaintenance.setSuccess(isExceptionThrown);  // Set success flag to false since no error occurred
            tdbMaintenance.setEncFileName(encFileName);  // Set the encrypted file name
            tdbMaintenance.setDateEnded(utility.nowUtcTimestamp());  // Set the end time of the operation
            tdbMaintenance.setDateStarted(currentIterationStartTime);  // Set the start time of the operation
        } else {
            // If an exception was thrown, log the failure data in TDB_Maintenance object
            tdbMaintenance.setRunId(run_id.toString());
            tdbMaintenance.setFileName(fileName);
            tdbMaintenance.setNumRecords(utility.getRecordsByFilename(baseFilename, dotFiles));  // Get number of records for the file
            tdbMaintenance.setSuccess(isExceptionThrown);  // Set success flag to true since an exception occurred
            tdbMaintenance.setEncFileName(encFileName);  // Set the encrypted file name
            tdbMaintenance.setDateEnded(utility.nowUtcTimestamp());  // Set the end time of the operation
            tdbMaintenance.setDateStarted(currentIterationStartTime);  // Set the start time of the operation
        }

        // Print the TDB_Maintenance object to the console for debugging/verification purposes
        System.out.println("EXECUTION DETAILS------->" + tdbMaintenance.toString());
        logger.info("EXECUTION DETAILS------->" + tdbMaintenance.toString());

        // Return the string representation of the TDB_Maintenance object (including all details)
        return tdbMaintenance.toString();
    }
}
