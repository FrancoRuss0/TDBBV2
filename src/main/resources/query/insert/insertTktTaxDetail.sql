INSERT INTO TktTaxDetail (
	ID, PNRLocatorID, PNRCreateDate, PrimaryDocNbr, VCRCreateDate, 
	TransactionDateTime, TaxSeqNbr, TaxAmt, TaxCode, LocationTypeCode, 
	ServiceCityCode, tdb_created_at
	)
VALUES
(
	?, ?, ?, ?, ?,
	?, ?, ?, ?, ?,
	?, ?
);