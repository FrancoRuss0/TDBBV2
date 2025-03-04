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
	CouponSeqNbr : cast.toNumber(record[6]),
	CouponDistanceKm : cast.toNumber(record[7]),
	CouponDistanceMi : cast.toNumber(record[8]),
	ProrationFactor : cast.toNumber(record[9]),
	ProrateBaseFareUSD : cast.toNumber(record[10]),
	ProrateTotalDocAmtUSD : cast.toNumber(record[11]),
	EquivBaseFareCurrCode : cast.toString(record[12]),
	EquivUSDExchgRate : cast.toNumber(record[13]),
	ProrateEquivBaseFareAmt : cast.toNumber(record[14]),
	ProrateEquivTotalDocAmt : cast.toNumber(record[15]),
	OwnerCurrencyCode : cast.toString(record[16]),
	ProrateBaseFareOwnerAmt : cast.toNumber(record[17]),
	ProrateTotalDocOwnerAmt : cast.toNumber(record[18])
} as Object {class: "com.kmmaltairlines.hip.tdbingester.filepojos.TktProRation"}