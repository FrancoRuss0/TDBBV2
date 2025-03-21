%dw 2.0
output application/java
var cast = readUrl("classpath://CastingFunctions.dwl", "application/dw")
---
(data) -> data map (record,index) -> 
{
	ID : cast.toString(record[0]),
	PNRLocatorID : cast.toString(record[1]),
	PNRCreateDate : cast.toDate(record[2],"yyyy-MM-dd"),
	FromDateTime : cast.toLocalDateTime(record[3],"yyyy-MM-dd HH:mm:ss.SSSSSS"),
	RFICode : cast.toString(record[4]),
	CommercialName : cast.toString(record[5]),
	SSIMCode : cast.toString(record[6]),
	SSRCode : cast.toString(record[7]),
	BoardPointAirportCode : cast.toString(record[8]),
	OffPointAirportCode : cast.toString(record[9]),
	OwningCarrierCode : cast.toString(record[10]),
	FeeVendorCode : cast.toString(record[11]),
	BookingMethodCode : cast.toString(record[12]),
	FulfillTypeCode : cast.toString(record[13]),
	EMDTypeCode : cast.toNumber(record[14]),
	RefundReissueCode : cast.toString(record[15]),
	FormOfRefundCode : cast.toString(record[16]),
	FrequentTravelerTierLevel : cast.toString(record[17]),
	BrandedFareId : cast.toString(record[18]),
	TourCode : cast.toString(record[19]),
	ServiceChargeCode : cast.toString(record[20]),
	FeeApplicationCode : cast.toString(record[21]),
	FirstTravelDate : cast.toDate(record[22],"yyyy-MM-dd"),
	LastTravelDate : cast.toDate(record[23],"yyyy-MM-dd"),
	HistoryActionCode : cast.toString(record[24]),
	TTYConfirmationDateTime : cast.toLocalDateTime(record[25],"yyyy-MM-dd HH:mm:ss.SSSSSS"),
	PurchaseByDateTime : cast.toLocalDateTime(record[26],"yyyy-MM-dd HH:mm:ss.SSSSSS"),
	BookingSourceCode : cast.toString(record[27]),
	EMDNbr : cast.toString(record[28]),
	EMDCouponNbr : cast.toNumber(record[29]),
	ETicketNbr : cast.toString(record[30]),
	ETicketCouponNbr : cast.toNumber(record[31]),
	SSRDirectFulfillCode : cast.toString(record[32]),
	NonEMDFormofPayment : cast.toString(record[33]),
	FeeWaivedCode : cast.toString(record[34]),
	AEBasePriceAmount : cast.toNumber(record[35]),
	AEBaseCurrencyCode : cast.toString(record[36]),
	AEEquivalentPaidAmount : cast.toNumber(record[37]),
	AEEquivalentAmtCurrencyCd : cast.toString(record[38]),
	ItemCount : cast.toNumber(record[39]),
	AETotalPriceAmount : cast.toNumber(record[40]),
	PassengerTypeCode : cast.toString(record[41]),
	TaxIncludedCode : cast.toString(record[42]),
	SegmentUseCode : cast.toString(record[43]),
	SegmentBookedDate : cast.toDate(record[44],"yyyy-MM-dd"),
	SegmentBookedTime : cast.toLocalTime(record[45],"HH:mm:ss"),
	NonEMDFOPCCCode : cast.toString(record[46]),
	NonEMDFOPMaskedCCNbr : cast.toString(record[47]),
	NonEMDFOPCCExpryDt : cast.toString(record[48]),
	GroupCode : cast.toString(record[49]),
	SimultaneousTicketPurchaseInd : cast.toString(record[50]),
	CommissionInd : cast.toString(record[51]),
	InterlineInd : cast.toString(record[52]),
	FeeGuaranteedInd : cast.toString(record[53]),
	EMDPaperInd : cast.toString(record[54]),
	RFISubCode : cast.toString(record[55]),
	RecordUpdateDate : cast.toDate(record[56],"yyyy-MM-dd"),
	RecordUpdateTime : cast.toLocalTime(record[57],"HH:mm:ss"),
	IntraPNRSetNbr : cast.toNumber(record[58]),
	PNRPassengerSeqId : cast.toNumber(record[59]),
	AEFLight : cast.toString(record[60]),
	AECurrentSegmentStatusCode : cast.toString(record[61]),
	AEPreviousSegmentStatus : cast.toString(record[62]),
	ACSCount : cast.toNumber(record[63]),
	AssociatedSegmentCount : cast.toNumber(record[64])
} as Object {class: "com.kmmaltairlines.hip.tdbingester.filepojos.ResAirExtra"}