package com.airmalta.hip.tdbingester.filepojos;

import java.sql.Date;
import java.sql.Time;


public class ResSuspDocAgmt extends PNRRecord {

	private String ID;
	private Short PNRPassengerSeqID;
	private Short ResArrSequenceId;
	private Date ResArrQueuePlaceDate;
	private String ResArrQueueName;
	private String ResArrangementLocationCode;
	private String ArrPassengerReferenceName;
	private Date ArrActivityDate;
	private Time ArrActivityTime;
	private String ArrDutyCode;
	private String ArrSine;
	private String SSRText;
	private String SSRCode;
	private String SourceTypeCode;
	private String SSRIdTypeCode;
	private String ResArrActionCode;
	private String ServiceStartCityCode;
	private String ServiceEndCityCode;
	private String TicketNbr;
	private Short SSRNbrInParty;
	private Date SSRStartDate;
	private String SSRFlightNumber;
	private String ClassOfService;
	private String VendorCode;
	private String SSRStatusCode;
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

	public Short getPNRPassengerSeqID() {
		return PNRPassengerSeqID;
	}

	public void setPNRPassengerSeqID(final Short PNRPassengerSeqID) {
		this.PNRPassengerSeqID = PNRPassengerSeqID;
	}

	public Short getResArrSequenceId() {
		return ResArrSequenceId;
	}

	public void setResArrSequenceId(final Short ResArrSequenceId) {
		this.ResArrSequenceId = ResArrSequenceId;
	}

	public Date getResArrQueuePlaceDate() {
		return ResArrQueuePlaceDate;
	}

	public void setResArrQueuePlaceDate(final Date ResArrQueuePlaceDate) {
		this.ResArrQueuePlaceDate = ResArrQueuePlaceDate;
	}

	public String getResArrQueueName() {
		return ResArrQueueName;
	}

	public void setResArrQueueName(final String ResArrQueueName) {
		this.ResArrQueueName = ResArrQueueName;
	}

	public String getResArrangementLocationCode() {
		return ResArrangementLocationCode;
	}

	public void setResArrangementLocationCode(final String ResArrangementLocationCode) {
		this.ResArrangementLocationCode = ResArrangementLocationCode;
	}

	public String getArrPassengerReferenceName() {
		return ArrPassengerReferenceName;
	}

	public void setArrPassengerReferenceName(final String ArrPassengerReferenceName) {
		this.ArrPassengerReferenceName = ArrPassengerReferenceName;
	}

	public Date getArrActivityDate() {
		return ArrActivityDate;
	}

	public void setArrActivityDate(final Date ArrActivityDate) {
		this.ArrActivityDate = ArrActivityDate;
	}

	public Time getArrActivityTime() {
		return ArrActivityTime;
	}

	public void setArrActivityTime(final Time ArrActivityTime) {
		this.ArrActivityTime = ArrActivityTime;
	}

	public String getArrDutyCode() {
		return ArrDutyCode;
	}

	public void setArrDutyCode(final String ArrDutyCode) {
		this.ArrDutyCode = ArrDutyCode;
	}

	public String getArrSine() {
		return ArrSine;
	}

	public void setArrSine(final String ArrSine) {
		this.ArrSine = ArrSine;
	}

	public String getSSRText() {
		return SSRText;
	}

	public void setSSRText(final String SSRText) {
		this.SSRText = SSRText;
	}

	public String getSSRCode() {
		return SSRCode;
	}

	public void setSSRCode(final String SSRCode) {
		this.SSRCode = SSRCode;
	}

	public String getSourceTypeCode() {
		return SourceTypeCode;
	}

	public void setSourceTypeCode(final String SourceTypeCode) {
		this.SourceTypeCode = SourceTypeCode;
	}

	public String getSSRIdTypeCode() {
		return SSRIdTypeCode;
	}

	public void setSSRIdTypeCode(final String SSRIdTypeCode) {
		this.SSRIdTypeCode = SSRIdTypeCode;
	}

	public String getResArrActionCode() {
		return ResArrActionCode;
	}

	public void setResArrActionCode(final String ResArrActionCode) {
		this.ResArrActionCode = ResArrActionCode;
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

	public String getTicketNbr() {
		return TicketNbr;
	}

	public void setTicketNbr(final String TicketNbr) {
		this.TicketNbr = TicketNbr;
	}

	public Short getSSRNbrInParty() {
		return SSRNbrInParty;
	}

	public void setSSRNbrInParty(final Short SSRNbrInParty) {
		this.SSRNbrInParty = SSRNbrInParty;
	}

	public Date getSSRStartDate() {
		return SSRStartDate;
	}

	public void setSSRStartDate(final Date SSRStartDate) {
		this.SSRStartDate = SSRStartDate;
	}

	public String getSSRFlightNumber() {
		return SSRFlightNumber;
	}

	public void setSSRFlightNumber(final String SSRFlightNumber) {
		this.SSRFlightNumber = SSRFlightNumber;
	}

	public String getClassOfService() {
		return ClassOfService;
	}

	public void setClassOfService(final String ClassOfService) {
		this.ClassOfService = ClassOfService;
	}

	public String getVendorCode() {
		return VendorCode;
	}

	public void setVendorCode(final String VendorCode) {
		this.VendorCode = VendorCode;
	}

	public String getSSRStatusCode() {
		return SSRStatusCode;
	}

	public void setSSRStatusCode(final String SSRStatusCode) {
		this.SSRStatusCode = SSRStatusCode;
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
		result = prime * result + ((PNRPassengerSeqID == null) ? 0 : PNRPassengerSeqID.hashCode());
		result = prime * result + ((ResArrSequenceId == null) ? 0 : ResArrSequenceId.hashCode());
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
		ResSuspDocAgmt other = (ResSuspDocAgmt) obj;
		if (IntraPNRSetNbr == null) {
			if (other.IntraPNRSetNbr != null)
				return false;
		} else if (!IntraPNRSetNbr.equals(other.IntraPNRSetNbr))
			return false;
		if (PNRPassengerSeqID == null) {
			if (other.PNRPassengerSeqID != null)
				return false;
		} else if (!PNRPassengerSeqID.equals(other.PNRPassengerSeqID))
			return false;
		if (ResArrSequenceId == null) {
			if (other.ResArrSequenceId != null)
				return false;
		} else if (!ResArrSequenceId.equals(other.ResArrSequenceId))
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