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
	PNRPassengerSeqID : cast.toNumber(record[4]),
	ResArrSequenceId : cast.toNumber(record[5]),
	ResArrQueuePlaceDate : cast.toDate(record[6],"yyyy-MM-dd"),
	ResArrQueueName : cast.toString(record[7]),
	ResArrangementLocationCode : cast.toString(record[8]),
	ArrPassengerReferenceName : cast.toString(record[9]),
	ArrActivityDate : cast.toDate(record[10],"yyyy-MM-dd"),
	ArrActivityTime : cast.toLocalTime(record[11],"HH:mm:ss"),
	ArrDutyCode : cast.toString(record[12]),
	ArrSine : cast.toString(record[13]),
	SSRText : cast.toString(record[14]),
	SSRCode : cast.toString(record[15]),
	SourceTypeCode : cast.toString(record[16]),
	SSRIdTypeCode : cast.toString(record[17]),
	ResArrActionCode : cast.toString(record[18]),
	ServiceStartCityCode : cast.toString(record[19]),
	ServiceEndCityCode : cast.toString(record[20]),
	TicketNbr : cast.toString(record[21]),
	SSRNbrInParty : cast.toNumber(record[22]),
	SSRStartDate : cast.toDate(record[23],"yyyy-MM-dd"),
	SSRFlightNumber : cast.toString(record[24]),
	ClassOfService : cast.toString(record[25]),
	VendorCode : cast.toString(record[26]),
	SSRStatusCode : cast.toString(record[27]),
	HistoryActionCodeId : cast.toString(record[28]),
	RecordUpdateDate : cast.toDate(record[29],"yyyy-MM-dd"),
	RecordUpdateTime : cast.toLocalTime(record[30],"HH:mm:ss"),
	IntraPNRSetNbr : cast.toNumber(record[31])
} as Object {class: "com.kmmaltairlines.hip.tdbingester.filepojos.ResSuspDocAgmt"}