package com.airmalta.hip.tdbingester.filepojos;

import java.sql.Date;
import java.sql.Time;


public class ResPassengerFT extends PNRRecord {

	private String ID;
	private Short PNRPassengerFTSeqId;
	private Short PNRPassengerSeqId;
	private String SourceTypeCode;
	private String ClassOfService;
	private String FrequentTravelerNbr;
	private String FTText;
	private String FTCurrentStatusCode;
	private String FTFlightNumber;
	private String ReceivingCarrierCode;
	private String ServiceStartCityCode;
	private String ServiceEndCityCode;
	private String SSRCode;
	private String SSRIdTypeCode;
	private Short SSRNbrInParty;
	private String VendorCode;
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

	public Short getPNRPassengerFTSeqId() {
		return PNRPassengerFTSeqId;
	}

	public void setPNRPassengerFTSeqId(final Short PNRPassengerFTSeqId) {
		this.PNRPassengerFTSeqId = PNRPassengerFTSeqId;
	}

	public Short getPNRPassengerSeqId() {
		return PNRPassengerSeqId;
	}

	public void setPNRPassengerSeqId(final Short PNRPassengerSeqId) {
		this.PNRPassengerSeqId = PNRPassengerSeqId;
	}

	public String getSourceTypeCode() {
		return SourceTypeCode;
	}

	public void setSourceTypeCode(final String SourceTypeCode) {
		this.SourceTypeCode = SourceTypeCode;
	}

	public String getClassOfService() {
		return ClassOfService;
	}

	public void setClassOfService(final String ClassOfService) {
		this.ClassOfService = ClassOfService;
	}

	public String getFrequentTravelerNbr() {
		return FrequentTravelerNbr;
	}

	public void setFrequentTravelerNbr(final String FrequentTravelerNbr) {
		this.FrequentTravelerNbr = FrequentTravelerNbr;
	}

	public String getFTText() {
		return FTText;
	}

	public void setFTText(final String FTText) {
		this.FTText = FTText;
	}

	public String getFTCurrentStatusCode() {
		return FTCurrentStatusCode;
	}

	public void setFTCurrentStatusCode(final String FTCurrentStatusCode) {
		this.FTCurrentStatusCode = FTCurrentStatusCode;
	}

	public String getFTFlightNumber() {
		return FTFlightNumber;
	}

	public void setFTFlightNumber(final String FTFlightNumber) {
		this.FTFlightNumber = FTFlightNumber;
	}

	public String getReceivingCarrierCode() {
		return ReceivingCarrierCode;
	}

	public void setReceivingCarrierCode(final String ReceivingCarrierCode) {
		this.ReceivingCarrierCode = ReceivingCarrierCode;
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

	public String getSSRCode() {
		return SSRCode;
	}

	public void setSSRCode(final String SSRCode) {
		this.SSRCode = SSRCode;
	}

	public String getSSRIdTypeCode() {
		return SSRIdTypeCode;
	}

	public void setSSRIdTypeCode(final String SSRIdTypeCode) {
		this.SSRIdTypeCode = SSRIdTypeCode;
	}

	public Short getSSRNbrInParty() {
		return SSRNbrInParty;
	}

	public void setSSRNbrInParty(final Short SSRNbrInParty) {
		this.SSRNbrInParty = SSRNbrInParty;
	}

	public String getVendorCode() {
		return VendorCode;
	}

	public void setVendorCode(final String VendorCode) {
		this.VendorCode = VendorCode;
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
		result = prime * result + ((PNRPassengerFTSeqId == null) ? 0 : PNRPassengerFTSeqId.hashCode());
		result = prime * result + ((SSRIdTypeCode == null) ? 0 : SSRIdTypeCode.hashCode());
		result = prime * result + ((SourceTypeCode == null) ? 0 : SourceTypeCode.hashCode());
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
		ResPassengerFT other = (ResPassengerFT) obj;
		if (IntraPNRSetNbr == null) {
			if (other.IntraPNRSetNbr != null)
				return false;
		} else if (!IntraPNRSetNbr.equals(other.IntraPNRSetNbr))
			return false;
		if (PNRPassengerFTSeqId == null) {
			if (other.PNRPassengerFTSeqId != null)
				return false;
		} else if (!PNRPassengerFTSeqId.equals(other.PNRPassengerFTSeqId))
			return false;
		if (SSRIdTypeCode == null) {
			if (other.SSRIdTypeCode != null)
				return false;
		} else if (!SSRIdTypeCode.equals(other.SSRIdTypeCode))
			return false;
		if (SourceTypeCode == null) {
			if (other.SourceTypeCode != null)
				return false;
		} else if (!SourceTypeCode.equals(other.SourceTypeCode))
			return false;
		return true;
	}

}