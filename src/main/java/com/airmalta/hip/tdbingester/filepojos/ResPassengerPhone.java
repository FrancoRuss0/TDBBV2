package com.airmalta.hip.tdbingester.filepojos;

import java.sql.Date;
import java.sql.Time;


public class ResPassengerPhone extends PNRRecord {

	private String ID;
	private Short PNRPassengerPhoneSeqId;
	private String CityPhoneCode;
	private String PhoneNbrText;
	private String PhoneTypeCode;
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

	public Short getPNRPassengerPhoneSeqId() {
		return PNRPassengerPhoneSeqId;
	}

	public void setPNRPassengerPhoneSeqId(final Short PNRPassengerPhoneSeqId) {
		this.PNRPassengerPhoneSeqId = PNRPassengerPhoneSeqId;
	}

	public String getCityPhoneCode() {
		return CityPhoneCode;
	}

	public void setCityPhoneCode(final String CityPhoneCode) {
		this.CityPhoneCode = CityPhoneCode;
	}

	public String getPhoneNbrText() {
		return PhoneNbrText;
	}

	public void setPhoneNbrText(final String PhoneNbrText) {
		this.PhoneNbrText = PhoneNbrText;
	}

	public String getPhoneTypeCode() {
		return PhoneTypeCode;
	}

	public void setPhoneTypeCode(final String PhoneTypeCode) {
		this.PhoneTypeCode = PhoneTypeCode;
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
		result = prime * result + ((PNRPassengerPhoneSeqId == null) ? 0 : PNRPassengerPhoneSeqId.hashCode());
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
		ResPassengerPhone other = (ResPassengerPhone) obj;
		if (IntraPNRSetNbr == null) {
			if (other.IntraPNRSetNbr != null)
				return false;
		} else if (!IntraPNRSetNbr.equals(other.IntraPNRSetNbr))
			return false;
		if (PNRPassengerPhoneSeqId == null) {
			if (other.PNRPassengerPhoneSeqId != null)
				return false;
		} else if (!PNRPassengerPhoneSeqId.equals(other.PNRPassengerPhoneSeqId))
			return false;
		return true;
	}

}