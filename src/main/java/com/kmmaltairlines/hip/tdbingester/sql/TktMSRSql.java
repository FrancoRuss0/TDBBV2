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
import com.kmmaltairlines.hip.tdbingester.filepojos.TktMSR;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("TktMSRSql")
public class TktMSRSql implements MethodInterface {

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(TktMSRSql.class);

	@Override
	@Transactional
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {

		ArrayList<TktMSR> tktMSR = new ArrayList<TktMSR>();
		for (Object flight : flights) {
			tktMSR.add((TktMSR) flight);
		}

		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertTktMSR.sql");

		// Prepare the SQL statement
		stmt = connection.prepareStatement(sql);

		// Add TktCouponHistory data to the batch for bulk insertion
		for (TktMSR msr : tktMSR) {
			stmt.setString(1, msr.getID());
			stmt.setString(2, msr.getPNRLocatorID());
			stmt.setDate(3, msr.getPNRCreateDate());
			stmt.setString(4, msr.getPrimaryDocNbr());
			stmt.setDate(5, msr.getVCRCreateDate());
			stmt.setTimestamp(6, msr.getTransactionDateTime());
			stmt.setShort(7, msr.getMSRSeqNbr());
			stmt.setByte(8, msr.getMSRQuantitySoldCount());
			stmt.setString(9, msr.getMSRTypeCode());
			stmt.setString(10, msr.getMSRTypeDesc());
			stmt.setString(11, msr.getMSRCurrencyCode());
			stmt.setBigDecimal(12, msr.getMSRChargeAmount());
			stmt.setBigDecimal(13, msr.getMSRTaxAmount());
			stmt.setString(14, msr.getMSRTaxCurrencyCode());
			stmt.setString(15, msr.getSourceSystemId());
			stmt.setString(16, msr.getOCGroupCode());
			stmt.setString(17, msr.getRFISubCode());
			stmt.setObject(18, utility.nowUtcTimestamp(), Types.TIMESTAMP);

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
		ArrayList<TktMSR> tktMSR = new ArrayList<TktMSR>();
		for (Object flight : flights) {
			tktMSR.add((TktMSR) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteTktMSR.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the flight data to the batch for bulk insertion
		for (TktMSR res : tktMSR) {
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
