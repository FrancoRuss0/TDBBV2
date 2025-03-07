INSERT INTO Res (
    ID, PNRLocatorID, PNRCreateDate, FromDateTime, CreateAAACityCode, 
    CreationCountryCode, GrpBookingInd, CorporateInd, NbrinParty, TTYAirlineCode, 
    TTYRecordLocator, TTYPosInformation, SeatCount, SourceSystemId, PNRCreateTime, 
    CreateAgentSine, NumberOfInfants, ClaimIndicator, CreateIATANr, PurgeDate, 
    MaxIntraPNRSetNbr, DivideOrigPNRLocatorID, OrigPNRCreateDate, OrigPNRCreateTime, DivideImagePNRInd, 
    CreateAAAOACCityCode, CreateAAAOACAcctCode, OACDefaultPartitionCode, 
    OACCityCode, OACAcctCode, OACStationNbr, CreateHomeCityCode, CodeSharePNRInd, 
    MCPCarrierInd, tdb_created_at
) 
VALUES (
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?,
    ?, ?
);
