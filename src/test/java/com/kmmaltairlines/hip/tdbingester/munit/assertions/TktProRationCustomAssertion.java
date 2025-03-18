package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;
import org.springframework.expression.TypedValue;

import com.kmmaltairlines.hip.tdbingester.filepojos.TktProRation;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;

public class TktProRationCustomAssertion  {

	
	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		TktProRation payloadPojo = new TktProRation();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof TktProRation)
	        	payloadPojo = (TktProRation) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not TktProRation.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of TktProRation.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorID(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getPrimaryDocNbr(), TestCastingFunctions.castToString(linearr[3]));
			Assert.assertEquals(payloadPojo.getVCRCreateDate(), TestCastingFunctions.castToDate(linearr[4],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getTransactionDateTime(), TestCastingFunctions.castToTimestamp(linearr[5],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getCouponSeqNbr(), TestCastingFunctions.castToShort(linearr[6]));
			Assert.assertEquals(payloadPojo.getCouponDistanceKm(), TestCastingFunctions.castToBigDecimal(linearr[7]));
			Assert.assertEquals(payloadPojo.getCouponDistanceMi(), TestCastingFunctions.castToBigDecimal(linearr[8]));
			Assert.assertEquals(payloadPojo.getProrationFactor(), TestCastingFunctions.castToBigDecimal(linearr[9]));
			Assert.assertEquals(payloadPojo.getProrateBaseFareUSD(), TestCastingFunctions.castToBigDecimal(linearr[10]));
			Assert.assertEquals(payloadPojo.getProrateTotalDocAmtUSD(), TestCastingFunctions.castToBigDecimal(linearr[11]));
			Assert.assertEquals(payloadPojo.getEquivBaseFareCurrCode(), TestCastingFunctions.castToString(linearr[12]));
			Assert.assertEquals(payloadPojo.getEquivUSDExchgRate(), TestCastingFunctions.castToBigDecimal(linearr[13]));
			Assert.assertEquals(payloadPojo.getProrateEquivBaseFareAmt(), TestCastingFunctions.castToBigDecimal(linearr[14]));
			Assert.assertEquals(payloadPojo.getProrateEquivTotalDocAmt(), TestCastingFunctions.castToBigDecimal(linearr[15]));
			Assert.assertEquals(payloadPojo.getOwnerCurrencyCode(), TestCastingFunctions.castToString(linearr[16]));
			Assert.assertEquals(payloadPojo.getProrateBaseFareOwnerAmt(), TestCastingFunctions.castToBigDecimal(linearr[17]));
			Assert.assertEquals(payloadPojo.getProrateTotalDocOwnerAmt(), TestCastingFunctions.castToBigDecimal(linearr[18]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in TktProRation file. Exception message: " + e.getMessage(), e);
		}

}

	public void execute(TypedValue arg0, Object arg1) throws AssertionError {
		// TODO Auto-generated method stub
		
	}
}