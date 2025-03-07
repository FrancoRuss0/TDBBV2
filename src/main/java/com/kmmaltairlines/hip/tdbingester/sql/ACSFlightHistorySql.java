package com.kmmaltairlines.hip.tdbingester.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.kmmaltairlines.hip.tdbingester.filepojos.ACSFlightHistory;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class ACSFlightHistorySql {
	/**
	 * Inserts ACSFlightHistory records into the database in bulk.
	 * 
	 * @param flights - List of ACSFlightHistory objects to be inserted
	 * @throws SQLException - If an error occurs while executing the SQL query
	 * @throws IOException 
	 */
	@SuppressWarnings("static-access")
	public static void insert(List<ACSFlightHistory> flights,Connection connessione) throws SQLException, IOException {
		Utility a = new Utility();

		// Establish database connection
		Connection conn = connessione;
		PreparedStatement stmt = null;

			// Read the SQL insert query from the file
			String sql = Utility.loadSqlFromFile("src/main/resources/query/InsertACSFlightHistory.sql");

			// Create a PreparedStatement to execute the SQL query
			stmt = conn.prepareStatement(sql);

			// Disable auto-commit for batch processing
			conn.setAutoCommit(false);

			// Add the flight data to the batch for bulk insertion
			for (ACSFlightHistory flightHistory : flights) {
	        	stmt.setString(1, flightHistory.getSourceSystemID());
	            stmt.setObject(2, flightHistory.getACSFltSegDate(), Types.TIMESTAMP);  
	            stmt.setString(3, flightHistory.getAirlineCode());
	            stmt.setString(4, flightHistory.getFltNbr());
	            stmt.setString(5, flightHistory.getAirlineOrigAirport());
	            stmt.setString(6, flightHistory.getAirlineDestAirport());
	            stmt.setObject(7, flightHistory.getSchdServiceStartTime(), Types.TIME); 
	            stmt.setString(8, flightHistory.getAAACityCode());
	            stmt.setString(9, flightHistory.getAgentSine());
	            stmt.setObject(10, flightHistory.getActionDate(), Types.TIMESTAMP); 
	            stmt.setObject(11, flightHistory.getActionTime(), Types.TIME); 
	            stmt.setString(12, flightHistory.getAgntStationLNIATA());
	            stmt.setString(13, flightHistory.getActionItem());
	            stmt.setString(14, flightHistory.getAgntDtyCd());
	            stmt.setString(15, flightHistory.getAgntHomeStation());
	            stmt.setObject(16, flightHistory.getMsgCreateDateTime(), Types.TIMESTAMP); 
	            stmt.setObject(17, a.nowUtcTimestamp(), Types.TIMESTAMP); 
	        	
	        	stmt.addBatch();
			}

			// Execute the batch insert
			int[] results = stmt.executeBatch();
			// Commit the transaction
			conn.commit();

			System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
			stmt.close();
	}
	
}
