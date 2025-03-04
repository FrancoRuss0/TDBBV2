package com.kmmaltairlines.hip.tdbingester.filepojos;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class ACSPaxHistory {

	private String SourceSystemID;
	private Date ACSFltSegDate;
	private String AirlineCode;
	private String FltNbr;
	private String AirlineOrigAirport;
	private String PNRLocatorId;
	private String NameLast;
	private String NameFirst;
	private String AirlineDestAirport;
	private Date SchdServiceStartDate;
	private Time SchdServiceStartTime;
	private String AAACityCode;
	private String AgentSine;
	private Date ActionDate;
	private Time ActionTime;
	private String AgntStationLNIATA;
	private String ActionItem;
	private String SeatLtr;
	private String SeatNbr;
	private String NbrOfBags;
	private String EditCode;
	private String AgntDtyCd;
	private String AgntHomeStation;
	private Short PaxID;
	private Short ItinID;
	private String PrevSeatNbr;
	private String PrevSeatLtr;
	private String OnBoardStatus;
	private String BPIssueStatus;
	private String BPReprintedStatus;
	private String BagTagInd;
	private Timestamp MsgCreateDateTime;
	private String Prev_BagTagInd;
	private String Prev_OnBoardStatus;
	private String Prev_BPIssueStatus;
	private String Prev_BPReprintedStatus;

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

	public String getPNRLocatorId() {
		return PNRLocatorId;
	}

	public void setPNRLocatorId(final String PNRLocatorId) {
		this.PNRLocatorId = PNRLocatorId;
	}

	public String getNameLast() {
		return NameLast;
	}

	public void setNameLast(final String NameLast) {
		this.NameLast = NameLast;
	}

	public String getNameFirst() {
		return NameFirst;
	}

	public void setNameFirst(final String NameFirst) {
		this.NameFirst = NameFirst;
	}

	public String getAirlineDestAirport() {
		return AirlineDestAirport;
	}

	public void setAirlineDestAirport(final String AirlineDestAirport) {
		this.AirlineDestAirport = AirlineDestAirport;
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

	public String getSeatLtr() {
		return SeatLtr;
	}

	public void setSeatLtr(final String SeatLtr) {
		this.SeatLtr = SeatLtr;
	}

	public String getSeatNbr() {
		return SeatNbr;
	}

	public void setSeatNbr(final String SeatNbr) {
		this.SeatNbr = SeatNbr;
	}

	public String getNbrOfBags() {
		return NbrOfBags;
	}

	public void setNbrOfBags(final String NbrOfBags) {
		this.NbrOfBags = NbrOfBags;
	}

	public String getEditCode() {
		return EditCode;
	}

	public void setEditCode(final String EditCode) {
		this.EditCode = EditCode;
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

	public Short getPaxID() {
		return PaxID;
	}

	public void setPaxID(final Short PaxID) {
		this.PaxID = PaxID;
	}

	public Short getItinID() {
		return ItinID;
	}

	public void setItinID(final Short ItinID) {
		this.ItinID = ItinID;
	}

	public String getPrevSeatNbr() {
		return PrevSeatNbr;
	}

	public void setPrevSeatNbr(final String PrevSeatNbr) {
		this.PrevSeatNbr = PrevSeatNbr;
	}

	public String getPrevSeatLtr() {
		return PrevSeatLtr;
	}

	public void setPrevSeatLtr(final String PrevSeatLtr) {
		this.PrevSeatLtr = PrevSeatLtr;
	}

	public String getOnBoardStatus() {
		return OnBoardStatus;
	}

	public void setOnBoardStatus(final String OnBoardStatus) {
		this.OnBoardStatus = OnBoardStatus;
	}

	public String getBPIssueStatus() {
		return BPIssueStatus;
	}

	public void setBPIssueStatus(final String BPIssueStatus) {
		this.BPIssueStatus = BPIssueStatus;
	}

	public String getBPReprintedStatus() {
		return BPReprintedStatus;
	}

	public void setBPReprintedStatus(final String BPReprintedStatus) {
		this.BPReprintedStatus = BPReprintedStatus;
	}

	public String getBagTagInd() {
		return BagTagInd;
	}

	public void setBagTagInd(final String BagTagInd) {
		this.BagTagInd = BagTagInd;
	}

	public Timestamp getMsgCreateDateTime() {
		return MsgCreateDateTime;
	}

	public void setMsgCreateDateTime(final Timestamp MsgCreateDateTime) {
		this.MsgCreateDateTime = MsgCreateDateTime;
	}

	public String getPrev_BagTagInd() {
		return Prev_BagTagInd;
	}

	public void setPrev_BagTagInd(final String Prev_BagTagInd) {
		this.Prev_BagTagInd = Prev_BagTagInd;
	}

	public String getPrev_OnBoardStatus() {
		return Prev_OnBoardStatus;
	}

	public void setPrev_OnBoardStatus(final String Prev_OnBoardStatus) {
		this.Prev_OnBoardStatus = Prev_OnBoardStatus;
	}

	public String getPrev_BPIssueStatus() {
		return Prev_BPIssueStatus;
	}

	public void setPrev_BPIssueStatus(final String Prev_BPIssueStatus) {
		this.Prev_BPIssueStatus = Prev_BPIssueStatus;
	}

	public String getPrev_BPReprintedStatus() {
		return Prev_BPReprintedStatus;
	}

	public void setPrev_BPReprintedStatus(final String Prev_BPReprintedStatus) {
		this.Prev_BPReprintedStatus = Prev_BPReprintedStatus;
	}

}