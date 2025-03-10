package com.kmmaltairlines.hip.tdbingester.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResSSR;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class ResSSRSql {

    @Autowired
    Utility utility;

    /**
     * Inserts a list of ResSSR records into the database in bulk.
     * 
     * @param resSSRs - List of ResSSR objects to be inserted
     * @param connection - Database connection object
     * @throws SQLException - If a database error occurs
     * @throws IOException - If an error occurs while reading SQL files
     */
    public void insert(List<ResSSR> resSSRs, Connection connection) throws SQLException, IOException {

        PreparedStatement stmt = null;

        // Read the SQL insert query from the file
        String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResSSR.sql");

        // Prepare the SQL statement
        stmt = connection.prepareStatement(sql);

        // Add ResSSR data to the batch for bulk insertion
        for (ResSSR ssr : resSSRs) {
            stmt.setString(1, ssr.getID());
            stmt.setShort(2, ssr.getResSSRSeqId());
            stmt.setShort(3, ssr.getPNRPassengerSeqId());
            stmt.setString(4, ssr.getSourceTypeCode());
            stmt.setString(5, ssr.getSSRIdTypeCode());
            stmt.setString(6, ssr.getSSRStatusCode());
            stmt.setString(7, ssr.getSSRFlightNumber());
            stmt.setShort(8, ssr.getSSRNbrInParty());
            stmt.setDate(9, ssr.getSSRStartDate());
            stmt.setString(10, ssr.getVendorCode());
            stmt.setString(11, ssr.getSSRCode());
            stmt.setString(12, ssr.getSSRText());
            stmt.setString(13, ssr.getClassOfService());
            stmt.setString(14, ssr.getServiceStartCityCode());
            stmt.setString(15, ssr.getServiceEndCityCode());
            stmt.setString(16, ssr.getHistoryActionCodeId());
            stmt.setDate(17, ssr.getRecordUpdateDate());
            stmt.setTime(18, ssr.getRecordUpdateTime());
            stmt.setShort(19, ssr.getIntraPNRSetNbr());
            stmt.addBatch(); // Add this record to the batch
        }

        // Execute the batch insert
        int[] results = stmt.executeBatch();

        System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
        stmt.close();
    }
}