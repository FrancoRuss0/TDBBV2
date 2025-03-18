package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;
import org.springframework.expression.TypedValue;

import com.kmmaltairlines.hip.tdbingester.filepojos.TktCouponHistory;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class TktCouponHistoryCustomAssertion {

	
	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		TktCouponHistory payloadPojo = new TktCouponHistory();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof TktCouponHistory)
	        	payloadPojo = (TktCouponHistory) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not TktCouponHistory.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of TktCouponHistory.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorID(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getPrimaryDocNbr(), TestCastingFunctions.castToString(linearr[3]));
			Assert.assertEquals(payloadPojo.getVCRCreateDate(), TestCastingFunctions.castToDate(linearr[4],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getTransactionDateTime(), TestCastingFunctions.castToTimestamp(linearr[5],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getCouponSeqNbr(), TestCastingFunctions.castToInteger(linearr[6]));
			Assert.assertEquals(payloadPojo.getFareBasisCode(), TestCastingFunctions.castToString(linearr[7]));
			Assert.assertEquals(payloadPojo.getCouponNbr(), TestCastingFunctions.castToInteger(linearr[8]));
			Assert.assertEquals(payloadPojo.getPreviousCouponStatusCode(), TestCastingFunctions.castToString(linearr[9]));
			Assert.assertEquals(payloadPojo.getNewCouponStatusCode(), TestCastingFunctions.castToString(linearr[10]));
			Assert.assertEquals(payloadPojo.getCouponNbrChanged(), TestCastingFunctions.castToInteger(linearr[11]));
			Assert.assertEquals(payloadPojo.getPreviousControlVendorCode(), TestCastingFunctions.castToString(linearr[12]));
			Assert.assertEquals(payloadPojo.getNewControlVendorCode(), TestCastingFunctions.castToString(linearr[13]));
			Assert.assertEquals(payloadPojo.getRevalMarketingAirlineCode(), TestCastingFunctions.castToString(linearr[14]));
			Assert.assertEquals(payloadPojo.getRevalClassofService(), TestCastingFunctions.castToString(linearr[15]));
			Assert.assertEquals(payloadPojo.getRevalMarketingFlightNbr(), TestCastingFunctions.castToString(linearr[16]));
			Assert.assertEquals(payloadPojo.getRevalServiceStartDate(), TestCastingFunctions.castToDate(linearr[17],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getRevalServiceStartCity(), TestCastingFunctions.castToString(linearr[18]));
			Assert.assertEquals(payloadPojo.getRevalServiceEndCity(), TestCastingFunctions.castToString(linearr[19]));
			Assert.assertEquals(payloadPojo.getRevalServiceStartTime() == null ? null : payloadPojo.getRevalServiceStartTime().toString(), TestCastingFunctions.castToTime(linearr[20],"HH:mm:ss.SSSSSS") == null ? null : TestCastingFunctions.castToTime(linearr[20],"HH:mm:ss.SSSSSS").toString());
			Assert.assertEquals(payloadPojo.getRevalServiceEndTime() == null ? null : payloadPojo.getRevalServiceEndTime().toString(), TestCastingFunctions.castToTime(linearr[21],"HH:mm:ss.SSSSSS") == null ? null : TestCastingFunctions.castToTime(linearr[21],"HH:mm:ss.SSSSSS").toString());
			Assert.assertEquals(payloadPojo.getRevalSegmentStatusCode(), TestCastingFunctions.castToString(linearr[22]));
			Assert.assertEquals(payloadPojo.getLastUpdate(), TestCastingFunctions.castToDate(linearr[23],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getLastUpdateSysTime() == null ? null : payloadPojo.getLastUpdateSysTime().toString(), TestCastingFunctions.castToTime(linearr[24],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[24],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getHistorySeqNbr(), TestCastingFunctions.castToInteger(linearr[25]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in TktCouponHistory file. Exception message: " + e.getMessage(), e);
		}

}

	public void execute(TypedValue arg0, Object arg1) throws AssertionError {
		// TODO Auto-generated method stub
		
	}
}