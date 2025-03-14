SELECT PrimaryDocNbr, VCRCreateDate, AddlExchgTktData, FileTransactionDateTime, DBTransactionDateTime FROM (
    SELECT TktDocument_Temp.PrimaryDocNbr,
            TktDocument_Temp.VCRCreateDate, 
            TktDocument_Temp.AddlExchgTktData, 
            TktDocument_Temp.TransactionDateTime as FileTransactionDateTime,
            TktDocument.TransactionDateTime as DBTransactionDateTime
    FROM TktDocument_Temp
    LEFT JOIN TktDocument
    ON TktDocument_Temp.PrimaryDocNbr = TktDocument.PrimaryDocNbr
    AND TktDocument_Temp.VCRCreateDate = TktDocument.VCRCreateDate
) as ComparedRecords 
-- updated records
WHERE 
(ComparedRecords.FileTransactionDateTime >= ComparedRecords.DBTransactionDateTime)
-- new records
OR (ComparedRecords.DBTransactionDateTime IS NULL)