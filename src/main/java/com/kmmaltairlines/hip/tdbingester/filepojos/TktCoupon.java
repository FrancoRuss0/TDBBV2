package com.kmmaltairlines.hip.tdbingester.filepojos;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

public class TktCoupon extends VCRRecord {

	private String ID;
	private String PNRLocatorID;
	private Date PNRCreateDate;
	private Short CouponSeqNbr;
	private Byte EntNbr;
	private String CouponStatus;
	private String PreviousCouponStatusCode;
	private String SegmentTypeCode;
	private String MarketingAirlineCode;
	private String MarketingFlightNbr;
	private String ServiceStartCity;
	private String ServiceEndCity;
	private String SegmentStatusCode;
	private Date ServiceStartDate;
	private Time ServiceStartTime;
	private Date ServiceEndDate;
	private Time ServiceEndTime;
	private String ClassOfService;
	private String FareBasisCode;
	private String TktDesignatorCode;
	private String FareBreakInd;
	private Date PriceNotValidBeforeDate;
	private Date PriceNotValidAfterDate;
	private String InvoluntaryInd;
	private String FlownFlightNbr;
	private Date FlownServiceStartDate;
	private String FlownServiceStartCity;
	private String FlownServiceEndCity;
	private String FlownClassOfService;
	private Date FlownFlightOrigDate;
	private String OperatingAirlineCode;
	private String OperatingFlightNbr;
	private String OperatingPNRLocator;
	private BigDecimal FareBreakAmt;
	private BigDecimal FareBreakDiscAmt;
	private String DiscountAmtInd;
	private String DiscountPctInd;
	private String StopoverCode;
	private String FrequentTravelerNbr;
	private String VendorCode;
	private String FareBreakCurrencyCode;
	private String SettlementAuthCode;
	private String BaggageAlwncText;

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

	public Byte getEntNbr() {
		return EntNbr;
	}

	public void setEntNbr(final Byte EntNbr) {
		this.EntNbr = EntNbr;
	}

	public String getCouponStatus() {
		return CouponStatus;
	}

	public void setCouponStatus(final String CouponStatus) {
		this.CouponStatus = CouponStatus;
	}

	public String getPreviousCouponStatusCode() {
		return PreviousCouponStatusCode;
	}

	public void setPreviousCouponStatusCode(final String PreviousCouponStatusCode) {
		this.PreviousCouponStatusCode = PreviousCouponStatusCode;
	}

	public String getSegmentTypeCode() {
		return SegmentTypeCode;
	}

	public void setSegmentTypeCode(final String SegmentTypeCode) {
		this.SegmentTypeCode = SegmentTypeCode;
	}

	public String getMarketingAirlineCode() {
		return MarketingAirlineCode;
	}

	public void setMarketingAirlineCode(final String MarketingAirlineCode) {
		this.MarketingAirlineCode = MarketingAirlineCode;
	}

	public String getMarketingFlightNbr() {
		return MarketingFlightNbr;
	}

	public void setMarketingFlightNbr(final String MarketingFlightNbr) {
		this.MarketingFlightNbr = MarketingFlightNbr;
	}

	public String getServiceStartCity() {
		return ServiceStartCity;
	}

	public void setServiceStartCity(final String ServiceStartCity) {
		this.ServiceStartCity = ServiceStartCity;
	}

	public String getServiceEndCity() {
		return ServiceEndCity;
	}

	public void setServiceEndCity(final String ServiceEndCity) {
		this.ServiceEndCity = ServiceEndCity;
	}

	public String getSegmentStatusCode() {
		return SegmentStatusCode;
	}

	public void setSegmentStatusCode(final String SegmentStatusCode) {
		this.SegmentStatusCode = SegmentStatusCode;
	}

	public Date getServiceStartDate() {
		return ServiceStartDate;
	}

	public void setServiceStartDate(final Date ServiceStartDate) {
		this.ServiceStartDate = ServiceStartDate;
	}

	public Time getServiceStartTime() {
		return ServiceStartTime;
	}

	public void setServiceStartTime(final Time ServiceStartTime) {
		this.ServiceStartTime = ServiceStartTime;
	}

	public Date getServiceEndDate() {
		return ServiceEndDate;
	}

	public void setServiceEndDate(final Date ServiceEndDate) {
		this.ServiceEndDate = ServiceEndDate;
	}

	public Time getServiceEndTime() {
		return ServiceEndTime;
	}

	public void setServiceEndTime(final Time ServiceEndTime) {
		this.ServiceEndTime = ServiceEndTime;
	}

	public String getClassOfService() {
		return ClassOfService;
	}

	public void setClassOfService(final String ClassOfService) {
		this.ClassOfService = ClassOfService;
	}

	public String getFareBasisCode() {
		return FareBasisCode;
	}

	public void setFareBasisCode(final String FareBasisCode) {
		this.FareBasisCode = FareBasisCode;
	}

	public String getTktDesignatorCode() {
		return TktDesignatorCode;
	}

	public void setTktDesignatorCode(final String TktDesignatorCode) {
		this.TktDesignatorCode = TktDesignatorCode;
	}

	public String getFareBreakInd() {
		return FareBreakInd;
	}

	public void setFareBreakInd(final String FareBreakInd) {
		this.FareBreakInd = FareBreakInd;
	}

