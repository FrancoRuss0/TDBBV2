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

import com.kmmaltairlines.hip.tdbingester.filepojos.TktAddress;
import com.kmmaltairlines.hip.tdbingester.filepojos.TktDocument;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("TktAddressSql")
public class TktAddressSql implements MethodInterface {

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(TktAddressSql.class);

	/**
	 * Inserts a list of TktAddress records into the database in bulk.
	 * 
	 * @param tktAddresses - List of TktAddress objects to be inserted
	 * @param connection   - Database connection object
	 * @throws SQLException - If a database error occurs
	 * @throws IOException  - If an error occurs while reading SQL files
	 */
	@Override
	@Transactional
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {

		ArrayList<TktAddress> tktTktAddress = new ArrayList<TktAddress>();
		for (Object flight : flights) {
			tktTktAddress.add((TktAddress) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertTktAddress.sql");

		// Prepare the SQL statement
		stmt = connection.prepareStatement(sql);

		// Add TktAddress data to the batch for bulk insertion
		for (TktAddress address : tktTktAddress) {
			stmt.setString(1, address.getID());
			stmt.setString(2, address.getPNRLocatorID());
			stmt.setDate(3, address.getPNRCreateDate());
			stmt.setString(4, address.getPrimaryDocNbr());
			stmt.setDate(5, address.getVCRCreateDate());
			stmt.setTimestamp(6, address.getTransactionDateTime());
			stmt.setShort(7, address.getAddrSeqNbr());
			stmt.setString(8, address.getAddrTxt());
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
		ArrayList<TktAddress> tktTktAddress = new ArrayList<TktAddress>();
		for (Object flight : flights) {
			tktTktAddress.add((TktAddress) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteTktAddress.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the flight data to the batch for bulk insertion
		for (TktAddress res : tktTktAddress) {
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
