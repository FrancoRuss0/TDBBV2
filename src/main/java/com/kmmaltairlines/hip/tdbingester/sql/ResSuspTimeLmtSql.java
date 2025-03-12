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
import com.kmmaltairlines.hip.tdbingester.filepojos.ResSuspTimeLmt;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("ResSuspTimeLmtSql")
public class ResSuspTimeLmtSql implements MethodInterface {

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(ResSuspTimeLmtSql.class);

	/**
	 * Inserts ACSFlight records into the database in bulk.
	 * 
	 * @param flights - List of ACSFlight objects to be inserted
	 * @throws SQLException - If an error occurs while executing the SQL query
	 * @throws IOException  - If an error occurs while reading SQL files
	 */
	@Override
	@Transactional
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		// Establish database connection
		ArrayList<ResSuspTimeLmt> resSuspTimeLmt = new ArrayList<ResSuspTimeLmt>();
		for (Object flight : flights) {
			resSuspTimeLmt.add((ResSuspTimeLmt) flight);
		}
		PreparedStatement stmt = null;
		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResSuspTimeLmt.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the flight data to the batch for bulk insertion
		for (ResSuspTimeLmt suspTimeLmt : resSuspTimeLmt) {

			stmt.setString(1, suspTimeLmt.getID());
			stmt.setString(2, suspTimeLmt.getPNRLocatorID());
			stmt.setObject(3, suspTimeLmt.getPNRCreateDate(), Types.DATE);
			stmt.setObject(4, suspTimeLmt.getFromDateTime(), Types.TIMESTAMP);
			if (suspTimeLmt.getSuspenseSequenceId() == null) {
				stmt.setNull(12, Types.NULL);
			} else {
				stmt.setShort(5, suspTimeLmt.getSuspenseSequenceId());
			}
			stmt.setString(6, suspTimeLmt.getTimeLimitActionTime());
			stmt.setObject(7, suspTimeLmt.getTimeLimitActionDate(), Types.DATE);
			stmt.setString(8, suspTimeLmt.getTimeLimitLocationCode());
			stmt.setString(9, suspTimeLmt.getTimeLimitVendorCode());
			stmt.setString(10, suspTimeLmt.getHistoryActionCodeId());
			stmt.setObject(11, suspTimeLmt.getRecordUpdateDate(), Types.DATE);
			stmt.setObject(12, suspTimeLmt.getRecordUpdateTime(), Types.TIME);

			if (suspTimeLmt.getIntraPNRSetNbr() == null) {
				stmt.setNull(12, Types.NULL);
			} else {
				stmt.setShort(13, suspTimeLmt.getIntraPNRSetNbr());
			}
			stmt.setObject(14, utility.nowUtcTimestamp(), Types.TIMESTAMP);
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
		ArrayList<ResSuspTimeLmt> resSuspTimeLmt = new ArrayList<ResSuspTimeLmt>();
		for (Object flight : flights) {
			resSuspTimeLmt.add((ResSuspTimeLmt) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteResSuspTimeLmt.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the flight data to the batch for bulk insertion
		for (ResSuspTimeLmt res : resSuspTimeLmt) {
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