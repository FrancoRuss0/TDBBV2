package com.airmalta.hip.tdbingester.filepojos;

import java.sql.Date;
import java.sql.Timestamp;

public abstract class PNRRecord {

	private String PNRLocatorID;
	private Date PNRCreateDate;
	private Timestamp FromDateTime;

	public String getPNRLocatorID() {
		return PNRLocatorID;
	}

	public void setPNRLocatorID(String pNRLocatorID) {
		PNRLocatorID = pNRLocatorID;
	}

	public Date getPNRCreateDate() {
		return PNRCreateDate;
	}

	public void setPNRCreateDate(Date pNRCreateDate) {
		PNRCreateDate = pNRCreateDate;
	}

	public Timestamp getFromDateTime() {
		return FromDateTime;
	}

	public void setFromDateTime(Timestamp fromDateTime) {
		FromDateTime = fromDateTime;
	}
	   
	
	/**
     * Every PNR record is uniquely identified by the PNRLocatorID and PNRCreateDate.
     * Given that this object is an abstact class, any concrete class must implement
     * hashcode() and equals().
     * 
     * Fields used by this abstract class, and any implementing class to determine
     * hashcode() and equals() are used together to determine the equality of one record with another.
     */

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((PNRLocatorID == null) ? 0 : PNRLocatorID.hashCode());
        result = prime * result + ((PNRCreateDate == null) ? 0 : PNRCreateDate.hashCode());
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
        PNRRecord other = (PNRRecord) obj;
        if (PNRLocatorID == null) {
            if (other.PNRLocatorID != null) {
                return false;
            }
        } else if (!PNRLocatorID.equals(other.PNRLocatorID)) {
            return false;
        }
        if (PNRCreateDate == null) {
            if (other.PNRCreateDate != null) {
                return false;
            }
        } else if (!PNRCreateDate.equals(other.PNRCreateDate)) {
            return false;
        }
        return true;
    }
	
	

}
