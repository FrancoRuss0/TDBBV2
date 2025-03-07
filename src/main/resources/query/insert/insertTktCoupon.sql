INSERT INTO TktCoupon (
	ID, PNRLocatorID, PNRCreateDate, PrimaryDocNbr, VCRCreateDate, 
	TransactionDateTime, CouponSeqNbr, EntNbr, CouponStatus, PreviousCouponStatusCode, 
	SegmentTypeCode, MarketingAirlineCode, MarketingFlightNbr, ServiceStartCity, ServiceEndCity, 
	SegmentStatusCode, ServiceStartDate, ServiceStartTime, ServiceEndDate, ServiceEndTime, 
	ClassOfService, FareBasisCode, TktDesignatorCode, FareBreakInd, PriceNotValidBeforeDate, 
	PriceNotValidAfterDate, InvoluntaryInd, FlownFlightNbr, FlownServiceStartDate, FlownServiceStartCity, 
	FlownServiceEndCity, FlownClassOfService, FlownFlightOrigDate, OperatingAirlineCode, OperatingFlightNbr, 
	OperatingPNRLocator, FareBreakAmt, FareBreakDiscAmt, DiscountAmtInd, DiscountPctInd, 
	StopoverCode, FrequentTravelerNbr, VendorCode, FareBreakCurrencyCode, SettlementAuthCode, 
	BaggageAlwncText, tdb_created_at)
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
	?, ?
	);