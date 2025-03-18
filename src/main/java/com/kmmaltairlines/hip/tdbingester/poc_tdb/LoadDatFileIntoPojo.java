package com.kmmaltairlines.hip.tdbingester.poc_tdb;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kmmaltairlines.hip.tdbingester.filepojos.DoneFileEntry;
import com.kmmaltairlines.mail.EmailRequest;
import com.kmmaltairlines.mail.MailService;

@Component // Marks the class as a Spring-managed component (bean)
public class LoadDatFileIntoPojo {

	// Autowired dependencies for services and classes used in the file processing
	@Autowired
	public TransformationIntoPOJO transformation; // Service for transforming .dat file into POJOs
	@Autowired
	public Utility utility; // Utility service for various utility methods (like getting records)
	@Autowired
	public SqlQueries query; // SQL queries service for interacting with the database
	@Autowired
	public MailService mailService; // Service for sending emails
	@Autowired
	public EmailRequest emailRequest; // Service for creating email requests

	// Logger to log messages for this class
	private static final Logger logger = LogManager.getLogger(LoadDatFileIntoPojo.class);

	/**
	 * This method is responsible for loading a .dat file, transforming it into
	 * POJOs (Plain Old Java Objects), and persisting the data into the database.
	 * 
	 * @param baseFilename       - The base filename (without extension) of the .dat
	 *                           file.
	 * @param doneFileEntryValue - The specific value from the done file entry.
	 * @param doneFileEntryList  - The list of DoneFileEntry objects that relate to
	 *                           this file.
	 * @param connection         - The database connection used for SQL operations.
	 * @param encFileName        - The name of the encrypted file being processed.
	 * @return Boolean - Returns true if the file is successfully processed,
	 *         otherwise false.
	 */
	public Boolean loadDatFile(String baseFilename, String doneFileEntryValue, ArrayList<DoneFileEntry> dotFiles,
			Connection connection, String encFileName) {

		// Map to hold variables, which will be used for the email in case of errors
		Map<String, Object> variables = new HashMap<>();

		// Construct the filename for the transformation script based on the base
		// filename
		String filename = baseFilename + ".dwl"; // The name of the transformation script
		String directory = "src\\main\\java\\transformations"; // Directory where transformation scripts are stored
		Path filePath = Paths.get(directory, filename); // Path to the transformation script file

		// Check if the transformation script file exists
		if (!Files.exists(filePath)) {
			// If the script doesn't exist, log an error and return false
			logger.error("Transformation script does not exist for the file " + filename + ".");
			return false;
		} else {
			// If the transformation script exists, proceed with processing
			logger.info("Processing .dat file.");
			logger.info("FILE NAME -> " + baseFilename);

			try {
				// Load the .dat file into POJOs (Plain Old Java Objects) via the transformation
				// service
				ArrayList<Object> listTransformation = transformation.loadDatFileIntoPOJO(doneFileEntryValue,
						baseFilename);

				// Compare the number of records in the file with the number of records in the
				// POJOs
				if (utility.getRecordsByFilename(baseFilename, dotFiles) == listTransformation.size()) {
					// If the record counts match, log the success
					logger.info("Successfully transformed file into POJOs.");

					// If there are records in the transformed list, persist them in the database
					if (listTransformation.size() > 0) {
						// Persist the records into the database using SQL queries service
						query.sql(listTransformation, baseFilename, connection);
						// Log success message after data persistence
						logger.info("Successfully persisted all records in the respective table.");
					} else {
						// If no records are found in the transformed list, log a message and skip
						// processing
						logger.info("No records were present in the TDB file. Skipping.");
					}
					return true; // Return true if the processing was successful
				} else {
					// If the number of records does not match, log the error
					logger.error("Number of lines denoted in " + baseFilename
							+ utility.getRecordsByFilename(baseFilename, dotFiles)
							+ " lines does not match number of lines in " + baseFilename + " "
							+ listTransformation.size() + " lines");
					return false;
				}
			} catch (Exception e) {
				// If an exception occurs during the processing, prepare the variables for the
				// error email
				variables.put("exceptionCause", e.getMessage());
				variables.put("donefileName", baseFilename);
				variables.put("encFileName", encFileName);
				variables.put("exceptionStackTrace", Arrays.toString(e.getStackTrace()));

				try {
					// Set the email template and send an email with the exception details
					emailRequest.setTemplateMessage("exception_email_template", variables);
					emailRequest.setSubject("Error in Travel Data Batch Ingester");
					mailService.sendEmail(emailRequest);
					logger.info("Email sent successfully.");
				} catch (Exception emailException) {
					// If an error occurs while sending the email, log the error
					logger.error("Error sending email: " + emailException.getMessage());
				}

				// Log the exception message and return false
				logger.error(e.getMessage());
				return false;
			}
		}
	}
}
