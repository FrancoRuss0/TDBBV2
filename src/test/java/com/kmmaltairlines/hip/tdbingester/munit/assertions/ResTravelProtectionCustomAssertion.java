package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResTravelProtection;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class ResTravelProtectionCustomAssertion {

	
	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		ResTravelProtection payloadPojo = new ResTravelProtection();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof ResTravelProtection)
	        	payloadPojo = (ResTravelProtection) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not ResTravelProtection.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of ResTravelProtection.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorID(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getFromDateTime(), TestCastingFunctions.castToTimestamp(linearr[3],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getSegmentNbr(), TestCastingFunctions.castToShort(linearr[4]));
			Assert.assertEquals(payloadPojo.getPlanTypeCode(), TestCastingFunctions.castToString(linearr[5]));
			Assert.assertEquals(payloadPojo.getVendorCode(), TestCastingFunctions.castToString(linearr[6]));
			Assert.assertEquals(payloadPojo.getPurchaseDate(), TestCastingFunctions.castToDate(linearr[7],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getSegmentType(), TestCastingFunctions.castToShort(linearr[8]));
			Assert.assertEquals(payloadPojo.getConfirmationNbr(), TestCastingFunctions.castToString(linearr[9]));
			Assert.assertEquals(payloadPojo.getCurrentSegmentStatusCode(), TestCastingFunctions.castToString(linearr[10]));
			Assert.assertEquals(payloadPojo.getServiceStartDate(), TestCastingFunctions.castToDate(linearr[11],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getServiceEndDate(), TestCastingFunctions.castToDate(linearr[12],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getServiceStartCityCode(), TestCastingFunctions.castToString(linearr[13]));
			Assert.assertEquals(payloadPojo.getServiceEndCityCode(), TestCastingFunctions.castToString(linearr[14]));
			Assert.assertEquals(payloadPojo.getFOPCode(), TestCastingFunctions.castToString(linearr[15]));
			Assert.assertEquals(payloadPojo.getPaymentCreditCardCode(), TestCastingFunctions.castToString(linearr[16]));
			Assert.assertEquals(payloadPojo.getPaymentCreditCardNbr(), TestCastingFunctions.castToString(linearr[17]));
			Assert.assertEquals(payloadPojo.getPaymentCreditCardExpDate(), TestCastingFunctions.castToDate(linearr[18],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getCurrCode(), TestCastingFunctions.castToString(linearr[19]));
			Assert.assertEquals(payloadPojo.getPremiumValue(), TestCastingFunctions.castToString(linearr[20]));
			Assert.assertEquals(payloadPojo.getPremiumAmt(), TestCastingFunctions.castToBigDecimal(linearr[21]));
			Assert.assertEquals(payloadPojo.getPremiumAmtUSD(), TestCastingFunctions.castToBigDecimal(linearr[22]));
			Assert.assertEquals(payloadPojo.getRecordUpdateDate(), TestCastingFunctions.castToDate(linearr[23],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getRecordUpdateTime() == null ? null : payloadPojo.getRecordUpdateTime().toString(), TestCastingFunctions.castToTime(linearr[24],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[24],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getHistoryActionCodeID(), TestCastingFunctions.castToString(linearr[25]));
			Assert.assertEquals(payloadPojo.getIntraPNRSetNbr(), TestCastingFunctions.castToShort(linearr[26]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in ResTravelProtection file. Exception message: " + e.getMessage(), e);
		}

}

}