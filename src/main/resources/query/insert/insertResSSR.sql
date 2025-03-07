INSERT INTO ResSSR (
    ID, PNRLocatorID, PNRCreateDate, FromDateTime, ResSSRSeqId, 
    PNRPassengerSeqId, SourceTypeCode, SSRIdTypeCode, SSRStatusCode, SSRFlightNumber, 
    SSRNbrInParty, SSRStartDate, VendorCode, SSRCode, SSRText, 
    ClassOfService, ServiceStartCityCode, ServiceEndCityCode, HistoryActionCodeId, RecordUpdateDate, 
    RecordUpdateTime, IntraPNRSetNbr, tdb_created_at
) 
VALUES (
    ?, ?, ?, ?, ?,  
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?
);
