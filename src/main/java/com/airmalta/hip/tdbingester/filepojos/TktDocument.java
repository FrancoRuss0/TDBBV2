package com.airmalta.hip.tdbingester.filepojos;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Defines the structure of a TktDocument file.
 * 
 * Fields used to determine uniqueness:
 *   - PrimaryDocNbr
 *   - VCRCreateDate
 *   - AddlExchgTktData
 * 
 * @author justin.saliba
 */
public class TktDocument extends VCRRecord {
	
	private String ID;
	private String PNRLocatorID;
	private Date PNRCreateDate;
	private String AirlineAccountingCode;
	private String EndDocNbr;
	private String VendorName;
	private String PointOfTktIssuance;
	private String ValidatingVendorCode;
	private String ValidatingVendorNbr;
	private Date PNRPurgeDate;
	private String CRSPNRLocator;
	private Date DocIssueDate;
	private String CustomerFullName;
	private String AgentCountryCode;
	private String IntlDocSaleCode;
	private String TourCode;
	private String AgentSine;
	private String OwningCityCode;
	private String AAACityCode;
	private String DocIssueAAAIATANbr;
	private String HomeCityCode;
	private String Restrictions;
	private String CurrConverRate;
	private Short BankSellRate;
	private Short BankBuyRate;
	private Short IntlClearHouseRate;
	private BigDecimal ExchgTktAmt;
	private String SettlementAuthCode;
	private String BaseFareCurrCode;
	private BigDecimal BaseFareAmt;
	private String TotalFareCurrCode;
	private BigDecimal TotalDocAmt;
	private String EquivBaseFareCurrCode;
	private BigDecimal EquivBaseFareAmt;
	private String DataInd;
	private String FareCalc;
	private Byte FareCalcType;
	private Date OriginalIssueDate;
	private String OriginalIssueCity;
	private String OriginalIATANbr;
	private String OriginalFOP;
	private String OriginalTktNbr;
	private String ExchgFOP;
	private String AddlExchgTktData;
	private String ExchgCoupon;
	private String AutoPriceCode;
	private String DocTypeCode;
	private String DocStatusCode;
	private String PassengerType;
	private String SourceSystemId;
	private String OACStationNbr;
	private String RefundableInd;
	private String CommissionableInd;
	private String InterlineInd;
	private String EMDRFICode;
	private String EMDType;
	private String TaxExInd;
	private String ConsumedAtIssueInd;
	private String ElectronicDocumentInd;
	private String ManualDocumentInd;
	private String VoucherRefundInd;
	private String RFICode;
	private String RFITxt;
	private String PTASvcChargeCurrCode;
	private BigDecimal PTASvcChargeAmt;
	private String PTAAddFundsDesc;
	private String PTAAddFundsCurrCode;
	private BigDecimal PTAAddFundsAmt;
	private String ExchgChangeFeeCurrCode;
	private BigDecimal ExchgChangeFeeAmt;
	private String OtherFeeCurrCode;
	private BigDecimal OtherFeeAmt;
	private String AddCollectCurrCode;
	private BigDecimal AddCollectAmt;
	private String OACDefaultPartitionCode;
	private String OACCityCode;
	private String OACAcctCode;
	private String NonRefFeeCurrCode;
	private BigDecimal NonRefFeeAmt;
	private String OBFeeDescText;
	private String OBFeePricingCode;
	private String OBFeeWaiverCode;
	private String OBFeeTotalCurrCode;
	private BigDecimal OBFeeTotal;
	private BigDecimal OBFeeTotalUSD;
	private String PricedPassengerType;

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

	public String getAirlineAccountingCode() {
		return AirlineAccountingCode;
	}

	public void setAirlineAccountingCode(final String AirlineAccountingCode) {
		this.AirlineAccountingCode = AirlineAccountingCode;
	}

	public String getEndDocNbr() {
		return EndDocNbr;
	}

	public void setEndDocNbr(final String EndDocNbr) {
		this.EndDocNbr = EndDocNbr;
	}

	public String getVendorName() {
		return VendorName;
	}

	public void setVendorName(final String VendorName) {
		this.VendorName = VendorName;
	}

	public String getPointOfTktIssuance() {
		return PointOfTktIssuance;
	}

	public void setPointOfTktIssuance(final String PointOfTktIssuance) {
		this.PointOfTktIssuance = PointOfTktIssuance;
	}

