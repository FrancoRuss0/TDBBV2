package com.airmalta.hip.tdbingester.filepojos;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;


public class ACSPaxFlight {

	private String SourceSystemID;
	private String PNRLocatorId;
	private String MCPPNRLocatorId;
	private Date PNRCreateDate;
	private Date MCPPNRCreateDate;
	private Short ResPaxId;
	private String AirlineCode;
	private String FltNbr;
	private Date ServiceStartDate;
	private String AirlineOrigAirport;
	private String ResPaxNameID;
	private String NameFirst;
	private String NameLast;
	private String PaxPNROrigin;
	private String PaxPNRDest;
	private String UPID;
	private String PaxTypeCd;
	private String RevenuePassengerInd;
	private String NonRevenuePassengerind;
	private String DeadheadInd;
	private String SelecteeInd;
	private String OnBrdInd;
	private String BoardingPassInd;
	private String PriorityListInd;
	private Short CheckInSeqNbr;
	private String FlownClassofService;
	private String ClassofService;
	private String BookedInventory;
	private String InventoryUpgradeInd;
	private String MarketingAirlineCd;
	private String MarketingFltNbr;
	private String CodeShareAirlineCd;
	private String CodeShareAirlineFltNbr;
	private String PaxThruInd;
	private String PaxInboundConxInd;
	private String PaxOutboundConxInd;
	private String PaxCodeShareInd;
	private String OneWorldConxInd;
	private String OneWorldInConxInd;
	private String OneWorldOutConxInd;
	private String GenderInd;
	private String CHGFLInd;
	private String CHGSGInd;
	private String GOSHOInd;
	private String IDPADInd;
	private String NORECInd;
	private String NOSHOInd;
	private String OFFLKInd;
	private String OFFLNInd;
	private String GOSHNInd;
	private String CHGCLInd;
	private String INVOLInd;
	private String APIPXInd;
	private String CFMWLInd;
	private String FQTVNInd;
	private String CheckInGrpCode;
	private Short CheckinGrpCnt;
	private String ResGrpCode;
	private Short ResGrpCnt;
	private String PaxContactText;
	private String ETCIInInd;
	private String ETCIOutInd;
	private String CheckInKioskInd;
	private String RemoteCheckInInd;
	private String CheckInMobileInd;
	private Time CheckInTime;
	private Date CheckInDate;
	private String ChknRestrictedSOCInd;
	private String VendorCode;
	private String FrequentTravelerNbr;
	private String FQTVTier;
	private String PriorityListCd;
	private String DeniedBoardType;
	private String OverSaleLegID;
	private Short OverSaleReasonNbr;
	private BigDecimal OversaleCompensation;
	private String CompTypeCd;
	private String CompCurrCd;
	private String OversaleReaccomInd;
	private String UpgradeCd;
	private String PaxCommentsText;
	private Short NbrOfBags;
	private Short TtlBagWeight;
	private String ExcessBagInd;
	private String NSTInd;
	private String OFLInd;
	private String STCHInd;
	private String BCSInd;
	private String SSUPInd;
	private String SSPRInd;
	private String WVERInd;
	private String INCUInd;
	private String OXYGInd;
	private String NMELInd;
	private String GCIPInd;
	private String GVIPInd;
	private Timestamp MsgCreateDateTime;
	private String APPInfantInd;
	private String APPAuthCountry;
	private String APPStatus;
	private String SSRCode;
	private String SSRText;
	private String PaxInboundCarrier;
	private String PaxInboundFlightNbr;
	private Date PaxInbSvcStDt;
	private Time PaxInbSvcStTm;
	private String PaxInbOrigin;
	private String PaxInbDest;
	private String PaxInbBookedClass;
	private String PaxOutboundCarrier;
	private String PaxOutboundFlightNbr;
	private Date PaxOutbSvcStDt;
	private Time PaxOutbSvcStTm;
	private String PaxOutbOrigin;
	private String PaxOutbDest;
	private String PaxOutbBookedClass;

