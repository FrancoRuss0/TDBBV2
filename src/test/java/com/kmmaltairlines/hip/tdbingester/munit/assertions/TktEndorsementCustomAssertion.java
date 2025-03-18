package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;
import org.springframework.expression.TypedValue;

import com.kmmaltairlines.hip.tdbingester.filepojos.TktEndorsement;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class TktEndorsementCustomAssertion {

	
	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		TktEndorsement payloadPojo = new TktEndorsement();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof TktEndorsement)
	        	payloadPojo = (TktEndorsement) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not TktEndorsement.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of TktEndorsement.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorID(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getPrimaryDocNbr(), TestCastingFunctions.castToString(linearr[3]));
			Assert.assertEquals(payloadPojo.getVCRCreateDate(), TestCastingFunctions.castToDate(linearr[4],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getTransactionDateTime(), TestCastingFunctions.castToTimestamp(linearr[5],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getEndSeqNbr(), TestCastingFunctions.castToInteger(linearr[6]));
			Assert.assertEquals(payloadPojo.getEndorsements(), TestCastingFunctions.castToString(linearr[7]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in TktEndorsement file. Exception message: " + e.getMessage(), e);
		}

}


	public void execute(TypedValue arg0, Object arg1) throws AssertionError {
		// TODO Auto-generated method stub
		
	}
}