package com.airmalta.hip.tdbingester.filepojos;

import java.sql.Date;
import java.sql.Time;


public class ResFlight extends PNRRecord {
	
	private String ID;
	private Short SegmentNbr;
	private String ActiveSegmentInd;
	private String CdshrLegInd;
	private String ClassOfService;
	private String ConnectivityCode;
	private Short NbrInParty;
	private String CurrentSegmentStatusCode;
	private String PreviousSegmentStatusCode;
	private Short SegmentTypeCode;
	private String ChangeSegmentStatusIndicator;
	private Short EquipmentCode;
	private String MarketingFlightNbr;
	private String FlightNbr;
	private String MarketingAirlineCode;
	private String OperatingFlightNbr;
	private String OperatingAirlineCode;
	private String AirlineCode;
	private String InboundFlightConnectionInd;
	private String MarriedConxInboundFlightInd;
	private String OutboundFlightConnectionInd;
	private String MarriedConxOutboundFlightInd;
	private String ServiceStartCity;
	private Date ServiceStartDate;
	private Time ServiceStartTime;
	private String ServiceEndCity;
	private Date ServiceEndDate;
	private Time ServiceEndTime;
	private String POSAgencyActualCityCode;
	private String EquipmentCodeDescription;
	private String PreReservedSeatIndicator;
	private String ConfirmationNbr;
	private String FlightPOSAgentIATANbr;
	private String HistoryActionCodeId;
	private Date RecordUpdateDate;
	private Time RecordUpdateTime;
	private Short IntraPNRSetNbr;
	private Date SegmentBookedDate;
	private Time SegmentBookedTime;
	private Short OpenFlightSegmentIndicator;
	private String SegmentActivityCode;
	private String BSGMSTRPNRLocatorID;
	private Date BSGMSTRPNRCreateDate;
	private Short NewMarriedConxGroupNbr;
	private Short NewMarriedConxSeqNbr;
	private String NewMarriedConxOutOfSeqInd;
	private String MarketingClassOfService;
	private String OperatingClassOfService;
	private String IATAEquipCode;
	private String IATAEquipDesc;
	private String OperatingAirlnLocatorID;

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

	public String getActiveSegmentInd() {
		return ActiveSegmentInd;
	}

	public void setActiveSegmentInd(final String ActiveSegmentInd) {
		this.ActiveSegmentInd = ActiveSegmentInd;
	}

	public String getCdshrLegInd() {
		return CdshrLegInd;
	}

	public void setCdshrLegInd(final String CdshrLegInd) {
		this.CdshrLegInd = CdshrLegInd;
	}

	public String getClassOfService() {
		return ClassOfService;
	}

	public void setClassOfService(final String ClassOfService) {
		this.ClassOfService = ClassOfService;
	}

	public String getConnectivityCode() {
		return ConnectivityCode;
	}

	public void setConnectivityCode(final String ConnectivityCode) {
		this.ConnectivityCode = ConnectivityCode;
	}

	public Short getNbrInParty() {
		return NbrInParty;
	}

	public void setNbrInParty(final Short NbrInParty) {
		this.NbrInParty = NbrInParty;
	}

	public String getCurrentSegmentStatusCode() {
		return CurrentSegmentStatusCode;
	}

	public void setCurrentSegmentStatusCode(final String CurrentSegmentStatusCode) {
		this.CurrentSegmentStatusCode = CurrentSegmentStatusCode;
	}

	public String getPreviousSegmentStatusCode() {
		return PreviousSegmentStatusCode;
	}

	public void setPreviousSegmentStatusCode(final String PreviousSegmentStatusCode) {
		this.PreviousSegmentStatusCode = PreviousSegmentStatusCode;
	}

	public Short getSegmentTypeCode() {
		return SegmentTypeCode;
	}

	public void setSegmentTypeCode(final Short SegmentTypeCode) {
		this.SegmentTypeCode = SegmentTypeCode;
	}

	public String getChangeSegmentStatusIndicator() {
		return ChangeSegmentStatusIndicator;
	}

	public void setChangeSegmentStatusIndicator(final String ChangeSegmentStatusIndicator) {
		this.ChangeSegmentStatusIndicator = ChangeSegmentStatusIndicator;
	}

	public Short getEquipmentCode() {
		return EquipmentCode;
	}

	public void setEquipmentCode(final Short EquipmentCode) {
		this.EquipmentCode = EquipmentCode;
	}

	public String getMarketingFlightNbr() {
		return MarketingFlightNbr;
	}

	public void setMarketingFlightNbr(final String MarketingFlightNbr) {
		this.MarketingFlightNbr = MarketingFlightNbr;
	}

	public String getFlightNbr() {
		return FlightNbr;
	}

	public void setFlightNbr(final String FlightNbr) {
		this.FlightNbr = FlightNbr;
	}

	public String getMarketingAirlineCode() {
		return MarketingAirlineCode;
	}

	public void setMarketingAirlineCode(final String MarketingAirlineCode) {
		this.MarketingAirlineCode = MarketingAirlineCode;
	}

	public String getOperatingFlightNbr() {
		return OperatingFlightNbr;
	}

	public void setOperatingFlightNbr(final String OperatingFlightNbr) {
		this.OperatingFlightNbr = OperatingFlightNbr;
	}

	public String getOperatingAirlineCode() {
		return OperatingAirlineCode;
	}

	public void setOperatingAirlineCode(final String OperatingAirlineCode) {
		this.OperatingAirlineCode = OperatingAirlineCode;
	}

	public String getAirlineCode() {
		return AirlineCode;
	}

	public void setAirlineCode(final String AirlineCode) {
		this.AirlineCode = AirlineCode;
	}

	public String getInboundFlightConnectionInd() {
		return InboundFlightConnectionInd;
	}

