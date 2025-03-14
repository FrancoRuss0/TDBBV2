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
import com.kmmaltairlines.hip.tdbingester.filepojos.ResAirExtraPortionofTravel;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("ResAirExtraPortionofTravelSql")
public class ResAirExtraPortionofTravelSql implements MethodInterface {

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(ResAirExtraPortionofTravelSql.class);

	/**
	 * Inserts ACSFlight records into the database in bulk.
	 * 
	 * @param flights - List of ACSFlight objects to be inserted
	 * @throws SQLException - If an error occurs while executing the SQL query
	 * @throws IOException  - If an error occurs while reading SQL files
	 */
	@Override
	@Transactional
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		// Establish database connection
		ArrayList<ResAirExtraPortionofTravel> resAirExtraPortionofTravel = new ArrayList<ResAirExtraPortionofTravel>();
		for (Object flight : flights) {
			resAirExtraPortionofTravel.add((ResAirExtraPortionofTravel) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResAirExtraPortionofTravel.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the flight data to the batch for bulk insertion
		for (ResAirExtraPortionofTravel airExtraPortion : resAirExtraPortionofTravel) {

			stmt.setString(1, airExtraPortion.getID());
			stmt.setString(2, airExtraPortion.getPNRLocatorID());
			stmt.setDate(3, airExtraPortion.getPNRCreateDate());
			stmt.setInt(4, airExtraPortion.getIntraPNRSetNbr());
			stmt.setTimestamp(5, airExtraPortion.getFromDateTime());
			stmt.setTimestamp(6, airExtraPortion.getTransmissionDateTime());
			stmt.setInt(7, airExtraPortion.getUniqueComponentID());
			stmt.setByte(8, airExtraPortion.getAEPortionSeqNbr());
			stmt.setInt(9, airExtraPortion.getPNRPassengerSeqID());
			stmt.setString(10, airExtraPortion.getAirlineCode());
			stmt.setString(11, airExtraPortion.getFlightNbr());
			stmt.setString(12, airExtraPortion.getClassofService());
			stmt.setDate(13, airExtraPortion.getServiceStartDate());
			stmt.setString(14, airExtraPortion.getServiceStartCity());
			stmt.setString(15, airExtraPortion.getServiceEndCity());
			stmt.setString(16, airExtraPortion.getEMDNbr());
			if (airExtraPortion.getEmdCouponNbr() == null) {
				stmt.setNull(17, Types.NULL);
			} else {
				stmt.setShort(17, airExtraPortion.getEmdCouponNbr());
			}
			stmt.setString(18, airExtraPortion.getETicketNbr());
			if (airExtraPortion.getETicketCpnNbr() == null) {
				stmt.setNull(19, Types.NULL);
			} else {
				stmt.setShort(19, airExtraPortion.getETicketCpnNbr());
			}
			stmt.setDate(20, airExtraPortion.getRecordUpdateDate());
			stmt.setTimestamp(21, airExtraPortion.getRecordUpdateDateTime());
			stmt.setString(22, airExtraPortion.getMarketingCarrierCode());
			stmt.setString(23, airExtraPortion.getOpertatingCarrierCode());
			stmt.setString(24, airExtraPortion.getSourceSystemID());
			stmt.setObject(25, utility.nowUtcTimestamp(), Types.TIMESTAMP);
			stmt.executeUpdate();
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
		ArrayList<ResAirExtraPortionofTravel> resAirExtraPortionofTravel = new ArrayList<ResAirExtraPortionofTravel>();
		for (Object flight : flights) {
			resAirExtraPortionofTravel.add((ResAirExtraPortionofTravel) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteResAirExtraPortionofTravel.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the flight data to the batch for bulk insertion
		for (ResAirExtraPortionofTravel res : resAirExtraPortionofTravel) {
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
