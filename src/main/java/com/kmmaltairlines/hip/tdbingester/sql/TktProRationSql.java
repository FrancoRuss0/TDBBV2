package com.kmmaltairlines.hip.tdbingester.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.TktProRation;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class TktProRationSql {

    @Autowired
    Utility utility;


    public void insert(List<TktProRation> tktProRations, Connection connection) throws SQLException, IOException {

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
        	stmt.setShort(4, proRation.getCouponSeqNbr());
        	stmt.setBigDecimal(5, proRation.getCouponDistanceKm());
        	stmt.setBigDecimal(6, proRation.getCouponDistanceMi());
        	stmt.setBigDecimal(7, proRation.getProrationFactor());
        	stmt.setBigDecimal(8, proRation.getProrateBaseFareUSD());
        	stmt.setBigDecimal(9, proRation.getProrateTotalDocAmtUSD());
        	stmt.setString(10, proRation.getEquivBaseFareCurrCode());
        	stmt.setBigDecimal(11, proRation.getEquivUSDExchgRate());
        	stmt.setBigDecimal(12, proRation.getProrateEquivBaseFareAmt());
        	stmt.setBigDecimal(13, proRation.getProrateEquivTotalDocAmt());
        	stmt.setString(14, proRation.getOwnerCurrencyCode());
        	stmt.setBigDecimal(15, proRation.getProrateBaseFareOwnerAmt());
        	stmt.setBigDecimal(16, proRation.getProrateTotalDocOwnerAmt());


            stmt.addBatch(); // Add this record to the batch
        }

        // Execute the batch insert
        int[] results = stmt.executeBatch();

        System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
        stmt.close();
    }
}
