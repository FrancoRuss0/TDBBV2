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
import com.kmmaltairlines.hip.tdbingester.filepojos.ResSSR;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("ResSSRSql")
public class ResSSRSql implements MethodInterface {

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(ResSSRSql.class);

	/**
	 * Inserts a list of ResSSR records into the database in bulk.
	 * 
	 * @param resSSRs    - List of ResSSR objects to be inserted
	 * @param connection - Database connection object
	 * @throws SQLException - If a database error occurs
	 * @throws IOException  - If an error occurs while reading SQL files
	 */
	@Override
	@Transactional
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		// Establish database connection
		ArrayList<ResSSR> resSSRs = new ArrayList<ResSSR>();
		for (Object flight : flights) {
			resSSRs.add((ResSSR) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResSSR.sql");

		// Prepare the SQL statement
		stmt = connection.prepareStatement(sql);

		// Add ResSSR data to the batch for bulk insertion
		for (ResSSR ssr : resSSRs) {
			stmt.setString(1, ssr.getID());
			stmt.setString(2, ssr.getPNRLocatorID());
			stmt.setDate(3, ssr.getPNRCreateDate());
			stmt.setTimestamp(4, ssr.getFromDateTime());
			stmt.setShort(5, ssr.getResSSRSeqId());
			stmt.setShort(6, ssr.getPNRPassengerSeqId());
			stmt.setString(7, ssr.getSourceTypeCode());
			stmt.setString(8, ssr.getSSRIdTypeCode());
			stmt.setString(9, ssr.getSSRStatusCode());
			stmt.setString(10, ssr.getSSRFlightNumber());
			stmt.setShort(11, ssr.getSSRNbrInParty());
			stmt.setDate(12, ssr.getSSRStartDate());
			stmt.setString(13, ssr.getVendorCode());
			stmt.setString(14, ssr.getSSRCode());
			stmt.setString(15, ssr.getSSRText());
			stmt.setString(16, ssr.getClassOfService());
			stmt.setString(17, ssr.getServiceStartCityCode());
			stmt.setString(18, ssr.getServiceEndCityCode());
			stmt.setString(19, ssr.getHistoryActionCodeId());
			stmt.setDate(20, ssr.getRecordUpdateDate());
			stmt.setTime(21, ssr.getRecordUpdateTime());
			stmt.setShort(22, ssr.getIntraPNRSetNbr());
			stmt.setObject(23, utility.nowUtcTimestamp(), Types.TIMESTAMP); 
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
		ArrayList<ResSSR> resSSRs = new ArrayList<ResSSR>();
		for (Object flight : flights) {
			resSSRs.add((ResSSR) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteResSSR.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the flight data to the batch for bulk insertion
		for (ResSSR res : resSSRs) {
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