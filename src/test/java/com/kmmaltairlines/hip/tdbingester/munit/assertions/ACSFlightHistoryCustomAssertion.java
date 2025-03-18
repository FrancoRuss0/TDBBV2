package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;
import org.springframework.expression.TypedValue;

import com.kmmaltairlines.hip.tdbingester.filepojos.ACSFlightHistory;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class ACSFlightHistoryCustomAssertion {

	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		ACSFlightHistory payloadPojo = new ACSFlightHistory();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof ACSFlightHistory)
	        	payloadPojo = (ACSFlightHistory) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not ACSFlightHistory.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of ACSFlightHistory.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getSourceSystemID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getACSFltSegDate(), TestCastingFunctions.castToDate(linearr[1],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getAirlineCode(), TestCastingFunctions.castToString(linearr[2]));
			Assert.assertEquals(payloadPojo.getFltNbr(), TestCastingFunctions.castToString(linearr[3]));
			Assert.assertEquals(payloadPojo.getAirlineOrigAirport(), TestCastingFunctions.castToString(linearr[4]));
			Assert.assertEquals(payloadPojo.getAirlineDestAirport(), TestCastingFunctions.castToString(linearr[5]));
			Assert.assertEquals(payloadPojo.getSchdServiceStartTime() == null ? null : payloadPojo.getSchdServiceStartTime().toString(), TestCastingFunctions.castToTime(linearr[6],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[6],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getAAACityCode(), TestCastingFunctions.castToString(linearr[7]));
			Assert.assertEquals(payloadPojo.getAgentSine(), TestCastingFunctions.castToString(linearr[8]));
			Assert.assertEquals(payloadPojo.getActionDate(), TestCastingFunctions.castToDate(linearr[9],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getActionTime() == null ? null : payloadPojo.getActionTime().toString(), TestCastingFunctions.castToTime(linearr[10],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[10],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getAgntStationLNIATA(), TestCastingFunctions.castToString(linearr[11]));
			Assert.assertEquals(payloadPojo.getActionItem(), TestCastingFunctions.castToString(linearr[12]));
			Assert.assertEquals(payloadPojo.getAgntDtyCd(), TestCastingFunctions.castToString(linearr[13]));
			Assert.assertEquals(payloadPojo.getAgntHomeStation(), TestCastingFunctions.castToString(linearr[14]));
			Assert.assertEquals(payloadPojo.getMsgCreateDateTime(), TestCastingFunctions.castToTimestamp(linearr[15],"yyyy-MM-dd HH:mm:ss"));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in ACSFlightHistory file. Exception message: " + e.getMessage(), e);
		}

}


	public void execute(TypedValue arg0, Object arg1) throws AssertionError {
		// TODO Auto-generated method stub
		
	}
}