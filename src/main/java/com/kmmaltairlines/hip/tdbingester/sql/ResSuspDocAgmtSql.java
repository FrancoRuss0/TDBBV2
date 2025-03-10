package com.kmmaltairlines.hip.tdbingester.sql;
 

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResSuspDocAgmt;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class ResSuspDocAgmtSql {

    @Autowired
    Utility utility;

    /**
     * Inserts a list of ResSuspDocAgmt records into the database in bulk.
     * 
     * @param resSuspDocAgmts - List of ResSuspDocAgmt objects to be inserted
     * @param connection - Database connection object
     * @throws SQLException - If a database error occurs
     * @throws IOException - If an error occurs while reading SQL files
     */
    public void insert(List<ResSuspDocAgmt> resSuspDocAgmts, Connection connection) throws SQLException, IOException {

        PreparedStatement stmt = null;

        // Read the SQL insert query from the file
        String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResSuspDocAgmt.sql");

        // Prepare the SQL statement
        stmt = connection.prepareStatement(sql);

        // Add ResSuspDocAgmt data to the batch for bulk insertion
        for (ResSuspDocAgmt docAgmt : resSuspDocAgmts) {
            stmt.setString(1, docAgmt.getID());
            stmt.setShort(2, docAgmt.getPNRPassengerSeqID());
            stmt.setShort(3, docAgmt.getResArrSequenceId());
            stmt.setDate(4, docAgmt.getResArrQueuePlaceDate());
            stmt.setString(5, docAgmt.getResArrQueueName());
            stmt.setString(6, docAgmt.getResArrangementLocationCode());
            stmt.setString(7, docAgmt.getArrPassengerReferenceName());
            stmt.setDate(8, docAgmt.getArrActivityDate());
            stmt.setTime(9, docAgmt.getArrActivityTime());
            stmt.setString(10, docAgmt.getArrDutyCode());
            stmt.setString(11, docAgmt.getArrSine());
            stmt.setString(12, docAgmt.getSSRText());
            stmt.setString(13, docAgmt.getSSRCode());
            stmt.setString(14, docAgmt.getSourceTypeCode());
            stmt.setString(15, docAgmt.getSSRIdTypeCode());
            stmt.setString(16, docAgmt.getResArrActionCode());
            stmt.setString(17, docAgmt.getServiceStartCityCode());
            stmt.setString(18, docAgmt.getServiceEndCityCode());
            stmt.setString(19, docAgmt.getTicketNbr());
            stmt.setShort(20, docAgmt.getSSRNbrInParty());
            stmt.setDate(21, docAgmt.getSSRStartDate());
            stmt.setString(22, docAgmt.getSSRFlightNumber());
            stmt.setString(23, docAgmt.getClassOfService());
            stmt.setString(24, docAgmt.getVendorCode());
            stmt.setString(25, docAgmt.getSSRStatusCode());
            stmt.setString(26, docAgmt.getHistoryActionCodeId());
            stmt.setDate(27, docAgmt.getRecordUpdateDate());
            stmt.setTime(28, docAgmt.getRecordUpdateTime());
            stmt.setShort(29, docAgmt.getIntraPNRSetNbr());
            stmt.addBatch(); // Add this record to the batch
        }

        // Execute the batch insert
        int[] results = stmt.executeBatch();

        System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
        stmt.close();
    }
}
