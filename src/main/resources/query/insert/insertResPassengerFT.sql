INSERT INTO ResPassengerFT (
    ID, PNRLocatorID, PNRCreateDate, FromDateTime, PNRPassengerFTSeqId, 
    PNRPassengerSeqId, SourceTypeCode, ClassOfService, FrequentTravelerNbr, FTText, 
    FTCurrentStatusCode, FTFlightNumber, ReceivingCarrierCode, ServiceStartCityCode, ServiceEndCityCode, 
    SSRCode, SSRIdTypeCode, SSRNbrInParty, VendorCode, HistoryActionCodeId, 
    RecordUpdateDate, RecordUpdateTime, IntraPNRSetNbr, tdb_created_at
) 
VALUES (
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?
);

