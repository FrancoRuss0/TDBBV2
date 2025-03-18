package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResAddress;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class ResAddressCustomAssertion {

	
	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		ResAddress payloadPojo = new ResAddress();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof ResAddress)
	        	payloadPojo = (ResAddress) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not ResAddress.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of ResAddress.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorID(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getFromDateTime(), TestCastingFunctions.castToTimestamp(linearr[3],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getAddressLine1(), TestCastingFunctions.castToString(linearr[4]));
			Assert.assertEquals(payloadPojo.getAddressLineType_1(), TestCastingFunctions.castToString(linearr[5]));
			Assert.assertEquals(payloadPojo.getAddressLine2(), TestCastingFunctions.castToString(linearr[6]));
			Assert.assertEquals(payloadPojo.getAddressLineType_2(), TestCastingFunctions.castToString(linearr[7]));
			Assert.assertEquals(payloadPojo.getAddressLine3(), TestCastingFunctions.castToString(linearr[8]));
			Assert.assertEquals(payloadPojo.getAddressLineType_3(), TestCastingFunctions.castToString(linearr[9]));
			Assert.assertEquals(payloadPojo.getAddressLine4(), TestCastingFunctions.castToString(linearr[10]));
			Assert.assertEquals(payloadPojo.getAddressLineType_4(), TestCastingFunctions.castToString(linearr[11]));
			Assert.assertEquals(payloadPojo.getAddressLine5(), TestCastingFunctions.castToString(linearr[12]));
			Assert.assertEquals(payloadPojo.getAddressLineType_5(), TestCastingFunctions.castToString(linearr[13]));
			Assert.assertEquals(payloadPojo.getAddressLine6(), TestCastingFunctions.castToString(linearr[14]));
			Assert.assertEquals(payloadPojo.getAddressLineType_6(), TestCastingFunctions.castToString(linearr[15]));
			Assert.assertEquals(payloadPojo.getRecordUpdateDate(), TestCastingFunctions.castToDate(linearr[16],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getRecordUpdateTime() == null ? null : payloadPojo.getRecordUpdateTime().toString(), TestCastingFunctions.castToTime(linearr[17],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[17],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getHistoryActionCodeId(), TestCastingFunctions.castToString(linearr[18]));
			Assert.assertEquals(payloadPojo.getResAddressSeqID(), TestCastingFunctions.castToInteger(linearr[19]));
			Assert.assertEquals(payloadPojo.getIntraPNRSetNbr(), TestCastingFunctions.castToShort(linearr[20]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in ResAddress file. Exception message: " + e.getMessage(), e);
		}

}

}