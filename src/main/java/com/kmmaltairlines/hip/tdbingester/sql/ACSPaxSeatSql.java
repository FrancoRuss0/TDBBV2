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

import com.kmmaltairlines.hip.tdbingester.filepojos.ACSPaxSeat;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.OneIteration;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component
public class ACSPaxSeatSql implements MethodInterface {
	@Autowired
	private Utility utility;

	private static final Logger logger = LogManager.getLogger(ACSPaxSeatSql.class);

	/**
	 * Inserts ACSFlightHistory records into the database in bulk.
	 * 
	 * @param flights - List of ACSPacDOCX objects to be inserted
	 * @throws SQLException - If an error occurs while executing the SQL query
	 * @throws IOException
	 */

	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		ArrayList<ACSPaxSeat> trasformACSPaxSeat = new ArrayList<ACSPaxSeat>();
		for (Object flight : flights) {
			trasformACSPaxSeat.add((ACSPaxSeat) flight);
		}
		PreparedStatement stmt = null;
		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertACSPaxSeat.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the flight data to the batch for bulk insertion
		for (ACSPaxSeat ACSPaxSeat : trasformACSPaxSeat) {
			stmt.setString(1, ACSPaxSeat.getSourceSystemID());
			stmt.setString(2, ACSPaxSeat.getPNRLocatorId());
			stmt.setDate(3, ACSPaxSeat.getPNRCreateDate());
			stmt.setShort(4, ACSPaxSeat.getResPaxId());
			stmt.setString(5, ACSPaxSeat.getAirlineCode());
			stmt.setString(6, ACSPaxSeat.getFltNbr());
			stmt.setDate(7, ACSPaxSeat.getServiceStartDate());
			stmt.setString(8, ACSPaxSeat.getAirlineOrigAirport());
			stmt.setString(9, ACSPaxSeat.getCabinCode());
			stmt.setString(10, ACSPaxSeat.getSeatRowNbr());
			stmt.setString(11, ACSPaxSeat.getSeatLtr());
			stmt.setString(12, ACSPaxSeat.getPreResSeatInd());
			stmt.setString(13, ACSPaxSeat.getJumpSeatTypeCode());
			stmt.setString(14, ACSPaxSeat.getJumpSeatRowNbr());
			stmt.setString(15, ACSPaxSeat.getJumpSeatLtr());
			stmt.setBigDecimal(16, ACSPaxSeat.getPaidUpgradeACAmt());
			stmt.setString(17, ACSPaxSeat.getInventoryUpgradeInd());
			stmt.setString(18, ACSPaxSeat.getDowngradeInd());
			stmt.setString(19, ACSPaxSeat.getUpgradeInd());
			stmt.setString(20, ACSPaxSeat.getCoachUpgradeInd());
			stmt.setString(21, ACSPaxSeat.getBusinessUpgradeInd());
			stmt.setTimestamp(22, ACSPaxSeat.getMsgCreateDateTime());
			stmt.setObject(23, utility.nowUtcTimestamp(), Types.TIMESTAMP);

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
