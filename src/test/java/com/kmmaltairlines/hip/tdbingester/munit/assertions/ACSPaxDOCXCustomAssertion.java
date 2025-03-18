package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;
import org.springframework.expression.TypedValue;

import com.kmmaltairlines.hip.tdbingester.filepojos.ACSPaxDOCX;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class ACSPaxDOCXCustomAssertion {

	
	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		ACSPaxDOCX payloadPojo = new ACSPaxDOCX();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof ACSPaxDOCX)
	        	payloadPojo = (ACSPaxDOCX) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not ACSPaxDOCX.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of ACSPaxDOCX.", new Exception());
		

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
			Assert.assertEquals(payloadPojo.getDOCVInd(), TestCastingFunctions.castToString(linearr[8]));
			Assert.assertEquals(payloadPojo.getInfDOCVind(), TestCastingFunctions.castToString(linearr[9]));
			Assert.assertEquals(payloadPojo.getDOCAInd(), TestCastingFunctions.castToString(linearr[10]));
			Assert.assertEquals(payloadPojo.getDocCode(), TestCastingFunctions.castToString(linearr[11]));
			Assert.assertEquals(payloadPojo.getACSDocInd(), TestCastingFunctions.castToString(linearr[12]));
			Assert.assertEquals(payloadPojo.getInfAddressInd(), TestCastingFunctions.castToString(linearr[13]));
			Assert.assertEquals(payloadPojo.getAddressType(), TestCastingFunctions.castToString(linearr[14]));
			Assert.assertEquals(payloadPojo.getAddressStreetNbrName(), TestCastingFunctions.castToString(linearr[15]));
			Assert.assertEquals(payloadPojo.getAddressCity(), TestCastingFunctions.castToString(linearr[16]));
			Assert.assertEquals(payloadPojo.getAddressState(), TestCastingFunctions.castToString(linearr[17]));
			Assert.assertEquals(payloadPojo.getAddressZip(), TestCastingFunctions.castToString(linearr[18]));
			Assert.assertEquals(payloadPojo.getAgtInputCountryCode(), TestCastingFunctions.castToString(linearr[19]));
			Assert.assertEquals(payloadPojo.getAddress2LtrCountryCode(), TestCastingFunctions.castToString(linearr[20]));
			Assert.assertEquals(payloadPojo.getAddress3LtrCountryCode(), TestCastingFunctions.castToString(linearr[21]));
			Assert.assertEquals(payloadPojo.getSegAssocInd(), TestCastingFunctions.castToString(linearr[22]));
			Assert.assertEquals(payloadPojo.getNameAssocInd(), TestCastingFunctions.castToString(linearr[23]));
			Assert.assertEquals(payloadPojo.getACSEntDOCAInd(), TestCastingFunctions.castToString(linearr[24]));
			Assert.assertEquals(payloadPojo.getMultiNameAssocDOCAInd(), TestCastingFunctions.castToString(linearr[25]));
			Assert.assertEquals(payloadPojo.getDocCd(), TestCastingFunctions.castToString(linearr[26]));
			Assert.assertEquals(payloadPojo.getDocInfantInd(), TestCastingFunctions.castToString(linearr[27]));
			Assert.assertEquals(payloadPojo.getDocIssuingCntry(), TestCastingFunctions.castToString(linearr[28]));
			Assert.assertEquals(payloadPojo.getDocNbr(), TestCastingFunctions.castToString(linearr[29]));
			Assert.assertEquals(payloadPojo.getDocPaxCntryCd(), TestCastingFunctions.castToString(linearr[30]));
			Assert.assertEquals(payloadPojo.getDocPaxDOB(), TestCastingFunctions.castToString(linearr[31]));
			Assert.assertEquals(payloadPojo.getDocPaxGender(), TestCastingFunctions.castToString(linearr[32]));
			Assert.assertEquals(payloadPojo.getDocExpiryDate(), TestCastingFunctions.castToString(linearr[33]));
			Assert.assertEquals(payloadPojo.getDocFullFirstName(), TestCastingFunctions.castToString(linearr[34]));
			Assert.assertEquals(payloadPojo.getDocFullMiddleName(), TestCastingFunctions.castToString(linearr[35]));
			Assert.assertEquals(payloadPojo.getDocFullLastName(), TestCastingFunctions.castToString(linearr[36]));
			Assert.assertEquals(payloadPojo.getMultiPassportInd(), TestCastingFunctions.castToString(linearr[37]));
			Assert.assertEquals(payloadPojo.getDocScanInd(), TestCastingFunctions.castToString(linearr[38]));
			Assert.assertEquals(payloadPojo.getDocCntryCd2Ch(), TestCastingFunctions.castToString(linearr[39]));
			Assert.assertEquals(payloadPojo.getDocCntryCd3Ch(), TestCastingFunctions.castToString(linearr[40]));
			Assert.assertEquals(payloadPojo.getPaxCntryCode2Ch(), TestCastingFunctions.castToString(linearr[41]));
			Assert.assertEquals(payloadPojo.getPaxCntryCode3Ch(), TestCastingFunctions.castToString(linearr[42]));
			Assert.assertEquals(payloadPojo.getMsgCreateDateTime(), TestCastingFunctions.castToTimestamp(linearr[43],"yyyy-MM-dd HH:mm:ss"));
			Assert.assertEquals(payloadPojo.getOtherDocInfInd(), TestCastingFunctions.castToString(linearr[44]));
			Assert.assertEquals(payloadPojo.getOtherDocCode(), TestCastingFunctions.castToString(linearr[45]));
			Assert.assertEquals(payloadPojo.getOtherDocNbr(), TestCastingFunctions.castToString(linearr[46]));
			Assert.assertEquals(payloadPojo.getOtherDocPlaceOfIssue(), TestCastingFunctions.castToString(linearr[47]));
			Assert.assertEquals(payloadPojo.getOtherDocIssueDate(), TestCastingFunctions.castToString(linearr[48]));
			Assert.assertEquals(payloadPojo.getOtherDocPaxBirthPlace(), TestCastingFunctions.castToString(linearr[49]));
			Assert.assertEquals(payloadPojo.getOtherDocPaxAgentInputLoc(), TestCastingFunctions.castToString(linearr[50]));
			Assert.assertEquals(payloadPojo.getOtherDocPaxCntryCdTwoChar(), TestCastingFunctions.castToString(linearr[51]));
			Assert.assertEquals(payloadPojo.getOtherDocPaxCntryCdThrChar(), TestCastingFunctions.castToString(linearr[52]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in ACSPaxDOCX file. Exception message: " + e.getMessage(), e);
		}

}


	public void execute(TypedValue arg0, Object arg1) throws AssertionError {
		// TODO Auto-generated method stub
		
	}
}