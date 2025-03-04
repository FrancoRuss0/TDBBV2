package com.kmmaltairlines.hip.tdbingester.filepojos;

import java.sql.Date;

public class TktEndorsement extends VCRRecord {

	private String ID;
	private String PNRLocatorID;
	private Date PNRCreateDate;
	private Integer EndSeqNbr;
	private String Endorsements;

	public String getID() {
		return ID;
	}

	public void setID(final String ID) {
		this.ID = ID;
	}

	public String getPNRLocatorID() {
		return PNRLocatorID;
	}

	public void setPNRLocatorID(final String PNRLocatorID) {
		this.PNRLocatorID = PNRLocatorID;
	}

	public Date getPNRCreateDate() {
		return PNRCreateDate;
	}

	public void setPNRCreateDate(final Date PNRCreateDate) {
		this.PNRCreateDate = PNRCreateDate;
	}

	public Integer getEndSeqNbr() {
		return EndSeqNbr;
	}

	public void setEndSeqNbr(final Integer EndSeqNbr) {
		this.EndSeqNbr = EndSeqNbr;
	}

	public String getEndorsements() {
		return Endorsements;
	}

	public void setEndorsements(final String Endorsements) {
		this.Endorsements = Endorsements;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((EndSeqNbr == null) ? 0 : EndSeqNbr.hashCode());
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
		TktEndorsement other = (TktEndorsement) obj;
		if (EndSeqNbr == null) {
			if (other.EndSeqNbr != null)
				return false;
		} else if (!EndSeqNbr.equals(other.EndSeqNbr))
			return false;
		return true;
	}

}