	public void setInboundFlightConnectionInd(final String InboundFlightConnectionInd) {
		this.InboundFlightConnectionInd = InboundFlightConnectionInd;
	}

	public String getMarriedConxInboundFlightInd() {
		return MarriedConxInboundFlightInd;
	}

	public void setMarriedConxInboundFlightInd(final String MarriedConxInboundFlightInd) {
		this.MarriedConxInboundFlightInd = MarriedConxInboundFlightInd;
	}

	public String getOutboundFlightConnectionInd() {
		return OutboundFlightConnectionInd;
	}

	public void setOutboundFlightConnectionInd(final String OutboundFlightConnectionInd) {
		this.OutboundFlightConnectionInd = OutboundFlightConnectionInd;
	}

	public String getMarriedConxOutboundFlightInd() {
		return MarriedConxOutboundFlightInd;
	}

	public void setMarriedConxOutboundFlightInd(final String MarriedConxOutboundFlightInd) {
		this.MarriedConxOutboundFlightInd = MarriedConxOutboundFlightInd;
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

	public String getServiceEndCity() {
		return ServiceEndCity;
	}

	public void setServiceEndCity(final String ServiceEndCity) {
		this.ServiceEndCity = ServiceEndCity;
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

	public String getPOSAgencyActualCityCode() {
		return POSAgencyActualCityCode;
	}

	public void setPOSAgencyActualCityCode(final String POSAgencyActualCityCode) {
		this.POSAgencyActualCityCode = POSAgencyActualCityCode;
	}

	public String getEquipmentCodeDescription() {
		return EquipmentCodeDescription;
	}

	public void setEquipmentCodeDescription(final String EquipmentCodeDescription) {
		this.EquipmentCodeDescription = EquipmentCodeDescription;
	}

	public String getPreReservedSeatIndicator() {
		return PreReservedSeatIndicator;
	}

	public void setPreReservedSeatIndicator(final String PreReservedSeatIndicator) {
		this.PreReservedSeatIndicator = PreReservedSeatIndicator;
	}

	public String getConfirmationNbr() {
		return ConfirmationNbr;
	}

	public void setConfirmationNbr(final String ConfirmationNbr) {
		this.ConfirmationNbr = ConfirmationNbr;
	}

	public String getFlightPOSAgentIATANbr() {
		return FlightPOSAgentIATANbr;
	}

	public void setFlightPOSAgentIATANbr(final String FlightPOSAgentIATANbr) {
		this.FlightPOSAgentIATANbr = FlightPOSAgentIATANbr;
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

	public Short getOpenFlightSegmentIndicator() {
		return OpenFlightSegmentIndicator;
	}

	public void setOpenFlightSegmentIndicator(final Short OpenFlightSegmentIndicator) {
		this.OpenFlightSegmentIndicator = OpenFlightSegmentIndicator;
	}

	public String getSegmentActivityCode() {
		return SegmentActivityCode;
	}

	public void setSegmentActivityCode(final String SegmentActivityCode) {
		this.SegmentActivityCode = SegmentActivityCode;
	}

	public String getBSGMSTRPNRLocatorID() {
		return BSGMSTRPNRLocatorID;
	}

	public void setBSGMSTRPNRLocatorID(final String BSGMSTRPNRLocatorID) {
		this.BSGMSTRPNRLocatorID = BSGMSTRPNRLocatorID;
	}

	public Date getBSGMSTRPNRCreateDate() {
		return BSGMSTRPNRCreateDate;
	}

	public void setBSGMSTRPNRCreateDate(final Date BSGMSTRPNRCreateDate) {
		this.BSGMSTRPNRCreateDate = BSGMSTRPNRCreateDate;
	}

	public Short getNewMarriedConxGroupNbr() {
		return NewMarriedConxGroupNbr;
	}

	public void setNewMarriedConxGroupNbr(final Short NewMarriedConxGroupNbr) {
		this.NewMarriedConxGroupNbr = NewMarriedConxGroupNbr;
	}

	public Short getNewMarriedConxSeqNbr() {
		return NewMarriedConxSeqNbr;
	}

	public void setNewMarriedConxSeqNbr(final Short NewMarriedConxSeqNbr) {
		this.NewMarriedConxSeqNbr = NewMarriedConxSeqNbr;
	}

	public String getNewMarriedConxOutOfSeqInd() {
		return NewMarriedConxOutOfSeqInd;
	}

	public void setNewMarriedConxOutOfSeqInd(final String NewMarriedConxOutOfSeqInd) {
		this.NewMarriedConxOutOfSeqInd = NewMarriedConxOutOfSeqInd;
	}

	public String getMarketingClassOfService() {
		return MarketingClassOfService;
	}

	public void setMarketingClassOfService(final String MarketingClassOfService) {
		this.MarketingClassOfService = MarketingClassOfService;
	}

	public String getOperatingClassOfService() {
		return OperatingClassOfService;
	}

	public void setOperatingClassOfService(final String OperatingClassOfService) {
		this.OperatingClassOfService = OperatingClassOfService;
	}

	public String getIATAEquipCode() {
		return IATAEquipCode;
	}

	public void setIATAEquipCode(final String IATAEquipCode) {
		this.IATAEquipCode = IATAEquipCode;
	}

	public String getIATAEquipDesc() {
		return IATAEquipDesc;
	}

	public void setIATAEquipDesc(final String IATAEquipDesc) {
		this.IATAEquipDesc = IATAEquipDesc;
	}

	public String getOperatingAirlnLocatorID() {
		return OperatingAirlnLocatorID;
	}

	public void setOperatingAirlnLocatorID(final String OperatingAirlnLocatorID) {
		this.OperatingAirlnLocatorID = OperatingAirlnLocatorID;
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
		ResFlight other = (ResFlight) obj;
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