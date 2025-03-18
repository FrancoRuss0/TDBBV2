package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResPaxDoc;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class ResPaxDocCustomAssertion {

	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		ResPaxDoc payloadPojo = new ResPaxDoc();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof ResPaxDoc)
	        	payloadPojo = (ResPaxDoc) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not ResPaxDoc.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of ResPaxDoc.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorID(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getFromDateTime(), TestCastingFunctions.castToTimestamp(linearr[3],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getPassengerDocSeqId(), TestCastingFunctions.castToShort(linearr[4]));
			Assert.assertEquals(payloadPojo.getPNRPassengerSeqId(), TestCastingFunctions.castToShort(linearr[5]));
			Assert.assertEquals(payloadPojo.getDocBirthdate(), TestCastingFunctions.castToDate(linearr[6],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getDocNumber(), TestCastingFunctions.castToString(linearr[7]));
			Assert.assertEquals(payloadPojo.getDocTypeCode(), TestCastingFunctions.castToString(linearr[8]));
			Assert.assertEquals(payloadPojo.getGenderCode(), TestCastingFunctions.castToString(linearr[9]));
			Assert.assertEquals(payloadPojo.getInfantInd(), TestCastingFunctions.castToString(linearr[10]));
			Assert.assertEquals(payloadPojo.getIssueCountryCode(), TestCastingFunctions.castToString(linearr[11]));
			Assert.assertEquals(payloadPojo.getPassengerFirstName(), TestCastingFunctions.castToString(linearr[12]));
			Assert.assertEquals(payloadPojo.getPassengerSecondName(), TestCastingFunctions.castToString(linearr[13]));
			Assert.assertEquals(payloadPojo.getPassengerLastName(), TestCastingFunctions.castToString(linearr[14]));
			Assert.assertEquals(payloadPojo.getPrimaryDocHolderInd(), TestCastingFunctions.castToString(linearr[15]));
			Assert.assertEquals(payloadPojo.getPrimaryDocHolderFirstName(), TestCastingFunctions.castToString(linearr[16]));
			Assert.assertEquals(payloadPojo.getPrimaryDocHolderLastName(), TestCastingFunctions.castToString(linearr[17]));
			Assert.assertEquals(payloadPojo.getSourceTypeCode(), TestCastingFunctions.castToString(linearr[18]));
			Assert.assertEquals(payloadPojo.getSSRCode(), TestCastingFunctions.castToString(linearr[19]));
			Assert.assertEquals(payloadPojo.getSSRIdTypeCode(), TestCastingFunctions.castToString(linearr[20]));
			Assert.assertEquals(payloadPojo.getSSRNumberInParty(), TestCastingFunctions.castToShort(linearr[21]));
			Assert.assertEquals(payloadPojo.getSSRStatusCode(), TestCastingFunctions.castToString(linearr[22]));
			Assert.assertEquals(payloadPojo.getSSRText(), TestCastingFunctions.castToString(linearr[23]));
			Assert.assertEquals(payloadPojo.getVendorCode(), TestCastingFunctions.castToString(linearr[24]));
			Assert.assertEquals(payloadPojo.getHistoryActionCodeId(), TestCastingFunctions.castToString(linearr[25]));
			Assert.assertEquals(payloadPojo.getRecordUpdateDate(), TestCastingFunctions.castToDate(linearr[26],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getRecordUpdateTime() == null ? null : payloadPojo.getRecordUpdateTime().toString(), TestCastingFunctions.castToTime(linearr[27],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[27],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getIntraPNRSetNbr(), TestCastingFunctions.castToShort(linearr[28]));
			Assert.assertEquals(payloadPojo.getDocIssueDate(), TestCastingFunctions.castToDate(linearr[29],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getDocExpDate(), TestCastingFunctions.castToDate(linearr[30],"yyyy-MM-dd"));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in ResPaxDoc file. Exception message: " + e.getMessage(), e);
		}

}

}