INSERT INTO ResHotel (
    ID, PNRLocatorID, PNRCreateDate, FromDateTime, SegmentNbr, 
    ServiceCityCode, ServiceStartDate, NbrofNightsCount, UnitsBookedCount, CurrentSegmentStatusCode, 
    SegmentTypeCode, PropertyCode, PropertyName, VendorHotelCode, HotelRoomTypeCode, 
    HotelRoomRate, HotelRateCode, CurrencyCode, HotelProductCode, ConfirmationNbr, 
    HotelReserveUnderName, HotelCorporateDiscountNbr, HotelExtraPersonRateAmount, HotelExtraPersonCount, NumberOfAdults, 
    HistoryActionCodeId, RecordUpdateDate, RecordUpdateTime, IntraPNRSetNbr, tdb_created_at
) 
VALUES (
    ?, ?, ?, ?, ?,  
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?
);
