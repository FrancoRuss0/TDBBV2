INSERT INTO TktAddress (
	ID, PNRLocatorID, PNRCreateDate, PrimaryDocNbr, VCRCreateDate, 
	TransactionDateTime, AddrSeqNbr, AddrTxt, tdb_created_at
	)
VALUES
(
	?, ?, ?, ?, ?,
	?, ?, ?, ?
	);