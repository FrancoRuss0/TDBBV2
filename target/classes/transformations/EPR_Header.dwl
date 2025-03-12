%dw 2.0
output application/java
var cast = readUrl("classpath://CastingFunctions.dwl", "application/dw")
---
(data) -> data map (record,index) -> 
{
	PCC_Cd : cast.toString(record[0]),
	User_Id : cast.toString(record[1]),
	Account_Cd : cast.toString(record[2]),
	Office_Cd : cast.toString(record[3]),
	Agent_Sine : cast.toString(record[4]),
	Active_Ind : cast.toString(record[5]),
	Access_Method_Txt : cast.toString(record[6]),
	Agent_Last_Nm : cast.toString(record[7]),
	Agent_Initial_Nm : cast.toString(record[8]),
	Home_Office_Cd : cast.toString(record[9]),
	Home_City_Txt : cast.toString(record[10]),
	Last_Sign_in_Dt : cast.toDate(record[11],"yyyy-MM-dd"),
	PIN_Set_Ind : cast.toString(record[12]),
	Password_Set_Ind : cast.toString(record[13]),
	PIV_Questions_Ind : cast.toString(record[14]),
	Duty_0_Cd_Ind : cast.toString(record[15]),
	Duty_1_Cd_Ind : cast.toString(record[16]),
	Duty_2_Cd_Ind : cast.toString(record[17]),
	Duty_3_Cd_Ind : cast.toString(record[18]),
	Duty_4_Cd_Ind : cast.toString(record[19]),
	Duty_5_Cd_Ind : cast.toString(record[20]),
	Duty_6_Cd_Ind : cast.toString(record[21]),
	Duty_7_Cd_Ind : cast.toString(record[22]),
	Duty_8_Cd_Ind : cast.toString(record[23]),
	Duty_9_Cd_Ind : cast.toString(record[24]),
	Duty_Hash_Cd_Ind : cast.toString(record[25]),
	Duty_Dash_Cd_Ind : cast.toString(record[26]),
	Duty_Star_Cd_Ind : cast.toString(record[27]),
	Duty_Slash_Cd_Ind : cast.toString(record[28]),
	Duty_Mesh_Cd_Ind : cast.toString(record[29]),
	Duty_0_Temp_Cd_Ind : cast.toString(record[30]),
	Duty_1_Temp_Cd_Ind : cast.toString(record[31]),
	Duty_2_Temp_Cd_Ind : cast.toString(record[32]),
	Duty_3_Temp_Cd_Ind : cast.toString(record[33]),
	Duty_4_Temp_Cd_Ind : cast.toString(record[34]),
	Duty_5_Temp_Cd_Ind : cast.toString(record[35]),
	Duty_6_Temp_Cd_Ind : cast.toString(record[36]),
	Duty_7_Temp_Cd_Ind : cast.toString(record[37]),
	Duty_8_Temp_Cd_Ind : cast.toString(record[38]),
	Duty_9_Temp_Cd_Ind : cast.toString(record[39]),
	Duty_Hash_Temp_Cd_Ind : cast.toString(record[40]),
	Duty_Dash_Temp_Cd_Ind : cast.toString(record[41]),
	Duty_Star_Temp_Cd_Ind : cast.toString(record[42]),
	Duty_Slash_Temp_Cd_Ind : cast.toString(record[43]),
	Duty_Mesh_Temp_Cd_Ind : cast.toString(record[44]),
	SCR_Group : cast.toNumber(record[45]),
	RecordStatus : cast.toString(record[46]),
	Keyword_Changed : cast.toString(record[47]),
	EffectiveDate : cast.toDate(record[48],"yyyy-MM-dd"),
	MCP_Partition_Code : cast.toString(record[49]),
	Default_Ticketing_Carrier : cast.toString(record[50]),
	Station_Code : cast.toString(record[51])
} as Object {class: "com.kmmaltairlines.hip.tdbingester.filepojos.EPR_Header"}