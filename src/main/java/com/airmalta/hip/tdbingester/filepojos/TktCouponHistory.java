package com.airmalta.hip.tdbingester.filepojos;

import java.sql.Date;
import java.sql.Time;


public class TktCouponHistory extends VCRRecord  {
	
	private String ID;
	private String PNRLocatorID;
	private Date PNRCreateDate;
	private Integer CouponSeqNbr;
	private String FareBasisCode;
	private Integer CouponNbr;
	private String PreviousCouponStatusCode;
	private String NewCouponStatusCode;
	private Integer CouponNbrChanged;
	private String PreviousControlVendorCode;
	private String NewControlVendorCode;
	private String RevalMarketingAirlineCode;
	private String RevalClassofService;
	private String RevalMarketingFlightNbr;
	private Date RevalServiceStartDate;
	private String RevalServiceStartCity;
	private String RevalServiceEndCity;
	private Time RevalServiceStartTime;
	private Time RevalServiceEndTime;
	private String RevalSegmentStatusCode;
	private Date LastUpdate;
	private Time LastUpdateSysTime;
	private Integer HistorySeqNbr;

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

	public Integer getCouponSeqNbr() {
		return CouponSeqNbr;
	}

	public void setCouponSeqNbr(final Integer CouponSeqNbr) {
		this.CouponSeqNbr = CouponSeqNbr;
	}

	public String getFareBasisCode() {
		return FareBasisCode;
	}

	public void setFareBasisCode(final String FareBasisCode) {
		this.FareBasisCode = FareBasisCode;
	}

	public Integer getCouponNbr() {
		return CouponNbr;
	}

	public void setCouponNbr(final Integer CouponNbr) {
		this.CouponNbr = CouponNbr;
	}

	public String getPreviousCouponStatusCode() {
		return PreviousCouponStatusCode;
	}

	public void setPreviousCouponStatusCode(final String PreviousCouponStatusCode) {
		this.PreviousCouponStatusCode = PreviousCouponStatusCode;
	}

	public String getNewCouponStatusCode() {
		return NewCouponStatusCode;
	}

	public void setNewCouponStatusCode(final String NewCouponStatusCode) {
		this.NewCouponStatusCode = NewCouponStatusCode;
	}

	public Integer getCouponNbrChanged() {
		return CouponNbrChanged;
	}

	public void setCouponNbrChanged(final Integer CouponNbrChanged) {
		this.CouponNbrChanged = CouponNbrChanged;
	}

	public String getPreviousControlVendorCode() {
		return PreviousControlVendorCode;
	}

	public void setPreviousControlVendorCode(final String PreviousControlVendorCode) {
		this.PreviousControlVendorCode = PreviousControlVendorCode;
	}

	public String getNewControlVendorCode() {
		return NewControlVendorCode;
	}

	public void setNewControlVendorCode(final String NewControlVendorCode) {
		this.NewControlVendorCode = NewControlVendorCode;
	}

	public String getRevalMarketingAirlineCode() {
		return RevalMarketingAirlineCode;
	}

	public void setRevalMarketingAirlineCode(final String RevalMarketingAirlineCode) {
		this.RevalMarketingAirlineCode = RevalMarketingAirlineCode;
	}

	public String getRevalClassofService() {
		return RevalClassofService;
	}

	public void setRevalClassofService(final String RevalClassofService) {
		this.RevalClassofService = RevalClassofService;
	}

	public String getRevalMarketingFlightNbr() {
		return RevalMarketingFlightNbr;
	}

	public void setRevalMarketingFlightNbr(final String RevalMarketingFlightNbr) {
		this.RevalMarketingFlightNbr = RevalMarketingFlightNbr;
	}

	public Date getRevalServiceStartDate() {
		return RevalServiceStartDate;
	}

	public void setRevalServiceStartDate(final Date RevalServiceStartDate) {
		this.RevalServiceStartDate = RevalServiceStartDate;
	}

	public String getRevalServiceStartCity() {
		return RevalServiceStartCity;
	}

	public void setRevalServiceStartCity(final String RevalServiceStartCity) {
		this.RevalServiceStartCity = RevalServiceStartCity;
	}

	public String getRevalServiceEndCity() {
		return RevalServiceEndCity;
	}

	public void setRevalServiceEndCity(final String RevalServiceEndCity) {
		this.RevalServiceEndCity = RevalServiceEndCity;
	}

	public Time getRevalServiceStartTime() {
		return RevalServiceStartTime;
	}

	public void setRevalServiceStartTime(final Time RevalServiceStartTime) {
		this.RevalServiceStartTime = RevalServiceStartTime;
	}

	public Time getRevalServiceEndTime() {
		return RevalServiceEndTime;
	}

	public void setRevalServiceEndTime(final Time RevalServiceEndTime) {
		this.RevalServiceEndTime = RevalServiceEndTime;
	}

	public String getRevalSegmentStatusCode() {
		return RevalSegmentStatusCode;
	}

	public void setRevalSegmentStatusCode(final String RevalSegmentStatusCode) {
		this.RevalSegmentStatusCode = RevalSegmentStatusCode;
	}

	public Date getLastUpdate() {
		return LastUpdate;
	}

	public void setLastUpdate(final Date LastUpdate) {
		this.LastUpdate = LastUpdate;
	}

	public Time getLastUpdateSysTime() {
		return LastUpdateSysTime;
	}

	public void setLastUpdateSysTime(final Time LastUpdateSysTime) {
		this.LastUpdateSysTime = LastUpdateSysTime;
	}

	public Integer getHistorySeqNbr() {
		return HistorySeqNbr;
	}

	public void setHistorySeqNbr(final Integer HistorySeqNbr) {
		this.HistorySeqNbr = HistorySeqNbr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((CouponNbrChanged == null) ? 0 : CouponNbrChanged.hashCode());
		result = prime * result + ((CouponSeqNbr == null) ? 0 : CouponSeqNbr.hashCode());
		result = prime * result + ((HistorySeqNbr == null) ? 0 : HistorySeqNbr.hashCode());
		result = prime * result + ((LastUpdate == null) ? 0 : LastUpdate.hashCode());
		result = prime * result + ((LastUpdateSysTime == null) ? 0 : LastUpdateSysTime.hashCode());
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
		TktCouponHistory other = (TktCouponHistory) obj;
		if (CouponNbrChanged == null) {
			if (other.CouponNbrChanged != null)
				return false;
		} else if (!CouponNbrChanged.equals(other.CouponNbrChanged))
			return false;
		if (CouponSeqNbr == null) {
			if (other.CouponSeqNbr != null)
				return false;
		} else if (!CouponSeqNbr.equals(other.CouponSeqNbr))
			return false;
		if (HistorySeqNbr == null) {
			if (other.HistorySeqNbr != null)
				return false;
		} else if (!HistorySeqNbr.equals(other.HistorySeqNbr))
			return false;
		if (LastUpdate == null) {
			if (other.LastUpdate != null)
				return false;
		} else if (!LastUpdate.equals(other.LastUpdate))
			return false;
		if (LastUpdateSysTime == null) {
			if (other.LastUpdateSysTime != null)
				return false;
		} else if (!LastUpdateSysTime.equals(other.LastUpdateSysTime))
			return false;
		return true;
	}

}