package com.kmmaltairlines.hip.tdbingester.filepojos;

import java.math.BigDecimal;
import java.sql.Date;

public class TktProRation extends VCRRecord {

	private String ID;
	private String PNRLocatorID;
	private Date PNRCreateDate;
	private Short CouponSeqNbr;
	private BigDecimal CouponDistanceKm;
	private BigDecimal CouponDistanceMi;
	private BigDecimal ProrationFactor;
	private BigDecimal ProrateBaseFareUSD;
	private BigDecimal ProrateTotalDocAmtUSD;
	private String EquivBaseFareCurrCode;
	private BigDecimal EquivUSDExchgRate;
	private BigDecimal ProrateEquivBaseFareAmt;
	private BigDecimal ProrateEquivTotalDocAmt;
	private String OwnerCurrencyCode;
	private BigDecimal ProrateBaseFareOwnerAmt;
	private BigDecimal ProrateTotalDocOwnerAmt;

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

	public Short getCouponSeqNbr() {
		return CouponSeqNbr;
	}

	public void setCouponSeqNbr(final Short CouponSeqNbr) {
		this.CouponSeqNbr = CouponSeqNbr;
	}

	public BigDecimal getCouponDistanceKm() {
		return CouponDistanceKm;
	}

	public void setCouponDistanceKm(final BigDecimal CouponDistanceKm) {
		this.CouponDistanceKm = CouponDistanceKm;
	}

	public BigDecimal getCouponDistanceMi() {
		return CouponDistanceMi;
	}

	public void setCouponDistanceMi(final BigDecimal CouponDistanceMi) {
		this.CouponDistanceMi = CouponDistanceMi;
	}

	public BigDecimal getProrationFactor() {
		return ProrationFactor;
	}

	public void setProrationFactor(final BigDecimal ProrationFactor) {
		this.ProrationFactor = ProrationFactor;
	}

	public BigDecimal getProrateBaseFareUSD() {
		return ProrateBaseFareUSD;
	}

	public void setProrateBaseFareUSD(final BigDecimal ProrateBaseFareUSD) {
		this.ProrateBaseFareUSD = ProrateBaseFareUSD;
	}

	public BigDecimal getProrateTotalDocAmtUSD() {
		return ProrateTotalDocAmtUSD;
	}

	public void setProrateTotalDocAmtUSD(final BigDecimal ProrateTotalDocAmtUSD) {
		this.ProrateTotalDocAmtUSD = ProrateTotalDocAmtUSD;
	}

	public String getEquivBaseFareCurrCode() {
		return EquivBaseFareCurrCode;
	}

	public void setEquivBaseFareCurrCode(final String EquivBaseFareCurrCode) {
		this.EquivBaseFareCurrCode = EquivBaseFareCurrCode;
	}

	public BigDecimal getEquivUSDExchgRate() {
		return EquivUSDExchgRate;
	}

	public void setEquivUSDExchgRate(final BigDecimal EquivUSDExchgRate) {
		this.EquivUSDExchgRate = EquivUSDExchgRate;
	}

	public BigDecimal getProrateEquivBaseFareAmt() {
		return ProrateEquivBaseFareAmt;
	}

	public void setProrateEquivBaseFareAmt(final BigDecimal ProrateEquivBaseFareAmt) {
		this.ProrateEquivBaseFareAmt = ProrateEquivBaseFareAmt;
	}

	public BigDecimal getProrateEquivTotalDocAmt() {
		return ProrateEquivTotalDocAmt;
	}

	public void setProrateEquivTotalDocAmt(final BigDecimal ProrateEquivTotalDocAmt) {
		this.ProrateEquivTotalDocAmt = ProrateEquivTotalDocAmt;
	}

	public String getOwnerCurrencyCode() {
		return OwnerCurrencyCode;
	}

	public void setOwnerCurrencyCode(final String OwnerCurrencyCode) {
		this.OwnerCurrencyCode = OwnerCurrencyCode;
	}

	public BigDecimal getProrateBaseFareOwnerAmt() {
		return ProrateBaseFareOwnerAmt;
	}

	public void setProrateBaseFareOwnerAmt(final BigDecimal ProrateBaseFareOwnerAmt) {
		this.ProrateBaseFareOwnerAmt = ProrateBaseFareOwnerAmt;
	}

	public BigDecimal getProrateTotalDocOwnerAmt() {
		return ProrateTotalDocOwnerAmt;
	}

	public void setProrateTotalDocOwnerAmt(final BigDecimal ProrateTotalDocOwnerAmt) {
		this.ProrateTotalDocOwnerAmt = ProrateTotalDocOwnerAmt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((CouponSeqNbr == null) ? 0 : CouponSeqNbr.hashCode());
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
		TktProRation other = (TktProRation) obj;
		if (CouponSeqNbr == null) {
			if (other.CouponSeqNbr != null)
				return false;
		} else if (!CouponSeqNbr.equals(other.CouponSeqNbr))
			return false;
		return true;
	}

}