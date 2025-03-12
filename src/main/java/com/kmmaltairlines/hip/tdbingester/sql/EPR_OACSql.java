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

import com.kmmaltairlines.hip.tdbingester.filepojos.EPR_OAC;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.OneIteration;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component
public class EPR_OACSql implements MethodInterface{
	@Autowired
	private Utility utility;
	
	private static final Logger logger = LogManager.getLogger(EPR_OACSql.class);
	/**
	 * Inserts ACSFlightHistory records into the database in bulk.
	 * 
	 * @param flights - List of EPR_OAC objects to be inserted
	 * @throws SQLException - If an error occurs while executing the SQL query
	 * @throws IOException 
	 */
	@Override
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		ArrayList<EPR_OAC> trasformEPR_OAC = new ArrayList<EPR_OAC>();
		for (Object flight : flights) {
			trasformEPR_OAC.add((EPR_OAC) flight);
		}

		PreparedStatement stmt = null;

			// Read the SQL insert query from the file
			String sql = utility.loadSqlFromFile("src/main/resources/query/insert/persistEPR_OAC.sql");

			// Create a PreparedStatement to execute the SQL query
			stmt = connection.prepareStatement(sql);

			// Add the flight data to the batch for bulk insertion
			for (EPR_OAC EPR_OAC : trasformEPR_OAC) {
	        	stmt.setString(1, EPR_OAC.getPCC_Cd());
	        	stmt.setString(2, EPR_OAC.getUser_Id());
	        	stmt.setString(3, EPR_OAC.getDefault_Ticketing_Carrier());
	        	stmt.setString(4, EPR_OAC.getPersonal_City_Code());
	        	stmt.setString(5, EPR_OAC.getPersonal_Account_Code());
	        	stmt.setString(6, EPR_OAC.getStation_Code());
	        	stmt.setString(7, EPR_OAC.getRecordStatus());
	        	stmt.setObject(8, EPR_OAC.getEffectiveDate(), Types.TIMESTAMP);
	        	
	        	stmt.setString(9, EPR_OAC.getPCC_Cd());
	        	stmt.setString(10, EPR_OAC.getUser_Id());
	        	stmt.setString(11, EPR_OAC.getDefault_Ticketing_Carrier());
	        	stmt.setString(12, EPR_OAC.getPersonal_City_Code());
	        	stmt.setString(13, EPR_OAC.getPersonal_Account_Code());
	        	stmt.setString(14, EPR_OAC.getStation_Code());
	        	stmt.setString(15, EPR_OAC.getRecordStatus());
	        	stmt.setObject(16, EPR_OAC.getEffectiveDate(), Types.TIMESTAMP);
	        	stmt.setObject(17, utility.nowUtcTimestamp(), Types.TIMESTAMP);
	        	

	        	stmt.addBatch();
			}

			// Execute the batch insert
			int[] results = stmt.executeBatch();

			logger.info("Bulk insert completed successfully. " + results.length + " records inserted.");
	        stmt.close();
	}
	@Override
	public String delete(List<Object> flights, Connection connection) throws SQLException, IOException {
		return null;
		// TODO Auto-generated method stub
		
	}
}
