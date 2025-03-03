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
	PNRPassengerSeqId : cast.toNumber(record[4]),
	SourceTypeCode : cast.toString(record[5]),
	SSRIdTypeCode : cast.toString(record[6]),
	SSRStatusCode : cast.toString(record[7]),
	SSRCode : cast.toString(record[8]),
	EmergencyContactSeqId : cast.toNumber(record[9]),
	EmergencyPhoneNumber : cast.toString(record[10]),
	EmergencyContactName : cast.toString(record[11]),
	CountryCode : cast.toString(record[12]),
	VendorCode : cast.toString(record[13]),
	SSRText : cast.toString(record[14]),
	HistoryActionCodeId : cast.toString(record[15]),
	RecordUpdateDate : cast.toDate(record[16],"yyyy-MM-dd"),
	RecordUpdateTime : cast.toLocalTime(record[17],"HH:mm:ss"),
	IntraPNRSetNbr : cast.toNumber(record[18])
} as Object {class: "com.airmalta.hip.tdbingester.filepojos.ResEmergencyCtc"}