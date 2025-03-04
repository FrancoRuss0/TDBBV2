package com.kmmaltairlines.hip.tdbingester.filepojos;

import java.sql.Date;
import java.sql.Time;

public class ResFlightAirExtra extends PNRRecord {

	private String ID;
	private Short SegmentNbr;
	private Short PNRPassengerSeqId;
	private String RFISubCode;
	private Date RecordUpdateDate;
	private Time RecordUpdateTime;
	private Short IntraPNRSetNbr;

	public String getID() {
		return ID;
	}

	public void setID(final String ID) {
		this.ID = ID;
	}

	public Short getSegmentNbr() {
		return SegmentNbr;
	}

	public void setSegmentNbr(final Short SegmentNbr) {
		this.SegmentNbr = SegmentNbr;
	}

	public Short getPNRPassengerSeqId() {
		return PNRPassengerSeqId;
	}

	public void setPNRPassengerSeqId(final Short PNRPassengerSeqId) {
		this.PNRPassengerSeqId = PNRPassengerSeqId;
	}

	public String getRFISubCode() {
		return RFISubCode;
	}

	public void setRFISubCode(final String RFISubCode) {
		this.RFISubCode = RFISubCode;
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
		result = prime * result + ((RFISubCode == null) ? 0 : RFISubCode.hashCode());
		result = prime * result + ((SegmentNbr == null) ? 0 : SegmentNbr.hashCode());
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
		ResFlightAirExtra other = (ResFlightAirExtra) obj;
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
		if (RFISubCode == null) {
			if (other.RFISubCode != null)
				return false;
		} else if (!RFISubCode.equals(other.RFISubCode))
			return false;
		if (SegmentNbr == null) {
			if (other.SegmentNbr != null)
				return false;
		} else if (!SegmentNbr.equals(other.SegmentNbr))
			return false;
		return true;
	}

}