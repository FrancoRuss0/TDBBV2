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
			stmt.setString(2, flight.getPNRLocatorID());
			stmt.setDate(3, flight.getPNRCreateDate());
			stmt.setTimestamp(4, flight.getFromDateTime());
			if (flight.getSegmentNbr() == null) {
				stmt.setNull(5, Types.NULL);
			} else {
				stmt.setShort(5, flight.getSegmentNbr());
			}

			stmt.setString(6, flight.getActiveSegmentInd());
			stmt.setString(7, flight.getCdshrLegInd());
			stmt.setString(8, flight.getClassOfService());
			stmt.setString(9, flight.getConnectivityCode());
			if (flight.getNbrInParty() == null) {
				stmt.setNull(10, Types.NULL);
			} else {
				stmt.setShort(10, flight.getNbrInParty());
			}

			stmt.setString(11, flight.getCurrentSegmentStatusCode());
			stmt.setString(12, flight.getPreviousSegmentStatusCode());
			if (flight.getSegmentTypeCode() == null) {
				stmt.setNull(13, Types.NULL);
			} else {
				stmt.setShort(13, flight.getSegmentTypeCode());
			}

			stmt.setString(14, flight.getChangeSegmentStatusIndicator());
			if (flight.getEquipmentCode() == null) {
				stmt.setNull(15, Types.NULL);
			} else {
				stmt.setShort(15, flight.getEquipmentCode());
			}

			stmt.setString(16, flight.getMarketingFlightNbr());
			stmt.setString(17, flight.getFlightNbr());
			stmt.setString(18, flight.getMarketingAirlineCode());
			stmt.setString(19, flight.getOperatingFlightNbr());
			stmt.setString(20, flight.getOperatingAirlineCode());
			stmt.setString(21, flight.getAirlineCode());
			stmt.setString(22, flight.getInboundFlightConnectionInd());
			stmt.setString(23, flight.getMarriedConxInboundFlightInd());
			stmt.setString(24, flight.getOutboundFlightConnectionInd());
			stmt.setString(25, flight.getMarriedConxOutboundFlightInd());
			stmt.setString(26, flight.getServiceStartCity());
			stmt.setDate(27, flight.getServiceStartDate());
			stmt.setTime(28, flight.getServiceStartTime());
			stmt.setString(29, flight.getServiceEndCity());
			stmt.setDate(30, flight.getServiceEndDate());
			stmt.setTime(31, flight.getServiceEndTime());
			stmt.setString(32, flight.getPOSAgencyActualCityCode());
			stmt.setString(33, flight.getEquipmentCodeDescription());
			stmt.setString(34, flight.getPreReservedSeatIndicator());
			stmt.setString(35, flight.getConfirmationNbr());
			stmt.setString(36, flight.getFlightPOSAgentIATANbr());
			stmt.setString(37, flight.getHistoryActionCodeId());
			stmt.setDate(38, flight.getRecordUpdateDate());
			stmt.setTime(39, flight.getRecordUpdateTime());
			if (flight.getIntraPNRSetNbr() == null) {
				stmt.setNull(40, Types.NULL);
			} else {
				stmt.setShort(40, flight.getIntraPNRSetNbr());
			}

			stmt.setDate(41, flight.getSegmentBookedDate());
			stmt.setTime(42, flight.getSegmentBookedTime());
			if (flight.getOpenFlightSegmentIndicator() == null) {
				stmt.setNull(43, Types.NULL);
			} else {
				stmt.setShort(43, flight.getOpenFlightSegmentIndicator());
			}

			stmt.setString(44, flight.getSegmentActivityCode());
			stmt.setString(45, flight.getBSGMSTRPNRLocatorID());
			stmt.setDate(46, flight.getBSGMSTRPNRCreateDate());
			if (flight.getNewMarriedConxGroupNbr() == null) {
				stmt.setNull(47, Types.NULL);
			} else {
				stmt.setShort(47, flight.getNewMarriedConxGroupNbr());
			}

			if (flight.getNewMarriedConxSeqNbr() == null) {
				stmt.setNull(48, Types.NULL);
			} else {
				stmt.setShort(48, flight.getNewMarriedConxSeqNbr());
			}

			stmt.setString(49, flight.getNewMarriedConxOutOfSeqInd());
			stmt.setString(50, flight.getMarketingClassOfService());
			stmt.setString(51, flight.getOperatingClassOfService());
			stmt.setString(52, flight.getIATAEquipCode());
			stmt.setString(53, flight.getIATAEquipDesc());
			stmt.setString(54, flight.getOperatingAirlnLocatorID());
			stmt.setObject(55, utility.nowUtcTimestamp(), Types.TIMESTAMP);
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
