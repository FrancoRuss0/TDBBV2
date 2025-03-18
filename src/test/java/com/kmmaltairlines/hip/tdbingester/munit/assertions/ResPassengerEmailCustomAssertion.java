package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResPassengerEmail;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;

public class ResPassengerEmailCustomAssertion {

	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		ResPassengerEmail payloadPojo = new ResPassengerEmail();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof ResPassengerEmail)
	        	payloadPojo = (ResPassengerEmail) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not ResPassengerEmail.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of ResPassengerEmail.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorID(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getFromDateTime(), TestCastingFunctions.castToTimestamp(linearr[3],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getPNRPassengerEMailSeqId(), TestCastingFunctions.castToShort(linearr[4]));
			Assert.assertEquals(payloadPojo.getEMailAddress(), TestCastingFunctions.castToString(linearr[5]));
			Assert.assertEquals(payloadPojo.getHistoryActionCodeId(), TestCastingFunctions.castToString(linearr[6]));
			Assert.assertEquals(payloadPojo.getRecordUpdateDate(), TestCastingFunctions.castToDate(linearr[7],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getRecordUpdateTime() == null ? null : payloadPojo.getRecordUpdateTime().toString(), TestCastingFunctions.castToTime(linearr[8],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[8],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getIntraPNRSetNbr(), TestCastingFunctions.castToShort(linearr[9]));
			Assert.assertEquals(payloadPojo.getPNRPassengerSeqID(), TestCastingFunctions.castToShort(linearr[10]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in ResPassengerEmail file. Exception message: " + e.getMessage(), e);
		}

}

}