package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResSuspDocAgmt;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class ResSuspDocAgmtCustomAssertion {

	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		ResSuspDocAgmt payloadPojo = new ResSuspDocAgmt();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof ResSuspDocAgmt)
	        	payloadPojo = (ResSuspDocAgmt) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not ResSuspDocAgmt.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of ResSuspDocAgmt.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorID(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getFromDateTime(), TestCastingFunctions.castToTimestamp(linearr[3],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getPNRPassengerSeqID(), TestCastingFunctions.castToShort(linearr[4]));
			Assert.assertEquals(payloadPojo.getResArrSequenceId(), TestCastingFunctions.castToShort(linearr[5]));
			Assert.assertEquals(payloadPojo.getResArrQueuePlaceDate(), TestCastingFunctions.castToDate(linearr[6],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getResArrQueueName(), TestCastingFunctions.castToString(linearr[7]));
			Assert.assertEquals(payloadPojo.getResArrangementLocationCode(), TestCastingFunctions.castToString(linearr[8]));
			Assert.assertEquals(payloadPojo.getArrPassengerReferenceName(), TestCastingFunctions.castToString(linearr[9]));
			Assert.assertEquals(payloadPojo.getArrActivityDate(), TestCastingFunctions.castToDate(linearr[10],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getArrActivityTime() == null ? null : payloadPojo.getArrActivityTime().toString(), TestCastingFunctions.castToTime(linearr[11],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[11],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getArrDutyCode(), TestCastingFunctions.castToString(linearr[12]));
			Assert.assertEquals(payloadPojo.getArrSine(), TestCastingFunctions.castToString(linearr[13]));
			Assert.assertEquals(payloadPojo.getSSRText(), TestCastingFunctions.castToString(linearr[14]));
			Assert.assertEquals(payloadPojo.getSSRCode(), TestCastingFunctions.castToString(linearr[15]));
			Assert.assertEquals(payloadPojo.getSourceTypeCode(), TestCastingFunctions.castToString(linearr[16]));
			Assert.assertEquals(payloadPojo.getSSRIdTypeCode(), TestCastingFunctions.castToString(linearr[17]));
			Assert.assertEquals(payloadPojo.getResArrActionCode(), TestCastingFunctions.castToString(linearr[18]));
			Assert.assertEquals(payloadPojo.getServiceStartCityCode(), TestCastingFunctions.castToString(linearr[19]));
			Assert.assertEquals(payloadPojo.getServiceEndCityCode(), TestCastingFunctions.castToString(linearr[20]));
			Assert.assertEquals(payloadPojo.getTicketNbr(), TestCastingFunctions.castToString(linearr[21]));
			Assert.assertEquals(payloadPojo.getSSRNbrInParty(), TestCastingFunctions.castToShort(linearr[22]));
			Assert.assertEquals(payloadPojo.getSSRStartDate(), TestCastingFunctions.castToDate(linearr[23],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getSSRFlightNumber(), TestCastingFunctions.castToString(linearr[24]));
			Assert.assertEquals(payloadPojo.getClassOfService(), TestCastingFunctions.castToString(linearr[25]));
			Assert.assertEquals(payloadPojo.getVendorCode(), TestCastingFunctions.castToString(linearr[26]));
			Assert.assertEquals(payloadPojo.getSSRStatusCode(), TestCastingFunctions.castToString(linearr[27]));
			Assert.assertEquals(payloadPojo.getHistoryActionCodeId(), TestCastingFunctions.castToString(linearr[28]));
			Assert.assertEquals(payloadPojo.getRecordUpdateDate(), TestCastingFunctions.castToDate(linearr[29],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getRecordUpdateTime() == null ? null : payloadPojo.getRecordUpdateTime().toString(), TestCastingFunctions.castToTime(linearr[30],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[30],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getIntraPNRSetNbr(), TestCastingFunctions.castToShort(linearr[31]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in ResSuspDocAgmt file. Exception message: " + e.getMessage(), e);
		}

}

}