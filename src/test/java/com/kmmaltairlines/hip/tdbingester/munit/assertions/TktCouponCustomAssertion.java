package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;

import com.kmmaltairlines.hip.tdbingester.filepojos.TktCoupon;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;

public class TktCouponCustomAssertion {

	
	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		TktCoupon payloadPojo = new TktCoupon();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof TktCoupon)
	        	payloadPojo = (TktCoupon) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not TktCoupon.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of TktCoupon.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorID(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getPrimaryDocNbr(), TestCastingFunctions.castToString(linearr[3]));
			Assert.assertEquals(payloadPojo.getVCRCreateDate(), TestCastingFunctions.castToDate(linearr[4],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getTransactionDateTime(), TestCastingFunctions.castToTimestamp(linearr[5],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getCouponSeqNbr(), TestCastingFunctions.castToShort(linearr[6]));
			Assert.assertEquals(payloadPojo.getEntNbr(), TestCastingFunctions.castToByte(linearr[7]));
			Assert.assertEquals(payloadPojo.getCouponStatus(), TestCastingFunctions.castToString(linearr[8]));
			Assert.assertEquals(payloadPojo.getPreviousCouponStatusCode(), TestCastingFunctions.castToString(linearr[9]));
			Assert.assertEquals(payloadPojo.getSegmentTypeCode(), TestCastingFunctions.castToString(linearr[10]));
			Assert.assertEquals(payloadPojo.getMarketingAirlineCode(), TestCastingFunctions.castToString(linearr[11]));
			Assert.assertEquals(payloadPojo.getMarketingFlightNbr(), TestCastingFunctions.castToString(linearr[12]));
			Assert.assertEquals(payloadPojo.getServiceStartCity(), TestCastingFunctions.castToString(linearr[13]));
			Assert.assertEquals(payloadPojo.getServiceEndCity(), TestCastingFunctions.castToString(linearr[14]));
			Assert.assertEquals(payloadPojo.getSegmentStatusCode(), TestCastingFunctions.castToString(linearr[15]));
			Assert.assertEquals(payloadPojo.getServiceStartDate(), TestCastingFunctions.castToDate(linearr[16],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getServiceStartTime() == null ? null : payloadPojo.getServiceStartTime().toString(), TestCastingFunctions.castToTime(linearr[17],"HH:mm:ss.SSSSSS") == null ? null : TestCastingFunctions.castToTime(linearr[17],"HH:mm:ss.SSSSSS").toString());
			Assert.assertEquals(payloadPojo.getServiceEndDate(), TestCastingFunctions.castToDate(linearr[18],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getServiceEndTime() == null ? null : payloadPojo.getServiceEndTime().toString(), TestCastingFunctions.castToTime(linearr[19],"HH:mm:ss.SSSSSS") == null ? null : TestCastingFunctions.castToTime(linearr[19],"HH:mm:ss.SSSSSS").toString());
			Assert.assertEquals(payloadPojo.getClassOfService(), TestCastingFunctions.castToString(linearr[20]));
			Assert.assertEquals(payloadPojo.getFareBasisCode(), TestCastingFunctions.castToString(linearr[21]));
			Assert.assertEquals(payloadPojo.getTktDesignatorCode(), TestCastingFunctions.castToString(linearr[22]));
			Assert.assertEquals(payloadPojo.getFareBreakInd(), TestCastingFunctions.castToString(linearr[23]));
			Assert.assertEquals(payloadPojo.getPriceNotValidBeforeDate(), TestCastingFunctions.castToDate(linearr[24],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getPriceNotValidAfterDate(), TestCastingFunctions.castToDate(linearr[25],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getInvoluntaryInd(), TestCastingFunctions.castToString(linearr[26]));
			Assert.assertEquals(payloadPojo.getFlownFlightNbr(), TestCastingFunctions.castToString(linearr[27]));
			Assert.assertEquals(payloadPojo.getFlownServiceStartDate(), TestCastingFunctions.castToDate(linearr[28],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getFlownServiceStartCity(), TestCastingFunctions.castToString(linearr[29]));
			Assert.assertEquals(payloadPojo.getFlownServiceEndCity(), TestCastingFunctions.castToString(linearr[30]));
			Assert.assertEquals(payloadPojo.getFlownClassOfService(), TestCastingFunctions.castToString(linearr[31]));
			Assert.assertEquals(payloadPojo.getFlownFlightOrigDate(), TestCastingFunctions.castToDate(linearr[32],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getOperatingAirlineCode(), TestCastingFunctions.castToString(linearr[33]));
			Assert.assertEquals(payloadPojo.getOperatingFlightNbr(), TestCastingFunctions.castToString(linearr[34]));
			Assert.assertEquals(payloadPojo.getOperatingPNRLocator(), TestCastingFunctions.castToString(linearr[35]));
			Assert.assertEquals(payloadPojo.getFareBreakAmt(), TestCastingFunctions.castToBigDecimal(linearr[36]));
			Assert.assertEquals(payloadPojo.getFareBreakDiscAmt(), TestCastingFunctions.castToBigDecimal(linearr[37]));
			Assert.assertEquals(payloadPojo.getDiscountAmtInd(), TestCastingFunctions.castToString(linearr[38]));
			Assert.assertEquals(payloadPojo.getDiscountPctInd(), TestCastingFunctions.castToString(linearr[39]));
			Assert.assertEquals(payloadPojo.getStopoverCode(), TestCastingFunctions.castToString(linearr[40]));
			Assert.assertEquals(payloadPojo.getFrequentTravelerNbr(), TestCastingFunctions.castToString(linearr[41]));
			Assert.assertEquals(payloadPojo.getVendorCode(), TestCastingFunctions.castToString(linearr[42]));
			Assert.assertEquals(payloadPojo.getFareBreakCurrencyCode(), TestCastingFunctions.castToString(linearr[43]));
			Assert.assertEquals(payloadPojo.getSettlementAuthCode(), TestCastingFunctions.castToString(linearr[44]));
			Assert.assertEquals(payloadPojo.getBaggageAlwncText(), TestCastingFunctions.castToString(linearr[45]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in TktCoupon file. Exception message: " + e.getMessage(), e);
		}

}

}