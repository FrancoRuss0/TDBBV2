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
import com.kmmaltairlines.hip.tdbingester.filepojos.ResHotel;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("ResHotelSql")
public class ResHotelSql implements MethodInterface {

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(ResHotelSql.class);

	/**
	 * Inserts ResHotel records into the database in bulk.
	 * 
	 * @param resHotels   - List of ResHotel objects to be inserted
	 * @param connessione - Connection object for the database connection
	 * @throws SQLException - If an error occurs while executing the SQL query
	 * @throws IOException  - If an error occurs while reading SQL files
	 */
	@Override
	@Transactional
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		ArrayList<ResHotel> resHotels = new ArrayList<ResHotel>();
		for (Object flight : flights) {
			resHotels.add((ResHotel) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResHotel.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the ResHotel data to the batch for bulk insertion
		for (ResHotel hotel : resHotels) {
			stmt.setString(1, hotel.getID());
			stmt.setShort(2, hotel.getSegmentNbr());
			stmt.setString(3, hotel.getServiceCityCode());
			stmt.setDate(4, hotel.getServiceStartDate());
			stmt.setShort(5, hotel.getNbrofNightsCount());
			stmt.setShort(6, hotel.getUnitsBookedCount());
			stmt.setString(7, hotel.getCurrentSegmentStatusCode());
			stmt.setShort(8, hotel.getSegmentTypeCode());
			stmt.setString(9, hotel.getPropertyCode());
			stmt.setString(10, hotel.getPropertyName());
			stmt.setString(11, hotel.getVendorHotelCode());
			stmt.setString(12, hotel.getHotelRoomTypeCode());
			stmt.setString(13, hotel.getHotelRoomRate());
			stmt.setString(14, hotel.getHotelRateCode());
			stmt.setString(15, hotel.getCurrencyCode());
			stmt.setString(16, hotel.getHotelProductCode());
			stmt.setString(17, hotel.getConfirmationNbr());
			stmt.setString(18, hotel.getHotelReserveUnderName());
			stmt.setString(19, hotel.getHotelCorporateDiscountNbr());
			stmt.setString(20, hotel.getHotelExtraPersonRateAmount());
			stmt.setShort(21, hotel.getHotelExtraPersonCount());
			stmt.setShort(22, hotel.getNumberOfAdults());
			stmt.setString(23, hotel.getHistoryActionCodeId());
			stmt.setDate(24, hotel.getRecordUpdateDate());
			stmt.setTime(25, hotel.getRecordUpdateTime());
			stmt.setShort(26, hotel.getIntraPNRSetNbr());

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
		ArrayList<ResHotel> resHotels = new ArrayList<ResHotel>();
		for (Object flight : flights) {
			resHotels.add((ResHotel) flight);
		}
		PreparedStatement stmt = null;

			// Read the SQL insert query from the file
			String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteResHotel.sql");

			// Create a PreparedStatement to execute the SQL query
			stmt = connection.prepareStatement(sql);

			// Add the flight data to the batch for bulk insertion
			for (ResHotel res : resHotels) {
				 	stmt.setString(1, res.getPNRLocatorID());
				 	stmt.setDate(2, res.getPNRCreateDate());
	                // Add the statement to the batch
	                stmt.addBatch();
			}

			// Execute the batch insert
			int[] results = stmt.executeBatch();
			String back=stmt.executeBatch().toString();
			logger.info("Delete completed successfully. " + results.length + " records deleted.");
	        stmt.close();
		return back;
	}
}