	public String getValidatingVendorCode() {
		return ValidatingVendorCode;
	}

	public void setValidatingVendorCode(final String ValidatingVendorCode) {
		this.ValidatingVendorCode = ValidatingVendorCode;
	}

	public String getValidatingVendorNbr() {
		return ValidatingVendorNbr;
	}

	public void setValidatingVendorNbr(final String ValidatingVendorNbr) {
		this.ValidatingVendorNbr = ValidatingVendorNbr;
	}

	public Date getPNRPurgeDate() {
		return PNRPurgeDate;
	}

	public void setPNRPurgeDate(final Date PNRPurgeDate) {
		this.PNRPurgeDate = PNRPurgeDate;
	}

	public String getCRSPNRLocator() {
		return CRSPNRLocator;
	}

	public void setCRSPNRLocator(final String CRSPNRLocator) {
		this.CRSPNRLocator = CRSPNRLocator;
	}

	public Date getDocIssueDate() {
		return DocIssueDate;
	}

	public void setDocIssueDate(final Date DocIssueDate) {
		this.DocIssueDate = DocIssueDate;
	}

	public String getCustomerFullName() {
		return CustomerFullName;
	}

	public void setCustomerFullName(final String CustomerFullName) {
		this.CustomerFullName = CustomerFullName;
	}

	public String getAgentCountryCode() {
		return AgentCountryCode;
	}

	public void setAgentCountryCode(final String AgentCountryCode) {
		this.AgentCountryCode = AgentCountryCode;
	}

	public String getIntlDocSaleCode() {
		return IntlDocSaleCode;
	}

	public void setIntlDocSaleCode(final String IntlDocSaleCode) {
		this.IntlDocSaleCode = IntlDocSaleCode;
	}

	public String getTourCode() {
		return TourCode;
	}

	public void setTourCode(final String TourCode) {
		this.TourCode = TourCode;
	}

	public String getAgentSine() {
		return AgentSine;
	}

	public void setAgentSine(final String AgentSine) {
		this.AgentSine = AgentSine;
	}

	public String getOwningCityCode() {
		return OwningCityCode;
	}

	public void setOwningCityCode(final String OwningCityCode) {
		this.OwningCityCode = OwningCityCode;
	}

	public String getAAACityCode() {
		return AAACityCode;
	}

	public void setAAACityCode(final String AAACityCode) {
		this.AAACityCode = AAACityCode;
	}

	public String getDocIssueAAAIATANbr() {
		return DocIssueAAAIATANbr;
	}

	public void setDocIssueAAAIATANbr(final String DocIssueAAAIATANbr) {
		this.DocIssueAAAIATANbr = DocIssueAAAIATANbr;
	}

	public String getHomeCityCode() {
		return HomeCityCode;
	}

	public void setHomeCityCode(final String HomeCityCode) {
		this.HomeCityCode = HomeCityCode;
	}

	public String getRestrictions() {
		return Restrictions;
	}

	public void setRestrictions(final String Restrictions) {
		this.Restrictions = Restrictions;
	}

	public String getCurrConverRate() {
		return CurrConverRate;
	}

	public void setCurrConverRate(final String CurrConverRate) {
		this.CurrConverRate = CurrConverRate;
	}

	public Short getBankSellRate() {
		return BankSellRate;
	}

	public void setBankSellRate(final Short BankSellRate) {
		this.BankSellRate = BankSellRate;
	}

	public Short getBankBuyRate() {
		return BankBuyRate;
	}

	public void setBankBuyRate(final Short BankBuyRate) {
		this.BankBuyRate = BankBuyRate;
	}

	public Short getIntlClearHouseRate() {
		return IntlClearHouseRate;
	}

	public void setIntlClearHouseRate(final Short IntlClearHouseRate) {
		this.IntlClearHouseRate = IntlClearHouseRate;
	}

	public BigDecimal getExchgTktAmt() {
		return ExchgTktAmt;
	}

	public void setExchgTktAmt(final BigDecimal ExchgTktAmt) {
		this.ExchgTktAmt = ExchgTktAmt;
	}

	public String getSettlementAuthCode() {
		return SettlementAuthCode;
	}

	public void setSettlementAuthCode(final String SettlementAuthCode) {
		this.SettlementAuthCode = SettlementAuthCode;
	}

	public String getBaseFareCurrCode() {
		return BaseFareCurrCode;
	}

