-- SQL Query to insert data into ACSFlightHistory table

INSERT INTO ACSFlightHistory (
	SourceSystemID, ACSFltSegDate, AirlineCode, FltNbr, AirlineOrigAirport, 
	AirlineDestAirport, SchdServiceStartTime, AAACityCode, AgentSine, ActionDate, 
	ActionTime, AgntStationLNIATA, ActionItem, AgntDtyCd, AgntHomeStation, 
	MsgCreateDateTime, tdb_created_at) 
VALUES (
	?, ?, ?, ?, ?, 
	?, ?, ?, ?, ?, 
	?, ?, ?, ?, ?, 
	?, ?);
