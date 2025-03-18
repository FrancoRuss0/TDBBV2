package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResAirExtraTax;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class ResAirExtraTaxCustomAssertion{

	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		ResAirExtraTax payloadPojo = new ResAirExtraTax();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof ResAirExtraTax)
	        	payloadPojo = (ResAirExtraTax) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not ResAirExtraTax.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of ResAirExtraTax.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorID(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getFromDateTime(), TestCastingFunctions.castToTimestamp(linearr[3],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getAETaxSeqNbr(), TestCastingFunctions.castToByte(linearr[4]));
			Assert.assertEquals(payloadPojo.getPNRPassengerSeqId(), TestCastingFunctions.castToShort(linearr[5]));
			Assert.assertEquals(payloadPojo.getRFISubCode(), TestCastingFunctions.castToString(linearr[6]));
			Assert.assertEquals(payloadPojo.getTaxCode(), TestCastingFunctions.castToString(linearr[7]));
			Assert.assertEquals(payloadPojo.getTaxAmount(), TestCastingFunctions.castToBigDecimal(linearr[8]));
			Assert.assertEquals(payloadPojo.getRecordUpdateDate(), TestCastingFunctions.castToDate(linearr[9],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getRecordUpdateTime() == null ? null : payloadPojo.getRecordUpdateTime().toString(), TestCastingFunctions.castToTime(linearr[10],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[10],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getIntraPNRSetNbr(), TestCastingFunctions.castToShort(linearr[11]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in ResAirExtraTax file. Exception message: " + e.getMessage(), e);
		}

}

}