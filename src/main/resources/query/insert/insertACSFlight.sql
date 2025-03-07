-- insertACSFlight.sql
INSERT INTO ACSFlight (
    SourceSystemID, AirlineCode, FltNbr, ServiceStartDate, AirlineOrigAirport, 
    AirlineDestAirport, SchdAirlineOrigAirport, SchdAirlineDestAirport, AirlineOrigGate, COGInd, 
    FltOverFlyInd, FltFlagStopInd, FltStubInd, GateReaderLNIATA, EstServiceEndDate, 
    EstServiceEndTime, EstServiceStartDate, EstServiceStartTime, SchdServiceStartDate, SchdServiceStartTime, 
    SchdServiceEndDate, SchdServiceEndTime, FltCloseDate, FltCloseTime, PDCDate, 
    PDCTime, FltLegDelayedInd, FltLegStatus, TailNbr, MsgCreateDateTime, 
    EquipmentType, AircraftConfig, TotalPaxCount, ReservedFutureUse1, ReservedFutureUse2, 
    ReservedFutureUse3, ReservedFutureUse4, ReservedFutureUse5, ReservedFutureUse6, ReservedFutureUse7, 
    ReservedFutureUse8, ReservedFutureUse9, tdb_created_at
) VALUES (
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?
);
