INSERT INTO ResFlight (
    ID, PNRLocatorId, PNRCreateDate, FromDateTime, SegmentNbr, 
    ActiveSegmentInd, CdshrLegInd, ClassOfService, ConnectivityCode, NbrInParty, 
    CurrentSegmentStatusCode, PreviousSegmentStatusCode, SegmentTypeCode, ChangeSegmentStatusIndicator, EquipmentCode, 
    MarketingFlightNbr, FlightNbr, MarketingAirlineCode, OperatingFlightNbr, OperatingAirlineCode, 
    AirlineCode, InboundFlightConnectionInd, MarriedConxInboundFlightInd, OutboundFlightConnectionInd, MarriedConxOutboundFlightInd, 
    ServiceStartCity, ServiceStartDate, ServiceStartTime, ServiceEndCity, ServiceEndDate, 
    ServiceEndTime, POSAgencyActualCityCode, EquipmentCodeDescription, PreReservedSeatIndicator, ConfirmationNbr, 
    FlightPOSAgentIATANbr, HistoryActionCodeId, RecordUpdateDate, RecordUpdateTime, IntraPNRSetNbr, 
    SegmentBookedDate, SegmentBookedTime, OpenFlightSegmentIndicator, SegmentActivityCode, BSGMSTRPNRLocatorID, 
    BSGMSTRPNRCreateDate, NewMarriedConxGroupNbr, NewMarriedConxSeqNbr, NewMarriedConxOutOfSeqInd, MarketingClassOfService, 
    OperatingClassOfService, IATAEquipCode, IATAEquipDesc, OperatingAirlnLocatorID, tdb_created_at 
) 
VALUES (
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?
);
