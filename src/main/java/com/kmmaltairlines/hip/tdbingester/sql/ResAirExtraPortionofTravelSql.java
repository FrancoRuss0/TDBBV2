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
			stmt.setInt(2, airExtraPortion.getIntraPNRSetNbr());
			stmt.setTimestamp(3, airExtraPortion.getTransmissionDateTime());
			stmt.setInt(4, airExtraPortion.getUniqueComponentID());
			stmt.setByte(5, airExtraPortion.getAEPortionSeqNbr());
			stmt.setInt(6, airExtraPortion.getPNRPassengerSeqID());
			stmt.setString(7, airExtraPortion.getAirlineCode());
			stmt.setString(8, airExtraPortion.getFlightNbr());
			stmt.setString(9, airExtraPortion.getClassofService());
			stmt.setDate(10, airExtraPortion.getServiceStartDate());
			stmt.setString(11, airExtraPortion.getServiceStartCity());
			stmt.setString(12, airExtraPortion.getServiceEndCity());
			stmt.setString(13, airExtraPortion.getEMDNbr());
			stmt.setShort(14, airExtraPortion.getEmdCouponNbr());
			stmt.setString(15, airExtraPortion.getETicketNbr());
			stmt.setShort(16, airExtraPortion.getETicketCpnNbr());
			stmt.setDate(17, airExtraPortion.getRecordUpdateDate());
			stmt.setTimestamp(18, airExtraPortion.getRecordUpdateDateTime());
			stmt.setString(19, airExtraPortion.getMarketingCarrierCode());
			stmt.setString(20, airExtraPortion.getOpertatingCarrierCode());
			stmt.setString(21, airExtraPortion.getSourceSystemID());
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
