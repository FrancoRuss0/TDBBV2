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

import com.kmmaltairlines.hip.tdbingester.filepojos.TKTFees;
import com.kmmaltairlines.hip.tdbingester.filepojos.TktDocument;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("TKTFeesSql")
public class TKTFeesSql implements MethodInterface{

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(TKTFeesSql.class);

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
		
		ArrayList<TKTFees> tktFees = new ArrayList<TKTFees>();
		for (Object flight : flights) {
			tktFees.add((TKTFees) flight);
		}
		
        PreparedStatement stmt = null;

        // Read the SQL insert query from the file
        String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertTKTFees.sql");

        // Prepare the SQL statement
        stmt = connection.prepareStatement(sql);

        // Add TktCouponHistory data to the batch for bulk insertion
        for (TKTFees fees : tktFees) {
        	stmt.setString(1, fees.getID());
        	stmt.setString(2, fees.getSourceSystemId());
        	stmt.setInt(3, fees.getFeeSequenceNbr());
        	stmt.setString(5, fees.getPrimaryDocNbr());
			stmt.setDate(6, fees.getVCRCreateDate());
			stmt.setTimestamp(7, fees.getTransactionDateTime());
        	stmt.setString(8, fees.getFeeTypeCd());
        	stmt.setString(9, fees.getFeeCatCd());
        	stmt.setString(10, fees.getFeeCurrCd());
        	stmt.setBigDecimal(11, fees.getFeeAmt());
        	stmt.setBigDecimal(12, fees.getFeeAmtUSD());
        	stmt.setString(13, fees.getApplyCreditInd());
        	stmt.setString(14, fees.getFeeSubCategory());
        	stmt.setString(15, fees.getFeeWaivedInd());
        	stmt.setString(16, fees.getFeeDescription());
        	stmt.setString(17, fees.getFeePriceCd());
        	stmt.setString(18, fees.getFeeWaiverCd());
        	stmt.setObject(19, utility.nowUtcTimestamp(), Types.TIMESTAMP);
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
     		ArrayList<TKTFees> tktFees = new ArrayList<TKTFees>();
    		for (Object flight : flights) {
    			tktFees.add((TKTFees) flight);
    		}
     		PreparedStatement stmt = null;

     		// Read the SQL insert query from the file
     		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteTKTFees.sql");

     		// Create a PreparedStatement to execute the SQL query
     		stmt = connection.prepareStatement(sql);

     		// Add the flight data to the batch for bulk insertion
     		for (TKTFees res : tktFees) {
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
