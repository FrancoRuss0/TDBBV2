INSERT INTO ResFlightAirExtra (
	ID, PNRLocatorID, PNRCreateDate, FromDateTime, SegmentNbr, 
	PNRPassengerSeqId, RFISubCode, RecordUpdateDate, RecordUpdateTime, IntraPNRSetNbr, 
	tdb_created_at)
VALUES
(
	?, ?, ?, ?, ?, 
	?, ?, ?, ?, ?, 
	?);
