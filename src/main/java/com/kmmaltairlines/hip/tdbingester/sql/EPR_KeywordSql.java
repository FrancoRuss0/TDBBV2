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

import com.kmmaltairlines.hip.tdbingester.filepojos.EPR_Keyword;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.OneIteration;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component
public class EPR_KeywordSql implements MethodInterface {
	@Autowired
	private Utility utility;

	private static final Logger logger = LogManager.getLogger(EPR_KeywordSql.class);

	/**
	 * Inserts ACSFlightHistory records into the database in bulk.
	 * 
	 * @param flights - List of EPR_Keyword objects to be inserted
	 * @throws SQLException - If an error occurs while executing the SQL query
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		ArrayList<EPR_Keyword> trasformEPR_Keyword = new ArrayList<EPR_Keyword>();
		for (Object flight : flights) {
			trasformEPR_Keyword.add((EPR_Keyword) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/persistEPR_Keyword.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the flight data to the batch for bulk insertion
		for (EPR_Keyword EPR_Keyword : trasformEPR_Keyword) {
			stmt.setString(1, EPR_Keyword.getPCC_Cd());
			stmt.setString(2, EPR_Keyword.getUser_Id());
			stmt.setString(3, EPR_Keyword.getKeyword());
			stmt.setString(4, EPR_Keyword.getRecordStatus());
			stmt.setObject(5, EPR_Keyword.getEffectiveDate(), Types.TIMESTAMP);

			stmt.setString(6, EPR_Keyword.getPCC_Cd());
			stmt.setString(7, EPR_Keyword.getUser_Id());
			stmt.setString(8, EPR_Keyword.getKeyword());
			stmt.setString(9, EPR_Keyword.getRecordStatus());
			stmt.setObject(10, EPR_Keyword.getEffectiveDate(), Types.TIMESTAMP);
			stmt.setObject(11, utility.nowUtcTimestamp(), Types.TIMESTAMP);

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
