package com.kmmaltairlines.hip.tdbingester.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResFlightAirExtra;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class ResFlightAirExtraSql {

    @Autowired
    Utility utility;

    /**
     * Inserts ResFlightAirExtra records into the database in bulk.
     * 
     * @param resFlightAirExtras - List of ResFlightAirExtra objects to be inserted
     * @param connessione - Connection object for the database connection
     * @throws SQLException - If an error occurs while executing the SQL query
     * @throws IOException - If an error occurs while reading SQL files
     */
    public void insert(List<ResFlightAirExtra> resFlightAirExtras, Connection connection) throws SQLException, IOException {
 
        PreparedStatement stmt = null;

        // Read the SQL insert query from the file
        String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResFlightAirExtra.sql");

        // Create a PreparedStatement to execute the SQL query
        stmt = connection.prepareStatement(sql);

        // Add the ResFlightAirExtra data to the batch for bulk insertion
        for (ResFlightAirExtra flightAirExtra : resFlightAirExtras) {
            stmt.setString(1, flightAirExtra.getID());
            stmt.setShort(2, flightAirExtra.getSegmentNbr());
            stmt.setShort(3, flightAirExtra.getPNRPassengerSeqId());
            stmt.setString(4, flightAirExtra.getRFISubCode());
            stmt.setDate(5, flightAirExtra.getRecordUpdateDate());
            stmt.setTime(6, flightAirExtra.getRecordUpdateTime());
            stmt.setShort(7, flightAirExtra.getIntraPNRSetNbr());

            // Add to batch
            stmt.addBatch();
        }

        // Execute the batch insert
        int[] results = stmt.executeBatch();

        System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
        stmt.close();
    }
}
