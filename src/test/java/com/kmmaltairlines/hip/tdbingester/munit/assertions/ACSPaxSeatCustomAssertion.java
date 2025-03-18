package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;
import org.springframework.expression.TypedValue;

import com.kmmaltairlines.hip.tdbingester.filepojos.ACSPaxSeat;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class ACSPaxSeatCustomAssertion {

	
	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		ACSPaxSeat payloadPojo = new ACSPaxSeat();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof ACSPaxSeat)
	        	payloadPojo = (ACSPaxSeat) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not ACSPaxSeat.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of ACSPaxSeat.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getSourceSystemID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorId(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getResPaxId(), TestCastingFunctions.castToShort(linearr[3]));
			Assert.assertEquals(payloadPojo.getAirlineCode(), TestCastingFunctions.castToString(linearr[4]));
			Assert.assertEquals(payloadPojo.getFltNbr(), TestCastingFunctions.castToString(linearr[5]));
			Assert.assertEquals(payloadPojo.getServiceStartDate(), TestCastingFunctions.castToDate(linearr[6],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getAirlineOrigAirport(), TestCastingFunctions.castToString(linearr[7]));
			Assert.assertEquals(payloadPojo.getCabinCode(), TestCastingFunctions.castToString(linearr[8]));
			Assert.assertEquals(payloadPojo.getSeatRowNbr(), TestCastingFunctions.castToString(linearr[9]));
			Assert.assertEquals(payloadPojo.getSeatLtr(), TestCastingFunctions.castToString(linearr[10]));
			Assert.assertEquals(payloadPojo.getPreResSeatInd(), TestCastingFunctions.castToString(linearr[11]));
			Assert.assertEquals(payloadPojo.getJumpSeatTypeCode(), TestCastingFunctions.castToString(linearr[12]));
			Assert.assertEquals(payloadPojo.getJumpSeatRowNbr(), TestCastingFunctions.castToString(linearr[13]));
			Assert.assertEquals(payloadPojo.getJumpSeatLtr(), TestCastingFunctions.castToString(linearr[14]));
			Assert.assertEquals(payloadPojo.getPaidUpgradeACAmt(), TestCastingFunctions.castToBigDecimal(linearr[15]));
			Assert.assertEquals(payloadPojo.getInventoryUpgradeInd(), TestCastingFunctions.castToString(linearr[16]));
			Assert.assertEquals(payloadPojo.getDowngradeInd(), TestCastingFunctions.castToString(linearr[17]));
			Assert.assertEquals(payloadPojo.getUpgradeInd(), TestCastingFunctions.castToString(linearr[18]));
			Assert.assertEquals(payloadPojo.getCoachUpgradeInd(), TestCastingFunctions.castToString(linearr[19]));
			Assert.assertEquals(payloadPojo.getBusinessUpgradeInd(), TestCastingFunctions.castToString(linearr[20]));
			Assert.assertEquals(payloadPojo.getMsgCreateDateTime(), TestCastingFunctions.castToTimestamp(linearr[21],"yyyy-MM-dd HH:mm:ss"));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in ACSPaxSeat file. Exception message: " + e.getMessage(), e);
		}

}

	public void execute(TypedValue arg0, Object arg1) throws AssertionError {
		// TODO Auto-generated method stub
		
	}
}