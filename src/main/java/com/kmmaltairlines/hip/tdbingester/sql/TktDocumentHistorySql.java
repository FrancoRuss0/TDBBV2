package com.kmmaltairlines.hip.tdbingester.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kmmaltairlines.hip.tdbingester.filepojos.TktDocument;
import com.kmmaltairlines.hip.tdbingester.filepojos.TktDocumentHistory;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("TktDocumentHistorySql")
public class TktDocumentHistorySql implements MethodInterface{

	@Autowired
	Utility utility;

	private static final Logger logger = LogManager.getLogger(TktDocumentHistorySql.class);

    /**
     * Inserts a list of TktDocumentHistory records into the database in bulk.
     * 
     * @param tktDocumentHistoryList - List of TktDocumentHistory objects to be inserted
     * @param connection - Database connection object
     * @throws SQLException - If a database error occurs
     * @throws IOException - If an error occurs while reading SQL files
     */
	@Override
	@Transactional
    public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		
		ArrayList<TktDocumentHistory> tktDocumentHistory = new ArrayList<TktDocumentHistory>();
		for (Object flight : flights) {
			tktDocumentHistory.add((TktDocumentHistory) flight);
		}
		
        PreparedStatement stmt = null;

        // Read the SQL insert query from the file
        String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertTktDocumentHistory.sql");

        // Prepare the SQL statement
        stmt = connection.prepareStatement(sql);

        // Add TktCouponHistory data to the batch for bulk insertion
        for (TktDocumentHistory document : tktDocumentHistory) {
        	stmt.setString(1, document.getID());
        	stmt.setString(2, document.getPNRLocatorID());
        	stmt.setDate(3, document.getPNRCreateDate());
        	stmt.setString(4, document.getPrimaryDocNbr());
        	stmt.setDate(5, document.getVCRCreateDate());
        	stmt.setTimestamp(6, document.getTransactionDateTime());
        	stmt.setInt(7, document.getHistorySeqNbr());
        	stmt.setString(8, document.getHistoryCd());
        	stmt.setString(9, document.getAAACityCode());
        	stmt.setString(10, document.getHomeCityCode());
        	stmt.setString(11, document.getAgentDutyCode());
        	stmt.setString(12, document.getAgentSine());
        	stmt.setDate(13, document.getLastUpdate());
        	stmt.setTime(14, document.getLastUpdateSysTime());
        	stmt.setString(15, document.getPreviousPNRLocatorId());
        	stmt.setString(16, document.getCPNBitMap());
        	stmt.setString(17, document.getNewPNRLocatorID());
        	stmt.setString(18, document.getAirlineAccountingCode());
        	stmt.setString(19, document.getDocNbr());
        	stmt.setString(20, document.getUpdateCRSCode());
        	stmt.setString(21, document.getUpdateAirlineCode());
        	stmt.setByte(22, document.getPurgeDueToAging());
        	stmt.setByte(23, document.getPurgeRequestByTCN());
        	stmt.setByte(24, document.getDay7Purge());
        	stmt.setString(25, document.getInputMsg());
        	stmt.setString(26, document.getRemarkTxt());
        	stmt.setString(27, document.getOACDefaultPartitionCode());
        	stmt.setString(28, document.getOACCityCode());
        	stmt.setString(29, document.getOACAcctCode());
        	stmt.setString(30, document.getOACStationNbr());
        	stmt.setObject(31, utility.nowUtcTimestamp(), Types.TIMESTAMP);


            stmt.addBatch(); // Add this record to the batch
        }

     // Execute the batch insert
     		int[] results = stmt.executeBatch();

     		logger.info("Bulk insert completed successfully. " + results.length + " records inserted.");
     		stmt.close();
     	}

     	@Override
     	@Transactional
     	public String delete(List<Object> flights, Connection connection) throws SQLException, IOException {
     		ArrayList<TktDocumentHistory> tktDocumentHistory = new ArrayList<TktDocumentHistory>();
    		for (Object flight : flights) {
    			tktDocumentHistory.add((TktDocumentHistory) flight);
    		}
     		PreparedStatement stmt = null;

     		// Read the SQL insert query from the file
     		String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteTktDocumentHistory.sql");

     		// Create a PreparedStatement to execute the SQL query
     		stmt = connection.prepareStatement(sql);

     		// Add the flight data to the batch for bulk insertion
     		for (TktDocumentHistory res : tktDocumentHistory) {
     			stmt.setString(1, res.getPrimaryDocNbr());
     			stmt.setDate(2, res.getVCRCreateDate());
     			// Add the statement to the batch
     			stmt.addBatch();
     		}

     		// Execute the batch insert
     		int[] results = stmt.executeBatch();
     		String back = stmt.executeBatch().toString();
     		logger.info("Delete completed successfully. " + results.length + " records deleted.");
     		stmt.close();
     		return back;
     	}
}