	public void setBaseFareCurrCode(final String BaseFareCurrCode) {
		this.BaseFareCurrCode = BaseFareCurrCode;
	}

	public BigDecimal getBaseFareAmt() {
		return BaseFareAmt;
	}

	public void setBaseFareAmt(final BigDecimal BaseFareAmt) {
		this.BaseFareAmt = BaseFareAmt;
	}

	public String getTotalFareCurrCode() {
		return TotalFareCurrCode;
	}

	public void setTotalFareCurrCode(final String TotalFareCurrCode) {
		this.TotalFareCurrCode = TotalFareCurrCode;
	}

	public BigDecimal getTotalDocAmt() {
		return TotalDocAmt;
	}

	public void setTotalDocAmt(final BigDecimal TotalDocAmt) {
		this.TotalDocAmt = TotalDocAmt;
	}

	public String getEquivBaseFareCurrCode() {
		return EquivBaseFareCurrCode;
	}

	public void setEquivBaseFareCurrCode(final String EquivBaseFareCurrCode) {
		this.EquivBaseFareCurrCode = EquivBaseFareCurrCode;
	}

	public BigDecimal getEquivBaseFareAmt() {
		return EquivBaseFareAmt;
	}

	public void setEquivBaseFareAmt(final BigDecimal EquivBaseFareAmt) {
		this.EquivBaseFareAmt = EquivBaseFareAmt;
	}

	public String getDataInd() {
		return DataInd;
	}

	public void setDataInd(final String DataInd) {
		this.DataInd = DataInd;
	}

	public String getFareCalc() {
		return FareCalc;
	}

	public void setFareCalc(final String FareCalc) {
		this.FareCalc = FareCalc;
	}

	public Byte getFareCalcType() {
		return FareCalcType;
	}

	public void setFareCalcType(final Byte FareCalcType) {
		this.FareCalcType = FareCalcType;
	}

	public Date getOriginalIssueDate() {
		return OriginalIssueDate;
	}

	public void setOriginalIssueDate(final Date OriginalIssueDate) {
		this.OriginalIssueDate = OriginalIssueDate;
	}

	public String getOriginalIssueCity() {
		return OriginalIssueCity;
	}

	public void setOriginalIssueCity(final String OriginalIssueCity) {
		this.OriginalIssueCity = OriginalIssueCity;
	}

	public String getOriginalIATANbr() {
		return OriginalIATANbr;
	}

	public void setOriginalIATANbr(final String OriginalIATANbr) {
		this.OriginalIATANbr = OriginalIATANbr;
	}

	public String getOriginalFOP() {
		return OriginalFOP;
	}

	public void setOriginalFOP(final String OriginalFOP) {
		this.OriginalFOP = OriginalFOP;
	}

	public String getOriginalTktNbr() {
		return OriginalTktNbr;
	}

	public void setOriginalTktNbr(final String OriginalTktNbr) {
		this.OriginalTktNbr = OriginalTktNbr;
	}

	public String getExchgFOP() {
		return ExchgFOP;
	}

	public void setExchgFOP(final String ExchgFOP) {
		this.ExchgFOP = ExchgFOP;
	}

	public String getAddlExchgTktData() {
		return AddlExchgTktData;
	}

	public void setAddlExchgTktData(final String AddlExchgTktData) {
		this.AddlExchgTktData = AddlExchgTktData;
	}

	public String getExchgCoupon() {
		return ExchgCoupon;
	}

	public void setExchgCoupon(final String ExchgCoupon) {
		this.ExchgCoupon = ExchgCoupon;
	}

	public String getAutoPriceCode() {
		return AutoPriceCode;
	}

	public void setAutoPriceCode(final String AutoPriceCode) {
		this.AutoPriceCode = AutoPriceCode;
	}

	public String getDocTypeCode() {
		return DocTypeCode;
	}

	public void setDocTypeCode(final String DocTypeCode) {
		this.DocTypeCode = DocTypeCode;
	}

	public String getDocStatusCode() {
		return DocStatusCode;
	}

	public void setDocStatusCode(final String DocStatusCode) {
		this.DocStatusCode = DocStatusCode;
	}

	public String getPassengerType() {
		return PassengerType;
	}

	public void setPassengerType(final String PassengerType) {
		this.PassengerType = PassengerType;
	}

