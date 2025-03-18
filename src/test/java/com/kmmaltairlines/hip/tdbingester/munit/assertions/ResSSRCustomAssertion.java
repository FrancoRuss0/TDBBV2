package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResSSR;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class ResSSRCustomAssertion {

	
	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		ResSSR payloadPojo = new ResSSR();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof ResSSR)
	        	payloadPojo = (ResSSR) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not ResSSR.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of ResSSR.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorID(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getFromDateTime(), TestCastingFunctions.castToTimestamp(linearr[3],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getResSSRSeqId(), TestCastingFunctions.castToShort(linearr[4]));
			Assert.assertEquals(payloadPojo.getPNRPassengerSeqId(), TestCastingFunctions.castToShort(linearr[5]));
			Assert.assertEquals(payloadPojo.getSourceTypeCode(), TestCastingFunctions.castToString(linearr[6]));
			Assert.assertEquals(payloadPojo.getSSRIdTypeCode(), TestCastingFunctions.castToString(linearr[7]));
			Assert.assertEquals(payloadPojo.getSSRStatusCode(), TestCastingFunctions.castToString(linearr[8]));
			Assert.assertEquals(payloadPojo.getSSRFlightNumber(), TestCastingFunctions.castToString(linearr[9]));
			Assert.assertEquals(payloadPojo.getSSRNbrInParty(), TestCastingFunctions.castToShort(linearr[10]));
			Assert.assertEquals(payloadPojo.getSSRStartDate(), TestCastingFunctions.castToDate(linearr[11],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getVendorCode(), TestCastingFunctions.castToString(linearr[12]));
			Assert.assertEquals(payloadPojo.getSSRCode(), TestCastingFunctions.castToString(linearr[13]));
			Assert.assertEquals(payloadPojo.getSSRText(), TestCastingFunctions.castToString(linearr[14]));
			Assert.assertEquals(payloadPojo.getClassOfService(), TestCastingFunctions.castToString(linearr[15]));
			Assert.assertEquals(payloadPojo.getServiceStartCityCode(), TestCastingFunctions.castToString(linearr[16]));
			Assert.assertEquals(payloadPojo.getServiceEndCityCode(), TestCastingFunctions.castToString(linearr[17]));
			Assert.assertEquals(payloadPojo.getHistoryActionCodeId(), TestCastingFunctions.castToString(linearr[18]));
			Assert.assertEquals(payloadPojo.getRecordUpdateDate(), TestCastingFunctions.castToDate(linearr[19],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getRecordUpdateTime() == null ? null : payloadPojo.getRecordUpdateTime().toString(), TestCastingFunctions.castToTime(linearr[20],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[20],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getIntraPNRSetNbr(), TestCastingFunctions.castToShort(linearr[21]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in ResSSR file. Exception message: " + e.getMessage(), e);
		}

}

}