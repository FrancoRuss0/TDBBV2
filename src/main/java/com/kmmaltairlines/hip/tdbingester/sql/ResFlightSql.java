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
import com.kmmaltairlines.hip.tdbingester.filepojos.ResFlight;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("ResFlightSql")
public class ResFlightSql implements MethodInterface {

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(ResFlightSql.class);

	/**
	 * Inserts ResFlight records into the database in bulk.
	 * 
	 * @param resFlights  - List of ResFlight objects to be inserted
	 * @param connessione - Connection object for the database connection
	 * @throws SQLException - If an error occurs while executing the SQL query
	 * @throws IOException  - If an error occurs while reading SQL files
	 */
	@Override
	@Transactional
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		// Establish database connection
		ArrayList<ResFlight> resFlights = new ArrayList<ResFlight>();
		for (Object flight : flights) {
			resFlights.add((ResFlight) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResFlight.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the ResFlight data to the batch for bulk insertion
		for (ResFlight flight : resFlights) {
			stmt.setString(1, flight.getID());
			stmt.setShort(2, flight.getSegmentNbr());
			stmt.setString(3, flight.getActiveSegmentInd());
			stmt.setString(4, flight.getCdshrLegInd());
			stmt.setString(5, flight.getClassOfService());
			stmt.setString(6, flight.getConnectivityCode());
			stmt.setShort(7, flight.getNbrInParty());
			stmt.setString(8, flight.getCurrentSegmentStatusCode());
			stmt.setString(9, flight.getPreviousSegmentStatusCode());
			stmt.setShort(10, flight.getSegmentTypeCode());
			stmt.setString(11, flight.getChangeSegmentStatusIndicator());
			stmt.setShort(12, flight.getEquipmentCode());
			stmt.setString(13, flight.getMarketingFlightNbr());
			stmt.setString(14, flight.getFlightNbr());
			stmt.setString(15, flight.getMarketingAirlineCode());
			stmt.setString(16, flight.getOperatingFlightNbr());
			stmt.setString(17, flight.getOperatingAirlineCode());
			stmt.setString(18, flight.getAirlineCode());
			stmt.setString(19, flight.getInboundFlightConnectionInd());
			stmt.setString(20, flight.getMarriedConxInboundFlightInd());
			stmt.setString(21, flight.getOutboundFlightConnectionInd());
			stmt.setString(22, flight.getMarriedConxOutboundFlightInd());
			stmt.setString(23, flight.getServiceStartCity());
			stmt.setDate(24, flight.getServiceStartDate());
			stmt.setTime(25, flight.getServiceStartTime());
			stmt.setString(26, flight.getServiceEndCity());
			stmt.setDate(27, flight.getServiceEndDate());
			stmt.setTime(28, flight.getServiceEndTime());
			stmt.setString(29, flight.getPOSAgencyActualCityCode());
			stmt.setString(30, flight.getEquipmentCodeDescription());
			stmt.setString(31, flight.getPreReservedSeatIndicator());
			stmt.setString(32, flight.getConfirmationNbr());
			stmt.setString(33, flight.getFlightPOSAgentIATANbr());
			stmt.setString(34, flight.getHistoryActionCodeId());
			stmt.setDate(35, flight.getRecordUpdateDate());
			stmt.setTime(36, flight.getRecordUpdateTime());
			stmt.setShort(37, flight.getIntraPNRSetNbr());
			stmt.setDate(38, flight.getSegmentBookedDate());
			stmt.setTime(39, flight.getSegmentBookedTime());
			stmt.setShort(40, flight.getOpenFlightSegmentIndicator());
			stmt.setString(41, flight.getSegmentActivityCode());
			stmt.setString(42, flight.getBSGMSTRPNRLocatorID());
			stmt.setDate(43, flight.getBSGMSTRPNRCreateDate());
			stmt.setShort(44, flight.getNewMarriedConxGroupNbr());
			stmt.setShort(45, flight.getNewMarriedConxSeqNbr());
			stmt.setString(46, flight.getNewMarriedConxOutOfSeqInd());
			stmt.setString(47, flight.getMarketingClassOfService());
			stmt.setString(48, flight.getOperatingClassOfService());
			stmt.setString(49, flight.getIATAEquipCode());
			stmt.setString(50, flight.getIATAEquipDesc());
			stmt.setString(51, flight.getOperatingAirlnLocatorID());

			// Add to batch
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
		ArrayList<ResFlight> resFlights = new ArrayList<ResFlight>();
		for (Object flight : flights) {
			resFlights.add((ResFlight) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteResFlight.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the flight data to the batch for bulk insertion
		for (ResFlight res : resFlights) {
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
