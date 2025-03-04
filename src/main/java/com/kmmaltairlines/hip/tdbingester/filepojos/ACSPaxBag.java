package com.kmmaltairlines.hip.tdbingester.filepojos;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class ACSPaxBag {

	private String SourceSystemID;
	private String PNRLocatorId;
	private Date PNRCreateDate;
	private Short ResPaxId;
	private String AirlineCode;
	private String FltNbr;
	private Date ServiceStartDate;
	private String AirlineOrigAirport;
	private String BagTag;
	private Time BagTagIssueTime;
	private Date BagTagIssueDate;
	private String BagDamagedInd;
	private String BagTransferMsgInd;
	private String BagEdifactAddInd;
	private String BagEdifactXLInd;
	private String BagPaxNewRteInd;
	private String BagPetInd;
	private String BagVoluntarySepInd;
	private String BagTagManualInd;
	private String BagTagXLInd;
	private String BagPremiumInd;
	private String BagPriorityInd;
	private String BagHeavyInd;
	private String BagClearedDogInd;
	private String BagClearedETDInd;
	private String BagClearedSrchInd;
	private String BagClearedTraceInd;
	private String BagCourierInd;
	private String BagStandByInd;
	private String BagGroupInd;
	private String BagSportEquipInd;
	private String BagBulkInd;
	private String BagLtdReleaseInd;
	private String XLAirportCode;
	private String XLAgentSign;
	private String XLDtyCd;
	private String XLAgentStation;
	private Time XLTime;
	private Date XLDate;
	private String BagRouteNbr;
	private String OriginalRteAgnt;
	private String OriginalRteAgntDtyCd;
	private String OriginalRteAgntStation;
	private Time OriginalRteAgntTime;
	private Date OriginalRteAgntDate;
	private Date RouteDate1;
	private Date RouteDate2;
	private Date RouteDate3;
	private Date RouteDate4;
	private Date RouteDate5;
	private String RouteOperatingAirline1;
	private String RouteOperatingAirline2;
	private String RouteOperatingAirline3;
	private String RouteOperatingAirline4;
	private String RouteOperatingAirline5;
	private String RouteFltNbr1;
	private String RouteFltNbr2;
	private String RouteFltNbr3;
	private String RouteFltNbr4;
	private String RouteFltNbr5;
	private String RouteOriginCd1;
	private String RouteOriginCd2;
	private String RouteOriginCd3;
	private String RouteOriginCd4;
	private String RouteOriginCd5;
	private String RouteDestCd1;
	private String RouteDestCd2;
	private String RouteDestCd3;
	private String RouteDestCd4;
	private String RouteDestCd5;
	private String BagRerouteNbr;
	private String BagOldRouteNbr;
	private String OriginalReRteAgnt;
	private String OriginalReRteAgntDtyCd;
	private String OriginalReRteAgntStation;
	private Time OriginalReRteAgntTime;
	private Date OriginalReRteAgntDate;
	private Date RerouteDate1;
	private Date RerouteDate2;
	private Date RerouteDate3;
	private Date RerouteDate4;
	private Date RerouteDate5;
	private String RerouteOperatingAirline1;
	private String RerouteOperatingAirline2;
	private String RerouteOperatingAirline3;
	private String RerouteOperatingAirline4;
	private String RerouteOperatingAirline5;
	private String RerouteFltNbr1;
	private String RerouteFltNbr2;
	private String RerouteFltNbr3;
	private String RerouteFltNbr4;
	private String RerouteFltNbr5;
	private String RerouteOriginCd1;
	private String RerouteOriginCd2;
	private String RerouteOriginCd3;
	private String RerouteOriginCd4;
	private String RerouteOriginCd5;
	private String RerouteDestCd1;
	private String RerouteDestCd2;
	private String RerouteDestCd3;
	private String RerouteDestCd4;
	private String RerouteDestCd5;
	private Timestamp MsgCreateDateTime;

	public String getSourceSystemID() {
		return SourceSystemID;
	}

	public void setSourceSystemID(final String SourceSystemID) {
		this.SourceSystemID = SourceSystemID;
	}

	public String getPNRLocatorId() {
		return PNRLocatorId;
	}

	public void setPNRLocatorId(final String PNRLocatorId) {
		this.PNRLocatorId = PNRLocatorId;
	}

	public Date getPNRCreateDate() {
		return PNRCreateDate;
	}

	public void setPNRCreateDate(final Date PNRCreateDate) {
		this.PNRCreateDate = PNRCreateDate;
	}

	public Short getResPaxId() {
		return ResPaxId;
	}

	public void setResPaxId(final Short ResPaxId) {
		this.ResPaxId = ResPaxId;
	}

	public String getAirlineCode() {
		return AirlineCode;
	}

	public void setAirlineCode(final String AirlineCode) {
		this.AirlineCode = AirlineCode;
	}

	public String getFltNbr() {
		return FltNbr;
	}

	public void setFltNbr(final String FltNbr) {
		this.FltNbr = FltNbr;
	}

	public Date getServiceStartDate() {
		return ServiceStartDate;
	}

	public void setServiceStartDate(final Date ServiceStartDate) {
		this.ServiceStartDate = ServiceStartDate;
	}

	public String getAirlineOrigAirport() {
		return AirlineOrigAirport;
	}

	public void setAirlineOrigAirport(final String AirlineOrigAirport) {
		this.AirlineOrigAirport = AirlineOrigAirport;
	}

	public String getBagTag() {
		return BagTag;
	}

	public void setBagTag(final String BagTag) {
		this.BagTag = BagTag;
	}

	public Time getBagTagIssueTime() {
		return BagTagIssueTime;
	}

	public void setBagTagIssueTime(final Time BagTagIssueTime) {
		this.BagTagIssueTime = BagTagIssueTime;
	}

	public Date getBagTagIssueDate() {
		return BagTagIssueDate;
	}

	public void setBagTagIssueDate(final Date BagTagIssueDate) {
		this.BagTagIssueDate = BagTagIssueDate;
	}

	public String getBagDamagedInd() {
		return BagDamagedInd;
	}

	public void setBagDamagedInd(final String BagDamagedInd) {
		this.BagDamagedInd = BagDamagedInd;
	}

	public String getBagTransferMsgInd() {
		return BagTransferMsgInd;
	}

	public void setBagTransferMsgInd(final String BagTransferMsgInd) {
		this.BagTransferMsgInd = BagTransferMsgInd;
	}

	public String getBagEdifactAddInd() {
		return BagEdifactAddInd;
	}

	public void setBagEdifactAddInd(final String BagEdifactAddInd) {
		this.BagEdifactAddInd = BagEdifactAddInd;
	}

	public String getBagEdifactXLInd() {
		return BagEdifactXLInd;
	}

	public void setBagEdifactXLInd(final String BagEdifactXLInd) {
		this.BagEdifactXLInd = BagEdifactXLInd;
	}

	public String getBagPaxNewRteInd() {
		return BagPaxNewRteInd;
	}

	public void setBagPaxNewRteInd(final String BagPaxNewRteInd) {
		this.BagPaxNewRteInd = BagPaxNewRteInd;
	}

	public String getBagPetInd() {
		return BagPetInd;
	}

	public void setBagPetInd(final String BagPetInd) {
		this.BagPetInd = BagPetInd;
	}

	public String getBagVoluntarySepInd() {
		return BagVoluntarySepInd;
	}

	public void setBagVoluntarySepInd(final String BagVoluntarySepInd) {
		this.BagVoluntarySepInd = BagVoluntarySepInd;
	}

	public String getBagTagManualInd() {
		return BagTagManualInd;
	}

	public void setBagTagManualInd(final String BagTagManualInd) {
		this.BagTagManualInd = BagTagManualInd;
	}

	public String getBagTagXLInd() {
		return BagTagXLInd;
	}

	public void setBagTagXLInd(final String BagTagXLInd) {
		this.BagTagXLInd = BagTagXLInd;
	}

	public String getBagPremiumInd() {
		return BagPremiumInd;
	}

	public void setBagPremiumInd(final String BagPremiumInd) {
		this.BagPremiumInd = BagPremiumInd;
	}

	public String getBagPriorityInd() {
		return BagPriorityInd;
	}

	public void setBagPriorityInd(final String BagPriorityInd) {
		this.BagPriorityInd = BagPriorityInd;
	}

	public String getBagHeavyInd() {
		return BagHeavyInd;
	}

	public void setBagHeavyInd(final String BagHeavyInd) {
		this.BagHeavyInd = BagHeavyInd;
	}

	public String getBagClearedDogInd() {
		return BagClearedDogInd;
	}

	public void setBagClearedDogInd(final String BagClearedDogInd) {
		this.BagClearedDogInd = BagClearedDogInd;
	}

	public String getBagClearedETDInd() {
		return BagClearedETDInd;
	}

	public void setBagClearedETDInd(final String BagClearedETDInd) {
		this.BagClearedETDInd = BagClearedETDInd;
	}

	public String getBagClearedSrchInd() {
		return BagClearedSrchInd;
	}

	public void setBagClearedSrchInd(final String BagClearedSrchInd) {
		this.BagClearedSrchInd = BagClearedSrchInd;
	}

	public String getBagClearedTraceInd() {
		return BagClearedTraceInd;
	}

	public void setBagClearedTraceInd(final String BagClearedTraceInd) {
		this.BagClearedTraceInd = BagClearedTraceInd;
	}

	public String getBagCourierInd() {
		return BagCourierInd;
	}

	public void setBagCourierInd(final String BagCourierInd) {
		this.BagCourierInd = BagCourierInd;
	}

	public String getBagStandByInd() {
		return BagStandByInd;
	}

	public void setBagStandByInd(final String BagStandByInd) {
		this.BagStandByInd = BagStandByInd;
	}

	public String getBagGroupInd() {
		return BagGroupInd;
	}

	public void setBagGroupInd(final String BagGroupInd) {
		this.BagGroupInd = BagGroupInd;
	}

	public String getBagSportEquipInd() {
		return BagSportEquipInd;
	}

	public void setBagSportEquipInd(final String BagSportEquipInd) {
		this.BagSportEquipInd = BagSportEquipInd;
	}

	public String getBagBulkInd() {
		return BagBulkInd;
	}

	public void setBagBulkInd(final String BagBulkInd) {
		this.BagBulkInd = BagBulkInd;
	}

	public String getBagLtdReleaseInd() {
		return BagLtdReleaseInd;
	}

	public void setBagLtdReleaseInd(final String BagLtdReleaseInd) {
		this.BagLtdReleaseInd = BagLtdReleaseInd;
	}

	public String getXLAirportCode() {
		return XLAirportCode;
	}

	public void setXLAirportCode(final String XLAirportCode) {
		this.XLAirportCode = XLAirportCode;
	}

	public String getXLAgentSign() {
		return XLAgentSign;
	}

	public void setXLAgentSign(final String XLAgentSign) {
		this.XLAgentSign = XLAgentSign;
	}

	public String getXLDtyCd() {
		return XLDtyCd;
	}

	public void setXLDtyCd(final String XLDtyCd) {
		this.XLDtyCd = XLDtyCd;
	}

	public String getXLAgentStation() {
		return XLAgentStation;
	}

	public void setXLAgentStation(final String XLAgentStation) {
		this.XLAgentStation = XLAgentStation;
	}

	public Time getXLTime() {
		return XLTime;
	}

	public void setXLTime(final Time XLTime) {
		this.XLTime = XLTime;
	}

	public Date getXLDate() {
		return XLDate;
	}

	public void setXLDate(final Date XLDate) {
		this.XLDate = XLDate;
	}

	public String getBagRouteNbr() {
		return BagRouteNbr;
	}

	public void setBagRouteNbr(final String BagRouteNbr) {
		this.BagRouteNbr = BagRouteNbr;
	}

	public String getOriginalRteAgnt() {
		return OriginalRteAgnt;
	}

	public void setOriginalRteAgnt(final String OriginalRteAgnt) {
		this.OriginalRteAgnt = OriginalRteAgnt;
	}

	public String getOriginalRteAgntDtyCd() {
		return OriginalRteAgntDtyCd;
	}

	public void setOriginalRteAgntDtyCd(final String OriginalRteAgntDtyCd) {
		this.OriginalRteAgntDtyCd = OriginalRteAgntDtyCd;
	}

	public String getOriginalRteAgntStation() {
		return OriginalRteAgntStation;
	}

	public void setOriginalRteAgntStation(final String OriginalRteAgntStation) {
		this.OriginalRteAgntStation = OriginalRteAgntStation;
	}

	public Time getOriginalRteAgntTime() {
		return OriginalRteAgntTime;
	}

	public void setOriginalRteAgntTime(final Time OriginalRteAgntTime) {
		this.OriginalRteAgntTime = OriginalRteAgntTime;
	}

	public Date getOriginalRteAgntDate() {
		return OriginalRteAgntDate;
	}

	public void setOriginalRteAgntDate(final Date OriginalRteAgntDate) {
		this.OriginalRteAgntDate = OriginalRteAgntDate;
	}

	public Date getRouteDate1() {
		return RouteDate1;
	}

	public void setRouteDate1(final Date RouteDate1) {
		this.RouteDate1 = RouteDate1;
	}

	public Date getRouteDate2() {
		return RouteDate2;
	}

	public void setRouteDate2(final Date RouteDate2) {
		this.RouteDate2 = RouteDate2;
	}

	public Date getRouteDate3() {
		return RouteDate3;
	}

	public void setRouteDate3(final Date RouteDate3) {
		this.RouteDate3 = RouteDate3;
	}

	public Date getRouteDate4() {
		return RouteDate4;
	}

	public void setRouteDate4(final Date RouteDate4) {
		this.RouteDate4 = RouteDate4;
	}

	public Date getRouteDate5() {
		return RouteDate5;
	}

	public void setRouteDate5(final Date RouteDate5) {
		this.RouteDate5 = RouteDate5;
	}

	public String getRouteOperatingAirline1() {
		return RouteOperatingAirline1;
	}

	public void setRouteOperatingAirline1(final String RouteOperatingAirline1) {
		this.RouteOperatingAirline1 = RouteOperatingAirline1;
	}

	public String getRouteOperatingAirline2() {
		return RouteOperatingAirline2;
	}

	public void setRouteOperatingAirline2(final String RouteOperatingAirline2) {
		this.RouteOperatingAirline2 = RouteOperatingAirline2;
	}

	public String getRouteOperatingAirline3() {
		return RouteOperatingAirline3;
	}

	public void setRouteOperatingAirline3(final String RouteOperatingAirline3) {
		this.RouteOperatingAirline3 = RouteOperatingAirline3;
	}

	public String getRouteOperatingAirline4() {
		return RouteOperatingAirline4;
	}

	public void setRouteOperatingAirline4(final String RouteOperatingAirline4) {
		this.RouteOperatingAirline4 = RouteOperatingAirline4;
	}

	public String getRouteOperatingAirline5() {
		return RouteOperatingAirline5;
	}

	public void setRouteOperatingAirline5(final String RouteOperatingAirline5) {
		this.RouteOperatingAirline5 = RouteOperatingAirline5;
	}

	public String getRouteFltNbr1() {
		return RouteFltNbr1;
	}

	public void setRouteFltNbr1(final String RouteFltNbr1) {
		this.RouteFltNbr1 = RouteFltNbr1;
	}

	public String getRouteFltNbr2() {
		return RouteFltNbr2;
	}

	public void setRouteFltNbr2(final String RouteFltNbr2) {
		this.RouteFltNbr2 = RouteFltNbr2;
	}

	public String getRouteFltNbr3() {
		return RouteFltNbr3;
	}

	public void setRouteFltNbr3(final String RouteFltNbr3) {
		this.RouteFltNbr3 = RouteFltNbr3;
	}

	public String getRouteFltNbr4() {
		return RouteFltNbr4;
	}

	public void setRouteFltNbr4(final String RouteFltNbr4) {
		this.RouteFltNbr4 = RouteFltNbr4;
	}

	public String getRouteFltNbr5() {
		return RouteFltNbr5;
	}

	public void setRouteFltNbr5(final String RouteFltNbr5) {
		this.RouteFltNbr5 = RouteFltNbr5;
	}

	public String getRouteOriginCd1() {
		return RouteOriginCd1;
	}

	public void setRouteOriginCd1(final String RouteOriginCd1) {
		this.RouteOriginCd1 = RouteOriginCd1;
	}

	public String getRouteOriginCd2() {
		return RouteOriginCd2;
	}

	public void setRouteOriginCd2(final String RouteOriginCd2) {
		this.RouteOriginCd2 = RouteOriginCd2;
	}

	public String getRouteOriginCd3() {
		return RouteOriginCd3;
	}

	public void setRouteOriginCd3(final String RouteOriginCd3) {
		this.RouteOriginCd3 = RouteOriginCd3;
	}

	public String getRouteOriginCd4() {
		return RouteOriginCd4;
	}

	public void setRouteOriginCd4(final String RouteOriginCd4) {
		this.RouteOriginCd4 = RouteOriginCd4;
	}

	public String getRouteOriginCd5() {
		return RouteOriginCd5;
	}

	public void setRouteOriginCd5(final String RouteOriginCd5) {
		this.RouteOriginCd5 = RouteOriginCd5;
	}

	public String getRouteDestCd1() {
		return RouteDestCd1;
	}

	public void setRouteDestCd1(final String RouteDestCd1) {
		this.RouteDestCd1 = RouteDestCd1;
	}

	public String getRouteDestCd2() {
		return RouteDestCd2;
	}

	public void setRouteDestCd2(final String RouteDestCd2) {
		this.RouteDestCd2 = RouteDestCd2;
	}

	public String getRouteDestCd3() {
		return RouteDestCd3;
	}

	public void setRouteDestCd3(final String RouteDestCd3) {
		this.RouteDestCd3 = RouteDestCd3;
	}

	public String getRouteDestCd4() {
		return RouteDestCd4;
	}

	public void setRouteDestCd4(final String RouteDestCd4) {
		this.RouteDestCd4 = RouteDestCd4;
	}

	public String getRouteDestCd5() {
		return RouteDestCd5;
	}

	public void setRouteDestCd5(final String RouteDestCd5) {
		this.RouteDestCd5 = RouteDestCd5;
	}

	public String getBagRerouteNbr() {
		return BagRerouteNbr;
	}

	public void setBagRerouteNbr(final String BagRerouteNbr) {
		this.BagRerouteNbr = BagRerouteNbr;
	}

	public String getBagOldRouteNbr() {
		return BagOldRouteNbr;
	}

	public void setBagOldRouteNbr(final String BagOldRouteNbr) {
		this.BagOldRouteNbr = BagOldRouteNbr;
	}

	public String getOriginalReRteAgnt() {
		return OriginalReRteAgnt;
	}

	public void setOriginalReRteAgnt(final String OriginalReRteAgnt) {
		this.OriginalReRteAgnt = OriginalReRteAgnt;
	}

	public String getOriginalReRteAgntDtyCd() {
		return OriginalReRteAgntDtyCd;
	}

	public void setOriginalReRteAgntDtyCd(final String OriginalReRteAgntDtyCd) {
		this.OriginalReRteAgntDtyCd = OriginalReRteAgntDtyCd;
	}

	public String getOriginalReRteAgntStation() {
		return OriginalReRteAgntStation;
	}

	public void setOriginalReRteAgntStation(final String OriginalReRteAgntStation) {
		this.OriginalReRteAgntStation = OriginalReRteAgntStation;
	}

	public Time getOriginalReRteAgntTime() {
		return OriginalReRteAgntTime;
	}

	public void setOriginalReRteAgntTime(final Time OriginalReRteAgntTime) {
		this.OriginalReRteAgntTime = OriginalReRteAgntTime;
	}

	public Date getOriginalReRteAgntDate() {
		return OriginalReRteAgntDate;
	}

	public void setOriginalReRteAgntDate(final Date OriginalReRteAgntDate) {
		this.OriginalReRteAgntDate = OriginalReRteAgntDate;
	}

	public Date getRerouteDate1() {
		return RerouteDate1;
	}

	public void setRerouteDate1(final Date RerouteDate1) {
		this.RerouteDate1 = RerouteDate1;
	}

	public Date getRerouteDate2() {
		return RerouteDate2;
	}

	public void setRerouteDate2(final Date RerouteDate2) {
		this.RerouteDate2 = RerouteDate2;
	}

	public Date getRerouteDate3() {
		return RerouteDate3;
	}

	public void setRerouteDate3(final Date RerouteDate3) {
		this.RerouteDate3 = RerouteDate3;
	}

	public Date getRerouteDate4() {
		return RerouteDate4;
	}

	public void setRerouteDate4(final Date RerouteDate4) {
		this.RerouteDate4 = RerouteDate4;
	}

	public Date getRerouteDate5() {
		return RerouteDate5;
	}

	public void setRerouteDate5(final Date RerouteDate5) {
		this.RerouteDate5 = RerouteDate5;
	}

	public String getRerouteOperatingAirline1() {
		return RerouteOperatingAirline1;
	}

	public void setRerouteOperatingAirline1(final String RerouteOperatingAirline1) {
		this.RerouteOperatingAirline1 = RerouteOperatingAirline1;
	}

	public String getRerouteOperatingAirline2() {
		return RerouteOperatingAirline2;
	}

	public void setRerouteOperatingAirline2(final String RerouteOperatingAirline2) {
		this.RerouteOperatingAirline2 = RerouteOperatingAirline2;
	}

	public String getRerouteOperatingAirline3() {
		return RerouteOperatingAirline3;
	}

	public void setRerouteOperatingAirline3(final String RerouteOperatingAirline3) {
		this.RerouteOperatingAirline3 = RerouteOperatingAirline3;
	}

	public String getRerouteOperatingAirline4() {
		return RerouteOperatingAirline4;
	}

	public void setRerouteOperatingAirline4(final String RerouteOperatingAirline4) {
		this.RerouteOperatingAirline4 = RerouteOperatingAirline4;
	}

	public String getRerouteOperatingAirline5() {
		return RerouteOperatingAirline5;
	}

	public void setRerouteOperatingAirline5(final String RerouteOperatingAirline5) {
		this.RerouteOperatingAirline5 = RerouteOperatingAirline5;
	}

	public String getRerouteFltNbr1() {
		return RerouteFltNbr1;
	}

	public void setRerouteFltNbr1(final String RerouteFltNbr1) {
		this.RerouteFltNbr1 = RerouteFltNbr1;
	}

	public String getRerouteFltNbr2() {
		return RerouteFltNbr2;
	}

	public void setRerouteFltNbr2(final String RerouteFltNbr2) {
		this.RerouteFltNbr2 = RerouteFltNbr2;
	}

	public String getRerouteFltNbr3() {
		return RerouteFltNbr3;
	}

	public void setRerouteFltNbr3(final String RerouteFltNbr3) {
		this.RerouteFltNbr3 = RerouteFltNbr3;
	}

	public String getRerouteFltNbr4() {
		return RerouteFltNbr4;
	}

	public void setRerouteFltNbr4(final String RerouteFltNbr4) {
		this.RerouteFltNbr4 = RerouteFltNbr4;
	}

	public String getRerouteFltNbr5() {
		return RerouteFltNbr5;
	}

	public void setRerouteFltNbr5(final String RerouteFltNbr5) {
		this.RerouteFltNbr5 = RerouteFltNbr5;
	}

	public String getRerouteOriginCd1() {
		return RerouteOriginCd1;
	}

	public void setRerouteOriginCd1(final String RerouteOriginCd1) {
		this.RerouteOriginCd1 = RerouteOriginCd1;
	}

	public String getRerouteOriginCd2() {
		return RerouteOriginCd2;
	}

	public void setRerouteOriginCd2(final String RerouteOriginCd2) {
		this.RerouteOriginCd2 = RerouteOriginCd2;
	}

	public String getRerouteOriginCd3() {
		return RerouteOriginCd3;
	}

	public void setRerouteOriginCd3(final String RerouteOriginCd3) {
		this.RerouteOriginCd3 = RerouteOriginCd3;
	}

	public String getRerouteOriginCd4() {
		return RerouteOriginCd4;
	}

	public void setRerouteOriginCd4(final String RerouteOriginCd4) {
		this.RerouteOriginCd4 = RerouteOriginCd4;
	}

	public String getRerouteOriginCd5() {
		return RerouteOriginCd5;
	}

	public void setRerouteOriginCd5(final String RerouteOriginCd5) {
		this.RerouteOriginCd5 = RerouteOriginCd5;
	}

	public String getRerouteDestCd1() {
		return RerouteDestCd1;
	}

	public void setRerouteDestCd1(final String RerouteDestCd1) {
		this.RerouteDestCd1 = RerouteDestCd1;
	}

	public String getRerouteDestCd2() {
		return RerouteDestCd2;
	}

	public void setRerouteDestCd2(final String RerouteDestCd2) {
		this.RerouteDestCd2 = RerouteDestCd2;
	}

	public String getRerouteDestCd3() {
		return RerouteDestCd3;
	}

	public void setRerouteDestCd3(final String RerouteDestCd3) {
		this.RerouteDestCd3 = RerouteDestCd3;
	}

	public String getRerouteDestCd4() {
		return RerouteDestCd4;
	}

	public void setRerouteDestCd4(final String RerouteDestCd4) {
		this.RerouteDestCd4 = RerouteDestCd4;
	}

	public String getRerouteDestCd5() {
		return RerouteDestCd5;
	}

	public void setRerouteDestCd5(final String RerouteDestCd5) {
		this.RerouteDestCd5 = RerouteDestCd5;
	}

	public Timestamp getMsgCreateDateTime() {
		return MsgCreateDateTime;
	}

	public void setMsgCreateDateTime(final Timestamp MsgCreateDateTime) {
		this.MsgCreateDateTime = MsgCreateDateTime;
	}

}