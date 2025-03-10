INSERT INTO ResPaxDoc (
    ID, PNRLocatorID, PNRCreateDate, FromDateTime, PassengerDocSeqId, 
    PNRPassengerSeqId, DocBirthdate, DocNumber, DocTypeCode, GenderCode, 
    InfantInd, IssueCountryCode, PassengerFirstName, PassengerSecondName, PassengerLastName, 
    PrimaryDocHolderInd, PrimaryDocHolderFirstName, PrimaryDocHolderLastName, SourceTypeCode, SSRCode, 
    SSRIdTypeCode, SSRNumberInParty, SSRStatusCode, SSRText, VendorCode, 
    HistoryActionCodeId, RecordUpdateDate, RecordUpdateTime, IntraPNRSetNbr, DocIssueDate, 
    DocExpDate, tdb_created_at
) 
VALUES (
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?, ?,
    ?, ?, ?, ?, ?,
    ?, ?
);
