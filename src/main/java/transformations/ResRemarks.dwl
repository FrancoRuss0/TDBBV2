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
	ResRemarkSeqId : cast.toNumber(record[4]),
	RemarkText : cast.toString(record[5]),
	RemarkType : cast.toNumber(record[6]),
	HistoryActionCodeId : cast.toString(record[7]),
	RecordUpdateDate : cast.toDate(record[8],"yyyy-MM-dd"),
	RecordUpdateTime : cast.toLocalTime(record[9],"HH:mm:ss"),
	IntraPNRSetNbr : cast.toNumber(record[10])
} as Object {class: "com.kmmaltairlines.hip.tdbingester.filepojos.ResRemarks"}