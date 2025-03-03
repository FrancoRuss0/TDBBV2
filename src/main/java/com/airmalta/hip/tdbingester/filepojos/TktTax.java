package com.airmalta.hip.tdbingester.filepojos;

import java.math.BigDecimal;
import java.sql.Date;


public class TktTax extends VCRRecord {
	
	private String ID;
	private String PNRLocatorID;
	private Date PNRCreateDate;
	private Byte TaxSeqNbr;
	private BigDecimal TaxAmt;
	private String TaxCode;
	private String TaxTypeCode;
	private String TaxCategoryCode;
	private String TaxCurrCode;

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

	public Byte getTaxSeqNbr() {
		return TaxSeqNbr;
	}

	public void setTaxSeqNbr(final Byte TaxSeqNbr) {
		this.TaxSeqNbr = TaxSeqNbr;
	}

	public BigDecimal getTaxAmt() {
		return TaxAmt;
	}

	public void setTaxAmt(final BigDecimal TaxAmt) {
		this.TaxAmt = TaxAmt;
	}

	public String getTaxCode() {
		return TaxCode;
	}

	public void setTaxCode(final String TaxCode) {
		this.TaxCode = TaxCode;
	}

	public String getTaxTypeCode() {
		return TaxTypeCode;
	}

	public void setTaxTypeCode(final String TaxTypeCode) {
		this.TaxTypeCode = TaxTypeCode;
	}

	public String getTaxCategoryCode() {
		return TaxCategoryCode;
	}

	public void setTaxCategoryCode(final String TaxCategoryCode) {
		this.TaxCategoryCode = TaxCategoryCode;
	}

	public String getTaxCurrCode() {
		return TaxCurrCode;
	}

	public void setTaxCurrCode(final String TaxCurrCode) {
		this.TaxCurrCode = TaxCurrCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((TaxCategoryCode == null) ? 0 : TaxCategoryCode.hashCode());
		result = prime * result + ((TaxCode == null) ? 0 : TaxCode.hashCode());
		result = prime * result + ((TaxSeqNbr == null) ? 0 : TaxSeqNbr.hashCode());
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
		TktTax other = (TktTax) obj;
		if (TaxCategoryCode == null) {
			if (other.TaxCategoryCode != null)
				return false;
		} else if (!TaxCategoryCode.equals(other.TaxCategoryCode))
			return false;
		if (TaxCode == null) {
			if (other.TaxCode != null)
				return false;
		} else if (!TaxCode.equals(other.TaxCode))
			return false;
		if (TaxSeqNbr == null) {
			if (other.TaxSeqNbr != null)
				return false;
		} else if (!TaxSeqNbr.equals(other.TaxSeqNbr))
			return false;
		return true;
	}

}