package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;
import org.springframework.expression.TypedValue;

import com.kmmaltairlines.hip.tdbingester.filepojos.TktCouponEMD;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class TktCouponEMDCustomAssertion {

	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		TktCouponEMD payloadPojo = new TktCouponEMD();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof TktCouponEMD)
	        	payloadPojo = (TktCouponEMD) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not TktCouponEMD.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of TktCouponEMD.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorID(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getPrimaryDocNbr(), TestCastingFunctions.castToString(linearr[3]));
			Assert.assertEquals(payloadPojo.getVCRCreateDate(), TestCastingFunctions.castToDate(linearr[4],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getTransactionDateTime(), TestCastingFunctions.castToTimestamp(linearr[5],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getCouponSeqNbr(), TestCastingFunctions.castToShort(linearr[6]));
			Assert.assertEquals(payloadPojo.getFeeOwnerCode(), TestCastingFunctions.castToString(linearr[7]));
			Assert.assertEquals(payloadPojo.getOCGroupCode(), TestCastingFunctions.castToString(linearr[8]));
			Assert.assertEquals(payloadPojo.getRFICode(), TestCastingFunctions.castToString(linearr[9]));
			Assert.assertEquals(payloadPojo.getQuantSold(), TestCastingFunctions.castToInteger(linearr[10]));
			Assert.assertEquals(payloadPojo.getRFISubCode(), TestCastingFunctions.castToString(linearr[11]));
			Assert.assertEquals(payloadPojo.getCommercialName(), TestCastingFunctions.castToString(linearr[12]));
			Assert.assertEquals(payloadPojo.getEMDTypeCode(), TestCastingFunctions.castToString(linearr[13]));
			Assert.assertEquals(payloadPojo.getFeeGuaranteedInd(), TestCastingFunctions.castToString(linearr[14]));
			Assert.assertEquals(payloadPojo.getFeeVendorCode(), TestCastingFunctions.castToString(linearr[15]));
			Assert.assertEquals(payloadPojo.getSegmentUseCode(), TestCastingFunctions.castToString(linearr[16]));
			Assert.assertEquals(payloadPojo.getRelPrimaryDocNbr(), TestCastingFunctions.castToString(linearr[17]));
			Assert.assertEquals(payloadPojo.getRelCouponSeqNbr(), TestCastingFunctions.castToByte(linearr[18]));
			Assert.assertEquals(payloadPojo.getRelVCRCreateDate(), TestCastingFunctions.castToDate(linearr[19],"yyyy-MM-dd"));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in TktCouponEMD file. Exception message: " + e.getMessage(), e);
		}

}

	public void execute(TypedValue arg0, Object arg1) throws AssertionError {
		// TODO Auto-generated method stub
		
	}
}