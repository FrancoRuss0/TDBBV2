INSERT INTO PreResSeat (
    ID, PNRLocatorID, PNRCreateDate, FromDateTime, PNRPassengerSeqId, 
    PRSSeqNbr, VendorCode, PRSFlightNumber, PRSCompartmentNbr, PRSRowNbr, 
    PRSLetter, PRSCurrentStatusCode, SmokingSeatIndicator, NonSmokingSeatIndicator, WindowSeatIndicator, 
    AisleSeatIndicator, LeftSideSeatIndicator, ExitSeatIndicator, RightSideSeatIndicator, BulkheadSeatIndicator, 
    UpperCompartmentSeatIndicator, OverWingSeatIndicator, HistoryActionCodeId, RecordUpdateDate, RecordUpdateTime, 
    IntraPNRSetNbr, tdb_created_at
) 
VALUES (
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?,
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?
);
