package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResSuspTimeLmt;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class ResSuspTimeLmtCustomAssertion {

	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		ResSuspTimeLmt payloadPojo = new ResSuspTimeLmt();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof ResSuspTimeLmt)
	        	payloadPojo = (ResSuspTimeLmt) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not ResSuspTimeLmt.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of ResSuspTimeLmt.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorID(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getFromDateTime(), TestCastingFunctions.castToTimestamp(linearr[3],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getSuspenseSequenceId(), TestCastingFunctions.castToShort(linearr[4]));
			Assert.assertEquals(payloadPojo.getTimeLimitActionTime(), TestCastingFunctions.castToString(linearr[5]));
			Assert.assertEquals(payloadPojo.getTimeLimitActionDate(), TestCastingFunctions.castToDate(linearr[6],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getTimeLimitLocationCode(), TestCastingFunctions.castToString(linearr[7]));
			Assert.assertEquals(payloadPojo.getTimeLimitVendorCode(), TestCastingFunctions.castToString(linearr[8]));
			Assert.assertEquals(payloadPojo.getHistoryActionCodeId(), TestCastingFunctions.castToString(linearr[9]));
			Assert.assertEquals(payloadPojo.getRecordUpdateDate(), TestCastingFunctions.castToDate(linearr[10],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getRecordUpdateTime() == null ? null : payloadPojo.getRecordUpdateTime().toString(), TestCastingFunctions.castToTime(linearr[11],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[11],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getIntraPNRSetNbr(), TestCastingFunctions.castToShort(linearr[12]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in ResSuspTimeLmt file. Exception message: " + e.getMessage(), e);
		}

}

}