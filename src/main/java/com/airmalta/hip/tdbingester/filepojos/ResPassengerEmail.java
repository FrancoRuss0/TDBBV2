package com.airmalta.hip.tdbingester.filepojos;

import java.sql.Date;
import java.sql.Time;


public class ResPassengerEmail extends PNRRecord {

	private String ID;
	private Short PNRPassengerEMailSeqId;
	private String EMailAddress;
	private String HistoryActionCodeId;
	private Date RecordUpdateDate;
	private Time RecordUpdateTime;
	private Short IntraPNRSetNbr;
	private Short PNRPassengerSeqID;

	public String getID() {
		return ID;
	}

	public void setID(final String ID) {
		this.ID = ID;
	}

	public Short getPNRPassengerEMailSeqId() {
		return PNRPassengerEMailSeqId;
	}

	public void setPNRPassengerEMailSeqId(final Short PNRPassengerEMailSeqId) {
		this.PNRPassengerEMailSeqId = PNRPassengerEMailSeqId;
	}

	public String getEMailAddress() {
		return EMailAddress;
	}

	public void setEMailAddress(final String EMailAddress) {
		this.EMailAddress = EMailAddress;
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

	public Short getPNRPassengerSeqID() {
		return PNRPassengerSeqID;
	}

	public void setPNRPassengerSeqID(final Short PNRPassengerSeqID) {
		this.PNRPassengerSeqID = PNRPassengerSeqID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((EMailAddress == null) ? 0 : EMailAddress.hashCode());
		result = prime * result + ((HistoryActionCodeId == null) ? 0 : HistoryActionCodeId.hashCode());
		result = prime * result + ((IntraPNRSetNbr == null) ? 0 : IntraPNRSetNbr.hashCode());
		result = prime * result + ((PNRPassengerEMailSeqId == null) ? 0 : PNRPassengerEMailSeqId.hashCode());
		result = prime * result + ((PNRPassengerSeqID == null) ? 0 : PNRPassengerSeqID.hashCode());
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
		ResPassengerEmail other = (ResPassengerEmail) obj;
		if (EMailAddress == null) {
			if (other.EMailAddress != null)
				return false;
		} else if (!EMailAddress.equals(other.EMailAddress))
			return false;
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
		if (PNRPassengerEMailSeqId == null) {
			if (other.PNRPassengerEMailSeqId != null)
				return false;
		} else if (!PNRPassengerEMailSeqId.equals(other.PNRPassengerEMailSeqId))
			return false;
		if (PNRPassengerSeqID == null) {
			if (other.PNRPassengerSeqID != null)
				return false;
		} else if (!PNRPassengerSeqID.equals(other.PNRPassengerSeqID))
			return false;
		return true;
	}

}