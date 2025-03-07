INSERT INTO ResRemarks (
    ID, PNRLocatorID, PNRCreateDate, FromDateTime, ResRemarkSeqId, 
    RemarkText, RemarkType, HistoryActionCodeId, RecordUpdateDate, RecordUpdateTime, 
    IntraPNRSetNbr, tdb_created_at
) 
VALUES (
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?,
    ?, ?
);
