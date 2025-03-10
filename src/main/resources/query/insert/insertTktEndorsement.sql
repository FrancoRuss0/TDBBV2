INSERT INTO TktEndorsement (
	ID, PNRLocatorID, PNRCreateDate, PrimaryDocNbr, VCRCreateDate, 
	TransactionDateTime, EndSeqNbr, Endorsements, tdb_created_at)
VALUES
(
	?, ?, ?, ?, ?,
	?, ?, ?, ?
);