	public String getSourceSystemID() {
		return SourceSystemID;
	}

	public void setSourceSystemID(final String SourceSystemID) {
		this.SourceSystemID = SourceSystemID;
	}

	public String getPNRLocatorId() {
		return PNRLocatorId;
	}

	public void setPNRLocatorId(final String PNRLocatorId) {
		this.PNRLocatorId = PNRLocatorId;
	}

	public String getMCPPNRLocatorId() {
		return MCPPNRLocatorId;
	}

	public void setMCPPNRLocatorId(final String MCPPNRLocatorId) {
		this.MCPPNRLocatorId = MCPPNRLocatorId;
	}

	public Date getPNRCreateDate() {
		return PNRCreateDate;
	}

	public void setPNRCreateDate(final Date PNRCreateDate) {
		this.PNRCreateDate = PNRCreateDate;
	}

	public Date getMCPPNRCreateDate() {
		return MCPPNRCreateDate;
	}

	public void setMCPPNRCreateDate(final Date MCPPNRCreateDate) {
		this.MCPPNRCreateDate = MCPPNRCreateDate;
	}

	public Short getResPaxId() {
		return ResPaxId;
	}

	public void setResPaxId(final Short ResPaxId) {
		this.ResPaxId = ResPaxId;
	}

	public String getAirlineCode() {
		return AirlineCode;
	}

	public void setAirlineCode(final String AirlineCode) {
		this.AirlineCode = AirlineCode;
	}

	public String getFltNbr() {
		return FltNbr;
	}

	public void setFltNbr(final String FltNbr) {
		this.FltNbr = FltNbr;
	}

	public Date getServiceStartDate() {
		return ServiceStartDate;
	}

	public void setServiceStartDate(final Date ServiceStartDate) {
		this.ServiceStartDate = ServiceStartDate;
	}

	public String getAirlineOrigAirport() {
		return AirlineOrigAirport;
	}

	public void setAirlineOrigAirport(final String AirlineOrigAirport) {
		this.AirlineOrigAirport = AirlineOrigAirport;
	}

	public String getResPaxNameID() {
		return ResPaxNameID;
	}

	public void setResPaxNameID(final String ResPaxNameID) {
		this.ResPaxNameID = ResPaxNameID;
	}

	public String getNameFirst() {
		return NameFirst;
	}

	public void setNameFirst(final String NameFirst) {
		this.NameFirst = NameFirst;
	}

	public String getNameLast() {
		return NameLast;
	}

	public void setNameLast(final String NameLast) {
		this.NameLast = NameLast;
	}

	public String getPaxPNROrigin() {
		return PaxPNROrigin;
	}

	public void setPaxPNROrigin(final String PaxPNROrigin) {
		this.PaxPNROrigin = PaxPNROrigin;
	}

	public String getPaxPNRDest() {
		return PaxPNRDest;
	}

	public void setPaxPNRDest(final String PaxPNRDest) {
		this.PaxPNRDest = PaxPNRDest;
	}

	public String getUPID() {
		return UPID;
	}

	public void setUPID(final String UPID) {
		this.UPID = UPID;
	}

	public String getPaxTypeCd() {
		return PaxTypeCd;
	}

	public void setPaxTypeCd(final String PaxTypeCd) {
		this.PaxTypeCd = PaxTypeCd;
	}

	public String getRevenuePassengerInd() {
		return RevenuePassengerInd;
	}

	public void setRevenuePassengerInd(final String RevenuePassengerInd) {
		this.RevenuePassengerInd = RevenuePassengerInd;
	}

	public String getNonRevenuePassengerind() {
		return NonRevenuePassengerind;
	}

	public void setNonRevenuePassengerind(final String NonRevenuePassengerind) {
		this.NonRevenuePassengerind = NonRevenuePassengerind;
	}

	public String getDeadheadInd() {
		return DeadheadInd;
	}

