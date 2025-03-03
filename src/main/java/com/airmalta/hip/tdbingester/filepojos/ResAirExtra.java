package com.airmalta.hip.tdbingester.filepojos;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;


public class ResAirExtra extends PNRRecord {
	
	private String ID;
	private String RFICode;
	private String CommercialName;
	private String SSIMCode;
	private String SSRCode;
	private String BoardPointAirportCode;
	private String OffPointAirportCode;
	private String OwningCarrierCode;
	private String FeeVendorCode;
	private String BookingMethodCode;
	private String FulfillTypeCode;
	private Short EMDTypeCode;
	private String RefundReissueCode;
	private String FormOfRefundCode;
	private String FrequentTravelerTierLevel;
	private String BrandedFareId;
	private String TourCode;
	private String ServiceChargeCode;
	private String FeeApplicationCode;
	private Date FirstTravelDate;
	private Date LastTravelDate;
	private String HistoryActionCode;
	private Timestamp TTYConfirmationDateTime;
	private Timestamp PurchaseByDateTime;
	private String BookingSourceCode;
	private String EMDNbr;
	private Short EMDCouponNbr;
	private String ETicketNbr;
	private Short ETicketCouponNbr;
	private String SSRDirectFulfillCode;
	private String NonEMDFormofPayment;
	private String FeeWaivedCode;
	private BigDecimal AEBasePriceAmount;
	private String AEBaseCurrencyCode;
	private BigDecimal AEEquivalentPaidAmount;
	private String AEEquivalentAmtCurrencyCd;
	private Short ItemCount;
	private BigDecimal AETotalPriceAmount;
	private String PassengerTypeCode;
	private String TaxIncludedCode;
	private String SegmentUseCode;
	private Date SegmentBookedDate;
	private Time SegmentBookedTime;
	private String NonEMDFOPCCCode;
	private String NonEMDFOPMaskedCCNbr;
	private String NonEMDFOPCCExpryDt;
	private String GroupCode;
	private String SimultaneousTicketPurchaseInd;
	private String CommissionInd;
	private String InterlineInd;
	private String FeeGuaranteedInd;
	private String EMDPaperInd;
	private String RFISubCode;
	private Date RecordUpdateDate;
	private Time RecordUpdateTime;
	private Short IntraPNRSetNbr;
	private Short PNRPassengerSeqId;
	private String AEFLight;
	private String AECurrentSegmentStatusCode;
	private String AEPreviousSegmentStatus;
	private Short ACSCount;
	private Short AssociatedSegmentCount;

	public String getID() {
		return ID;
	}

	public void setID(final String ID) {
		this.ID = ID;
	}

	public String getRFICode() {
		return RFICode;
	}

	public void setRFICode(final String RFICode) {
		this.RFICode = RFICode;
	}

	public String getCommercialName() {
		return CommercialName;
	}

	public void setCommercialName(final String CommercialName) {
		this.CommercialName = CommercialName;
	}

	public String getSSIMCode() {
		return SSIMCode;
	}

	public void setSSIMCode(final String SSIMCode) {
		this.SSIMCode = SSIMCode;
	}

	public String getSSRCode() {
		return SSRCode;
	}

	public void setSSRCode(final String SSRCode) {
		this.SSRCode = SSRCode;
	}

	public String getBoardPointAirportCode() {
		return BoardPointAirportCode;
	}

	public void setBoardPointAirportCode(final String BoardPointAirportCode) {
		this.BoardPointAirportCode = BoardPointAirportCode;
	}

	public String getOffPointAirportCode() {
		return OffPointAirportCode;
	}

	public void setOffPointAirportCode(final String OffPointAirportCode) {
		this.OffPointAirportCode = OffPointAirportCode;
	}

	public String getOwningCarrierCode() {
		return OwningCarrierCode;
	}

	public void setOwningCarrierCode(final String OwningCarrierCode) {
		this.OwningCarrierCode = OwningCarrierCode;
	}

