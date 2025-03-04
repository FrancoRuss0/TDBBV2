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
	FeeOwnerCode : cast.toString(record[7]),
	OCGroupCode : cast.toString(record[8]),
	RFICode : cast.toString(record[9]),
	QuantSold : cast.toNumber(record[10]),
	RFISubCode : cast.toString(record[11]),
	CommercialName : cast.toString(record[12]),
	EMDTypeCode : cast.toString(record[13]),
	FeeGuaranteedInd : cast.toString(record[14]),
	FeeVendorCode : cast.toString(record[15]),
	SegmentUseCode : cast.toString(record[16]),
	RelPrimaryDocNbr : cast.toString(record[17]),
	RelCouponSeqNbr : cast.toNumber(record[18]),
	RelVCRCreateDate : cast.toDate(record[19],"yyyy-MM-dd")
} as Object {class: "com.kmmaltairlines.hip.tdbingester.filepojos.TktCouponEMD"}