%dw 2.0
output application/java
var cast = readUrl("classpath://CastingFunctions.dwl", "application/dw")
---
(data) -> data map (record,index) -> 
{
	SourceSystemID : cast.toString(record[0]),
	PNRLocatorId : cast.toString(record[1]),
	PNRCreateDate : cast.toDate(record[2],"yyyy-MM-dd"),
	ResPaxId : cast.toNumber(record[3]),
	AirlineCode : cast.toString(record[4]),
	FltNbr : cast.toString(record[5]),
	ServiceStartDate : cast.toDate(record[6],"yyyy-MM-dd"),
	AirlineOrigAirport : cast.toString(record[7]),
	BagTag : cast.toString(record[8]),
	BagTagIssueTime : cast.toLocalTime(record[9],"HH:mm:ss"),
	BagTagIssueDate : cast.toDate(record[10],"yyyy-MM-dd"),
	BagDamagedInd : cast.toString(record[11]),
	BagTransferMsgInd : cast.toString(record[12]),
	BagEdifactAddInd : cast.toString(record[13]),
	BagEdifactXLInd : cast.toString(record[14]),
	BagPaxNewRteInd : cast.toString(record[15]),
	BagPetInd : cast.toString(record[16]),
	BagVoluntarySepInd : cast.toString(record[17]),
	BagTagManualInd : cast.toString(record[18]),
	BagTagXLInd : cast.toString(record[19]),
	BagPremiumInd : cast.toString(record[20]),
	BagPriorityInd : cast.toString(record[21]),
	BagHeavyInd : cast.toString(record[22]),
	BagClearedDogInd : cast.toString(record[23]),
	BagClearedETDInd : cast.toString(record[24]),
	BagClearedSrchInd : cast.toString(record[25]),
	BagClearedTraceInd : cast.toString(record[26]),
	BagCourierInd : cast.toString(record[27]),
	BagStandByInd : cast.toString(record[28]),
	BagGroupInd : cast.toString(record[29]),
	BagSportEquipInd : cast.toString(record[30]),
	BagBulkInd : cast.toString(record[31]),
	BagLtdReleaseInd : cast.toString(record[32]),
	XLAirportCode : cast.toString(record[33]),
	XLAgentSign : cast.toString(record[34]),
	XLDtyCd : cast.toString(record[35]),
	XLAgentStation : cast.toString(record[36]),
	XLTime : cast.toLocalTime(record[37],"HH:mm:ss"),
	XLDate : cast.toDate(record[38],"yyyy-MM-dd"),
	BagRouteNbr : cast.toString(record[39]),
	OriginalRteAgnt : cast.toString(record[40]),
	OriginalRteAgntDtyCd : cast.toString(record[41]),
	OriginalRteAgntStation : cast.toString(record[42]),
	OriginalRteAgntTime : cast.toLocalTime(record[43],"HH:mm:ss"),
	OriginalRteAgntDate : cast.toDate(record[44],"yyyy-MM-dd"),
	RouteDate1 : cast.toDate(record[45],"yyyy-MM-dd"),
	RouteDate2 : cast.toDate(record[46],"yyyy-MM-dd"),
	RouteDate3 : cast.toDate(record[47],"yyyy-MM-dd"),
	RouteDate4 : cast.toDate(record[48],"yyyy-MM-dd"),
	RouteDate5 : cast.toDate(record[49],"yyyy-MM-dd"),
	RouteOperatingAirline1 : cast.toString(record[50]),
	RouteOperatingAirline2 : cast.toString(record[51]),
	RouteOperatingAirline3 : cast.toString(record[52]),
	RouteOperatingAirline4 : cast.toString(record[53]),
	RouteOperatingAirline5 : cast.toString(record[54]),
	RouteFltNbr1 : cast.toString(record[55]),
	RouteFltNbr2 : cast.toString(record[56]),
	RouteFltNbr3 : cast.toString(record[57]),
	RouteFltNbr4 : cast.toString(record[58]),
	RouteFltNbr5 : cast.toString(record[59]),
	RouteOriginCd1 : cast.toString(record[60]),
	RouteOriginCd2 : cast.toString(record[61]),
	RouteOriginCd3 : cast.toString(record[62]),
	RouteOriginCd4 : cast.toString(record[63]),
	RouteOriginCd5 : cast.toString(record[64]),
	RouteDestCd1 : cast.toString(record[65]),
	RouteDestCd2 : cast.toString(record[66]),
	RouteDestCd3 : cast.toString(record[67]),
	RouteDestCd4 : cast.toString(record[68]),
	RouteDestCd5 : cast.toString(record[69]),
	BagRerouteNbr : cast.toString(record[70]),
	BagOldRouteNbr : cast.toString(record[71]),
	OriginalReRteAgnt : cast.toString(record[72]),
	OriginalReRteAgntDtyCd : cast.toString(record[73]),
	OriginalReRteAgntStation : cast.toString(record[74]),
	OriginalReRteAgntTime : cast.toLocalTime(record[75],"HH:mm:ss"),
	OriginalReRteAgntDate : cast.toDate(record[76],"yyyy-MM-dd"),
	RerouteDate1 : cast.toDate(record[77],"yyyy-MM-dd"),
	RerouteDate2 : cast.toDate(record[78],"yyyy-MM-dd"),
	RerouteDate3 : cast.toDate(record[79],"yyyy-MM-dd"),
	RerouteDate4 : cast.toDate(record[80],"yyyy-MM-dd"),
	RerouteDate5 : cast.toDate(record[81],"yyyy-MM-dd"),
	RerouteOperatingAirline1 : cast.toString(record[82]),
	RerouteOperatingAirline2 : cast.toString(record[83]),
	RerouteOperatingAirline3 : cast.toString(record[84]),
	RerouteOperatingAirline4 : cast.toString(record[85]),
	RerouteOperatingAirline5 : cast.toString(record[86]),
	RerouteFltNbr1 : cast.toString(record[87]),
	RerouteFltNbr2 : cast.toString(record[88]),
	RerouteFltNbr3 : cast.toString(record[89]),
	RerouteFltNbr4 : cast.toString(record[90]),
	RerouteFltNbr5 : cast.toString(record[91]),
	RerouteOriginCd1 : cast.toString(record[92]),
	RerouteOriginCd2 : cast.toString(record[93]),
	RerouteOriginCd3 : cast.toString(record[94]),
	RerouteOriginCd4 : cast.toString(record[95]),
	RerouteOriginCd5 : cast.toString(record[96]),
	RerouteDestCd1 : cast.toString(record[97]),
	RerouteDestCd2 : cast.toString(record[98]),
	RerouteDestCd3 : cast.toString(record[99]),
	RerouteDestCd4 : cast.toString(record[100]),
	RerouteDestCd5 : cast.toString(record[101]),
	MsgCreateDateTime : cast.toLocalDateTime(record[102],"yyyy-MM-dd HH:mm:ss")
} as Object {class: "com.kmmaltairlines.hip.tdbingester.filepojos.ACSPaxBag"}