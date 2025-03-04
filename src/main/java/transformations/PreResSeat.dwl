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
	PNRPassengerSeqId : cast.toNumber(record[4]),
	PRSSeqNbr : cast.toNumber(record[5]),
	VendorCode : cast.toString(record[6]),
	PRSFlightNumber : cast.toString(record[7]),
	PRSCompartmentNbr : cast.toNumber(record[8]),
	PRSRowNbr : cast.toNumber(record[9]),
	PRSLetter : cast.toString(record[10]),
	PRSCurrentStatusCode : cast.toString(record[11]),
	SmokingSeatIndicator : cast.toString(record[12]),
	NonSmokingSeatIndicator : cast.toString(record[13]),
	WindowSeatIndicator : cast.toString(record[14]),
	AisleSeatIndicator : cast.toString(record[15]),
	LeftSideSeatIndicator : cast.toString(record[16]),
	ExitSeatIndicator : cast.toString(record[17]),
	RightSideSeatIndicator : cast.toString(record[18]),
	BulkheadSeatIndicator : cast.toString(record[19]),
	UpperCompartmentSeatIndicator : cast.toString(record[20]),
	OverWingSeatIndicator : cast.toString(record[21]),
	HistoryActionCodeId : cast.toString(record[22]),
	RecordUpdateDate : cast.toDate(record[23],"yyyy-MM-dd"),
	RecordUpdateTime : cast.toLocalTime(record[24],"HH:mm:ss"),
	IntraPNRSetNbr : cast.toNumber(record[25])
} as Object {class: "com.kmmaltairlines.hip.tdbingester.filepojos.PreResSeat"}