	public Date getPriceNotValidBeforeDate() {
		return PriceNotValidBeforeDate;
	}

	public void setPriceNotValidBeforeDate(final Date PriceNotValidBeforeDate) {
		this.PriceNotValidBeforeDate = PriceNotValidBeforeDate;
	}

	public Date getPriceNotValidAfterDate() {
		return PriceNotValidAfterDate;
	}

	public void setPriceNotValidAfterDate(final Date PriceNotValidAfterDate) {
		this.PriceNotValidAfterDate = PriceNotValidAfterDate;
	}

	public String getInvoluntaryInd() {
		return InvoluntaryInd;
	}

	public void setInvoluntaryInd(final String InvoluntaryInd) {
		this.InvoluntaryInd = InvoluntaryInd;
	}

	public String getFlownFlightNbr() {
		return FlownFlightNbr;
	}

	public void setFlownFlightNbr(final String FlownFlightNbr) {
		this.FlownFlightNbr = FlownFlightNbr;
	}

	public Date getFlownServiceStartDate() {
		return FlownServiceStartDate;
	}

	public void setFlownServiceStartDate(final Date FlownServiceStartDate) {
		this.FlownServiceStartDate = FlownServiceStartDate;
	}

	public String getFlownServiceStartCity() {
		return FlownServiceStartCity;
	}

	public void setFlownServiceStartCity(final String FlownServiceStartCity) {
		this.FlownServiceStartCity = FlownServiceStartCity;
	}

	public String getFlownServiceEndCity() {
		return FlownServiceEndCity;
	}

	public void setFlownServiceEndCity(final String FlownServiceEndCity) {
		this.FlownServiceEndCity = FlownServiceEndCity;
	}

	public String getFlownClassOfService() {
		return FlownClassOfService;
	}

	public void setFlownClassOfService(final String FlownClassOfService) {
		this.FlownClassOfService = FlownClassOfService;
	}

	public Date getFlownFlightOrigDate() {
		return FlownFlightOrigDate;
	}

	public void setFlownFlightOrigDate(final Date FlownFlightOrigDate) {
		this.FlownFlightOrigDate = FlownFlightOrigDate;
	}

	public String getOperatingAirlineCode() {
		return OperatingAirlineCode;
	}

	public void setOperatingAirlineCode(final String OperatingAirlineCode) {
		this.OperatingAirlineCode = OperatingAirlineCode;
	}

	public String getOperatingFlightNbr() {
		return OperatingFlightNbr;
	}

	public void setOperatingFlightNbr(final String OperatingFlightNbr) {
		this.OperatingFlightNbr = OperatingFlightNbr;
	}

	public String getOperatingPNRLocator() {
		return OperatingPNRLocator;
	}

	public void setOperatingPNRLocator(final String OperatingPNRLocator) {
		this.OperatingPNRLocator = OperatingPNRLocator;
	}

	public BigDecimal getFareBreakAmt() {
		return FareBreakAmt;
	}

	public void setFareBreakAmt(final BigDecimal FareBreakAmt) {
		this.FareBreakAmt = FareBreakAmt;
	}

	public BigDecimal getFareBreakDiscAmt() {
		return FareBreakDiscAmt;
	}

	public void setFareBreakDiscAmt(final BigDecimal FareBreakDiscAmt) {
		this.FareBreakDiscAmt = FareBreakDiscAmt;
	}

	public String getDiscountAmtInd() {
		return DiscountAmtInd;
	}

	public void setDiscountAmtInd(final String DiscountAmtInd) {
		this.DiscountAmtInd = DiscountAmtInd;
	}

	public String getDiscountPctInd() {
		return DiscountPctInd;
	}

	public void setDiscountPctInd(final String DiscountPctInd) {
		this.DiscountPctInd = DiscountPctInd;
	}

	public String getStopoverCode() {
		return StopoverCode;
	}

	public void setStopoverCode(final String StopoverCode) {
		this.StopoverCode = StopoverCode;
	}

	public String getFrequentTravelerNbr() {
		return FrequentTravelerNbr;
	}

	public void setFrequentTravelerNbr(final String FrequentTravelerNbr) {
		this.FrequentTravelerNbr = FrequentTravelerNbr;
	}

	public String getVendorCode() {
		return VendorCode;
	}

	public void setVendorCode(final String VendorCode) {
		this.VendorCode = VendorCode;
	}

	public String getFareBreakCurrencyCode() {
		return FareBreakCurrencyCode;
	}

	public void setFareBreakCurrencyCode(final String FareBreakCurrencyCode) {
		this.FareBreakCurrencyCode = FareBreakCurrencyCode;
	}

	public String getSettlementAuthCode() {
		return SettlementAuthCode;
	}

	public void setSettlementAuthCode(final String SettlementAuthCode) {
		this.SettlementAuthCode = SettlementAuthCode;
	}

	public String getBaggageAlwncText() {
		return BaggageAlwncText;
	}

	public void setBaggageAlwncText(final String BaggageAlwncText) {
		this.BaggageAlwncText = BaggageAlwncText;
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
		TktCoupon other = (TktCoupon) obj;
		if (CouponSeqNbr == null) {
			if (other.CouponSeqNbr != null)
				return false;
		} else if (!CouponSeqNbr.equals(other.CouponSeqNbr))
			return false;
		return true;
	}

}