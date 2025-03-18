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
import com.kmmaltairlines.hip.tdbingester.filepojos.TktTaxDetail;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("TktTaxDetailSql")
public class TktTaxDetailSql implements MethodInterface {

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(TktTaxDetailSql.class);

	@Override
	@Transactional
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {

		ArrayList<TktTaxDetail> tktTaxDetails = new ArrayList<TktTaxDetail>();
		for (Object flight : flights) {
			tktTaxDetails.add((TktTaxDetail) flight);
		}

		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertTktTaxDetail.sql");

		// Prepare the SQL statement
		stmt = connection.prepareStatement(sql);

		// Add TktCouponHistory data to the batch for bulk insertion
		for (TktTaxDetail taxDetails : tktTaxDetails) {
			stmt.setString(1, taxDetails.getID());
			stmt.setString(2, taxDetails.getPNRLocatorID());
			stmt.setDate(3, taxDetails.getPNRCreateDate());
			stmt.setString(4, taxDetails.getPrimaryDocNbr());
			stmt.setDate(5, taxDetails.getVCRCreateDate());
			stmt.setTimestamp(6, taxDetails.getTransactionDateTime());
			stmt.setByte(7, taxDetails.getTaxSeqNbr());
			stmt.setBigDecimal(8, taxDetails.getTaxAmt());
			stmt.setString(9, taxDetails.getTaxCode());
			stmt.setShort(10, taxDetails.getLocationTypeCode());
			stmt.setString(11, taxDetails.getServiceCityCode());
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
		ArrayList<TktTaxDetail> tktTaxDetails = new ArrayList<TktTaxDetail>();
		for (Object flight : flights) {
			tktTaxDetails.add((TktTaxDetail) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteTktTaxDetail.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the flight data to the batch for bulk insertion
		for (TktTaxDetail res : tktTaxDetails) {
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