	public void setDeadheadInd(final String DeadheadInd) {
		this.DeadheadInd = DeadheadInd;
	}

	public String getSelecteeInd() {
		return SelecteeInd;
	}

	public void setSelecteeInd(final String SelecteeInd) {
		this.SelecteeInd = SelecteeInd;
	}

	public String getOnBrdInd() {
		return OnBrdInd;
	}

	public void setOnBrdInd(final String OnBrdInd) {
		this.OnBrdInd = OnBrdInd;
	}

	public String getBoardingPassInd() {
		return BoardingPassInd;
	}

	public void setBoardingPassInd(final String BoardingPassInd) {
		this.BoardingPassInd = BoardingPassInd;
	}

	public String getPriorityListInd() {
		return PriorityListInd;
	}

	public void setPriorityListInd(final String PriorityListInd) {
		this.PriorityListInd = PriorityListInd;
	}

	public Short getCheckInSeqNbr() {
		return CheckInSeqNbr;
	}

	public void setCheckInSeqNbr(final Short CheckInSeqNbr) {
		this.CheckInSeqNbr = CheckInSeqNbr;
	}

	public String getFlownClassofService() {
		return FlownClassofService;
	}

	public void setFlownClassofService(final String FlownClassofService) {
		this.FlownClassofService = FlownClassofService;
	}

	public String getClassofService() {
		return ClassofService;
	}

	public void setClassofService(final String ClassofService) {
		this.ClassofService = ClassofService;
	}

	public String getBookedInventory() {
		return BookedInventory;
	}

	public void setBookedInventory(final String BookedInventory) {
		this.BookedInventory = BookedInventory;
	}

	public String getInventoryUpgradeInd() {
		return InventoryUpgradeInd;
	}

	public void setInventoryUpgradeInd(final String InventoryUpgradeInd) {
		this.InventoryUpgradeInd = InventoryUpgradeInd;
	}

	public String getMarketingAirlineCd() {
		return MarketingAirlineCd;
	}

	public void setMarketingAirlineCd(final String MarketingAirlineCd) {
		this.MarketingAirlineCd = MarketingAirlineCd;
	}

	public String getMarketingFltNbr() {
		return MarketingFltNbr;
	}

	public void setMarketingFltNbr(final String MarketingFltNbr) {
		this.MarketingFltNbr = MarketingFltNbr;
	}

	public String getCodeShareAirlineCd() {
		return CodeShareAirlineCd;
	}

	public void setCodeShareAirlineCd(final String CodeShareAirlineCd) {
		this.CodeShareAirlineCd = CodeShareAirlineCd;
	}

	public String getCodeShareAirlineFltNbr() {
		return CodeShareAirlineFltNbr;
	}

	public void setCodeShareAirlineFltNbr(final String CodeShareAirlineFltNbr) {
		this.CodeShareAirlineFltNbr = CodeShareAirlineFltNbr;
	}

	public String getPaxThruInd() {
		return PaxThruInd;
	}

	public void setPaxThruInd(final String PaxThruInd) {
		this.PaxThruInd = PaxThruInd;
	}

	public String getPaxInboundConxInd() {
		return PaxInboundConxInd;
	}

	public void setPaxInboundConxInd(final String PaxInboundConxInd) {
		this.PaxInboundConxInd = PaxInboundConxInd;
	}

	public String getPaxOutboundConxInd() {
		return PaxOutboundConxInd;
	}

	public void setPaxOutboundConxInd(final String PaxOutboundConxInd) {
		this.PaxOutboundConxInd = PaxOutboundConxInd;
	}

	public String getPaxCodeShareInd() {
		return PaxCodeShareInd;
	}

	public void setPaxCodeShareInd(final String PaxCodeShareInd) {
		this.PaxCodeShareInd = PaxCodeShareInd;
	}

	public String getOneWorldConxInd() {
		return OneWorldConxInd;
	}

	public void setOneWorldConxInd(final String OneWorldConxInd) {
		this.OneWorldConxInd = OneWorldConxInd;
	}

