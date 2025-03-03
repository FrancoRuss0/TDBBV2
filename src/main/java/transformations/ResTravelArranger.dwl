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
	SignatureType : cast.toString(record[4]),
	UpdateAAACityCode : cast.toString(record[5]),
	UpdateAgentDutyCode : cast.toString(record[6]),
	UpdateAgentSine : cast.toString(record[7]),
	UpdateBookingCRSCode : cast.toString(record[8]),
	UpdateHomeCityCode : cast.toString(record[9]),
	RecordUpdateDate : cast.toDate(record[10],"yyyy-MM-dd"),
	RecordUpdateTime : cast.toLocalTime(record[11],"HH:mm:ss"),
	IntraPNRSetNbr : cast.toNumber(record[12]),
	ReceivedFrom : cast.toString(record[13]),
	UpdateAAAOACCityCode : cast.toString(record[14]),
	UpdateAAAOACAcctCode : cast.toString(record[15]),
	OACDefaultPartitionCode : cast.toString(record[16]),
	OACCityCode : cast.toString(record[17]),
	OACAcctCode : cast.toString(record[18]),
	OACStationNbr : cast.toString(record[19])
} as Object {class: "com.airmalta.hip.tdbingester.filepojos.ResTravelArranger"}