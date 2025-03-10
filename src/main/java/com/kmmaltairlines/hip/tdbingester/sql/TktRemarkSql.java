package com.kmmaltairlines.hip.tdbingester.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.TktRemark;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class TktRemarkSql {

    @Autowired
    Utility utility;


    public void insert(List<TktRemark> tktRemarks, Connection connection) throws SQLException, IOException {

        PreparedStatement stmt = null;

        // Read the SQL insert query from the file
        String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertTktRemark.sql");

        // Prepare the SQL statement
        stmt = connection.prepareStatement(sql);

        // Add TktCouponHistory data to the batch for bulk insertion
        for (TktRemark remark : tktRemarks) {
        	stmt.setString(1, remark.getID());
        	stmt.setString(2, remark.getPNRLocatorID());
        	stmt.setDate(3, remark.getPNRCreateDate());
        	stmt.setShort(4, remark.getRemarkSeqNbr());
        	stmt.setString(5, remark.getRemarkTxt());

            stmt.addBatch(); // Add this record to the batch
        }

        // Execute the batch insert
        int[] results = stmt.executeBatch();

        System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
        stmt.close();
    }
}
