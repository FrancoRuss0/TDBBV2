package com.kmmaltairlines.hip.tdbingester.filepojos;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

public class ACSPaxSeat {

	private String SourceSystemID;
	private String PNRLocatorId;
	private Date PNRCreateDate;
	private Short ResPaxId;
	private String AirlineCode;
	private String FltNbr;
	private Date ServiceStartDate;
	private String AirlineOrigAirport;
	private String CabinCode;
	private String SeatRowNbr;
	private String SeatLtr;
	private String PreResSeatInd;
	private String JumpSeatTypeCode;
	private String JumpSeatRowNbr;
	private String JumpSeatLtr;
	private BigDecimal PaidUpgradeACAmt;
	private String InventoryUpgradeInd;
	private String DowngradeInd;
	private String UpgradeInd;
	private String CoachUpgradeInd;
	private String BusinessUpgradeInd;
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

	public String getCabinCode() {
		return CabinCode;
	}

	public void setCabinCode(final String CabinCode) {
		this.CabinCode = CabinCode;
	}

	public String getSeatRowNbr() {
		return SeatRowNbr;
	}

	public void setSeatRowNbr(final String SeatRowNbr) {
		this.SeatRowNbr = SeatRowNbr;
	}

	public String getSeatLtr() {
		return SeatLtr;
	}

	public void setSeatLtr(final String SeatLtr) {
		this.SeatLtr = SeatLtr;
	}

	public String getPreResSeatInd() {
		return PreResSeatInd;
	}

	public void setPreResSeatInd(final String PreResSeatInd) {
		this.PreResSeatInd = PreResSeatInd;
	}

	public String getJumpSeatTypeCode() {
		return JumpSeatTypeCode;
	}

	public void setJumpSeatTypeCode(final String JumpSeatTypeCode) {
		this.JumpSeatTypeCode = JumpSeatTypeCode;
	}

	public String getJumpSeatRowNbr() {
		return JumpSeatRowNbr;
	}

	public void setJumpSeatRowNbr(final String JumpSeatRowNbr) {
		this.JumpSeatRowNbr = JumpSeatRowNbr;
	}

	public String getJumpSeatLtr() {
		return JumpSeatLtr;
	}

	public void setJumpSeatLtr(final String JumpSeatLtr) {
		this.JumpSeatLtr = JumpSeatLtr;
	}

	public BigDecimal getPaidUpgradeACAmt() {
		return PaidUpgradeACAmt;
	}

	public void setPaidUpgradeACAmt(final BigDecimal PaidUpgradeACAmt) {
		this.PaidUpgradeACAmt = PaidUpgradeACAmt;
	}

	public String getInventoryUpgradeInd() {
		return InventoryUpgradeInd;
	}

	public void setInventoryUpgradeInd(final String InventoryUpgradeInd) {
		this.InventoryUpgradeInd = InventoryUpgradeInd;
	}

	public String getDowngradeInd() {
		return DowngradeInd;
	}

	public void setDowngradeInd(final String DowngradeInd) {
		this.DowngradeInd = DowngradeInd;
	}

	public String getUpgradeInd() {
		return UpgradeInd;
	}

	public void setUpgradeInd(final String UpgradeInd) {
		this.UpgradeInd = UpgradeInd;
	}

	public String getCoachUpgradeInd() {
		return CoachUpgradeInd;
	}

	public void setCoachUpgradeInd(final String CoachUpgradeInd) {
		this.CoachUpgradeInd = CoachUpgradeInd;
	}

	public String getBusinessUpgradeInd() {
		return BusinessUpgradeInd;
	}

	public void setBusinessUpgradeInd(final String BusinessUpgradeInd) {
		this.BusinessUpgradeInd = BusinessUpgradeInd;
	}

	public Timestamp getMsgCreateDateTime() {
		return MsgCreateDateTime;
	}

	public void setMsgCreateDateTime(final Timestamp MsgCreateDateTime) {
		this.MsgCreateDateTime = MsgCreateDateTime;
	}

}