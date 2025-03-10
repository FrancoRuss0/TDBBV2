package com.kmmaltairlines.hip.tdbingester.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResODFlight;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class ResODFlightSql {

    @Autowired
    Utility utility;

    /**
     * Inserts ResODFlight records into the database in bulk.
     * 
     * @param resODFlights - List of ResODFlight objects to be inserted
     * @param connessione - Connection object for the database connection
     * @throws SQLException - If an error occurs while executing the SQL query
     * @throws IOException - If an error occurs while reading SQL files
     */
    public void insert(List<ResODFlight> resODFlights, Connection connessione) throws SQLException, IOException {

        // Establish database connection
        Connection conn = connessione;
        PreparedStatement stmt = null;

        // Read the SQL insert query from the file
        String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResODFlight.sql");

        // Create a PreparedStatement to execute the SQL query
        stmt = conn.prepareStatement(sql);

        // Add the ResODFlight data to the batch for bulk insertion
        for (ResODFlight odFlight : resODFlights) {
            stmt.setString(1, odFlight.getID());
            stmt.setShort(2, odFlight.getSegmentNbr());
            stmt.setString(3, odFlight.getAirlineOrigTerminal());
            stmt.setString(4, odFlight.getAirlineDestTerminal());
            stmt.setString(5, odFlight.getTravelerOrigTerminal());
            stmt.setString(6, odFlight.getTravelerDestTerminal());
            stmt.setString(7, odFlight.getAirlineOrigCntry());
            stmt.setString(8, odFlight.getAirlineDestCntry());
            stmt.setString(9, odFlight.getTravelerOrigCntry());
            stmt.setString(10, odFlight.getTravelerDestCntry());
            stmt.addBatch();  // Add this record to the batch
        }

        // Execute the batch insert
        int[] results = stmt.executeBatch();

        System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
        stmt.close();
    }
}
