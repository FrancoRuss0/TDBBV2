package com.airmalta.hip.tdbingester.filepojos;

import java.sql.Date;
import java.sql.Time;

public class ResAddress extends PNRRecord {
	
	private String ID;
	private String AddressLine1;
	private String AddressLineType_1;
	private String AddressLine2;
	private String AddressLineType_2;
	private String AddressLine3;
	private String AddressLineType_3;
	private String AddressLine4;
	private String AddressLineType_4;
	private String AddressLine5;
	private String AddressLineType_5;
	private String AddressLine6;
	private String AddressLineType_6;
	private Date RecordUpdateDate;
	private Time RecordUpdateTime;
	private String HistoryActionCodeId;
	private Integer ResAddressSeqID;
	private Short IntraPNRSetNbr;

	public String getID() {
		return ID;
	}

	public void setID(final String ID) {
		this.ID = ID;
	}

	public String getAddressLine1() {
		return AddressLine1;
	}

	public void setAddressLine1(final String AddressLine1) {
		this.AddressLine1 = AddressLine1;
	}

	public String getAddressLineType_1() {
		return AddressLineType_1;
	}

	public void setAddressLineType_1(final String AddressLineType_1) {
		this.AddressLineType_1 = AddressLineType_1;
	}

	public String getAddressLine2() {
		return AddressLine2;
	}

	public void setAddressLine2(final String AddressLine2) {
		this.AddressLine2 = AddressLine2;
	}

	public String getAddressLineType_2() {
		return AddressLineType_2;
	}

	public void setAddressLineType_2(final String AddressLineType_2) {
		this.AddressLineType_2 = AddressLineType_2;
	}

	public String getAddressLine3() {
		return AddressLine3;
	}

	public void setAddressLine3(final String AddressLine3) {
		this.AddressLine3 = AddressLine3;
	}

	public String getAddressLineType_3() {
		return AddressLineType_3;
	}

	public void setAddressLineType_3(final String AddressLineType_3) {
		this.AddressLineType_3 = AddressLineType_3;
	}

	public String getAddressLine4() {
		return AddressLine4;
	}

	public void setAddressLine4(final String AddressLine4) {
		this.AddressLine4 = AddressLine4;
	}

	public String getAddressLineType_4() {
		return AddressLineType_4;
	}

	public void setAddressLineType_4(final String AddressLineType_4) {
		this.AddressLineType_4 = AddressLineType_4;
	}

	public String getAddressLine5() {
		return AddressLine5;
	}

	public void setAddressLine5(final String AddressLine5) {
		this.AddressLine5 = AddressLine5;
	}

	public String getAddressLineType_5() {
		return AddressLineType_5;
	}

	public void setAddressLineType_5(final String AddressLineType_5) {
		this.AddressLineType_5 = AddressLineType_5;
	}

	public String getAddressLine6() {
		return AddressLine6;
	}

	public void setAddressLine6(final String AddressLine6) {
		this.AddressLine6 = AddressLine6;
	}

	public String getAddressLineType_6() {
		return AddressLineType_6;
	}

	public void setAddressLineType_6(final String AddressLineType_6) {
		this.AddressLineType_6 = AddressLineType_6;
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

	public String getHistoryActionCodeId() {
		return HistoryActionCodeId;
	}

	public void setHistoryActionCodeId(final String HistoryActionCodeId) {
		this.HistoryActionCodeId = HistoryActionCodeId;
	}

	public Integer getResAddressSeqID() {
		return ResAddressSeqID;
	}

	public void setResAddressSeqID(final Integer ResAddressSeqID) {
		this.ResAddressSeqID = ResAddressSeqID;
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
		result = prime * result + ((ResAddressSeqID == null) ? 0 : ResAddressSeqID.hashCode());
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
		ResAddress other = (ResAddress) obj;
		if (IntraPNRSetNbr == null) {
			if (other.IntraPNRSetNbr != null)
				return false;
		} else if (!IntraPNRSetNbr.equals(other.IntraPNRSetNbr))
			return false;
		if (ResAddressSeqID == null) {
			if (other.ResAddressSeqID != null)
				return false;
		} else if (!ResAddressSeqID.equals(other.ResAddressSeqID))
			return false;
		return true;
	}

}