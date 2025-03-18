package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;

import com.kmmaltairlines.hip.tdbingester.filepojos.TktAddress;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class TktAddressCustomAssertion {

	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		TktAddress payloadPojo = new TktAddress();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof TktAddress)
	        	payloadPojo = (TktAddress) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not TktAddress.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of TktAddress.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorID(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getPrimaryDocNbr(), TestCastingFunctions.castToString(linearr[3]));
			Assert.assertEquals(payloadPojo.getVCRCreateDate(), TestCastingFunctions.castToDate(linearr[4],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getTransactionDateTime(), TestCastingFunctions.castToTimestamp(linearr[5],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getAddrSeqNbr(), TestCastingFunctions.castToShort(linearr[6]));
			Assert.assertEquals(payloadPojo.getAddrTxt(), TestCastingFunctions.castToString(linearr[7]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in TktAddress file. Exception message: " + e.getMessage(), e);
		}

}


}