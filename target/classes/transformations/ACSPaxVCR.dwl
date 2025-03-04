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
	VCRCreateDate : cast.toDate(record[8],"yyyy-MM-dd"),
	AirlineAccountingCode : cast.toString(record[9]),
	VCRSerialNbr : cast.toString(record[10]),
	VCRCouponSeqNbr : cast.toNumber(record[11]),
	ClassofService : cast.toString(record[12]),
	FareBasisCode : cast.toString(record[13]),
	VCRInUseInd : cast.toString(record[14]),
	VCRSelectDisAssocInd : cast.toString(record[15]),
	VCRDisAssocInd : cast.toString(record[16]),
	VCRDisAssocRsn : cast.toString(record[17]),
	VCRGrabNGoInd : cast.toString(record[18]),
	CommonElecTktInd : cast.toString(record[19]),
	VCRExistInd : cast.toString(record[20]),
	MultiVCRInd : cast.toString(record[21]),
	PrevCpnStatsErrInd : cast.toString(record[22]),
	PrevCpnStatsErrOverrideInd : cast.toString(record[23]),
	InfVCRInd : cast.toString(record[24]),
	InfVCRIssueDate : cast.toDate(record[25],"yyyy-MM-dd"),
	InfVCRCreateDate : cast.toDate(record[26],"yyyy-MM-dd"),
	InfVCRCreateTime : cast.toLocalTime(record[27],"HH:mm:ss"),
	InfVCRAirlineAccountingCode : cast.toString(record[28]),
	InfVCRSerialNbr : cast.toString(record[29]),
	InfVCRCouponSeqNbr : cast.toNumber(record[30]),
	InfVCRFareBasisCode : cast.toString(record[31]),
	InfVCRClassofService : cast.toString(record[32]),
	InfVCRInUseInd : cast.toString(record[33]),
	InfCheckInComplete : cast.toString(record[34]),
	MsgCreateDateTime : cast.toLocalDateTime(record[35],"yyyy-MM-dd HH:mm:ss")
} as Object {class: "com.kmmaltairlines.hip.tdbingester.filepojos.ACSPaxVCR"}