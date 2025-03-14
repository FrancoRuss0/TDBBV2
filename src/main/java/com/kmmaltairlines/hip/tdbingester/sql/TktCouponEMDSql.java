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

import com.kmmaltairlines.hip.tdbingester.filepojos.TktCouponEMD;
import com.kmmaltairlines.hip.tdbingester.filepojos.TktDocument;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("TktCouponEMDSql")
public class TktCouponEMDSql implements MethodInterface{

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(TktCouponEMDSql.class);

    /**
     * Inserts a list of TktCouponEMD records into the database in bulk.
     * 
     * @param tktCouponEMDs - List of TktCouponEMD objects to be inserted
     * @param connection - Database connection object
     * @throws SQLException - If a database error occurs
     * @throws IOException - If an error occurs while reading SQL files
     */
	@Override
	@Transactional
    public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		
		ArrayList<TktCouponEMD> TktCouponEMD = new ArrayList<TktCouponEMD>();
		for (Object flight : flights) {
			TktCouponEMD.add((TktCouponEMD) flight);
		}
		
        PreparedStatement stmt = null;

        // Read the SQL insert query from the file
        String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertTktCouponEMD.sql");

        // Prepare the SQL statement
        stmt = connection.prepareStatement(sql);

        // Add TktCouponEMD data to the batch for bulk insertion
        for (TktCouponEMD couponEMD : TktCouponEMD) {
            stmt.setString(1, couponEMD.getID());
            stmt.setString(2, couponEMD.getPNRLocatorID());
            stmt.setDate(3, couponEMD.getPNRCreateDate());
            stmt.setString(4, couponEMD.getPrimaryDocNbr());
			stmt.setDate(5, couponEMD.getVCRCreateDate());
			stmt.setTimestamp(6, couponEMD.getTransactionDateTime());
            stmt.setShort(7, couponEMD.getCouponSeqNbr());
            stmt.setString(8, couponEMD.getFeeOwnerCode());
            stmt.setString(9, couponEMD.getOCGroupCode());
            stmt.setString(10, couponEMD.getRFICode());
            stmt.setInt(11, couponEMD.getQuantSold());
            stmt.setString(12, couponEMD.getRFISubCode());
            stmt.setString(13, couponEMD.getCommercialName());
            stmt.setString(14, couponEMD.getEMDTypeCode());
            stmt.setString(15, couponEMD.getFeeGuaranteedInd());
            stmt.setString(16, couponEMD.getFeeVendorCode());
            stmt.setString(17, couponEMD.getSegmentUseCode());
            stmt.setString(18, couponEMD.getRelPrimaryDocNbr());
            stmt.setByte(19, couponEMD.getRelCouponSeqNbr());
            stmt.setDate(20, couponEMD.getRelVCRCreateDate());
            stmt.setObject(21, utility.nowUtcTimestamp(), Types.TIMESTAMP);
            // Add this record to the batch
            stmt.addBatch();
        }

     // Execute the batch insert
     		int[] results = stmt.executeBatch();

     		logger.info("Bulk insert completed successfully. " + results.length + " records inserted.");
     		stmt.close();
     	}

     	@Override
     	@Transactional
     	public String delete(List<Object> flights, Connection connection) throws SQLException, IOException {
     		ArrayList<TktCouponEMD> TktCouponEMD = new ArrayList<TktCouponEMD>();
    		for (Object flight : flights) {
    			TktCouponEMD.add((TktCouponEMD) flight);
    		}
     		PreparedStatement stmt = null;

     		// Read the SQL insert query from the file
     		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteTktCouponEMD.sql");

     		// Create a PreparedStatement to execute the SQL query
     		stmt = connection.prepareStatement(sql);

     		// Add the flight data to the batch for bulk insertion
     		for (TktCouponEMD res : TktCouponEMD) {
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
