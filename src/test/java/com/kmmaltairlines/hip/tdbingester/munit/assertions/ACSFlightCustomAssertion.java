package com.kmmaltairlines.hip.tdbingester.munit.assertions;


import java.util.ArrayList;
import org.junit.Assert;
import org.springframework.expression.TypedValue;

import com.kmmaltairlines.hip.tdbingester.filepojos.*;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class ACSFlightCustomAssertion  {

	
	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		ACSFlight payloadPojo = new ACSFlight();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof ACSFlight)
	        	payloadPojo = (ACSFlight) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not ACSFlight.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of ACSFlight.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getSourceSystemID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getAirlineCode(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getFltNbr(), TestCastingFunctions.castToString(linearr[2]));
			Assert.assertEquals(payloadPojo.getServiceStartDate(), TestCastingFunctions.castToDate(linearr[3],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getAirlineOrigAirport(), TestCastingFunctions.castToString(linearr[4]));
			Assert.assertEquals(payloadPojo.getAirlineDestAirport(), TestCastingFunctions.castToString(linearr[5]));
			Assert.assertEquals(payloadPojo.getSchdAirlineOrigAirport(), TestCastingFunctions.castToString(linearr[6]));
			Assert.assertEquals(payloadPojo.getSchdAirlineDestAirport(), TestCastingFunctions.castToString(linearr[7]));
			Assert.assertEquals(payloadPojo.getAirlineOrigGate(), TestCastingFunctions.castToString(linearr[8]));
			Assert.assertEquals(payloadPojo.getCOGInd(), TestCastingFunctions.castToString(linearr[9]));
			Assert.assertEquals(payloadPojo.getFltOverFlyInd(), TestCastingFunctions.castToString(linearr[10]));
			Assert.assertEquals(payloadPojo.getFltFlagStopInd(), TestCastingFunctions.castToString(linearr[11]));
			Assert.assertEquals(payloadPojo.getFltStubInd(), TestCastingFunctions.castToString(linearr[12]));
			Assert.assertEquals(payloadPojo.getGateReaderLNIATA(), TestCastingFunctions.castToString(linearr[13]));
			Assert.assertEquals(payloadPojo.getEstServiceEndDate(), TestCastingFunctions.castToDate(linearr[14],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getEstServiceEndTime() == null ? null : payloadPojo.getEstServiceEndTime().toString(), TestCastingFunctions.castToTime(linearr[15],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[15],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getEstServiceStartDate(), TestCastingFunctions.castToDate(linearr[16],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getEstServiceStartTime() == null ? null : payloadPojo.getEstServiceStartTime().toString(), TestCastingFunctions.castToTime(linearr[17],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[17],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getSchdServiceStartDate(), TestCastingFunctions.castToDate(linearr[18],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getSchdServiceStartTime() == null ? null : payloadPojo.getSchdServiceStartTime().toString(), TestCastingFunctions.castToTime(linearr[19],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[19],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getSchdServiceEndDate(), TestCastingFunctions.castToDate(linearr[20],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getSchdServiceEndTime() == null ? null : payloadPojo.getSchdServiceEndTime().toString(), TestCastingFunctions.castToTime(linearr[21],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[21],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getFltCloseDate(), TestCastingFunctions.castToDate(linearr[22],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getFltCloseTime() == null ? null : payloadPojo.getFltCloseTime().toString(), TestCastingFunctions.castToTime(linearr[23],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[23],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getPDCDate(), TestCastingFunctions.castToDate(linearr[24],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getPDCTime() == null ? null : payloadPojo.getPDCTime().toString(), TestCastingFunctions.castToTime(linearr[25],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[25],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getFltLegDelayedInd(), TestCastingFunctions.castToString(linearr[26]));
			Assert.assertEquals(payloadPojo.getFltLegStatus(), TestCastingFunctions.castToString(linearr[27]));
			Assert.assertEquals(payloadPojo.getTailNbr(), TestCastingFunctions.castToString(linearr[28]));
			Assert.assertEquals(payloadPojo.getMsgCreateDateTime(), TestCastingFunctions.castToTimestamp(linearr[29],"yyyy-MM-dd HH:mm:ss"));
			Assert.assertEquals(payloadPojo.getEquipmentType(), TestCastingFunctions.castToString(linearr[30]));
			Assert.assertEquals(payloadPojo.getAircraftConfig(), TestCastingFunctions.castToString(linearr[31]));
			Assert.assertEquals(payloadPojo.getTotalPaxCount(), TestCastingFunctions.castToShort(linearr[32]));
			Assert.assertEquals(payloadPojo.getReservedFutureUse1(), TestCastingFunctions.castToShort(linearr[33]));
			Assert.assertEquals(payloadPojo.getReservedFutureUse2(), TestCastingFunctions.castToShort(linearr[34]));
			Assert.assertEquals(payloadPojo.getReservedFutureUse3(), TestCastingFunctions.castToShort(linearr[35]));
			Assert.assertEquals(payloadPojo.getReservedFutureUse4(), TestCastingFunctions.castToShort(linearr[36]));
			Assert.assertEquals(payloadPojo.getReservedFutureUse5(), TestCastingFunctions.castToShort(linearr[37]));
			Assert.assertEquals(payloadPojo.getReservedFutureUse6(), TestCastingFunctions.castToShort(linearr[38]));
			Assert.assertEquals(payloadPojo.getReservedFutureUse7(), TestCastingFunctions.castToShort(linearr[39]));
			Assert.assertEquals(payloadPojo.getReservedFutureUse8(), TestCastingFunctions.castToShort(linearr[40]));
			Assert.assertEquals(payloadPojo.getReservedFutureUse9(), TestCastingFunctions.castToShort(linearr[41]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in ACSFlight file. Exception message: " + e.getMessage(), e);
		}

}

	public void execute(TypedValue arg0, Object arg1) throws AssertionError {
		// TODO Auto-generated method stub
		
	}
}