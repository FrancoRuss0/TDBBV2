package com.airmalta.hip.tdbingester.filepojos;

import java.sql.Date;
import java.sql.Time;

public class ResSSR extends PNRRecord {

	private String ID;
	private Short ResSSRSeqId;
	private Short PNRPassengerSeqId;
	private String SourceTypeCode;
	private String SSRIdTypeCode;
	private String SSRStatusCode;
	private String SSRFlightNumber;
	private Short SSRNbrInParty;
	private Date SSRStartDate;
	private String VendorCode;
	private String SSRCode;
	private String SSRText;
	private String ClassOfService;
	private String ServiceStartCityCode;
	private String ServiceEndCityCode;
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

	public Short getResSSRSeqId() {
		return ResSSRSeqId;
	}

	public void setResSSRSeqId(final Short ResSSRSeqId) {
		this.ResSSRSeqId = ResSSRSeqId;
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

	public String getSSRFlightNumber() {
		return SSRFlightNumber;
	}

	public void setSSRFlightNumber(final String SSRFlightNumber) {
		this.SSRFlightNumber = SSRFlightNumber;
	}

	public Short getSSRNbrInParty() {
		return SSRNbrInParty;
	}

	public void setSSRNbrInParty(final Short SSRNbrInParty) {
		this.SSRNbrInParty = SSRNbrInParty;
	}

	public Date getSSRStartDate() {
		return SSRStartDate;
	}

	public void setSSRStartDate(final Date SSRStartDate) {
		this.SSRStartDate = SSRStartDate;
	}

	public String getVendorCode() {
		return VendorCode;
	}

	public void setVendorCode(final String VendorCode) {
		this.VendorCode = VendorCode;
	}

	public String getSSRCode() {
		return SSRCode;
	}

	public void setSSRCode(final String SSRCode) {
		this.SSRCode = SSRCode;
	}

	public String getSSRText() {
		return SSRText;
	}

	public void setSSRText(final String SSRText) {
		this.SSRText = SSRText;
	}

	public String getClassOfService() {
		return ClassOfService;
	}

	public void setClassOfService(final String ClassOfService) {
		this.ClassOfService = ClassOfService;
	}

	public String getServiceStartCityCode() {
		return ServiceStartCityCode;
	}

	public void setServiceStartCityCode(final String ServiceStartCityCode) {
		this.ServiceStartCityCode = ServiceStartCityCode;
	}

	public String getServiceEndCityCode() {
		return ServiceEndCityCode;
	}

	public void setServiceEndCityCode(final String ServiceEndCityCode) {
		this.ServiceEndCityCode = ServiceEndCityCode;
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
		result = prime * result + ((PNRPassengerSeqId == null) ? 0 : PNRPassengerSeqId.hashCode());
		result = prime * result + ((ResSSRSeqId == null) ? 0 : ResSSRSeqId.hashCode());
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
		ResSSR other = (ResSSR) obj;
		if (IntraPNRSetNbr == null) {
			if (other.IntraPNRSetNbr != null)
				return false;
		} else if (!IntraPNRSetNbr.equals(other.IntraPNRSetNbr))
			return false;
		if (PNRPassengerSeqId == null) {
			if (other.PNRPassengerSeqId != null)
				return false;
		} else if (!PNRPassengerSeqId.equals(other.PNRPassengerSeqId))
			return false;
		if (ResSSRSeqId == null) {
			if (other.ResSSRSeqId != null)
				return false;
		} else if (!ResSSRSeqId.equals(other.ResSSRSeqId))
			return false;
		if (SSRIdTypeCode == null) {
			if (other.SSRIdTypeCode != null)
				return false;
		} else if (!SSRIdTypeCode.equals(other.SSRIdTypeCode))
			return false;
		return true;
	}

}