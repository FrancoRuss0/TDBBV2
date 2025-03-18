package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;

import com.kmmaltairlines.hip.tdbingester.filepojos.PreResSeat;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class PreResSeatCustomAssertion {

	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		PreResSeat payloadPojo = new PreResSeat();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof PreResSeat)
	        	payloadPojo = (PreResSeat) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not PreResSeat.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of PreResSeat.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorID(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getFromDateTime(), TestCastingFunctions.castToTimestamp(linearr[3],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getPNRPassengerSeqId(), TestCastingFunctions.castToShort(linearr[4]));
			Assert.assertEquals(payloadPojo.getPRSSeqNbr(), TestCastingFunctions.castToShort(linearr[5]));
			Assert.assertEquals(payloadPojo.getVendorCode(), TestCastingFunctions.castToString(linearr[6]));
			Assert.assertEquals(payloadPojo.getPRSFlightNumber(), TestCastingFunctions.castToString(linearr[7]));
			Assert.assertEquals(payloadPojo.getPRSCompartmentNbr(), TestCastingFunctions.castToShort(linearr[8]));
			Assert.assertEquals(payloadPojo.getPRSRowNbr(), TestCastingFunctions.castToShort(linearr[9]));
			Assert.assertEquals(payloadPojo.getPRSLetter(), TestCastingFunctions.castToString(linearr[10]));
			Assert.assertEquals(payloadPojo.getPRSCurrentStatusCode(), TestCastingFunctions.castToString(linearr[11]));
			Assert.assertEquals(payloadPojo.getSmokingSeatIndicator(), TestCastingFunctions.castToString(linearr[12]));
			Assert.assertEquals(payloadPojo.getNonSmokingSeatIndicator(), TestCastingFunctions.castToString(linearr[13]));
			Assert.assertEquals(payloadPojo.getWindowSeatIndicator(), TestCastingFunctions.castToString(linearr[14]));
			Assert.assertEquals(payloadPojo.getAisleSeatIndicator(), TestCastingFunctions.castToString(linearr[15]));
			Assert.assertEquals(payloadPojo.getLeftSideSeatIndicator(), TestCastingFunctions.castToString(linearr[16]));
			Assert.assertEquals(payloadPojo.getExitSeatIndicator(), TestCastingFunctions.castToString(linearr[17]));
			Assert.assertEquals(payloadPojo.getRightSideSeatIndicator(), TestCastingFunctions.castToString(linearr[18]));
			Assert.assertEquals(payloadPojo.getBulkheadSeatIndicator(), TestCastingFunctions.castToString(linearr[19]));
			Assert.assertEquals(payloadPojo.getUpperCompartmentSeatIndicator(), TestCastingFunctions.castToString(linearr[20]));
			Assert.assertEquals(payloadPojo.getOverWingSeatIndicator(), TestCastingFunctions.castToString(linearr[21]));
			Assert.assertEquals(payloadPojo.getHistoryActionCodeId(), TestCastingFunctions.castToString(linearr[22]));
			Assert.assertEquals(payloadPojo.getRecordUpdateDate(), TestCastingFunctions.castToDate(linearr[23],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getRecordUpdateTime() == null ? null : payloadPojo.getRecordUpdateTime().toString(), TestCastingFunctions.castToTime(linearr[24],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[24],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getIntraPNRSetNbr(), TestCastingFunctions.castToShort(linearr[25]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in PreResSeat file. Exception message: " + e.getMessage(), e);
		}

}

}