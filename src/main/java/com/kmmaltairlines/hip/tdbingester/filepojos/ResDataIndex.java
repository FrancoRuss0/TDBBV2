package com.kmmaltairlines.hip.tdbingester.filepojos;

import java.sql.Date;
import java.sql.Time;

public class ResDataIndex extends PNRRecord {

	private String ID;
	private Short NameAssociationID;
	private String ProfileType;
	private String ProfileValue;
	private String SourceSystemId;
	private Date RecordUpdateDate;
	private Time RecordUpdateTime;
	private Short IntraPNRSetNbr;
	private Short CDISeqNbr;
	private String ResActivityCode;

	public String getID() {
		return ID;
	}

	public void setID(final String ID) {
		this.ID = ID;
	}

	public Short getNameAssociationID() {
		return NameAssociationID;
	}

	public void setNameAssociationID(final Short NameAssociationID) {
		this.NameAssociationID = NameAssociationID;
	}

	public String getProfileType() {
		return ProfileType;
	}

	public void setProfileType(final String ProfileType) {
		this.ProfileType = ProfileType;
	}

	public String getProfileValue() {
		return ProfileValue;
	}

	public void setProfileValue(final String ProfileValue) {
		this.ProfileValue = ProfileValue;
	}

	public String getSourceSystemId() {
		return SourceSystemId;
	}

	public void setSourceSystemId(final String SourceSystemId) {
		this.SourceSystemId = SourceSystemId;
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

	public Short getCDISeqNbr() {
		return CDISeqNbr;
	}

	public void setCDISeqNbr(final Short CDISeqNbr) {
		this.CDISeqNbr = CDISeqNbr;
	}

	public String getResActivityCode() {
		return ResActivityCode;
	}

	public void setResActivityCode(final String ResActivityCode) {
		this.ResActivityCode = ResActivityCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((CDISeqNbr == null) ? 0 : CDISeqNbr.hashCode());
		result = prime * result + ((IntraPNRSetNbr == null) ? 0 : IntraPNRSetNbr.hashCode());
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
		ResDataIndex other = (ResDataIndex) obj;
		if (CDISeqNbr == null) {
			if (other.CDISeqNbr != null)
				return false;
		} else if (!CDISeqNbr.equals(other.CDISeqNbr))
			return false;
		if (IntraPNRSetNbr == null) {
			if (other.IntraPNRSetNbr != null)
				return false;
		} else if (!IntraPNRSetNbr.equals(other.IntraPNRSetNbr))
			return false;
		return true;
	}

}