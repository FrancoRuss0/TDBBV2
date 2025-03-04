package com.kmmaltairlines.hip.tdbingester.filepojos;

import java.sql.Date;
import java.sql.Time;

public class ResRemarks extends PNRRecord {

	private String ID;
	private Short ResRemarkSeqId;
	private String RemarkText;
	private Short RemarkType;
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

	public Short getResRemarkSeqId() {
		return ResRemarkSeqId;
	}

	public void setResRemarkSeqId(final Short ResRemarkSeqId) {
		this.ResRemarkSeqId = ResRemarkSeqId;
	}

	public String getRemarkText() {
		return RemarkText;
	}

	public void setRemarkText(final String RemarkText) {
		this.RemarkText = RemarkText;
	}

	public Short getRemarkType() {
		return RemarkType;
	}

	public void setRemarkType(final Short RemarkType) {
		this.RemarkType = RemarkType;
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
		result = prime * result + ((ResRemarkSeqId == null) ? 0 : ResRemarkSeqId.hashCode());
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
		ResRemarks other = (ResRemarks) obj;
		if (IntraPNRSetNbr == null) {
			if (other.IntraPNRSetNbr != null)
				return false;
		} else if (!IntraPNRSetNbr.equals(other.IntraPNRSetNbr))
			return false;
		if (ResRemarkSeqId == null) {
			if (other.ResRemarkSeqId != null)
				return false;
		} else if (!ResRemarkSeqId.equals(other.ResRemarkSeqId))
			return false;
		return true;
	}

}