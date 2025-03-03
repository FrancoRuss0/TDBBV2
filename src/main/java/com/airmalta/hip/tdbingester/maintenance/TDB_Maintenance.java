package com.airmalta.hip.tdbingester.maintenance;

import java.sql.Timestamp;

public class TDB_Maintenance {

	private String runId;
	private String fileName;
	private Integer numRecords;
	private Boolean success;
	private String encFileName;
	private Timestamp dateStarted;
	private Timestamp dateEnded;
	
	public String getRunId() {
		return runId;
	}
	public void setRunId(String runId) {
		this.runId = runId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Integer getNumRecords() {
		return numRecords;
	}
	public void setNumRecords(Integer numRecords) {
		this.numRecords = numRecords;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getEncFileName() {
		return encFileName;
	}
	public void setEncFileName(String encFileName) {
		this.encFileName = encFileName;
	}
	public Timestamp getDateStarted() {
		return dateStarted;
	}
	public void setDateStarted(Timestamp dateStarted) {
		this.dateStarted = dateStarted;
	}
	public Timestamp getDateEnded() {
		return dateEnded;
	}
	public void setDateEnded(Timestamp dateEnded) {
		this.dateEnded = dateEnded;
	}
	
	@Override
	public String toString() {
		return "TDB_Maintenance [runId=" + runId + ", fileName=" + fileName + ", numRecords=" + numRecords
				+ ", success=" + success + ", encFileName=" + encFileName + ", dateStarted=" + dateStarted
				+ ", dateEnded=" + dateEnded + "]";
	}
	
	
}
