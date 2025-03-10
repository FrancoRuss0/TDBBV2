package com.kmmaltairlines.hip.tdbingester.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResPassengerFT;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class ResPassengerFTSql {

    @Autowired
    Utility utility;

    /**
     * Inserts ResPassengerFT records into the database in bulk.
     * 
     * @param resPassengerFTs - List of ResPassengerFT objects to be inserted
     * @param connessione - Connection object for the database connection
     * @throws SQLException - If an error occurs while executing the SQL query
     * @throws IOException - If an error occurs while reading SQL files
     */
    public void insert(List<ResPassengerFT> resPassengerFTs, Connection connection) throws SQLException, IOException {

        PreparedStatement stmt = null;

        // Read the SQL insert query from the file
        String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResPassengerFT.sql");

        // Create a PreparedStatement to execute the SQL query
        stmt = connection.prepareStatement(sql);

        // Add the ResPassengerFT data to the batch for bulk insertion
        for (ResPassengerFT passengerFT : resPassengerFTs) {
            stmt.setString(1, passengerFT.getID());
            stmt.setShort(2, passengerFT.getPNRPassengerFTSeqId());
            stmt.setShort(3, passengerFT.getPNRPassengerSeqId());
            stmt.setString(4, passengerFT.getSourceTypeCode());
            stmt.setString(5, passengerFT.getClassOfService());
            stmt.setString(6, passengerFT.getFrequentTravelerNbr());
            stmt.setString(7, passengerFT.getFTText());
            stmt.setString(8, passengerFT.getFTCurrentStatusCode());
            stmt.setString(9, passengerFT.getFTFlightNumber());
            stmt.setString(10, passengerFT.getReceivingCarrierCode());
            stmt.setString(11, passengerFT.getServiceStartCityCode());
            stmt.setString(12, passengerFT.getServiceEndCityCode());
            stmt.setString(13, passengerFT.getSSRCode());
            stmt.setString(14, passengerFT.getSSRIdTypeCode());
            stmt.setShort(15, passengerFT.getSSRNbrInParty());
            stmt.setString(16, passengerFT.getVendorCode());
            stmt.setString(17, passengerFT.getHistoryActionCodeId());
            stmt.setDate(18, passengerFT.getRecordUpdateDate());
            stmt.setTime(19, passengerFT.getRecordUpdateTime());
            stmt.setShort(20, passengerFT.getIntraPNRSetNbr());
            stmt.addBatch();  // Add this record to the batch
        }

        // Execute the batch insert
        int[] results = stmt.executeBatch();

        System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
        stmt.close();
    }
}
