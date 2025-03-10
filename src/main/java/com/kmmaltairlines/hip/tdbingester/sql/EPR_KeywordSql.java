package com.kmmaltairlines.hip.tdbingester.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.kmmaltairlines.hip.tdbingester.filepojos.ACSFlightHistory;
import com.kmmaltairlines.hip.tdbingester.filepojos.EPR_Keyword;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class EPR_KeywordSql {
	/**
	 * Inserts ACSFlightHistory records into the database in bulk.
	 * 
	 * @param flights - List of EPR_Keyword objects to be inserted
	 * @throws SQLException - If an error occurs while executing the SQL query
	 * @throws IOException 
	 */
	@SuppressWarnings("static-access")
	public static void insert(List<EPR_Keyword> flights,Connection connessione) throws SQLException, IOException {

		// Establish database connection
		Connection conn = connessione;
		PreparedStatement stmt = null;

			// Read the SQL insert query from the file
			String sql = Utility.loadSqlFromFile("src/main/resources/query/persistEPR_Keyword.sql");

			// Create a PreparedStatement to execute the SQL query
			stmt = conn.prepareStatement(sql);

			// Disable auto-commit for batch processing
			conn.setAutoCommit(false);

			// Add the flight data to the batch for bulk insertion
			for (EPR_Keyword EPR_Keyword : flights) {
	        	stmt.setString(1, EPR_Keyword.getPCC_Cd());
	        	stmt.setString(2, EPR_Keyword.getUser_Id());
	        	stmt.setString(3, EPR_Keyword.getKeyword());
	        	stmt.setString(4, EPR_Keyword.getRecordStatus());
	        	stmt.setObject(5, EPR_Keyword.getEffectiveDate(), Types.TIMESTAMP);
	        	
	        	stmt.setString(6, EPR_Keyword.getPCC_Cd());
	        	stmt.setString(7, EPR_Keyword.getUser_Id());
	        	stmt.setString(8, EPR_Keyword.getKeyword());
	        	stmt.setString(9,EPR_Keyword.getRecordStatus());
	        	stmt.setObject(10,EPR_Keyword.getEffectiveDate(), Types.TIMESTAMP);
	        	stmt.setObject(11, Utility.nowUtcTimestamp(), Types.TIMESTAMP);
	        	
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
