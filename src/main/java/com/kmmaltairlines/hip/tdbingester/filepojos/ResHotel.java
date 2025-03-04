package com.kmmaltairlines.hip.tdbingester.filepojos;

import java.sql.Date;
import java.sql.Time;

public class ResHotel extends PNRRecord {

	private String ID;
	private Short SegmentNbr;
	private String ServiceCityCode;
	private Date ServiceStartDate;
	private Short NbrofNightsCount;
	private Short UnitsBookedCount;
	private String CurrentSegmentStatusCode;
	private Short SegmentTypeCode;
	private String PropertyCode;
	private String PropertyName;
	private String VendorHotelCode;
	private String HotelRoomTypeCode;
	private String HotelRoomRate;
	private String HotelRateCode;
	private String CurrencyCode;
	private String HotelProductCode;
	private String ConfirmationNbr;
	private String HotelReserveUnderName;
	private String HotelCorporateDiscountNbr;
	private String HotelExtraPersonRateAmount;
	private Short HotelExtraPersonCount;
	private Short NumberOfAdults;
	private String HistoryActionCodeId;
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

	public String getServiceCityCode() {
		return ServiceCityCode;
	}

	public void setServiceCityCode(final String ServiceCityCode) {
		this.ServiceCityCode = ServiceCityCode;
	}

	public Date getServiceStartDate() {
		return ServiceStartDate;
	}

	public void setServiceStartDate(final Date ServiceStartDate) {
		this.ServiceStartDate = ServiceStartDate;
	}

	public Short getNbrofNightsCount() {
		return NbrofNightsCount;
	}

	public void setNbrofNightsCount(final Short NbrofNightsCount) {
		this.NbrofNightsCount = NbrofNightsCount;
	}

	public Short getUnitsBookedCount() {
		return UnitsBookedCount;
	}

	public void setUnitsBookedCount(final Short UnitsBookedCount) {
		this.UnitsBookedCount = UnitsBookedCount;
	}

	public String getCurrentSegmentStatusCode() {
		return CurrentSegmentStatusCode;
	}

	public void setCurrentSegmentStatusCode(final String CurrentSegmentStatusCode) {
		this.CurrentSegmentStatusCode = CurrentSegmentStatusCode;
	}

	public Short getSegmentTypeCode() {
		return SegmentTypeCode;
	}

	public void setSegmentTypeCode(final Short SegmentTypeCode) {
		this.SegmentTypeCode = SegmentTypeCode;
	}

	public String getPropertyCode() {
		return PropertyCode;
	}

	public void setPropertyCode(final String PropertyCode) {
		this.PropertyCode = PropertyCode;
	}

	public String getPropertyName() {
		return PropertyName;
	}

	public void setPropertyName(final String PropertyName) {
		this.PropertyName = PropertyName;
	}

	public String getVendorHotelCode() {
		return VendorHotelCode;
	}

	public void setVendorHotelCode(final String VendorHotelCode) {
		this.VendorHotelCode = VendorHotelCode;
	}

	public String getHotelRoomTypeCode() {
		return HotelRoomTypeCode;
	}

	public void setHotelRoomTypeCode(final String HotelRoomTypeCode) {
		this.HotelRoomTypeCode = HotelRoomTypeCode;
	}

	public String getHotelRoomRate() {
		return HotelRoomRate;
	}

	public void setHotelRoomRate(final String HotelRoomRate) {
		this.HotelRoomRate = HotelRoomRate;
	}

	public String getHotelRateCode() {
		return HotelRateCode;
	}

	public void setHotelRateCode(final String HotelRateCode) {
		this.HotelRateCode = HotelRateCode;
	}

	public String getCurrencyCode() {
		return CurrencyCode;
	}

	public void setCurrencyCode(final String CurrencyCode) {
		this.CurrencyCode = CurrencyCode;
	}

	public String getHotelProductCode() {
		return HotelProductCode;
	}

	public void setHotelProductCode(final String HotelProductCode) {
		this.HotelProductCode = HotelProductCode;
	}

	public String getConfirmationNbr() {
		return ConfirmationNbr;
	}

	public void setConfirmationNbr(final String ConfirmationNbr) {
		this.ConfirmationNbr = ConfirmationNbr;
	}

	public String getHotelReserveUnderName() {
		return HotelReserveUnderName;
	}

	public void setHotelReserveUnderName(final String HotelReserveUnderName) {
		this.HotelReserveUnderName = HotelReserveUnderName;
	}

	public String getHotelCorporateDiscountNbr() {
		return HotelCorporateDiscountNbr;
	}

	public void setHotelCorporateDiscountNbr(final String HotelCorporateDiscountNbr) {
		this.HotelCorporateDiscountNbr = HotelCorporateDiscountNbr;
	}

	public String getHotelExtraPersonRateAmount() {
		return HotelExtraPersonRateAmount;
	}

	public void setHotelExtraPersonRateAmount(final String HotelExtraPersonRateAmount) {
		this.HotelExtraPersonRateAmount = HotelExtraPersonRateAmount;
	}

	public Short getHotelExtraPersonCount() {
		return HotelExtraPersonCount;
	}

	public void setHotelExtraPersonCount(final Short HotelExtraPersonCount) {
		this.HotelExtraPersonCount = HotelExtraPersonCount;
	}

	public Short getNumberOfAdults() {
		return NumberOfAdults;
	}

	public void setNumberOfAdults(final Short NumberOfAdults) {
		this.NumberOfAdults = NumberOfAdults;
	}

	public String getHistoryActionCodeId() {
		return HistoryActionCodeId;
	}

	public void setHistoryActionCodeId(final String HistoryActionCodeId) {
		this.HistoryActionCodeId = HistoryActionCodeId;
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
		ResHotel other = (ResHotel) obj;
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