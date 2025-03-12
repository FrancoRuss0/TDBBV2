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

import com.kmmaltairlines.hip.tdbingester.filepojos.ACSFlightHistory;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.OneIteration;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component
public class ACSFlightHistorySql implements MethodInterface {
	@Autowired
	private Utility utility;
	
	private static final Logger logger = LogManager.getLogger(ACSFlightHistorySql.class);
	/**
	 * Inserts ACSFlightHistory records into the database in bulk.
	 * 
	 * @param flights - List of ACSFlightHistory objects to be inserted
	 * @throws SQLException - If an error occurs while executing the SQL query
	 * @throws IOException 
	 */
	@Override
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		ArrayList<ACSFlightHistory> trasformACSFlightHistory = new ArrayList<ACSFlightHistory>();
		for (Object flight : flights) {
			trasformACSFlightHistory.add((ACSFlightHistory) flight);
		}
		PreparedStatement stmt = null;

			// Read the SQL insert query from the file
			String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertACSFlightHistory.sql");

			// Create a PreparedStatement to execute the SQL query
			stmt = connection.prepareStatement(sql);

			// Disable auto-commit for batch processing

			// Add the flight data to the batch for bulk insertion
			for (ACSFlightHistory flightHistory : trasformACSFlightHistory) {
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
	            stmt.setObject(17, utility.nowUtcTimestamp(), Types.TIMESTAMP); 
	        	
	        	stmt.addBatch();
			}

			// Execute the batch insert
			int[] results = stmt.executeBatch();
			// Commit the transaction

			logger.info("Bulk insert completed successfully. " + results.length + " records inserted.");
	        stmt.close();
		
	}
	@Override
	public String delete(List<Object> flights, Connection connection) throws SQLException, IOException {
		return null;
		// TODO Auto-generated method stub
		
	}
	
}
