%dw 2.0
output application/java
var cast = readUrl("classpath://CastingFunctions.dwl", "application/dw")
---
(data) -> data map (record,index) -> 
{
	SourceSystemID : cast.toString(record[0]),
	PNRLocatorId : cast.toString(record[1]),
	PNRCreateDate : cast.toDate(record[2],"yyyy-MM-dd"),
	ResPaxId : cast.toNumber(record[3]),
	AirlineCode : cast.toString(record[4]),
	FltNbr : cast.toString(record[5]),
	ServiceStartDate : cast.toDate(record[6],"yyyy-MM-dd"),
	AirlineOrigAirport : cast.toString(record[7]),
	CabinCode : cast.toString(record[8]),
	SeatRowNbr : cast.toString(record[9]),
	SeatLtr : cast.toString(record[10]),
	PreResSeatInd : cast.toString(record[11]),
	JumpSeatTypeCode : cast.toString(record[12]),
	JumpSeatRowNbr : cast.toString(record[13]),
	JumpSeatLtr : cast.toString(record[14]),
	PaidUpgradeACAmt : cast.toNumber(record[15]),
	InventoryUpgradeInd : cast.toString(record[16]),
	DowngradeInd : cast.toString(record[17]),
	UpgradeInd : cast.toString(record[18]),
	CoachUpgradeInd : cast.toString(record[19]),
	BusinessUpgradeInd : cast.toString(record[20]),
	MsgCreateDateTime : cast.toLocalDateTime(record[21],"yyyy-MM-dd HH:mm:ss")
} as Object {class: "com.airmalta.hip.tdbingester.filepojos.ACSPaxSeat"}