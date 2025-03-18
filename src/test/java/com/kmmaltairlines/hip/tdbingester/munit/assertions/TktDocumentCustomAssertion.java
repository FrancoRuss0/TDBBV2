package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;
import org.springframework.expression.TypedValue;

import com.kmmaltairlines.hip.tdbingester.filepojos.TktDocument;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class TktDocumentCustomAssertion {

	
	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		TktDocument payloadPojo = new TktDocument();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof TktDocument)
	        	payloadPojo = (TktDocument) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not TktDocument.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of TktDocument.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorID(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getPrimaryDocNbr(), TestCastingFunctions.castToString(linearr[3]));
			Assert.assertEquals(payloadPojo.getVCRCreateDate(), TestCastingFunctions.castToDate(linearr[4],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getTransactionDateTime(), TestCastingFunctions.castToTimestamp(linearr[5],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getAirlineAccountingCode(), TestCastingFunctions.castToString(linearr[6]));
			Assert.assertEquals(payloadPojo.getEndDocNbr(), TestCastingFunctions.castToString(linearr[7]));
			Assert.assertEquals(payloadPojo.getVendorName(), TestCastingFunctions.castToString(linearr[8]));
			Assert.assertEquals(payloadPojo.getPointOfTktIssuance(), TestCastingFunctions.castToString(linearr[9]));
			Assert.assertEquals(payloadPojo.getValidatingVendorCode(), TestCastingFunctions.castToString(linearr[10]));
			Assert.assertEquals(payloadPojo.getValidatingVendorNbr(), TestCastingFunctions.castToString(linearr[11]));
			Assert.assertEquals(payloadPojo.getPNRPurgeDate(), TestCastingFunctions.castToDate(linearr[12],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getCRSPNRLocator(), TestCastingFunctions.castToString(linearr[13]));
			Assert.assertEquals(payloadPojo.getDocIssueDate(), TestCastingFunctions.castToDate(linearr[14],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getCustomerFullName(), TestCastingFunctions.castToString(linearr[15]));
			Assert.assertEquals(payloadPojo.getAgentCountryCode(), TestCastingFunctions.castToString(linearr[16]));
			Assert.assertEquals(payloadPojo.getIntlDocSaleCode(), TestCastingFunctions.castToString(linearr[17]));
			Assert.assertEquals(payloadPojo.getTourCode(), TestCastingFunctions.castToString(linearr[18]));
			Assert.assertEquals(payloadPojo.getAgentSine(), TestCastingFunctions.castToString(linearr[19]));
			Assert.assertEquals(payloadPojo.getOwningCityCode(), TestCastingFunctions.castToString(linearr[20]));
			Assert.assertEquals(payloadPojo.getAAACityCode(), TestCastingFunctions.castToString(linearr[21]));
			Assert.assertEquals(payloadPojo.getDocIssueAAAIATANbr(), TestCastingFunctions.castToString(linearr[22]));
			Assert.assertEquals(payloadPojo.getHomeCityCode(), TestCastingFunctions.castToString(linearr[23]));
			Assert.assertEquals(payloadPojo.getRestrictions(), TestCastingFunctions.castToString(linearr[24]));
			Assert.assertEquals(payloadPojo.getCurrConverRate(), TestCastingFunctions.castToString(linearr[25]));
			Assert.assertEquals(payloadPojo.getBankSellRate(), TestCastingFunctions.castToShort(linearr[26]));
			Assert.assertEquals(payloadPojo.getBankBuyRate(), TestCastingFunctions.castToShort(linearr[27]));
			Assert.assertEquals(payloadPojo.getIntlClearHouseRate(), TestCastingFunctions.castToShort(linearr[28]));
			Assert.assertEquals(payloadPojo.getExchgTktAmt(), TestCastingFunctions.castToBigDecimal(linearr[29]));
			Assert.assertEquals(payloadPojo.getSettlementAuthCode(), TestCastingFunctions.castToString(linearr[30]));
			Assert.assertEquals(payloadPojo.getBaseFareCurrCode(), TestCastingFunctions.castToString(linearr[31]));
			Assert.assertEquals(payloadPojo.getBaseFareAmt(), TestCastingFunctions.castToBigDecimal(linearr[32]));
			Assert.assertEquals(payloadPojo.getTotalFareCurrCode(), TestCastingFunctions.castToString(linearr[33]));
			Assert.assertEquals(payloadPojo.getTotalDocAmt(), TestCastingFunctions.castToBigDecimal(linearr[34]));
			Assert.assertEquals(payloadPojo.getEquivBaseFareCurrCode(), TestCastingFunctions.castToString(linearr[35]));
			Assert.assertEquals(payloadPojo.getEquivBaseFareAmt(), TestCastingFunctions.castToBigDecimal(linearr[36]));
			Assert.assertEquals(payloadPojo.getDataInd(), TestCastingFunctions.castToString(linearr[37]));
			Assert.assertEquals(payloadPojo.getFareCalc(), TestCastingFunctions.castToString(linearr[38]));
			Assert.assertEquals(payloadPojo.getFareCalcType(), TestCastingFunctions.castToByte(linearr[39]));
			Assert.assertEquals(payloadPojo.getOriginalIssueDate(), TestCastingFunctions.castToDate(linearr[40],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getOriginalIssueCity(), TestCastingFunctions.castToString(linearr[41]));
			Assert.assertEquals(payloadPojo.getOriginalIATANbr(), TestCastingFunctions.castToString(linearr[42]));
			Assert.assertEquals(payloadPojo.getOriginalFOP(), TestCastingFunctions.castToString(linearr[43]));
			Assert.assertEquals(payloadPojo.getOriginalTktNbr(), TestCastingFunctions.castToString(linearr[44]));
			Assert.assertEquals(payloadPojo.getExchgFOP(), TestCastingFunctions.castToString(linearr[45]));
			Assert.assertEquals(payloadPojo.getAddlExchgTktData(), TestCastingFunctions.castToString(linearr[46]));
			Assert.assertEquals(payloadPojo.getExchgCoupon(), TestCastingFunctions.castToString(linearr[47]));
			Assert.assertEquals(payloadPojo.getAutoPriceCode(), TestCastingFunctions.castToString(linearr[48]));
			Assert.assertEquals(payloadPojo.getDocTypeCode(), TestCastingFunctions.castToString(linearr[49]));
			Assert.assertEquals(payloadPojo.getDocStatusCode(), TestCastingFunctions.castToString(linearr[50]));
			Assert.assertEquals(payloadPojo.getPassengerType(), TestCastingFunctions.castToString(linearr[51]));
			Assert.assertEquals(payloadPojo.getSourceSystemId(), TestCastingFunctions.castToString(linearr[52]));
			Assert.assertEquals(payloadPojo.getOACStationNbr(), TestCastingFunctions.castToString(linearr[53]));
			Assert.assertEquals(payloadPojo.getRefundableInd(), TestCastingFunctions.castToString(linearr[54]));
			Assert.assertEquals(payloadPojo.getCommissionableInd(), TestCastingFunctions.castToString(linearr[55]));
			Assert.assertEquals(payloadPojo.getInterlineInd(), TestCastingFunctions.castToString(linearr[56]));
			Assert.assertEquals(payloadPojo.getEMDRFICode(), TestCastingFunctions.castToString(linearr[57]));
			Assert.assertEquals(payloadPojo.getEMDType(), TestCastingFunctions.castToString(linearr[58]));
			Assert.assertEquals(payloadPojo.getTaxExInd(), TestCastingFunctions.castToString(linearr[59]));
			Assert.assertEquals(payloadPojo.getConsumedAtIssueInd(), TestCastingFunctions.castToString(linearr[60]));
			Assert.assertEquals(payloadPojo.getElectronicDocumentInd(), TestCastingFunctions.castToString(linearr[61]));
			Assert.assertEquals(payloadPojo.getManualDocumentInd(), TestCastingFunctions.castToString(linearr[62]));
			Assert.assertEquals(payloadPojo.getVoucherRefundInd(), TestCastingFunctions.castToString(linearr[63]));
			Assert.assertEquals(payloadPojo.getRFICode(), TestCastingFunctions.castToString(linearr[64]));
			Assert.assertEquals(payloadPojo.getRFITxt(), TestCastingFunctions.castToString(linearr[65]));
			Assert.assertEquals(payloadPojo.getPTASvcChargeCurrCode(), TestCastingFunctions.castToString(linearr[66]));
			Assert.assertEquals(payloadPojo.getPTASvcChargeAmt(), TestCastingFunctions.castToBigDecimal(linearr[67]));
			Assert.assertEquals(payloadPojo.getPTAAddFundsDesc(), TestCastingFunctions.castToString(linearr[68]));
			Assert.assertEquals(payloadPojo.getPTAAddFundsCurrCode(), TestCastingFunctions.castToString(linearr[69]));
			Assert.assertEquals(payloadPojo.getPTAAddFundsAmt(), TestCastingFunctions.castToBigDecimal(linearr[70]));
			Assert.assertEquals(payloadPojo.getExchgChangeFeeCurrCode(), TestCastingFunctions.castToString(linearr[71]));
			Assert.assertEquals(payloadPojo.getExchgChangeFeeAmt(), TestCastingFunctions.castToBigDecimal(linearr[72]));
			Assert.assertEquals(payloadPojo.getOtherFeeCurrCode(), TestCastingFunctions.castToString(linearr[73]));
			Assert.assertEquals(payloadPojo.getOtherFeeAmt(), TestCastingFunctions.castToBigDecimal(linearr[74]));
			Assert.assertEquals(payloadPojo.getAddCollectCurrCode(), TestCastingFunctions.castToString(linearr[75]));
			Assert.assertEquals(payloadPojo.getAddCollectAmt(), TestCastingFunctions.castToBigDecimal(linearr[76]));
			Assert.assertEquals(payloadPojo.getOACDefaultPartitionCode(), TestCastingFunctions.castToString(linearr[77]));
			Assert.assertEquals(payloadPojo.getOACCityCode(), TestCastingFunctions.castToString(linearr[78]));
			Assert.assertEquals(payloadPojo.getOACAcctCode(), TestCastingFunctions.castToString(linearr[79]));
			Assert.assertEquals(payloadPojo.getNonRefFeeCurrCode(), TestCastingFunctions.castToString(linearr[80]));
			Assert.assertEquals(payloadPojo.getNonRefFeeAmt(), TestCastingFunctions.castToBigDecimal(linearr[81]));
			Assert.assertEquals(payloadPojo.getOBFeeDescText(), TestCastingFunctions.castToString(linearr[82]));
			Assert.assertEquals(payloadPojo.getOBFeePricingCode(), TestCastingFunctions.castToString(linearr[83]));
			Assert.assertEquals(payloadPojo.getOBFeeWaiverCode(), TestCastingFunctions.castToString(linearr[84]));
			Assert.assertEquals(payloadPojo.getOBFeeTotalCurrCode(), TestCastingFunctions.castToString(linearr[85]));
			Assert.assertEquals(payloadPojo.getOBFeeTotal(), TestCastingFunctions.castToBigDecimal(linearr[86]));
			Assert.assertEquals(payloadPojo.getOBFeeTotalUSD(), TestCastingFunctions.castToBigDecimal(linearr[87]));
			Assert.assertEquals(payloadPojo.getPricedPassengerType(), TestCastingFunctions.castToString(linearr[88]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in TktDocument file. Exception message: " + e.getMessage(), e);
		}

}

	public void execute(TypedValue arg0, Object arg1) throws AssertionError {
		// TODO Auto-generated method stub
		
	}
}