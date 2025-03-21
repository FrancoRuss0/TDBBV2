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
import com.kmmaltairlines.hip.tdbingester.filepojos.ResTravelArranger;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("ResTravelArrangerSql")
public class ResTravelArrangerSql implements MethodInterface {

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(ResTravelArrangerSql.class);

	/**
	 * Inserts a list of ResTravelArranger records into the database in bulk.
	 * 
	 * @param resTravelArrangers - List of ResTravelArranger objects to be inserted
	 * @param connection         - Database connection object
	 * @throws SQLException - If a database error occurs
	 * @throws IOException  - If an error occurs while reading SQL files
	 */
	@Override
	@Transactional
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		// Establish database connection
		ArrayList<ResTravelArranger> resTravelArrangers = new ArrayList<ResTravelArranger>();
		for (Object flight : flights) {
			resTravelArrangers.add((ResTravelArranger) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResTravelArranger.sql");

		// Prepare the SQL statement
		stmt = connection.prepareStatement(sql);

		// Add ResTravelArranger data to the batch for bulk insertion
		for (ResTravelArranger arranger : resTravelArrangers) {
			stmt.setString(1, arranger.getID());
			stmt.setString(2, arranger.getPNRLocatorID());
			stmt.setDate(3, arranger.getPNRCreateDate());
			stmt.setTimestamp(4, arranger.getFromDateTime());
			stmt.setString(5, arranger.getSignatureType());
			stmt.setString(6, arranger.getUpdateAAACityCode());
			stmt.setString(7, arranger.getUpdateAgentDutyCode());
			stmt.setString(8, arranger.getUpdateAgentSine());
			stmt.setString(9, arranger.getUpdateBookingCRSCode());
			stmt.setString(10, arranger.getUpdateHomeCityCode());
			stmt.setDate(11, arranger.getRecordUpdateDate());
			stmt.setTime(12, arranger.getRecordUpdateTime());
			stmt.setShort(13, arranger.getIntraPNRSetNbr());
			stmt.setString(14, arranger.getReceivedFrom());
			stmt.setString(15, arranger.getUpdateAAAOACCityCode());
			stmt.setString(16, arranger.getUpdateAAAOACAcctCode());
			stmt.setString(17, arranger.getOACDefaultPartitionCode());
			stmt.setString(18, arranger.getOACCityCode());
			stmt.setString(19, arranger.getOACAcctCode());
			stmt.setString(20, arranger.getOACStationNbr());
			stmt.setObject(21, utility.nowUtcTimestamp(), Types.TIMESTAMP);
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
		ArrayList<ResTravelArranger> resTravelArrangers = new ArrayList<ResTravelArranger>();
		for (Object flight : flights) {
			resTravelArrangers.add((ResTravelArranger) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteResTravelArranger.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the flight data to the batch for bulk insertion
		for (ResTravelArranger res : resTravelArrangers) {
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
