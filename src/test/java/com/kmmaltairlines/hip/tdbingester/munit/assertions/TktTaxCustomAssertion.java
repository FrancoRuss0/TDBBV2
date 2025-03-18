package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;

import com.kmmaltairlines.hip.tdbingester.filepojos.TktTax;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class TktTaxCustomAssertion {

	
	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		TktTax payloadPojo = new TktTax();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof TktTax)
	        	payloadPojo = (TktTax) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not TktTax.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of TktTax.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorID(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getPrimaryDocNbr(), TestCastingFunctions.castToString(linearr[3]));
			Assert.assertEquals(payloadPojo.getVCRCreateDate(), TestCastingFunctions.castToDate(linearr[4],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getTransactionDateTime(), TestCastingFunctions.castToTimestamp(linearr[5],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getTaxSeqNbr(), TestCastingFunctions.castToByte(linearr[6]));
			Assert.assertEquals(payloadPojo.getTaxAmt(), TestCastingFunctions.castToBigDecimal(linearr[7]));
			Assert.assertEquals(payloadPojo.getTaxCode(), TestCastingFunctions.castToString(linearr[8]));
			Assert.assertEquals(payloadPojo.getTaxTypeCode(), TestCastingFunctions.castToString(linearr[9]));
			Assert.assertEquals(payloadPojo.getTaxCategoryCode(), TestCastingFunctions.castToString(linearr[10]));
			Assert.assertEquals(payloadPojo.getTaxCurrCode(), TestCastingFunctions.castToString(linearr[11]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in TktTax file. Exception message: " + e.getMessage(), e);
		}

}

}