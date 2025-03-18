package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResODFlight;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class ResODFlightCustomAssertion {

	
	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		ResODFlight payloadPojo = new ResODFlight();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof ResODFlight)
	        	payloadPojo = (ResODFlight) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not ResODFlight.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of ResODFlight.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorID(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getFromDateTime(), TestCastingFunctions.castToTimestamp(linearr[3],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getSegmentNbr(), TestCastingFunctions.castToShort(linearr[4]));
			Assert.assertEquals(payloadPojo.getAirlineOrigTerminal(), TestCastingFunctions.castToString(linearr[5]));
			Assert.assertEquals(payloadPojo.getAirlineDestTerminal(), TestCastingFunctions.castToString(linearr[6]));
			Assert.assertEquals(payloadPojo.getTravelerOrigTerminal(), TestCastingFunctions.castToString(linearr[7]));
			Assert.assertEquals(payloadPojo.getTravelerDestTerminal(), TestCastingFunctions.castToString(linearr[8]));
			Assert.assertEquals(payloadPojo.getAirlineOrigCntry(), TestCastingFunctions.castToString(linearr[9]));
			Assert.assertEquals(payloadPojo.getAirlineDestCntry(), TestCastingFunctions.castToString(linearr[10]));
			Assert.assertEquals(payloadPojo.getTravelerOrigCntry(), TestCastingFunctions.castToString(linearr[11]));
			Assert.assertEquals(payloadPojo.getTravelerDestCntry(), TestCastingFunctions.castToString(linearr[12]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in ResODFlight file. Exception message: " + e.getMessage(), e);
		}

}


}