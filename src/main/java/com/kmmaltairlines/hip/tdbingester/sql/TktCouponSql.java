package com.kmmaltairlines.hip.tdbingester.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kmmaltairlines.hip.tdbingester.filepojos.TktCoupon;
import com.kmmaltairlines.hip.tdbingester.filepojos.TktDocument;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("TktCouponSql")
public class TktCouponSql implements MethodInterface {

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(TktCouponSql.class);

	/**
	 * Inserts a list of TktCoupon records into the database in bulk.
	 * 
	 * @param tktCoupons - List of TktCoupon objects to be inserted
	 * @param connection - Database connection object
	 * @throws SQLException - If a database error occurs
	 * @throws IOException  - If an error occurs while reading SQL files
	 */
	@Override
	@Transactional
	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {

		ArrayList<TktCoupon> tktCoupon = new ArrayList<TktCoupon>();
		for (Object flight : flights) {
			tktCoupon.add((TktCoupon) flight);
		}

		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertTktCoupon.sql");

		// Prepare the SQL statement
		stmt = connection.prepareStatement(sql);

		// Add TktCoupon data to the batch for bulk insertion
		for (TktCoupon coupon : tktCoupon) {
			stmt.setString(1, coupon.getID());
			stmt.setString(2, coupon.getPNRLocatorID());
			stmt.setDate(3, coupon.getPNRCreateDate());
			stmt.setString(4, coupon.getPrimaryDocNbr());
			stmt.setDate(5, coupon.getVCRCreateDate());
			stmt.setTimestamp(6, coupon.getTransactionDateTime());
			stmt.setShort(7, coupon.getCouponSeqNbr());
			stmt.setByte(8, coupon.getEntNbr());
			stmt.setString(9, coupon.getCouponStatus());
			stmt.setString(10, coupon.getPreviousCouponStatusCode());
			stmt.setString(11, coupon.getSegmentTypeCode());
			stmt.setString(12, coupon.getMarketingAirlineCode());
			stmt.setString(13, coupon.getMarketingFlightNbr());
			stmt.setString(14, coupon.getServiceStartCity());
			stmt.setString(15, coupon.getServiceEndCity());
			stmt.setString(16, coupon.getSegmentStatusCode());
			stmt.setDate(17, coupon.getServiceStartDate());
			stmt.setTime(18, coupon.getServiceStartTime());
			stmt.setDate(19, coupon.getServiceEndDate());
			stmt.setTime(20, coupon.getServiceEndTime());
			stmt.setString(21, coupon.getClassOfService());
			stmt.setString(22, coupon.getFareBasisCode());
			stmt.setString(23, coupon.getTktDesignatorCode());
			stmt.setString(24, coupon.getFareBreakInd());
			stmt.setDate(25, coupon.getPriceNotValidBeforeDate());
			stmt.setDate(26, coupon.getPriceNotValidAfterDate());
			stmt.setString(27, coupon.getInvoluntaryInd());
			stmt.setString(28, coupon.getFlownFlightNbr());
			stmt.setDate(29, coupon.getFlownServiceStartDate());
			stmt.setString(30, coupon.getFlownServiceStartCity());
			stmt.setString(31, coupon.getFlownServiceEndCity());
			stmt.setString(32, coupon.getFlownClassOfService());
			stmt.setDate(33, coupon.getFlownFlightOrigDate());
			stmt.setString(34, coupon.getOperatingAirlineCode());
			stmt.setString(35, coupon.getOperatingFlightNbr());
			stmt.setString(36, coupon.getOperatingPNRLocator());
			stmt.setBigDecimal(37, coupon.getFareBreakAmt());
			stmt.setBigDecimal(38, coupon.getFareBreakDiscAmt());
			stmt.setString(39, coupon.getDiscountAmtInd());
			stmt.setString(40, coupon.getDiscountPctInd());
			stmt.setString(41, coupon.getStopoverCode());
			stmt.setString(42, coupon.getFrequentTravelerNbr());
			stmt.setString(43, coupon.getVendorCode());
			stmt.setString(44, coupon.getFareBreakCurrencyCode());
			stmt.setString(45, coupon.getSettlementAuthCode());
			stmt.setString(46, coupon.getBaggageAlwncText());
			stmt.setObject(47, utility.nowUtcTimestamp(), Types.TIMESTAMP);

			stmt.addBatch(); // Add this record to the batch
		}

		// Execute the batch insert
		int[] results = stmt.executeBatch();

		logger.info("Bulk insert completed successfully. " + results.length + " records inserted.");
		stmt.close();
	}

	@Override
	@Transactional
	public String delete(List<Object> flights, Connection connection) throws SQLException, IOException {
		ArrayList<TktCoupon> tktCoupon = new ArrayList<TktCoupon>();
		for (Object flight : flights) {
			tktCoupon.add((TktCoupon) flight);
		}
		PreparedStatement stmt = null;

		// Read the SQL insert query from the file
		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteTktCoupon.sql");

		// Create a PreparedStatement to execute the SQL query
		stmt = connection.prepareStatement(sql);

		// Add the flight data to the batch for bulk insertion
		for (TktCoupon res : tktCoupon) {
			stmt.setString(1, res.getPrimaryDocNbr());
			stmt.setDate(2, res.getVCRCreateDate());
			// Add the statement to the batch
			stmt.addBatch();
		}

		// Execute the batch insert
		int[] results = stmt.executeBatch();
		String back = stmt.executeBatch().toString();
		logger.info("Delete completed successfully. " + results.length + " records deleted.");
		stmt.close();
		return back;
	}
}
