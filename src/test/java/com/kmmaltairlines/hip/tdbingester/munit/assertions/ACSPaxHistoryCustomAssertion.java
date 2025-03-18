package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;
import org.springframework.expression.TypedValue;

import com.kmmaltairlines.hip.tdbingester.filepojos.ACSPaxHistory;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class ACSPaxHistoryCustomAssertion  {

	
	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		ACSPaxHistory payloadPojo = new ACSPaxHistory();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof ACSPaxHistory)
	        	payloadPojo = (ACSPaxHistory) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not ACSPaxHistory.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of ACSPaxHistory.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getSourceSystemID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getACSFltSegDate(), TestCastingFunctions.castToDate(linearr[1],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getAirlineCode(), TestCastingFunctions.castToString(linearr[2]));
			Assert.assertEquals(payloadPojo.getFltNbr(), TestCastingFunctions.castToString(linearr[3]));
			Assert.assertEquals(payloadPojo.getAirlineOrigAirport(), TestCastingFunctions.castToString(linearr[4]));
			Assert.assertEquals(payloadPojo.getPNRLocatorId(), TestCastingFunctions.castToString(linearr[5]));
			Assert.assertEquals(payloadPojo.getNameLast(), TestCastingFunctions.castToString(linearr[6]));
			Assert.assertEquals(payloadPojo.getNameFirst(), TestCastingFunctions.castToString(linearr[7]));
			Assert.assertEquals(payloadPojo.getAirlineDestAirport(), TestCastingFunctions.castToString(linearr[8]));
			Assert.assertEquals(payloadPojo.getSchdServiceStartDate(), TestCastingFunctions.castToDate(linearr[9],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getSchdServiceStartTime() == null ? null : payloadPojo.getSchdServiceStartTime().toString(), TestCastingFunctions.castToTime(linearr[10],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[10],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getAAACityCode(), TestCastingFunctions.castToString(linearr[11]));
			Assert.assertEquals(payloadPojo.getAgentSine(), TestCastingFunctions.castToString(linearr[12]));
			Assert.assertEquals(payloadPojo.getActionDate(), TestCastingFunctions.castToDate(linearr[13],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getActionTime() == null ? null : payloadPojo.getActionTime().toString(), TestCastingFunctions.castToTime(linearr[14],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[14],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getAgntStationLNIATA(), TestCastingFunctions.castToString(linearr[15]));
			Assert.assertEquals(payloadPojo.getActionItem(), TestCastingFunctions.castToString(linearr[16]));
			Assert.assertEquals(payloadPojo.getSeatLtr(), TestCastingFunctions.castToString(linearr[17]));
			Assert.assertEquals(payloadPojo.getSeatNbr(), TestCastingFunctions.castToString(linearr[18]));
			Assert.assertEquals(payloadPojo.getNbrOfBags(), TestCastingFunctions.castToString(linearr[19]));
			Assert.assertEquals(payloadPojo.getEditCode(), TestCastingFunctions.castToString(linearr[20]));
			Assert.assertEquals(payloadPojo.getAgntDtyCd(), TestCastingFunctions.castToString(linearr[21]));
			Assert.assertEquals(payloadPojo.getAgntHomeStation(), TestCastingFunctions.castToString(linearr[22]));
			Assert.assertEquals(payloadPojo.getPaxID(), TestCastingFunctions.castToShort(linearr[23]));
			Assert.assertEquals(payloadPojo.getItinID(), TestCastingFunctions.castToShort(linearr[24]));
			Assert.assertEquals(payloadPojo.getPrevSeatNbr(), TestCastingFunctions.castToString(linearr[25]));
			Assert.assertEquals(payloadPojo.getPrevSeatLtr(), TestCastingFunctions.castToString(linearr[26]));
			Assert.assertEquals(payloadPojo.getOnBoardStatus(), TestCastingFunctions.castToString(linearr[27]));
			Assert.assertEquals(payloadPojo.getBPIssueStatus(), TestCastingFunctions.castToString(linearr[28]));
			Assert.assertEquals(payloadPojo.getBPReprintedStatus(), TestCastingFunctions.castToString(linearr[29]));
			Assert.assertEquals(payloadPojo.getBagTagInd(), TestCastingFunctions.castToString(linearr[30]));
			Assert.assertEquals(payloadPojo.getMsgCreateDateTime(), TestCastingFunctions.castToTimestamp(linearr[31],"yyyy-MM-dd HH:mm:ss"));
			Assert.assertEquals(payloadPojo.getPrev_BagTagInd(), TestCastingFunctions.castToString(linearr[32]));
			Assert.assertEquals(payloadPojo.getPrev_OnBoardStatus(), TestCastingFunctions.castToString(linearr[33]));
			Assert.assertEquals(payloadPojo.getPrev_BPIssueStatus(), TestCastingFunctions.castToString(linearr[34]));
			Assert.assertEquals(payloadPojo.getPrev_BPReprintedStatus(), TestCastingFunctions.castToString(linearr[35]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in ACSPaxHistory file. Exception message: " + e.getMessage(), e);
		}

}


	public void execute(TypedValue arg0, Object arg1) throws AssertionError {
		// TODO Auto-generated method stub
		
	}
}