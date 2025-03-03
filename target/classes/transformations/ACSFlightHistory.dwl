%dw 2.0
output application/java
var cast = readUrl("classpath://CastingFunctions.dwl", "application/dw")
---
(data) -> data map (record,index) -> 
{
	SourceSystemID : cast.toString(record[0]),
	ACSFltSegDate : cast.toDate(record[1],"yyyy-MM-dd"),
	AirlineCode : cast.toString(record[2]),
	FltNbr : cast.toString(record[3]),
	AirlineOrigAirport : cast.toString(record[4]),
	AirlineDestAirport : cast.toString(record[5]),
	SchdServiceStartTime : cast.toLocalTime(record[6],"HH:mm:ss"),
	AAACityCode : cast.toString(record[7]),
	AgentSine : cast.toString(record[8]),
	ActionDate : cast.toDate(record[9],"yyyy-MM-dd"),
	ActionTime : cast.toLocalTime(record[10],"HH:mm:ss"),
	AgntStationLNIATA : cast.toString(record[11]),
	ActionItem : cast.toString(record[12]),
	AgntDtyCd : cast.toString(record[13]),
	AgntHomeStation : cast.toString(record[14]),
	MsgCreateDateTime : cast.toLocalDateTime(record[15],"yyyy-MM-dd HH:mm:ss")
} as Object {class: "com.airmalta.hip.tdbingester.filepojos.ACSFlightHistory"}