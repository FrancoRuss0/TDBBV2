package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResCar;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class ResCarCustomAssertion {

	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		ResCar payloadPojo = new ResCar();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof ResCar)
	        	payloadPojo = (ResCar) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not ResCar.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of ResCar.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorID(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getFromDateTime(), TestCastingFunctions.castToTimestamp(linearr[3],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getSegmentNbr(), TestCastingFunctions.castToShort(linearr[4]));
			Assert.assertEquals(payloadPojo.getCarClassificationCode(), TestCastingFunctions.castToString(linearr[5]));
			Assert.assertEquals(payloadPojo.getCarCorporateDiscountNbr(), TestCastingFunctions.castToString(linearr[6]));
			Assert.assertEquals(payloadPojo.getCarDropoffChargeAmount(), TestCastingFunctions.castToString(linearr[7]));
			Assert.assertEquals(payloadPojo.getCarDropOffCurCode(), TestCastingFunctions.castToString(linearr[8]));
			Assert.assertEquals(payloadPojo.getCarExtraDayRateAmount(), TestCastingFunctions.castToString(linearr[9]));
			Assert.assertEquals(payloadPojo.getCarExtraHourRateAmount(), TestCastingFunctions.castToString(linearr[10]));
			Assert.assertEquals(payloadPojo.getCarMileageLimit(), TestCastingFunctions.castToString(linearr[11]));
			Assert.assertEquals(payloadPojo.getCarReserveUnderName(), TestCastingFunctions.castToString(linearr[12]));
			Assert.assertEquals(payloadPojo.getCarTypeCode(), TestCastingFunctions.castToString(linearr[13]));
			Assert.assertEquals(payloadPojo.getConfirmationNbr(), TestCastingFunctions.castToString(linearr[14]));
			Assert.assertEquals(payloadPojo.getServiceStartCity(), TestCastingFunctions.castToString(linearr[15]));
			Assert.assertEquals(payloadPojo.getServiceStartDate(), TestCastingFunctions.castToDate(linearr[16],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getServiceStartTime() == null ? null : payloadPojo.getServiceStartTime().toString(), TestCastingFunctions.castToTime(linearr[17],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[17],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getCurrentSegmentStatusCode(), TestCastingFunctions.castToString(linearr[18]));
			Assert.assertEquals(payloadPojo.getUnitsBookedCount(), TestCastingFunctions.castToShort(linearr[19]));
			Assert.assertEquals(payloadPojo.getDaysRentedCount(), TestCastingFunctions.castToShort(linearr[20]));
			Assert.assertEquals(payloadPojo.getVendorCarCode(), TestCastingFunctions.castToString(linearr[21]));
			Assert.assertEquals(payloadPojo.getRentalRate(), TestCastingFunctions.castToString(linearr[22]));
			Assert.assertEquals(payloadPojo.getCurrencyCode(), TestCastingFunctions.castToString(linearr[23]));
			Assert.assertEquals(payloadPojo.getRatePlanCode(), TestCastingFunctions.castToString(linearr[24]));
			Assert.assertEquals(payloadPojo.getNonAirportLocationDescript(), TestCastingFunctions.castToString(linearr[25]));
			Assert.assertEquals(payloadPojo.getProductNonstdEndLocationText(), TestCastingFunctions.castToString(linearr[26]));
			Assert.assertEquals(payloadPojo.getHistoryActionCodeId(), TestCastingFunctions.castToString(linearr[27]));
			Assert.assertEquals(payloadPojo.getRecordUpdateDate(), TestCastingFunctions.castToDate(linearr[28],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getRecordUpdateTime() == null ? null : payloadPojo.getRecordUpdateTime().toString(), TestCastingFunctions.castToTime(linearr[29],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[29],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getIntraPNRSetNbr(), TestCastingFunctions.castToShort(linearr[30]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in ResCar file. Exception message: " + e.getMessage(), e);
		}

}

}