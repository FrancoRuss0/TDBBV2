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
import com.kmmaltairlines.hip.tdbingester.filepojos.ResAirExtraTax;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("ResAirExtraTaxSql")
public class ResAirExtraTaxSql implements MethodInterface {

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(ResAirExtraTaxSql.class);

	/**
	 * Inserts ResAirExtraTax records into the database in bulk.
	 * 
	 * @param resAirExtraTax - List of ResAirExtraTax objects to be inserted
	 * @param connessione    - Connection object for the database connection
	 * @throws SQLException - If an error occurs while executing the SQL query
	 * @throws IOException  - If an error occurs while reading SQL files
	 */
	@Override
	@Transactional
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		ArrayList<ResAirExtraTax> resAirExtraTax = new ArrayList<ResAirExtraTax>();
		for (Object flight : flights) {
			resAirExtraTax.add((ResAirExtraTax) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResAirExtraTax.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the ResAirExtraTax data to the batch for bulk insertion
		for (ResAirExtraTax airExtraTax : resAirExtraTax) {
			stmt.setString(1, airExtraTax.getID());
			stmt.setString(2, airExtraTax.getPNRLocatorID());
			stmt.setDate(3, airExtraTax.getPNRCreateDate());
			stmt.setTimestamp(4, airExtraTax.getFromDateTime());
			stmt.setByte(5, airExtraTax.getAETaxSeqNbr());
			stmt.setShort(6, airExtraTax.getPNRPassengerSeqId());
			stmt.setString(7, airExtraTax.getRFISubCode());
			stmt.setString(8, airExtraTax.getTaxCode());
			stmt.setBigDecimal(9, airExtraTax.getTaxAmount());
			stmt.setDate(10, airExtraTax.getRecordUpdateDate());
			stmt.setTime(11, airExtraTax.getRecordUpdateTime());
			stmt.setShort(12, airExtraTax.getIntraPNRSetNbr());
			stmt.setObject(13, utility.nowUtcTimestamp(), Types.TIMESTAMP);
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
		ArrayList<ResAirExtraTax> resAirExtraTax = new ArrayList<ResAirExtraTax>();
		for (Object flight : flights) {
			resAirExtraTax.add((ResAirExtraTax) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteResAirExtraTax.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the flight data to the batch for bulk insertion
		for (ResAirExtraTax res : resAirExtraTax) {
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