	public String getFeeVendorCode() {
		return FeeVendorCode;
	}

	public void setFeeVendorCode(final String FeeVendorCode) {
		this.FeeVendorCode = FeeVendorCode;
	}

	public String getBookingMethodCode() {
		return BookingMethodCode;
	}

	public void setBookingMethodCode(final String BookingMethodCode) {
		this.BookingMethodCode = BookingMethodCode;
	}

	public String getFulfillTypeCode() {
		return FulfillTypeCode;
	}

	public void setFulfillTypeCode(final String FulfillTypeCode) {
		this.FulfillTypeCode = FulfillTypeCode;
	}

	public Short getEMDTypeCode() {
		return EMDTypeCode;
	}

	public void setEMDTypeCode(final Short EMDTypeCode) {
		this.EMDTypeCode = EMDTypeCode;
	}

	public String getRefundReissueCode() {
		return RefundReissueCode;
	}

	public void setRefundReissueCode(final String RefundReissueCode) {
		this.RefundReissueCode = RefundReissueCode;
	}

	public String getFormOfRefundCode() {
		return FormOfRefundCode;
	}

	public void setFormOfRefundCode(final String FormOfRefundCode) {
		this.FormOfRefundCode = FormOfRefundCode;
	}

	public String getFrequentTravelerTierLevel() {
		return FrequentTravelerTierLevel;
	}

	public void setFrequentTravelerTierLevel(final String FrequentTravelerTierLevel) {
		this.FrequentTravelerTierLevel = FrequentTravelerTierLevel;
	}

	public String getBrandedFareId() {
		return BrandedFareId;
	}

	public void setBrandedFareId(final String BrandedFareId) {
		this.BrandedFareId = BrandedFareId;
	}

	public String getTourCode() {
		return TourCode;
	}

	public void setTourCode(final String TourCode) {
		this.TourCode = TourCode;
	}

	public String getServiceChargeCode() {
		return ServiceChargeCode;
	}

	public void setServiceChargeCode(final String ServiceChargeCode) {
		this.ServiceChargeCode = ServiceChargeCode;
	}

	public String getFeeApplicationCode() {
		return FeeApplicationCode;
	}

	public void setFeeApplicationCode(final String FeeApplicationCode) {
		this.FeeApplicationCode = FeeApplicationCode;
	}

	public Date getFirstTravelDate() {
		return FirstTravelDate;
	}

	public void setFirstTravelDate(final Date FirstTravelDate) {
		this.FirstTravelDate = FirstTravelDate;
	}

	public Date getLastTravelDate() {
		return LastTravelDate;
	}

	public void setLastTravelDate(final Date LastTravelDate) {
		this.LastTravelDate = LastTravelDate;
	}

	public String getHistoryActionCode() {
		return HistoryActionCode;
	}

	public void setHistoryActionCode(final String HistoryActionCode) {
		this.HistoryActionCode = HistoryActionCode;
	}

	public Timestamp getTTYConfirmationDateTime() {
		return TTYConfirmationDateTime;
	}

	public void setTTYConfirmationDateTime(final Timestamp TTYConfirmationDateTime) {
		this.TTYConfirmationDateTime = TTYConfirmationDateTime;
	}

	public Timestamp getPurchaseByDateTime() {
		return PurchaseByDateTime;
	}

	public void setPurchaseByDateTime(final Timestamp PurchaseByDateTime) {
		this.PurchaseByDateTime = PurchaseByDateTime;
	}

	public String getBookingSourceCode() {
		return BookingSourceCode;
	}

	public void setBookingSourceCode(final String BookingSourceCode) {
		this.BookingSourceCode = BookingSourceCode;
	}

	public String getEMDNbr() {
		return EMDNbr;
	}

	public void setEMDNbr(final String EMDNbr) {
		this.EMDNbr = EMDNbr;
	}

