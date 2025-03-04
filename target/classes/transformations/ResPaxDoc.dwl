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
	PassengerDocSeqId : cast.toNumber(record[4]),
	PNRPassengerSeqId : cast.toNumber(record[5]),
	DocBirthdate : cast.toDate(record[6],"yyyy-MM-dd"),
	DocNumber : cast.toString(record[7]),
	DocTypeCode : cast.toString(record[8]),
	GenderCode : cast.toString(record[9]),
	InfantInd : cast.toString(record[10]),
	IssueCountryCode : cast.toString(record[11]),
	PassengerFirstName : cast.toString(record[12]),
	PassengerSecondName : cast.toString(record[13]),
	PassengerLastName : cast.toString(record[14]),
	PrimaryDocHolderInd : cast.toString(record[15]),
	PrimaryDocHolderFirstName : cast.toString(record[16]),
	PrimaryDocHolderLastName : cast.toString(record[17]),
	SourceTypeCode : cast.toString(record[18]),
	SSRCode : cast.toString(record[19]),
	SSRIdTypeCode : cast.toString(record[20]),
	SSRNumberInParty : cast.toNumber(record[21]),
	SSRStatusCode : cast.toString(record[22]),
	SSRText : cast.toString(record[23]),
	VendorCode : cast.toString(record[24]),
	HistoryActionCodeId : cast.toString(record[25]),
	RecordUpdateDate : cast.toDate(record[26],"yyyy-MM-dd"),
	RecordUpdateTime : cast.toLocalTime(record[27],"HH:mm:ss"),
	IntraPNRSetNbr : cast.toNumber(record[28]),
	DocIssueDate : cast.toDate(record[29],"yyyy-MM-dd"),
	DocExpDate : cast.toDate(record[30],"yyyy-MM-dd")
} as Object {class: "com.kmmaltairlines.hip.tdbingester.filepojos.ResPaxDoc"}