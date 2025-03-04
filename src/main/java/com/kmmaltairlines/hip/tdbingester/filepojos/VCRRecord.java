package com.kmmaltairlines.hip.tdbingester.filepojos;

import java.sql.Date;
import java.sql.Timestamp;

public abstract class VCRRecord {

	private String PrimaryDocNbr;
	private Date VCRCreateDate;
	private Timestamp TransactionDateTime;

	public Timestamp getTransactionDateTime() {
		return TransactionDateTime;
	}

	public void setTransactionDateTime(final Timestamp TransactionDateTime) {
		this.TransactionDateTime = TransactionDateTime;
	}

	public String getPrimaryDocNbr() {
		return PrimaryDocNbr;
	}

	public void setPrimaryDocNbr(final String PrimaryDocNbr) {
		this.PrimaryDocNbr = PrimaryDocNbr;
	}

	public Date getVCRCreateDate() {
		return VCRCreateDate;
	}

	public void setVCRCreateDate(final Date VCRCreateDate) {
		this.VCRCreateDate = VCRCreateDate;
	}

	/**
	 * Every VCR record is uniquely identified by the PrimaryDocNbr and
	 * VCRCreateDate. Given that this object is an abstact class, any concrete class
	 * must implement hashcode() and equals().
	 * 
	 * Fields used by this abstract class, and any implementing class to determine
	 * hashcode() and equals() are used together to determine the equality of one
	 * record with another.
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((PrimaryDocNbr == null) ? 0 : PrimaryDocNbr.hashCode());
		result = prime * result + ((VCRCreateDate == null) ? 0 : VCRCreateDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		VCRRecord other = (VCRRecord) obj;
		if (PrimaryDocNbr == null) {
			if (other.PrimaryDocNbr != null) {
				return false;
			}
		} else if (!PrimaryDocNbr.equals(other.PrimaryDocNbr)) {
			return false;
		}
		if (VCRCreateDate == null) {
			if (other.VCRCreateDate != null) {
				return false;
			}
		} else if (!VCRCreateDate.equals(other.VCRCreateDate)) {
			return false;
		}
		return true;
	}

}
