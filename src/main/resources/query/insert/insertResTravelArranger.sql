INSERT INTO ResTravelArranger (
    ID, PNRLocatorID, PNRCreateDate, FromDateTime, SignatureType, 
    UpdateAAACityCode, UpdateAgentDutyCode, UpdateAgentSine, UpdateBookingCRSCode, UpdateHomeCityCode, 
    RecordUpdateDate, RecordUpdateTime, IntraPNRSetNbr, ReceivedFrom, UpdateAAAOACCityCode, 
    UpdateAAAOACAcctCode, OACDefaultPartitionCode, OACCityCode, OACAcctCode, OACStationNbr, 
    tdb_created_at
) 
VALUES (
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?,  
    ?, ?, ?, ?, ?,
    ?
);