	public Short getEMDCouponNbr() {
		return EMDCouponNbr;
	}

	public void setEMDCouponNbr(final Short EMDCouponNbr) {
		this.EMDCouponNbr = EMDCouponNbr;
	}

	public String getETicketNbr() {
		return ETicketNbr;
	}

	public void setETicketNbr(final String ETicketNbr) {
		this.ETicketNbr = ETicketNbr;
	}

	public Short getETicketCouponNbr() {
		return ETicketCouponNbr;
	}

	public void setETicketCouponNbr(final Short ETicketCouponNbr) {
		this.ETicketCouponNbr = ETicketCouponNbr;
	}

	public String getSSRDirectFulfillCode() {
		return SSRDirectFulfillCode;
	}

	public void setSSRDirectFulfillCode(final String SSRDirectFulfillCode) {
		this.SSRDirectFulfillCode = SSRDirectFulfillCode;
	}

	public String getNonEMDFormofPayment() {
		return NonEMDFormofPayment;
	}

	public void setNonEMDFormofPayment(final String NonEMDFormofPayment) {
		this.NonEMDFormofPayment = NonEMDFormofPayment;
	}

	public String getFeeWaivedCode() {
		return FeeWaivedCode;
	}

	public void setFeeWaivedCode(final String FeeWaivedCode) {
		this.FeeWaivedCode = FeeWaivedCode;
	}

	public BigDecimal getAEBasePriceAmount() {
		return AEBasePriceAmount;
	}

	public void setAEBasePriceAmount(final BigDecimal AEBasePriceAmount) {
		this.AEBasePriceAmount = AEBasePriceAmount;
	}

	public String getAEBaseCurrencyCode() {
		return AEBaseCurrencyCode;
	}

	public void setAEBaseCurrencyCode(final String AEBaseCurrencyCode) {
		this.AEBaseCurrencyCode = AEBaseCurrencyCode;
	}

	public BigDecimal getAEEquivalentPaidAmount() {
		return AEEquivalentPaidAmount;
	}

	public void setAEEquivalentPaidAmount(final BigDecimal AEEquivalentPaidAmount) {
		this.AEEquivalentPaidAmount = AEEquivalentPaidAmount;
	}

	public String getAEEquivalentAmtCurrencyCd() {
		return AEEquivalentAmtCurrencyCd;
	}

	public void setAEEquivalentAmtCurrencyCd(final String AEEquivalentAmtCurrencyCd) {
		this.AEEquivalentAmtCurrencyCd = AEEquivalentAmtCurrencyCd;
	}

	public Short getItemCount() {
		return ItemCount;
	}

	public void setItemCount(final Short ItemCount) {
		this.ItemCount = ItemCount;
	}

	public BigDecimal getAETotalPriceAmount() {
		return AETotalPriceAmount;
	}

	public void setAETotalPriceAmount(final BigDecimal AETotalPriceAmount) {
		this.AETotalPriceAmount = AETotalPriceAmount;
	}

	public String getPassengerTypeCode() {
		return PassengerTypeCode;
	}

	public void setPassengerTypeCode(final String PassengerTypeCode) {
		this.PassengerTypeCode = PassengerTypeCode;
	}

	public String getTaxIncludedCode() {
		return TaxIncludedCode;
	}

	public void setTaxIncludedCode(final String TaxIncludedCode) {
		this.TaxIncludedCode = TaxIncludedCode;
	}

	public String getSegmentUseCode() {
		return SegmentUseCode;
	}

	public void setSegmentUseCode(final String SegmentUseCode) {
		this.SegmentUseCode = SegmentUseCode;
	}

	public Date getSegmentBookedDate() {
		return SegmentBookedDate;
	}

	public void setSegmentBookedDate(final Date SegmentBookedDate) {
		this.SegmentBookedDate = SegmentBookedDate;
	}

	public Time getSegmentBookedTime() {
		return SegmentBookedTime;
	}

