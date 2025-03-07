INSERT INTO ResAirExtraPortionofTravel (
	ID, PNRLocatorID, PNRCreateDate, IntraPNRSetNbr, FromDateTime, 
	TransmissionDateTime, UniqueComponentID, AEPortionSeqNbr, PNRPassengerSeqID, AirlineCode, 
	FlightNbr, ClassofService, ServiceStartDate, ServiceStartCity, ServiceEndCity, 
	EMDNbr, EmdCouponNbr, ETicketNbr, ETicketCpnNbr, RecordUpdateDate, 
	RecordUpdateDateTime, MarketingCarrierCode, OpertatingCarrierCode, SourceSystemID, tdb_created_at)
VALUES
(?, ?, ?, ?, ?, 
 ?, ?, ?, ?, ?, 
 ?, ?, ?, ?, ?, 
 ?, ?, ?, ?, ?, 
 ?, ?, ?, ?, ?);
