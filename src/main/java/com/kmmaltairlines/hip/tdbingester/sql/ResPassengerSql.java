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
import com.kmmaltairlines.hip.tdbingester.filepojos.ResPassenger;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("ResPassengerSql")
public class ResPassengerSql implements MethodInterface {

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(ResPassengerSql.class);

	/**
	 * Inserts ResPassenger records into the database in bulk.
	 * 
	 * @param resPassengers - List of ResPassenger objects to be inserted
	 * @param connessione   - Connection object for the database connection
	 * @throws SQLException - If an error occurs while executing the SQL query
	 * @throws IOException  - If an error occurs while reading SQL files
	 */
	@Override
	@Transactional
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		// Establish database connection
		ArrayList<ResPassenger> resPassengers = new ArrayList<ResPassenger>();
		for (Object flight : flights) {
			resPassengers.add((ResPassenger) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResPassenger.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the ResPassenger data to the batch for bulk insertion
		for (ResPassenger passenger : resPassengers) {
			stmt.setString(1, passenger.getID());
			stmt.setString(2, passenger.getPNRLocatorID());
			stmt.setDate(3, passenger.getPNRCreateDate());
			stmt.setTimestamp(4, passenger.getFromDateTime());
			stmt.setShort(5, passenger.getPNRPassengerSeqId());
			stmt.setString(6, passenger.getNameFirst());
			stmt.setString(7, passenger.getNameLast());
			stmt.setString(8, passenger.getNameComment());
			stmt.setString(9, passenger.getRelativePassengerNbr());
			stmt.setString(10, passenger.getHistoryActionCodeId());
			stmt.setDate(11, passenger.getRecordUpdateDate());
			stmt.setTime(12, passenger.getRecordUpdateTime());
			stmt.setShort(13, passenger.getIntraPNRSetNbr());
			stmt.setObject(14, utility.nowUtcTimestamp(), Types.TIMESTAMP);
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
		ArrayList<ResPassenger> resPassengers = new ArrayList<ResPassenger>();
		for (Object flight : flights) {
			resPassengers.add((ResPassenger) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteResPassenger.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the flight data to the batch for bulk insertion
		for (ResPassenger res : resPassengers) {
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