	public String getOneWorldInConxInd() {
		return OneWorldInConxInd;
	}

	public void setOneWorldInConxInd(final String OneWorldInConxInd) {
		this.OneWorldInConxInd = OneWorldInConxInd;
	}

	public String getOneWorldOutConxInd() {
		return OneWorldOutConxInd;
	}

	public void setOneWorldOutConxInd(final String OneWorldOutConxInd) {
		this.OneWorldOutConxInd = OneWorldOutConxInd;
	}

	public String getGenderInd() {
		return GenderInd;
	}

	public void setGenderInd(final String GenderInd) {
		this.GenderInd = GenderInd;
	}

	public String getCHGFLInd() {
		return CHGFLInd;
	}

	public void setCHGFLInd(final String CHGFLInd) {
		this.CHGFLInd = CHGFLInd;
	}

	public String getCHGSGInd() {
		return CHGSGInd;
	}

	public void setCHGSGInd(final String CHGSGInd) {
		this.CHGSGInd = CHGSGInd;
	}

	public String getGOSHOInd() {
		return GOSHOInd;
	}

	public void setGOSHOInd(final String GOSHOInd) {
		this.GOSHOInd = GOSHOInd;
	}

	public String getIDPADInd() {
		return IDPADInd;
	}

	public void setIDPADInd(final String IDPADInd) {
		this.IDPADInd = IDPADInd;
	}

	public String getNORECInd() {
		return NORECInd;
	}

	public void setNORECInd(final String NORECInd) {
		this.NORECInd = NORECInd;
	}

	public String getNOSHOInd() {
		return NOSHOInd;
	}

	public void setNOSHOInd(final String NOSHOInd) {
		this.NOSHOInd = NOSHOInd;
	}

	public String getOFFLKInd() {
		return OFFLKInd;
	}

	public void setOFFLKInd(final String OFFLKInd) {
		this.OFFLKInd = OFFLKInd;
	}

	public String getOFFLNInd() {
		return OFFLNInd;
	}

	public void setOFFLNInd(final String OFFLNInd) {
		this.OFFLNInd = OFFLNInd;
	}

	public String getGOSHNInd() {
		return GOSHNInd;
	}

	public void setGOSHNInd(final String GOSHNInd) {
		this.GOSHNInd = GOSHNInd;
	}

	public String getCHGCLInd() {
		return CHGCLInd;
	}

	public void setCHGCLInd(final String CHGCLInd) {
		this.CHGCLInd = CHGCLInd;
	}

	public String getINVOLInd() {
		return INVOLInd;
	}

	public void setINVOLInd(final String INVOLInd) {
		this.INVOLInd = INVOLInd;
	}

	public String getAPIPXInd() {
		return APIPXInd;
	}

	public void setAPIPXInd(final String APIPXInd) {
		this.APIPXInd = APIPXInd;
	}

	public String getCFMWLInd() {
		return CFMWLInd;
	}

	public void setCFMWLInd(final String CFMWLInd) {
		this.CFMWLInd = CFMWLInd;
	}

	public String getFQTVNInd() {
		return FQTVNInd;
	}

	public void setFQTVNInd(final String FQTVNInd) {
		this.FQTVNInd = FQTVNInd;
	}

	public String getCheckInGrpCode() {
		return CheckInGrpCode;
	}

	public void setCheckInGrpCode(final String CheckInGrpCode) {
		this.CheckInGrpCode = CheckInGrpCode;
	}

	public Short getCheckinGrpCnt() {
		return CheckinGrpCnt;
	}

	public void setCheckinGrpCnt(final Short CheckinGrpCnt) {
		this.CheckinGrpCnt = CheckinGrpCnt;
	}

	public String getResGrpCode() {
		return ResGrpCode;
	}

	public void setResGrpCode(final String ResGrpCode) {
		this.ResGrpCode = ResGrpCode;
	}

	public Short getResGrpCnt() {
		return ResGrpCnt;
	}

