INSERT INTO TktCouponHistory (
	ID, PNRLocatorID, PNRCreateDate, PrimaryDocNbr, VCRCreateDate, 
	TransactionDateTime, CouponSeqNbr, FareBasisCode, CouponNbr, PreviousCouponStatusCode, 
	NewCouponStatusCode, CouponNbrChanged, PreviousControlVendorCode, NewControlVendorCode, RevalMarketingAirlineCode, 
	RevalClassofService, RevalMarketingFlightNbr, RevalServiceStartDate, RevalServiceStartCity, RevalServiceEndCity, 
	RevalServiceStartTime, RevalServiceEndTime, RevalSegmentStatusCode, LastUpdate, LastUpdateSysTime, 
	HistorySeqNbr, tdb_created_at)
VALUES
(
	?, ?, ?, ?, ?,
	?, ?, ?, ?, ?,
	?, ?, ?, ?, ?,
	?, ?, ?, ?, ?,
	?, ?, ?, ?, ?,
	?, ?
);