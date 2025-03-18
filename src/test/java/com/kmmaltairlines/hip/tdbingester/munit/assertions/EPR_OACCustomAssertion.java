package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;
import org.springframework.expression.TypedValue;

import com.kmmaltairlines.hip.tdbingester.filepojos.EPR_OAC;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class EPR_OACCustomAssertion {

	
	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		EPR_OAC payloadPojo = new EPR_OAC();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof EPR_OAC)
	        	payloadPojo = (EPR_OAC) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not EPR_OAC.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of EPR_OAC.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getPCC_Cd(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getUser_Id(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getDefault_Ticketing_Carrier(), TestCastingFunctions.castToString(linearr[2]));
			Assert.assertEquals(payloadPojo.getPersonal_City_Code(), TestCastingFunctions.castToString(linearr[3]));
			Assert.assertEquals(payloadPojo.getPersonal_Account_Code(), TestCastingFunctions.castToString(linearr[4]));
			Assert.assertEquals(payloadPojo.getStation_Code(), TestCastingFunctions.castToString(linearr[5]));
			Assert.assertEquals(payloadPojo.getRecordStatus(), TestCastingFunctions.castToString(linearr[6]));
			Assert.assertEquals(payloadPojo.getEffectiveDate(), TestCastingFunctions.castToDate(linearr[7],"yyyy-MM-dd"));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in EPR_OAC file. Exception message: " + e.getMessage(), e);
		}

}


	public void execute(TypedValue arg0, Object arg1) throws AssertionError {
		// TODO Auto-generated method stub
		
	}
}