	public void setSegmentBookedTime(final Time SegmentBookedTime) {
		this.SegmentBookedTime = SegmentBookedTime;
	}

	public String getNonEMDFOPCCCode() {
		return NonEMDFOPCCCode;
	}

	public void setNonEMDFOPCCCode(final String NonEMDFOPCCCode) {
		this.NonEMDFOPCCCode = NonEMDFOPCCCode;
	}

	public String getNonEMDFOPMaskedCCNbr() {
		return NonEMDFOPMaskedCCNbr;
	}

	public void setNonEMDFOPMaskedCCNbr(final String NonEMDFOPMaskedCCNbr) {
		this.NonEMDFOPMaskedCCNbr = NonEMDFOPMaskedCCNbr;
	}

	public String getNonEMDFOPCCExpryDt() {
		return NonEMDFOPCCExpryDt;
	}

	public void setNonEMDFOPCCExpryDt(final String NonEMDFOPCCExpryDt) {
		this.NonEMDFOPCCExpryDt = NonEMDFOPCCExpryDt;
	}

	public String getGroupCode() {
		return GroupCode;
	}

	public void setGroupCode(final String GroupCode) {
		this.GroupCode = GroupCode;
	}

	public String getSimultaneousTicketPurchaseInd() {
		return SimultaneousTicketPurchaseInd;
	}

	public void setSimultaneousTicketPurchaseInd(final String SimultaneousTicketPurchaseInd) {
		this.SimultaneousTicketPurchaseInd = SimultaneousTicketPurchaseInd;
	}

	public String getCommissionInd() {
		return CommissionInd;
	}

	public void setCommissionInd(final String CommissionInd) {
		this.CommissionInd = CommissionInd;
	}

	public String getInterlineInd() {
		return InterlineInd;
	}

	public void setInterlineInd(final String InterlineInd) {
		this.InterlineInd = InterlineInd;
	}

	public String getFeeGuaranteedInd() {
		return FeeGuaranteedInd;
	}

	public void setFeeGuaranteedInd(final String FeeGuaranteedInd) {
		this.FeeGuaranteedInd = FeeGuaranteedInd;
	}

	public String getEMDPaperInd() {
		return EMDPaperInd;
	}

	public void setEMDPaperInd(final String EMDPaperInd) {
		this.EMDPaperInd = EMDPaperInd;
	}

	public String getRFISubCode() {
		return RFISubCode;
	}

	public void setRFISubCode(final String RFISubCode) {
		this.RFISubCode = RFISubCode;
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

	public Short getPNRPassengerSeqId() {
		return PNRPassengerSeqId;
	}

	public void setPNRPassengerSeqId(final Short PNRPassengerSeqId) {
		this.PNRPassengerSeqId = PNRPassengerSeqId;
	}

	public String getAEFLight() {
		return AEFLight;
	}

	public void setAEFLight(final String AEFLight) {
		this.AEFLight = AEFLight;
	}

	public String getAECurrentSegmentStatusCode() {
		return AECurrentSegmentStatusCode;
	}

	public void setAECurrentSegmentStatusCode(final String AECurrentSegmentStatusCode) {
		this.AECurrentSegmentStatusCode = AECurrentSegmentStatusCode;
	}

	public String getAEPreviousSegmentStatus() {
		return AEPreviousSegmentStatus;
	}

	public void setAEPreviousSegmentStatus(final String AEPreviousSegmentStatus) {
		this.AEPreviousSegmentStatus = AEPreviousSegmentStatus;
	}

	public Short getACSCount() {
		return ACSCount;
	}

	public void setACSCount(final Short ACSCount) {
		this.ACSCount = ACSCount;
	}

	public Short getAssociatedSegmentCount() {
		return AssociatedSegmentCount;
	}

	public void setAssociatedSegmentCount(final Short AssociatedSegmentCount) {
		this.AssociatedSegmentCount = AssociatedSegmentCount;
	}

}