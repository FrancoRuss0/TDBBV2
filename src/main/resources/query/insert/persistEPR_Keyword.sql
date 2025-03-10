MERGE EPR_keyword AS target
USING (SELECT ? PCC_Cd, ? User_Id, ? Keyword, ? RecordStatus, ? EffectiveDate) AS source ON
(source.PCC_Cd = target.PCC_Cd) and
(source.User_Id = target.User_Id) and
((source.Keyword = target.Keyword)  or (source.Keyword is null and target.Keyword is null)) and
(source.EffectiveDate = target.EffectiveDate)
WHEN MATCHED THEN UPDATE SET
target.RecordStatus = source.RecordStatus
WHEN NOT MATCHED THEN INSERT (PCC_Cd, User_Id, Keyword, RecordStatus, EffectiveDate, tdb_created_at)
VALUES
(?, ?, ?, ?, ?, ?);