INSERT INTO TktCouponEMD (
	ID, PNRLocatorID, PNRCreateDate, PrimaryDocNbr, VCRCreateDate, 
	TransactionDateTime, CouponSeqNbr, FeeOwnerCode, OCGroupCode, RFICode, 
	QuantSold, RFISubCode, CommercialName, EMDTypeCode, FeeGuaranteedInd, 
	FeeVendorCode, SegmentUseCode, RelPrimaryDocNbr, RelCouponSeqNbr, RelVCRCreateDate, 
	tdb_created_at
	)
VALUES
(
	?, ?, ?, ?, ?,
	?, ?, ?, ?, ?,
	?, ?, ?, ?, ?,
	?, ?, ?, ?, ?,
	?
);