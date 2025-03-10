package com.kmmaltairlines.hip.tdbingester.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.TktTaxDetail;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class TktTaxDetailSql {

    @Autowired
    Utility utility;
    
    public void insert(List<TktTaxDetail> tktTaxDetails, Connection connection) throws SQLException, IOException {

        PreparedStatement stmt = null;

        // Read the SQL insert query from the file
        String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertTktTaxDetail.sql");

        // Prepare the SQL statement
        stmt = connection.prepareStatement(sql);

        // Add TktCouponHistory data to the batch for bulk insertion
        for (TktTaxDetail taxDetails : tktTaxDetails) {
        	stmt.setString(1, taxDetails.getID());
        	stmt.setString(2, taxDetails.getPNRLocatorID());
        	stmt.setDate(3, taxDetails.getPNRCreateDate());
        	stmt.setByte(4, taxDetails.getTaxSeqNbr());
        	stmt.setBigDecimal(5, taxDetails.getTaxAmt());
        	stmt.setString(6, taxDetails.getTaxCode());
        	stmt.setShort(7, taxDetails.getLocationTypeCode());
        	stmt.setString(8, taxDetails.getServiceCityCode());

            stmt.addBatch(); // Add this record to the batch
        }

        // Execute the batch insert
        int[] results = stmt.executeBatch();

        System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
        stmt.close();
    }
}
