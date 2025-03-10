package com.kmmaltairlines.hip.tdbingester.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResHotel;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class ResHotelSql {

    @Autowired
    Utility utility;

    /**
     * Inserts ResHotel records into the database in bulk.
     * 
     * @param resHotels - List of ResHotel objects to be inserted
     * @param connessione - Connection object for the database connection
     * @throws SQLException - If an error occurs while executing the SQL query
     * @throws IOException - If an error occurs while reading SQL files
     */
    public void insert(List<ResHotel> resHotels, Connection connection) throws SQLException, IOException {
 
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

        System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
        stmt.close();
    }
}
