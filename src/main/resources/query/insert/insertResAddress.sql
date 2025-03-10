INSERT INTO ResAddress (
    ID, PNRLocatorID, PNRCreateDate, FromDateTime, AddressLine1, 
    AddressLineType_1, AddressLine2, AddressLineType_2, AddressLine3, AddressLineType_3, 
    AddressLine4, AddressLineType_4, AddressLine5, AddressLineType_5, AddressLine6, 
    AddressLineType_6, RecordUpdateDate, RecordUpdateTime, HistoryActionCodeId, ResAddressSeqID, 
    IntraPNRSetNbr, tdb_created_at
) 
VALUES (
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?,
    ?, ?
);
