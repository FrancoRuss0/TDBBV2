%dw 2.0
output application/java
var cast = readUrl("classpath://CastingFunctions.dwl", "application/dw")
---
(data) -> data map (record,index) -> 
{
	ID : cast.toString(record[0]),
	PNRLocatorID : cast.toString(record[1]),
	PNRCreateDate : cast.toDate(record[2],"yyyy-MM-dd"),
	PrimaryDocNbr : cast.toString(record[3]),
	VCRCreateDate : cast.toDate(record[4],"yyyy-MM-dd"),
	TransactionDateTime : if (cast.toLocalDateTime(record[5],"yyyy-MM-dd HH:mm:ss.SSSSSS") == null) now() else cast.toLocalDateTime(record[5],"yyyy-MM-dd HH:mm:ss.SSSSSS"),
	HistorySeqNbr : cast.toNumber(record[6]),
	HistoryCd : cast.toString(record[7]),
	AAACityCode : cast.toString(record[8]),
	HomeCityCode : cast.toString(record[9]),
	AgentDutyCode : cast.toString(record[10]),
	AgentSine : cast.toString(record[11]),
	LastUpdate : cast.toDate(record[12],"yyyy-MM-dd"),
	LastUpdateSysTime : cast.toLocalTime(record[13],"HH:mm:ss.SSSSSS"),
	PreviousPNRLocatorId : cast.toString(record[14]),
	CPNBitMap : cast.toString(record[15]),
	NewPNRLocatorID : cast.toString(record[16]),
	AirlineAccountingCode : cast.toString(record[17]),
	DocNbr : cast.toString(record[18]),
	UpdateCRSCode : cast.toString(record[19]),
	UpdateAirlineCode : cast.toString(record[20]),
	PurgeDueToAging : cast.toNumber(record[21]),
	PurgeRequestByTCN : cast.toNumber(record[22]),
	Day7Purge : cast.toNumber(record[23]),
	InputMsg : cast.toString(record[24]),
	RemarkTxt : cast.toString(record[25]),
	OACDefaultPartitionCode : cast.toString(record[26]),
	OACCityCode : cast.toString(record[27]),
	OACAcctCode : cast.toString(record[28]),
	OACStationNbr : cast.toString(record[29])
} as Object {class: "com.kmmaltairlines.hip.tdbingester.filepojos.TktDocumentHistory"}