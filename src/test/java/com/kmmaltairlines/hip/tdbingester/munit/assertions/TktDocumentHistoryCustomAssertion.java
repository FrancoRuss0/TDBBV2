package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;
import org.springframework.expression.TypedValue;

import com.kmmaltairlines.hip.tdbingester.filepojos.TktDocumentHistory;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class TktDocumentHistoryCustomAssertion {

	
	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		TktDocumentHistory payloadPojo = new TktDocumentHistory();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof TktDocumentHistory)
	        	payloadPojo = (TktDocumentHistory) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not TktDocumentHistory.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of TktDocumentHistory.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorID(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getPrimaryDocNbr(), TestCastingFunctions.castToString(linearr[3]));
			Assert.assertEquals(payloadPojo.getVCRCreateDate(), TestCastingFunctions.castToDate(linearr[4],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getTransactionDateTime(), TestCastingFunctions.castToTimestamp(linearr[5],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getHistorySeqNbr(), TestCastingFunctions.castToInteger(linearr[6]));
			Assert.assertEquals(payloadPojo.getHistoryCd(), TestCastingFunctions.castToString(linearr[7]));
			Assert.assertEquals(payloadPojo.getAAACityCode(), TestCastingFunctions.castToString(linearr[8]));
			Assert.assertEquals(payloadPojo.getHomeCityCode(), TestCastingFunctions.castToString(linearr[9]));
			Assert.assertEquals(payloadPojo.getAgentDutyCode(), TestCastingFunctions.castToString(linearr[10]));
			Assert.assertEquals(payloadPojo.getAgentSine(), TestCastingFunctions.castToString(linearr[11]));
			Assert.assertEquals(payloadPojo.getLastUpdate(), TestCastingFunctions.castToDate(linearr[12],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getLastUpdateSysTime() == null ? null : payloadPojo.getLastUpdateSysTime().toString(), TestCastingFunctions.castToTime(linearr[13],"HH:mm:ss.SSSSSS") == null ? null : TestCastingFunctions.castToTime(linearr[13],"HH:mm:ss.SSSSSS").toString());
			Assert.assertEquals(payloadPojo.getPreviousPNRLocatorId(), TestCastingFunctions.castToString(linearr[14]));
			Assert.assertEquals(payloadPojo.getCPNBitMap(), TestCastingFunctions.castToString(linearr[15]));
			Assert.assertEquals(payloadPojo.getNewPNRLocatorID(), TestCastingFunctions.castToString(linearr[16]));
			Assert.assertEquals(payloadPojo.getAirlineAccountingCode(), TestCastingFunctions.castToString(linearr[17]));
			Assert.assertEquals(payloadPojo.getDocNbr(), TestCastingFunctions.castToString(linearr[18]));
			Assert.assertEquals(payloadPojo.getUpdateCRSCode(), TestCastingFunctions.castToString(linearr[19]));
			Assert.assertEquals(payloadPojo.getUpdateAirlineCode(), TestCastingFunctions.castToString(linearr[20]));
			Assert.assertEquals(payloadPojo.getPurgeDueToAging(), TestCastingFunctions.castToByte(linearr[21]));
			Assert.assertEquals(payloadPojo.getPurgeRequestByTCN(), TestCastingFunctions.castToByte(linearr[22]));
			Assert.assertEquals(payloadPojo.getDay7Purge(), TestCastingFunctions.castToByte(linearr[23]));
			Assert.assertEquals(payloadPojo.getInputMsg(), TestCastingFunctions.castToString(linearr[24]));
			Assert.assertEquals(payloadPojo.getRemarkTxt(), TestCastingFunctions.castToString(linearr[25]));
			Assert.assertEquals(payloadPojo.getOACDefaultPartitionCode(), TestCastingFunctions.castToString(linearr[26]));
			Assert.assertEquals(payloadPojo.getOACCityCode(), TestCastingFunctions.castToString(linearr[27]));
			Assert.assertEquals(payloadPojo.getOACAcctCode(), TestCastingFunctions.castToString(linearr[28]));
			Assert.assertEquals(payloadPojo.getOACStationNbr(), TestCastingFunctions.castToString(linearr[29]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in TktDocumentHistory file. Exception message: " + e.getMessage(), e);
		}

}

	public void execute(TypedValue arg0, Object arg1) throws AssertionError {
		// TODO Auto-generated method stub
		
	}
}