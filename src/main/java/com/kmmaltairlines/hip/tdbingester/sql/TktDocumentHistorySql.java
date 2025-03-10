package com.kmmaltairlines.hip.tdbingester.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.TktDocumentHistory;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class TktDocumentHistorySql {

    @Autowired
    Utility utility;

    /**
     * Inserts a list of TktDocumentHistory records into the database in bulk.
     * 
     * @param tktDocumentHistoryList - List of TktDocumentHistory objects to be inserted
     * @param connection - Database connection object
     * @throws SQLException - If a database error occurs
     * @throws IOException - If an error occurs while reading SQL files
     */
    public void insert(List<TktDocumentHistory> tktDocumentHistoryList, Connection connection) throws SQLException, IOException {

        PreparedStatement stmt = null;

        // Read the SQL insert query from the file
        String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertTktDocumentHistory.sql");

        // Prepare the SQL statement
        stmt = connection.prepareStatement(sql);

        // Add TktCouponHistory data to the batch for bulk insertion
        for (TktDocumentHistory document : tktDocumentHistoryList) {
        	stmt.setString(1, document.getID());
        	stmt.setString(2, document.getPNRLocatorID());
        	stmt.setDate(3, document.getPNRCreateDate());
        	stmt.setInt(4, document.getHistorySeqNbr());
        	stmt.setString(5, document.getHistoryCd());
        	stmt.setString(6, document.getAAACityCode());
        	stmt.setString(7, document.getHomeCityCode());
        	stmt.setString(8, document.getAgentDutyCode());
        	stmt.setString(9, document.getAgentSine());
        	stmt.setDate(10, document.getLastUpdate());
        	stmt.setTime(11, document.getLastUpdateSysTime());
        	stmt.setString(12, document.getPreviousPNRLocatorId());
        	stmt.setString(13, document.getCPNBitMap());
        	stmt.setString(14, document.getNewPNRLocatorID());
        	stmt.setString(15, document.getAirlineAccountingCode());
        	stmt.setString(16, document.getDocNbr());
        	stmt.setString(17, document.getUpdateCRSCode());
        	stmt.setString(18, document.getUpdateAirlineCode());
        	stmt.setByte(19, document.getPurgeDueToAging());
        	stmt.setByte(20, document.getPurgeRequestByTCN());
        	stmt.setByte(21, document.getDay7Purge());
        	stmt.setString(22, document.getInputMsg());
        	stmt.setString(23, document.getRemarkTxt());
        	stmt.setString(24, document.getOACDefaultPartitionCode());
        	stmt.setString(25, document.getOACCityCode());
        	stmt.setString(26, document.getOACAcctCode());
        	stmt.setString(27, document.getOACStationNbr());

            stmt.addBatch(); // Add this record to the batch
        }

        // Execute the batch insert
        int[] results = stmt.executeBatch();

        System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
        stmt.close();
    }
}
