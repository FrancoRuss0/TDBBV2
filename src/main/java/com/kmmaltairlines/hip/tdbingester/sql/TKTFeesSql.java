package com.kmmaltairlines.hip.tdbingester.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.TKTFees;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class TKTFeesSql {

    @Autowired
    Utility utility;

    /**
     * Inserts a list of TktCouponHistory records into the database in bulk.
     * 
     * @param tktCouponHistoryList - List of TktCouponHistory objects to be inserted
     * @param connection - Database connection object
     * @throws SQLException - If a database error occurs
     * @throws IOException - If an error occurs while reading SQL files
     */
    public void insert(List<TKTFees> tktFees, Connection connection) throws SQLException, IOException {

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
        	stmt.setString(4, fees.getFeeTypeCd());
        	stmt.setString(5, fees.getFeeCatCd());
        	stmt.setString(6, fees.getFeeCurrCd());
        	stmt.setBigDecimal(7, fees.getFeeAmt());
        	stmt.setBigDecimal(8, fees.getFeeAmtUSD());
        	stmt.setString(9, fees.getApplyCreditInd());
        	stmt.setString(10, fees.getFeeSubCategory());
        	stmt.setString(11, fees.getFeeWaivedInd());
        	stmt.setString(12, fees.getFeeDescription());
        	stmt.setString(13, fees.getFeePriceCd());
        	stmt.setString(14, fees.getFeeWaiverCd());

            stmt.addBatch(); // Add this record to the batch
        }

        // Execute the batch insert
        int[] results = stmt.executeBatch();

        System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
        stmt.close();
    }
}
