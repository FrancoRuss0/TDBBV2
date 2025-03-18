package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;
import org.springframework.expression.TypedValue;

import com.kmmaltairlines.hip.tdbingester.filepojos.TktMSR;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class TktMSRCustomAssertion {

	
	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		TktMSR payloadPojo = new TktMSR();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof TktMSR)
	        	payloadPojo = (TktMSR) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not TktMSR.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of TktMSR.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorID(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getPrimaryDocNbr(), TestCastingFunctions.castToString(linearr[3]));
			Assert.assertEquals(payloadPojo.getVCRCreateDate(), TestCastingFunctions.castToDate(linearr[4],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getTransactionDateTime(), TestCastingFunctions.castToTimestamp(linearr[5],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getMSRSeqNbr(), TestCastingFunctions.castToShort(linearr[6]));
			Assert.assertEquals(payloadPojo.getMSRQuantitySoldCount(), TestCastingFunctions.castToByte(linearr[7]));
			Assert.assertEquals(payloadPojo.getMSRTypeCode(), TestCastingFunctions.castToString(linearr[8]));
			Assert.assertEquals(payloadPojo.getMSRTypeDesc(), TestCastingFunctions.castToString(linearr[9]));
			Assert.assertEquals(payloadPojo.getMSRCurrencyCode(), TestCastingFunctions.castToString(linearr[10]));
			Assert.assertEquals(payloadPojo.getMSRChargeAmount(), TestCastingFunctions.castToBigDecimal(linearr[11]));
			Assert.assertEquals(payloadPojo.getMSRTaxAmount(), TestCastingFunctions.castToBigDecimal(linearr[12]));
			Assert.assertEquals(payloadPojo.getMSRTaxCurrencyCode(), TestCastingFunctions.castToString(linearr[13]));
			Assert.assertEquals(payloadPojo.getSourceSystemId(), TestCastingFunctions.castToString(linearr[14]));
			Assert.assertEquals(payloadPojo.getOCGroupCode(), TestCastingFunctions.castToString(linearr[15]));
			Assert.assertEquals(payloadPojo.getRFISubCode(), TestCastingFunctions.castToString(linearr[16]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in TktMSR file. Exception message: " + e.getMessage(), e);
		}

}

	public void execute(TypedValue arg0, Object arg1) throws AssertionError {
		// TODO Auto-generated method stub
		
	}
}