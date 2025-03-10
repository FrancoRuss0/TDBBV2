package com.kmmaltairlines.hip.tdbingester.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.TktCouponEMD;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class TktCouponEMDSql {

    @Autowired
    Utility utility;

    /**
     * Inserts a list of TktCouponEMD records into the database in bulk.
     * 
     * @param tktCouponEMDs - List of TktCouponEMD objects to be inserted
     * @param connection - Database connection object
     * @throws SQLException - If a database error occurs
     * @throws IOException - If an error occurs while reading SQL files
     */
    public void insert(List<TktCouponEMD> tktCouponEMDs, Connection connection) throws SQLException, IOException {

        PreparedStatement stmt = null;

        // Read the SQL insert query from the file
        String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertTktCouponEMD.sql");

        // Prepare the SQL statement
        stmt = connection.prepareStatement(sql);

        // Add TktCouponEMD data to the batch for bulk insertion
        for (TktCouponEMD couponEMD : tktCouponEMDs) {
            stmt.setString(1, couponEMD.getID());
            stmt.setString(2, couponEMD.getPNRLocatorID());
            stmt.setDate(3, couponEMD.getPNRCreateDate());
            stmt.setShort(4, couponEMD.getCouponSeqNbr());
            stmt.setString(5, couponEMD.getFeeOwnerCode());
            stmt.setString(6, couponEMD.getOCGroupCode());
            stmt.setString(7, couponEMD.getRFICode());
            stmt.setInt(8, couponEMD.getQuantSold());
            stmt.setString(9, couponEMD.getRFISubCode());
            stmt.setString(10, couponEMD.getCommercialName());
            stmt.setString(11, couponEMD.getEMDTypeCode());
            stmt.setString(12, couponEMD.getFeeGuaranteedInd());
            stmt.setString(13, couponEMD.getFeeVendorCode());
            stmt.setString(14, couponEMD.getSegmentUseCode());
            stmt.setString(15, couponEMD.getRelPrimaryDocNbr());
            stmt.setByte(16, couponEMD.getRelCouponSeqNbr());
            stmt.setDate(17, couponEMD.getRelVCRCreateDate());

            // Add this record to the batch
            stmt.addBatch();
        }

        // Execute the batch insert
        int[] results = stmt.executeBatch();

        System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
        stmt.close();
    }
}
