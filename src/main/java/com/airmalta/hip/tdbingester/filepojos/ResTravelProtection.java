package com.airmalta.hip.tdbingester.filepojos;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;


public class ResTravelProtection extends PNRRecord {

	private String ID;
	private Short SegmentNbr;
	private String PlanTypeCode;
	private String VendorCode;
	private Date PurchaseDate;
	private Short SegmentType;
	private String ConfirmationNbr;
	private String CurrentSegmentStatusCode;
	private Date ServiceStartDate;
	private Date ServiceEndDate;
	private String ServiceStartCityCode;
	private String ServiceEndCityCode;
	private String FOPCode;
	private String PaymentCreditCardCode;
	private String PaymentCreditCardNbr;
	private Date PaymentCreditCardExpDate;
	private String CurrCode;
	private String PremiumValue;
	private BigDecimal PremiumAmt;
	private BigDecimal PremiumAmtUSD;
	private Date RecordUpdateDate;
	private Time RecordUpdateTime;
	private String HistoryActionCodeID;
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

	public String getPlanTypeCode() {
		return PlanTypeCode;
	}

	public void setPlanTypeCode(final String PlanTypeCode) {
		this.PlanTypeCode = PlanTypeCode;
	}

	public String getVendorCode() {
		return VendorCode;
	}

	public void setVendorCode(final String VendorCode) {
		this.VendorCode = VendorCode;
	}

	public Date getPurchaseDate() {
		return PurchaseDate;
	}

	public void setPurchaseDate(final Date PurchaseDate) {
		this.PurchaseDate = PurchaseDate;
	}

	public Short getSegmentType() {
		return SegmentType;
	}

	public void setSegmentType(final Short SegmentType) {
		this.SegmentType = SegmentType;
	}

	public String getConfirmationNbr() {
		return ConfirmationNbr;
	}

	public void setConfirmationNbr(final String ConfirmationNbr) {
		this.ConfirmationNbr = ConfirmationNbr;
	}

	public String getCurrentSegmentStatusCode() {
		return CurrentSegmentStatusCode;
	}

	public void setCurrentSegmentStatusCode(final String CurrentSegmentStatusCode) {
		this.CurrentSegmentStatusCode = CurrentSegmentStatusCode;
	}

	public Date getServiceStartDate() {
		return ServiceStartDate;
	}

	public void setServiceStartDate(final Date ServiceStartDate) {
		this.ServiceStartDate = ServiceStartDate;
	}

	public Date getServiceEndDate() {
		return ServiceEndDate;
	}

	public void setServiceEndDate(final Date ServiceEndDate) {
		this.ServiceEndDate = ServiceEndDate;
	}

	public String getServiceStartCityCode() {
		return ServiceStartCityCode;
	}

	public void setServiceStartCityCode(final String ServiceStartCityCode) {
		this.ServiceStartCityCode = ServiceStartCityCode;
	}

	public String getServiceEndCityCode() {
		return ServiceEndCityCode;
	}

	public void setServiceEndCityCode(final String ServiceEndCityCode) {
		this.ServiceEndCityCode = ServiceEndCityCode;
	}

	public String getFOPCode() {
		return FOPCode;
	}

	public void setFOPCode(final String FOPCode) {
		this.FOPCode = FOPCode;
	}

	public String getPaymentCreditCardCode() {
		return PaymentCreditCardCode;
	}

	public void setPaymentCreditCardCode(final String PaymentCreditCardCode) {
		this.PaymentCreditCardCode = PaymentCreditCardCode;
	}

	public String getPaymentCreditCardNbr() {
		return PaymentCreditCardNbr;
	}

	public void setPaymentCreditCardNbr(final String PaymentCreditCardNbr) {
		this.PaymentCreditCardNbr = PaymentCreditCardNbr;
	}

	public Date getPaymentCreditCardExpDate() {
		return PaymentCreditCardExpDate;
	}

	public void setPaymentCreditCardExpDate(final Date PaymentCreditCardExpDate) {
		this.PaymentCreditCardExpDate = PaymentCreditCardExpDate;
	}

	public String getCurrCode() {
		return CurrCode;
	}

	public void setCurrCode(final String CurrCode) {
		this.CurrCode = CurrCode;
	}

	public String getPremiumValue() {
		return PremiumValue;
	}

	public void setPremiumValue(final String PremiumValue) {
		this.PremiumValue = PremiumValue;
	}

	public BigDecimal getPremiumAmt() {
		return PremiumAmt;
	}

	public void setPremiumAmt(final BigDecimal PremiumAmt) {
		this.PremiumAmt = PremiumAmt;
	}

	public BigDecimal getPremiumAmtUSD() {
		return PremiumAmtUSD;
	}

	public void setPremiumAmtUSD(final BigDecimal PremiumAmtUSD) {
		this.PremiumAmtUSD = PremiumAmtUSD;
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

	public String getHistoryActionCodeID() {
		return HistoryActionCodeID;
	}

	public void setHistoryActionCodeID(final String HistoryActionCodeID) {
		this.HistoryActionCodeID = HistoryActionCodeID;
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
		ResTravelProtection other = (ResTravelProtection) obj;
		if (IntraPNRSetNbr == null) {
			if (other.IntraPNRSetNbr != null)
				return false;
		} else if (!IntraPNRSetNbr.equals(other.IntraPNRSetNbr))
			return false;
		if (SegmentNbr == null) {
			if (other.SegmentNbr != null)
				return false;
		} else if (!SegmentNbr.equals(other.SegmentNbr))
			return false;
		return true;
	}

}