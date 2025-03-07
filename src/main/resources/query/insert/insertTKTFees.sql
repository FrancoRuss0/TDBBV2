INSERT INTO TKTFees (
	ID, PrimaryDocNbr, VCRCreateDate, TransactionDateTime, SourceSystemId, 
	FeeSequenceNbr, FeeTypeCd, FeeCatCd, FeeCurrCd, FeeAmt, 
	FeeAmtUSD, ApplyCreditInd, FeeSubCategory, FeeWaivedInd, FeeDescription, 
	FeePriceCd, FeeWaiverCd, tdb_created_at)
VALUES
(
	?, ?, ?, ?, ?,
	?, ?, ?, ?, ?,
	?, ?, ?, ?, ?,
	?, ?, ?
);