INSERT INTO ResODFlight (
    ID, PNRLocatorID, PNRCreateDate, FromDateTime, SegmentNbr, 
    AirlineOrigTerminal, AirlineDestTerminal, TravelerOrigTerminal, TravelerDestTerminal, AirlineOrigCntry, 
    AirlineDestCntry, TravelerOrigCntry, TravelerDestCntry, tdb_created_at
) 
VALUES (
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?,
    ?, ?, ?, ?
);
