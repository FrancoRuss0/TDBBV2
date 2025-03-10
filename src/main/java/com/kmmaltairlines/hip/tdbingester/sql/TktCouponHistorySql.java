package com.kmmaltairlines.hip.tdbingester.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.TktCouponHistory;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class TktCouponHistorySql {

    @Autowired
    Utility utility;

    /**
     * Inserts a list of TktCouponHistory records into the database in bulk.
     * 
     * @param tktCouponHistoryList - List of TktCouponHistory objects to be inserted
     * @param connection - Database connection object
     * @throws SQLException - If a database error occurs
     * @throws IOException - If an error occurs while reading SQL files
     */
    public void insert(List<TktCouponHistory> tktCouponHistoryList, Connection connection) throws SQLException, IOException {

        PreparedStatement stmt = null;

        // Read the SQL insert query from the file
        String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertTktCouponHistory.sql");

        // Prepare the SQL statement
        stmt = connection.prepareStatement(sql);

        // Add TktCouponHistory data to the batch for bulk insertion
        for (TktCouponHistory history : tktCouponHistoryList) {
            stmt.setString(1, history.getID());
            stmt.setString(2, history.getPNRLocatorID());
            stmt.setDate(3, history.getPNRCreateDate());
            stmt.setInt(4, history.getCouponSeqNbr());
            stmt.setString(5, history.getFareBasisCode());
            stmt.setInt(6, history.getCouponNbr());
            stmt.setString(7, history.getPreviousCouponStatusCode());
            stmt.setString(8, history.getNewCouponStatusCode());
            stmt.setInt(9, history.getCouponNbrChanged());
            stmt.setString(10, history.getPreviousControlVendorCode());
            stmt.setString(11, history.getNewControlVendorCode());
            stmt.setString(12, history.getRevalMarketingAirlineCode());
            stmt.setString(13, history.getRevalClassofService());
            stmt.setString(14, history.getRevalMarketingFlightNbr());
            stmt.setDate(15, history.getRevalServiceStartDate());
            stmt.setString(16, history.getRevalServiceStartCity());
            stmt.setString(17, history.getRevalServiceEndCity());
            stmt.setTime(18, history.getRevalServiceStartTime());
            stmt.setTime(19, history.getRevalServiceEndTime());
            stmt.setString(20, history.getRevalSegmentStatusCode());
            stmt.setDate(21, history.getLastUpdate());
            stmt.setTime(22, history.getLastUpdateSysTime());
            stmt.setInt(23, history.getHistorySeqNbr());
            stmt.addBatch(); // Add this record to the batch
        }

        // Execute the batch insert
        int[] results = stmt.executeBatch();

        System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
        stmt.close();
    }
}
