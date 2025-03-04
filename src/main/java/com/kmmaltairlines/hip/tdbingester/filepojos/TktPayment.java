package com.kmmaltairlines.hip.tdbingester.filepojos;

import java.math.BigDecimal;
import java.sql.Date;

public class TktPayment extends VCRRecord {

	private String ID;
	private String PNRLocatorID;
	private Date PNRCreateDate;
	private Short PaymentSeqNbr;
	private String FOPCode;
	private BigDecimal PaymentAmt;
	private String PaymentVendorCode;
	private String AcctNbr;
	private String PaymentCurrCode;
	private String PaymentRemarks;
	private String PaymentApprovalCode;
	private String PaymentApprovalTypeCode;

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

	public Short getPaymentSeqNbr() {
		return PaymentSeqNbr;
	}

	public void setPaymentSeqNbr(final Short PaymentSeqNbr) {
		this.PaymentSeqNbr = PaymentSeqNbr;
	}

	public String getFOPCode() {
		return FOPCode;
	}

	public void setFOPCode(final String FOPCode) {
		this.FOPCode = FOPCode;
	}

	public BigDecimal getPaymentAmt() {
		return PaymentAmt;
	}

	public void setPaymentAmt(final BigDecimal PaymentAmt) {
		this.PaymentAmt = PaymentAmt;
	}

	public String getPaymentVendorCode() {
		return PaymentVendorCode;
	}

	public void setPaymentVendorCode(final String PaymentVendorCode) {
		this.PaymentVendorCode = PaymentVendorCode;
	}

	public String getAcctNbr() {
		return AcctNbr;
	}

	public void setAcctNbr(final String AcctNbr) {
		this.AcctNbr = AcctNbr;
	}

	public String getPaymentCurrCode() {
		return PaymentCurrCode;
	}

	public void setPaymentCurrCode(final String PaymentCurrCode) {
		this.PaymentCurrCode = PaymentCurrCode;
	}

	public String getPaymentRemarks() {
		return PaymentRemarks;
	}

	public void setPaymentRemarks(final String PaymentRemarks) {
		this.PaymentRemarks = PaymentRemarks;
	}

	public String getPaymentApprovalCode() {
		return PaymentApprovalCode;
	}

	public void setPaymentApprovalCode(final String PaymentApprovalCode) {
		this.PaymentApprovalCode = PaymentApprovalCode;
	}

	public String getPaymentApprovalTypeCode() {
		return PaymentApprovalTypeCode;
	}

	public void setPaymentApprovalTypeCode(final String PaymentApprovalTypeCode) {
		this.PaymentApprovalTypeCode = PaymentApprovalTypeCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((PaymentSeqNbr == null) ? 0 : PaymentSeqNbr.hashCode());
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
		TktPayment other = (TktPayment) obj;
		if (PaymentSeqNbr == null) {
			if (other.PaymentSeqNbr != null)
				return false;
		} else if (!PaymentSeqNbr.equals(other.PaymentSeqNbr))
			return false;
		return true;
	}

}