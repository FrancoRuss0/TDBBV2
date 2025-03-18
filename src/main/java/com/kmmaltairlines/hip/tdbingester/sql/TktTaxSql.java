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
import com.kmmaltairlines.hip.tdbingester.filepojos.TktTax;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("TktTaxSql")
public class TktTaxSql implements MethodInterface {

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(TktTaxSql.class);

	@Override
	@Transactional
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {

		ArrayList<TktTax> tktTaxes = new ArrayList<TktTax>();
		for (Object flight : flights) {
			tktTaxes.add((TktTax) flight);
		}

		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertTktTax.sql");

		// Prepare the SQL statement
		stmt = connection.prepareStatement(sql);

		// Add TktCouponHistory data to the batch for bulk insertion
		for (TktTax tax : tktTaxes) {
			stmt.setString(1, tax.getID());
			stmt.setString(2, tax.getPNRLocatorID());
			stmt.setDate(3, tax.getPNRCreateDate());
			stmt.setString(4, tax.getPrimaryDocNbr());
			stmt.setDate(5, tax.getVCRCreateDate());
			stmt.setTimestamp(6, tax.getTransactionDateTime());
			stmt.setByte(7, tax.getTaxSeqNbr());
			stmt.setBigDecimal(8, tax.getTaxAmt());
			stmt.setString(9, tax.getTaxCode());
			stmt.setString(10, tax.getTaxTypeCode());
			stmt.setString(11, tax.getTaxCategoryCode());
			stmt.setString(12, tax.getTaxCurrCode());
			stmt.setObject(13, utility.nowUtcTimestamp(), Types.TIMESTAMP);

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
		ArrayList<TktTax> tktTaxes = new ArrayList<TktTax>();
		for (Object flight : flights) {
			tktTaxes.add((TktTax) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteTktTax.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the flight data to the batch for bulk insertion
		for (TktTax res : tktTaxes) {
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
