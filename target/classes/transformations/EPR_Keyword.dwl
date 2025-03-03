%dw 2.0
output application/java
var cast = readUrl("classpath://CastingFunctions.dwl", "application/dw")
---
(data) -> data map (record,index) -> 
{
	PCC_Cd : cast.toString(record[0]),
	User_Id : cast.toString(record[1]),
	Keyword : cast.toString(record[2]),
	RecordStatus : cast.toString(record[3]),
	EffectiveDate : cast.toDate(record[4],"yyyy-MM-dd")
} as Object {class: "com.airmalta.hip.tdbingester.filepojos.EPR_keyword"}