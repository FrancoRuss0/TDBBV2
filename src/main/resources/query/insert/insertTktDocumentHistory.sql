INSERT INTO TktDocumentHistory (
	ID, PNRLocatorID, PNRCreateDate, PrimaryDocNbr, VCRCreateDate, 
	TransactionDateTime, HistorySeqNbr, HistoryCd, AAACityCode, HomeCityCode, 
	AgentDutyCode, AgentSine, LastUpdate, LastUpdateSysTime, PreviousPNRLocatorId, 
	CPNBitMap, NewPNRLocatorID, AirlineAccountingCode, DocNbr, UpdateCRSCode, 
	UpdateAirlineCode, PurgeDueToAging, PurgeRequestByTCN, Day7Purge, InputMsg, 
	RemarkTxt, OACDefaultPartitionCode, OACCityCode, OACAcctCode, OACStationNbr, 
	tdb_created_at)
VALUES
(
	?, ?, ?, ?, ?,
	?, ?, ?, ?, ?,
	?, ?, ?, ?, ?,
	?, ?, ?, ?, ?,
	?, ?, ?, ?, ?,
	?, ?, ?, ?, ?,
	?
);