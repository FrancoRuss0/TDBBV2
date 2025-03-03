%dw 2.0
output application/java
var cast = readUrl("classpath://CastingFunctions.dwl", "application/dw")
---
(data) -> data map (record,index) -> 
{
	ID : cast.toString(record[0]),
	PNRLocatorID : cast.toString(record[1]),
	PNRCreateDate : cast.toDate(record[2],"yyyy-MM-dd"),
	IntraPNRSetNbr : cast.toNumber(record[3]),
	FromDateTime : cast.toLocalDateTime(record[4],"yyyy-MM-dd HH:mm:ss.SSSSSS"),
	TransmissionDateTime : cast.toLocalDateTime(record[5],"yyyy-MM-dd HH:mm:ss.SSSSSS"),
	UniqueComponentID : cast.toNumber(record[6]),
	AEPortionSeqNbr : cast.toNumber(record[7]),
	PNRPassengerSeqID : cast.toNumber(record[8]),
	AirlineCode : cast.toString(record[9]),
	FlightNbr : cast.toString(record[10]),
	ClassofService : cast.toString(record[11]),
	ServiceStartDate : cast.toDate(record[12],"yyyy-MM-dd"),
	ServiceStartCity : cast.toString(record[13]),
	ServiceEndCity : cast.toString(record[14]),
	EMDNbr : cast.toString(record[15]),
	EmdCouponNbr : cast.toNumber(record[16]),
	ETicketNbr : cast.toString(record[17]),
	ETicketCpnNbr : cast.toNumber(record[18]),
	RecordUpdateDate : cast.toDate(record[19],"yyyy-MM-dd"),
	RecordUpdateDateTime : cast.toLocalDateTime(record[20],"yyyy-MM-dd HH:mm:ss"),
	MarketingCarrierCode : cast.toString(record[21]),
	OpertatingCarrierCode : cast.toString(record[22]),
	SourceSystemID : cast.toString(record[23])
} as Object {class: "com.airmalta.hip.tdbingester.filepojos.ResAirExtraPortionofTravel"}