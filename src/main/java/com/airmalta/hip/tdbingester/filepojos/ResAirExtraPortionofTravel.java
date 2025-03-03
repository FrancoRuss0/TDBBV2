package com.airmalta.hip.tdbingester.filepojos;

import java.sql.Date;
import java.sql.Timestamp;

public class ResAirExtraPortionofTravel extends PNRRecord {
	private String ID;
	private Integer IntraPNRSetNbr;
	private Timestamp TransmissionDateTime;
	private Integer UniqueComponentID;
	private Byte AEPortionSeqNbr;
	private Integer PNRPassengerSeqID;
	private String AirlineCode;
	private String FlightNbr;
	private String ClassofService;
	private Date ServiceStartDate;
	private String ServiceStartCity;
	private String ServiceEndCity;
	private String EMDNbr;
	private Short EmdCouponNbr;
	private String ETicketNbr;
	private Short ETicketCpnNbr;
	private Date RecordUpdateDate;
	private Timestamp RecordUpdateDateTime;
	private String MarketingCarrierCode;
	private String OpertatingCarrierCode;
	private String SourceSystemID;

	public String getID() {
		return ID;
	}

	public void setID(final String ID) {
		this.ID = ID;
	}

	public Integer getIntraPNRSetNbr() {
		return IntraPNRSetNbr;
	}

	public void setIntraPNRSetNbr(final Integer IntraPNRSetNbr) {
		this.IntraPNRSetNbr = IntraPNRSetNbr;
	}

	public Timestamp getTransmissionDateTime() {
		return TransmissionDateTime;
	}

	public void setTransmissionDateTime(final Timestamp TransmissionDateTime) {
		this.TransmissionDateTime = TransmissionDateTime;
	}

	public Integer getUniqueComponentID() {
		return UniqueComponentID;
	}

	public void setUniqueComponentID(final Integer UniqueComponentID) {
		this.UniqueComponentID = UniqueComponentID;
	}

	public Byte getAEPortionSeqNbr() {
		return AEPortionSeqNbr;
	}

	public void setAEPortionSeqNbr(final Byte AEPortionSeqNbr) {
		this.AEPortionSeqNbr = AEPortionSeqNbr;
	}

	public Integer getPNRPassengerSeqID() {
		return PNRPassengerSeqID;
	}

	public void setPNRPassengerSeqID(final Integer PNRPassengerSeqID) {
		this.PNRPassengerSeqID = PNRPassengerSeqID;
	}

	public String getAirlineCode() {
		return AirlineCode;
	}

	public void setAirlineCode(final String AirlineCode) {
		this.AirlineCode = AirlineCode;
	}

	public String getFlightNbr() {
		return FlightNbr;
	}

	public void setFlightNbr(final String FlightNbr) {
		this.FlightNbr = FlightNbr;
	}

	public String getClassofService() {
		return ClassofService;
	}

	public void setClassofService(final String ClassofService) {
		this.ClassofService = ClassofService;
	}

	public Date getServiceStartDate() {
		return ServiceStartDate;
	}

	public void setServiceStartDate(final Date ServiceStartDate) {
		this.ServiceStartDate = ServiceStartDate;
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

	public String getEMDNbr() {
		return EMDNbr;
	}

	public void setEMDNbr(final String EMDNbr) {
		this.EMDNbr = EMDNbr;
	}

	public Short getEmdCouponNbr() {
		return EmdCouponNbr;
	}

	public void setEmdCouponNbr(final Short EmdCouponNbr) {
		this.EmdCouponNbr = EmdCouponNbr;
	}

	public String getETicketNbr() {
		return ETicketNbr;
	}

	public void setETicketNbr(final String ETicketNbr) {
		this.ETicketNbr = ETicketNbr;
	}

	public Short getETicketCpnNbr() {
		return ETicketCpnNbr;
	}

	public void setETicketCpnNbr(final Short ETicketCpnNbr) {
		this.ETicketCpnNbr = ETicketCpnNbr;
	}

	public Date getRecordUpdateDate() {
		return RecordUpdateDate;
	}

	public void setRecordUpdateDate(final Date RecordUpdateDate) {
		this.RecordUpdateDate = RecordUpdateDate;
	}

	public Timestamp getRecordUpdateDateTime() {
		return RecordUpdateDateTime;
	}

	public void setRecordUpdateDateTime(final Timestamp RecordUpdateDateTime) {
		this.RecordUpdateDateTime = RecordUpdateDateTime;
	}

	public String getMarketingCarrierCode() {
		return MarketingCarrierCode;
	}

	public void setMarketingCarrierCode(final String MarketingCarrierCode) {
		this.MarketingCarrierCode = MarketingCarrierCode;
	}

	public String getOpertatingCarrierCode() {
		return OpertatingCarrierCode;
	}

	public void setOpertatingCarrierCode(final String OpertatingCarrierCode) {
		this.OpertatingCarrierCode = OpertatingCarrierCode;
	}

	public String getSourceSystemID() {
		return SourceSystemID;
	}

	public void setSourceSystemID(final String SourceSystemID) {
		this.SourceSystemID = SourceSystemID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((AEPortionSeqNbr == null) ? 0 : AEPortionSeqNbr.hashCode());
		result = prime * result + ((IntraPNRSetNbr == null) ? 0 : IntraPNRSetNbr.hashCode());
		result = prime * result + ((UniqueComponentID == null) ? 0 : UniqueComponentID.hashCode());
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
		ResAirExtraPortionofTravel other = (ResAirExtraPortionofTravel) obj;
		if (AEPortionSeqNbr == null) {
			if (other.AEPortionSeqNbr != null)
				return false;
		} else if (!AEPortionSeqNbr.equals(other.AEPortionSeqNbr))
			return false;
		if (IntraPNRSetNbr == null) {
			if (other.IntraPNRSetNbr != null)
				return false;
		} else if (!IntraPNRSetNbr.equals(other.IntraPNRSetNbr))
			return false;
		if (UniqueComponentID == null) {
			if (other.UniqueComponentID != null)
				return false;
		} else if (!UniqueComponentID.equals(other.UniqueComponentID))
			return false;
		return true;
	}

}