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
import org.springframework.stereotype.Service;

import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFileEntry;

@Service
public class LoadDatFileIntoPojo {

    @Autowired
    private SqlProperty sqlProperty;  // Injected SqlProperty object for database connection and configuration
    
    // Constructor for the class, initializing with the SqlProperty
    public LoadDatFileIntoPojo(SqlProperty sqlProperty) {
        this.sqlProperty = sqlProperty;
    }

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
    public Boolean LoadDatFile(String baseFilename, String doneFileEntryValue, ArrayList<DoneFileEntry> dotFiles) {
        
        // Utility object to help with general utility operations (e.g., timestamp, record counts)
        Utility utility = new Utility();
        
        // Construct the filename for the transformation script
        String filename = baseFilename + ".dwl";  // File name for the transformation script
        String directory = "src\\main\\java\\transformations";  // Directory path where transformation scripts are located
        SqlQueries query = new SqlQueries();  // Object for handling SQL queries
        Path filePath = Paths.get(directory, filename);  // Path to the transformation script

        // Check if the transformation script file exists
        if (!Files.exists(filePath)) {
            // If the file doesn't exist, log an error and return false
            System.err.println("Transformation script does not exist for the file " + filename + ".");
            logger.error("Transformation script does not exist for the file " + filename + ".");
            return false;
        } else {
            // If the file exists, proceed with processing
            System.out.println("Processing .dat file.");
            logger.info("Processing .dat file.");
            System.out.println("FILE NAME -> " + baseFilename);
            
            try {
                // Transformation object to load the .dat file into POJOs
                TransformationIntoPOJO transformation = new TransformationIntoPOJO();
                
                // Load the .dat file into POJOs
                ArrayList<Object> listTransformation = transformation.loadDatFileIntoPOJO(doneFileEntryValue, baseFilename);

                // Compare the number of records in the file with the number of records in the POJOs
                if (utility.getRecordsByFilename(baseFilename, dotFiles) == listTransformation.size()) {
                    // If the record counts match, log success
                    System.out.println("Successfully transformed file into POJOs.");
                    logger.info("Successfully transformed file into POJOs.");
                    
                    // If transformation was successful, persist the data into the database
                    if (listTransformation.size() > 0) {
                        // Persist the records into the database using SQL queries
                    	// Retrieve connection properties from sqlProperty
                		String url = sqlProperty.getJdbcUrl();
                		String username = sqlProperty.getUser();
                		String password = sqlProperty.getPassword();

                		// Create and return a connection to the database
                		Connection conn = DriverManager.getConnection(url, username, password);
                    		query.sql(listTransformation, baseFilename,conn);
                        // Log success message after data persistence
                        System.out.println("Successfully persisted all records in the respective table.");
                        logger.info("Successfully persisted all records in the respective table.");
                    } else {
                        // If no records are found in the transformed list, log a message and skip processing
                        System.out.println("No records were present in the TDB file. Skipping.");
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
                System.err.println(e.getMessage());
                logger.error(e.getMessage());
                return false;
            }
        }
    }
}
