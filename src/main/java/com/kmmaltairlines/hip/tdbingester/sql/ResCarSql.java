package com.kmmaltairlines.hip.tdbingester.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResCar;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class ResCarSql {

    @Autowired
    Utility utility;

    /**
     * Inserts ResCar records into the database in bulk.
     * 
     * @param resCar - List of ResCar objects to be inserted
     * @param connessione - Connection object for the database connection
     * @throws SQLException - If an error occurs while executing the SQL query
     * @throws IOException - If an error occurs while reading SQL files
     */
    public void insert(List<ResCar> resCar, Connection connection) throws SQLException, IOException {
 
        PreparedStatement stmt = null;

        // Read the SQL insert query from the file
        String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResCar.sql");

        // Create a PreparedStatement to execute the SQL query
        stmt = connection.prepareStatement(sql);

        // Add the ResCar data to the batch for bulk insertion
        for (ResCar car : resCar) {
            stmt.setString(1, car.getID());
            stmt.setShort(2, car.getSegmentNbr());
            stmt.setString(3, car.getCarClassificationCode());
            stmt.setString(4, car.getCarCorporateDiscountNbr());
            stmt.setString(5, car.getCarDropoffChargeAmount());
            stmt.setString(6, car.getCarDropOffCurCode());
            stmt.setString(7, car.getCarExtraDayRateAmount());
            stmt.setString(8, car.getCarExtraHourRateAmount());
            stmt.setString(9, car.getCarMileageLimit());
            stmt.setString(10, car.getCarReserveUnderName());
            stmt.setString(11, car.getCarTypeCode());
            stmt.setString(12, car.getConfirmationNbr());
            stmt.setString(13, car.getServiceStartCity());
            stmt.setDate(14, car.getServiceStartDate());
            stmt.setTime(15, car.getServiceStartTime());
            stmt.setString(16, car.getCurrentSegmentStatusCode());
            stmt.setShort(17, car.getUnitsBookedCount());
            stmt.setShort(18, car.getDaysRentedCount());
            stmt.setString(19, car.getVendorCarCode());
            stmt.setString(20, car.getRentalRate());
            stmt.setString(21, car.getCurrencyCode());
            stmt.setString(22, car.getRatePlanCode());
            stmt.setString(23, car.getNonAirportLocationDescript());
            stmt.setString(24, car.getProductNonstdEndLocationText());
            stmt.setString(25, car.getHistoryActionCodeId());
            stmt.setDate(26, car.getRecordUpdateDate());
            stmt.setTime(27, car.getRecordUpdateTime());
            stmt.setShort(28, car.getIntraPNRSetNbr());
            stmt.addBatch();
        }

        // Execute the batch insert
        int[] results = stmt.executeBatch();

        System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
        stmt.close();
    }
}
