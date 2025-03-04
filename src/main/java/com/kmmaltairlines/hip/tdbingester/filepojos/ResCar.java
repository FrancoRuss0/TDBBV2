package com.kmmaltairlines.hip.tdbingester.filepojos;

import java.sql.Date;
import java.sql.Time;

public class ResCar extends PNRRecord {

	private String ID;
	private Short SegmentNbr;
	private String CarClassificationCode;
	private String CarCorporateDiscountNbr;
	private String CarDropoffChargeAmount;
	private String CarDropOffCurCode;
	private String CarExtraDayRateAmount;
	private String CarExtraHourRateAmount;
	private String CarMileageLimit;
	private String CarReserveUnderName;
	private String CarTypeCode;
	private String ConfirmationNbr;
	private String ServiceStartCity;
	private Date ServiceStartDate;
	private Time ServiceStartTime;
	private String CurrentSegmentStatusCode;
	private Short UnitsBookedCount;
	private Short DaysRentedCount;
	private String VendorCarCode;
	private String RentalRate;
	private String CurrencyCode;
	private String RatePlanCode;
	private String NonAirportLocationDescript;
	private String ProductNonstdEndLocationText;
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

	public String getCarClassificationCode() {
		return CarClassificationCode;
	}

	public void setCarClassificationCode(final String CarClassificationCode) {
		this.CarClassificationCode = CarClassificationCode;
	}

	public String getCarCorporateDiscountNbr() {
		return CarCorporateDiscountNbr;
	}

	public void setCarCorporateDiscountNbr(final String CarCorporateDiscountNbr) {
		this.CarCorporateDiscountNbr = CarCorporateDiscountNbr;
	}

	public String getCarDropoffChargeAmount() {
		return CarDropoffChargeAmount;
	}

	public void setCarDropoffChargeAmount(final String CarDropoffChargeAmount) {
		this.CarDropoffChargeAmount = CarDropoffChargeAmount;
	}

	public String getCarDropOffCurCode() {
		return CarDropOffCurCode;
	}

	public void setCarDropOffCurCode(final String CarDropOffCurCode) {
		this.CarDropOffCurCode = CarDropOffCurCode;
	}

	public String getCarExtraDayRateAmount() {
		return CarExtraDayRateAmount;
	}

	public void setCarExtraDayRateAmount(final String CarExtraDayRateAmount) {
		this.CarExtraDayRateAmount = CarExtraDayRateAmount;
	}

	public String getCarExtraHourRateAmount() {
		return CarExtraHourRateAmount;
	}

	public void setCarExtraHourRateAmount(final String CarExtraHourRateAmount) {
		this.CarExtraHourRateAmount = CarExtraHourRateAmount;
	}

	public String getCarMileageLimit() {
		return CarMileageLimit;
	}

	public void setCarMileageLimit(final String CarMileageLimit) {
		this.CarMileageLimit = CarMileageLimit;
	}

	public String getCarReserveUnderName() {
		return CarReserveUnderName;
	}

	public void setCarReserveUnderName(final String CarReserveUnderName) {
		this.CarReserveUnderName = CarReserveUnderName;
	}

	public String getCarTypeCode() {
		return CarTypeCode;
	}

	public void setCarTypeCode(final String CarTypeCode) {
		this.CarTypeCode = CarTypeCode;
	}

	public String getConfirmationNbr() {
		return ConfirmationNbr;
	}

	public void setConfirmationNbr(final String ConfirmationNbr) {
		this.ConfirmationNbr = ConfirmationNbr;
	}

	public String getServiceStartCity() {
		return ServiceStartCity;
	}

	public void setServiceStartCity(final String ServiceStartCity) {
		this.ServiceStartCity = ServiceStartCity;
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

	public String getCurrentSegmentStatusCode() {
		return CurrentSegmentStatusCode;
	}

	public void setCurrentSegmentStatusCode(final String CurrentSegmentStatusCode) {
		this.CurrentSegmentStatusCode = CurrentSegmentStatusCode;
	}

	public Short getUnitsBookedCount() {
		return UnitsBookedCount;
	}

	public void setUnitsBookedCount(final Short UnitsBookedCount) {
		this.UnitsBookedCount = UnitsBookedCount;
	}

	public Short getDaysRentedCount() {
		return DaysRentedCount;
	}

	public void setDaysRentedCount(final Short DaysRentedCount) {
		this.DaysRentedCount = DaysRentedCount;
	}

	public String getVendorCarCode() {
		return VendorCarCode;
	}

	public void setVendorCarCode(final String VendorCarCode) {
		this.VendorCarCode = VendorCarCode;
	}

	public String getRentalRate() {
		return RentalRate;
	}

	public void setRentalRate(final String RentalRate) {
		this.RentalRate = RentalRate;
	}

	public String getCurrencyCode() {
		return CurrencyCode;
	}

	public void setCurrencyCode(final String CurrencyCode) {
		this.CurrencyCode = CurrencyCode;
	}

	public String getRatePlanCode() {
		return RatePlanCode;
	}

	public void setRatePlanCode(final String RatePlanCode) {
		this.RatePlanCode = RatePlanCode;
	}

	public String getNonAirportLocationDescript() {
		return NonAirportLocationDescript;
	}

	public void setNonAirportLocationDescript(final String NonAirportLocationDescript) {
		this.NonAirportLocationDescript = NonAirportLocationDescript;
	}

	public String getProductNonstdEndLocationText() {
		return ProductNonstdEndLocationText;
	}

	public void setProductNonstdEndLocationText(final String ProductNonstdEndLocationText) {
		this.ProductNonstdEndLocationText = ProductNonstdEndLocationText;
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
		ResCar other = (ResCar) obj;
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