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
import com.kmmaltairlines.hip.tdbingester.filepojos.ResFlightAirExtra;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("ResFlightAirExtraSql")
public class ResFlightAirExtraSql implements MethodInterface {

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(ResFlightAirExtraSql.class);

	/**
	 * Inserts ResFlightAirExtra records into the database in bulk.
	 * 
	 * @param resFlightAirExtras - List of ResFlightAirExtra objects to be inserted
	 * @param connessione        - Connection object for the database connection
	 * @throws SQLException - If an error occurs while executing the SQL query
	 * @throws IOException  - If an error occurs while reading SQL files
	 */
	@Override
	@Transactional
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		// Establish database connection
		ArrayList<ResFlightAirExtra> resFlightAirExtras = new ArrayList<ResFlightAirExtra>();
		for (Object flight : flights) {
			resFlightAirExtras.add((ResFlightAirExtra) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResFlightAirExtra.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the ResFlightAirExtra data to the batch for bulk insertion
		for (ResFlightAirExtra flightAirExtra : resFlightAirExtras) {
			stmt.setString(1, flightAirExtra.getID());
			stmt.setString(2, flightAirExtra.getPNRLocatorID());
			stmt.setDate(3, flightAirExtra.getPNRCreateDate());
			stmt.setTimestamp(4, flightAirExtra.getFromDateTime());
			stmt.setShort(5, flightAirExtra.getSegmentNbr());
			stmt.setShort(6, flightAirExtra.getPNRPassengerSeqId());
			stmt.setString(7, flightAirExtra.getRFISubCode());
			stmt.setDate(8, flightAirExtra.getRecordUpdateDate());
			stmt.setTime(9, flightAirExtra.getRecordUpdateTime());
			stmt.setShort(10, flightAirExtra.getIntraPNRSetNbr());
			stmt.setObject(11, utility.nowUtcTimestamp(), Types.TIMESTAMP); 
			// Add to batch
			stmt.addBatch();
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
		ArrayList<ResFlightAirExtra> resFlightAirExtras = new ArrayList<ResFlightAirExtra>();
		for (Object flight : flights) {
			resFlightAirExtras.add((ResFlightAirExtra) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteResFlightAirExtra.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the flight data to the batch for bulk insertion
		for (ResFlightAirExtra res : resFlightAirExtras) {
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
