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
import com.kmmaltairlines.hip.tdbingester.filepojos.ResRemarks;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("ResRemarksSql")
public class ResRemarksSql implements MethodInterface {

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(ResRemarksSql.class);

	/**
	 * Inserts a list of ResRemarks records into the database in bulk.
	 * 
	 * @param resRemarks - List of ResRemarks objects to be inserted
	 * @param connection - Database connection object
	 * @throws SQLException - If a database error occurs
	 * @throws IOException  - If an error occurs while reading SQL files
	 */
	@Override
	@Transactional
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		// Establish database connection
		ArrayList<ResRemarks> resRemarks = new ArrayList<ResRemarks>();
		for (Object flight : flights) {
			resRemarks.add((ResRemarks) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResRemarks.sql");

		// Prepare the SQL statement
		stmt = connection.prepareStatement(sql);

		// Add ResRemarks data to the batch for bulk insertion
		for (ResRemarks remark : resRemarks) {
			stmt.setString(1, remark.getID());
			stmt.setString(2, remark.getPNRLocatorID());
			stmt.setDate(3, remark.getPNRCreateDate());
			stmt.setTimestamp(4, remark.getFromDateTime());
			stmt.setShort(5, remark.getResRemarkSeqId());
			stmt.setString(6, remark.getRemarkText());
			stmt.setShort(7, remark.getRemarkType());
			stmt.setString(8, remark.getHistoryActionCodeId());
			stmt.setDate(9, remark.getRecordUpdateDate());
			stmt.setTime(10, remark.getRecordUpdateTime());
			stmt.setShort(11, remark.getIntraPNRSetNbr());
			stmt.setObject(12, utility.nowUtcTimestamp(), Types.TIMESTAMP);
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
		ArrayList<ResRemarks> resRemarks = new ArrayList<ResRemarks>();
		for (Object flight : flights) {
			resRemarks.add((ResRemarks) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteResRemarks.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the flight data to the batch for bulk insertion
		for (ResRemarks res : resRemarks) {
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
