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

import com.kmmaltairlines.hip.tdbingester.filepojos.ACSPaxFlight;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.MethodInterface;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.OneIteration;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

@Component
public class ACSPaxFlightSql implements MethodInterface{
	
	@Autowired
	private Utility utility;
	
	private static final Logger logger = LogManager.getLogger(ACSPaxFlightSql.class);
	/**
	 * Inserts ACSFlightHistory records into the database in bulk.
	 * 
	 * @param flights - List of ACSPaxFlight objects to be inserted
	 * @throws SQLException - If an error occurs while executing the SQL query
	 * @throws IOException 
	 */

	public void insert(List<Object> flights, Connection connection) throws SQLException, IOException {
		ArrayList<ACSPaxFlight> trasformACSPaxFlight = new ArrayList<ACSPaxFlight>();
		for (Object flight : flights) {
			trasformACSPaxFlight.add((ACSPaxFlight) flight);
		}
		PreparedStatement stmt = null;
			// Read the SQL insert query from the file
			String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertACSPaxFlight.sql");

			// Create a PreparedStatement to execute the SQL query
			stmt = connection.prepareStatement(sql);

			// Add the flight data to the batch for bulk insertion
			for (ACSPaxFlight ACSPaxFlight : trasformACSPaxFlight) {
			    stmt.setString(1, ACSPaxFlight.getSourceSystemID());
			    stmt.setString(2, ACSPaxFlight.getPNRLocatorId());
			    stmt.setString(3, ACSPaxFlight.getMCPPNRLocatorId());
			    stmt.setObject(4, ACSPaxFlight.getPNRCreateDate(), Types.TIMESTAMP);
			    stmt.setObject(5, ACSPaxFlight.getMCPPNRCreateDate(), Types.TIMESTAMP);
			    stmt.setInt(6, ACSPaxFlight.getResPaxId());
			    stmt.setString(7, ACSPaxFlight.getAirlineCode());
			    stmt.setString(8, ACSPaxFlight.getFltNbr());
			    stmt.setObject(9, ACSPaxFlight.getServiceStartDate(),Types.TIMESTAMP );
			    stmt.setString(10, ACSPaxFlight.getAirlineOrigAirport());
			    stmt.setString(11, ACSPaxFlight.getResPaxNameID());
			    stmt.setString(12, ACSPaxFlight.getNameFirst());
			    stmt.setString(13, ACSPaxFlight.getNameLast());
			    stmt.setString(14, ACSPaxFlight.getPaxPNROrigin());
			    stmt.setString(15, ACSPaxFlight.getPaxPNRDest());
			    stmt.setString(16, ACSPaxFlight.getUPID());
			    stmt.setString(17, ACSPaxFlight.getPaxTypeCd());
			    stmt.setString(18, ACSPaxFlight.getRevenuePassengerInd());
			    stmt.setString(19, ACSPaxFlight.getNonRevenuePassengerind());
			    stmt.setString(20, ACSPaxFlight.getDeadheadInd());
			    stmt.setString(21, ACSPaxFlight.getSelecteeInd());
			    stmt.setString(22, ACSPaxFlight.getOnBrdInd());
			    stmt.setString(23, ACSPaxFlight.getBoardingPassInd());
			    stmt.setString(24, ACSPaxFlight.getPriorityListInd());
			    if(ACSPaxFlight.getCheckInSeqNbr()==null) {
			    	stmt.setNull(25, Types.NULL);
			    }else{
			    	stmt.setInt(25, ACSPaxFlight.getCheckInSeqNbr());
			    }
			    stmt.setString(26, ACSPaxFlight.getFlownClassofService());
			    stmt.setString(27, ACSPaxFlight.getClassofService());
			    stmt.setString(28, ACSPaxFlight.getBookedInventory());
			    stmt.setString(29, ACSPaxFlight.getInventoryUpgradeInd());
			    stmt.setString(30, ACSPaxFlight.getMarketingAirlineCd());
			    stmt.setString(31, ACSPaxFlight.getMarketingFltNbr());
			    stmt.setString(32, ACSPaxFlight.getCodeShareAirlineCd());
			    stmt.setString(33, ACSPaxFlight.getCodeShareAirlineFltNbr());
			    stmt.setString(34, ACSPaxFlight.getPaxThruInd());
			    stmt.setString(35, ACSPaxFlight.getPaxInboundConxInd());
			    stmt.setString(36, ACSPaxFlight.getPaxOutboundConxInd());
			    stmt.setString(37, ACSPaxFlight.getPaxCodeShareInd());
			    stmt.setString(38, ACSPaxFlight.getOneWorldConxInd());
			    stmt.setString(39, ACSPaxFlight.getOneWorldInConxInd());
			    stmt.setString(40, ACSPaxFlight.getOneWorldOutConxInd());
			    stmt.setString(41, ACSPaxFlight.getGenderInd());
			    stmt.setString(42, ACSPaxFlight.getCHGFLInd());
			    stmt.setString(43, ACSPaxFlight.getCHGSGInd());
			    stmt.setString(44, ACSPaxFlight.getGOSHOInd());
			    stmt.setString(45, ACSPaxFlight.getIDPADInd());
			    stmt.setString(46, ACSPaxFlight.getNORECInd());
			    stmt.setString(47, ACSPaxFlight.getNOSHOInd());
			    stmt.setString(48, ACSPaxFlight.getOFFLKInd());
			    stmt.setString(49, ACSPaxFlight.getOFFLNInd());
			    stmt.setString(50, ACSPaxFlight.getGOSHNInd());
			    stmt.setString(51, ACSPaxFlight.getCHGCLInd());
			    stmt.setString(52, ACSPaxFlight.getINVOLInd());
			    stmt.setString(53, ACSPaxFlight.getAPIPXInd());
			    stmt.setString(54, ACSPaxFlight.getCFMWLInd());
			    stmt.setString(55, ACSPaxFlight.getFQTVNInd());
			    stmt.setString(56, ACSPaxFlight.getCheckInGrpCode());
			    stmt.setInt(57, ACSPaxFlight.getCheckinGrpCnt());
			    stmt.setString(58, ACSPaxFlight.getResGrpCode());
			    stmt.setInt(59, ACSPaxFlight.getResGrpCnt());
			    stmt.setString(60, ACSPaxFlight.getPaxContactText());
			    stmt.setString(61, ACSPaxFlight.getETCIInInd());
			    stmt.setString(62, ACSPaxFlight.getETCIOutInd());
			    stmt.setString(63, ACSPaxFlight.getCheckInKioskInd());
			    stmt.setString(64, ACSPaxFlight.getRemoteCheckInInd());
			    stmt.setString(65, ACSPaxFlight.getCheckInMobileInd());
			    stmt.setObject(66, ACSPaxFlight.getCheckInTime(), Types.TIMESTAMP);
			    stmt.setObject(67, ACSPaxFlight.getCheckInDate(), Types.TIMESTAMP);
			    stmt.setString(68, ACSPaxFlight.getChknRestrictedSOCInd());
			    stmt.setString(69, ACSPaxFlight.getVendorCode());
			    stmt.setString(70, ACSPaxFlight.getFrequentTravelerNbr());
			    stmt.setString(71, ACSPaxFlight.getFQTVTier());
			    stmt.setString(72, ACSPaxFlight.getPriorityListCd());
			    stmt.setString(73, ACSPaxFlight.getDeniedBoardType());
			    stmt.setString(74, ACSPaxFlight.getOverSaleLegID());
			    if(ACSPaxFlight.getOverSaleReasonNbr()==null) {
			    	stmt.setNull(75, Types.NULL);
			    }else{
			    	stmt.setShort(75, ACSPaxFlight.getOverSaleReasonNbr());
			    }
			    stmt.setBigDecimal(76, ACSPaxFlight.getOversaleCompensation());
			    stmt.setString(77, ACSPaxFlight.getCompTypeCd());
			    stmt.setString(78, ACSPaxFlight.getCompCurrCd());
			    stmt.setString(79, ACSPaxFlight.getOversaleReaccomInd());
			    stmt.setString(80, ACSPaxFlight.getUpgradeCd());
			    stmt.setString(81, ACSPaxFlight.getPaxCommentsText());
			    if(ACSPaxFlight.getNbrOfBags()==null) {
			    	stmt.setNull(82, Types.NULL);
			    }else{
			    	stmt.setShort(82, ACSPaxFlight.getNbrOfBags());
			    }
			    if(ACSPaxFlight.getTtlBagWeight()==null) {
			    	stmt.setNull(83, Types.NULL);
			    }else{
			    	stmt.setShort(83, ACSPaxFlight.getTtlBagWeight());
			    }
			    stmt.setString(84, ACSPaxFlight.getExcessBagInd());
			    stmt.setString(85, ACSPaxFlight.getNSTInd());
			    stmt.setString(86, ACSPaxFlight.getOFLInd());
			    stmt.setString(87, ACSPaxFlight.getSTCHInd());
			    stmt.setString(88, ACSPaxFlight.getBCSInd());
			    stmt.setString(89, ACSPaxFlight.getSSUPInd());
			    stmt.setString(90, ACSPaxFlight.getSSPRInd());
			    stmt.setString(91, ACSPaxFlight.getWVERInd());
			    stmt.setString(92, ACSPaxFlight.getINCUInd());
			    stmt.setString(93, ACSPaxFlight.getOXYGInd());
			    stmt.setString(94, ACSPaxFlight.getNMELInd());
			    stmt.setString(95, ACSPaxFlight.getGCIPInd());
			    stmt.setString(96, ACSPaxFlight.getGVIPInd());
			    stmt.setObject(97, ACSPaxFlight.getMsgCreateDateTime(), Types.TIMESTAMP);
			    stmt.setString(98, ACSPaxFlight.getAPPInfantInd());
			    stmt.setString(99, ACSPaxFlight.getAPPAuthCountry());
			    stmt.setString(100, ACSPaxFlight.getAPPStatus());
			    stmt.setString(101, ACSPaxFlight.getSSRCode());
			    stmt.setString(102, ACSPaxFlight.getSSRText());
			    stmt.setString(103, ACSPaxFlight.getPaxInboundCarrier());
			    stmt.setString(104, ACSPaxFlight.getPaxInboundFlightNbr());
			    stmt.setObject(105, ACSPaxFlight.getPaxInbSvcStDt(), Types.TIMESTAMP);
			    stmt.setObject(106, ACSPaxFlight.getPaxInbSvcStTm(), Types.TIMESTAMP);
			    stmt.setString(107, ACSPaxFlight.getPaxInbOrigin());
			    stmt.setString(108, ACSPaxFlight.getPaxInbDest());
			    stmt.setString(109, ACSPaxFlight.getPaxInbBookedClass());
			    stmt.setString(110, ACSPaxFlight.getPaxOutboundCarrier());
			    stmt.setString(111, ACSPaxFlight.getPaxOutboundFlightNbr());
			    stmt.setObject(112, ACSPaxFlight.getPaxOutbSvcStDt(), Types.TIMESTAMP);
			    stmt.setObject(113, ACSPaxFlight.getPaxOutbSvcStTm(), Types.TIMESTAMP);
			    stmt.setString(114, ACSPaxFlight.getPaxOutbOrigin());
			    stmt.setString(115, ACSPaxFlight.getPaxOutbDest());
			    stmt.setString(116, ACSPaxFlight.getPaxOutbBookedClass());
			    stmt.setObject(117, utility.nowUtcTimestamp(), Types.TIMESTAMP); 
			    
			    stmt.addBatch();
			}

			// Execute the batch insert
			int[] results = stmt.executeBatch();

			logger.info("Bulk insert completed successfully. " + results.length + " records inserted.");
	        stmt.close();
	}
	@Override
	public String delete(List<Object> flights, Connection connection) throws SQLException, IOException {
		return null;
		// TODO Auto-generated method stub
		
	}
}