	public void setResGrpCnt(final Short ResGrpCnt) {
		this.ResGrpCnt = ResGrpCnt;
	}

	public String getPaxContactText() {
		return PaxContactText;
	}

	public void setPaxContactText(final String PaxContactText) {
		this.PaxContactText = PaxContactText;
	}

	public String getETCIInInd() {
		return ETCIInInd;
	}

	public void setETCIInInd(final String ETCIInInd) {
		this.ETCIInInd = ETCIInInd;
	}

	public String getETCIOutInd() {
		return ETCIOutInd;
	}

	public void setETCIOutInd(final String ETCIOutInd) {
		this.ETCIOutInd = ETCIOutInd;
	}

	public String getCheckInKioskInd() {
		return CheckInKioskInd;
	}

	public void setCheckInKioskInd(final String CheckInKioskInd) {
		this.CheckInKioskInd = CheckInKioskInd;
	}

	public String getRemoteCheckInInd() {
		return RemoteCheckInInd;
	}

	public void setRemoteCheckInInd(final String RemoteCheckInInd) {
		this.RemoteCheckInInd = RemoteCheckInInd;
	}

	public String getCheckInMobileInd() {
		return CheckInMobileInd;
	}

	public void setCheckInMobileInd(final String CheckInMobileInd) {
		this.CheckInMobileInd = CheckInMobileInd;
	}

	public Time getCheckInTime() {
		return CheckInTime;
	}

	public void setCheckInTime(final Time CheckInTime) {
		this.CheckInTime = CheckInTime;
	}

	public Date getCheckInDate() {
		return CheckInDate;
	}

	public void setCheckInDate(final Date CheckInDate) {
		this.CheckInDate = CheckInDate;
	}

	public String getChknRestrictedSOCInd() {
		return ChknRestrictedSOCInd;
	}

	public void setChknRestrictedSOCInd(final String ChknRestrictedSOCInd) {
		this.ChknRestrictedSOCInd = ChknRestrictedSOCInd;
	}

	public String getVendorCode() {
		return VendorCode;
	}

	public void setVendorCode(final String VendorCode) {
		this.VendorCode = VendorCode;
	}

	public String getFrequentTravelerNbr() {
		return FrequentTravelerNbr;
	}

	public void setFrequentTravelerNbr(final String FrequentTravelerNbr) {
		this.FrequentTravelerNbr = FrequentTravelerNbr;
	}

	public String getFQTVTier() {
		return FQTVTier;
	}

	public void setFQTVTier(final String FQTVTier) {
		this.FQTVTier = FQTVTier;
	}

	public String getPriorityListCd() {
		return PriorityListCd;
	}

	public void setPriorityListCd(final String PriorityListCd) {
		this.PriorityListCd = PriorityListCd;
	}

	public String getDeniedBoardType() {
		return DeniedBoardType;
	}

	public void setDeniedBoardType(final String DeniedBoardType) {
		this.DeniedBoardType = DeniedBoardType;
	}

	public String getOverSaleLegID() {
		return OverSaleLegID;
	}

	public void setOverSaleLegID(final String OverSaleLegID) {
		this.OverSaleLegID = OverSaleLegID;
	}

	public Short getOverSaleReasonNbr() {
		return OverSaleReasonNbr;
	}

	public void setOverSaleReasonNbr(final Short OverSaleReasonNbr) {
		this.OverSaleReasonNbr = OverSaleReasonNbr;
	}

	public BigDecimal getOversaleCompensation() {
		return OversaleCompensation;
	}

	public void setOversaleCompensation(final BigDecimal OversaleCompensation) {
		this.OversaleCompensation = OversaleCompensation;
	}

	public String getCompTypeCd() {
		return CompTypeCd;
	}

	public void setCompTypeCd(final String CompTypeCd) {
		this.CompTypeCd = CompTypeCd;
	}

	public String getCompCurrCd() {
		return CompCurrCd;
	}

