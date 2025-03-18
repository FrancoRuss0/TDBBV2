package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResEmergencyCtc;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class ResEmergencyCtcCustomAssertion {

	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		ResEmergencyCtc payloadPojo = new ResEmergencyCtc();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof ResEmergencyCtc)
	        	payloadPojo = (ResEmergencyCtc) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not ResEmergencyCtc.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of ResEmergencyCtc.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorID(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getFromDateTime(), TestCastingFunctions.castToTimestamp(linearr[3],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getPNRPassengerSeqId(), TestCastingFunctions.castToShort(linearr[4]));
			Assert.assertEquals(payloadPojo.getSourceTypeCode(), TestCastingFunctions.castToString(linearr[5]));
			Assert.assertEquals(payloadPojo.getSSRIdTypeCode(), TestCastingFunctions.castToString(linearr[6]));
			Assert.assertEquals(payloadPojo.getSSRStatusCode(), TestCastingFunctions.castToString(linearr[7]));
			Assert.assertEquals(payloadPojo.getSSRCode(), TestCastingFunctions.castToString(linearr[8]));
			Assert.assertEquals(payloadPojo.getEmergencyContactSeqId(), TestCastingFunctions.castToShort(linearr[9]));
			Assert.assertEquals(payloadPojo.getEmergencyPhoneNumber(), TestCastingFunctions.castToString(linearr[10]));
			Assert.assertEquals(payloadPojo.getEmergencyContactName(), TestCastingFunctions.castToString(linearr[11]));
			Assert.assertEquals(payloadPojo.getCountryCode(), TestCastingFunctions.castToString(linearr[12]));
			Assert.assertEquals(payloadPojo.getVendorCode(), TestCastingFunctions.castToString(linearr[13]));
			Assert.assertEquals(payloadPojo.getSSRText(), TestCastingFunctions.castToString(linearr[14]));
			Assert.assertEquals(payloadPojo.getHistoryActionCodeId(), TestCastingFunctions.castToString(linearr[15]));
			Assert.assertEquals(payloadPojo.getRecordUpdateDate(), TestCastingFunctions.castToDate(linearr[16],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getRecordUpdateTime() == null ? null : payloadPojo.getRecordUpdateTime().toString(), TestCastingFunctions.castToTime(linearr[17],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[17],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getIntraPNRSetNbr(), TestCastingFunctions.castToShort(linearr[18]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in ResEmergencyCtc file. Exception message: " + e.getMessage(), e);
		}

}

}