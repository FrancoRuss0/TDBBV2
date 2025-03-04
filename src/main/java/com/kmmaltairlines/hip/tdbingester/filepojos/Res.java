package com.kmmaltairlines.hip.tdbingester.filepojos;

import java.sql.Date;
import java.sql.Time;

public class Res extends PNRRecord {

	private String ID;
	private String CreateAAACityCode;
	private String CreationCountryCode;
	private String GrpBookingInd;
	private String CorporateInd;
	private Short NbrinParty;
	private String TTYAirlineCode;
	private String TTYRecordLocator;
	private String TTYPosInformation;
	private Short SeatCount;
	private String SourceSystemId;
	private Time PNRCreateTime;
	private String CreateAgentSine;
	private Short NumberOfInfants;
	private String ClaimIndicator;
	private String CreateIATANr;
	private Date PurgeDate;
	private Short MaxIntraPNRSetNbr;
	private String DivideOrigPNRLocatorID;
	private Date OrigPNRCreateDate;
	private Time OrigPNRCreateTime;
	private String DivideImagePNRInd;
	private String CreateAAAOACCityCode;
	private String CreateAAAOACAcctCode;
	private String OACDefaultPartitionCode;
	private String OACCityCode;
	private String OACAcctCode;
	private String OACStationNbr;
	private String CreateHomeCityCode;
	private String CodeSharePNRInd;
	private String MCPCarrierInd;

	public String getID() {
		return ID;
	}

	public void setID(final String ID) {
		this.ID = ID;
	}

	public String getCreateAAACityCode() {
		return CreateAAACityCode;
	}

	public void setCreateAAACityCode(final String CreateAAACityCode) {
		this.CreateAAACityCode = CreateAAACityCode;
	}

	public String getCreationCountryCode() {
		return CreationCountryCode;
	}

	public void setCreationCountryCode(final String CreationCountryCode) {
		this.CreationCountryCode = CreationCountryCode;
	}

	public String getGrpBookingInd() {
		return GrpBookingInd;
	}

	public void setGrpBookingInd(final String GrpBookingInd) {
		this.GrpBookingInd = GrpBookingInd;
	}

	public String getCorporateInd() {
		return CorporateInd;
	}

	public void setCorporateInd(final String CorporateInd) {
		this.CorporateInd = CorporateInd;
	}

	public Short getNbrinParty() {
		return NbrinParty;
	}

	public void setNbrinParty(final Short NbrinParty) {
		this.NbrinParty = NbrinParty;
	}

	public String getTTYAirlineCode() {
		return TTYAirlineCode;
	}

	public void setTTYAirlineCode(final String TTYAirlineCode) {
		this.TTYAirlineCode = TTYAirlineCode;
	}

	public String getTTYRecordLocator() {
		return TTYRecordLocator;
	}

	public void setTTYRecordLocator(final String TTYRecordLocator) {
		this.TTYRecordLocator = TTYRecordLocator;
	}

	public String getTTYPosInformation() {
		return TTYPosInformation;
	}

	public void setTTYPosInformation(final String TTYPosInformation) {
		this.TTYPosInformation = TTYPosInformation;
	}

	public Short getSeatCount() {
		return SeatCount;
	}

	public void setSeatCount(final Short SeatCount) {
		this.SeatCount = SeatCount;
	}

	public String getSourceSystemId() {
		return SourceSystemId;
	}

	public void setSourceSystemId(final String SourceSystemId) {
		this.SourceSystemId = SourceSystemId;
	}

	public Time getPNRCreateTime() {
		return PNRCreateTime;
	}

	public void setPNRCreateTime(final Time PNRCreateTime) {
		this.PNRCreateTime = PNRCreateTime;
	}

	public String getCreateAgentSine() {
		return CreateAgentSine;
	}

	public void setCreateAgentSine(final String CreateAgentSine) {
		this.CreateAgentSine = CreateAgentSine;
	}

	public Short getNumberOfInfants() {
		return NumberOfInfants;
	}

	public void setNumberOfInfants(final Short NumberOfInfants) {
		this.NumberOfInfants = NumberOfInfants;
	}

	public String getClaimIndicator() {
		return ClaimIndicator;
	}

	public void setClaimIndicator(final String ClaimIndicator) {
		this.ClaimIndicator = ClaimIndicator;
	}

	public String getCreateIATANr() {
		return CreateIATANr;
	}

	public void setCreateIATANr(final String CreateIATANr) {
		this.CreateIATANr = CreateIATANr;
	}

	public Date getPurgeDate() {
		return PurgeDate;
	}

	public void setPurgeDate(final Date PurgeDate) {
		this.PurgeDate = PurgeDate;
	}

	public Short getMaxIntraPNRSetNbr() {
		return MaxIntraPNRSetNbr;
	}

	public void setMaxIntraPNRSetNbr(final Short MaxIntraPNRSetNbr) {
		this.MaxIntraPNRSetNbr = MaxIntraPNRSetNbr;
	}

	public String getDivideOrigPNRLocatorID() {
		return DivideOrigPNRLocatorID;
	}

	public void setDivideOrigPNRLocatorID(final String DivideOrigPNRLocatorID) {
		this.DivideOrigPNRLocatorID = DivideOrigPNRLocatorID;
	}

	public Date getOrigPNRCreateDate() {
		return OrigPNRCreateDate;
	}

	public void setOrigPNRCreateDate(final Date OrigPNRCreateDate) {
		this.OrigPNRCreateDate = OrigPNRCreateDate;
	}

	public Time getOrigPNRCreateTime() {
		return OrigPNRCreateTime;
	}

	public void setOrigPNRCreateTime(final Time OrigPNRCreateTime) {
		this.OrigPNRCreateTime = OrigPNRCreateTime;
	}

	public String getDivideImagePNRInd() {
		return DivideImagePNRInd;
	}

	public void setDivideImagePNRInd(final String DivideImagePNRInd) {
		this.DivideImagePNRInd = DivideImagePNRInd;
	}

	public String getCreateAAAOACCityCode() {
		return CreateAAAOACCityCode;
	}

	public void setCreateAAAOACCityCode(final String CreateAAAOACCityCode) {
		this.CreateAAAOACCityCode = CreateAAAOACCityCode;
	}

	public String getCreateAAAOACAcctCode() {
		return CreateAAAOACAcctCode;
	}

	public void setCreateAAAOACAcctCode(final String CreateAAAOACAcctCode) {
		this.CreateAAAOACAcctCode = CreateAAAOACAcctCode;
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

	public String getOACStationNbr() {
		return OACStationNbr;
	}

	public void setOACStationNbr(final String OACStationNbr) {
		this.OACStationNbr = OACStationNbr;
	}

	public String getCreateHomeCityCode() {
		return CreateHomeCityCode;
	}

	public void setCreateHomeCityCode(final String CreateHomeCityCode) {
		this.CreateHomeCityCode = CreateHomeCityCode;
	}

	public String getCodeSharePNRInd() {
		return CodeSharePNRInd;
	}

	public void setCodeSharePNRInd(final String CodeSharePNRInd) {
		this.CodeSharePNRInd = CodeSharePNRInd;
	}

	public String getMCPCarrierInd() {
		return MCPCarrierInd;
	}

	public void setMCPCarrierInd(final String MCPCarrierInd) {
		this.MCPCarrierInd = MCPCarrierInd;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

}