%dw 2.0
output application/java
var cast = readUrl("classpath://CastingFunctions.dwl", "application/dw")
---
(data) -> data map (record,index) -> 
{
	ID : cast.toString(record[0]),
	PNRLocatorID : cast.toString(record[1]),
	PNRCreateDate : cast.toDate(record[2],"yyyy-MM-dd"),
	PrimaryDocNbr : cast.toString(record[3]),
	VCRCreateDate : cast.toDate(record[4],"yyyy-MM-dd"),
	TransactionDateTime : cast.toLocalDateTime(record[5],"yyyy-MM-dd HH:mm:ss.SSSSSS"),
	CouponSeqNbr : cast.toNumber(record[6]),
	EntNbr : cast.toNumber(record[7]),
	CouponStatus : cast.toString(record[8]),
	PreviousCouponStatusCode : cast.toString(record[9]),
	SegmentTypeCode : cast.toString(record[10]),
	MarketingAirlineCode : cast.toString(record[11]),
	MarketingFlightNbr : cast.toString(record[12]),
	ServiceStartCity : cast.toString(record[13]),
	ServiceEndCity : cast.toString(record[14]),
	SegmentStatusCode : cast.toString(record[15]),
	ServiceStartDate : cast.toDate(record[16],"yyyy-MM-dd"),
	ServiceStartTime : cast.toLocalTime(record[17],"HH:mm:ss.SSSSSS"),
	ServiceEndDate : cast.toDate(record[18],"yyyy-MM-dd"),
	ServiceEndTime : cast.toLocalTime(record[19],"HH:mm:ss.SSSSSS"),
	ClassOfService : cast.toString(record[20]),
	FareBasisCode : cast.toString(record[21]),
	TktDesignatorCode : cast.toString(record[22]),
	FareBreakInd : cast.toString(record[23]),
	PriceNotValidBeforeDate : cast.toDate(record[24],"yyyy-MM-dd"),
	PriceNotValidAfterDate : cast.toDate(record[25],"yyyy-MM-dd"),
	InvoluntaryInd : cast.toString(record[26]),
	FlownFlightNbr : cast.toString(record[27]),
	FlownServiceStartDate : cast.toDate(record[28],"yyyy-MM-dd"),
	FlownServiceStartCity : cast.toString(record[29]),
	FlownServiceEndCity : cast.toString(record[30]),
	FlownClassOfService : cast.toString(record[31]),
	FlownFlightOrigDate : cast.toDate(record[32],"yyyy-MM-dd"),
	OperatingAirlineCode : cast.toString(record[33]),
	OperatingFlightNbr : cast.toString(record[34]),
	OperatingPNRLocator : cast.toString(record[35]),
	FareBreakAmt : cast.toNumber(record[36]),
	FareBreakDiscAmt : cast.toNumber(record[37]),
	DiscountAmtInd : cast.toString(record[38]),
	DiscountPctInd : cast.toString(record[39]),
	StopoverCode : cast.toString(record[40]),
	FrequentTravelerNbr : cast.toString(record[41]),
	VendorCode : cast.toString(record[42]),
	FareBreakCurrencyCode : cast.toString(record[43]),
	SettlementAuthCode : cast.toString(record[44]),
	BaggageAlwncText : cast.toString(record[45])
} as Object {class: "com.kmmaltairlines.hip.tdbingester.filepojos.TktCoupon"}