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
	SegmentNbr : cast.toNumber(record[4]),
	AirlineOrigTerminal : cast.toString(record[5]),
	AirlineDestTerminal : cast.toString(record[6]),
	TravelerOrigTerminal : cast.toString(record[7]),
	TravelerDestTerminal : cast.toString(record[8]),
	AirlineOrigCntry : cast.toString(record[9]),
	AirlineDestCntry : cast.toString(record[10]),
	TravelerOrigCntry : cast.toString(record[11]),
	TravelerDestCntry : cast.toString(record[12])
} as Object {class: "com.airmalta.hip.tdbingester.filepojos.ResODFlight"}