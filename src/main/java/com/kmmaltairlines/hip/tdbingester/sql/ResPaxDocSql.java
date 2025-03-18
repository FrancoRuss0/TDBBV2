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
import com.kmmaltairlines.hip.tdbingester.filepojos.ResPaxDoc;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("ResPaxDocSql")
public class ResPaxDocSql implements MethodInterface {

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(ResPaxDocSql.class);

	/**
	 * Inserts a list of ResPaxDoc records into the database in bulk.
	 *
	 * @param resPaxDocs - List of ResPaxDoc objects to be inserted.
	 * @param connection - Database connection object.
	 * @throws SQLException - If an error occurs while executing the SQL query.
	 * @throws IOException  - If an error occurs while reading the SQL file.
	 */
	@Override
	@Transactional
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		// Establish database connection
		ArrayList<ResPaxDoc> resPaxDocs = new ArrayList<ResPaxDoc>();
		for (Object flight : flights) {
			resPaxDocs.add((ResPaxDoc) flight);
		}

		PreparedStatement stmt = null;

		// Load the SQL insert query from a file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResPaxDoc.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add each ResPaxDoc record to the batch
		for (ResPaxDoc paxDoc : resPaxDocs) {
			stmt.setString(1, paxDoc.getID());
			stmt.setString(2, paxDoc.getPNRLocatorID());
			stmt.setDate(3, paxDoc.getPNRCreateDate());
			stmt.setTimestamp(4, paxDoc.getFromDateTime());
			stmt.setShort(5, paxDoc.getPassengerDocSeqId());
			stmt.setShort(6, paxDoc.getPNRPassengerSeqId());
			stmt.setDate(7, paxDoc.getDocBirthdate());
			stmt.setString(8, paxDoc.getDocNumber());
			stmt.setString(9, paxDoc.getDocTypeCode());
			stmt.setString(10, paxDoc.getGenderCode());
			stmt.setString(11, paxDoc.getInfantInd());
			stmt.setString(12, paxDoc.getIssueCountryCode());
			stmt.setString(13, paxDoc.getPassengerFirstName());
			stmt.setString(14, paxDoc.getPassengerSecondName());
			stmt.setString(15, paxDoc.getPassengerLastName());
			stmt.setString(16, paxDoc.getPrimaryDocHolderInd());
			stmt.setString(17, paxDoc.getPrimaryDocHolderFirstName());
			stmt.setString(18, paxDoc.getPrimaryDocHolderLastName());
			stmt.setString(19, paxDoc.getSourceTypeCode());
			stmt.setString(20, paxDoc.getSSRCode());
			stmt.setString(21, paxDoc.getSSRIdTypeCode());
			stmt.setShort(22, paxDoc.getSSRNumberInParty());
			stmt.setString(23, paxDoc.getSSRStatusCode());
			stmt.setString(24, paxDoc.getSSRText());
			stmt.setString(25, paxDoc.getVendorCode());
			stmt.setString(26, paxDoc.getHistoryActionCodeId());
			stmt.setDate(27, paxDoc.getRecordUpdateDate());
			stmt.setTime(28, paxDoc.getRecordUpdateTime());
			stmt.setShort(29, paxDoc.getIntraPNRSetNbr());
			stmt.setDate(30, paxDoc.getDocIssueDate());
			stmt.setDate(31, paxDoc.getDocExpDate());
			stmt.setObject(32, utility.nowUtcTimestamp(), Types.TIMESTAMP);
			stmt.addBatch(); // Add to batch
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
		ArrayList<ResPaxDoc> resPaxDocs = new ArrayList<ResPaxDoc>();
		for (Object flight : flights) {
			resPaxDocs.add((ResPaxDoc) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteResPaxDoc.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the flight data to the batch for bulk insertion
		for (ResPaxDoc res : resPaxDocs) {
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
