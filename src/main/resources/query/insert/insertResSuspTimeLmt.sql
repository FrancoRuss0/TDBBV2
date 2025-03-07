INSERT INTO ResSuspTimeLmt (
    ID, PNRLocatorID, PNRCreateDate, FromDateTime, SuspenseSequenceId, 
    TimeLimitActionTime, TimeLimitActionDate, TimeLimitLocationCode, TimeLimitVendorCode, HistoryActionCodeId, 
    RecordUpdateDate, RecordUpdateTime, IntraPNRSetNbr, tdb_created_at
) 
VALUES (
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?
);
