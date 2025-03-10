-- SQL Query to insert data into ACSPaxSeat table

INSERT INTO ACSPaxSeat (
SourceSystemID , 
PNRLocatorId , 
PNRCreateDate , 
ResPaxId , 
AirlineCode , 
FltNbr , 
ServiceStartDate , 
AirlineOrigAirport, 
CabinCode , 
SeatRowNbr , 
SeatLtr , 
PreResSeatInd , 
JumpSeatTypeCode , 
JumpSeatRowNbr , 
JumpSeatLtr , 
PaidUpgradeACAmt , 
InventoryUpgradeInd , 
DowngradeInd , 
UpgradeInd , 
CoachUpgradeInd , 
BusinessUpgradeInd , 
MsgCreateDateTime ,
tdb_created_at 
) 
VALUES (?, ?, ?, ?, ?, 
		?, ?, ?, ?, ?, 
		?, ?, ?, ?, ?, 
		?, ?, ?, ?, ?, 
		?, ?, ?);
