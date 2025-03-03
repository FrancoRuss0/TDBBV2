package com.airmalta.hip.tdbingester.filepojos;

import java.sql.Date;


public class TktAddress extends VCRRecord{

	private String ID;
	private String PNRLocatorID;
	private Date PNRCreateDate;
	private Short AddrSeqNbr;
	private String AddrTxt;

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

	public Short getAddrSeqNbr() {
		return AddrSeqNbr;
	}

	public void setAddrSeqNbr(final Short AddrSeqNbr) {
		this.AddrSeqNbr = AddrSeqNbr;
	}

	public String getAddrTxt() {
		return AddrTxt;
	}

	public void setAddrTxt(final String AddrTxt) {
		this.AddrTxt = AddrTxt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((AddrSeqNbr == null) ? 0 : AddrSeqNbr.hashCode());
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
		TktAddress other = (TktAddress) obj;
		if (AddrSeqNbr == null) {
			if (other.AddrSeqNbr != null)
				return false;
		} else if (!AddrSeqNbr.equals(other.AddrSeqNbr))
			return false;
		return true;
	}

}