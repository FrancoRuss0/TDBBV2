%dw 2.0
output application/java
var cast = readUrl("classpath://CastingFunctions.dwl", "application/dw")
---
(data) -> data map (record,index) -> 
{
	PCC_Cd : cast.toString(record[0]),
	User_Id : cast.toString(record[1]),
	Default_Ticketing_Carrier : cast.toString(record[2]),
	Personal_City_Code : cast.toString(record[3]),
	Personal_Account_Code : cast.toString(record[4]),
	Station_Code : cast.toString(record[5]),
	RecordStatus : cast.toString(record[6]),
	EffectiveDate : cast.toDate(record[7],"yyyy-MM-dd")
} as Object {class: "com.airmalta.hip.tdbingester.filepojos.EPR_OAC"}