INSERT INTO TktPayment (
	ID, PNRLocatorID, PNRCreateDate, PrimaryDocNbr, VCRCreateDate, 
	TransactionDateTime, PaymentSeqNbr, FOPCode, PaymentAmt, PaymentVendorCode, 
	AcctNbr, PaymentCurrCode, PaymentRemarks, PaymentApprovalCode, PaymentApprovalTypeCode, 
	tdb_created_at
	)
VALUES
(
	?, ?, ?, ?, ?,
	?, ?, ?, ?, ?,
	?, ?, ?, ?, ?,
	?
);