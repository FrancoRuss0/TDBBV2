INSERT INTO ResPassenger (
    ID, PNRLocatorID, PNRCreateDate, FromDateTime, PNRPassengerSeqId, 
    NameFirst, NameLast, NameComment, RelativePassengerNbr, HistoryActionCodeId, 
    RecordUpdateDate, RecordUpdateTime, IntraPNRSetNbr, tdb_created_at
) 
VALUES (
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?
);
