package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;

import com.kmmaltairlines.hip.tdbingester.filepojos.TktPayment;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class TktPaymentCustomAssertion {

	
	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		TktPayment payloadPojo = new TktPayment();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof TktPayment)
	        	payloadPojo = (TktPayment) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not TktPayment.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of TktPayment.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorID(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getPrimaryDocNbr(), TestCastingFunctions.castToString(linearr[3]));
			Assert.assertEquals(payloadPojo.getVCRCreateDate(), TestCastingFunctions.castToDate(linearr[4],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getTransactionDateTime(), TestCastingFunctions.castToTimestamp(linearr[5],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getPaymentSeqNbr(), TestCastingFunctions.castToShort(linearr[6]));
			Assert.assertEquals(payloadPojo.getFOPCode(), TestCastingFunctions.castToString(linearr[7]));
			Assert.assertEquals(payloadPojo.getPaymentAmt(), TestCastingFunctions.castToBigDecimal(linearr[8]));
			Assert.assertEquals(payloadPojo.getPaymentVendorCode(), TestCastingFunctions.castToString(linearr[9]));
			Assert.assertEquals(payloadPojo.getAcctNbr(), TestCastingFunctions.castToString(linearr[10]));
			Assert.assertEquals(payloadPojo.getPaymentCurrCode(), TestCastingFunctions.castToString(linearr[11]));
			Assert.assertEquals(payloadPojo.getPaymentRemarks(), TestCastingFunctions.castToString(linearr[12]));
			Assert.assertEquals(payloadPojo.getPaymentApprovalCode(), TestCastingFunctions.castToString(linearr[13]));
			Assert.assertEquals(payloadPojo.getPaymentApprovalTypeCode(), TestCastingFunctions.castToString(linearr[14]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in TktPayment file. Exception message: " + e.getMessage(), e);
		}

}

}