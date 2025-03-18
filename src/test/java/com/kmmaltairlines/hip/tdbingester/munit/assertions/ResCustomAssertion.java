package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;

import org.junit.Assert;

import com.kmmaltairlines.hip.tdbingester.filepojos.Res;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class ResCustomAssertion {

	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		
		Res payloadPojo = new Res();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof Res)
	        	payloadPojo = (Res) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not Res.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of Res.", new Exception());
		

		
		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorID(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getFromDateTime(), TestCastingFunctions.castToTimestamp(linearr[3],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getCreateAAACityCode(), TestCastingFunctions.castToString(linearr[4]));
			Assert.assertEquals(payloadPojo.getCreationCountryCode(), TestCastingFunctions.castToString(linearr[5]));
			Assert.assertEquals(payloadPojo.getGrpBookingInd(), TestCastingFunctions.castToString(linearr[6]));
			Assert.assertEquals(payloadPojo.getCorporateInd(), TestCastingFunctions.castToString(linearr[7]));
			Assert.assertEquals(payloadPojo.getNbrinParty(), TestCastingFunctions.castToShort(linearr[8]));
			Assert.assertEquals(payloadPojo.getTTYAirlineCode(), TestCastingFunctions.castToString(linearr[9]));
			Assert.assertEquals(payloadPojo.getTTYRecordLocator(), TestCastingFunctions.castToString(linearr[10]));
			Assert.assertEquals(payloadPojo.getTTYPosInformation(), TestCastingFunctions.castToString(linearr[11]));
			Assert.assertEquals(payloadPojo.getSeatCount(), TestCastingFunctions.castToShort(linearr[12]));
			Assert.assertEquals(payloadPojo.getSourceSystemId(), TestCastingFunctions.castToString(linearr[13]));
			Assert.assertEquals(payloadPojo.getPNRCreateTime() == null ? null : payloadPojo.getPNRCreateTime().toString(), TestCastingFunctions.castToTime(linearr[14],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[14],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getCreateAgentSine(), TestCastingFunctions.castToString(linearr[15]));
			Assert.assertEquals(payloadPojo.getNumberOfInfants(), TestCastingFunctions.castToShort(linearr[16]));
			Assert.assertEquals(payloadPojo.getClaimIndicator(), TestCastingFunctions.castToString(linearr[17]));
			Assert.assertEquals(payloadPojo.getCreateIATANr(), TestCastingFunctions.castToString(linearr[18]));
			Assert.assertEquals(payloadPojo.getPurgeDate(), TestCastingFunctions.castToDate(linearr[19],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getMaxIntraPNRSetNbr(), TestCastingFunctions.castToShort(linearr[20]));
			Assert.assertEquals(payloadPojo.getDivideOrigPNRLocatorID(), TestCastingFunctions.castToString(linearr[21]));
			Assert.assertEquals(payloadPojo.getOrigPNRCreateDate(), TestCastingFunctions.castToDate(linearr[22],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getOrigPNRCreateTime() == null ? null : payloadPojo.getOrigPNRCreateTime().toString(), TestCastingFunctions.castToTime(linearr[23],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[23],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getDivideImagePNRInd(), TestCastingFunctions.castToString(linearr[24]));
			Assert.assertEquals(payloadPojo.getCreateAAAOACCityCode(), TestCastingFunctions.castToString(linearr[25]));
			Assert.assertEquals(payloadPojo.getCreateAAAOACAcctCode(), TestCastingFunctions.castToString(linearr[26]));
			Assert.assertEquals(payloadPojo.getOACDefaultPartitionCode(), TestCastingFunctions.castToString(linearr[27]));
			Assert.assertEquals(payloadPojo.getOACCityCode(), TestCastingFunctions.castToString(linearr[28]));
			Assert.assertEquals(payloadPojo.getOACAcctCode(), TestCastingFunctions.castToString(linearr[29]));
			Assert.assertEquals(payloadPojo.getOACStationNbr(), TestCastingFunctions.castToString(linearr[30]));
			Assert.assertEquals(payloadPojo.getCreateHomeCityCode(), TestCastingFunctions.castToString(linearr[31]));
			Assert.assertEquals(payloadPojo.getCodeSharePNRInd(), TestCastingFunctions.castToString(linearr[32]));
			Assert.assertEquals(payloadPojo.getMCPCarrierInd(), TestCastingFunctions.castToString(linearr[33]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in Res file. Exception message: " + e.getMessage(), e);
		}

		
}

}