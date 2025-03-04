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
	ServiceCityCode : cast.toString(record[5]),
	ServiceStartDate : cast.toDate(record[6],"yyyy-MM-dd"),
	NbrofNightsCount : cast.toNumber(record[7]),
	UnitsBookedCount : cast.toNumber(record[8]),
	CurrentSegmentStatusCode : cast.toString(record[9]),
	SegmentTypeCode : cast.toNumber(record[10]),
	PropertyCode : cast.toString(record[11]),
	PropertyName : cast.toString(record[12]),
	VendorHotelCode : cast.toString(record[13]),
	HotelRoomTypeCode : cast.toString(record[14]),
	HotelRoomRate : cast.toString(record[15]),
	HotelRateCode : cast.toString(record[16]),
	CurrencyCode : cast.toString(record[17]),
	HotelProductCode : cast.toString(record[18]),
	ConfirmationNbr : cast.toString(record[19]),
	HotelReserveUnderName : cast.toString(record[20]),
	HotelCorporateDiscountNbr : cast.toString(record[21]),
	HotelExtraPersonRateAmount : cast.toString(record[22]),
	HotelExtraPersonCount : cast.toNumber(record[23]),
	NumberOfAdults : cast.toNumber(record[24]),
	HistoryActionCodeId : cast.toString(record[25]),
	RecordUpdateDate : cast.toDate(record[26],"yyyy-MM-dd"),
	RecordUpdateTime : cast.toLocalTime(record[27],"HH:mm:ss"),
	IntraPNRSetNbr : cast.toNumber(record[28])
} as Object {class: "com.kmmaltairlines.hip.tdbingester.filepojos.ResHotel"}