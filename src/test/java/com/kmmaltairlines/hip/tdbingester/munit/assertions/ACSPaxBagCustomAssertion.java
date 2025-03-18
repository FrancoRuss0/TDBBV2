package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;
import org.springframework.expression.TypedValue;

import com.kmmaltairlines.hip.tdbingester.filepojos.ACSPaxBag;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class ACSPaxBagCustomAssertion  {

	
	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		ACSPaxBag payloadPojo = new ACSPaxBag();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof ACSPaxBag)
	        	payloadPojo = (ACSPaxBag) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not ACSPaxBag.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of ACSPaxBag.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getSourceSystemID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorId(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getResPaxId(), TestCastingFunctions.castToShort(linearr[3]));
			Assert.assertEquals(payloadPojo.getAirlineCode(), TestCastingFunctions.castToString(linearr[4]));
			Assert.assertEquals(payloadPojo.getFltNbr(), TestCastingFunctions.castToString(linearr[5]));
			Assert.assertEquals(payloadPojo.getServiceStartDate(), TestCastingFunctions.castToDate(linearr[6],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getAirlineOrigAirport(), TestCastingFunctions.castToString(linearr[7]));
			Assert.assertEquals(payloadPojo.getBagTag(), TestCastingFunctions.castToString(linearr[8]));
			Assert.assertEquals(payloadPojo.getBagTagIssueTime() == null ? null : payloadPojo.getBagTagIssueTime().toString(), TestCastingFunctions.castToTime(linearr[9],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[9],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getBagTagIssueDate(), TestCastingFunctions.castToDate(linearr[10],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getBagDamagedInd(), TestCastingFunctions.castToString(linearr[11]));
			Assert.assertEquals(payloadPojo.getBagTransferMsgInd(), TestCastingFunctions.castToString(linearr[12]));
			Assert.assertEquals(payloadPojo.getBagEdifactAddInd(), TestCastingFunctions.castToString(linearr[13]));
			Assert.assertEquals(payloadPojo.getBagEdifactXLInd(), TestCastingFunctions.castToString(linearr[14]));
			Assert.assertEquals(payloadPojo.getBagPaxNewRteInd(), TestCastingFunctions.castToString(linearr[15]));
			Assert.assertEquals(payloadPojo.getBagPetInd(), TestCastingFunctions.castToString(linearr[16]));
			Assert.assertEquals(payloadPojo.getBagVoluntarySepInd(), TestCastingFunctions.castToString(linearr[17]));
			Assert.assertEquals(payloadPojo.getBagTagManualInd(), TestCastingFunctions.castToString(linearr[18]));
			Assert.assertEquals(payloadPojo.getBagTagXLInd(), TestCastingFunctions.castToString(linearr[19]));
			Assert.assertEquals(payloadPojo.getBagPremiumInd(), TestCastingFunctions.castToString(linearr[20]));
			Assert.assertEquals(payloadPojo.getBagPriorityInd(), TestCastingFunctions.castToString(linearr[21]));
			Assert.assertEquals(payloadPojo.getBagHeavyInd(), TestCastingFunctions.castToString(linearr[22]));
			Assert.assertEquals(payloadPojo.getBagClearedDogInd(), TestCastingFunctions.castToString(linearr[23]));
			Assert.assertEquals(payloadPojo.getBagClearedETDInd(), TestCastingFunctions.castToString(linearr[24]));
			Assert.assertEquals(payloadPojo.getBagClearedSrchInd(), TestCastingFunctions.castToString(linearr[25]));
			Assert.assertEquals(payloadPojo.getBagClearedTraceInd(), TestCastingFunctions.castToString(linearr[26]));
			Assert.assertEquals(payloadPojo.getBagCourierInd(), TestCastingFunctions.castToString(linearr[27]));
			Assert.assertEquals(payloadPojo.getBagStandByInd(), TestCastingFunctions.castToString(linearr[28]));
			Assert.assertEquals(payloadPojo.getBagGroupInd(), TestCastingFunctions.castToString(linearr[29]));
			Assert.assertEquals(payloadPojo.getBagSportEquipInd(), TestCastingFunctions.castToString(linearr[30]));
			Assert.assertEquals(payloadPojo.getBagBulkInd(), TestCastingFunctions.castToString(linearr[31]));
			Assert.assertEquals(payloadPojo.getBagLtdReleaseInd(), TestCastingFunctions.castToString(linearr[32]));
			Assert.assertEquals(payloadPojo.getXLAirportCode(), TestCastingFunctions.castToString(linearr[33]));
			Assert.assertEquals(payloadPojo.getXLAgentSign(), TestCastingFunctions.castToString(linearr[34]));
			Assert.assertEquals(payloadPojo.getXLDtyCd(), TestCastingFunctions.castToString(linearr[35]));
			Assert.assertEquals(payloadPojo.getXLAgentStation(), TestCastingFunctions.castToString(linearr[36]));
			Assert.assertEquals(payloadPojo.getXLTime() == null ? null : payloadPojo.getXLTime().toString(), TestCastingFunctions.castToTime(linearr[37],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[37],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getXLDate(), TestCastingFunctions.castToDate(linearr[38],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getBagRouteNbr(), TestCastingFunctions.castToString(linearr[39]));
			Assert.assertEquals(payloadPojo.getOriginalRteAgnt(), TestCastingFunctions.castToString(linearr[40]));
			Assert.assertEquals(payloadPojo.getOriginalRteAgntDtyCd(), TestCastingFunctions.castToString(linearr[41]));
			Assert.assertEquals(payloadPojo.getOriginalRteAgntStation(), TestCastingFunctions.castToString(linearr[42]));
			Assert.assertEquals(payloadPojo.getOriginalRteAgntTime() == null ? null : payloadPojo.getOriginalRteAgntTime().toString(), TestCastingFunctions.castToTime(linearr[43],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[43],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getOriginalRteAgntDate(), TestCastingFunctions.castToDate(linearr[44],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getRouteDate1(), TestCastingFunctions.castToDate(linearr[45],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getRouteDate2(), TestCastingFunctions.castToDate(linearr[46],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getRouteDate3(), TestCastingFunctions.castToDate(linearr[47],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getRouteDate4(), TestCastingFunctions.castToDate(linearr[48],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getRouteDate5(), TestCastingFunctions.castToDate(linearr[49],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getRouteOperatingAirline1(), TestCastingFunctions.castToString(linearr[50]));
			Assert.assertEquals(payloadPojo.getRouteOperatingAirline2(), TestCastingFunctions.castToString(linearr[51]));
			Assert.assertEquals(payloadPojo.getRouteOperatingAirline3(), TestCastingFunctions.castToString(linearr[52]));
			Assert.assertEquals(payloadPojo.getRouteOperatingAirline4(), TestCastingFunctions.castToString(linearr[53]));
			Assert.assertEquals(payloadPojo.getRouteOperatingAirline5(), TestCastingFunctions.castToString(linearr[54]));
			Assert.assertEquals(payloadPojo.getRouteFltNbr1(), TestCastingFunctions.castToString(linearr[55]));
			Assert.assertEquals(payloadPojo.getRouteFltNbr2(), TestCastingFunctions.castToString(linearr[56]));
			Assert.assertEquals(payloadPojo.getRouteFltNbr3(), TestCastingFunctions.castToString(linearr[57]));
			Assert.assertEquals(payloadPojo.getRouteFltNbr4(), TestCastingFunctions.castToString(linearr[58]));
			Assert.assertEquals(payloadPojo.getRouteFltNbr5(), TestCastingFunctions.castToString(linearr[59]));
			Assert.assertEquals(payloadPojo.getRouteOriginCd1(), TestCastingFunctions.castToString(linearr[60]));
			Assert.assertEquals(payloadPojo.getRouteOriginCd2(), TestCastingFunctions.castToString(linearr[61]));
			Assert.assertEquals(payloadPojo.getRouteOriginCd3(), TestCastingFunctions.castToString(linearr[62]));
			Assert.assertEquals(payloadPojo.getRouteOriginCd4(), TestCastingFunctions.castToString(linearr[63]));
			Assert.assertEquals(payloadPojo.getRouteOriginCd5(), TestCastingFunctions.castToString(linearr[64]));
			Assert.assertEquals(payloadPojo.getRouteDestCd1(), TestCastingFunctions.castToString(linearr[65]));
			Assert.assertEquals(payloadPojo.getRouteDestCd2(), TestCastingFunctions.castToString(linearr[66]));
			Assert.assertEquals(payloadPojo.getRouteDestCd3(), TestCastingFunctions.castToString(linearr[67]));
			Assert.assertEquals(payloadPojo.getRouteDestCd4(), TestCastingFunctions.castToString(linearr[68]));
			Assert.assertEquals(payloadPojo.getRouteDestCd5(), TestCastingFunctions.castToString(linearr[69]));
			Assert.assertEquals(payloadPojo.getBagRerouteNbr(), TestCastingFunctions.castToString(linearr[70]));
			Assert.assertEquals(payloadPojo.getBagOldRouteNbr(), TestCastingFunctions.castToString(linearr[71]));
			Assert.assertEquals(payloadPojo.getOriginalReRteAgnt(), TestCastingFunctions.castToString(linearr[72]));
			Assert.assertEquals(payloadPojo.getOriginalReRteAgntDtyCd(), TestCastingFunctions.castToString(linearr[73]));
			Assert.assertEquals(payloadPojo.getOriginalReRteAgntStation(), TestCastingFunctions.castToString(linearr[74]));
			Assert.assertEquals(payloadPojo.getOriginalReRteAgntTime() == null ? null : payloadPojo.getOriginalReRteAgntTime().toString(), TestCastingFunctions.castToTime(linearr[75],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[75],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getOriginalReRteAgntDate(), TestCastingFunctions.castToDate(linearr[76],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getRerouteDate1(), TestCastingFunctions.castToDate(linearr[77],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getRerouteDate2(), TestCastingFunctions.castToDate(linearr[78],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getRerouteDate3(), TestCastingFunctions.castToDate(linearr[79],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getRerouteDate4(), TestCastingFunctions.castToDate(linearr[80],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getRerouteDate5(), TestCastingFunctions.castToDate(linearr[81],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getRerouteOperatingAirline1(), TestCastingFunctions.castToString(linearr[82]));
			Assert.assertEquals(payloadPojo.getRerouteOperatingAirline2(), TestCastingFunctions.castToString(linearr[83]));
			Assert.assertEquals(payloadPojo.getRerouteOperatingAirline3(), TestCastingFunctions.castToString(linearr[84]));
			Assert.assertEquals(payloadPojo.getRerouteOperatingAirline4(), TestCastingFunctions.castToString(linearr[85]));
			Assert.assertEquals(payloadPojo.getRerouteOperatingAirline5(), TestCastingFunctions.castToString(linearr[86]));
			Assert.assertEquals(payloadPojo.getRerouteFltNbr1(), TestCastingFunctions.castToString(linearr[87]));
			Assert.assertEquals(payloadPojo.getRerouteFltNbr2(), TestCastingFunctions.castToString(linearr[88]));
			Assert.assertEquals(payloadPojo.getRerouteFltNbr3(), TestCastingFunctions.castToString(linearr[89]));
			Assert.assertEquals(payloadPojo.getRerouteFltNbr4(), TestCastingFunctions.castToString(linearr[90]));
			Assert.assertEquals(payloadPojo.getRerouteFltNbr5(), TestCastingFunctions.castToString(linearr[91]));
			Assert.assertEquals(payloadPojo.getRerouteOriginCd1(), TestCastingFunctions.castToString(linearr[92]));
			Assert.assertEquals(payloadPojo.getRerouteOriginCd2(), TestCastingFunctions.castToString(linearr[93]));
			Assert.assertEquals(payloadPojo.getRerouteOriginCd3(), TestCastingFunctions.castToString(linearr[94]));
			Assert.assertEquals(payloadPojo.getRerouteOriginCd4(), TestCastingFunctions.castToString(linearr[95]));
			Assert.assertEquals(payloadPojo.getRerouteOriginCd5(), TestCastingFunctions.castToString(linearr[96]));
			Assert.assertEquals(payloadPojo.getRerouteDestCd1(), TestCastingFunctions.castToString(linearr[97]));
			Assert.assertEquals(payloadPojo.getRerouteDestCd2(), TestCastingFunctions.castToString(linearr[98]));
			Assert.assertEquals(payloadPojo.getRerouteDestCd3(), TestCastingFunctions.castToString(linearr[99]));
			Assert.assertEquals(payloadPojo.getRerouteDestCd4(), TestCastingFunctions.castToString(linearr[100]));
			Assert.assertEquals(payloadPojo.getRerouteDestCd5(), TestCastingFunctions.castToString(linearr[101]));
			Assert.assertEquals(payloadPojo.getMsgCreateDateTime(), TestCastingFunctions.castToTimestamp(linearr[102],"yyyy-MM-dd HH:mm:ss"));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in ACSPaxBag file. Exception message: " + e.getMessage(), e);
		}

}


	public void execute(TypedValue arg0, Object arg1) throws AssertionError {
		// TODO Auto-generated method stub
		
	}
}