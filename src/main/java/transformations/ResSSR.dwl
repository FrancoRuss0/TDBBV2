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
	ResSSRSeqId : cast.toNumber(record[4]),
	PNRPassengerSeqId : cast.toNumber(record[5]),
	SourceTypeCode : cast.toString(record[6]),
	SSRIdTypeCode : cast.toString(record[7]),
	SSRStatusCode : cast.toString(record[8]),
	SSRFlightNumber : cast.toString(record[9]),
	SSRNbrInParty : cast.toNumber(record[10]),
	SSRStartDate : cast.toDate(record[11],"yyyy-MM-dd"),
	VendorCode : cast.toString(record[12]),
	SSRCode : cast.toString(record[13]),
	SSRText : cast.toString(record[14]),
	ClassOfService : cast.toString(record[15]),
	ServiceStartCityCode : cast.toString(record[16]),
	ServiceEndCityCode : cast.toString(record[17]),
	HistoryActionCodeId : cast.toString(record[18]),
	RecordUpdateDate : cast.toDate(record[19],"yyyy-MM-dd"),
	RecordUpdateTime : cast.toLocalTime(record[20],"HH:mm:ss"),
	IntraPNRSetNbr : cast.toNumber(record[21])
} as Object {class: "com.airmalta.hip.tdbingester.filepojos.ResSSR"}