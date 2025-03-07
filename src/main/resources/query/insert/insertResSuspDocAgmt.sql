INSERT INTO ResSuspDocAgmt (
     ID, PNRLocatorID, PNRCreateDate, FromDateTime, PNRPassengerSeqID, 
    ResArrSequenceId, ResArrQueuePlaceDate, ResArrQueueName, ResArrangementLocationCode, ArrPassengerReferenceName, 
    ArrActivityDate, ArrActivityTime, ArrDutyCode, ArrSine, SSRText, 
    SSRCode, SourceTypeCode, SSRIdTypeCode, ResArrActionCode, ServiceStartCityCode, 
    ServiceEndCityCode, TicketNbr, SSRNbrInParty, SSRStartDate, SSRFlightNumber, 
    ClassOfService, VendorCode, SSRStatusCode, HistoryActionCodeId, RecordUpdateDate, 
    RecordUpdateTime, IntraPNRSetNbr, tdb_created_at
) 
VALUES (
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?,
    ?, ?, ?
);
