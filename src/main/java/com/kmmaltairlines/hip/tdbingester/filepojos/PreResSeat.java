package com.kmmaltairlines.hip.tdbingester.filepojos;

import java.sql.Date;
import java.sql.Time;

public class PreResSeat extends PNRRecord {

	private String ID;
	private Short PNRPassengerSeqId;
	private Short PRSSeqNbr;
	private String VendorCode;
	private String PRSFlightNumber;
	private Short PRSCompartmentNbr;
	private Short PRSRowNbr;
	private String PRSLetter;
	private String PRSCurrentStatusCode;
	private String SmokingSeatIndicator;
	private String NonSmokingSeatIndicator;
	private String WindowSeatIndicator;
	private String AisleSeatIndicator;
	private String LeftSideSeatIndicator;
	private String ExitSeatIndicator;
	private String RightSideSeatIndicator;
	private String BulkheadSeatIndicator;
	private String UpperCompartmentSeatIndicator;
	private String OverWingSeatIndicator;
	private String HistoryActionCodeId;
	private Date RecordUpdateDate;
	private Time RecordUpdateTime;
	private Short IntraPNRSetNbr;

	public String getID() {
		return ID;
	}

	public void setID(final String ID) {
		this.ID = ID;
	}

	public Short getPNRPassengerSeqId() {
		return PNRPassengerSeqId;
	}

	public void setPNRPassengerSeqId(final Short PNRPassengerSeqId) {
		this.PNRPassengerSeqId = PNRPassengerSeqId;
	}

	public Short getPRSSeqNbr() {
		return PRSSeqNbr;
	}

	public void setPRSSeqNbr(final Short PRSSeqNbr) {
		this.PRSSeqNbr = PRSSeqNbr;
	}

	public String getVendorCode() {
		return VendorCode;
	}

	public void setVendorCode(final String VendorCode) {
		this.VendorCode = VendorCode;
	}

	public String getPRSFlightNumber() {
		return PRSFlightNumber;
	}

	public void setPRSFlightNumber(final String PRSFlightNumber) {
		this.PRSFlightNumber = PRSFlightNumber;
	}

	public Short getPRSCompartmentNbr() {
		return PRSCompartmentNbr;
	}

	public void setPRSCompartmentNbr(final Short PRSCompartmentNbr) {
		this.PRSCompartmentNbr = PRSCompartmentNbr;
	}

	public Short getPRSRowNbr() {
		return PRSRowNbr;
	}

	public void setPRSRowNbr(final Short PRSRowNbr) {
		this.PRSRowNbr = PRSRowNbr;
	}

	public String getPRSLetter() {
		return PRSLetter;
	}

	public void setPRSLetter(final String PRSLetter) {
		this.PRSLetter = PRSLetter;
	}

	public String getPRSCurrentStatusCode() {
		return PRSCurrentStatusCode;
	}

	public void setPRSCurrentStatusCode(final String PRSCurrentStatusCode) {
		this.PRSCurrentStatusCode = PRSCurrentStatusCode;
	}

	public String getSmokingSeatIndicator() {
		return SmokingSeatIndicator;
	}

	public void setSmokingSeatIndicator(final String SmokingSeatIndicator) {
		this.SmokingSeatIndicator = SmokingSeatIndicator;
	}

	public String getNonSmokingSeatIndicator() {
		return NonSmokingSeatIndicator;
	}

	public void setNonSmokingSeatIndicator(final String NonSmokingSeatIndicator) {
		this.NonSmokingSeatIndicator = NonSmokingSeatIndicator;
	}

	public String getWindowSeatIndicator() {
		return WindowSeatIndicator;
	}

	public void setWindowSeatIndicator(final String WindowSeatIndicator) {
		this.WindowSeatIndicator = WindowSeatIndicator;
	}

	public String getAisleSeatIndicator() {
		return AisleSeatIndicator;
	}

	public void setAisleSeatIndicator(final String AisleSeatIndicator) {
		this.AisleSeatIndicator = AisleSeatIndicator;
	}

	public String getLeftSideSeatIndicator() {
		return LeftSideSeatIndicator;
	}

	public void setLeftSideSeatIndicator(final String LeftSideSeatIndicator) {
		this.LeftSideSeatIndicator = LeftSideSeatIndicator;
	}

	public String getExitSeatIndicator() {
		return ExitSeatIndicator;
	}

	public void setExitSeatIndicator(final String ExitSeatIndicator) {
		this.ExitSeatIndicator = ExitSeatIndicator;
	}

	public String getRightSideSeatIndicator() {
		return RightSideSeatIndicator;
	}

	public void setRightSideSeatIndicator(final String RightSideSeatIndicator) {
		this.RightSideSeatIndicator = RightSideSeatIndicator;
	}

	public String getBulkheadSeatIndicator() {
		return BulkheadSeatIndicator;
	}

	public void setBulkheadSeatIndicator(final String BulkheadSeatIndicator) {
		this.BulkheadSeatIndicator = BulkheadSeatIndicator;
	}

	public String getUpperCompartmentSeatIndicator() {
		return UpperCompartmentSeatIndicator;
	}

	public void setUpperCompartmentSeatIndicator(final String UpperCompartmentSeatIndicator) {
		this.UpperCompartmentSeatIndicator = UpperCompartmentSeatIndicator;
	}

	public String getOverWingSeatIndicator() {
		return OverWingSeatIndicator;
	}

	public void setOverWingSeatIndicator(final String OverWingSeatIndicator) {
		this.OverWingSeatIndicator = OverWingSeatIndicator;
	}

	public String getHistoryActionCodeId() {
		return HistoryActionCodeId;
	}

	public void setHistoryActionCodeId(final String HistoryActionCodeId) {
		this.HistoryActionCodeId = HistoryActionCodeId;
	}

	public Date getRecordUpdateDate() {
		return RecordUpdateDate;
	}

	public void setRecordUpdateDate(final Date RecordUpdateDate) {
		this.RecordUpdateDate = RecordUpdateDate;
	}

	public Time getRecordUpdateTime() {
		return RecordUpdateTime;
	}

	public void setRecordUpdateTime(final Time RecordUpdateTime) {
		this.RecordUpdateTime = RecordUpdateTime;
	}

	public Short getIntraPNRSetNbr() {
		return IntraPNRSetNbr;
	}

	public void setIntraPNRSetNbr(final Short IntraPNRSetNbr) {
		this.IntraPNRSetNbr = IntraPNRSetNbr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((IntraPNRSetNbr == null) ? 0 : IntraPNRSetNbr.hashCode());
		result = prime * result + ((PRSSeqNbr == null) ? 0 : PRSSeqNbr.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PreResSeat other = (PreResSeat) obj;
		if (IntraPNRSetNbr == null) {
			if (other.IntraPNRSetNbr != null)
				return false;
		} else if (!IntraPNRSetNbr.equals(other.IntraPNRSetNbr))
			return false;
		if (PRSSeqNbr == null) {
			if (other.PRSSeqNbr != null)
				return false;
		} else if (!PRSSeqNbr.equals(other.PRSSeqNbr))
			return false;
		return true;
	}

}