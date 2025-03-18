package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResHotel;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class ResHotelCustomAssertion {

	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		ResHotel payloadPojo = new ResHotel();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof ResHotel)
	        	payloadPojo = (ResHotel) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not ResHotel.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of ResHotel.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorID(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getFromDateTime(), TestCastingFunctions.castToTimestamp(linearr[3],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getSegmentNbr(), TestCastingFunctions.castToShort(linearr[4]));
			Assert.assertEquals(payloadPojo.getServiceCityCode(), TestCastingFunctions.castToString(linearr[5]));
			Assert.assertEquals(payloadPojo.getServiceStartDate(), TestCastingFunctions.castToDate(linearr[6],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getNbrofNightsCount(), TestCastingFunctions.castToShort(linearr[7]));
			Assert.assertEquals(payloadPojo.getUnitsBookedCount(), TestCastingFunctions.castToShort(linearr[8]));
			Assert.assertEquals(payloadPojo.getCurrentSegmentStatusCode(), TestCastingFunctions.castToString(linearr[9]));
			Assert.assertEquals(payloadPojo.getSegmentTypeCode(), TestCastingFunctions.castToShort(linearr[10]));
			Assert.assertEquals(payloadPojo.getPropertyCode(), TestCastingFunctions.castToString(linearr[11]));
			Assert.assertEquals(payloadPojo.getPropertyName(), TestCastingFunctions.castToString(linearr[12]));
			Assert.assertEquals(payloadPojo.getVendorHotelCode(), TestCastingFunctions.castToString(linearr[13]));
			Assert.assertEquals(payloadPojo.getHotelRoomTypeCode(), TestCastingFunctions.castToString(linearr[14]));
			Assert.assertEquals(payloadPojo.getHotelRoomRate(), TestCastingFunctions.castToString(linearr[15]));
			Assert.assertEquals(payloadPojo.getHotelRateCode(), TestCastingFunctions.castToString(linearr[16]));
			Assert.assertEquals(payloadPojo.getCurrencyCode(), TestCastingFunctions.castToString(linearr[17]));
			Assert.assertEquals(payloadPojo.getHotelProductCode(), TestCastingFunctions.castToString(linearr[18]));
			Assert.assertEquals(payloadPojo.getConfirmationNbr(), TestCastingFunctions.castToString(linearr[19]));
			Assert.assertEquals(payloadPojo.getHotelReserveUnderName(), TestCastingFunctions.castToString(linearr[20]));
			Assert.assertEquals(payloadPojo.getHotelCorporateDiscountNbr(), TestCastingFunctions.castToString(linearr[21]));
			Assert.assertEquals(payloadPojo.getHotelExtraPersonRateAmount(), TestCastingFunctions.castToString(linearr[22]));
			Assert.assertEquals(payloadPojo.getHotelExtraPersonCount(), TestCastingFunctions.castToShort(linearr[23]));
			Assert.assertEquals(payloadPojo.getNumberOfAdults(), TestCastingFunctions.castToShort(linearr[24]));
			Assert.assertEquals(payloadPojo.getHistoryActionCodeId(), TestCastingFunctions.castToString(linearr[25]));
			Assert.assertEquals(payloadPojo.getRecordUpdateDate(), TestCastingFunctions.castToDate(linearr[26],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getRecordUpdateTime() == null ? null : payloadPojo.getRecordUpdateTime().toString(), TestCastingFunctions.castToTime(linearr[27],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[27],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getIntraPNRSetNbr(), TestCastingFunctions.castToShort(linearr[28]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in ResHotel file. Exception message: " + e.getMessage(), e);
		}

}

}