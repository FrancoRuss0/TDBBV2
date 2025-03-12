package com.kmmaltairlines.hip.tdbingester.sql;
 

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kmmaltairlines.hip.tdbingester.filepojos.Res;
import com.kmmaltairlines.hip.tdbingester.filepojos.ResSuspDocAgmt;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.OneIteration;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("ResSuspDocAgmtSql")
public class ResSuspDocAgmtSql implements MethodInterface{
	
	@Autowired
	Utility utility;
	
	private static final Logger logger = LogManager.getLogger(ResSuspDocAgmtSql.class);
	
    /**
     * Inserts a list of ResSuspDocAgmt records into the database in bulk.
     * 
     * @param resSuspDocAgmts - List of ResSuspDocAgmt objects to be inserted
     * @param connection - Database connection object
     * @throws SQLException - If a database error occurs
     * @throws IOException - If an error occurs while reading SQL files
     */
	@Override
	@Transactional
    public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		ArrayList<ResSuspDocAgmt> trasformResSuspDocAgmt = new ArrayList<ResSuspDocAgmt>();
		for (Object flight : flights) {
			trasformResSuspDocAgmt.add((ResSuspDocAgmt) flight);
		}
        PreparedStatement stmt = null;
        // Read the SQL insert query from the file
        String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResSuspDocAgmt.sql");

        // Prepare the SQL statement
        stmt = connection.prepareStatement(sql);

        // Add ResSuspDocAgmt data to the batch for bulk insertion
        for (ResSuspDocAgmt docAgmt : trasformResSuspDocAgmt) {
            stmt.setString(1, docAgmt.getID());
            stmt.setString(2, docAgmt.getPNRLocatorID());
            stmt.setObject(3, docAgmt.getPNRCreateDate(), Types.DATE);
            stmt.setTimestamp(4, docAgmt.getFromDateTime());
            if(docAgmt.getPNRPassengerSeqID()==null) {
		    	stmt.setNull(5, Types.NULL);
		    }else{
		    	stmt.setShort(5, docAgmt.getPNRPassengerSeqID());
		    }
            
            if(docAgmt.getResArrSequenceId()==null) {
		    	stmt.setNull(6, Types.NULL);
		    }else{
		    	stmt.setShort(6, docAgmt.getResArrSequenceId());
		    }
            
           
            stmt.setDate(7, docAgmt.getResArrQueuePlaceDate());
            stmt.setString(8, docAgmt.getResArrQueueName());
            stmt.setString(9, docAgmt.getResArrangementLocationCode());
            stmt.setString(10, docAgmt.getArrPassengerReferenceName());
            stmt.setDate(11, docAgmt.getArrActivityDate());
            stmt.setTime(12, docAgmt.getArrActivityTime());
            stmt.setString(13, docAgmt.getArrDutyCode());
            stmt.setString(14, docAgmt.getArrSine());
            stmt.setString(15, docAgmt.getSSRText());
            stmt.setString(16, docAgmt.getSSRCode());
            stmt.setString(17, docAgmt.getSourceTypeCode());
            stmt.setString(18, docAgmt.getSSRIdTypeCode());
            stmt.setString(19, docAgmt.getResArrActionCode());
            stmt.setString(20, docAgmt.getServiceStartCityCode());
            stmt.setString(21, docAgmt.getServiceEndCityCode());
            stmt.setString(22, docAgmt.getTicketNbr());
            if(docAgmt.getSSRNbrInParty()==null) {
		    	stmt.setNull(23, Types.NULL);
		    }else{
		    	stmt.setShort(23, docAgmt.getSSRNbrInParty());
		    }
            
            stmt.setDate(24, docAgmt.getSSRStartDate());
            stmt.setString(25, docAgmt.getSSRFlightNumber());
            stmt.setString(26, docAgmt.getClassOfService());
            stmt.setString(27, docAgmt.getVendorCode());
            stmt.setString(28, docAgmt.getSSRStatusCode());
            stmt.setString(29, docAgmt.getHistoryActionCodeId());
            stmt.setDate(30, docAgmt.getRecordUpdateDate());
            stmt.setTime(31, docAgmt.getRecordUpdateTime());
            if(docAgmt.getIntraPNRSetNbr()==null) {
		    	stmt.setNull(32, Types.NULL);
		    }else{
		    	stmt.setShort(32, docAgmt.getIntraPNRSetNbr());
		    }
            stmt.setObject(33, utility.nowUtcTimestamp(), Types.TIMESTAMP);
            stmt.addBatch(); // Add this record to the batch
        }

        // Execute the batch insert
        int[] results = stmt.executeBatch();

		logger.info("Bulk insert completed successfully. " + results.length + " records inserted.");
        stmt.close();
    }

	@Override
	public String delete(List<Object> flights, Connection connection) throws SQLException, IOException {
		ArrayList<ResSuspDocAgmt> trasformRes = new ArrayList<ResSuspDocAgmt>();
		for (Object flight : flights) {
			trasformRes.add((ResSuspDocAgmt) flight);
		}
		PreparedStatement stmt = null;

			// Read the SQL insert query from the file
			String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteResSuspDocAgmt.sql");

			// Create a PreparedStatement to execute the SQL query
			stmt = connection.prepareStatement(sql);

			// Add the flight data to the batch for bulk insertion
			for (ResSuspDocAgmt res : trasformRes) {
				 	stmt.setString(1, res.getPNRLocatorID());
				 	stmt.setDate(2, res.getPNRCreateDate());
	                // Add the statement to the batch
	                stmt.addBatch();
			}

			// Execute the batch insert
			int[] results = stmt.executeBatch();
			String back=stmt.executeBatch().toString();
			logger.info("Delete completed successfully. " + results.length + " records deleted.");
	        stmt.close();
		return back;
	}
}
