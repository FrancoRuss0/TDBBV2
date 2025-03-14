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
import com.kmmaltairlines.hip.tdbingester.filepojos.TktPayment;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("TktPaymentSql")
public class TktPaymentSql implements MethodInterface{

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(TktPaymentSql.class);

	@Override
	@Transactional
    public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		
		ArrayList<TktPayment> tktPayments = new ArrayList<TktPayment>();
		for (Object flight : flights) {
			tktPayments.add((TktPayment) flight);
		}
		
        PreparedStatement stmt = null;

        // Read the SQL insert query from the file
        String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertTktPayment.sql");

        // Prepare the SQL statement
        stmt = connection.prepareStatement(sql);

        // Add TktCouponHistory data to the batch for bulk insertion
        for (TktPayment payment : tktPayments) {
        	stmt.setString(1, payment.getID());
        	stmt.setString(2, payment.getPNRLocatorID());
        	stmt.setDate(3, payment.getPNRCreateDate());
        	stmt.setString(4, payment.getPrimaryDocNbr());
        	stmt.setDate(5, payment.getVCRCreateDate());
        	stmt.setTimestamp(6, payment.getTransactionDateTime());
        	stmt.setShort(7, payment.getPaymentSeqNbr());
        	stmt.setString(8, payment.getFOPCode());
        	stmt.setBigDecimal(9, payment.getPaymentAmt());
        	stmt.setString(10, payment.getPaymentVendorCode());
        	stmt.setString(11, payment.getAcctNbr());
        	stmt.setString(12, payment.getPaymentCurrCode());
        	stmt.setString(13, payment.getPaymentRemarks());
        	stmt.setString(14, payment.getPaymentApprovalCode());
        	stmt.setString(15, payment.getPaymentApprovalTypeCode());
        	stmt.setObject(16, utility.nowUtcTimestamp(), Types.TIMESTAMP);


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
     		ArrayList<TktPayment> tktPayments = new ArrayList<TktPayment>();
    		for (Object flight : flights) {
    			tktPayments.add((TktPayment) flight);
    		}
    		
     		PreparedStatement stmt = null;

     		// Read the SQL insert query from the file
     		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteTktPayment.sql");

     		// Create a PreparedStatement to execute the SQL query
     		stmt = connection.prepareStatement(sql);

     		// Add the flight data to the batch for bulk insertion
     		for (TktPayment res : tktPayments) {
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
