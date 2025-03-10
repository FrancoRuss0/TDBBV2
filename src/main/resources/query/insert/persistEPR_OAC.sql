MERGE EPR_OAC AS target
USING (SELECT ? PCC_Cd, ? User_Id, ? Default_Ticketing_Carrier, ? Personal_City_Code, ? Personal_Account_Code, ? Station_Code, ? RecordStatus, ? EffectiveDate) AS source ON
(source.PCC_Cd = target.PCC_Cd) and
(source.User_Id = target.User_Id) and
((source.Default_Ticketing_Carrier = target.Default_Ticketing_Carrier)  or (source.Default_Ticketing_Carrier is null and target.Default_Ticketing_Carrier is null)) and
((source.Personal_City_Code = target.Personal_City_Code)  or (source.Personal_City_Code is null and target.Personal_City_Code is null)) and
((source.Personal_Account_Code = target.Personal_Account_Code)  or (source.Personal_Account_Code is null and target.Personal_Account_Code is null)) and
((source.Station_Code = target.Station_Code)  or (source.Station_Code is null and target.Station_Code is null)) and
(source.EffectiveDate = target.EffectiveDate)
WHEN MATCHED THEN UPDATE SET
target.RecordStatus = source.RecordStatus
WHEN NOT MATCHED THEN INSERT (PCC_Cd, User_Id, Default_Ticketing_Carrier, Personal_City_Code, Personal_Account_Code, Station_Code, RecordStatus, EffectiveDate, tdb_created_at)
VALUES
(?, ?, ?, ?, ?, ?, ?, ?, ?);