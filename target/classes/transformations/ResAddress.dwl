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
	AddressLine1 : cast.toString(record[4]),
	AddressLineType_1 : cast.toString(record[5]),
	AddressLine2 : cast.toString(record[6]),
	AddressLineType_2 : cast.toString(record[7]),
	AddressLine3 : cast.toString(record[8]),
	AddressLineType_3 : cast.toString(record[9]),
	AddressLine4 : cast.toString(record[10]),
	AddressLineType_4 : cast.toString(record[11]),
	AddressLine5 : cast.toString(record[12]),
	AddressLineType_5 : cast.toString(record[13]),
	AddressLine6 : cast.toString(record[14]),
	AddressLineType_6 : cast.toString(record[15]),
	RecordUpdateDate : cast.toDate(record[16],"yyyy-MM-dd"),
	RecordUpdateTime : cast.toLocalTime(record[17],"HH:mm:ss"),
	HistoryActionCodeId : cast.toString(record[18]),
	ResAddressSeqID : cast.toNumber(record[19]),
	IntraPNRSetNbr : cast.toNumber(record[20])
} as Object {class: "com.kmmaltairlines.hip.tdbingester.filepojos.ResAddress"}