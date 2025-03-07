INSERT INTO ResPassengerEmail (
    ID, PNRLocatorID, PNRCreateDate, FromDateTime, PNRPassengerEMailSeqId, 
    EMailAddress, HistoryActionCodeId, RecordUpdateDate, RecordUpdateTime, IntraPNRSetNbr, 
    PNRPassengerSeqID, tdb_created_at
) 
VALUES (
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?
);
