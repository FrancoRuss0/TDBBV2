INSERT INTO ResDataIndex (
    ID, PNRLocatorID, PNRCreateDate, FromDateTime, NameAssociationID, 
    ProfileType, ProfileValue, SourceSystemId, RecordUpdateDate, RecordUpdateTime, 
    IntraPNRSetNbr, CDISeqNbr, ResActivityCode, tdb_created_at
) 
VALUES (
    ?, ?, ?, ?, ?,  
    ?, ?, ?, ?, ?, 
    ?, ?, ?, ?
);
