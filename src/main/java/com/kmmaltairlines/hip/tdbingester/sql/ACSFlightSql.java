package com.kmmaltairlines.hip.tdbingester.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.kmmaltairlines.hip.tdbingester.filepojos.ACSFlight;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component
public class ACSFlightSql {

	/**
	 * Inserts ACSFlight records into the database in bulk.
	 * @param flights - List of ACSFlight objects to be inserted
	 * @throws SQLException - If an error occurs while executing the SQL query
	 * @throws IOException - If an error occurs while reading SQL files
	 */
	public void insert(List<ACSFlight> acsFlights,Connection connection) throws SQLException, IOException {


		PreparedStatement stmt = null;
		Utility utility=new Utility();
			// Read the SQL insert query from the file
			String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertACSFlight.sql");

			// Create a PreparedStatement to execute the SQL query
			stmt = connection.prepareStatement(sql);

			// Disable auto-commit for batch processing

			// Add the flight data to the batch for bulk insertion
			for (ACSFlight flight : acsFlights) {
				stmt.setString(1, flight.getSourceSystemID());
				stmt.setString(2, flight.getAirlineCode());
				stmt.setString(3, flight.getFltNbr());
				stmt.setObject(4, flight.getServiceStartDate(), Types.TIMESTAMP);
				stmt.setString(5, flight.getAirlineOrigAirport());
				stmt.setString(6, flight.getAirlineDestAirport());
				stmt.setString(7, flight.getSchdAirlineOrigAirport());
				stmt.setString(8, flight.getSchdAirlineDestAirport());
				stmt.setString(9, flight.getAirlineOrigGate());
				stmt.setString(10, flight.getCOGInd());
				stmt.setString(11, flight.getFltOverFlyInd());
				stmt.setString(12, flight.getFltFlagStopInd());
				stmt.setString(13, flight.getFltStubInd());
				stmt.setString(14, flight.getGateReaderLNIATA());
				stmt.setObject(15, flight.getEstServiceEndDate(), Types.TIMESTAMP);
				stmt.setObject(16, flight.getEstServiceEndTime(), Types.TIME);
				stmt.setObject(17, flight.getEstServiceStartDate(), Types.TIMESTAMP);
				stmt.setObject(18, flight.getEstServiceStartTime(), Types.TIME);
				stmt.setObject(19, flight.getSchdServiceStartDate(), Types.TIMESTAMP);
				stmt.setObject(20, flight.getSchdServiceStartTime(), Types.TIME);
				stmt.setObject(21, flight.getSchdServiceEndDate(), Types.TIMESTAMP);
				stmt.setObject(22, flight.getSchdServiceEndTime(), Types.TIME);
				stmt.setObject(23, flight.getFltCloseDate(), Types.TIMESTAMP);
				stmt.setObject(24, flight.getFltCloseTime(), Types.TIME);
				stmt.setObject(25, flight.getPDCDate(), Types.TIMESTAMP);
				stmt.setObject(26, flight.getPDCTime(), Types.TIME);
				stmt.setString(27, flight.getFltLegDelayedInd());
				stmt.setString(28, flight.getFltLegStatus());
				stmt.setString(29, flight.getTailNbr());
				stmt.setObject(30, flight.getMsgCreateDateTime(), Types.TIMESTAMP);
				stmt.setString(31, flight.getEquipmentType());
				stmt.setString(32, flight.getAircraftConfig());
				stmt.setInt(33, flight.getTotalPaxCount());
				stmt.setObject(34, flight.getReservedFutureUse1(), Types.NUMERIC);
				stmt.setObject(35, flight.getReservedFutureUse2(), Types.NUMERIC);
				stmt.setObject(36, flight.getReservedFutureUse3(), Types.NUMERIC);
				stmt.setObject(37, flight.getReservedFutureUse4(), Types.NUMERIC);
				stmt.setObject(38, flight.getReservedFutureUse5(), Types.NUMERIC);
				stmt.setObject(39, flight.getReservedFutureUse6(), Types.NUMERIC);
				stmt.setObject(40, flight.getReservedFutureUse7(), Types.NUMERIC);
				stmt.setObject(41, flight.getReservedFutureUse8(), Types.NUMERIC);
				stmt.setObject(42, flight.getReservedFutureUse9(), Types.NUMERIC);
				stmt.setObject(43, utility.nowUtcTimestamp(), Types.TIMESTAMP);
				// Add the statement to the batch
				stmt.addBatch();
			}

			// Execute the batch insert
			int[] results = stmt.executeBatch();


			System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
	        stmt.close();
	}
}
