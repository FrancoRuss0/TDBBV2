package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResTravelArranger;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class ResTravelArrangerCustomAssertion {

	
	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		ResTravelArranger payloadPojo = new ResTravelArranger();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof ResTravelArranger)
	        	payloadPojo = (ResTravelArranger) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not ResTravelArranger.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of ResTravelArranger.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorID(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getFromDateTime(), TestCastingFunctions.castToTimestamp(linearr[3],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getSignatureType(), TestCastingFunctions.castToString(linearr[4]));
			Assert.assertEquals(payloadPojo.getUpdateAAACityCode(), TestCastingFunctions.castToString(linearr[5]));
			Assert.assertEquals(payloadPojo.getUpdateAgentDutyCode(), TestCastingFunctions.castToString(linearr[6]));
			Assert.assertEquals(payloadPojo.getUpdateAgentSine(), TestCastingFunctions.castToString(linearr[7]));
			Assert.assertEquals(payloadPojo.getUpdateBookingCRSCode(), TestCastingFunctions.castToString(linearr[8]));
			Assert.assertEquals(payloadPojo.getUpdateHomeCityCode(), TestCastingFunctions.castToString(linearr[9]));
			Assert.assertEquals(payloadPojo.getRecordUpdateDate(), TestCastingFunctions.castToDate(linearr[10],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getRecordUpdateTime() == null ? null : payloadPojo.getRecordUpdateTime().toString(), TestCastingFunctions.castToTime(linearr[11],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[11],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getIntraPNRSetNbr(), TestCastingFunctions.castToShort(linearr[12]));
			Assert.assertEquals(payloadPojo.getReceivedFrom(), TestCastingFunctions.castToString(linearr[13]));
			Assert.assertEquals(payloadPojo.getUpdateAAAOACCityCode(), TestCastingFunctions.castToString(linearr[14]));
			Assert.assertEquals(payloadPojo.getUpdateAAAOACAcctCode(), TestCastingFunctions.castToString(linearr[15]));
			Assert.assertEquals(payloadPojo.getOACDefaultPartitionCode(), TestCastingFunctions.castToString(linearr[16]));
			Assert.assertEquals(payloadPojo.getOACCityCode(), TestCastingFunctions.castToString(linearr[17]));
			Assert.assertEquals(payloadPojo.getOACAcctCode(), TestCastingFunctions.castToString(linearr[18]));
			Assert.assertEquals(payloadPojo.getOACStationNbr(), TestCastingFunctions.castToString(linearr[19]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in ResTravelArranger file. Exception message: " + e.getMessage(), e);
		}

}


}