package com.airmalta.hip.tdbingester.filepojos;

import java.math.BigDecimal;


public class TKTFees extends VCRRecord {

	private String ID;
	private String SourceSystemId;
	private Integer FeeSequenceNbr;
	private String FeeTypeCd;
	private String FeeCatCd;
	private String FeeCurrCd;
	private BigDecimal FeeAmt;
	private BigDecimal FeeAmtUSD;
	private String ApplyCreditInd;
	private String FeeSubCategory;
	private String FeeWaivedInd;
	private String FeeDescription;
	private String FeePriceCd;
	private String FeeWaiverCd;

	public String getID() {
		return ID;
	}

	public void setID(final String ID) {
		this.ID = ID;
	}

	public String getSourceSystemId() {
		return SourceSystemId;
	}

	public void setSourceSystemId(final String SourceSystemId) {
		this.SourceSystemId = SourceSystemId;
	}

	public Integer getFeeSequenceNbr() {
		return FeeSequenceNbr;
	}

	public void setFeeSequenceNbr(final Integer FeeSequenceNbr) {
		this.FeeSequenceNbr = FeeSequenceNbr;
	}

	public String getFeeTypeCd() {
		return FeeTypeCd;
	}

	public void setFeeTypeCd(final String FeeTypeCd) {
		this.FeeTypeCd = FeeTypeCd;
	}

	public String getFeeCatCd() {
		return FeeCatCd;
	}

	public void setFeeCatCd(final String FeeCatCd) {
		this.FeeCatCd = FeeCatCd;
	}

	public String getFeeCurrCd() {
		return FeeCurrCd;
	}

	public void setFeeCurrCd(final String FeeCurrCd) {
		this.FeeCurrCd = FeeCurrCd;
	}

	public BigDecimal getFeeAmt() {
		return FeeAmt;
	}

	public void setFeeAmt(final BigDecimal FeeAmt) {
		this.FeeAmt = FeeAmt;
	}

	public BigDecimal getFeeAmtUSD() {
		return FeeAmtUSD;
	}

	public void setFeeAmtUSD(final BigDecimal FeeAmtUSD) {
		this.FeeAmtUSD = FeeAmtUSD;
	}

	public String getApplyCreditInd() {
		return ApplyCreditInd;
	}

	public void setApplyCreditInd(final String ApplyCreditInd) {
		this.ApplyCreditInd = ApplyCreditInd;
	}

	public String getFeeSubCategory() {
		return FeeSubCategory;
	}

	public void setFeeSubCategory(final String FeeSubCategory) {
		this.FeeSubCategory = FeeSubCategory;
	}

	public String getFeeWaivedInd() {
		return FeeWaivedInd;
	}

	public void setFeeWaivedInd(final String FeeWaivedInd) {
		this.FeeWaivedInd = FeeWaivedInd;
	}

	public String getFeeDescription() {
		return FeeDescription;
	}

	public void setFeeDescription(final String FeeDescription) {
		this.FeeDescription = FeeDescription;
	}

	public String getFeePriceCd() {
		return FeePriceCd;
	}

	public void setFeePriceCd(final String FeePriceCd) {
		this.FeePriceCd = FeePriceCd;
	}

	public String getFeeWaiverCd() {
		return FeeWaiverCd;
	}

	public void setFeeWaiverCd(final String FeeWaiverCd) {
		this.FeeWaiverCd = FeeWaiverCd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((FeeSequenceNbr == null) ? 0 : FeeSequenceNbr.hashCode());
		result = prime * result + ((SourceSystemId == null) ? 0 : SourceSystemId.hashCode());
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
		TKTFees other = (TKTFees) obj;
		if (FeeSequenceNbr == null) {
			if (other.FeeSequenceNbr != null)
				return false;
		} else if (!FeeSequenceNbr.equals(other.FeeSequenceNbr))
			return false;
		if (SourceSystemId == null) {
			if (other.SourceSystemId != null)
				return false;
		} else if (!SourceSystemId.equals(other.SourceSystemId))
			return false;
		return true;
	}

}