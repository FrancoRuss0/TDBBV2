package com.airmalta.hip.tdbingester.filepojos;

import java.sql.Date;
import java.sql.Time;

public class ResEmergencyCtc extends PNRRecord {

	private String ID;
	private Short PNRPassengerSeqId;
	private String SourceTypeCode;
	private String SSRIdTypeCode;
	private String SSRStatusCode;
	private String SSRCode;
	private Short EmergencyContactSeqId;
	private String EmergencyPhoneNumber;
	private String EmergencyContactName;
	private String CountryCode;
	private String VendorCode;
	private String SSRText;
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

	public String getSourceTypeCode() {
		return SourceTypeCode;
	}

	public void setSourceTypeCode(final String SourceTypeCode) {
		this.SourceTypeCode = SourceTypeCode;
	}

	public String getSSRIdTypeCode() {
		return SSRIdTypeCode;
	}

	public void setSSRIdTypeCode(final String SSRIdTypeCode) {
		this.SSRIdTypeCode = SSRIdTypeCode;
	}

	public String getSSRStatusCode() {
		return SSRStatusCode;
	}

	public void setSSRStatusCode(final String SSRStatusCode) {
		this.SSRStatusCode = SSRStatusCode;
	}

	public String getSSRCode() {
		return SSRCode;
	}

	public void setSSRCode(final String SSRCode) {
		this.SSRCode = SSRCode;
	}

	public Short getEmergencyContactSeqId() {
		return EmergencyContactSeqId;
	}

	public void setEmergencyContactSeqId(final Short EmergencyContactSeqId) {
		this.EmergencyContactSeqId = EmergencyContactSeqId;
	}

	public String getEmergencyPhoneNumber() {
		return EmergencyPhoneNumber;
	}

	public void setEmergencyPhoneNumber(final String EmergencyPhoneNumber) {
		this.EmergencyPhoneNumber = EmergencyPhoneNumber;
	}

	public String getEmergencyContactName() {
		return EmergencyContactName;
	}

	public void setEmergencyContactName(final String EmergencyContactName) {
		this.EmergencyContactName = EmergencyContactName;
	}

	public String getCountryCode() {
		return CountryCode;
	}

	public void setCountryCode(final String CountryCode) {
		this.CountryCode = CountryCode;
	}

	public String getVendorCode() {
		return VendorCode;
	}

	public void setVendorCode(final String VendorCode) {
		this.VendorCode = VendorCode;
	}

	public String getSSRText() {
		return SSRText;
	}

	public void setSSRText(final String SSRText) {
		this.SSRText = SSRText;
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
		result = prime * result + ((EmergencyContactSeqId == null) ? 0 : EmergencyContactSeqId.hashCode());
		result = prime * result + ((IntraPNRSetNbr == null) ? 0 : IntraPNRSetNbr.hashCode());
		result = prime * result + ((SSRCode == null) ? 0 : SSRCode.hashCode());
		result = prime * result + ((SSRIdTypeCode == null) ? 0 : SSRIdTypeCode.hashCode());
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
		ResEmergencyCtc other = (ResEmergencyCtc) obj;
		if (EmergencyContactSeqId == null) {
			if (other.EmergencyContactSeqId != null)
				return false;
		} else if (!EmergencyContactSeqId.equals(other.EmergencyContactSeqId))
			return false;
		if (IntraPNRSetNbr == null) {
			if (other.IntraPNRSetNbr != null)
				return false;
		} else if (!IntraPNRSetNbr.equals(other.IntraPNRSetNbr))
			return false;
		if (SSRCode == null) {
			if (other.SSRCode != null)
				return false;
		} else if (!SSRCode.equals(other.SSRCode))
			return false;
		if (SSRIdTypeCode == null) {
			if (other.SSRIdTypeCode != null)
				return false;
		} else if (!SSRIdTypeCode.equals(other.SSRIdTypeCode))
			return false;
		return true;
	}

}