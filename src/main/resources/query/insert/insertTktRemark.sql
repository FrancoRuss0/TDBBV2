INSERT INTO TktRemark (
	ID, PNRLocatorID, PNRCreateDate, PrimaryDocNbr, VCRCreateDate, 
	TransactionDateTime, RemarkSeqNbr, RemarkTxt, tdb_created_at)
VALUES
(
	?, ?, ?, ?, ?,
	?, ?, ?, ?
	);