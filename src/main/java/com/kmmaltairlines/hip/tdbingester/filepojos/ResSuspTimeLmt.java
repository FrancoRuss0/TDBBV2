package com.kmmaltairlines.hip.tdbingester.filepojos;

import java.sql.Date;
import java.sql.Time;

public class ResSuspTimeLmt extends PNRRecord {

	private String ID;
	private Short SuspenseSequenceId;
	private String TimeLimitActionTime;
	private Date TimeLimitActionDate;
	private String TimeLimitLocationCode;
	private String TimeLimitVendorCode;
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

	public Short getSuspenseSequenceId() {
		return SuspenseSequenceId;
	}

	public void setSuspenseSequenceId(final Short SuspenseSequenceId) {
		this.SuspenseSequenceId = SuspenseSequenceId;
	}

	public String getTimeLimitActionTime() {
		return TimeLimitActionTime;
	}

	public void setTimeLimitActionTime(final String TimeLimitActionTime) {
		this.TimeLimitActionTime = TimeLimitActionTime;
	}

	public Date getTimeLimitActionDate() {
		return TimeLimitActionDate;
	}

	public void setTimeLimitActionDate(final Date TimeLimitActionDate) {
		this.TimeLimitActionDate = TimeLimitActionDate;
	}

	public String getTimeLimitLocationCode() {
		return TimeLimitLocationCode;
	}

	public void setTimeLimitLocationCode(final String TimeLimitLocationCode) {
		this.TimeLimitLocationCode = TimeLimitLocationCode;
	}

	public String getTimeLimitVendorCode() {
		return TimeLimitVendorCode;
	}

	public void setTimeLimitVendorCode(final String TimeLimitVendorCode) {
		this.TimeLimitVendorCode = TimeLimitVendorCode;
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
		result = prime * result + ((SuspenseSequenceId == null) ? 0 : SuspenseSequenceId.hashCode());
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
		ResSuspTimeLmt other = (ResSuspTimeLmt) obj;
		if (IntraPNRSetNbr == null) {
			if (other.IntraPNRSetNbr != null)
				return false;
		} else if (!IntraPNRSetNbr.equals(other.IntraPNRSetNbr))
			return false;
		if (SuspenseSequenceId == null) {
			if (other.SuspenseSequenceId != null)
				return false;
		} else if (!SuspenseSequenceId.equals(other.SuspenseSequenceId))
			return false;
		return true;
	}

}