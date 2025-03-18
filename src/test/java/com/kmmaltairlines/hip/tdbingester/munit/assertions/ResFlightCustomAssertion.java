package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;

import org.junit.Assert;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResFlight;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class ResFlightCustomAssertion {

	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		ResFlight payloadPojo = new ResFlight();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof ResFlight)
	        	payloadPojo = (ResFlight) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not ResFlight.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of ResFlight.", new Exception());
		

		 
		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorID(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getFromDateTime(), TestCastingFunctions.castToTimestamp(linearr[3],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getSegmentNbr(), TestCastingFunctions.castToShort(linearr[4]));
			Assert.assertEquals(payloadPojo.getActiveSegmentInd(), TestCastingFunctions.castToString(linearr[5]));
			Assert.assertEquals(payloadPojo.getCdshrLegInd(), TestCastingFunctions.castToString(linearr[6]));
			Assert.assertEquals(payloadPojo.getClassOfService(), TestCastingFunctions.castToString(linearr[7]));
			Assert.assertEquals(payloadPojo.getConnectivityCode(), TestCastingFunctions.castToString(linearr[8]));
			Assert.assertEquals(payloadPojo.getNbrInParty(), TestCastingFunctions.castToShort(linearr[9]));
			Assert.assertEquals(payloadPojo.getCurrentSegmentStatusCode(), TestCastingFunctions.castToString(linearr[10]));
			Assert.assertEquals(payloadPojo.getPreviousSegmentStatusCode(), TestCastingFunctions.castToString(linearr[11]));
			Assert.assertEquals(payloadPojo.getSegmentTypeCode(), TestCastingFunctions.castToShort(linearr[12]));
			Assert.assertEquals(payloadPojo.getChangeSegmentStatusIndicator(), TestCastingFunctions.castToString(linearr[13]));
			Assert.assertEquals(payloadPojo.getEquipmentCode(), TestCastingFunctions.castToShort(linearr[14]));
			Assert.assertEquals(payloadPojo.getMarketingFlightNbr(), TestCastingFunctions.castToString(linearr[15]));
			Assert.assertEquals(payloadPojo.getFlightNbr(), TestCastingFunctions.castToString(linearr[16]));
			Assert.assertEquals(payloadPojo.getMarketingAirlineCode(), TestCastingFunctions.castToString(linearr[17]));
			Assert.assertEquals(payloadPojo.getOperatingFlightNbr(), TestCastingFunctions.castToString(linearr[18]));
			Assert.assertEquals(payloadPojo.getOperatingAirlineCode(), TestCastingFunctions.castToString(linearr[19]));
			Assert.assertEquals(payloadPojo.getAirlineCode(), TestCastingFunctions.castToString(linearr[20]));
			Assert.assertEquals(payloadPojo.getInboundFlightConnectionInd(), TestCastingFunctions.castToString(linearr[21]));
			Assert.assertEquals(payloadPojo.getMarriedConxInboundFlightInd(), TestCastingFunctions.castToString(linearr[22]));
			Assert.assertEquals(payloadPojo.getOutboundFlightConnectionInd(), TestCastingFunctions.castToString(linearr[23]));
			Assert.assertEquals(payloadPojo.getMarriedConxOutboundFlightInd(), TestCastingFunctions.castToString(linearr[24]));
			Assert.assertEquals(payloadPojo.getServiceStartCity(), TestCastingFunctions.castToString(linearr[25]));
			Assert.assertEquals(payloadPojo.getServiceStartDate(), TestCastingFunctions.castToDate(linearr[26],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getServiceStartTime() == null ? null : payloadPojo.getServiceStartTime().toString(), TestCastingFunctions.castToTime(linearr[27],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[27],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getServiceEndCity(), TestCastingFunctions.castToString(linearr[28]));
			Assert.assertEquals(payloadPojo.getServiceEndDate(), TestCastingFunctions.castToDate(linearr[29],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getServiceEndTime() == null ? null : payloadPojo.getServiceEndTime().toString(), TestCastingFunctions.castToTime(linearr[30],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[30],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getPOSAgencyActualCityCode(), TestCastingFunctions.castToString(linearr[31]));
			Assert.assertEquals(payloadPojo.getEquipmentCodeDescription(), TestCastingFunctions.castToString(linearr[32]));
			Assert.assertEquals(payloadPojo.getPreReservedSeatIndicator(), TestCastingFunctions.castToString(linearr[33]));
			Assert.assertEquals(payloadPojo.getConfirmationNbr(), TestCastingFunctions.castToString(linearr[34]));
			Assert.assertEquals(payloadPojo.getFlightPOSAgentIATANbr(), TestCastingFunctions.castToString(linearr[35]));
			Assert.assertEquals(payloadPojo.getHistoryActionCodeId(), TestCastingFunctions.castToString(linearr[36]));
			Assert.assertEquals(payloadPojo.getRecordUpdateDate(), TestCastingFunctions.castToDate(linearr[37],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getRecordUpdateTime() == null ? null : payloadPojo.getRecordUpdateTime().toString(), TestCastingFunctions.castToTime(linearr[38],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[38],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getIntraPNRSetNbr(), TestCastingFunctions.castToShort(linearr[39]));
			Assert.assertEquals(payloadPojo.getSegmentBookedDate(), TestCastingFunctions.castToDate(linearr[40],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getSegmentBookedTime() == null ? null : payloadPojo.getSegmentBookedTime().toString(), TestCastingFunctions.castToTime(linearr[41],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[41],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getOpenFlightSegmentIndicator(), TestCastingFunctions.castToShort(linearr[42]));
			Assert.assertEquals(payloadPojo.getSegmentActivityCode(), TestCastingFunctions.castToString(linearr[43]));
			Assert.assertEquals(payloadPojo.getBSGMSTRPNRLocatorID(), TestCastingFunctions.castToString(linearr[44]));
			Assert.assertEquals(payloadPojo.getBSGMSTRPNRCreateDate(), TestCastingFunctions.castToDate(linearr[45],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getNewMarriedConxGroupNbr(), TestCastingFunctions.castToShort(linearr[46]));
			Assert.assertEquals(payloadPojo.getNewMarriedConxSeqNbr(), TestCastingFunctions.castToShort(linearr[47]));
			Assert.assertEquals(payloadPojo.getNewMarriedConxOutOfSeqInd(), TestCastingFunctions.castToString(linearr[48]));
			Assert.assertEquals(payloadPojo.getMarketingClassOfService(), TestCastingFunctions.castToString(linearr[49]));
			Assert.assertEquals(payloadPojo.getOperatingClassOfService(), TestCastingFunctions.castToString(linearr[50]));
			Assert.assertEquals(payloadPojo.getIATAEquipCode(), TestCastingFunctions.castToString(linearr[51]));
			Assert.assertEquals(payloadPojo.getIATAEquipDesc(), TestCastingFunctions.castToString(linearr[52]));
			Assert.assertEquals(payloadPojo.getOperatingAirlnLocatorID(), TestCastingFunctions.castToString(linearr[53]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in ResFlight file. Exception message: " + e.getMessage(), e);
		}

	
}

}