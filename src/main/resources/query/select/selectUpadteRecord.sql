SELECT PNRLocatorID, PNRCreateDate, FileFromDateTime, DBFromDateTime FROM (
	SELECT Res_Temp.PNRLocatorID, Res_Temp.PNRCreateDate, Res_Temp.FromDateTime as FileFromDateTime, Res.FromDateTime as DBFromDateTime
	FROM Res_Temp
	LEFT JOIN Res 
	ON Res_Temp.PNRLocatorID = Res.PNRLocatorID
	AND Res_Temp.PNRCreateDate = Res.PNRCreateDate
	) AS ComparedRecords
WHERE 
(ComparedRecords.FileFromDateTime >= ComparedRecords.DBFromDateTime)
OR (ComparedRecords.DBFromDateTime IS NULL)