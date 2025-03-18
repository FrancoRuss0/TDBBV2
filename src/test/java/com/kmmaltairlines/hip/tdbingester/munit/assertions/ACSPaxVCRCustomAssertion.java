package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;
import org.springframework.expression.TypedValue;

import com.kmmaltairlines.hip.tdbingester.filepojos.ACSPaxVCR;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class ACSPaxVCRCustomAssertion {

	
	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		ACSPaxVCR payloadPojo = new ACSPaxVCR();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof ACSPaxVCR)
	        	payloadPojo = (ACSPaxVCR) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not ACSPaxVCR.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of ACSPaxVCR.", new Exception());
		

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
			Assert.assertEquals(payloadPojo.getVCRCreateDate(), TestCastingFunctions.castToDate(linearr[8],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getAirlineAccountingCode(), TestCastingFunctions.castToString(linearr[9]));
			Assert.assertEquals(payloadPojo.getVCRSerialNbr(), TestCastingFunctions.castToString(linearr[10]));
			Assert.assertEquals(payloadPojo.getVCRCouponSeqNbr(), TestCastingFunctions.castToShort(linearr[11]));
			Assert.assertEquals(payloadPojo.getClassofService(), TestCastingFunctions.castToString(linearr[12]));
			Assert.assertEquals(payloadPojo.getFareBasisCode(), TestCastingFunctions.castToString(linearr[13]));
			Assert.assertEquals(payloadPojo.getVCRInUseInd(), TestCastingFunctions.castToString(linearr[14]));
			Assert.assertEquals(payloadPojo.getVCRSelectDisAssocInd(), TestCastingFunctions.castToString(linearr[15]));
			Assert.assertEquals(payloadPojo.getVCRDisAssocInd(), TestCastingFunctions.castToString(linearr[16]));
			Assert.assertEquals(payloadPojo.getVCRDisAssocRsn(), TestCastingFunctions.castToString(linearr[17]));
			Assert.assertEquals(payloadPojo.getVCRGrabNGoInd(), TestCastingFunctions.castToString(linearr[18]));
			Assert.assertEquals(payloadPojo.getCommonElecTktInd(), TestCastingFunctions.castToString(linearr[19]));
			Assert.assertEquals(payloadPojo.getVCRExistInd(), TestCastingFunctions.castToString(linearr[20]));
			Assert.assertEquals(payloadPojo.getMultiVCRInd(), TestCastingFunctions.castToString(linearr[21]));
			Assert.assertEquals(payloadPojo.getPrevCpnStatsErrInd(), TestCastingFunctions.castToString(linearr[22]));
			Assert.assertEquals(payloadPojo.getPrevCpnStatsErrOverrideInd(), TestCastingFunctions.castToString(linearr[23]));
			Assert.assertEquals(payloadPojo.getInfVCRInd(), TestCastingFunctions.castToString(linearr[24]));
			Assert.assertEquals(payloadPojo.getInfVCRIssueDate(), TestCastingFunctions.castToDate(linearr[25],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getInfVCRCreateDate(), TestCastingFunctions.castToDate(linearr[26],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getInfVCRCreateTime() == null ? null : payloadPojo.getInfVCRCreateTime().toString(), TestCastingFunctions.castToTime(linearr[27],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[27],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getInfVCRAirlineAccountingCode(), TestCastingFunctions.castToString(linearr[28]));
			Assert.assertEquals(payloadPojo.getInfVCRSerialNbr(), TestCastingFunctions.castToString(linearr[29]));
			Assert.assertEquals(payloadPojo.getInfVCRCouponSeqNbr(), TestCastingFunctions.castToShort(linearr[30]));
			Assert.assertEquals(payloadPojo.getInfVCRFareBasisCode(), TestCastingFunctions.castToString(linearr[31]));
			Assert.assertEquals(payloadPojo.getInfVCRClassofService(), TestCastingFunctions.castToString(linearr[32]));
			Assert.assertEquals(payloadPojo.getInfVCRInUseInd(), TestCastingFunctions.castToString(linearr[33]));
			Assert.assertEquals(payloadPojo.getInfCheckInComplete(), TestCastingFunctions.castToString(linearr[34]));
			Assert.assertEquals(payloadPojo.getMsgCreateDateTime(), TestCastingFunctions.castToTimestamp(linearr[35],"yyyy-MM-dd HH:mm:ss"));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in ACSPaxVCR file. Exception message: " + e.getMessage(), e);
		}

}


	public void execute(TypedValue arg0, Object arg1) throws AssertionError {
		// TODO Auto-generated method stub
		
	}
}