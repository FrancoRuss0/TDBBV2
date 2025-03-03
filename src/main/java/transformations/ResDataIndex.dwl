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
	NameAssociationID : cast.toNumber(record[4]),
	ProfileType : cast.toString(record[5]),
	ProfileValue : cast.toString(record[6]),
	SourceSystemId : cast.toString(record[7]),
	RecordUpdateDate : cast.toDate(record[8],"yyyy-MM-dd"),
	RecordUpdateTime : cast.toLocalTime(record[9],"HH:mm:ss"),
	IntraPNRSetNbr : cast.toNumber(record[10]),
	CDISeqNbr : cast.toNumber(record[11]),
	ResActivityCode : cast.toString(record[12])
} as Object {class: "com.airmalta.hip.tdbingester.filepojos.ResDataIndex"}