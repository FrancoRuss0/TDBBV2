package com.kmmaltairlines.hip.tdbingester.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.ACSPaxDOCX;
import com.kmmaltairlines.hip.tdbingester.filepojos.ACSPaxVCR;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class ACSPaxDOCXSql {

	/**
	 * Inserts ACSFlightHistory records into the database in bulk.
	 * 
	 * @param flights - List of ACSPacDOCX objects to be inserted
	 * @throws SQLException - If an error occurs while executing the SQL query
	 * @throws IOException 
	 */
	@SuppressWarnings("static-access")
	public void insert(List<ACSPaxDOCX> flights,Connection connection) throws SQLException, IOException {


		PreparedStatement stmt = null;
		Utility utility=new Utility();
			// Read the SQL insert query from the file
			String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertACSPaxDOCX.sql");

			// Create a PreparedStatement to execute the SQL query
			stmt = connection.prepareStatement(sql);


			// Add the flight data to the batch for bulk insertion
			for (ACSPaxDOCX ACSPaxDOCX : flights) {
				stmt.setString(1, ACSPaxDOCX.getSourceSystemID());
		        stmt.setString(2, ACSPaxDOCX.getPNRLocatorId());
		        stmt.setDate(3, ACSPaxDOCX.getPNRCreateDate());
		        if(ACSPaxDOCX.getResPaxId()==null) {
			    	stmt.setNull(4, Types.NULL);
			    }else{
			    	stmt.setShort(4, ACSPaxDOCX.getResPaxId()); 
			    }
		        stmt.setString(5, ACSPaxDOCX.getAirlineCode());
		        stmt.setString(6, ACSPaxDOCX.getFltNbr());
		        stmt.setDate(7, ACSPaxDOCX.getServiceStartDate());
		        stmt.setString(8, ACSPaxDOCX.getAirlineOrigAirport());
		        stmt.setString(9, ACSPaxDOCX.getDOCVInd());
		        stmt.setString(10, ACSPaxDOCX.getInfDOCVind());
		        stmt.setString(11, ACSPaxDOCX.getDOCAInd());
		        stmt.setString(12, ACSPaxDOCX.getDocCode());
		        stmt.setString(13, ACSPaxDOCX.getACSDocInd());
		        stmt.setString(14, ACSPaxDOCX.getInfAddressInd());
		        stmt.setString(15, ACSPaxDOCX.getAddressType());
		        stmt.setString(16, ACSPaxDOCX.getAddressStreetNbrName());
		        stmt.setString(17, ACSPaxDOCX.getAddressCity());
		        stmt.setString(18, ACSPaxDOCX.getAddressState());
		        stmt.setString(19, ACSPaxDOCX.getAddressZip());
		        stmt.setString(20, ACSPaxDOCX.getAgtInputCountryCode());
		        stmt.setString(21, ACSPaxDOCX.getAddress2LtrCountryCode());
		        stmt.setString(22, ACSPaxDOCX.getAddress3LtrCountryCode());
		        stmt.setString(23, ACSPaxDOCX.getSegAssocInd());
		        stmt.setString(24, ACSPaxDOCX.getNameAssocInd());
		        stmt.setString(25, ACSPaxDOCX.getACSEntDOCAInd());
		        stmt.setString(26, ACSPaxDOCX.getMultiNameAssocDOCAInd());
		        stmt.setString(27, ACSPaxDOCX.getDocCd());
		        stmt.setString(28, ACSPaxDOCX.getDocInfantInd());
		        stmt.setString(29, ACSPaxDOCX.getDocIssuingCntry());
		        stmt.setString(30, ACSPaxDOCX.getDocNbr());
		        stmt.setString(31, ACSPaxDOCX.getDocPaxCntryCd());
		        stmt.setString(32, ACSPaxDOCX.getDocPaxDOB());
		        stmt.setString(33, ACSPaxDOCX.getDocPaxGender());
		        stmt.setString(34, ACSPaxDOCX.getDocExpiryDate());
		        stmt.setString(35, ACSPaxDOCX.getDocFullFirstName());
		        stmt.setString(36, ACSPaxDOCX.getDocFullMiddleName());
		        stmt.setString(37, ACSPaxDOCX.getDocFullLastName());
		        stmt.setString(38, ACSPaxDOCX.getMultiPassportInd());
		        stmt.setString(39, ACSPaxDOCX.getDocScanInd());
		        stmt.setString(40, ACSPaxDOCX.getDocCntryCd2Ch());
		        stmt.setString(41, ACSPaxDOCX.getDocCntryCd3Ch());
		        stmt.setString(42, ACSPaxDOCX.getPaxCntryCode2Ch());
		        stmt.setString(43, ACSPaxDOCX.getPaxCntryCode3Ch());
		        stmt.setTimestamp(44, ACSPaxDOCX.getMsgCreateDateTime());
		        stmt.setString(45, ACSPaxDOCX.getOtherDocInfInd());
		        stmt.setString(46, ACSPaxDOCX.getOtherDocCode());
		        stmt.setString(47, ACSPaxDOCX.getOtherDocNbr());
		        stmt.setString(48, ACSPaxDOCX.getOtherDocPlaceOfIssue());
		        stmt.setString(49, ACSPaxDOCX.getOtherDocIssueDate());
		        stmt.setString(50, ACSPaxDOCX.getOtherDocPaxBirthPlace());
		        stmt.setString(51, ACSPaxDOCX.getOtherDocPaxAgentInputLoc());
		        stmt.setString(52, ACSPaxDOCX.getOtherDocPaxCntryCdTwoChar());
		        stmt.setString(53, ACSPaxDOCX.getOtherDocPaxCntryCdThrChar());
	            stmt.setObject(54, utility.nowUtcTimestamp(), Types.TIMESTAMP); 
	        	
	        	stmt.addBatch();
			}

			// Execute the batch insert
			int[] results = stmt.executeBatch();


			System.out.println("Bulk insert completed successfully. " + results.length + " records inserted.");
			stmt.close();
	}
}
