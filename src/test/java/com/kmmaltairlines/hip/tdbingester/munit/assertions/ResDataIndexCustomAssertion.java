package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResDataIndex;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class ResDataIndexCustomAssertion {

	
	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		ResDataIndex payloadPojo = new ResDataIndex();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof ResDataIndex)
	        	payloadPojo = (ResDataIndex) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not ResDataIndex.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of ResDataIndex.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorID(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getFromDateTime(), TestCastingFunctions.castToTimestamp(linearr[3],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getNameAssociationID(), TestCastingFunctions.castToShort(linearr[4]));
			Assert.assertEquals(payloadPojo.getProfileType(), TestCastingFunctions.castToString(linearr[5]));
			Assert.assertEquals(payloadPojo.getProfileValue(), TestCastingFunctions.castToString(linearr[6]));
			Assert.assertEquals(payloadPojo.getSourceSystemId(), TestCastingFunctions.castToString(linearr[7]));
			Assert.assertEquals(payloadPojo.getRecordUpdateDate(), TestCastingFunctions.castToDate(linearr[8],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getRecordUpdateTime() == null ? null : payloadPojo.getRecordUpdateTime().toString(), TestCastingFunctions.castToTime(linearr[9],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[9],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getIntraPNRSetNbr(), TestCastingFunctions.castToShort(linearr[10]));
			Assert.assertEquals(payloadPojo.getCDISeqNbr(), TestCastingFunctions.castToShort(linearr[11]));
			Assert.assertEquals(payloadPojo.getResActivityCode(), TestCastingFunctions.castToString(linearr[12]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in ResDataIndex file. Exception message: " + e.getMessage(), e);
		}

}

}