package com.kmmaltairlines.hip.tdbingester.filepojos;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

public class ResAirExtraTax extends PNRRecord {

	private String ID;
	private Byte AETaxSeqNbr;
	private Short PNRPassengerSeqId;
	private String RFISubCode;
	private String TaxCode;
	private BigDecimal TaxAmount;
	private Date RecordUpdateDate;
	private Time RecordUpdateTime;
	private Short IntraPNRSetNbr;

	public String getID() {
		return ID;
	}

	public void setID(final String ID) {
		this.ID = ID;
	}

	public Byte getAETaxSeqNbr() {
		return AETaxSeqNbr;
	}

	public void setAETaxSeqNbr(final Byte AETaxSeqNbr) {
		this.AETaxSeqNbr = AETaxSeqNbr;
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

	public String getTaxCode() {
		return TaxCode;
	}

	public void setTaxCode(final String TaxCode) {
		this.TaxCode = TaxCode;
	}

	public BigDecimal getTaxAmount() {
		return TaxAmount;
	}

	public void setTaxAmount(final BigDecimal TaxAmount) {
		this.TaxAmount = TaxAmount;
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
		result = prime * result + ((AETaxSeqNbr == null) ? 0 : AETaxSeqNbr.hashCode());
		result = prime * result + ((IntraPNRSetNbr == null) ? 0 : IntraPNRSetNbr.hashCode());
		result = prime * result + ((PNRPassengerSeqId == null) ? 0 : PNRPassengerSeqId.hashCode());
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
		ResAirExtraTax other = (ResAirExtraTax) obj;
		if (AETaxSeqNbr == null) {
			if (other.AETaxSeqNbr != null)
				return false;
		} else if (!AETaxSeqNbr.equals(other.AETaxSeqNbr))
			return false;
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
		return true;
	}

}