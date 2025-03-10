package com.kmmaltairlines.hip.tdbingester.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.TktMSR;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class TktMSRSql {

    @Autowired
    Utility utility;


    public void insert(List<TktMSR> tktMSR, Connection connection) throws SQLException, IOException {

        PreparedStatement stmt = null;

        // Read the SQL insert query from the file
        String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertTktMSR.sql");

        // Prepare the SQL statement
        stmt = connection.prepareStatement(sql);

        // Add TktCouponHistory data to the batch for bulk insertion
        for (TktMSR msr : tktMSR) {
        	stmt.setString(1, msr.getID());
        	stmt.setString(2, msr.getPNRLocatorID());
        	stmt.setDate(3, msr.getPNRCreateDate());
        	stmt.setShort(4, msr.getMSRSeqNbr());
        	stmt.setByte(5, msr.getMSRQuantitySoldCount());
        	stmt.setString(6, msr.getMSRTypeCode());
        	stmt.setString(7, msr.getMSRTypeDesc());
        	stmt.setString(8, msr.getMSRCurrencyCode());
        	stmt.setBigDecimal(9, msr.getMSRChargeAmount());
        	stmt.setBigDecimal(10, msr.getMSRTaxAmount());
        	stmt.setString(11, msr.getMSRTaxCurrencyCode());
        	stmt.setString(12, msr.getSourceSystemId());
        	stmt.setString(13, msr.getOCGroupCode());
        	stmt.setString(14, msr.getRFISubCode());

            stmt.addBatch(); // Add this record to the batch
        }

        // Execute the batch insert
        int[] results = stmt.executeBatch();

        System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
        stmt.close();
    }
}
