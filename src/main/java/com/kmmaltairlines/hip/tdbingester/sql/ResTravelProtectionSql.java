package com.kmmaltairlines.hip.tdbingester.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kmmaltairlines.hip.tdbingester.filepojos.Res;
import com.kmmaltairlines.hip.tdbingester.filepojos.ResTravelProtection;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component("ResTravelProtectionSql")
public class ResTravelProtectionSql implements MethodInterface{

	@Autowired
	Utility utility;
	
	private static final Logger logger = LogManager.getLogger(ResTravelProtectionSql.class);

    /**
     * Inserts a list of ResTravelProtection records into the database in bulk.
     * 
     * @param resTravelProtections - List of ResTravelProtection objects to be inserted
     * @param connection - Database connection object
     * @throws SQLException - If a database error occurs
     * @throws IOException - If an error occurs while reading SQL files
     */
	@Override
	@Transactional
    public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		// Establish database connection
		ArrayList<ResTravelProtection> resTravelProtections = new ArrayList<ResTravelProtection>();
		for (Object flight : flights) {
			resTravelProtections.add((ResTravelProtection) flight);
		}
        PreparedStatement stmt = null;

        // Read the SQL insert query from the file
        String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertResTravelProtection.sql");

        // Prepare the SQL statement
        stmt = connection.prepareStatement(sql);

        // Add ResTravelProtection data to the batch for bulk insertion
        for (ResTravelProtection protection : resTravelProtections) {
            stmt.setString(1, protection.getID());
            stmt.setShort(2, protection.getSegmentNbr());
            stmt.setString(3, protection.getPlanTypeCode());
            stmt.setString(4, protection.getVendorCode());
            stmt.setDate(5, protection.getPurchaseDate());
            stmt.setShort(6, protection.getSegmentType());
            stmt.setString(7, protection.getConfirmationNbr());
            stmt.setString(8, protection.getCurrentSegmentStatusCode());
            stmt.setDate(9, protection.getServiceStartDate());
            stmt.setDate(10, protection.getServiceEndDate());
            stmt.setString(11, protection.getServiceStartCityCode());
            stmt.setString(12, protection.getServiceEndCityCode());
            stmt.setString(13, protection.getFOPCode());
            stmt.setString(14, protection.getPaymentCreditCardCode());
            stmt.setString(15, protection.getPaymentCreditCardNbr());
            stmt.setDate(16, protection.getPaymentCreditCardExpDate());
            stmt.setString(17, protection.getCurrCode());
            stmt.setString(18, protection.getPremiumValue());
            stmt.setBigDecimal(19, protection.getPremiumAmt());
            stmt.setBigDecimal(20, protection.getPremiumAmtUSD());
            stmt.setDate(21, protection.getRecordUpdateDate());
            stmt.setTime(22, protection.getRecordUpdateTime());
            stmt.setString(23, protection.getHistoryActionCodeID());
            stmt.setShort(24, protection.getIntraPNRSetNbr());
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
     	// Establish database connection
    		ArrayList<ResTravelProtection> resTravelProtections = new ArrayList<ResTravelProtection>();
    		for (Object flight : flights) {
    			resTravelProtections.add((ResTravelProtection) flight);
    		}
     		PreparedStatement stmt = null;

     			// Read the SQL insert query from the file
     			String sql = utility.loadSqlFromFile("src/main/resources/query/delete/deleteResTravelProtection.sql");

     			// Create a PreparedStatement to execute the SQL query
     			stmt = connection.prepareStatement(sql);

     			// Add the flight data to the batch for bulk insertion
     			for (ResTravelProtection res : resTravelProtections) {
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
