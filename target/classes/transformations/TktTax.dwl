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
	TaxSeqNbr : cast.toNumber(record[6]),
	TaxAmt : cast.toNumber(record[7]),
	TaxCode : cast.toString(record[8]),
	TaxTypeCode : cast.toString(record[9]),
	TaxCategoryCode : cast.toString(record[10]),
	TaxCurrCode : cast.toString(record[11])
} as Object {class: "com.kmmaltairlines.hip.tdbingester.filepojos.TktTax"}