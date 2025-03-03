%dw 2.0
output application/java
var cast = readUrl("classpath://CastingFunctions.dwl", "application/dw")
---
(data) -> data map (record,index) -> 
{
	SourceSystemID : cast.toString(record[0]),
	PNRLocatorId : cast.toString(record[1]),
	MCPPNRLocatorId : cast.toString(record[2]),
	PNRCreateDate : cast.toDate(record[3],"yyyy-MM-dd"),
	MCPPNRCreateDate : cast.toDate(record[4],"yyyy-MM-dd"),
	ResPaxId : cast.toNumber(record[5]),
	AirlineCode : cast.toString(record[6]),
	FltNbr : cast.toString(record[7]),
	ServiceStartDate : cast.toDate(record[8],"yyyy-MM-dd"),
	AirlineOrigAirport : cast.toString(record[9]),
	ResPaxNameID : cast.toString(record[10]),
	NameFirst : cast.toString(record[11]),
	NameLast : cast.toString(record[12]),
	PaxPNROrigin : cast.toString(record[13]),
	PaxPNRDest : cast.toString(record[14]),
	UPID : cast.toString(record[15]),
	PaxTypeCd : cast.toString(record[16]),
	RevenuePassengerInd : cast.toString(record[17]),
	NonRevenuePassengerind : cast.toString(record[18]),
	DeadheadInd : cast.toString(record[19]),
	SelecteeInd : cast.toString(record[20]),
	OnBrdInd : cast.toString(record[21]),
	BoardingPassInd : cast.toString(record[22]),
	PriorityListInd : cast.toString(record[23]),
	CheckInSeqNbr : cast.toNumber(record[24]),
	FlownClassofService : cast.toString(record[25]),
	ClassofService : cast.toString(record[26]),
	BookedInventory : cast.toString(record[27]),
	InventoryUpgradeInd : cast.toString(record[28]),
	MarketingAirlineCd : cast.toString(record[29]),
	MarketingFltNbr : cast.toString(record[30]),
	CodeShareAirlineCd : cast.toString(record[31]),
	CodeShareAirlineFltNbr : cast.toString(record[32]),
	PaxThruInd : cast.toString(record[33]),
	PaxInboundConxInd : cast.toString(record[34]),
	PaxOutboundConxInd : cast.toString(record[35]),
	PaxCodeShareInd : cast.toString(record[36]),
	OneWorldConxInd : cast.toString(record[37]),
	OneWorldInConxInd : cast.toString(record[38]),
	OneWorldOutConxInd : cast.toString(record[39]),
	GenderInd : cast.toString(record[40]),
	CHGFLInd : cast.toString(record[41]),
	CHGSGInd : cast.toString(record[42]),
	GOSHOInd : cast.toString(record[43]),
	IDPADInd : cast.toString(record[44]),
	NORECInd : cast.toString(record[45]),
	NOSHOInd : cast.toString(record[46]),
	OFFLKInd : cast.toString(record[47]),
	OFFLNInd : cast.toString(record[48]),
	GOSHNInd : cast.toString(record[49]),
	CHGCLInd : cast.toString(record[50]),
	INVOLInd : cast.toString(record[51]),
	APIPXInd : cast.toString(record[52]),
	CFMWLInd : cast.toString(record[53]),
	FQTVNInd : cast.toString(record[54]),
	CheckInGrpCode : cast.toString(record[55]),
	CheckinGrpCnt : cast.toNumber(record[56]),
	ResGrpCode : cast.toString(record[57]),
	ResGrpCnt : cast.toNumber(record[58]),
	PaxContactText : cast.toString(record[59]),
	ETCIInInd : cast.toString(record[60]),
	ETCIOutInd : cast.toString(record[61]),
	CheckInKioskInd : cast.toString(record[62]),
	RemoteCheckInInd : cast.toString(record[63]),
	CheckInMobileInd : cast.toString(record[64]),
	CheckInTime : cast.toLocalTime(record[65],"HH:mm:ss"),
	CheckInDate : cast.toDate(record[66],"yyyy-MM-dd"),
	ChknRestrictedSOCInd : cast.toString(record[67]),
	VendorCode : cast.toString(record[68]),
	FrequentTravelerNbr : cast.toString(record[69]),
	FQTVTier : cast.toString(record[70]),
	PriorityListCd : cast.toString(record[71]),
	DeniedBoardType : cast.toString(record[72]),
	OverSaleLegID : cast.toString(record[73]),
	OverSaleReasonNbr : cast.toNumber(record[74]),
	OversaleCompensation : cast.toNumber(record[75]),
	CompTypeCd : cast.toString(record[76]),
	CompCurrCd : cast.toString(record[77]),
	OversaleReaccomInd : cast.toString(record[78]),
	UpgradeCd : cast.toString(record[79]),
	PaxCommentsText : cast.toString(record[80]),
	NbrOfBags : cast.toNumber(record[81]),
	TtlBagWeight : cast.toNumber(record[82]),
	ExcessBagInd : cast.toString(record[83]),
	NSTInd : cast.toString(record[84]),
	OFLInd : cast.toString(record[85]),
	STCHInd : cast.toString(record[86]),
	BCSInd : cast.toString(record[87]),
	SSUPInd : cast.toString(record[88]),
	SSPRInd : cast.toString(record[89]),
	WVERInd : cast.toString(record[90]),
	INCUInd : cast.toString(record[91]),
	OXYGInd : cast.toString(record[92]),
	NMELInd : cast.toString(record[93]),
	GCIPInd : cast.toString(record[94]),
	GVIPInd : cast.toString(record[95]),
	MsgCreateDateTime : cast.toLocalDateTime(record[96],"yyyy-MM-dd HH:mm:ss"),
	APPInfantInd : cast.toString(record[97]),
	APPAuthCountry : cast.toString(record[98]),
	APPStatus : cast.toString(record[99]),
	SSRCode : cast.toString(record[100]),
	SSRText : cast.toString(record[101]),
	PaxInboundCarrier : cast.toString(record[102]),
	PaxInboundFlightNbr : cast.toString(record[103]),
	PaxInbSvcStDt : cast.toDate(record[104],"yyyy-MM-dd"),
	PaxInbSvcStTm : cast.toLocalTime(record[105],"HH:mm:ss"),
	PaxInbOrigin : cast.toString(record[106]),
	PaxInbDest : cast.toString(record[107]),
	PaxInbBookedClass : cast.toString(record[108]),
	PaxOutboundCarrier : cast.toString(record[109]),
	PaxOutboundFlightNbr : cast.toString(record[110]),
	PaxOutbSvcStDt : cast.toDate(record[111],"yyyy-MM-dd"),
	PaxOutbSvcStTm : cast.toLocalTime(record[112],"HH:mm:ss"),
	PaxOutbOrigin : cast.toString(record[113]),
	PaxOutbDest : cast.toString(record[114]),
	PaxOutbBookedClass : cast.toString(record[115])
} as Object {class: "com.airmalta.hip.tdbingester.filepojos.ACSPaxFlight"}