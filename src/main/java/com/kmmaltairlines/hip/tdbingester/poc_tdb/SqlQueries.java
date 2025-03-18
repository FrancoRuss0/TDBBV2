package com.kmmaltairlines.hip.tdbingester.poc_tdb;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.kmmaltairlines.hip.tdbingester.sql.GetUpdPNR;
import com.kmmaltairlines.hip.tdbingester.sql.GetUpdVCR;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@Component // Marks this class as a Spring component, making it a Spring-managed bean
public class SqlQueries {

	// Autowired dependencies for various services
	@Autowired
	private ApplicationContext context; // Spring context for dependency injection
	@Autowired
	private Utility utility; // Utility service for various utility functions
	@Autowired
	private GetUpdPNR getUpdPNR; // Service for handling PNR (Passenger Name Record) data
	@Autowired
	private GetUpdVCR getUpdVCR; // Service for handling VCR (Voyage Control Record) data

	// Maps to store updated PNR and VCR records, grouped by date
	Map<String, Map<Date, List<Map<String, Object>>>> updatedPNRRecords;
	Map<String, Map<Date, List<Map<String, Object>>>> updatedVCRRecords;

	// Logger to log messages for this class
	private static final Logger logger = LogManager.getLogger(SqlQueries.class);

	/**
	 * This method processes flight data based on the provided base filename and
	 * inserts the corresponding records into the database. It handles PNR and VCR
	 * records, as well as general flight records.
	 * 
	 * @param flights      - List of flight objects to be inserted into the database
	 * @param baseFilename - The name of the file that helps determine the data type
	 *                     (e.g., "Res", "Tkt")
	 * @param connection   - The database connection used for SQL operations
	 * @throws Exception
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 */
	public void sql(List<Object> flights, String baseFilename, Connection connection) throws Exception {
		try {
			// If the filename contains "Res" (Reservation), process PNR records
			if (baseFilename.contains("Res")) {
				// Remove duplicate PNR records based on the base filename
				flights = utility.removeDuplicatesPNR(flights, baseFilename);

				// If the filename corresponds to a reservation, handle the PNR processing
				if (utility.isRes(baseFilename)) {
					// Set auto-commit to false to manually handle transactions
					connection.setAutoCommit(false);

					// Insert PNR records into the database and commit
					getUpdPNR.insert(flights, connection);
					connection.commit();

					// Select updated PNR records from the database
					updatedPNRRecords = getUpdPNR.select(connection);
					// Group the selected records by date
					updatedPNRRecords = utility.groupData(updatedPNRRecords);
				}

				// Filter out records that already exist in the database
				flights = utility.filterRecordsPNR(flights, updatedPNRRecords);

				// Get the appropriate SQL interface based on the base filename
				MethodInterface methodInterface = (MethodInterface) context.getBean(baseFilename + "Sql");

				// Delete any existing records in the database before inserting new ones
				connection.setAutoCommit(false);
				methodInterface.delete(flights, connection);
				connection.commit();

				// Insert the new records into the database
				connection.setAutoCommit(false);
				methodInterface.insert(flights, connection);
				connection.commit();

				// If the filename contains "Tkt" (Ticket), process VCR records
			} else if (baseFilename.contains("Tkt")) {
				// Remove duplicate VCR records based on the base filename
				flights = utility.removeDuplicatesVCR(flights, baseFilename);

				// If the filename corresponds to a ticket document, handle the VCR processing
				if (utility.isTktDocument(baseFilename)) {
					// Set auto-commit to false to manually handle transactions
					connection.setAutoCommit(false);

					// Insert VCR records into the database and commit
					getUpdVCR.insert(flights, connection);
					connection.commit();

					// Select updated VCR records from the database
					updatedVCRRecords = getUpdVCR.select(connection);
					// Group the selected records by date
					updatedVCRRecords = utility.groupData(updatedVCRRecords);
				}

				// Filter out records that already exist in the database
				flights = utility.filterRecordsVCR(flights, updatedVCRRecords);

				// Get the appropriate SQL interface based on the base filename
				MethodInterface methodInterface = (MethodInterface) context.getBean(baseFilename + "Sql");

				// Delete any existing records in the database before inserting new ones
				connection.setAutoCommit(false);
				methodInterface.delete(flights, connection);
				connection.commit();

				// Insert the new records into the database
				connection.setAutoCommit(false);
				methodInterface.insert(flights, connection);
				connection.commit();

				// If the filename does not contain "Res" or "Tkt", handle general flight
				// records
			} else {
				// Get the appropriate SQL interface based on the base filename
				MethodInterface methodInterface = (MethodInterface) context.getBean(baseFilename + "Sql");

				// Insert the flight records into the database
				connection.setAutoCommit(false);
				methodInterface.insert(flights, connection);
				connection.commit();
			}

			// Catch and handle SQL exceptions
		} catch (SQLException ex) {
			logger.error("Error processing file : " + ex.getMessage());

			// If an error occurs, attempt to roll back the transaction
			if (connection != null) {
				try {
					connection.rollback(); // Rollback before rethrowing the exception
				} catch (SQLException rollbackEx) {
					logger.error("Error during rollback: " + rollbackEx.getMessage());
				}
			}

			// Rethrow the SQL exception to propagate the error
			throw ex;
		}
	}
}
