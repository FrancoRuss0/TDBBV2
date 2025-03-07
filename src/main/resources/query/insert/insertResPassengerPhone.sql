INSERT INTO ResPassengerPhone (
    ID, PNRLocatorID, PNRCreateDate, FromDateTime, PNRPassengerPhoneSeqId, 
    CityPhoneCode, PhoneNbrText, PhoneTypeCode, HistoryActionCodeId, RecordUpdateDate, 
    RecordUpdateTime, IntraPNRSetNbr, tdb_created_at
) 
VALUES (
    ?, ?, ?, ?, ?,  
    ?, ?, ?, ?, ?, 
    ?, ?, ?
);
