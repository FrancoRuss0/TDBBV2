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
import com.kmmaltairlines.hip.tdbingester.filepojos.ResCar;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("ResCarSql")
public class ResCarSql implements MethodInterface {

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(ResCarSql.class);

	/**
	 * Inserts ResCar records into the database in bulk.
	 * 
	 * @param resCar      - List of ResCar objects to be inserted
	 * @param connessione - Connection object for the database connection
	 * @throws SQLException - If an error occurs while executing the SQL query
	 * @throws IOException  - If an error occurs while reading SQL files
	 */
	@Override
	@Transactional
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		// Establish database connection
		ArrayList<ResCar> resCar = new ArrayList<ResCar>();
		for (Object flight : flights) {
			resCar.add((ResCar) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResCar.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the ResCar data to the batch for bulk insertion
		for (ResCar car : resCar) {
			stmt.setString(1, car.getID());
			stmt.setString(2, car.getPNRLocatorID());
			stmt.setDate(3, car.getPNRCreateDate());
			stmt.setTimestamp(4, car.getFromDateTime());
			if (car.getSegmentNbr() == null) {
				stmt.setNull(5, Types.NULL);
			} else {
				stmt.setShort(5, car.getSegmentNbr());
			}

			stmt.setString(6, car.getCarClassificationCode());
			stmt.setString(7, car.getCarCorporateDiscountNbr());
			stmt.setString(8, car.getCarDropoffChargeAmount());
			stmt.setString(9, car.getCarDropOffCurCode());
			stmt.setString(10, car.getCarExtraDayRateAmount());
			stmt.setString(11, car.getCarExtraHourRateAmount());
			stmt.setString(12, car.getCarMileageLimit());
			stmt.setString(13, car.getCarReserveUnderName());
			stmt.setString(14, car.getCarTypeCode());
			stmt.setString(15, car.getConfirmationNbr());
			stmt.setString(16, car.getServiceStartCity());
			stmt.setDate(17, car.getServiceStartDate());
			stmt.setTime(18, car.getServiceStartTime());
			stmt.setString(19, car.getCurrentSegmentStatusCode());
			if (car.getUnitsBookedCount() == null) {
				stmt.setNull(20, Types.NULL);
			} else {
				stmt.setShort(20, car.getUnitsBookedCount());
			}

			if (car.getDaysRentedCount() == null) {
				stmt.setNull(21, Types.NULL);
			} else {
				stmt.setShort(21, car.getDaysRentedCount());
			}

			stmt.setString(22, car.getVendorCarCode());
			stmt.setString(23, car.getRentalRate());
			stmt.setString(24, car.getCurrencyCode());
			stmt.setString(25, car.getRatePlanCode());
			stmt.setString(26, car.getNonAirportLocationDescript());
			stmt.setString(27, car.getProductNonstdEndLocationText());
			stmt.setString(28, car.getHistoryActionCodeId());
			stmt.setDate(29, car.getRecordUpdateDate());
			stmt.setTime(30, car.getRecordUpdateTime());
			if (car.getIntraPNRSetNbr() == null) {
				stmt.setNull(31, Types.NULL);
			} else {
				stmt.setShort(31, car.getIntraPNRSetNbr());
			}

			stmt.setObject(32, utility.nowUtcTimestamp(), Types.TIMESTAMP);
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
		ArrayList<ResCar> resCar = new ArrayList<ResCar>();
		for (Object flight : flights) {
			resCar.add((ResCar) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteResCar.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the flight data to the batch for bulk insertion
		for (ResCar res : resCar) {
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
