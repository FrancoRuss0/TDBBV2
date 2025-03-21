INSERT INTO TktDocument (
	ID, PNRLocatorID, PNRCreateDate, PrimaryDocNbr, VCRCreateDate, 
	TransactionDateTime, AirlineAccountingCode, EndDocNbr, VendorName, PointOfTktIssuance, 
	ValidatingVendorCode, ValidatingVendorNbr, PNRPurgeDate, CRSPNRLocator, DocIssueDate, 
	CustomerFullName, AgentCountryCode, IntlDocSaleCode, TourCode, AgentSine, 
	OwningCityCode, AAACityCode, DocIssueAAAIATANbr, HomeCityCode, Restrictions, 
	CurrConverRate, BankSellRate, BankBuyRate, IntlClearHouseRate, ExchgTktAmt, 
	SettlementAuthCode, BaseFareCurrCode, BaseFareAmt, TotalFareCurrCode, TotalDocAmt, 
	EquivBaseFareCurrCode, EquivBaseFareAmt, DataInd, FareCalc, FareCalcType, 
	OriginalIssueDate, OriginalIssueCity, OriginalIATANbr, OriginalFOP, OriginalTktNbr, 
	ExchgFOP, AddlExchgTktData, ExchgCoupon, AutoPriceCode, DocTypeCode, 
	DocStatusCode, PassengerType, SourceSystemId, OACStationNbr, RefundableInd, 
	CommissionableInd, InterlineInd, EMDRFICode, EMDType, TaxExInd, 
	ConsumedAtIssueInd, ElectronicDocumentInd, ManualDocumentInd, VoucherRefundInd, RFICode, 
	RFITxt, PTASvcChargeCurrCode, PTASvcChargeAmt, PTAAddFundsDesc, PTAAddFundsCurrCode, 
	PTAAddFundsAmt, ExchgChangeFeeCurrCode, ExchgChangeFeeAmt, OtherFeeCurrCode, OtherFeeAmt, 
	AddCollectCurrCode, AddCollectAmt, OACDefaultPartitionCode, OACCityCode, OACAcctCode, 
	NonRefFeeCurrCode, NonRefFeeAmt, OBFeeDescText, OBFeePricingCode, OBFeeWaiverCode, 
	OBFeeTotalCurrCode, OBFeeTotal, OBFeeTotalUSD, PricedPassengerType, tdb_created_at
)
VALUES
 (
	?, ?, ?, ?, ?, 
	?, ?, ?, ?, ?, 
	?, ?, ?, ?, ?, 
	?, ?, ?, ?, ?, 
	?, ?, ?, ?, ?, 
	?, ?, ?, ?, ?, 
	?, ?, ?, ?, ?, 
	?, ?, ?, ?, ?, 
	?, ?, ?, ?, ?, 
	?, ?, ?, ?, ?, 
	?, ?, ?, ?, ?, 
	?, ?, ?, ?, ?, 
	?, ?, ?, ?, ?, 
	?, ?, ?, ?, ?, 
	?, ?, ?, ?, ?, 
	?, ?, ?, ?, ?, 
	?, ?, ?, ?, ?, 
	?, ?, ?, ?, ? 
);
 