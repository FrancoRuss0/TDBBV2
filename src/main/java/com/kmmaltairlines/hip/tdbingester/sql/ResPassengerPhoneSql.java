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
import com.kmmaltairlines.hip.tdbingester.filepojos.ResPassengerPhone;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("ResPassengerPhoneSql")
public class ResPassengerPhoneSql implements MethodInterface {

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(ResPassengerPhoneSql.class);

	/**
	 * Inserts ResPassengerPhone records into the database in bulk.
	 * 
	 * @param resPassengerPhones - List of ResPassengerPhone objects to be inserted
	 * @param connessione        - Connection object for the database connection
	 * @throws SQLException - If an error occurs while executing the SQL query
	 * @throws IOException  - If an error occurs while reading SQL files
	 */
	@Override
	@Transactional
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		// Establish database connection
		ArrayList<ResPassengerPhone> resPassengerPhones = new ArrayList<ResPassengerPhone>();
		for (Object flight : flights) {
			resPassengerPhones.add((ResPassengerPhone) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResPassengerPhone.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the ResPassengerFT data to the batch for bulk insertion
		for (ResPassengerPhone passengerPhone : resPassengerPhones) {
			stmt.setString(1, passengerPhone.getID());
			stmt.setString(2, passengerPhone.getPNRLocatorID());
			stmt.setDate(3, passengerPhone.getPNRCreateDate());
			stmt.setTimestamp(4, passengerPhone.getFromDateTime());
			stmt.setShort(5, passengerPhone.getPNRPassengerPhoneSeqId());
			stmt.setString(6, passengerPhone.getCityPhoneCode());
			stmt.setString(7, passengerPhone.getPhoneNbrText());
			stmt.setString(8, passengerPhone.getPhoneTypeCode());
			stmt.setString(9, passengerPhone.getHistoryActionCodeId());
			stmt.setDate(10, passengerPhone.getRecordUpdateDate());
			stmt.setTime(11, passengerPhone.getRecordUpdateTime());
			stmt.setShort(12, passengerPhone.getIntraPNRSetNbr());
			stmt.setObject(13, utility.nowUtcTimestamp(), Types.TIMESTAMP);
			stmt.addBatch(); // Aggiunge il record al batch
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
		ArrayList<ResPassengerPhone> resPassengerPhones = new ArrayList<ResPassengerPhone>();
		for (Object flight : flights) {
			resPassengerPhones.add((ResPassengerPhone) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteResPassengerPhone.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the flight data to the batch for bulk insertion
		for (ResPassengerPhone res : resPassengerPhones) {
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
