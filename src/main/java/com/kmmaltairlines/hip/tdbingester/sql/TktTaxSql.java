package com.kmmaltairlines.hip.tdbingester.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.TktTax;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class TktTaxSql {

    @Autowired
    Utility utility;
    
    public void insert(List<TktTax> tktTaxes, Connection connection) throws SQLException, IOException {

        PreparedStatement stmt = null;

        // Read the SQL insert query from the file
        String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertTktTax.sql");

        // Prepare the SQL statement
        stmt = connection.prepareStatement(sql);

        // Add TktCouponHistory data to the batch for bulk insertion
        for (TktTax tax : tktTaxes) {
        	stmt.setString(1, tax.getID());
        	stmt.setString(2, tax.getPNRLocatorID());
        	stmt.setDate(3, tax.getPNRCreateDate());
        	stmt.setByte(4, tax.getTaxSeqNbr());
        	stmt.setBigDecimal(5, tax.getTaxAmt());
        	stmt.setString(6, tax.getTaxCode());
        	stmt.setString(7, tax.getTaxTypeCode());
        	stmt.setString(8, tax.getTaxCategoryCode());
        	stmt.setString(9, tax.getTaxCurrCode());

            stmt.addBatch(); // Add this record to the batch
        }

        // Execute the batch insert
        int[] results = stmt.executeBatch();

        System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
        stmt.close();
    }
}
