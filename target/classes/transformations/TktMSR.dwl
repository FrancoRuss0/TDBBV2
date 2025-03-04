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
	TransactionDateTime : cast.toLocalDateTime(record[5],"yyyy-MM-dd HH:mm:ss.SSSSSS"),
	MSRSeqNbr : cast.toNumber(record[6]),
	MSRQuantitySoldCount : cast.toNumber(record[7]),
	MSRTypeCode : cast.toString(record[8]),
	MSRTypeDesc : cast.toString(record[9]),
	MSRCurrencyCode : cast.toString(record[10]),
	MSRChargeAmount : cast.toNumber(record[11]),
	MSRTaxAmount : cast.toNumber(record[12]),
	MSRTaxCurrencyCode : cast.toString(record[13]),
	SourceSystemId : cast.toString(record[14]),
	OCGroupCode : cast.toString(record[15]),
	RFISubCode : cast.toString(record[16])
} as Object {class: "com.kmmaltairlines.hip.tdbingester.filepojos.TktMSR"}