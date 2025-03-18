package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResAirExtraPortionofTravel;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class ResAirExtraPortionofTravelCustomAssertion {

	
	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		ResAirExtraPortionofTravel payloadPojo = new ResAirExtraPortionofTravel();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof ResAirExtraPortionofTravel)
	        	payloadPojo = (ResAirExtraPortionofTravel) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not ResAirExtraPortionofTravel.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of ResAirExtraPortionofTravel.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorID(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getIntraPNRSetNbr(), TestCastingFunctions.castToInteger(linearr[3]));
			Assert.assertEquals(payloadPojo.getFromDateTime(), TestCastingFunctions.castToTimestamp(linearr[4],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getTransmissionDateTime(), TestCastingFunctions.castToTimestamp(linearr[5],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getUniqueComponentID(), TestCastingFunctions.castToInteger(linearr[6]));
			Assert.assertEquals(payloadPojo.getAEPortionSeqNbr(), TestCastingFunctions.castToByte(linearr[7]));
			Assert.assertEquals(payloadPojo.getPNRPassengerSeqID(), TestCastingFunctions.castToInteger(linearr[8]));
			Assert.assertEquals(payloadPojo.getAirlineCode(), TestCastingFunctions.castToString(linearr[9]));
			Assert.assertEquals(payloadPojo.getFlightNbr(), TestCastingFunctions.castToString(linearr[10]));
			Assert.assertEquals(payloadPojo.getClassofService(), TestCastingFunctions.castToString(linearr[11]));
			Assert.assertEquals(payloadPojo.getServiceStartDate(), TestCastingFunctions.castToDate(linearr[12],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getServiceStartCity(), TestCastingFunctions.castToString(linearr[13]));
			Assert.assertEquals(payloadPojo.getServiceEndCity(), TestCastingFunctions.castToString(linearr[14]));
			Assert.assertEquals(payloadPojo.getEMDNbr(), TestCastingFunctions.castToString(linearr[15]));
			Assert.assertEquals(payloadPojo.getEmdCouponNbr(), TestCastingFunctions.castToShort(linearr[16]));
			Assert.assertEquals(payloadPojo.getETicketNbr(), TestCastingFunctions.castToString(linearr[17]));
			Assert.assertEquals(payloadPojo.getETicketCpnNbr(), TestCastingFunctions.castToShort(linearr[18]));
			Assert.assertEquals(payloadPojo.getRecordUpdateDate(), TestCastingFunctions.castToDate(linearr[19],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getRecordUpdateDateTime(), TestCastingFunctions.castToTimestamp(linearr[20],"yyyy-MM-dd HH:mm:ss"));
			Assert.assertEquals(payloadPojo.getMarketingCarrierCode(), TestCastingFunctions.castToString(linearr[21]));
			Assert.assertEquals(payloadPojo.getOpertatingCarrierCode(), TestCastingFunctions.castToString(linearr[22]));
			Assert.assertEquals(payloadPojo.getSourceSystemID(), TestCastingFunctions.castToString(linearr[23]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in ResAirExtraPortionofTravel file. Exception message: " + e.getMessage(), e);
		}

}


}