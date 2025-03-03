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
	SuspenseSequenceId : cast.toNumber(record[4]),
	TimeLimitActionTime : cast.toString(record[5]),
	TimeLimitActionDate : cast.toDate(record[6],"yyyy-MM-dd"),
	TimeLimitLocationCode : cast.toString(record[7]),
	TimeLimitVendorCode : cast.toString(record[8]),
	HistoryActionCodeId : cast.toString(record[9]),
	RecordUpdateDate : cast.toDate(record[10],"yyyy-MM-dd"),
	RecordUpdateTime : cast.toLocalTime(record[11],"HH:mm:ss"),
	IntraPNRSetNbr : cast.toNumber(record[12])
} as Object {class: "com.airmalta.hip.tdbingester.filepojos.ResSuspTimeLmt"}