	public String getSourceSystemId() {
		return SourceSystemId;
	}

	public void setSourceSystemId(final String SourceSystemId) {
		this.SourceSystemId = SourceSystemId;
	}

	public String getOACStationNbr() {
		return OACStationNbr;
	}

	public void setOACStationNbr(final String OACStationNbr) {
		this.OACStationNbr = OACStationNbr;
	}

	public String getRefundableInd() {
		return RefundableInd;
	}

	public void setRefundableInd(final String RefundableInd) {
		this.RefundableInd = RefundableInd;
	}

	public String getCommissionableInd() {
		return CommissionableInd;
	}

	public void setCommissionableInd(final String CommissionableInd) {
		this.CommissionableInd = CommissionableInd;
	}

	public String getInterlineInd() {
		return InterlineInd;
	}

	public void setInterlineInd(final String InterlineInd) {
		this.InterlineInd = InterlineInd;
	}

	public String getEMDRFICode() {
		return EMDRFICode;
	}

	public void setEMDRFICode(final String EMDRFICode) {
		this.EMDRFICode = EMDRFICode;
	}

	public String getEMDType() {
		return EMDType;
	}

	public void setEMDType(final String EMDType) {
		this.EMDType = EMDType;
	}

	public String getTaxExInd() {
		return TaxExInd;
	}

	public void setTaxExInd(final String TaxExInd) {
		this.TaxExInd = TaxExInd;
	}

	public String getConsumedAtIssueInd() {
		return ConsumedAtIssueInd;
	}

	public void setConsumedAtIssueInd(final String ConsumedAtIssueInd) {
		this.ConsumedAtIssueInd = ConsumedAtIssueInd;
	}

	public String getElectronicDocumentInd() {
		return ElectronicDocumentInd;
	}

	public void setElectronicDocumentInd(final String ElectronicDocumentInd) {
		this.ElectronicDocumentInd = ElectronicDocumentInd;
	}

	public String getManualDocumentInd() {
		return ManualDocumentInd;
	}

	public void setManualDocumentInd(final String ManualDocumentInd) {
		this.ManualDocumentInd = ManualDocumentInd;
	}

	public String getVoucherRefundInd() {
		return VoucherRefundInd;
	}

	public void setVoucherRefundInd(final String VoucherRefundInd) {
		this.VoucherRefundInd = VoucherRefundInd;
	}

	public String getRFICode() {
		return RFICode;
	}

	public void setRFICode(final String RFICode) {
		this.RFICode = RFICode;
	}

	public String getRFITxt() {
		return RFITxt;
	}

	public void setRFITxt(final String RFITxt) {
		this.RFITxt = RFITxt;
	}

	public String getPTASvcChargeCurrCode() {
		return PTASvcChargeCurrCode;
	}

	public void setPTASvcChargeCurrCode(final String PTASvcChargeCurrCode) {
		this.PTASvcChargeCurrCode = PTASvcChargeCurrCode;
	}

	public BigDecimal getPTASvcChargeAmt() {
		return PTASvcChargeAmt;
	}

	public void setPTASvcChargeAmt(final BigDecimal PTASvcChargeAmt) {
		this.PTASvcChargeAmt = PTASvcChargeAmt;
	}

	public String getPTAAddFundsDesc() {
		return PTAAddFundsDesc;
	}

	public void setPTAAddFundsDesc(final String PTAAddFundsDesc) {
		this.PTAAddFundsDesc = PTAAddFundsDesc;
	}

	public String getPTAAddFundsCurrCode() {
		return PTAAddFundsCurrCode;
	}

	public void setPTAAddFundsCurrCode(final String PTAAddFundsCurrCode) {
		this.PTAAddFundsCurrCode = PTAAddFundsCurrCode;
	}

	public BigDecimal getPTAAddFundsAmt() {
		return PTAAddFundsAmt;
	}

	public void setPTAAddFundsAmt(final BigDecimal PTAAddFundsAmt) {
		this.PTAAddFundsAmt = PTAAddFundsAmt;
	}

	public String getExchgChangeFeeCurrCode() {
		return ExchgChangeFeeCurrCode;
	}

	public void setExchgChangeFeeCurrCode(final String ExchgChangeFeeCurrCode) {
		this.ExchgChangeFeeCurrCode = ExchgChangeFeeCurrCode;
	}

	public BigDecimal getExchgChangeFeeAmt() {
		return ExchgChangeFeeAmt;
	}

