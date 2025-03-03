package com.airmalta.hip.tdbingester.filepojos;

import java.math.BigDecimal;
import java.sql.Date;


public class TktMSR extends VCRRecord {

	private String ID;
	private String PNRLocatorID;
	private Date PNRCreateDate;
	private Short MSRSeqNbr;
	private Byte MSRQuantitySoldCount;
	private String MSRTypeCode;
	private String MSRTypeDesc;
	private String MSRCurrencyCode;
	private BigDecimal MSRChargeAmount;
	private BigDecimal MSRTaxAmount;
	private String MSRTaxCurrencyCode;
	private String SourceSystemId;
	private String OCGroupCode;
	private String RFISubCode;

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

	public Short getMSRSeqNbr() {
		return MSRSeqNbr;
	}

	public void setMSRSeqNbr(final Short MSRSeqNbr) {
		this.MSRSeqNbr = MSRSeqNbr;
	}

	public Byte getMSRQuantitySoldCount() {
		return MSRQuantitySoldCount;
	}

	public void setMSRQuantitySoldCount(final Byte MSRQuantitySoldCount) {
		this.MSRQuantitySoldCount = MSRQuantitySoldCount;
	}

	public String getMSRTypeCode() {
		return MSRTypeCode;
	}

	public void setMSRTypeCode(final String MSRTypeCode) {
		this.MSRTypeCode = MSRTypeCode;
	}

	public String getMSRTypeDesc() {
		return MSRTypeDesc;
	}

	public void setMSRTypeDesc(final String MSRTypeDesc) {
		this.MSRTypeDesc = MSRTypeDesc;
	}

	public String getMSRCurrencyCode() {
		return MSRCurrencyCode;
	}

	public void setMSRCurrencyCode(final String MSRCurrencyCode) {
		this.MSRCurrencyCode = MSRCurrencyCode;
	}

	public BigDecimal getMSRChargeAmount() {
		return MSRChargeAmount;
	}

	public void setMSRChargeAmount(final BigDecimal MSRChargeAmount) {
		this.MSRChargeAmount = MSRChargeAmount;
	}

	public BigDecimal getMSRTaxAmount() {
		return MSRTaxAmount;
	}

	public void setMSRTaxAmount(final BigDecimal MSRTaxAmount) {
		this.MSRTaxAmount = MSRTaxAmount;
	}

	public String getMSRTaxCurrencyCode() {
		return MSRTaxCurrencyCode;
	}

	public void setMSRTaxCurrencyCode(final String MSRTaxCurrencyCode) {
		this.MSRTaxCurrencyCode = MSRTaxCurrencyCode;
	}

	public String getSourceSystemId() {
		return SourceSystemId;
	}

	public void setSourceSystemId(final String SourceSystemId) {
		this.SourceSystemId = SourceSystemId;
	}

	public String getOCGroupCode() {
		return OCGroupCode;
	}

	public void setOCGroupCode(final String OCGroupCode) {
		this.OCGroupCode = OCGroupCode;
	}

	public String getRFISubCode() {
		return RFISubCode;
	}

	public void setRFISubCode(final String RFISubCode) {
		this.RFISubCode = RFISubCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((MSRSeqNbr == null) ? 0 : MSRSeqNbr.hashCode());
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
		TktMSR other = (TktMSR) obj;
		if (MSRSeqNbr == null) {
			if (other.MSRSeqNbr != null)
				return false;
		} else if (!MSRSeqNbr.equals(other.MSRSeqNbr))
			return false;
		return true;
	}

}