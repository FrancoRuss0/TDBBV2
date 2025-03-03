package com.airmalta.hip.tdbingester.filepojos;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;


public class ACSFlight {
	
	private String SourceSystemID;
	private String AirlineCode;
	private String FltNbr;
	private Date ServiceStartDate;
	private String AirlineOrigAirport;
	private String AirlineDestAirport;
	private String SchdAirlineOrigAirport;
	private String SchdAirlineDestAirport;
	private String AirlineOrigGate;
	private String COGInd;
	private String FltOverFlyInd;
	private String FltFlagStopInd;
	private String FltStubInd;
	private String GateReaderLNIATA;
	private Date EstServiceEndDate;
	private Time EstServiceEndTime;
	private Date EstServiceStartDate;
	private Time EstServiceStartTime;
	private Date SchdServiceStartDate;
	private Time SchdServiceStartTime;
	private Date SchdServiceEndDate;
	private Time SchdServiceEndTime;
	private Date FltCloseDate;
	private Time FltCloseTime;
	private Date PDCDate;
	private Time PDCTime;
	private String FltLegDelayedInd;
	private String FltLegStatus;
	private String TailNbr;
	private Timestamp MsgCreateDateTime;
	private String EquipmentType;
	private String AircraftConfig;
	private Short TotalPaxCount;
	private Short ReservedFutureUse1;
	private Short ReservedFutureUse2;
	private Short ReservedFutureUse3;
	private Short ReservedFutureUse4;
	private Short ReservedFutureUse5;
	private Short ReservedFutureUse6;
	private Short ReservedFutureUse7;
	private Short ReservedFutureUse8;
	private Short ReservedFutureUse9;

	public String getSourceSystemID() {
		return SourceSystemID;
	}

