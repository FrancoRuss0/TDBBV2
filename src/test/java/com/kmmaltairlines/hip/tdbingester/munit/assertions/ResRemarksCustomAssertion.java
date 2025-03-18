package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResRemarks;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class ResRemarksCustomAssertion {

	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		ResRemarks payloadPojo = new ResRemarks();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof ResRemarks)
	        	payloadPojo = (ResRemarks) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not ResRemarks.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of ResRemarks.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorID(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getFromDateTime(), TestCastingFunctions.castToTimestamp(linearr[3],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getResRemarkSeqId(), TestCastingFunctions.castToShort(linearr[4]));
			Assert.assertEquals(payloadPojo.getRemarkText(), TestCastingFunctions.castToString(linearr[5]));
			Assert.assertEquals(payloadPojo.getRemarkType(), TestCastingFunctions.castToShort(linearr[6]));
			Assert.assertEquals(payloadPojo.getHistoryActionCodeId(), TestCastingFunctions.castToString(linearr[7]));
			Assert.assertEquals(payloadPojo.getRecordUpdateDate(), TestCastingFunctions.castToDate(linearr[8],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getRecordUpdateTime() == null ? null : payloadPojo.getRecordUpdateTime().toString(), TestCastingFunctions.castToTime(linearr[9],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[9],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getIntraPNRSetNbr(), TestCastingFunctions.castToShort(linearr[10]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in ResRemarks file. Exception message: " + e.getMessage(), e);
		}

}

}