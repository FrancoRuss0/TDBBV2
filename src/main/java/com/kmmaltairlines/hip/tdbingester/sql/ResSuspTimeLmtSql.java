package com.kmmaltairlines.hip.tdbingester.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResSuspTimeLmt;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class ResSuspTimeLmtSql {
	
	@Autowired
	Utility utility;
	/**
	 * Inserts ACSFlight records into the database in bulk.
	 * 
	 * @param flights - List of ACSFlight objects to be inserted
	 * @throws SQLException - If an error occurs while executing the SQL query
	 * @throws IOException - If an error occurs while reading SQL files
	 */
	public void insert(List<ResSuspTimeLmt> resSuspTimeLmt,Connection connessione) throws SQLException, IOException {

		// Establish database connection
		Connection conn = connessione;
		PreparedStatement stmt = null;

			// Read the SQL insert query from the file
			String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResSuspTimeLmt.sql");

			// Create a PreparedStatement to execute the SQL query
			stmt = conn.prepareStatement(sql);

			// Add the flight data to the batch for bulk insertion
			for (ResSuspTimeLmt suspTimeLmt : resSuspTimeLmt) {
				
				stmt.setString(1, suspTimeLmt.getID());
				stmt.setString(2, suspTimeLmt.getPNRLocatorID());
				stmt.setObject(3, suspTimeLmt.getPNRCreateDate(), Types.DATE);
				stmt.setObject(4, suspTimeLmt.getFromDateTime(), Types.TIMESTAMP);
                stmt.setShort(5, suspTimeLmt.getSuspenseSequenceId());
                stmt.setString(6, suspTimeLmt.getTimeLimitActionTime());
                stmt.setObject(7, suspTimeLmt.getTimeLimitActionDate(), Types.DATE);
                stmt.setString(8, suspTimeLmt.getTimeLimitLocationCode());
                stmt.setString(9, suspTimeLmt.getTimeLimitVendorCode());
                stmt.setString(10, suspTimeLmt.getHistoryActionCodeId() );
                stmt.setObject(11, suspTimeLmt.getRecordUpdateDate(), Types.DATE);
                stmt.setObject(12, suspTimeLmt.getRecordUpdateTime(), Types.TIME);
                stmt.setShort(13, suspTimeLmt.getIntraPNRSetNbr());
                stmt.setObject(14, utility.nowUtcTimestamp(), Types.TIMESTAMP);
                stmt.addBatch();
			}

			// Execute the batch insert
			int[] results = stmt.executeBatch();

			System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
	        stmt.close();
	}
}