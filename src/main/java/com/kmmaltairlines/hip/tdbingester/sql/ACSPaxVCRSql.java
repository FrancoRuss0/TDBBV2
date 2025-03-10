package com.kmmaltairlines.hip.tdbingester.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.ACSPaxVCR;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class ACSPaxVCRSql {

	/**
	 * Inserts ACSFlightHistory records into the database in bulk.
	 * 
	 * @param flights - List of ACSPaxVCR objects to be inserted
	 * @throws SQLException - If an error occurs while executing the SQL query
	 * @throws IOException 
	 */
	@SuppressWarnings("static-access")
	public void insert(List<ACSPaxVCR> flights,Connection connection) throws SQLException, IOException {


		PreparedStatement stmt = null;
		Utility utility=new Utility();
			// Read the SQL insert query from the file
			String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertACSPaxVCR.sql");

			// Create a PreparedStatement to execute the SQL query
			stmt = connection.prepareStatement(sql);


			// Add the flight data to the batch for bulk insertion
			for (ACSPaxVCR ACSPaxVCR : flights) {
	        	stmt.setString(1, ACSPaxVCR.getSourceSystemID());
	            stmt.setString(2, ACSPaxVCR.getPNRLocatorId());  
	            stmt.setObject(3, ACSPaxVCR.getPNRCreateDate(), Types.TIMESTAMP);
	            stmt.setShort(4, ACSPaxVCR.getResPaxId());
	            stmt.setString(5, ACSPaxVCR.getAirlineCode());
	            stmt.setString(6, ACSPaxVCR.getFltNbr());
	            stmt.setObject(7, ACSPaxVCR.getServiceStartDate());
	            stmt.setString(8, ACSPaxVCR.getAirlineOrigAirport()); 
	            stmt.setObject(8, ACSPaxVCR.getVCRCreateDate(), Types.TIMESTAMP);
	            stmt.setString(10, ACSPaxVCR.getAirlineAccountingCode());
	            stmt.setString(11, ACSPaxVCR.getVCRSerialNbr()); 
	            if(ACSPaxVCR.getVCRCouponSeqNbr()==null) {
			    	stmt.setNull(12, Types.NULL);
			    }else{
			    	stmt.setShort(12, ACSPaxVCR.getVCRCouponSeqNbr()); 
			    }
	            stmt.setString(13, ACSPaxVCR.getClassofService());
	            stmt.setString(14, ACSPaxVCR.getFareBasisCode());
	            stmt.setString(15, ACSPaxVCR.getVCRInUseInd());
	            stmt.setString(16, ACSPaxVCR.getVCRSelectDisAssocInd());
	            stmt.setString(17, ACSPaxVCR.getVCRDisAssocInd());
	            stmt.setString(18, ACSPaxVCR.getVCRDisAssocRsn());
	            stmt.setString(19, ACSPaxVCR.getVCRGrabNGoInd());
	            stmt.setString(20, ACSPaxVCR.getCommonElecTktInd());
	            stmt.setString(21, ACSPaxVCR.getVCRExistInd());
	            stmt.setString(22, ACSPaxVCR.getMultiVCRInd());
	            stmt.setString(23, ACSPaxVCR.getPrevCpnStatsErrInd());
	            stmt.setString(24, ACSPaxVCR.getPrevCpnStatsErrOverrideInd());
	            stmt.setString(25, ACSPaxVCR.getInfVCRInd());
	            stmt.setObject(26, ACSPaxVCR.getInfVCRIssueDate(), Types.DATE);
	            stmt.setObject(27, ACSPaxVCR.getInfVCRCreateDate(), Types.DATE);
	            stmt.setObject(28, ACSPaxVCR.getInfVCRCreateTime(), Types.TIME);
	            stmt.setString(29, ACSPaxVCR.getInfVCRAirlineAccountingCode());
	            stmt.setString(30, ACSPaxVCR.getInfVCRSerialNbr());
	            if(ACSPaxVCR.getInfVCRCouponSeqNbr()==null) {
			    	stmt.setNull(31, Types.NULL);
			    }else{
			    	stmt.setShort(31, ACSPaxVCR.getInfVCRCouponSeqNbr());
			    }
	            stmt.setString(32, ACSPaxVCR.getInfVCRFareBasisCode());
	            stmt.setString(33, ACSPaxVCR.getInfVCRClassofService());
	            stmt.setString(34, ACSPaxVCR.getInfVCRInUseInd());
	            stmt.setString(35, ACSPaxVCR.getInfCheckInComplete());
	            stmt.setObject(36, ACSPaxVCR.getMsgCreateDateTime(), Types.TIMESTAMP);
	            stmt.setObject(37, utility.nowUtcTimestamp(), Types.TIMESTAMP); 
	        	
	        	stmt.addBatch();
			}

			// Execute the batch insert
			int[] results = stmt.executeBatch();


			System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
			stmt.close();
	}
}
