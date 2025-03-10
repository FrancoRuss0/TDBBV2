INSERT INTO TktTax (
	ID, PNRLocatorID, PNRCreateDate, PrimaryDocNbr, VCRCreateDate, 
	TransactionDateTime, TaxSeqNbr, TaxAmt, TaxCode, TaxTypeCode, 
	TaxCategoryCode, TaxCurrCode, tdb_created_at)
VALUES
(
	?, ?, ?, ?, ?,
	?, ?, ?, ?, ?,
	?, ?, ?
	
);