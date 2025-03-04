%dw 2.0
output application/java
var cast = readUrl("classpath://CastingFunctions.dwl", "application/dw")
---
(data) -> data map (record,index) -> 
{
	ID : cast.toString(record[0]),
	PrimaryDocNbr : cast.toString(record[1]),
	VCRCreateDate : cast.toDate(record[2],"yyyy-MM-dd"),
	TransactionDateTime : cast.toLocalDateTime(record[3],"yyyy-MM-dd HH:mm:ss.SSSSSS"),
	SourceSystemId : cast.toString(record[4]),
	FeeSequenceNbr : cast.toNumber(record[5]),
	FeeTypeCd : cast.toString(record[6]),
	FeeCatCd : cast.toString(record[7]),
	FeeCurrCd : cast.toString(record[8]),
	FeeAmt : cast.toNumber(record[9]),
	FeeAmtUSD : cast.toNumber(record[10]),
	ApplyCreditInd : cast.toString(record[11]),
	FeeSubCategory : cast.toString(record[12]),
	FeeWaivedInd : cast.toString(record[13]),
	FeeDescription : cast.toString(record[14]),
	FeePriceCd : cast.toString(record[15]),
	FeeWaiverCd : cast.toString(record[16])
} as Object {class: "com.kmmaltairlines.hip.tdbingester.filepojos.TKTFees"}