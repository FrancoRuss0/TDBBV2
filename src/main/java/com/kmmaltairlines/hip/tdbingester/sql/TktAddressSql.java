package com.kmmaltairlines.hip.tdbingester.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.TktAddress;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class TktAddressSql {

    @Autowired
    Utility utility;

    /**
     * Inserts a list of TktAddress records into the database in bulk.
     * 
     * @param tktAddresses - List of TktAddress objects to be inserted
     * @param connection - Database connection object
     * @throws SQLException - If a database error occurs
     * @throws IOException - If an error occurs while reading SQL files
     */
    public void insert(List<TktAddress> tktAddresses, Connection connection) throws SQLException, IOException {

        PreparedStatement stmt = null;

        // Read the SQL insert query from the file
        String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertTktAddress.sql");

        // Prepare the SQL statement
        stmt = connection.prepareStatement(sql);

        // Add TktAddress data to the batch for bulk insertion
        for (TktAddress address : tktAddresses) {
            stmt.setString(1, address.getID());
            stmt.setString(2, address.getPNRLocatorID());
            stmt.setDate(3, address.getPNRCreateDate());
            stmt.setShort(4, address.getAddrSeqNbr());
            stmt.setString(5, address.getAddrTxt());
            stmt.addBatch(); // Add this record to the batch
        }

        // Execute the batch insert
        int[] results = stmt.executeBatch();

        System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
        stmt.close();
    }
}
