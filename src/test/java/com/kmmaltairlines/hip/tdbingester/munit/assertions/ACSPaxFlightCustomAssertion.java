package com.kmmaltairlines.hip.tdbingester.munit.assertions;

import java.util.ArrayList;
import org.junit.Assert;
import org.springframework.expression.TypedValue;

import com.kmmaltairlines.hip.tdbingester.filepojos.ACSPaxFlight;
import com.kmmaltairlines.hip.tdbingester.utils.TestCastingFunctions;


public class ACSPaxFlightCustomAssertion {

	public void execute(ArrayList<?> payload, String line) throws AssertionError {

		ACSPaxFlight payloadPojo = new ACSPaxFlight();
		if (payload instanceof ArrayList<?>) {
	        if(((ArrayList<?>)payload).get(0) instanceof ACSPaxFlight)
	        	payloadPojo = (ACSPaxFlight) ((ArrayList<?>) payload).get(0);
	        else
				throw new AssertionError("Element in payload Arraylist is not ACSPaxFlight.", new Exception());
		}
		else
			throw new AssertionError("Payload is not of type ArrayList of ACSPaxFlight.", new Exception());
		

		String[] linearr = line.split("\\|",-1);

		try {
			Assert.assertEquals(payloadPojo.getSourceSystemID(), TestCastingFunctions.castToString(linearr[0]));
			Assert.assertEquals(payloadPojo.getPNRLocatorId(), TestCastingFunctions.castToString(linearr[1]));
			Assert.assertEquals(payloadPojo.getMCPPNRLocatorId(), TestCastingFunctions.castToString(linearr[2]));
			Assert.assertEquals(payloadPojo.getPNRCreateDate(), TestCastingFunctions.castToDate(linearr[3],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getMCPPNRCreateDate(), TestCastingFunctions.castToDate(linearr[4],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getResPaxId(), TestCastingFunctions.castToShort(linearr[5]));
			Assert.assertEquals(payloadPojo.getAirlineCode(), TestCastingFunctions.castToString(linearr[6]));
			Assert.assertEquals(payloadPojo.getFltNbr(), TestCastingFunctions.castToString(linearr[7]));
			Assert.assertEquals(payloadPojo.getServiceStartDate(), TestCastingFunctions.castToDate(linearr[8],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getAirlineOrigAirport(), TestCastingFunctions.castToString(linearr[9]));
			Assert.assertEquals(payloadPojo.getResPaxNameID(), TestCastingFunctions.castToString(linearr[10]));
			Assert.assertEquals(payloadPojo.getNameFirst(), TestCastingFunctions.castToString(linearr[11]));
			Assert.assertEquals(payloadPojo.getNameLast(), TestCastingFunctions.castToString(linearr[12]));
			Assert.assertEquals(payloadPojo.getPaxPNROrigin(), TestCastingFunctions.castToString(linearr[13]));
			Assert.assertEquals(payloadPojo.getPaxPNRDest(), TestCastingFunctions.castToString(linearr[14]));
			Assert.assertEquals(payloadPojo.getUPID(), TestCastingFunctions.castToString(linearr[15]));
			Assert.assertEquals(payloadPojo.getPaxTypeCd(), TestCastingFunctions.castToString(linearr[16]));
			Assert.assertEquals(payloadPojo.getRevenuePassengerInd(), TestCastingFunctions.castToString(linearr[17]));
			Assert.assertEquals(payloadPojo.getNonRevenuePassengerind(), TestCastingFunctions.castToString(linearr[18]));
			Assert.assertEquals(payloadPojo.getDeadheadInd(), TestCastingFunctions.castToString(linearr[19]));
			Assert.assertEquals(payloadPojo.getSelecteeInd(), TestCastingFunctions.castToString(linearr[20]));
			Assert.assertEquals(payloadPojo.getOnBrdInd(), TestCastingFunctions.castToString(linearr[21]));
			Assert.assertEquals(payloadPojo.getBoardingPassInd(), TestCastingFunctions.castToString(linearr[22]));
			Assert.assertEquals(payloadPojo.getPriorityListInd(), TestCastingFunctions.castToString(linearr[23]));
			Assert.assertEquals(payloadPojo.getCheckInSeqNbr(), TestCastingFunctions.castToShort(linearr[24]));
			Assert.assertEquals(payloadPojo.getFlownClassofService(), TestCastingFunctions.castToString(linearr[25]));
			Assert.assertEquals(payloadPojo.getClassofService(), TestCastingFunctions.castToString(linearr[26]));
			Assert.assertEquals(payloadPojo.getBookedInventory(), TestCastingFunctions.castToString(linearr[27]));
			Assert.assertEquals(payloadPojo.getInventoryUpgradeInd(), TestCastingFunctions.castToString(linearr[28]));
			Assert.assertEquals(payloadPojo.getMarketingAirlineCd(), TestCastingFunctions.castToString(linearr[29]));
			Assert.assertEquals(payloadPojo.getMarketingFltNbr(), TestCastingFunctions.castToString(linearr[30]));
			Assert.assertEquals(payloadPojo.getCodeShareAirlineCd(), TestCastingFunctions.castToString(linearr[31]));
			Assert.assertEquals(payloadPojo.getCodeShareAirlineFltNbr(), TestCastingFunctions.castToString(linearr[32]));
			Assert.assertEquals(payloadPojo.getPaxThruInd(), TestCastingFunctions.castToString(linearr[33]));
			Assert.assertEquals(payloadPojo.getPaxInboundConxInd(), TestCastingFunctions.castToString(linearr[34]));
			Assert.assertEquals(payloadPojo.getPaxOutboundConxInd(), TestCastingFunctions.castToString(linearr[35]));
			Assert.assertEquals(payloadPojo.getPaxCodeShareInd(), TestCastingFunctions.castToString(linearr[36]));
			Assert.assertEquals(payloadPojo.getOneWorldConxInd(), TestCastingFunctions.castToString(linearr[37]));
			Assert.assertEquals(payloadPojo.getOneWorldInConxInd(), TestCastingFunctions.castToString(linearr[38]));
			Assert.assertEquals(payloadPojo.getOneWorldOutConxInd(), TestCastingFunctions.castToString(linearr[39]));
			Assert.assertEquals(payloadPojo.getGenderInd(), TestCastingFunctions.castToString(linearr[40]));
			Assert.assertEquals(payloadPojo.getCHGFLInd(), TestCastingFunctions.castToString(linearr[41]));
			Assert.assertEquals(payloadPojo.getCHGSGInd(), TestCastingFunctions.castToString(linearr[42]));
			Assert.assertEquals(payloadPojo.getGOSHOInd(), TestCastingFunctions.castToString(linearr[43]));
			Assert.assertEquals(payloadPojo.getIDPADInd(), TestCastingFunctions.castToString(linearr[44]));
			Assert.assertEquals(payloadPojo.getNORECInd(), TestCastingFunctions.castToString(linearr[45]));
			Assert.assertEquals(payloadPojo.getNOSHOInd(), TestCastingFunctions.castToString(linearr[46]));
			Assert.assertEquals(payloadPojo.getOFFLKInd(), TestCastingFunctions.castToString(linearr[47]));
			Assert.assertEquals(payloadPojo.getOFFLNInd(), TestCastingFunctions.castToString(linearr[48]));
			Assert.assertEquals(payloadPojo.getGOSHNInd(), TestCastingFunctions.castToString(linearr[49]));
			Assert.assertEquals(payloadPojo.getCHGCLInd(), TestCastingFunctions.castToString(linearr[50]));
			Assert.assertEquals(payloadPojo.getINVOLInd(), TestCastingFunctions.castToString(linearr[51]));
			Assert.assertEquals(payloadPojo.getAPIPXInd(), TestCastingFunctions.castToString(linearr[52]));
			Assert.assertEquals(payloadPojo.getCFMWLInd(), TestCastingFunctions.castToString(linearr[53]));
			Assert.assertEquals(payloadPojo.getFQTVNInd(), TestCastingFunctions.castToString(linearr[54]));
			Assert.assertEquals(payloadPojo.getCheckInGrpCode(), TestCastingFunctions.castToString(linearr[55]));
			Assert.assertEquals(payloadPojo.getCheckinGrpCnt(), TestCastingFunctions.castToShort(linearr[56]));
			Assert.assertEquals(payloadPojo.getResGrpCode(), TestCastingFunctions.castToString(linearr[57]));
			Assert.assertEquals(payloadPojo.getResGrpCnt(), TestCastingFunctions.castToShort(linearr[58]));
			Assert.assertEquals(payloadPojo.getPaxContactText(), TestCastingFunctions.castToString(linearr[59]));
			Assert.assertEquals(payloadPojo.getETCIInInd(), TestCastingFunctions.castToString(linearr[60]));
			Assert.assertEquals(payloadPojo.getETCIOutInd(), TestCastingFunctions.castToString(linearr[61]));
			Assert.assertEquals(payloadPojo.getCheckInKioskInd(), TestCastingFunctions.castToString(linearr[62]));
			Assert.assertEquals(payloadPojo.getRemoteCheckInInd(), TestCastingFunctions.castToString(linearr[63]));
			Assert.assertEquals(payloadPojo.getCheckInMobileInd(), TestCastingFunctions.castToString(linearr[64]));
			Assert.assertEquals(payloadPojo.getCheckInTime() == null ? null : payloadPojo.getCheckInTime().toString(), TestCastingFunctions.castToTime(linearr[65],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[65],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getCheckInDate(), TestCastingFunctions.castToDate(linearr[66],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getChknRestrictedSOCInd(), TestCastingFunctions.castToString(linearr[67]));
			Assert.assertEquals(payloadPojo.getVendorCode(), TestCastingFunctions.castToString(linearr[68]));
			Assert.assertEquals(payloadPojo.getFrequentTravelerNbr(), TestCastingFunctions.castToString(linearr[69]));
			Assert.assertEquals(payloadPojo.getFQTVTier(), TestCastingFunctions.castToString(linearr[70]));
			Assert.assertEquals(payloadPojo.getPriorityListCd(), TestCastingFunctions.castToString(linearr[71]));
			Assert.assertEquals(payloadPojo.getDeniedBoardType(), TestCastingFunctions.castToString(linearr[72]));
			Assert.assertEquals(payloadPojo.getOverSaleLegID(), TestCastingFunctions.castToString(linearr[73]));
			Assert.assertEquals(payloadPojo.getOverSaleReasonNbr(), TestCastingFunctions.castToShort(linearr[74]));
			Assert.assertEquals(payloadPojo.getOversaleCompensation(), TestCastingFunctions.castToBigDecimal(linearr[75]));
			Assert.assertEquals(payloadPojo.getCompTypeCd(), TestCastingFunctions.castToString(linearr[76]));
			Assert.assertEquals(payloadPojo.getCompCurrCd(), TestCastingFunctions.castToString(linearr[77]));
			Assert.assertEquals(payloadPojo.getOversaleReaccomInd(), TestCastingFunctions.castToString(linearr[78]));
			Assert.assertEquals(payloadPojo.getUpgradeCd(), TestCastingFunctions.castToString(linearr[79]));
			Assert.assertEquals(payloadPojo.getPaxCommentsText(), TestCastingFunctions.castToString(linearr[80]));
			Assert.assertEquals(payloadPojo.getNbrOfBags(), TestCastingFunctions.castToShort(linearr[81]));
			Assert.assertEquals(payloadPojo.getTtlBagWeight(), TestCastingFunctions.castToShort(linearr[82]));
			Assert.assertEquals(payloadPojo.getExcessBagInd(), TestCastingFunctions.castToString(linearr[83]));
			Assert.assertEquals(payloadPojo.getNSTInd(), TestCastingFunctions.castToString(linearr[84]));
			Assert.assertEquals(payloadPojo.getOFLInd(), TestCastingFunctions.castToString(linearr[85]));
			Assert.assertEquals(payloadPojo.getSTCHInd(), TestCastingFunctions.castToString(linearr[86]));
			Assert.assertEquals(payloadPojo.getBCSInd(), TestCastingFunctions.castToString(linearr[87]));
			Assert.assertEquals(payloadPojo.getSSUPInd(), TestCastingFunctions.castToString(linearr[88]));
			Assert.assertEquals(payloadPojo.getSSPRInd(), TestCastingFunctions.castToString(linearr[89]));
			Assert.assertEquals(payloadPojo.getWVERInd(), TestCastingFunctions.castToString(linearr[90]));
			Assert.assertEquals(payloadPojo.getINCUInd(), TestCastingFunctions.castToString(linearr[91]));
			Assert.assertEquals(payloadPojo.getOXYGInd(), TestCastingFunctions.castToString(linearr[92]));
			Assert.assertEquals(payloadPojo.getNMELInd(), TestCastingFunctions.castToString(linearr[93]));
			Assert.assertEquals(payloadPojo.getGCIPInd(), TestCastingFunctions.castToString(linearr[94]));
			Assert.assertEquals(payloadPojo.getGVIPInd(), TestCastingFunctions.castToString(linearr[95]));
			Assert.assertEquals(payloadPojo.getMsgCreateDateTime(), TestCastingFunctions.castToTimestamp(linearr[96],"yyyy-MM-dd HH:mm:ss"));
			Assert.assertEquals(payloadPojo.getAPPInfantInd(), TestCastingFunctions.castToString(linearr[97]));
			Assert.assertEquals(payloadPojo.getAPPAuthCountry(), TestCastingFunctions.castToString(linearr[98]));
			Assert.assertEquals(payloadPojo.getAPPStatus(), TestCastingFunctions.castToString(linearr[99]));
			Assert.assertEquals(payloadPojo.getSSRCode(), TestCastingFunctions.castToString(linearr[100]));
			Assert.assertEquals(payloadPojo.getSSRText(), TestCastingFunctions.castToString(linearr[101]));
			Assert.assertEquals(payloadPojo.getPaxInboundCarrier(), TestCastingFunctions.castToString(linearr[102]));
			Assert.assertEquals(payloadPojo.getPaxInboundFlightNbr(), TestCastingFunctions.castToString(linearr[103]));
			Assert.assertEquals(payloadPojo.getPaxInbSvcStDt(), TestCastingFunctions.castToDate(linearr[104],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getPaxInbSvcStTm() == null ? null : payloadPojo.getPaxInbSvcStTm().toString(), TestCastingFunctions.castToTime(linearr[105],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[105],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getPaxInbOrigin(), TestCastingFunctions.castToString(linearr[106]));
			Assert.assertEquals(payloadPojo.getPaxInbDest(), TestCastingFunctions.castToString(linearr[107]));
			Assert.assertEquals(payloadPojo.getPaxInbBookedClass(), TestCastingFunctions.castToString(linearr[108]));
			Assert.assertEquals(payloadPojo.getPaxOutboundCarrier(), TestCastingFunctions.castToString(linearr[109]));
			Assert.assertEquals(payloadPojo.getPaxOutboundFlightNbr(), TestCastingFunctions.castToString(linearr[110]));
			Assert.assertEquals(payloadPojo.getPaxOutbSvcStDt(), TestCastingFunctions.castToDate(linearr[111],"yyyy-MM-dd"));
			Assert.assertEquals(payloadPojo.getPaxOutbSvcStTm() == null ? null : payloadPojo.getPaxOutbSvcStTm().toString(), TestCastingFunctions.castToTime(linearr[112],"HH:mm:ss") == null ? null : TestCastingFunctions.castToTime(linearr[112],"HH:mm:ss").toString());
			Assert.assertEquals(payloadPojo.getPaxOutbOrigin(), TestCastingFunctions.castToString(linearr[113]));
			Assert.assertEquals(payloadPojo.getPaxOutbDest(), TestCastingFunctions.castToString(linearr[114]));
			Assert.assertEquals(payloadPojo.getPaxOutbBookedClass(), TestCastingFunctions.castToString(linearr[115]));
		} catch (Exception e) {
			throw new AssertionError("Casting Error in ACSPaxFlight file. Exception message: " + e.getMessage(), e);
		}

}

	public void execute(TypedValue arg0, Object arg1) throws AssertionError {
		// TODO Auto-generated method stub
		
	}
}