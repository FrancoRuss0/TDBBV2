INSERT INTO ResCar (
    ID, PNRLocatorID, PNRCreateDate, FromDateTime, SegmentNbr, 
    CarClassificationCode, CarCorporateDiscountNbr, CarDropoffChargeAmount, CarDropOffCurCode, CarExtraDayRateAmount, 
    CarExtraHourRateAmount, CarMileageLimit, CarReserveUnderName, CarTypeCode, ConfirmationNbr, 
    ServiceStartCity, ServiceStartDate, ServiceStartTime, CurrentSegmentStatusCode, UnitsBookedCount, 
    DaysRentedCount, VendorCarCode, RentalRate, CurrencyCode, RatePlanCode, 
    NonAirportLocationDescript, ProductNonstdEndLocationText, HistoryActionCodeId, RecordUpdateDate, RecordUpdateTime, 
    IntraPNRSetNbr, tdb_created_at
) 
VALUES (
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ? 
);
