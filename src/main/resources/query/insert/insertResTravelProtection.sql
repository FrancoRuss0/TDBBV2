INSERT INTO ResTravelProtection (
    ID, PNRLocatorID, PNRCreateDate, FromDateTime, SegmentNbr, 
    PlanTypeCode, VendorCode, PurchaseDate, SegmentType, ConfirmationNbr, 
    CurrentSegmentStatusCode, ServiceStartDate, ServiceEndDate, ServiceStartCityCode, ServiceEndCityCode, 
    FOPCode, PaymentCreditCardCode, PaymentCreditCardNbr, PaymentCreditCardExpDate, CurrCode, 
    PremiumValue, PremiumAmt, PremiumAmtUSD, RecordUpdateDate, RecordUpdateTime, 
    HistoryActionCodeID, IntraPNRSetNbr, tdb_created_at
) 
VALUES (
    ?, ?, ?, ?, ?,   
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?,
    ?, ?, ?, ?, ?,
    ?, ?, ?, ?, ?,
    ?, ?, ?
);
