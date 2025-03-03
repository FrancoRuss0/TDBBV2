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
	CarClassificationCode : cast.toString(record[5]),
	CarCorporateDiscountNbr : cast.toString(record[6]),
	CarDropoffChargeAmount : cast.toString(record[7]),
	CarDropOffCurCode : cast.toString(record[8]),
	CarExtraDayRateAmount : cast.toString(record[9]),
	CarExtraHourRateAmount : cast.toString(record[10]),
	CarMileageLimit : cast.toString(record[11]),
	CarReserveUnderName : cast.toString(record[12]),
	CarTypeCode : cast.toString(record[13]),
	ConfirmationNbr : cast.toString(record[14]),
	ServiceStartCity : cast.toString(record[15]),
	ServiceStartDate : cast.toDate(record[16],"yyyy-MM-dd"),
	ServiceStartTime : cast.toLocalTime(record[17],"HH:mm:ss"),
	CurrentSegmentStatusCode : cast.toString(record[18]),
	UnitsBookedCount : cast.toNumber(record[19]),
	DaysRentedCount : cast.toNumber(record[20]),
	VendorCarCode : cast.toString(record[21]),
	RentalRate : cast.toString(record[22]),
	CurrencyCode : cast.toString(record[23]),
	RatePlanCode : cast.toString(record[24]),
	NonAirportLocationDescript : cast.toString(record[25]),
	ProductNonstdEndLocationText : cast.toString(record[26]),
	HistoryActionCodeId : cast.toString(record[27]),
	RecordUpdateDate : cast.toDate(record[28],"yyyy-MM-dd"),
	RecordUpdateTime : cast.toLocalTime(record[29],"HH:mm:ss"),
	IntraPNRSetNbr : cast.toNumber(record[30])
} as Object {class: "com.airmalta.hip.tdbingester.filepojos.ResCar"}