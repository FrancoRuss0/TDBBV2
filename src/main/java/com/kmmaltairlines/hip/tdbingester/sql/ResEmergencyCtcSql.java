package com.kmmaltairlines.hip.tdbingester.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kmmaltairlines.hip.tdbingester.filepojos.Res;
import com.kmmaltairlines.hip.tdbingester.filepojos.ResEmergencyCtc;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("ResEmergencyCtcSql")
public class ResEmergencyCtcSql implements MethodInterface {

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(ResEmergencyCtcSql.class);

	/**
	 * Inserts ResEmergencyCtc records into the database in bulk.
	 * 
	 * @param resEmergencyCtc - List of ResEmergencyCtc objects to be inserted
	 * @param connessione     - Connection object for the database connection
	 * @throws SQLException - If an error occurs while executing the SQL query
	 * @throws IOException  - If an error occurs while reading SQL files
	 */
	@Override
	@Transactional
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		// Establish database connection
		ArrayList<ResEmergencyCtc> resEmergencyCtc = new ArrayList<ResEmergencyCtc>();
		for (Object flight : flights) {
			resEmergencyCtc.add((ResEmergencyCtc) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResEmergencyCtc.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the ResEmergencyCtc data to the batch for bulk insertion
		for (ResEmergencyCtc emergencyCtc : resEmergencyCtc) {
			stmt.setString(1, emergencyCtc.getID());
			stmt.setShort(2, emergencyCtc.getPNRPassengerSeqId());
			stmt.setString(3, emergencyCtc.getSourceTypeCode());
			stmt.setString(4, emergencyCtc.getSSRIdTypeCode());
			stmt.setString(5, emergencyCtc.getSSRStatusCode());
			stmt.setString(6, emergencyCtc.getSSRCode());
			stmt.setShort(7, emergencyCtc.getEmergencyContactSeqId());
			stmt.setString(8, emergencyCtc.getEmergencyPhoneNumber());
			stmt.setString(9, emergencyCtc.getEmergencyContactName());
			stmt.setString(10, emergencyCtc.getCountryCode());
			stmt.setString(11, emergencyCtc.getVendorCode());
			stmt.setString(12, emergencyCtc.getSSRText());
			stmt.setString(13, emergencyCtc.getHistoryActionCodeId());
			stmt.setDate(14, emergencyCtc.getRecordUpdateDate());
			stmt.setTime(15, emergencyCtc.getRecordUpdateTime());
			stmt.setShort(16, emergencyCtc.getIntraPNRSetNbr());
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
		// Establish database connection
				ArrayList<ResEmergencyCtc> resEmergencyCtc = new ArrayList<ResEmergencyCtc>();
				for (Object flight : flights) {
					resEmergencyCtc.add((ResEmergencyCtc) flight);
				}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteResEmergencyCtc.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the flight data to the batch for bulk insertion
		for (ResEmergencyCtc res : resEmergencyCtc) {
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
