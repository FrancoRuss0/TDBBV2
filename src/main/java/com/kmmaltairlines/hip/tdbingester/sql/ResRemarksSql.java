package com.kmmaltairlines.hip.tdbingester.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResRemarks;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class ResRemarksSql {

    @Autowired
    Utility utility;

    /**
     * Inserts a list of ResRemarks records into the database in bulk.
     * 
     * @param resRemarks - List of ResRemarks objects to be inserted
     * @param connection - Database connection object
     * @throws SQLException - If a database error occurs
     * @throws IOException - If an error occurs while reading SQL files
     */
    public void insert(List<ResRemarks> resRemarks, Connection connection) throws SQLException, IOException {

        PreparedStatement stmt = null;

        // Read the SQL insert query from the file
        String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResRemarks.sql");

        // Prepare the SQL statement
        stmt = connection.prepareStatement(sql);

        // Add ResRemarks data to the batch for bulk insertion
        for (ResRemarks remark : resRemarks) {
            stmt.setString(1, remark.getID());
            stmt.setShort(2, remark.getResRemarkSeqId());
            stmt.setString(3, remark.getRemarkText());
            stmt.setShort(4, remark.getRemarkType());
            stmt.setString(5, remark.getHistoryActionCodeId());
            stmt.setDate(6, remark.getRecordUpdateDate());
            stmt.setTime(7, remark.getRecordUpdateTime());
            stmt.setShort(8, remark.getIntraPNRSetNbr());
            stmt.addBatch(); // Add this record to the batch
        }

        // Execute the batch insert
        int[] results = stmt.executeBatch();

        System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
        stmt.close();
    }
}
