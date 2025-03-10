package com.kmmaltairlines.hip.tdbingester.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.TktCoupon;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class TktCouponSql {

    @Autowired
    Utility utility;

    /**
     * Inserts a list of TktCoupon records into the database in bulk.
     * 
     * @param tktCoupons - List of TktCoupon objects to be inserted
     * @param connection - Database connection object
     * @throws SQLException - If a database error occurs
     * @throws IOException - If an error occurs while reading SQL files
     */
    public void insert(List<TktCoupon> tktCoupons, Connection connection) throws SQLException, IOException {

        PreparedStatement stmt = null;

        // Read the SQL insert query from the file
        String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertTktCoupon.sql");

        // Prepare the SQL statement
        stmt = connection.prepareStatement(sql);

        // Add TktCoupon data to the batch for bulk insertion
        for (TktCoupon coupon : tktCoupons) {
            stmt.setString(1, coupon.getID());
            stmt.setString(2, coupon.getPNRLocatorID());
            stmt.setDate(3, coupon.getPNRCreateDate());
            stmt.setShort(4, coupon.getCouponSeqNbr());
            stmt.setByte(5, coupon.getEntNbr());
            stmt.setString(6, coupon.getCouponStatus());
            stmt.setString(7, coupon.getPreviousCouponStatusCode());
            stmt.setString(8, coupon.getSegmentTypeCode());
            stmt.setString(9, coupon.getMarketingAirlineCode());
            stmt.setString(10, coupon.getMarketingFlightNbr());
            stmt.setString(11, coupon.getServiceStartCity());
            stmt.setString(12, coupon.getServiceEndCity());
            stmt.setString(13, coupon.getSegmentStatusCode());
            stmt.setDate(14, coupon.getServiceStartDate());
            stmt.setTime(15, coupon.getServiceStartTime());
            stmt.setDate(16, coupon.getServiceEndDate());
            stmt.setTime(17, coupon.getServiceEndTime());
            stmt.setString(18, coupon.getClassOfService());
            stmt.setString(19, coupon.getFareBasisCode());
            stmt.setString(20, coupon.getTktDesignatorCode());
            stmt.setString(21, coupon.getFareBreakInd());
            stmt.setDate(22, coupon.getPriceNotValidBeforeDate());
            stmt.setDate(23, coupon.getPriceNotValidAfterDate());
            stmt.setString(24, coupon.getInvoluntaryInd());
            stmt.setString(25, coupon.getFlownFlightNbr());
            stmt.setDate(26, coupon.getFlownServiceStartDate());
            stmt.setString(27, coupon.getFlownServiceStartCity());
            stmt.setString(28, coupon.getFlownServiceEndCity());
            stmt.setString(29, coupon.getFlownClassOfService());
            stmt.setDate(30, coupon.getFlownFlightOrigDate());
            stmt.setString(31, coupon.getOperatingAirlineCode());
            stmt.setString(32, coupon.getOperatingFlightNbr());
            stmt.setString(33, coupon.getOperatingPNRLocator());
            stmt.setBigDecimal(34, coupon.getFareBreakAmt());
            stmt.setBigDecimal(35, coupon.getFareBreakDiscAmt());
            stmt.setString(36, coupon.getDiscountAmtInd());
            stmt.setString(37, coupon.getDiscountPctInd());
            stmt.setString(38, coupon.getStopoverCode());
            stmt.setString(39, coupon.getFrequentTravelerNbr());
            stmt.setString(40, coupon.getVendorCode());
            stmt.setString(41, coupon.getFareBreakCurrencyCode());
            stmt.setString(42, coupon.getSettlementAuthCode());
            stmt.setString(43, coupon.getBaggageAlwncText());
            stmt.addBatch(); // Add this record to the batch
        }

        // Execute the batch insert
        int[] results = stmt.executeBatch();

        System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
        stmt.close();
    }
}
