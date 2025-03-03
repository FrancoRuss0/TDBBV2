package com.airmalta.hip.tdbingester.filepojos;

import java.sql.Date;


public class TktCouponEMD extends VCRRecord {

	private String ID;
	private String PNRLocatorID;
	private Date PNRCreateDate;
	private Short CouponSeqNbr;
	private String FeeOwnerCode;
	private String OCGroupCode;
	private String RFICode;
	private Integer QuantSold;
	private String RFISubCode;
	private String CommercialName;
	private String EMDTypeCode;
	private String FeeGuaranteedInd;
	private String FeeVendorCode;
	private String SegmentUseCode;
	private String RelPrimaryDocNbr;
	private Byte RelCouponSeqNbr;
	private Date RelVCRCreateDate;

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

	public String getFeeOwnerCode() {
		return FeeOwnerCode;
	}

	public void setFeeOwnerCode(final String FeeOwnerCode) {
		this.FeeOwnerCode = FeeOwnerCode;
	}

	public String getOCGroupCode() {
		return OCGroupCode;
	}

	public void setOCGroupCode(final String OCGroupCode) {
		this.OCGroupCode = OCGroupCode;
	}

	public String getRFICode() {
		return RFICode;
	}

	public void setRFICode(final String RFICode) {
		this.RFICode = RFICode;
	}

	public Integer getQuantSold() {
		return QuantSold;
	}

	public void setQuantSold(final Integer QuantSold) {
		this.QuantSold = QuantSold;
	}

	public String getRFISubCode() {
		return RFISubCode;
	}

	public void setRFISubCode(final String RFISubCode) {
		this.RFISubCode = RFISubCode;
	}

	public String getCommercialName() {
		return CommercialName;
	}

	public void setCommercialName(final String CommercialName) {
		this.CommercialName = CommercialName;
	}

	public String getEMDTypeCode() {
		return EMDTypeCode;
	}

	public void setEMDTypeCode(final String EMDTypeCode) {
		this.EMDTypeCode = EMDTypeCode;
	}

	public String getFeeGuaranteedInd() {
		return FeeGuaranteedInd;
	}

	public void setFeeGuaranteedInd(final String FeeGuaranteedInd) {
		this.FeeGuaranteedInd = FeeGuaranteedInd;
	}

	public String getFeeVendorCode() {
		return FeeVendorCode;
	}

	public void setFeeVendorCode(final String FeeVendorCode) {
		this.FeeVendorCode = FeeVendorCode;
	}

	public String getSegmentUseCode() {
		return SegmentUseCode;
	}

	public void setSegmentUseCode(final String SegmentUseCode) {
		this.SegmentUseCode = SegmentUseCode;
	}

	public String getRelPrimaryDocNbr() {
		return RelPrimaryDocNbr;
	}

	public void setRelPrimaryDocNbr(final String RelPrimaryDocNbr) {
		this.RelPrimaryDocNbr = RelPrimaryDocNbr;
	}

	public Byte getRelCouponSeqNbr() {
		return RelCouponSeqNbr;
	}

	public void setRelCouponSeqNbr(final Byte RelCouponSeqNbr) {
		this.RelCouponSeqNbr = RelCouponSeqNbr;
	}

	public Date getRelVCRCreateDate() {
		return RelVCRCreateDate;
	}

	public void setRelVCRCreateDate(final Date RelVCRCreateDate) {
		this.RelVCRCreateDate = RelVCRCreateDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((CouponSeqNbr == null) ? 0 : CouponSeqNbr.hashCode());
		result = prime * result + ((RelCouponSeqNbr == null) ? 0 : RelCouponSeqNbr.hashCode());
		result = prime * result + ((RelPrimaryDocNbr == null) ? 0 : RelPrimaryDocNbr.hashCode());
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
		TktCouponEMD other = (TktCouponEMD) obj;
		if (CouponSeqNbr == null) {
			if (other.CouponSeqNbr != null)
				return false;
		} else if (!CouponSeqNbr.equals(other.CouponSeqNbr))
			return false;
		if (RelCouponSeqNbr == null) {
			if (other.RelCouponSeqNbr != null)
				return false;
		} else if (!RelCouponSeqNbr.equals(other.RelCouponSeqNbr))
			return false;
		if (RelPrimaryDocNbr == null) {
			if (other.RelPrimaryDocNbr != null)
				return false;
		} else if (!RelPrimaryDocNbr.equals(other.RelPrimaryDocNbr))
			return false;
		return true;
	}

}