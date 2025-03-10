package com.kmmaltairlines.hip.tdbingester.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kmmaltairlines.hip.tdbingester.filepojos.ACSPaxBag;
import com.kmmaltairlines.hip.tdbingester.poc_tdb.Utility;

public class ACSPaxBagSql {
	@Autowired
	Utility utility;
	
	@SuppressWarnings("static-access")
	public void insert(List<ACSPaxBag> flights,Connection connessione) throws SQLException, IOException {

		// Establish database connection
		Connection conn = connessione;
		PreparedStatement stmt = null;

			// Read the SQL insert query from the file
			String sql = utility.loadSqlFromFile("src/main/resources/query/insert/insertACSPaxBag.sql");

			// Create a PreparedStatement to execute the SQL query
			stmt = conn.prepareStatement(sql);


			// Add the flight data to the batch for bulk insertion
			for (ACSPaxBag ACSPaxBag : flights) {
				 stmt.setString(1, ACSPaxBag.getSourceSystemID());
			        stmt.setString(2, ACSPaxBag.getPNRLocatorId());
			        stmt.setDate(3, ACSPaxBag.getPNRCreateDate());
			        if(ACSPaxBag.getResPaxId()==null) {
				    	stmt.setNull(4, Types.NULL);
				    }else{
				    	stmt.setShort(4, ACSPaxBag.getResPaxId());
				    }
			        stmt.setString(5, ACSPaxBag.getAirlineCode());
			        stmt.setString(6, ACSPaxBag.getFltNbr());
			        stmt.setDate(7, ACSPaxBag.getServiceStartDate());
			        stmt.setString(8, ACSPaxBag.getAirlineOrigAirport());
			        stmt.setString(9, ACSPaxBag.getBagTag());
			        stmt.setTime(10, ACSPaxBag.getBagTagIssueTime());
			        stmt.setDate(11, ACSPaxBag.getBagTagIssueDate());
			        stmt.setString(12, ACSPaxBag.getBagDamagedInd());
			        stmt.setString(13, ACSPaxBag.getBagTransferMsgInd());
			        stmt.setString(14, ACSPaxBag.getBagEdifactAddInd());
			        stmt.setString(15, ACSPaxBag.getBagEdifactXLInd());
			        stmt.setString(16, ACSPaxBag.getBagPaxNewRteInd());
			        stmt.setString(17, ACSPaxBag.getBagPetInd());
			        stmt.setString(18, ACSPaxBag.getBagVoluntarySepInd());
			        stmt.setString(19, ACSPaxBag.getBagTagManualInd());
			        stmt.setString(20, ACSPaxBag.getBagTagXLInd());
			        stmt.setString(21, ACSPaxBag.getBagPremiumInd());
			        stmt.setString(22, ACSPaxBag.getBagPriorityInd());
			        stmt.setString(23, ACSPaxBag.getBagHeavyInd());
			        stmt.setString(24, ACSPaxBag.getBagClearedDogInd());
			        stmt.setString(25, ACSPaxBag.getBagClearedETDInd());
			        stmt.setString(26, ACSPaxBag.getBagClearedSrchInd());
			        stmt.setString(27, ACSPaxBag.getBagClearedTraceInd());
			        stmt.setString(28, ACSPaxBag.getBagCourierInd());
			        stmt.setString(29, ACSPaxBag.getBagStandByInd());
			        stmt.setString(30, ACSPaxBag.getBagGroupInd());
			        stmt.setString(31, ACSPaxBag.getBagSportEquipInd());
			        stmt.setString(32, ACSPaxBag.getBagBulkInd());
			        stmt.setString(33, ACSPaxBag.getBagLtdReleaseInd());
			        stmt.setString(34, ACSPaxBag.getXLAirportCode());
			        stmt.setString(35, ACSPaxBag.getXLAgentSign());
			        stmt.setString(36, ACSPaxBag.getXLDtyCd());
			        stmt.setString(37, ACSPaxBag.getXLAgentStation());
			        stmt.setTime(38, ACSPaxBag.getXLTime());
			        stmt.setDate(39, ACSPaxBag.getXLDate());
			        stmt.setString(40, ACSPaxBag.getBagRouteNbr());
			        stmt.setString(41, ACSPaxBag.getOriginalRteAgnt());
			        stmt.setString(42, ACSPaxBag.getOriginalRteAgntDtyCd());
			        stmt.setString(43, ACSPaxBag.getOriginalRteAgntStation());
			        stmt.setTime(44, ACSPaxBag.getOriginalRteAgntTime());
			        stmt.setDate(45, ACSPaxBag.getOriginalRteAgntDate());
			        stmt.setDate(46, ACSPaxBag.getRouteDate1());
			        stmt.setDate(47, ACSPaxBag.getRouteDate2());
			        stmt.setDate(48, ACSPaxBag.getRouteDate3());
			        stmt.setDate(49, ACSPaxBag.getRouteDate4());
			        stmt.setDate(50, ACSPaxBag.getRouteDate5());
			        stmt.setString(51, ACSPaxBag.getRouteOperatingAirline1());
			        stmt.setString(52, ACSPaxBag.getRouteOperatingAirline2());
			        stmt.setString(53, ACSPaxBag.getRouteOperatingAirline3());
			        stmt.setString(54, ACSPaxBag.getRouteOperatingAirline4());
			        stmt.setString(55, ACSPaxBag.getRouteOperatingAirline5());
			        stmt.setString(56, ACSPaxBag.getRouteFltNbr1());
			        stmt.setString(57, ACSPaxBag.getRouteFltNbr2());
			        stmt.setString(58, ACSPaxBag.getRouteFltNbr3());
			        stmt.setString(59, ACSPaxBag.getRouteFltNbr4());
			        stmt.setString(60, ACSPaxBag.getRouteFltNbr5());
			        stmt.setString(61, ACSPaxBag.getRouteOriginCd1());
			        stmt.setString(62, ACSPaxBag.getRouteOriginCd2());
			        stmt.setString(63, ACSPaxBag.getRouteOriginCd3());
			        stmt.setString(64, ACSPaxBag.getRouteOriginCd4());
			        stmt.setString(65, ACSPaxBag.getRouteOriginCd5());
			        stmt.setString(66, ACSPaxBag.getRouteDestCd1());
			        stmt.setString(67, ACSPaxBag.getRouteDestCd2());
			        stmt.setString(68, ACSPaxBag.getRouteDestCd3());
			        stmt.setString(69, ACSPaxBag.getRouteDestCd4());
			        stmt.setString(70, ACSPaxBag.getRouteDestCd5());
			        stmt.setString(71, ACSPaxBag.getBagRerouteNbr());
			        stmt.setString(72, ACSPaxBag.getBagOldRouteNbr());
			        stmt.setString(73, ACSPaxBag.getOriginalReRteAgnt());
			        stmt.setString(74, ACSPaxBag.getOriginalReRteAgntDtyCd());
			        stmt.setString(75, ACSPaxBag.getOriginalReRteAgntStation());
			        stmt.setTime(76, ACSPaxBag.getOriginalReRteAgntTime());
			        stmt.setDate(77, ACSPaxBag.getOriginalReRteAgntDate());
			        stmt.setDate(78, ACSPaxBag.getRerouteDate1());
			        stmt.setDate(79, ACSPaxBag.getRerouteDate2());
			        stmt.setDate(80, ACSPaxBag.getRerouteDate3());
			        stmt.setDate(81, ACSPaxBag.getRerouteDate4());
			        stmt.setDate(82, ACSPaxBag.getRerouteDate5());
			        stmt.setString(83, ACSPaxBag.getRerouteOperatingAirline1());
			        stmt.setString(84, ACSPaxBag.getRerouteOperatingAirline2());
			        stmt.setString(85, ACSPaxBag.getRerouteOperatingAirline3());
			        stmt.setString(86, ACSPaxBag.getRerouteOperatingAirline4());
			        stmt.setString(87, ACSPaxBag.getRerouteOperatingAirline5());
			        stmt.setString(88, ACSPaxBag.getRerouteFltNbr1());
			        stmt.setString(89, ACSPaxBag.getRerouteFltNbr2());
			        stmt.setString(90, ACSPaxBag.getRerouteFltNbr3());
			        stmt.setString(91, ACSPaxBag.getRerouteFltNbr4());
			        stmt.setString(92, ACSPaxBag.getRerouteFltNbr5());
			        stmt.setString(93, ACSPaxBag.getRerouteOriginCd1());
			        stmt.setString(94, ACSPaxBag.getRerouteOriginCd2());
			        stmt.setString(95, ACSPaxBag.getRerouteOriginCd3());
			        stmt.setString(96, ACSPaxBag.getRerouteOriginCd4());
			        stmt.setString(97, ACSPaxBag.getRerouteOriginCd5());
			        stmt.setString(98, ACSPaxBag.getRerouteDestCd1());
			        stmt.setString(99, ACSPaxBag.getRerouteDestCd2());
			        stmt.setString(100, ACSPaxBag.getRerouteDestCd3());
			        stmt.setString(101, ACSPaxBag.getRerouteDestCd4());
			        stmt.setString(102, ACSPaxBag.getRerouteDestCd5());
			        stmt.setTimestamp(103, ACSPaxBag.getMsgCreateDateTime());
			        stmt.setObject(104, utility.nowUtcTimestamp(), Types.TIMESTAMP); 
	        	
	        	stmt.addBatch();
			}

			// Execute the batch insert
			int[] results = stmt.executeBatch();

			stmt.close();
	}
}