	public void setExchgChangeFeeAmt(final BigDecimal ExchgChangeFeeAmt) {
		this.ExchgChangeFeeAmt = ExchgChangeFeeAmt;
	}

	public String getOtherFeeCurrCode() {
		return OtherFeeCurrCode;
	}

	public void setOtherFeeCurrCode(final String OtherFeeCurrCode) {
		this.OtherFeeCurrCode = OtherFeeCurrCode;
	}

	public BigDecimal getOtherFeeAmt() {
		return OtherFeeAmt;
	}

	public void setOtherFeeAmt(final BigDecimal OtherFeeAmt) {
		this.OtherFeeAmt = OtherFeeAmt;
	}

	public String getAddCollectCurrCode() {
		return AddCollectCurrCode;
	}

	public void setAddCollectCurrCode(final String AddCollectCurrCode) {
		this.AddCollectCurrCode = AddCollectCurrCode;
	}

	public BigDecimal getAddCollectAmt() {
		return AddCollectAmt;
	}

	public void setAddCollectAmt(final BigDecimal AddCollectAmt) {
		this.AddCollectAmt = AddCollectAmt;
	}

	public String getOACDefaultPartitionCode() {
		return OACDefaultPartitionCode;
	}

	public void setOACDefaultPartitionCode(final String OACDefaultPartitionCode) {
		this.OACDefaultPartitionCode = OACDefaultPartitionCode;
	}

	public String getOACCityCode() {
		return OACCityCode;
	}

	public void setOACCityCode(final String OACCityCode) {
		this.OACCityCode = OACCityCode;
	}

	public String getOACAcctCode() {
		return OACAcctCode;
	}

	public void setOACAcctCode(final String OACAcctCode) {
		this.OACAcctCode = OACAcctCode;
	}

	public String getNonRefFeeCurrCode() {
		return NonRefFeeCurrCode;
	}

	public void setNonRefFeeCurrCode(final String NonRefFeeCurrCode) {
		this.NonRefFeeCurrCode = NonRefFeeCurrCode;
	}

	public BigDecimal getNonRefFeeAmt() {
		return NonRefFeeAmt;
	}

	public void setNonRefFeeAmt(final BigDecimal NonRefFeeAmt) {
		this.NonRefFeeAmt = NonRefFeeAmt;
	}

	public String getOBFeeDescText() {
		return OBFeeDescText;
	}

	public void setOBFeeDescText(final String OBFeeDescText) {
		this.OBFeeDescText = OBFeeDescText;
	}

	public String getOBFeePricingCode() {
		return OBFeePricingCode;
	}

	public void setOBFeePricingCode(final String OBFeePricingCode) {
		this.OBFeePricingCode = OBFeePricingCode;
	}

	public String getOBFeeWaiverCode() {
		return OBFeeWaiverCode;
	}

	public void setOBFeeWaiverCode(final String OBFeeWaiverCode) {
		this.OBFeeWaiverCode = OBFeeWaiverCode;
	}

	public String getOBFeeTotalCurrCode() {
		return OBFeeTotalCurrCode;
	}

	public void setOBFeeTotalCurrCode(final String OBFeeTotalCurrCode) {
		this.OBFeeTotalCurrCode = OBFeeTotalCurrCode;
	}

	public BigDecimal getOBFeeTotal() {
		return OBFeeTotal;
	}

	public void setOBFeeTotal(final BigDecimal OBFeeTotal) {
		this.OBFeeTotal = OBFeeTotal;
	}

	public BigDecimal getOBFeeTotalUSD() {
		return OBFeeTotalUSD;
	}

	public void setOBFeeTotalUSD(final BigDecimal OBFeeTotalUSD) {
		this.OBFeeTotalUSD = OBFeeTotalUSD;
	}

	public String getPricedPassengerType() {
		return PricedPassengerType;
	}

	public void setPricedPassengerType(final String PricedPassengerType) {
		this.PricedPassengerType = PricedPassengerType;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((AddlExchgTktData == null) ? 0 : AddlExchgTktData.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        TktDocument other = (TktDocument) obj;
        if (AddlExchgTktData == null) {
            if (other.AddlExchgTktData != null) {
                return false;
            }
        } else if (!AddlExchgTktData.equals(other.AddlExchgTktData)) {
            return false;
        }
        return true;
    }
	
}