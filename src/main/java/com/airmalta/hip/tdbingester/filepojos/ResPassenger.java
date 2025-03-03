package com.airmalta.hip.tdbingester.filepojos;

import java.sql.Date;
import java.sql.Time;


public class ResPassenger extends PNRRecord {

	private String ID;
	private Short PNRPassengerSeqId;
	private String NameFirst;
	private String NameLast;
	private String NameComment;
	private String RelativePassengerNbr;
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

	public String getNameFirst() {
		return NameFirst;
	}

	public void setNameFirst(final String NameFirst) {
		this.NameFirst = NameFirst;
	}

	public String getNameLast() {
		return NameLast;
	}

	public void setNameLast(final String NameLast) {
		this.NameLast = NameLast;
	}

	public String getNameComment() {
		return NameComment;
	}

	public void setNameComment(final String NameComment) {
		this.NameComment = NameComment;
	}

	public String getRelativePassengerNbr() {
		return RelativePassengerNbr;
	}

	public void setRelativePassengerNbr(final String RelativePassengerNbr) {
		this.RelativePassengerNbr = RelativePassengerNbr;
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
		result = prime * result + ((HistoryActionCodeId == null) ? 0 : HistoryActionCodeId.hashCode());
		result = prime * result + ((IntraPNRSetNbr == null) ? 0 : IntraPNRSetNbr.hashCode());
		result = prime * result + ((NameComment == null) ? 0 : NameComment.hashCode());
		result = prime * result + ((NameFirst == null) ? 0 : NameFirst.hashCode());
		result = prime * result + ((NameLast == null) ? 0 : NameLast.hashCode());
		result = prime * result + ((PNRPassengerSeqId == null) ? 0 : PNRPassengerSeqId.hashCode());
		result = prime * result + ((RelativePassengerNbr == null) ? 0 : RelativePassengerNbr.hashCode());
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
		ResPassenger other = (ResPassenger) obj;
		if (HistoryActionCodeId == null) {
			if (other.HistoryActionCodeId != null)
				return false;
		} else if (!HistoryActionCodeId.equals(other.HistoryActionCodeId))
			return false;
		if (IntraPNRSetNbr == null) {
			if (other.IntraPNRSetNbr != null)
				return false;
		} else if (!IntraPNRSetNbr.equals(other.IntraPNRSetNbr))
			return false;
		if (NameComment == null) {
			if (other.NameComment != null)
				return false;
		} else if (!NameComment.equals(other.NameComment))
			return false;
		if (NameFirst == null) {
			if (other.NameFirst != null)
				return false;
		} else if (!NameFirst.equals(other.NameFirst))
			return false;
		if (NameLast == null) {
			if (other.NameLast != null)
				return false;
		} else if (!NameLast.equals(other.NameLast))
			return false;
		if (PNRPassengerSeqId == null) {
			if (other.PNRPassengerSeqId != null)
				return false;
		} else if (!PNRPassengerSeqId.equals(other.PNRPassengerSeqId))
			return false;
		if (RelativePassengerNbr == null) {
			if (other.RelativePassengerNbr != null)
				return false;
		} else if (!RelativePassengerNbr.equals(other.RelativePassengerNbr))
			return false;
		return true;
	}

}