package com.kmmaltairlines.hip.tdbingester.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.TktEndorsement;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class TktEndorsementSql {

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
    public void insert(List<TktEndorsement> tktEndorsements, Connection connection) throws SQLException, IOException {

        PreparedStatement stmt = null;

        // Read the SQL insert query from the file
        String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertTktEndorsement.sql");

        // Prepare the SQL statement
        stmt = connection.prepareStatement(sql);

        // Add TktCouponHistory data to the batch for bulk insertion
        for (TktEndorsement endorsement : tktEndorsements) {
        	stmt.setString(1, endorsement.getID());
        	stmt.setString(2, endorsement.getPNRLocatorID());
        	stmt.setDate(3, endorsement.getPNRCreateDate());
        	stmt.setInt(4, endorsement.getEndSeqNbr());
        	stmt.setString(5, endorsement.getEndorsements());

            stmt.addBatch(); // Add this record to the batch
        }

        // Execute the batch insert
        int[] results = stmt.executeBatch();

        System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
        stmt.close();
    }
}
