package com.kmmaltairlines.hip.tdbingester.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResTravelArranger;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class ResTravelArrangerSql {

    @Autowired
    Utility utility;

    /**
     * Inserts a list of ResTravelArranger records into the database in bulk.
     * 
     * @param resTravelArrangers - List of ResTravelArranger objects to be inserted
     * @param connection - Database connection object
     * @throws SQLException - If a database error occurs
     * @throws IOException - If an error occurs while reading SQL files
     */
    public void insert(List<ResTravelArranger> resTravelArrangers, Connection connection) throws SQLException, IOException {

        PreparedStatement stmt = null;

        // Read the SQL insert query from the file
        String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResTravelArranger.sql");

        // Prepare the SQL statement
        stmt = connection.prepareStatement(sql);

        // Add ResTravelArranger data to the batch for bulk insertion
        for (ResTravelArranger arranger : resTravelArrangers) {
            stmt.setString(1, arranger.getID());
            stmt.setString(2, arranger.getSignatureType());
            stmt.setString(3, arranger.getUpdateAAACityCode());
            stmt.setString(4, arranger.getUpdateAgentDutyCode());
            stmt.setString(5, arranger.getUpdateAgentSine());
            stmt.setString(6, arranger.getUpdateBookingCRSCode());
            stmt.setString(7, arranger.getUpdateHomeCityCode());
            stmt.setDate(8, arranger.getRecordUpdateDate());
            stmt.setTime(9, arranger.getRecordUpdateTime());
            stmt.setShort(10, arranger.getIntraPNRSetNbr());
            stmt.setString(11, arranger.getReceivedFrom());
            stmt.setString(12, arranger.getUpdateAAAOACCityCode());
            stmt.setString(13, arranger.getUpdateAAAOACAcctCode());
            stmt.setString(14, arranger.getOACDefaultPartitionCode());
            stmt.setString(15, arranger.getOACCityCode());
            stmt.setString(16, arranger.getOACAcctCode());
            stmt.setString(17, arranger.getOACStationNbr());
            stmt.addBatch(); // Add this record to the batch
        }

        // Execute the batch insert
        int[] results = stmt.executeBatch();

        System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
        stmt.close();
    }
}
