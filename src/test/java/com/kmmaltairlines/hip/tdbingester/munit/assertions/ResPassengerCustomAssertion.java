package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResPassenger;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class ResPassengerCustomAssertion {

	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		ResPassenger payloadPojo = new ResPassenger();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof ResPassenger)
	        	payloadPojo = (ResPassenger) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not ResPassenger.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of ResPassenger.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorID(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getFromDateTime(), TestCastingFunctions.castToTimestamp(linearr[3],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getPNRPassengerSeqId(), TestCastingFunctions.castToShort(linearr[4]));
			Assert.assertEquals(payloadPojo.getNameFirst(), TestCastingFunctions.castToString(linearr[5]));
			Assert.assertEquals(payloadPojo.getNameLast(), TestCastingFunctions.castToString(linearr[6]));
			Assert.assertEquals(payloadPojo.getNameComment(), TestCastingFunctions.castToString(linearr[7]));
			Assert.assertEquals(payloadPojo.getRelativePassengerNbr(), TestCastingFunctions.castToString(linearr[8]));
			Assert.assertEquals(payloadPojo.getHistoryActionCodeId(), TestCastingFunctions.castToString(linearr[9]));
			Assert.assertEquals(payloadPojo.getRecordUpdateDate(), TestCastingFunctions.castToDate(linearr[10],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getRecordUpdateTime() == null ? null : payloadPojo.getRecordUpdateTime().toString(), TestCastingFunctions.castToTime(linearr[11],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[11],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getIntraPNRSetNbr(), TestCastingFunctions.castToShort(linearr[12]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in ResPassenger file. Exception message: " + e.getMessage(), e);
		}

}

}