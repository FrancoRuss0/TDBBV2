package com.kmmaltairlines.hip.tdbingester.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kmmaltairlines.hip.tdbingester.filepojos.TktCouponHistory;
import com.kmmaltairlines.hip.tdbingester.filepojos.TktDocument;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("TktCouponHistorySql")
public class TktCouponHistorySql implements MethodInterface{

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(TktCouponHistorySql.class);


    /**
     * Inserts a list of TktCouponHistory records into the database in bulk.
     * 
     * @param tktCouponHistoryList - List of TktCouponHistory objects to be inserted
     * @param connection - Database connection object
     * @throws SQLException - If a database error occurs
     * @throws IOException - If an error occurs while reading SQL files
     */
	@Override
	@Transactional
    public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		
		ArrayList<TktCouponHistory> tktCouponHistory = new ArrayList<TktCouponHistory>();
		for (Object flight : flights) {
			tktCouponHistory.add((TktCouponHistory) flight);
		}
		
        PreparedStatement stmt = null;

        // Read the SQL insert query from the file
        String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertTktCouponHistory.sql");

        // Prepare the SQL statement
        stmt = connection.prepareStatement(sql);

        // Add TktCouponHistory data to the batch for bulk insertion
        for (TktCouponHistory history : tktCouponHistory) {
            stmt.setString(1, history.getID());
            stmt.setString(2, history.getPNRLocatorID());
            stmt.setDate(3, history.getPNRCreateDate());
            stmt.setString(4, history.getPrimaryDocNbr());
			stmt.setDate(5, history.getVCRCreateDate());
			stmt.setTimestamp(6, history.getTransactionDateTime());
            stmt.setInt(7, history.getCouponSeqNbr());
            stmt.setString(8, history.getFareBasisCode());
            stmt.setInt(9, history.getCouponNbr());
            stmt.setString(10, history.getPreviousCouponStatusCode());
            stmt.setString(11, history.getNewCouponStatusCode());
            stmt.setInt(12, history.getCouponNbrChanged());
            stmt.setString(13, history.getPreviousControlVendorCode());
            stmt.setString(14, history.getNewControlVendorCode());
            stmt.setString(15, history.getRevalMarketingAirlineCode());
            stmt.setString(16, history.getRevalClassofService());
            stmt.setString(17, history.getRevalMarketingFlightNbr());
            stmt.setDate(18, history.getRevalServiceStartDate());
            stmt.setString(19, history.getRevalServiceStartCity());
            stmt.setString(20, history.getRevalServiceEndCity());
            stmt.setTime(21, history.getRevalServiceStartTime());
            stmt.setTime(22, history.getRevalServiceEndTime());
            stmt.setString(23, history.getRevalSegmentStatusCode());
            stmt.setDate(24, history.getLastUpdate());
            stmt.setTime(25, history.getLastUpdateSysTime());
            stmt.setInt(26, history.getHistorySeqNbr());
            stmt.setObject(27, utility.nowUtcTimestamp(), Types.TIMESTAMP);
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
     		ArrayList<TktCouponHistory> tktCouponHistory = new ArrayList<TktCouponHistory>();
    		for (Object flight : flights) {
    			tktCouponHistory.add((TktCouponHistory) flight);
    		}
     		PreparedStatement stmt = null;

     		// Read the SQL insert query from the file
     		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteTktCouponHistory.sql");

     		// Create a PreparedStatement to execute the SQL query
     		stmt = connection.prepareStatement(sql);

     		// Add the flight data to the batch for bulk insertion
     		for (TktCouponHistory res : tktCouponHistory) {
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
