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
	PNRPassengerFTSeqId : cast.toNumber(record[4]),
	PNRPassengerSeqId : cast.toNumber(record[5]),
	SourceTypeCode : cast.toString(record[6]),
	ClassOfService : cast.toString(record[7]),
	FrequentTravelerNbr : cast.toString(record[8]),
	FTText : cast.toString(record[9]),
	FTCurrentStatusCode : cast.toString(record[10]),
	FTFlightNumber : cast.toString(record[11]),
	ReceivingCarrierCode : cast.toString(record[12]),
	ServiceStartCityCode : cast.toString(record[13]),
	ServiceEndCityCode : cast.toString(record[14]),
	SSRCode : cast.toString(record[15]),
	SSRIdTypeCode : cast.toString(record[16]),
	SSRNbrInParty : cast.toNumber(record[17]),
	VendorCode : cast.toString(record[18]),
	HistoryActionCodeId : cast.toString(record[19]),
	RecordUpdateDate : cast.toDate(record[20],"yyyy-MM-dd"),
	RecordUpdateTime : cast.toLocalTime(record[21],"HH:mm:ss"),
	IntraPNRSetNbr : cast.toNumber(record[22])
} as Object {class: "com.kmmaltairlines.hip.tdbingester.filepojos.ResPassengerFT"}