	public void setCompCurrCd(final String CompCurrCd) {
		this.CompCurrCd = CompCurrCd;
	}

	public String getOversaleReaccomInd() {
		return OversaleReaccomInd;
	}

	public void setOversaleReaccomInd(final String OversaleReaccomInd) {
		this.OversaleReaccomInd = OversaleReaccomInd;
	}

	public String getUpgradeCd() {
		return UpgradeCd;
	}

	public void setUpgradeCd(final String UpgradeCd) {
		this.UpgradeCd = UpgradeCd;
	}

	public String getPaxCommentsText() {
		return PaxCommentsText;
	}

	public void setPaxCommentsText(final String PaxCommentsText) {
		this.PaxCommentsText = PaxCommentsText;
	}

	public Short getNbrOfBags() {
		return NbrOfBags;
	}

	public void setNbrOfBags(final Short NbrOfBags) {
		this.NbrOfBags = NbrOfBags;
	}

	public Short getTtlBagWeight() {
		return TtlBagWeight;
	}

	public void setTtlBagWeight(final Short TtlBagWeight) {
		this.TtlBagWeight = TtlBagWeight;
	}

	public String getExcessBagInd() {
		return ExcessBagInd;
	}

	public void setExcessBagInd(final String ExcessBagInd) {
		this.ExcessBagInd = ExcessBagInd;
	}

	public String getNSTInd() {
		return NSTInd;
	}

	public void setNSTInd(final String NSTInd) {
		this.NSTInd = NSTInd;
	}

	public String getOFLInd() {
		return OFLInd;
	}

	public void setOFLInd(final String OFLInd) {
		this.OFLInd = OFLInd;
	}

	public String getSTCHInd() {
		return STCHInd;
	}

	public void setSTCHInd(final String STCHInd) {
		this.STCHInd = STCHInd;
	}

	public String getBCSInd() {
		return BCSInd;
	}

	public void setBCSInd(final String BCSInd) {
		this.BCSInd = BCSInd;
	}

	public String getSSUPInd() {
		return SSUPInd;
	}

	public void setSSUPInd(final String SSUPInd) {
		this.SSUPInd = SSUPInd;
	}

	public String getSSPRInd() {
		return SSPRInd;
	}

	public void setSSPRInd(final String SSPRInd) {
		this.SSPRInd = SSPRInd;
	}

	public String getWVERInd() {
		return WVERInd;
	}

	public void setWVERInd(final String WVERInd) {
		this.WVERInd = WVERInd;
	}

	public String getINCUInd() {
		return INCUInd;
	}

	public void setINCUInd(final String INCUInd) {
		this.INCUInd = INCUInd;
	}

	public String getOXYGInd() {
		return OXYGInd;
	}

	public void setOXYGInd(final String OXYGInd) {
		this.OXYGInd = OXYGInd;
	}

	public String getNMELInd() {
		return NMELInd;
	}

	public void setNMELInd(final String NMELInd) {
		this.NMELInd = NMELInd;
	}

	public String getGCIPInd() {
		return GCIPInd;
	}

	public void setGCIPInd(final String GCIPInd) {
		this.GCIPInd = GCIPInd;
	}

	public String getGVIPInd() {
		return GVIPInd;
	}

	public void setGVIPInd(final String GVIPInd) {
		this.GVIPInd = GVIPInd;
	}

	public Timestamp getMsgCreateDateTime() {
		return MsgCreateDateTime;
	}

	public void setMsgCreateDateTime(final Timestamp MsgCreateDateTime) {
		this.MsgCreateDateTime = MsgCreateDateTime;
	}

	public String getAPPInfantInd() {
		return APPInfantInd;
	}

	public void setAPPInfantInd(final String APPInfantInd) {
		this.APPInfantInd = APPInfantInd;
	}

	public String getAPPAuthCountry() {
		return APPAuthCountry;
	}

	public void setAPPAuthCountry(final String APPAuthCountry) {
		this.APPAuthCountry = APPAuthCountry;
	}

