INSERT INTO TktMSR (
	ID, PNRLocatorID, PNRCreateDate, PrimaryDocNbr, VCRCreateDate, 
	TransactionDateTime, MSRSeqNbr, MSRQuantitySoldCount, MSRTypeCode, MSRTypeDesc, 
	MSRCurrencyCode, MSRChargeAmount, MSRTaxAmount, MSRTaxCurrencyCode, SourceSystemId, 
	OCGroupCode, RFISubCode, tdb_created_at)
VALUES
(
	?, ?, ?, ?, ?,
	?, ?, ?, ?, ?,
	?, ?, ?, ?, ?,
	?, ?, ?
);