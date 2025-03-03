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
	PNRPassengerEMailSeqId : cast.toNumber(record[4]),
	EMailAddress : cast.toString(record[5]),
	HistoryActionCodeId : cast.toString(record[6]),
	RecordUpdateDate : cast.toDate(record[7],"yyyy-MM-dd"),
	RecordUpdateTime : cast.toLocalTime(record[8],"HH:mm:ss"),
	IntraPNRSetNbr : cast.toNumber(record[9]),
	PNRPassengerSeqID : cast.toNumber(record[10])
} as Object {class: "com.airmalta.hip.tdbingester.filepojos.ResPassengerEmail"}