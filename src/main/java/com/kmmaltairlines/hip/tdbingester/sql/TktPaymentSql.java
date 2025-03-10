package com.kmmaltairlines.hip.tdbingester.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.TktPayment;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class TktPaymentSql {

    @Autowired
    Utility utility;


    public void insert(List<TktPayment> tktPayments, Connection connection) throws SQLException, IOException {

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
        	stmt.setShort(4, payment.getPaymentSeqNbr());
        	stmt.setString(5, payment.getFOPCode());
        	stmt.setBigDecimal(6, payment.getPaymentAmt());
        	stmt.setString(7, payment.getPaymentVendorCode());
        	stmt.setString(8, payment.getAcctNbr());
        	stmt.setString(9, payment.getPaymentCurrCode());
        	stmt.setString(10, payment.getPaymentRemarks());
        	stmt.setString(11, payment.getPaymentApprovalCode());
        	stmt.setString(12, payment.getPaymentApprovalTypeCode());


            stmt.addBatch(); // Add this record to the batch
        }

        // Execute the batch insert
        int[] results = stmt.executeBatch();

        System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
        stmt.close();
    }
}
