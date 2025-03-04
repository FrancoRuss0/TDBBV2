package com.kmmaltairlines.hip.tdbingester.filepojos;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class ACSFlightHistory {

	private String SourceSystemID;
	private Date ACSFltSegDate;
	private String AirlineCode;
	private String FltNbr;
	private String AirlineOrigAirport;
	private String AirlineDestAirport;
	private Time SchdServiceStartTime;
	private String AAACityCode;
	private String AgentSine;
	private Date ActionDate;
	private Time ActionTime;
	private String AgntStationLNIATA;
	private String ActionItem;
	private String AgntDtyCd;
	private String AgntHomeStation;
	private Timestamp MsgCreateDateTime;

	public String getSourceSystemID() {
		return SourceSystemID;
	}

	public void setSourceSystemID(final String SourceSystemID) {
		this.SourceSystemID = SourceSystemID;
	}

	public Date getACSFltSegDate() {
		return ACSFltSegDate;
	}

	public void setACSFltSegDate(final Date ACSFltSegDate) {
		this.ACSFltSegDate = ACSFltSegDate;
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

	public Time getSchdServiceStartTime() {
		return SchdServiceStartTime;
	}

	public void setSchdServiceStartTime(final Time SchdServiceStartTime) {
		this.SchdServiceStartTime = SchdServiceStartTime;
	}

	public String getAAACityCode() {
		return AAACityCode;
	}

	public void setAAACityCode(final String AAACityCode) {
		this.AAACityCode = AAACityCode;
	}

	public String getAgentSine() {
		return AgentSine;
	}

	public void setAgentSine(final String AgentSine) {
		this.AgentSine = AgentSine;
	}

	public Date getActionDate() {
		return ActionDate;
	}

	public void setActionDate(final Date ActionDate) {
		this.ActionDate = ActionDate;
	}

	public Time getActionTime() {
		return ActionTime;
	}

	public void setActionTime(final Time ActionTime) {
		this.ActionTime = ActionTime;
	}

	public String getAgntStationLNIATA() {
		return AgntStationLNIATA;
	}

	public void setAgntStationLNIATA(final String AgntStationLNIATA) {
		this.AgntStationLNIATA = AgntStationLNIATA;
	}

	public String getActionItem() {
		return ActionItem;
	}

	public void setActionItem(final String ActionItem) {
		this.ActionItem = ActionItem;
	}

	public String getAgntDtyCd() {
		return AgntDtyCd;
	}

	public void setAgntDtyCd(final String AgntDtyCd) {
		this.AgntDtyCd = AgntDtyCd;
	}

	public String getAgntHomeStation() {
		return AgntHomeStation;
	}

	public void setAgntHomeStation(final String AgntHomeStation) {
		this.AgntHomeStation = AgntHomeStation;
	}

	public Timestamp getMsgCreateDateTime() {
		return MsgCreateDateTime;
	}

	public void setMsgCreateDateTime(final Timestamp MsgCreateDateTime) {
		this.MsgCreateDateTime = MsgCreateDateTime;
	}

}