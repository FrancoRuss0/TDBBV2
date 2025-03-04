package com.kmmaltairlines.hip.tdbingester.filepojos;

import java.sql.Date;
import java.sql.Time;

public class ResTravelArranger extends PNRRecord {

	private String ID;
	private String SignatureType;
	private String UpdateAAACityCode;
	private String UpdateAgentDutyCode;
	private String UpdateAgentSine;
	private String UpdateBookingCRSCode;
	private String UpdateHomeCityCode;
	private Date RecordUpdateDate;
	private Time RecordUpdateTime;
	private Short IntraPNRSetNbr;
	private String ReceivedFrom;
	private String UpdateAAAOACCityCode;
	private String UpdateAAAOACAcctCode;
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

	public String getSignatureType() {
		return SignatureType;
	}

	public void setSignatureType(final String SignatureType) {
		this.SignatureType = SignatureType;
	}

	public String getUpdateAAACityCode() {
		return UpdateAAACityCode;
	}

	public void setUpdateAAACityCode(final String UpdateAAACityCode) {
		this.UpdateAAACityCode = UpdateAAACityCode;
	}

	public String getUpdateAgentDutyCode() {
		return UpdateAgentDutyCode;
	}

	public void setUpdateAgentDutyCode(final String UpdateAgentDutyCode) {
		this.UpdateAgentDutyCode = UpdateAgentDutyCode;
	}

	public String getUpdateAgentSine() {
		return UpdateAgentSine;
	}

	public void setUpdateAgentSine(final String UpdateAgentSine) {
		this.UpdateAgentSine = UpdateAgentSine;
	}

	public String getUpdateBookingCRSCode() {
		return UpdateBookingCRSCode;
	}

	public void setUpdateBookingCRSCode(final String UpdateBookingCRSCode) {
		this.UpdateBookingCRSCode = UpdateBookingCRSCode;
	}

	public String getUpdateHomeCityCode() {
		return UpdateHomeCityCode;
	}

	public void setUpdateHomeCityCode(final String UpdateHomeCityCode) {
		this.UpdateHomeCityCode = UpdateHomeCityCode;
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

	public String getReceivedFrom() {
		return ReceivedFrom;
	}

	public void setReceivedFrom(final String ReceivedFrom) {
		this.ReceivedFrom = ReceivedFrom;
	}

	public String getUpdateAAAOACCityCode() {
		return UpdateAAAOACCityCode;
	}

	public void setUpdateAAAOACCityCode(final String UpdateAAAOACCityCode) {
		this.UpdateAAAOACCityCode = UpdateAAAOACCityCode;
	}

	public String getUpdateAAAOACAcctCode() {
		return UpdateAAAOACAcctCode;
	}

	public void setUpdateAAAOACAcctCode(final String UpdateAAAOACAcctCode) {
		this.UpdateAAAOACAcctCode = UpdateAAAOACAcctCode;
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
		result = prime * result + ((IntraPNRSetNbr == null) ? 0 : IntraPNRSetNbr.hashCode());
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
		ResTravelArranger other = (ResTravelArranger) obj;
		if (IntraPNRSetNbr == null) {
			if (other.IntraPNRSetNbr != null)
				return false;
		} else if (!IntraPNRSetNbr.equals(other.IntraPNRSetNbr))
			return false;
		return true;
	}

}