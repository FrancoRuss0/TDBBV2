package com.kmmaltairlines.hip.tdbingester.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kmmaltairlines.hip.tdbingester.filepojos.Res;
import com.kmmaltairlines.hip.tdbingester.filepojos.ResPassengerEmail;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("ResPassengerEmailSql")
public class ResPassengerEmailSql implements MethodInterface {

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(ResPassengerEmailSql.class);

	/**
	 * Inserts ResPassengerEmail records into the database in bulk.
	 * 
	 * @param resPassengerEmails - List of ResPassengerEmail objects to be inserted
	 * @param connessione        - Connection object for the database connection
	 * @throws SQLException - If an error occurs while executing the SQL query
	 * @throws IOException  - If an error occurs while reading SQL files
	 */
	@Override
	@Transactional
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		// Establish database connection
		ArrayList<ResPassengerEmail> resPassengerEmails = new ArrayList<ResPassengerEmail>();
		for (Object flight : flights) {
			resPassengerEmails.add((ResPassengerEmail) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResPassengerEmail.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the ResPassengerEmail data to the batch for bulk insertion
		for (ResPassengerEmail passengerEmail : resPassengerEmails) {
			stmt.setString(1, passengerEmail.getID());
			stmt.setString(2, passengerEmail.getPNRLocatorID());
			stmt.setDate(3, passengerEmail.getPNRCreateDate());
			stmt.setTimestamp(4, passengerEmail.getFromDateTime());
			stmt.setShort(5, passengerEmail.getPNRPassengerEMailSeqId());
			stmt.setString(6, passengerEmail.getEMailAddress());
			stmt.setString(7, passengerEmail.getHistoryActionCodeId());
			stmt.setDate(8, passengerEmail.getRecordUpdateDate());
			stmt.setTime(9, passengerEmail.getRecordUpdateTime());
			stmt.setShort(10, passengerEmail.getIntraPNRSetNbr());
			stmt.setShort(11, passengerEmail.getPNRPassengerSeqID());
			stmt.setObject(12, utility.nowUtcTimestamp(), Types.TIMESTAMP);
			stmt.addBatch(); // Add this record to the batch
		}

		// Execute the batch insert
		int[] results = stmt.executeBatch();

		logger.info("Bulk insert completed successfully. " + results.length + " records inserted.");
		stmt.close();
	}

	@Override
	@Transactional
	public String delete(List<Object> flights, Connection connection) throws SQLException, IOException {
		// Establish database connection
		ArrayList<ResPassengerEmail> resPassengerEmails = new ArrayList<ResPassengerEmail>();
		for (Object flight : flights) {
			resPassengerEmails.add((ResPassengerEmail) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteResPassengerEmail.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the flight data to the batch for bulk insertion
		for (ResPassengerEmail res : resPassengerEmails) {
			stmt.setString(1, res.getPNRLocatorID());
			stmt.setDate(2, res.getPNRCreateDate());
			// Add the statement to the batch
			stmt.addBatch();
		}

		// Execute the batch insert
		int[] results = stmt.executeBatch();
		String back = stmt.executeBatch().toString();
		logger.info("Delete completed successfully. " + results.length + " records deleted.");
		stmt.close();
		return back;
	}
}
