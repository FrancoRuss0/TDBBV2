package com.kmmaltairlines.hip.tdbingester.sql;
 
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResPassengerPhone;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class ResPassengerPhoneSql {

    @Autowired
    Utility utility;

    /**
     * Inserts ResPassengerPhone records into the database in bulk.
     * 
     * @param resPassengerPhones - List of ResPassengerPhone objects to be inserted
     * @param connessione - Connection object for the database connection
     * @throws SQLException - If an error occurs while executing the SQL query
     * @throws IOException - If an error occurs while reading SQL files
     */
    public void insert(List<ResPassengerPhone> resPassengerPhones, Connection connection) throws SQLException, IOException {
 
        PreparedStatement stmt = null;

        // Read the SQL insert query from the file
        String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResPassengerPhone.sql");

        // Create a PreparedStatement to execute the SQL query
        stmt = connection.prepareStatement(sql);

        // Add the ResPassengerFT data to the batch for bulk insertion
        for (ResPassengerPhone passengerPhone : resPassengerPhones) {
            stmt.setString(1, passengerPhone.getID());
            stmt.setShort(2, passengerPhone.getPNRPassengerPhoneSeqId());
            stmt.setString(3, passengerPhone.getCityPhoneCode());
            stmt.setString(4, passengerPhone.getPhoneNbrText());
            stmt.setString(5, passengerPhone.getPhoneTypeCode());
            stmt.setString(6, passengerPhone.getHistoryActionCodeId());
            stmt.setDate(7, passengerPhone.getRecordUpdateDate());
            stmt.setTime(8, passengerPhone.getRecordUpdateTime());
            stmt.setShort(9, passengerPhone.getIntraPNRSetNbr());
            stmt.addBatch(); // Aggiunge il record al batch
        }

        // Execute the batch insert
        int[] results = stmt.executeBatch();

        System.out.println("Inserimento batch completato. " + results.length + " record inseriti.");
        stmt.close();
    }
}
