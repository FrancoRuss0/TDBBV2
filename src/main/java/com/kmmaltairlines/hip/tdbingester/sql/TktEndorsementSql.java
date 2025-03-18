package com.kmmaltairlines.hip.tdbingester.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kmmaltairlines.hip.tdbingester.filepojos.TktDocument;
import com.kmmaltairlines.hip.tdbingester.filepojos.TktEndorsement;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("TktEndorsementSql")
public class TktEndorsementSql implements MethodInterface {

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(TktEndorsementSql.class);

	/**
	 * Inserts a list of TktCouponHistory records into the database in bulk.
	 * 
	 * @param tktCouponHistoryList - List of TktCouponHistory objects to be inserted
	 * @param connection           - Database connection object
	 * @throws SQLException - If a database error occurs
	 * @throws IOException  - If an error occurs while reading SQL files
	 */
	@Override
	@Transactional
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {

		ArrayList<TktEndorsement> tktEndorsements = new ArrayList<TktEndorsement>();
		for (Object flight : flights) {
			tktEndorsements.add((TktEndorsement) flight);
		}

		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertTktEndorsement.sql");

		// Prepare the SQL statement
		stmt = connection.prepareStatement(sql);

		// Add TktCouponHistory data to the batch for bulk insertion
		for (TktEndorsement endorsement : tktEndorsements) {
			stmt.setString(1, endorsement.getID());
			stmt.setString(2, endorsement.getPNRLocatorID());
			stmt.setDate(3, endorsement.getPNRCreateDate());
			stmt.setString(4, endorsement.getPrimaryDocNbr());
			stmt.setDate(5, endorsement.getVCRCreateDate());
			stmt.setTimestamp(6, endorsement.getTransactionDateTime());
			stmt.setInt(7, endorsement.getEndSeqNbr());
			stmt.setString(8, endorsement.getEndorsements());
			stmt.setObject(9, utility.nowUtcTimestamp(), Types.TIMESTAMP);
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
		ArrayList<TktEndorsement> tktEndorsements = new ArrayList<TktEndorsement>();
		for (Object flight : flights) {
			tktEndorsements.add((TktEndorsement) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteTktEndorsement.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the flight data to the batch for bulk insertion
		for (TktEndorsement res : tktEndorsements) {
			stmt.setString(1, res.getPrimaryDocNbr());
			stmt.setDate(2, res.getVCRCreateDate());
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
