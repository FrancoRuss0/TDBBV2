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
	PaymentSeqNbr : cast.toNumber(record[6]),
	FOPCode : cast.toString(record[7]),
	PaymentAmt : cast.toNumber(record[8]),
	PaymentVendorCode : cast.toString(record[9]),
	AcctNbr : cast.toString(record[10]),
	PaymentCurrCode : cast.toString(record[11]),
	PaymentRemarks : cast.toString(record[12]),
	PaymentApprovalCode : cast.toString(record[13]),
	PaymentApprovalTypeCode : cast.toString(record[14])
} as Object {class: "com.kmmaltairlines.hip.tdbingester.filepojos.TktPayment"}