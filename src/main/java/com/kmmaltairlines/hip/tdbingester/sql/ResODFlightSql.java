package com.kmmaltairlines.hip.tdbingester.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kmmaltairlines.hip.tdbingester.filepojos.Res;
import com.kmmaltairlines.hip.tdbingester.filepojos.ResODFlight;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("ResODFlightSql")
public class ResODFlightSql implements MethodInterface {

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(ResODFlightSql.class);

	/**
	 * Inserts ResODFlight records into the database in bulk.
	 * 
	 * @param resODFlights - List of ResODFlight objects to be inserted
	 * @param connessione  - Connection object for the database connection
	 * @throws SQLException - If an error occurs while executing the SQL query
	 * @throws IOException  - If an error occurs while reading SQL files
	 */
	@Override
	@Transactional
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		// Establish database connection
		ArrayList<ResODFlight> resODFlights = new ArrayList<ResODFlight>();
		for (Object flight : flights) {
			resODFlights.add((ResODFlight) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResODFlight.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the ResODFlight data to the batch for bulk insertion
		for (ResODFlight odFlight : resODFlights) {
			stmt.setString(1, odFlight.getID());
			stmt.setShort(2, odFlight.getSegmentNbr());
			stmt.setString(3, odFlight.getAirlineOrigTerminal());
			stmt.setString(4, odFlight.getAirlineDestTerminal());
			stmt.setString(5, odFlight.getTravelerOrigTerminal());
			stmt.setString(6, odFlight.getTravelerDestTerminal());
			stmt.setString(7, odFlight.getAirlineOrigCntry());
			stmt.setString(8, odFlight.getAirlineDestCntry());
			stmt.setString(9, odFlight.getTravelerOrigCntry());
			stmt.setString(10, odFlight.getTravelerDestCntry());
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
				ArrayList<ResODFlight> resODFlights = new ArrayList<ResODFlight>();
				for (Object flight : flights) {
					resODFlights.add((ResODFlight) flight);
				}
		PreparedStatement stmt = null;

			// Read the SQL insert query from the file
			String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteResODFlight.sql");

			// Create a PreparedStatement to execute the SQL query
			stmt = connection.prepareStatement(sql);

			// Add the flight data to the batch for bulk insertion
			for (ResODFlight res : resODFlights) {
				 	stmt.setString(1, res.getPNRLocatorID());
				 	stmt.setDate(2, res.getPNRCreateDate());
	                // Add the statement to the batch
	                stmt.addBatch();
			}

			// Execute the batch insert
			int[] results = stmt.executeBatch();
			String back=stmt.executeBatch().toString();
			logger.info("Delete completed successfully. " + results.length + " records deleted.");
	        stmt.close();
		return back;
	}
}