	public void setSourceSystemID(final String SourceSystemID) {
		this.SourceSystemID = SourceSystemID;
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

	public String getAirlineDestAirport() {
		return AirlineDestAirport;
	}

	public void setAirlineDestAirport(final String AirlineDestAirport) {
		this.AirlineDestAirport = AirlineDestAirport;
	}

	public String getSchdAirlineOrigAirport() {
		return SchdAirlineOrigAirport;
	}

	public void setSchdAirlineOrigAirport(final String SchdAirlineOrigAirport) {
		this.SchdAirlineOrigAirport = SchdAirlineOrigAirport;
	}

	public String getSchdAirlineDestAirport() {
		return SchdAirlineDestAirport;
	}

	public void setSchdAirlineDestAirport(final String SchdAirlineDestAirport) {
		this.SchdAirlineDestAirport = SchdAirlineDestAirport;
	}

	public String getAirlineOrigGate() {
		return AirlineOrigGate;
	}

	public void setAirlineOrigGate(final String AirlineOrigGate) {
		this.AirlineOrigGate = AirlineOrigGate;
	}

	public String getCOGInd() {
		return COGInd;
	}

	public void setCOGInd(final String COGInd) {
		this.COGInd = COGInd;
	}

	public String getFltOverFlyInd() {
		return FltOverFlyInd;
	}

	public void setFltOverFlyInd(final String FltOverFlyInd) {
		this.FltOverFlyInd = FltOverFlyInd;
	}

	public String getFltFlagStopInd() {
		return FltFlagStopInd;
	}

	public void setFltFlagStopInd(final String FltFlagStopInd) {
		this.FltFlagStopInd = FltFlagStopInd;
	}

	public String getFltStubInd() {
		return FltStubInd;
	}

	public void setFltStubInd(final String FltStubInd) {
		this.FltStubInd = FltStubInd;
	}

	public String getGateReaderLNIATA() {
		return GateReaderLNIATA;
	}

	public void setGateReaderLNIATA(final String GateReaderLNIATA) {
		this.GateReaderLNIATA = GateReaderLNIATA;
	}

	public Date getEstServiceEndDate() {
		return EstServiceEndDate;
	}

	public void setEstServiceEndDate(final Date EstServiceEndDate) {
		this.EstServiceEndDate = EstServiceEndDate;
	}

	public Time getEstServiceEndTime() {
		return EstServiceEndTime;
	}

	public void setEstServiceEndTime(final Time EstServiceEndTime) {
		this.EstServiceEndTime = EstServiceEndTime;
	}

	public Date getEstServiceStartDate() {
		return EstServiceStartDate;
	}

	public void setEstServiceStartDate(final Date EstServiceStartDate) {
		this.EstServiceStartDate = EstServiceStartDate;
	}

	public Time getEstServiceStartTime() {
		return EstServiceStartTime;
	}

	public void setEstServiceStartTime(final Time EstServiceStartTime) {
		this.EstServiceStartTime = EstServiceStartTime;
	}

	public Date getSchdServiceStartDate() {
		return SchdServiceStartDate;
	}

	public void setSchdServiceStartDate(final Date SchdServiceStartDate) {
		this.SchdServiceStartDate = SchdServiceStartDate;
	}

	public Time getSchdServiceStartTime() {
		return SchdServiceStartTime;
	}

	public void setSchdServiceStartTime(final Time SchdServiceStartTime) {
		this.SchdServiceStartTime = SchdServiceStartTime;
	}

	public Date getSchdServiceEndDate() {
		return SchdServiceEndDate;
	}

	public void setSchdServiceEndDate(final Date SchdServiceEndDate) {
		this.SchdServiceEndDate = SchdServiceEndDate;
	}

	public Time getSchdServiceEndTime() {
		return SchdServiceEndTime;
	}

	public void setSchdServiceEndTime(final Time SchdServiceEndTime) {
		this.SchdServiceEndTime = SchdServiceEndTime;
	}

	public Date getFltCloseDate() {
		return FltCloseDate;
	}

	public void setFltCloseDate(final Date FltCloseDate) {
		this.FltCloseDate = FltCloseDate;
	}

	public Time getFltCloseTime() {
		return FltCloseTime;
	}

	public void setFltCloseTime(final Time FltCloseTime) {
		this.FltCloseTime = FltCloseTime;
	}

	public Date getPDCDate() {
		return PDCDate;
	}

	public void setPDCDate(final Date PDCDate) {
		this.PDCDate = PDCDate;
	}

	public Time getPDCTime() {
		return PDCTime;
	}

	public void setPDCTime(final Time PDCTime) {
		this.PDCTime = PDCTime;
	}

	public String getFltLegDelayedInd() {
		return FltLegDelayedInd;
	}

	public void setFltLegDelayedInd(final String FltLegDelayedInd) {
		this.FltLegDelayedInd = FltLegDelayedInd;
	}

	public String getFltLegStatus() {
		return FltLegStatus;
	}

	public void setFltLegStatus(final String FltLegStatus) {
		this.FltLegStatus = FltLegStatus;
	}

	public String getTailNbr() {
		return TailNbr;
	}

	public void setTailNbr(final String TailNbr) {
		this.TailNbr = TailNbr;
	}

	public Timestamp getMsgCreateDateTime() {
		return MsgCreateDateTime;
	}

	public void setMsgCreateDateTime(final Timestamp MsgCreateDateTime) {
		this.MsgCreateDateTime = MsgCreateDateTime;
	}

	public String getEquipmentType() {
		return EquipmentType;
	}

	public void setEquipmentType(final String EquipmentType) {
		this.EquipmentType = EquipmentType;
	}

	public String getAircraftConfig() {
		return AircraftConfig;
	}

	public void setAircraftConfig(final String AircraftConfig) {
		this.AircraftConfig = AircraftConfig;
	}

	public Short getTotalPaxCount() {
		return TotalPaxCount;
	}

	public void setTotalPaxCount(final Short TotalPaxCount) {
		this.TotalPaxCount = TotalPaxCount;
	}

	public Short getReservedFutureUse1() {
		return ReservedFutureUse1;
	}

	public void setReservedFutureUse1(final Short ReservedFutureUse1) {
		this.ReservedFutureUse1 = ReservedFutureUse1;
	}

	public Short getReservedFutureUse2() {
		return ReservedFutureUse2;
	}

	public void setReservedFutureUse2(final Short ReservedFutureUse2) {
		this.ReservedFutureUse2 = ReservedFutureUse2;
	}

	public Short getReservedFutureUse3() {
		return ReservedFutureUse3;
	}

	public void setReservedFutureUse3(final Short ReservedFutureUse3) {
		this.ReservedFutureUse3 = ReservedFutureUse3;
	}

	public Short getReservedFutureUse4() {
		return ReservedFutureUse4;
	}

	public void setReservedFutureUse4(final Short ReservedFutureUse4) {
		this.ReservedFutureUse4 = ReservedFutureUse4;
	}

	public Short getReservedFutureUse5() {
		return ReservedFutureUse5;
	}

	public void setReservedFutureUse5(final Short ReservedFutureUse5) {
		this.ReservedFutureUse5 = ReservedFutureUse5;
	}

	public Short getReservedFutureUse6() {
		return ReservedFutureUse6;
	}

	public void setReservedFutureUse6(final Short ReservedFutureUse6) {
		this.ReservedFutureUse6 = ReservedFutureUse6;
	}

	public Short getReservedFutureUse7() {
		return ReservedFutureUse7;
	}

	public void setReservedFutureUse7(final Short ReservedFutureUse7) {
		this.ReservedFutureUse7 = ReservedFutureUse7;
	}

	public Short getReservedFutureUse8() {
		return ReservedFutureUse8;
	}

	public void setReservedFutureUse8(final Short ReservedFutureUse8) {
		this.ReservedFutureUse8 = ReservedFutureUse8;
	}

	public Short getReservedFutureUse9() {
		return ReservedFutureUse9;
	}

	public void setReservedFutureUse9(final Short ReservedFutureUse9) {
		this.ReservedFutureUse9 = ReservedFutureUse9;
	}
	
}