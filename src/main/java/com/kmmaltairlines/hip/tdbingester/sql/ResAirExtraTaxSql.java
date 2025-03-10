package com.kmmaltairlines.hip.tdbingester.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResAirExtraTax;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class ResAirExtraTaxSql {

    @Autowired
    Utility utility;

    /**
     * Inserts ResAirExtraTax records into the database in bulk.
     * 
     * @param resAirExtraTax - List of ResAirExtraTax objects to be inserted
     * @param connessione - Connection object for the database connection
     * @throws SQLException - If an error occurs while executing the SQL query
     * @throws IOException - If an error occurs while reading SQL files
     */
    public void insert(List<ResAirExtraTax> resAirExtraTax, Connection connection) throws SQLException, IOException {
 
        PreparedStatement stmt = null;

        // Read the SQL insert query from the file
        String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResAirExtraTax.sql");

        // Create a PreparedStatement to execute the SQL query
        stmt = connection.prepareStatement(sql);

        // Add the ResAirExtraTax data to the batch for bulk insertion
        for (ResAirExtraTax airExtraTax : resAirExtraTax) {
            stmt.setString(1, airExtraTax.getID());
            stmt.setByte(2, airExtraTax.getAETaxSeqNbr());
            stmt.setShort(3, airExtraTax.getPNRPassengerSeqId());
            stmt.setString(4, airExtraTax.getRFISubCode());
            stmt.setString(5, airExtraTax.getTaxCode());
            stmt.setBigDecimal(6, airExtraTax.getTaxAmount());
            stmt.setDate(7, airExtraTax.getRecordUpdateDate());
            stmt.setTime(8, airExtraTax.getRecordUpdateTime());
            stmt.setShort(9, airExtraTax.getIntraPNRSetNbr());
            stmt.addBatch();
        }

        // Execute the batch insert
        int[] results = stmt.executeBatch();

        System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
        stmt.close();
    }
}
