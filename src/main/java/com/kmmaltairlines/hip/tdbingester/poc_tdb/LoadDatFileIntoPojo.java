package com.kmmaltairlines.hip.tdbingester.poc_tdb;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFileEntry;

@Component
public class LoadDatFileIntoPojo {	
	@Autowired
	private TransformationIntoPOJO transformation;
	@Autowired
	private Utility utility;
	@Autowired
	private SqlQueries query;
    // Logger to log messages
    private static final Logger logger = LogManager.getLogger(LoadDatFileIntoPojo.class);

    /**
     * This method is responsible for loading a .dat file, transforming it into POJOs (Plain Old Java Objects),
     * and persisting the data into the database.
     * @param baseFilename - The base filename (without extension) of the .dat file.
     * @param doneFileEntryValue - The specific value from the done file entry.
     * @param doneFileEntryList - The list of DoneFileEntry objects that relate to this file.
     * @return Boolean - Returns true if the file is successfully processed, otherwise false.
     */
    public Boolean loadDatFile(String baseFilename, String doneFileEntryValue, ArrayList<DoneFileEntry> dotFiles,Connection connection) {
        // Construct the filename for the transformation script
        String filename = baseFilename + ".dwl";  // File name for the transformation script
        String directory = "src\\main\\java\\transformations";  // Directory path where transformation scripts are located
        Path filePath = Paths.get(directory, filename);  // Path to the transformation script

        // Check if the transformation script file exists
        if (!Files.exists(filePath)) {
            // If the file doesn't exist, log an error and return false
            logger.error("Transformation script does not exist for the file " + filename + ".");
            return false;
        } else {
            // If the file exists, proceed with processing
            logger.info("Processing .dat file.");
            logger.info("FILE NAME -> " + baseFilename);
            
            try {
                // Load the .dat file into POJOs
                ArrayList<Object> listTransformation = transformation.loadDatFileIntoPOJO(doneFileEntryValue, baseFilename);
                // Compare the number of records in the file with the number of records in the POJOs
                if (utility.getRecordsByFilename(baseFilename, dotFiles) == listTransformation.size()) {
                    // If the record counts match, log success
                    logger.info("Successfully transformed file into POJOs.");
                    
                    // If transformation was successful, persist the data into the database
                    if (listTransformation.size() > 0) {
                        // Persist the records into the database using SQL queries
                    	// Retrieve connection properties from sqlProperty
                		// Create and return a connection to the database
                    		query.sql(listTransformation, baseFilename,connection);
                        // Log success message after data persistence
                        logger.info("Successfully persisted all records in the respective table.");
                    } else {
                        // If no records are found in the transformed list, log a message and skip processing
                        logger.info("No records were present in the TDB file. Skipping.");
                    }
                    return true;  // Return true if the process was successful
                } else {
                    logger.error("Number of lines denoted in " + baseFilename
                            + utility.getRecordsByFilename(baseFilename, dotFiles)
                            + " lines does not match number of lines in " + baseFilename + " " + listTransformation.size()
                            + " lines");
                    return false;
                }
            } catch (Exception e) {
                // If any exception occurs during processing, log the error and return false
                logger.error(e.getMessage());
                return false;
            }
        }
    }
}
