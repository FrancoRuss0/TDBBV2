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
import com.kmmaltairlines.hip.tdbingester.filepojos.TktRemark;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("TktRemarkSql")
public class TktRemarkSql implements MethodInterface {

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(TktRemarkSql.class);

	@Override
	@Transactional
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {

		ArrayList<TktRemark> tktRemarks = new ArrayList<TktRemark>();
		for (Object flight : flights) {
			tktRemarks.add((TktRemark) flight);
		}

		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertTktRemark.sql");

		// Prepare the SQL statement
		stmt = connection.prepareStatement(sql);

		// Add TktCouponHistory data to the batch for bulk insertion
		for (TktRemark remark : tktRemarks) {
			stmt.setString(1, remark.getID());
			stmt.setString(2, remark.getPNRLocatorID());
			stmt.setDate(3, remark.getPNRCreateDate());
			stmt.setString(4, remark.getPrimaryDocNbr());
			stmt.setDate(5, remark.getVCRCreateDate());
			stmt.setTimestamp(6, remark.getTransactionDateTime());
			stmt.setShort(7, remark.getRemarkSeqNbr());
			stmt.setString(8, remark.getRemarkTxt());
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
		ArrayList<TktRemark> tktRemarks = new ArrayList<TktRemark>();
		for (Object flight : flights) {
			tktRemarks.add((TktRemark) flight);
		}

		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteTktRemark.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the flight data to the batch for bulk insertion
		for (TktRemark res : tktRemarks) {
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
