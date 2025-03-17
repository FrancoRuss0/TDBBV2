package com.kmmaltairlines.hip.tdbingester.poc_tdb;

import java.util.ArrayList;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFileEntry;
import com.kmmaltairlines.hip.tdbingester.maintenance.TDB_Maintenance;
import com.kmmaltairlines.hip.tdbingester.sql.TDB_MaintenanceSql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

@Component  // Marks this class as a Spring-managed bean
public class OneIteration {

    // Autowired dependencies for other services and classes
    @Autowired
    private LoadDatFileIntoPojo loadFile;  // Service to load and process .dat files into POJOs

    @Autowired
    private TDB_MaintenanceSql tdbSql;  // SQL service for interacting with TDB_Maintenance data

    // Logger to log messages for this class
    private static final Logger logger = LogManager.getLogger(OneIteration.class);

    /**
     * This method processes each entry in the done file and performs the necessary operations.
     * It processes the file by loading its content, performing maintenance operations, and logging the results.
     * @param doneFileName - the list of entries in the done file.
     * @param doneFileContent - the specific entry value from the done file.
     * @param run_id - unique run identifier for the current execution.
     * @param doneFileEntryListA - the list of `DoneFileEntry` objects.
     * @param encFileName - the name of the encrypted file being processed.
     * @param connection - the database connection used for SQL operations.
     * @param report - the list to hold the processed maintenance reports.
     * @return ArrayList<TDB_Maintenance> - the updated report after processing the file.
     * @throws SQLException - if a database error occurs during processing.
     * @throws IOException - if there is an error loading the file content.
     */
    public ArrayList<TDB_Maintenance> processDoneFiles(String doneFileName, String doneFileContent, UUID run_id, 
                                                       ArrayList<DoneFileEntry> doneFileEntry, String encFileName, 
                                                       Connection connection, ArrayList<TDB_Maintenance> report) 
                                                       throws IOException, SQLException {

        // Create a utility object for handling timestamps and other utilities
        Utility utility = new Utility();
        TDB_Maintenance tdbMaintenance = new TDB_Maintenance();  // Object to store maintenance info
        Timestamp currentIterationStartTime = utility.nowUtcTimestamp();  // Capture the start time for this operation

        // Extract base filename and the actual filename without ".dat" extension
        String[] parts = doneFileName.split("_");
        String baseFilename;
        // If the filename does not have enough parts, use the first part as the base filename
        if (parts.length < 3) {
            baseFilename = parts[0];
        } else {
            // If the filename has more parts, use the first two parts as the base filename
            baseFilename = parts[0] + "_" + parts[1];
        }

        // Flag to track if any exceptions are thrown during the file processing
        boolean isExceptionThrown = false;

        // Call method to load the .dat file and process its content
        isExceptionThrown = loadFile.loadDatFile(baseFilename, doneFileContent, doneFileEntry, connection, encFileName);

        // If no exception was thrown during processing, log success details
        if (isExceptionThrown == false) {
            // Set the properties of the TDB_Maintenance object for successful processing
            tdbMaintenance.setRunId(run_id.toString());
            tdbMaintenance.setFileName(doneFileName);  // Set the file name being processed
            tdbMaintenance.setNumRecords(utility.getRecordsByFilename(baseFilename, doneFileEntry));  // Get number of records processed
            tdbMaintenance.setSuccess(isExceptionThrown);  // Success flag (false means successful processing)
            tdbMaintenance.setEncFileName(encFileName);  // Set the encrypted file name
            tdbMaintenance.setDateEnded(utility.nowUtcTimestamp());  // Set the end time of the operation
            tdbMaintenance.setDateStarted(currentIterationStartTime);  // Set the start time of the operation
            report.add(tdbMaintenance);  // Add the maintenance object to the report list
        } else {
            // If an exception was thrown during processing, log failure details
            tdbMaintenance.setRunId(run_id.toString());
            tdbMaintenance.setFileName(doneFileName);
            tdbMaintenance.setNumRecords(utility.getRecordsByFilename(baseFilename, doneFileEntry));  // Get number of records for the failed file
            tdbMaintenance.setSuccess(isExceptionThrown);  // Success flag (true means there was an exception)
            tdbMaintenance.setEncFileName(encFileName);
            tdbMaintenance.setDateEnded(utility.nowUtcTimestamp());
            tdbMaintenance.setDateStarted(currentIterationStartTime);
            report.add(tdbMaintenance);  // Add the failure maintenance object to the report list
        }

        // Log the details of the TDB_Maintenance object for debugging or verification
        logger.info("EXECUTION DETAILS------->" + tdbMaintenance.toString());

        // Insert the TDB_Maintenance object into the database
        tdbSql.insert(tdbMaintenance, connection);

        // Return the updated report containing the processed maintenance entries
        return report;
    }
}
