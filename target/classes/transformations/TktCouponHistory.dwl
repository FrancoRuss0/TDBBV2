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
	FareBasisCode : cast.toString(record[7]),
	CouponNbr : cast.toNumber(record[8]),
	PreviousCouponStatusCode : cast.toString(record[9]),
	NewCouponStatusCode : cast.toString(record[10]),
	CouponNbrChanged : cast.toNumber(record[11]),
	PreviousControlVendorCode : cast.toString(record[12]),
	NewControlVendorCode : cast.toString(record[13]),
	RevalMarketingAirlineCode : cast.toString(record[14]),
	RevalClassofService : cast.toString(record[15]),
	RevalMarketingFlightNbr : cast.toString(record[16]),
	RevalServiceStartDate : cast.toDate(record[17],"yyyy-MM-dd"),
	RevalServiceStartCity : cast.toString(record[18]),
	RevalServiceEndCity : cast.toString(record[19]),
	RevalServiceStartTime : cast.toLocalTime(record[20],"HH:mm:ss.SSSSSS"),
	RevalServiceEndTime : cast.toLocalTime(record[21],"HH:mm:ss.SSSSSS"),
	RevalSegmentStatusCode : cast.toString(record[22]),
	LastUpdate : cast.toDate(record[23],"yyyy-MM-dd"),
	LastUpdateSysTime : cast.toLocalTime(record[24],"HH:mm:ss"),
	HistorySeqNbr : cast.toNumber(record[25])
} as Object {class: "com.airmalta.hip.tdbingester.filepojos.TktCouponHistory"}