package com.kmmaltairlines.hip.tdbingester.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResPassenger;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class ResPassengerSql {

    @Autowired
    Utility utility;

    /**
     * Inserts ResPassenger records into the database in bulk.
     * 
     * @param resPassengers - List of ResPassenger objects to be inserted
     * @param connessione - Connection object for the database connection
     * @throws SQLException - If an error occurs while executing the SQL query
     * @throws IOException - If an error occurs while reading SQL files
     */
    public void insert(List<ResPassenger> resPassengers, Connection connection) throws SQLException, IOException {
 
        PreparedStatement stmt = null;

        // Read the SQL insert query from the file
        String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResPassenger.sql");

        // Create a PreparedStatement to execute the SQL query
        stmt = connection.prepareStatement(sql);

        // Add the ResPassenger data to the batch for bulk insertion
        for (ResPassenger passenger : resPassengers) {
            stmt.setString(1, passenger.getID());
            stmt.setShort(2, passenger.getPNRPassengerSeqId());
            stmt.setString(3, passenger.getNameFirst());
            stmt.setString(4, passenger.getNameLast());
            stmt.setString(5, passenger.getNameComment());
            stmt.setString(6, passenger.getRelativePassengerNbr());
            stmt.setString(7, passenger.getHistoryActionCodeId());
            stmt.setDate(8, passenger.getRecordUpdateDate());
            stmt.setTime(9, passenger.getRecordUpdateTime());
            stmt.setShort(10, passenger.getIntraPNRSetNbr());
            stmt.addBatch();  // Add this record to the batch
        }

        // Execute the batch insert
        int[] results = stmt.executeBatch();

        System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
        stmt.close();
    }
}
