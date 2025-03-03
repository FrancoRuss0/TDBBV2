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
	PNRPassengerPhoneSeqId : cast.toNumber(record[4]),
	CityPhoneCode : cast.toString(record[5]),
	PhoneNbrText : cast.toString(record[6]),
	PhoneTypeCode : cast.toString(record[7]),
	HistoryActionCodeId : cast.toString(record[8]),
	RecordUpdateDate : cast.toDate(record[9],"yyyy-MM-dd"),
	RecordUpdateTime : cast.toLocalTime(record[10],"HH:mm:ss"),
	IntraPNRSetNbr : cast.toNumber(record[11])
} as Object {class: "com.airmalta.hip.tdbingester.filepojos.ResPassengerPhone"}