	public String getAPPStatus() {
		return APPStatus;
	}

	public void setAPPStatus(final String APPStatus) {
		this.APPStatus = APPStatus;
	}

	public String getSSRCode() {
		return SSRCode;
	}

	public void setSSRCode(final String SSRCode) {
		this.SSRCode = SSRCode;
	}

	public String getSSRText() {
		return SSRText;
	}

	public void setSSRText(final String SSRText) {
		this.SSRText = SSRText;
	}

	public String getPaxInboundCarrier() {
		return PaxInboundCarrier;
	}

	public void setPaxInboundCarrier(final String PaxInboundCarrier) {
		this.PaxInboundCarrier = PaxInboundCarrier;
	}

	public String getPaxInboundFlightNbr() {
		return PaxInboundFlightNbr;
	}

	public void setPaxInboundFlightNbr(final String PaxInboundFlightNbr) {
		this.PaxInboundFlightNbr = PaxInboundFlightNbr;
	}

	public Date getPaxInbSvcStDt() {
		return PaxInbSvcStDt;
	}

	public void setPaxInbSvcStDt(final Date PaxInbSvcStDt) {
		this.PaxInbSvcStDt = PaxInbSvcStDt;
	}

	public Time getPaxInbSvcStTm() {
		return PaxInbSvcStTm;
	}

	public void setPaxInbSvcStTm(final Time PaxInbSvcStTm) {
		this.PaxInbSvcStTm = PaxInbSvcStTm;
	}

	public String getPaxInbOrigin() {
		return PaxInbOrigin;
	}

	public void setPaxInbOrigin(final String PaxInbOrigin) {
		this.PaxInbOrigin = PaxInbOrigin;
	}

	public String getPaxInbDest() {
		return PaxInbDest;
	}

	public void setPaxInbDest(final String PaxInbDest) {
		this.PaxInbDest = PaxInbDest;
	}

	public String getPaxInbBookedClass() {
		return PaxInbBookedClass;
	}

	public void setPaxInbBookedClass(final String PaxInbBookedClass) {
		this.PaxInbBookedClass = PaxInbBookedClass;
	}

	public String getPaxOutboundCarrier() {
		return PaxOutboundCarrier;
	}

	public void setPaxOutboundCarrier(final String PaxOutboundCarrier) {
		this.PaxOutboundCarrier = PaxOutboundCarrier;
	}

	public String getPaxOutboundFlightNbr() {
		return PaxOutboundFlightNbr;
	}

	public void setPaxOutboundFlightNbr(final String PaxOutboundFlightNbr) {
		this.PaxOutboundFlightNbr = PaxOutboundFlightNbr;
	}

	public Date getPaxOutbSvcStDt() {
		return PaxOutbSvcStDt;
	}

	public void setPaxOutbSvcStDt(final Date PaxOutbSvcStDt) {
		this.PaxOutbSvcStDt = PaxOutbSvcStDt;
	}

	public Time getPaxOutbSvcStTm() {
		return PaxOutbSvcStTm;
	}

	public void setPaxOutbSvcStTm(final Time PaxOutbSvcStTm) {
		this.PaxOutbSvcStTm = PaxOutbSvcStTm;
	}

	public String getPaxOutbOrigin() {
		return PaxOutbOrigin;
	}

	public void setPaxOutbOrigin(final String PaxOutbOrigin) {
		this.PaxOutbOrigin = PaxOutbOrigin;
	}

	public String getPaxOutbDest() {
		return PaxOutbDest;
	}

	public void setPaxOutbDest(final String PaxOutbDest) {
		this.PaxOutbDest = PaxOutbDest;
	}

	public String getPaxOutbBookedClass() {
		return PaxOutbBookedClass;
	}

	public void setPaxOutbBookedClass(final String PaxOutbBookedClass) {
		this.PaxOutbBookedClass = PaxOutbBookedClass;
	}

}