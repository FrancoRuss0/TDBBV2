package com.airmalta.hip.tdbingester.filepojos;

import java.sql.Date;
import java.sql.Time;


public class ResPaxDoc extends PNRRecord {

	private String ID;
	private Short PassengerDocSeqId;
	private Short PNRPassengerSeqId;
	private Date DocBirthdate;
	private String DocNumber;
	private String DocTypeCode;
	private String GenderCode;
	private String InfantInd;
	private String IssueCountryCode;
	private String PassengerFirstName;
	private String PassengerSecondName;
	private String PassengerLastName;
	private String PrimaryDocHolderInd;
	private String PrimaryDocHolderFirstName;
	private String PrimaryDocHolderLastName;
	private String SourceTypeCode;
	private String SSRCode;
	private String SSRIdTypeCode;
	private Short SSRNumberInParty;
	private String SSRStatusCode;
	private String SSRText;
	private String VendorCode;
	private String HistoryActionCodeId;
	private Date RecordUpdateDate;
	private Time RecordUpdateTime;
	private Short IntraPNRSetNbr;
	private Date DocIssueDate;
	private Date DocExpDate;

	public String getID() {
		return ID;
	}

	public void setID(final String ID) {
		this.ID = ID;
	}

	public Short getPassengerDocSeqId() {
		return PassengerDocSeqId;
	}

	public void setPassengerDocSeqId(final Short PassengerDocSeqId) {
		this.PassengerDocSeqId = PassengerDocSeqId;
	}

	public Short getPNRPassengerSeqId() {
		return PNRPassengerSeqId;
	}

	public void setPNRPassengerSeqId(final Short PNRPassengerSeqId) {
		this.PNRPassengerSeqId = PNRPassengerSeqId;
	}

	public Date getDocBirthdate() {
		return DocBirthdate;
	}

	public void setDocBirthdate(final Date DocBirthdate) {
		this.DocBirthdate = DocBirthdate;
	}

	public String getDocNumber() {
		return DocNumber;
	}

	public void setDocNumber(final String DocNumber) {
		this.DocNumber = DocNumber;
	}

	public String getDocTypeCode() {
		return DocTypeCode;
	}

	public void setDocTypeCode(final String DocTypeCode) {
		this.DocTypeCode = DocTypeCode;
	}

	public String getGenderCode() {
		return GenderCode;
	}

	public void setGenderCode(final String GenderCode) {
		this.GenderCode = GenderCode;
	}

	public String getInfantInd() {
		return InfantInd;
	}

	public void setInfantInd(final String InfantInd) {
		this.InfantInd = InfantInd;
	}

	public String getIssueCountryCode() {
		return IssueCountryCode;
	}

	public void setIssueCountryCode(final String IssueCountryCode) {
		this.IssueCountryCode = IssueCountryCode;
	}

	public String getPassengerFirstName() {
		return PassengerFirstName;
	}

	public void setPassengerFirstName(final String PassengerFirstName) {
		this.PassengerFirstName = PassengerFirstName;
	}

	public String getPassengerSecondName() {
		return PassengerSecondName;
	}

	public void setPassengerSecondName(final String PassengerSecondName) {
		this.PassengerSecondName = PassengerSecondName;
	}

	public String getPassengerLastName() {
		return PassengerLastName;
	}

	public void setPassengerLastName(final String PassengerLastName) {
		this.PassengerLastName = PassengerLastName;
	}

	public String getPrimaryDocHolderInd() {
		return PrimaryDocHolderInd;
	}

	public void setPrimaryDocHolderInd(final String PrimaryDocHolderInd) {
		this.PrimaryDocHolderInd = PrimaryDocHolderInd;
	}

	public String getPrimaryDocHolderFirstName() {
		return PrimaryDocHolderFirstName;
	}

	public void setPrimaryDocHolderFirstName(final String PrimaryDocHolderFirstName) {
		this.PrimaryDocHolderFirstName = PrimaryDocHolderFirstName;
	}

	public String getPrimaryDocHolderLastName() {
		return PrimaryDocHolderLastName;
	}

	public void setPrimaryDocHolderLastName(final String PrimaryDocHolderLastName) {
		this.PrimaryDocHolderLastName = PrimaryDocHolderLastName;
	}

	public String getSourceTypeCode() {
		return SourceTypeCode;
	}

	public void setSourceTypeCode(final String SourceTypeCode) {
		this.SourceTypeCode = SourceTypeCode;
	}

	public String getSSRCode() {
		return SSRCode;
	}

	public void setSSRCode(final String SSRCode) {
		this.SSRCode = SSRCode;
	}

	public String getSSRIdTypeCode() {
		return SSRIdTypeCode;
	}

	public void setSSRIdTypeCode(final String SSRIdTypeCode) {
		this.SSRIdTypeCode = SSRIdTypeCode;
	}

	public Short getSSRNumberInParty() {
		return SSRNumberInParty;
	}

	public void setSSRNumberInParty(final Short SSRNumberInParty) {
		this.SSRNumberInParty = SSRNumberInParty;
	}

	public String getSSRStatusCode() {
		return SSRStatusCode;
	}

	public void setSSRStatusCode(final String SSRStatusCode) {
		this.SSRStatusCode = SSRStatusCode;
	}

	public String getSSRText() {
		return SSRText;
	}

	public void setSSRText(final String SSRText) {
		this.SSRText = SSRText;
	}

	public String getVendorCode() {
		return VendorCode;
	}

	public void setVendorCode(final String VendorCode) {
		this.VendorCode = VendorCode;
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

	public Date getDocIssueDate() {
		return DocIssueDate;
	}

	public void setDocIssueDate(final Date DocIssueDate) {
		this.DocIssueDate = DocIssueDate;
	}

	public Date getDocExpDate() {
		return DocExpDate;
	}

	public void setDocExpDate(final Date DocExpDate) {
		this.DocExpDate = DocExpDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((IntraPNRSetNbr == null) ? 0 : IntraPNRSetNbr.hashCode());
		result = prime * result + ((PassengerDocSeqId == null) ? 0 : PassengerDocSeqId.hashCode());
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
		ResPaxDoc other = (ResPaxDoc) obj;
		if (IntraPNRSetNbr == null) {
			if (other.IntraPNRSetNbr != null)
				return false;
		} else if (!IntraPNRSetNbr.equals(other.IntraPNRSetNbr))
			return false;
		if (PassengerDocSeqId == null) {
			if (other.PassengerDocSeqId != null)
				return false;
		} else if (!PassengerDocSeqId.equals(other.PassengerDocSeqId))
			return false;
		if (SSRIdTypeCode == null) {
			if (other.SSRIdTypeCode != null)
				return false;
		} else if (!SSRIdTypeCode.equals(other.SSRIdTypeCode))
			return false;
		return true;
	}

}