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
	CreateAAACityCode : cast.toString(record[4]),
	CreationCountryCode : cast.toString(record[5]),
	GrpBookingInd : cast.toString(record[6]),
	CorporateInd : cast.toString(record[7]),
	NbrinParty : cast.toNumber(record[8]),
	TTYAirlineCode : cast.toString(record[9]),
	TTYRecordLocator : cast.toString(record[10]),
	TTYPosInformation : cast.toString(record[11]),
	SeatCount : cast.toNumber(record[12]),
	SourceSystemId : cast.toString(record[13]),
	PNRCreateTime : cast.toLocalTime(record[14],"HH:mm:ss"),
	CreateAgentSine : cast.toString(record[15]),
	NumberOfInfants : cast.toNumber(record[16]),
	ClaimIndicator : cast.toString(record[17]),
	CreateIATANr : cast.toString(record[18]),
	PurgeDate : cast.toDate(record[19],"yyyy-MM-dd"),
	MaxIntraPNRSetNbr : cast.toNumber(record[20]),
	DivideOrigPNRLocatorID : cast.toString(record[21]),
	OrigPNRCreateDate : cast.toDate(record[22],"yyyy-MM-dd"),
	OrigPNRCreateTime : cast.toLocalTime(record[23],"HH:mm:ss"),
	DivideImagePNRInd : cast.toString(record[24]),
	CreateAAAOACCityCode : cast.toString(record[25]),
	CreateAAAOACAcctCode : cast.toString(record[26]),
	OACDefaultPartitionCode : cast.toString(record[27]),
	OACCityCode : cast.toString(record[28]),
	OACAcctCode : cast.toString(record[29]),
	OACStationNbr : cast.toString(record[30]),
	CreateHomeCityCode : cast.toString(record[31]),
	CodeSharePNRInd : cast.toString(record[32]),
	MCPCarrierInd : cast.toString(record[33])
} as Object {class: "com.kmmaltairlines.hip.tdbingester.filepojos.Res"}