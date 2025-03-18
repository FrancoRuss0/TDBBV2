package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;
import org.springframework.expression.TypedValue;

import com.kmmaltairlines.hip.tdbingester.filepojos.TKTFees;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class TKTFeesCustomAssertion {

	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		TKTFees payloadPojo = new TKTFees();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof TKTFees)
	        	payloadPojo = (TKTFees) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not TKTFees.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of TKTFees.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPrimaryDocNbr(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getVCRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getTransactionDateTime(), TestCastingFunctions.castToTimestamp(linearr[3],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getSourceSystemId(), TestCastingFunctions.castToString(linearr[4]));
			Assert.assertEquals(payloadPojo.getFeeSequenceNbr(), TestCastingFunctions.castToInteger(linearr[5]));
			Assert.assertEquals(payloadPojo.getFeeTypeCd(), TestCastingFunctions.castToString(linearr[6]));
			Assert.assertEquals(payloadPojo.getFeeCatCd(), TestCastingFunctions.castToString(linearr[7]));
			Assert.assertEquals(payloadPojo.getFeeCurrCd(), TestCastingFunctions.castToString(linearr[8]));
			Assert.assertEquals(payloadPojo.getFeeAmt(), TestCastingFunctions.castToBigDecimal(linearr[9]));
			Assert.assertEquals(payloadPojo.getFeeAmtUSD(), TestCastingFunctions.castToBigDecimal(linearr[10]));
			Assert.assertEquals(payloadPojo.getApplyCreditInd(), TestCastingFunctions.castToString(linearr[11]));
			Assert.assertEquals(payloadPojo.getFeeSubCategory(), TestCastingFunctions.castToString(linearr[12]));
			Assert.assertEquals(payloadPojo.getFeeWaivedInd(), TestCastingFunctions.castToString(linearr[13]));
			Assert.assertEquals(payloadPojo.getFeeDescription(), TestCastingFunctions.castToString(linearr[14]));
			Assert.assertEquals(payloadPojo.getFeePriceCd(), TestCastingFunctions.castToString(linearr[15]));
			Assert.assertEquals(payloadPojo.getFeeWaiverCd(), TestCastingFunctions.castToString(linearr[16]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in TKTFees file. Exception message: " + e.getMessage(), e);
		}

}

	public void execute(TypedValue arg0, Object arg1) throws AssertionError {
		// TODO Auto-generated method stub
		
	}
}