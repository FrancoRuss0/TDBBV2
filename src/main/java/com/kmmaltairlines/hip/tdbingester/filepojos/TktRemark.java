package com.kmmaltairlines.hip.tdbingester.filepojos;

import java.sql.Date;

public class TktRemark extends VCRRecord {

	private String ID;
	private String PNRLocatorID;
	private Date PNRCreateDate;
	private Short RemarkSeqNbr;
	private String RemarkTxt;

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

	public Short getRemarkSeqNbr() {
		return RemarkSeqNbr;
	}

	public void setRemarkSeqNbr(final Short RemarkSeqNbr) {
		this.RemarkSeqNbr = RemarkSeqNbr;
	}

	public String getRemarkTxt() {
		return RemarkTxt;
	}

	public void setRemarkTxt(final String RemarkTxt) {
		this.RemarkTxt = RemarkTxt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((RemarkSeqNbr == null) ? 0 : RemarkSeqNbr.hashCode());
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
		TktRemark other = (TktRemark) obj;
		if (RemarkSeqNbr == null) {
			if (other.RemarkSeqNbr != null)
				return false;
		} else if (!RemarkSeqNbr.equals(other.RemarkSeqNbr))
			return false;
		return true;
	}

}