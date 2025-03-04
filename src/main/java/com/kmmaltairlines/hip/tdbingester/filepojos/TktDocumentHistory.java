package com.kmmaltairlines.hip.tdbingester.filepojos;

import java.sql.Date;
import java.sql.Time;

public class TktDocumentHistory extends VCRRecord {

	private String ID;
	private String PNRLocatorID;
	private Date PNRCreateDate;
	private Integer HistorySeqNbr;
	private String HistoryCd;
	private String AAACityCode;
	private String HomeCityCode;
	private String AgentDutyCode;
	private String AgentSine;
	private Date LastUpdate;
	private Time LastUpdateSysTime;
	private String PreviousPNRLocatorId;
	private String CPNBitMap;
	private String NewPNRLocatorID;
	private String AirlineAccountingCode;
	private String DocNbr;
	private String UpdateCRSCode;
	private String UpdateAirlineCode;
	private Byte PurgeDueToAging;
	private Byte PurgeRequestByTCN;
	private Byte Day7Purge;
	private String InputMsg;
	private String RemarkTxt;
	private String OACDefaultPartitionCode;
	private String OACCityCode;
	private String OACAcctCode;
	private String OACStationNbr;

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

	public Integer getHistorySeqNbr() {
		return HistorySeqNbr;
	}

	public void setHistorySeqNbr(final Integer HistorySeqNbr) {
		this.HistorySeqNbr = HistorySeqNbr;
	}

	public String getHistoryCd() {
		return HistoryCd;
	}

	public void setHistoryCd(final String HistoryCd) {
		this.HistoryCd = HistoryCd;
	}

	public String getAAACityCode() {
		return AAACityCode;
	}

	public void setAAACityCode(final String AAACityCode) {
		this.AAACityCode = AAACityCode;
	}

	public String getHomeCityCode() {
		return HomeCityCode;
	}

	public void setHomeCityCode(final String HomeCityCode) {
		this.HomeCityCode = HomeCityCode;
	}

	public String getAgentDutyCode() {
		return AgentDutyCode;
	}

	public void setAgentDutyCode(final String AgentDutyCode) {
		this.AgentDutyCode = AgentDutyCode;
	}

	public String getAgentSine() {
		return AgentSine;
	}

	public void setAgentSine(final String AgentSine) {
		this.AgentSine = AgentSine;
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

	public String getPreviousPNRLocatorId() {
		return PreviousPNRLocatorId;
	}

	public void setPreviousPNRLocatorId(final String PreviousPNRLocatorId) {
		this.PreviousPNRLocatorId = PreviousPNRLocatorId;
	}

	public String getCPNBitMap() {
		return CPNBitMap;
	}

	public void setCPNBitMap(final String CPNBitMap) {
		this.CPNBitMap = CPNBitMap;
	}

	public String getNewPNRLocatorID() {
		return NewPNRLocatorID;
	}

	public void setNewPNRLocatorID(final String NewPNRLocatorID) {
		this.NewPNRLocatorID = NewPNRLocatorID;
	}

	public String getAirlineAccountingCode() {
		return AirlineAccountingCode;
	}

	public void setAirlineAccountingCode(final String AirlineAccountingCode) {
		this.AirlineAccountingCode = AirlineAccountingCode;
	}

	public String getDocNbr() {
		return DocNbr;
	}

	public void setDocNbr(final String DocNbr) {
		this.DocNbr = DocNbr;
	}

	public String getUpdateCRSCode() {
		return UpdateCRSCode;
	}

	public void setUpdateCRSCode(final String UpdateCRSCode) {
		this.UpdateCRSCode = UpdateCRSCode;
	}

	public String getUpdateAirlineCode() {
		return UpdateAirlineCode;
	}

	public void setUpdateAirlineCode(final String UpdateAirlineCode) {
		this.UpdateAirlineCode = UpdateAirlineCode;
	}

	public Byte getPurgeDueToAging() {
		return PurgeDueToAging;
	}

	public void setPurgeDueToAging(final Byte PurgeDueToAging) {
		this.PurgeDueToAging = PurgeDueToAging;
	}

	public Byte getPurgeRequestByTCN() {
		return PurgeRequestByTCN;
	}

	public void setPurgeRequestByTCN(final Byte PurgeRequestByTCN) {
		this.PurgeRequestByTCN = PurgeRequestByTCN;
	}

	public Byte getDay7Purge() {
		return Day7Purge;
	}

	public void setDay7Purge(final Byte Day7Purge) {
		this.Day7Purge = Day7Purge;
	}

	public String getInputMsg() {
		return InputMsg;
	}

	public void setInputMsg(final String InputMsg) {
		this.InputMsg = InputMsg;
	}

	public String getRemarkTxt() {
		return RemarkTxt;
	}

	public void setRemarkTxt(final String RemarkTxt) {
		this.RemarkTxt = RemarkTxt;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		TktDocumentHistory other = (TktDocumentHistory) obj;
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