INSERT INTO ResEmergencyCtc (
    ID, PNRLocatorID, PNRCreateDate, FromDateTime, PNRPassengerSeqId, 
    SourceTypeCode, SSRIdTypeCode, SSRStatusCode, SSRCode, EmergencyContactSeqId, 
    EmergencyPhoneNumber, EmergencyContactName, CountryCode, VendorCode, SSRText, 
    HistoryActionCodeId, RecordUpdateDate, RecordUpdateTime, IntraPNRSetNbr, tdb_created_at
) 
VALUES (
    ?, ?, ?, ?, ?,  
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?
);
