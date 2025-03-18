package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;

import com.kmmaltairlines.hip.tdbingester.filepojos.ResAirExtra;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class ResAirExtraCustomAssertion {

	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		ResAirExtra payloadPojo = new ResAirExtra();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof ResAirExtra)
	        	payloadPojo = (ResAirExtra) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not ResAirExtra.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of ResAirExtra.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorID(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[2],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getFromDateTime(), TestCastingFunctions.castToTimestamp(linearr[3],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getRFICode(), TestCastingFunctions.castToString(linearr[4]));
			Assert.assertEquals(payloadPojo.getCommercialName(), TestCastingFunctions.castToString(linearr[5]));
			Assert.assertEquals(payloadPojo.getSSIMCode(), TestCastingFunctions.castToString(linearr[6]));
			Assert.assertEquals(payloadPojo.getSSRCode(), TestCastingFunctions.castToString(linearr[7]));
			Assert.assertEquals(payloadPojo.getBoardPointAirportCode(), TestCastingFunctions.castToString(linearr[8]));
			Assert.assertEquals(payloadPojo.getOffPointAirportCode(), TestCastingFunctions.castToString(linearr[9]));
			Assert.assertEquals(payloadPojo.getOwningCarrierCode(), TestCastingFunctions.castToString(linearr[10]));
			Assert.assertEquals(payloadPojo.getFeeVendorCode(), TestCastingFunctions.castToString(linearr[11]));
			Assert.assertEquals(payloadPojo.getBookingMethodCode(), TestCastingFunctions.castToString(linearr[12]));
			Assert.assertEquals(payloadPojo.getFulfillTypeCode(), TestCastingFunctions.castToString(linearr[13]));
			Assert.assertEquals(payloadPojo.getEMDTypeCode(), TestCastingFunctions.castToShort(linearr[14]));
			Assert.assertEquals(payloadPojo.getRefundReissueCode(), TestCastingFunctions.castToString(linearr[15]));
			Assert.assertEquals(payloadPojo.getFormOfRefundCode(), TestCastingFunctions.castToString(linearr[16]));
			Assert.assertEquals(payloadPojo.getFrequentTravelerTierLevel(), TestCastingFunctions.castToString(linearr[17]));
			Assert.assertEquals(payloadPojo.getBrandedFareId(), TestCastingFunctions.castToString(linearr[18]));
			Assert.assertEquals(payloadPojo.getTourCode(), TestCastingFunctions.castToString(linearr[19]));
			Assert.assertEquals(payloadPojo.getServiceChargeCode(), TestCastingFunctions.castToString(linearr[20]));
			Assert.assertEquals(payloadPojo.getFeeApplicationCode(), TestCastingFunctions.castToString(linearr[21]));
			Assert.assertEquals(payloadPojo.getFirstTravelDate(), TestCastingFunctions.castToDate(linearr[22],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getLastTravelDate(), TestCastingFunctions.castToDate(linearr[23],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getHistoryActionCode(), TestCastingFunctions.castToString(linearr[24]));
			Assert.assertEquals(payloadPojo.getTTYConfirmationDateTime(), TestCastingFunctions.castToTimestamp(linearr[25],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getPurchaseByDateTime(), TestCastingFunctions.castToTimestamp(linearr[26],"yyyy-MM-dd HH:mm:ss.SSSSSS"));
			Assert.assertEquals(payloadPojo.getBookingSourceCode(), TestCastingFunctions.castToString(linearr[27]));
			Assert.assertEquals(payloadPojo.getEMDNbr(), TestCastingFunctions.castToString(linearr[28]));
			Assert.assertEquals(payloadPojo.getEMDCouponNbr(), TestCastingFunctions.castToShort(linearr[29]));
			Assert.assertEquals(payloadPojo.getETicketNbr(), TestCastingFunctions.castToString(linearr[30]));
			Assert.assertEquals(payloadPojo.getETicketCouponNbr(), TestCastingFunctions.castToShort(linearr[31]));
			Assert.assertEquals(payloadPojo.getSSRDirectFulfillCode(), TestCastingFunctions.castToString(linearr[32]));
			Assert.assertEquals(payloadPojo.getNonEMDFormofPayment(), TestCastingFunctions.castToString(linearr[33]));
			Assert.assertEquals(payloadPojo.getFeeWaivedCode(), TestCastingFunctions.castToString(linearr[34]));
			Assert.assertEquals(payloadPojo.getAEBasePriceAmount(), TestCastingFunctions.castToBigDecimal(linearr[35]));
			Assert.assertEquals(payloadPojo.getAEBaseCurrencyCode(), TestCastingFunctions.castToString(linearr[36]));
			Assert.assertEquals(payloadPojo.getAEEquivalentPaidAmount(), TestCastingFunctions.castToBigDecimal(linearr[37]));
			Assert.assertEquals(payloadPojo.getAEEquivalentAmtCurrencyCd(), TestCastingFunctions.castToString(linearr[38]));
			Assert.assertEquals(payloadPojo.getItemCount(), TestCastingFunctions.castToShort(linearr[39]));
			Assert.assertEquals(payloadPojo.getAETotalPriceAmount(), TestCastingFunctions.castToBigDecimal(linearr[40]));
			Assert.assertEquals(payloadPojo.getPassengerTypeCode(), TestCastingFunctions.castToString(linearr[41]));
			Assert.assertEquals(payloadPojo.getTaxIncludedCode(), TestCastingFunctions.castToString(linearr[42]));
			Assert.assertEquals(payloadPojo.getSegmentUseCode(), TestCastingFunctions.castToString(linearr[43]));
			Assert.assertEquals(payloadPojo.getSegmentBookedDate(), TestCastingFunctions.castToDate(linearr[44],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getSegmentBookedTime() == null ? null : payloadPojo.getSegmentBookedTime().toString(), TestCastingFunctions.castToTime(linearr[45],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[45],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getNonEMDFOPCCCode(), TestCastingFunctions.castToString(linearr[46]));
			Assert.assertEquals(payloadPojo.getNonEMDFOPMaskedCCNbr(), TestCastingFunctions.castToString(linearr[47]));
			Assert.assertEquals(payloadPojo.getNonEMDFOPCCExpryDt(), TestCastingFunctions.castToString(linearr[48]));
			Assert.assertEquals(payloadPojo.getGroupCode(), TestCastingFunctions.castToString(linearr[49]));
			Assert.assertEquals(payloadPojo.getSimultaneousTicketPurchaseInd(), TestCastingFunctions.castToString(linearr[50]));
			Assert.assertEquals(payloadPojo.getCommissionInd(), TestCastingFunctions.castToString(linearr[51]));
			Assert.assertEquals(payloadPojo.getInterlineInd(), TestCastingFunctions.castToString(linearr[52]));
			Assert.assertEquals(payloadPojo.getFeeGuaranteedInd(), TestCastingFunctions.castToString(linearr[53]));
			Assert.assertEquals(payloadPojo.getEMDPaperInd(), TestCastingFunctions.castToString(linearr[54]));
			Assert.assertEquals(payloadPojo.getRFISubCode(), TestCastingFunctions.castToString(linearr[55]));
			Assert.assertEquals(payloadPojo.getRecordUpdateDate(), TestCastingFunctions.castToDate(linearr[56],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getRecordUpdateTime() == null ? null : payloadPojo.getRecordUpdateTime().toString(), TestCastingFunctions.castToTime(linearr[57],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[57],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getIntraPNRSetNbr(), TestCastingFunctions.castToShort(linearr[58]));
			Assert.assertEquals(payloadPojo.getPNRPassengerSeqId(), TestCastingFunctions.castToShort(linearr[59]));
			Assert.assertEquals(payloadPojo.getAEFLight(), TestCastingFunctions.castToString(linearr[60]));
			Assert.assertEquals(payloadPojo.getAECurrentSegmentStatusCode(), TestCastingFunctions.castToString(linearr[61]));
			Assert.assertEquals(payloadPojo.getAEPreviousSegmentStatus(), TestCastingFunctions.castToString(linearr[62]));
			Assert.assertEquals(payloadPojo.getACSCount(), TestCastingFunctions.castToShort(linearr[63]));
			Assert.assertEquals(payloadPojo.getAssociatedSegmentCount(), TestCastingFunctions.castToShort(linearr[64]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in ResAirExtra file. Exception message: " + e.getMessage(), e);
		}

}

}