INSERT INTO TktProRation (
	ID, PNRLocatorID, PNRCreateDate, PrimaryDocNbr, VCRCreateDate, 
	TransactionDateTime, CouponSeqNbr, CouponDistanceKm, CouponDistanceMi, ProrationFactor, 
	ProrateBaseFareUSD, ProrateTotalDocAmtUSD, EquivBaseFareCurrCode, EquivUSDExchgRate, ProrateEquivBaseFareAmt, 
	ProrateEquivTotalDocAmt, OwnerCurrencyCode, ProrateBaseFareOwnerAmt, ProrateTotalDocOwnerAmt, tdb_created_at
	)
VALUES
(
	?, ?, ?, ?, ?,
	?, ?, ?, ?, ?,
	?, ?, ?, ?, ?,
	?, ?, ?, ?, ?
);