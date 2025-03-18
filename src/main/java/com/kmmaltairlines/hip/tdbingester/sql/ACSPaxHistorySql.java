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

import com.kmmaltairlines.hip.tdbingester.filepojos.ACSPaxHistory;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.OneIteration;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component
public class ACSPaxHistorySql implements MethodInterface {
	@Autowired
	private Utility utility;

	private static final Logger logger = LogManager.getLogger(ACSPaxHistorySql.class);

	@Override
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		ArrayList<ACSPaxHistory> trasformACSPaxHistory = new ArrayList<ACSPaxHistory>();
		for (Object flight : flights) {
			trasformACSPaxHistory.add((ACSPaxHistory) flight);
		}
		PreparedStatement stmt = null;
		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertACSPaxHistory.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Disable auto-commit for batch processing

		// Add the flight data to the batch for bulk insertion
		for (ACSPaxHistory flight : trasformACSPaxHistory) {
			stmt.setString(1, flight.getSourceSystemID());
			stmt.setDate(2, flight.getACSFltSegDate());
			stmt.setString(3, flight.getAirlineCode());
			stmt.setString(4, flight.getFltNbr());
			stmt.setString(5, flight.getAirlineOrigAirport());
			stmt.setString(6, flight.getPNRLocatorId());
			stmt.setString(7, flight.getNameLast());
			stmt.setString(8, flight.getNameFirst());
			stmt.setString(9, flight.getAirlineDestAirport());
			stmt.setDate(10, flight.getSchdServiceStartDate());
			stmt.setTime(11, flight.getSchdServiceStartTime());
			stmt.setString(12, flight.getAAACityCode());
			stmt.setString(13, flight.getAgentSine());
			stmt.setDate(14, flight.getActionDate());
			stmt.setTime(15, flight.getActionTime());
			stmt.setString(16, flight.getAgntStationLNIATA());
			stmt.setString(17, flight.getActionItem());
			stmt.setString(18, flight.getSeatLtr());
			stmt.setString(19, flight.getSeatNbr());
			stmt.setString(20, flight.getNbrOfBags());
			stmt.setString(21, flight.getEditCode());
			stmt.setString(22, flight.getAgntDtyCd());
			stmt.setString(23, flight.getAgntHomeStation());
			stmt.setShort(24, flight.getPaxID());
			stmt.setShort(25, flight.getItinID());
			stmt.setString(26, flight.getPrevSeatNbr());
			stmt.setString(27, flight.getPrevSeatLtr());
			stmt.setString(28, flight.getOnBoardStatus());
			stmt.setString(29, flight.getBPIssueStatus());
			stmt.setString(30, flight.getBPReprintedStatus());
			stmt.setString(31, flight.getBagTagInd());
			stmt.setTimestamp(32, flight.getMsgCreateDateTime());
			stmt.setString(33, flight.getPrev_BagTagInd());
			stmt.setString(34, flight.getPrev_OnBoardStatus());
			stmt.setString(35, flight.getPrev_BPIssueStatus());
			stmt.setString(36, flight.getPrev_BPReprintedStatus());
			stmt.setObject(37, utility.nowUtcTimestamp(), Types.TIMESTAMP);
			// Add the statement to the batch
			stmt.addBatch();
		}

		// Execute the batch insert
		int[] results = stmt.executeBatch();

		logger.info("Bulk insert completed successfully. " + results.length + " records inserted.");
		stmt.close();
	}

	@Override
	public String delete(List<Object> flights, Connection connection) throws SQLException, IOException {
		return null;
		// TODO Auto-generated method stub

	}

}
