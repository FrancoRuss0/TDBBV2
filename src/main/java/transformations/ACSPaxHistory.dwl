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
	PNRLocatorId : cast.toString(record[5]),
	NameLast : cast.toString(record[6]),
	NameFirst : cast.toString(record[7]),
	AirlineDestAirport : cast.toString(record[8]),
	SchdServiceStartDate : cast.toDate(record[9],"yyyy-MM-dd"),
	SchdServiceStartTime : cast.toLocalTime(record[10],"HH:mm:ss"),
	AAACityCode : cast.toString(record[11]),
	AgentSine : cast.toString(record[12]),
	ActionDate : cast.toDate(record[13],"yyyy-MM-dd"),
	ActionTime : cast.toLocalTime(record[14],"HH:mm:ss"),
	AgntStationLNIATA : cast.toString(record[15]),
	ActionItem : cast.toString(record[16]),
	SeatLtr : cast.toString(record[17]),
	SeatNbr : cast.toString(record[18]),
	NbrOfBags : cast.toString(record[19]),
	EditCode : cast.toString(record[20]),
	AgntDtyCd : cast.toString(record[21]),
	AgntHomeStation : cast.toString(record[22]),
	PaxID : cast.toNumber(record[23]),
	ItinID : cast.toNumber(record[24]),
	PrevSeatNbr : cast.toString(record[25]),
	PrevSeatLtr : cast.toString(record[26]),
	OnBoardStatus : cast.toString(record[27]),
	BPIssueStatus : cast.toString(record[28]),
	BPReprintedStatus : cast.toString(record[29]),
	BagTagInd : cast.toString(record[30]),
	MsgCreateDateTime : cast.toLocalDateTime(record[31],"yyyy-MM-dd HH:mm:ss"),
	Prev_BagTagInd : cast.toString(record[32]),
	Prev_OnBoardStatus : cast.toString(record[33]),
	Prev_BPIssueStatus : cast.toString(record[34]),
	Prev_BPReprintedStatus : cast.toString(record[35])
} as Object {class: "com.kmmaltairlines.hip.tdbingester.filepojos.ACSPaxHistory"}