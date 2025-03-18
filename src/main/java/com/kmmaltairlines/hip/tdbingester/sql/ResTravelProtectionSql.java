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
import com.kmmaltairlines.hip.tdbingester.filepojos.ResTravelProtection;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("ResTravelProtectionSql")
public class ResTravelProtectionSql implements MethodInterface {

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(ResTravelProtectionSql.class);

	/**
	 * Inserts a list of ResTravelProtection records into the database in bulk.
	 * 
	 * @param resTravelProtections - List of ResTravelProtection objects to be
	 *                             inserted
	 * @param connection           - Database connection object
	 * @throws SQLException - If a database error occurs
	 * @throws IOException  - If an error occurs while reading SQL files
	 */
	@Override
	@Transactional
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		// Establish database connection
		ArrayList<ResTravelProtection> resTravelProtections = new ArrayList<ResTravelProtection>();
		for (Object flight : flights) {
			resTravelProtections.add((ResTravelProtection) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResTravelProtection.sql");

		// Prepare the SQL statement
		stmt = connection.prepareStatement(sql);

		// Add ResTravelProtection data to the batch for bulk insertion
		for (ResTravelProtection protection : resTravelProtections) {
			stmt.setString(1, protection.getID());
			stmt.setString(2, protection.getPNRLocatorID());
			stmt.setDate(3, protection.getPNRCreateDate());
			stmt.setTimestamp(4, protection.getFromDateTime());
			if (protection.getSegmentNbr() == null) {
				stmt.setNull(5, Types.NULL);
			} else {
				stmt.setShort(5, protection.getSegmentNbr());
			}

			stmt.setString(6, protection.getPlanTypeCode());
			stmt.setString(7, protection.getVendorCode());
			stmt.setDate(8, protection.getPurchaseDate());
			if (protection.getSegmentType() == null) {
				stmt.setNull(9, Types.NULL);
			} else {
				stmt.setShort(9, protection.getSegmentType());
			}

			stmt.setString(10, protection.getConfirmationNbr());
			stmt.setString(11, protection.getCurrentSegmentStatusCode());
			stmt.setDate(12, protection.getServiceStartDate());
			stmt.setDate(13, protection.getServiceEndDate());
			stmt.setString(14, protection.getServiceStartCityCode());
			stmt.setString(15, protection.getServiceEndCityCode());
			stmt.setString(16, protection.getFOPCode());
			stmt.setString(17, protection.getPaymentCreditCardCode());
			stmt.setString(18, protection.getPaymentCreditCardNbr());
			stmt.setDate(19, protection.getPaymentCreditCardExpDate());
			stmt.setString(20, protection.getCurrCode());
			stmt.setString(21, protection.getPremiumValue());
			stmt.setBigDecimal(22, protection.getPremiumAmt());
			stmt.setBigDecimal(23, protection.getPremiumAmtUSD());
			stmt.setDate(24, protection.getRecordUpdateDate());
			stmt.setTime(25, protection.getRecordUpdateTime());
			stmt.setString(26, protection.getHistoryActionCodeID());
			if (protection.getIntraPNRSetNbr() == null) {
				stmt.setNull(27, Types.NULL);
			} else {
				stmt.setShort(27, protection.getIntraPNRSetNbr());
			}

			stmt.setObject(28, utility.nowUtcTimestamp(), Types.TIMESTAMP);
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
		ArrayList<ResTravelProtection> resTravelProtections = new ArrayList<ResTravelProtection>();
		for (Object flight : flights) {
			resTravelProtections.add((ResTravelProtection) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteResTravelProtection.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the flight data to the batch for bulk insertion
		for (ResTravelProtection res : resTravelProtections) {
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
