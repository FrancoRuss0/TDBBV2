package com.kmmaltairlines.hip.tdbingester.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResPassengerEmail;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class ResPassengerEmailSql {

    @Autowired
    Utility utility;

    /**
     * Inserts ResPassengerEmail records into the database in bulk.
     * 
     * @param resPassengerEmails - List of ResPassengerEmail objects to be inserted
     * @param connessione - Connection object for the database connection
     * @throws SQLException - If an error occurs while executing the SQL query
     * @throws IOException - If an error occurs while reading SQL files
     */
    public void insert(List<ResPassengerEmail> resPassengerEmails, Connection connection) throws SQLException, IOException {

        PreparedStatement stmt = null;

        // Read the SQL insert query from the file
        String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResPassengerEmail.sql");

        // Create a PreparedStatement to execute the SQL query
        stmt = connection.prepareStatement(sql);

        // Add the ResPassengerEmail data to the batch for bulk insertion
        for (ResPassengerEmail passengerEmail : resPassengerEmails) {
            stmt.setString(1, passengerEmail.getID());
            stmt.setShort(2, passengerEmail.getPNRPassengerEMailSeqId());
            stmt.setString(3, passengerEmail.getEMailAddress());
            stmt.setString(4, passengerEmail.getHistoryActionCodeId());
            stmt.setDate(5, passengerEmail.getRecordUpdateDate());
            stmt.setTime(6, passengerEmail.getRecordUpdateTime());
            stmt.setShort(7, passengerEmail.getIntraPNRSetNbr());
            stmt.setShort(8, passengerEmail.getPNRPassengerSeqID());
            stmt.addBatch();  // Add this record to the batch
        }

        // Execute the batch insert
        int[] results = stmt.executeBatch();

        System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
        stmt.close();
    }
}
