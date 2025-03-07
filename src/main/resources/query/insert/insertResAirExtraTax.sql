INSERT INTO ResAirExtraTax (
	ID, PNRLocatorID, PNRCreateDate, FromDateTime, AETaxSeqNbr, 
	PNRPassengerSeqId, RFISubCode, TaxCode, TaxAmount, RecordUpdateDate, 
	RecordUpdateTime, IntraPNRSetNbr, tdb_created_at)
VALUES
(
	?, ?, ?, ?, ?, 
	?, ?, ?, ?, ?, 
	?, ?, ?
	);
