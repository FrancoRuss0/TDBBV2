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

import com.kmmaltairlines.hip.tdbingester.filepojos.TktDocument;
import com.kmmaltairlines.hip.tdbingester.filepojos.TktProRation;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("TktProRationSql")
public class TktProRationSql implements MethodInterface{

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(TktProRationSql.class);

	@Override
	@Transactional
    public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		
		ArrayList<TktProRation> tktProRations = new ArrayList<TktProRation>();
		for (Object flight : flights) {
			tktProRations.add((TktProRation) flight);
		}
		
        PreparedStatement stmt = null;

        // Read the SQL insert query from the file
        String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertTktProRation.sql");

        // Prepare the SQL statement
        stmt = connection.prepareStatement(sql);

        // Add TktCouponHistory data to the batch for bulk insertion
        for (TktProRation proRation : tktProRations) {
        	stmt.setString(1, proRation.getID());
        	stmt.setString(2, proRation.getPNRLocatorID());
        	stmt.setDate(3, proRation.getPNRCreateDate());
        	stmt.setString(4, proRation.getPrimaryDocNbr());
        	stmt.setDate(5, proRation.getVCRCreateDate());
        	stmt.setTimestamp(6, proRation.getTransactionDateTime());
        	stmt.setShort(7, proRation.getCouponSeqNbr());
        	stmt.setBigDecimal(8, proRation.getCouponDistanceKm());
        	stmt.setBigDecimal(9, proRation.getCouponDistanceMi());
        	stmt.setBigDecimal(10, proRation.getProrationFactor());
        	stmt.setBigDecimal(11, proRation.getProrateBaseFareUSD());
        	stmt.setBigDecimal(12, proRation.getProrateTotalDocAmtUSD());
        	stmt.setString(13, proRation.getEquivBaseFareCurrCode());
        	stmt.setBigDecimal(14, proRation.getEquivUSDExchgRate());
        	stmt.setBigDecimal(15, proRation.getProrateEquivBaseFareAmt());
        	stmt.setBigDecimal(16, proRation.getProrateEquivTotalDocAmt());
        	stmt.setString(17, proRation.getOwnerCurrencyCode());
        	stmt.setBigDecimal(18, proRation.getProrateBaseFareOwnerAmt());
        	stmt.setBigDecimal(19, proRation.getProrateTotalDocOwnerAmt());
        	stmt.setObject(20, utility.nowUtcTimestamp(), Types.TIMESTAMP);


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
     		ArrayList<TktProRation> tktProRations = new ArrayList<TktProRation>();
    		for (Object flight : flights) {
    			tktProRations.add((TktProRation) flight);
    		}
     		PreparedStatement stmt = null;

     		// Read the SQL insert query from the file
     		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteTktProRation.sql");

     		// Create a PreparedStatement to execute the SQL query
     		stmt = connection.prepareStatement(sql);

     		// Add the flight data to the batch for bulk insertion
     		for (TktProRation res : tktProRations) {
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
