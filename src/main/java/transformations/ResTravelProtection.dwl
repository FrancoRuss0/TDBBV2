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
	SegmentNbr : cast.toNumber(record[4]),
	PlanTypeCode : cast.toString(record[5]),
	VendorCode : cast.toString(record[6]),
	PurchaseDate : cast.toDate(record[7],"yyyy-MM-dd"),
	SegmentType : cast.toNumber(record[8]),
	ConfirmationNbr : cast.toString(record[9]),
	CurrentSegmentStatusCode : cast.toString(record[10]),
	ServiceStartDate : cast.toDate(record[11],"yyyy-MM-dd"),
	ServiceEndDate : cast.toDate(record[12],"yyyy-MM-dd"),
	ServiceStartCityCode : cast.toString(record[13]),
	ServiceEndCityCode : cast.toString(record[14]),
	FOPCode : cast.toString(record[15]),
	PaymentCreditCardCode : cast.toString(record[16]),
	PaymentCreditCardNbr : cast.toString(record[17]),
	PaymentCreditCardExpDate : cast.toDate(record[18],"yyyy-MM-dd"),
	CurrCode : cast.toString(record[19]),
	PremiumValue : cast.toString(record[20]),
	PremiumAmt : cast.toNumber(record[21]),
	PremiumAmtUSD : cast.toNumber(record[22]),
	RecordUpdateDate : cast.toDate(record[23],"yyyy-MM-dd"),
	RecordUpdateTime : cast.toLocalTime(record[24],"HH:mm:ss"),
	HistoryActionCodeID : cast.toString(record[25]),
	IntraPNRSetNbr : cast.toNumber(record[26])
} as Object {class: "com.airmalta.hip.tdbingester.filepojos.ResTravelProtection"}