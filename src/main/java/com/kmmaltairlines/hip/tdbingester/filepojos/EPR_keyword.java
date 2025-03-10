package com.kmmaltairlines.hip.tdbingester.filepojos;

import java.sql.Date;

public class EPR_Keyword {
	private String PCC_Cd;
	private String User_Id;
	private String Keyword;
	private String RecordStatus;
	private Date EffectiveDate;

	public String getPCC_Cd() {
		return PCC_Cd;
	}

	public void setPCC_Cd(final String PCC_Cd) {
		this.PCC_Cd = PCC_Cd;
	}

	public String getUser_Id() {
		return User_Id;
	}

	public void setUser_Id(final String User_Id) {
		this.User_Id = User_Id;
	}

	public String getKeyword() {
		return Keyword;
	}

	public void setKeyword(final String Keyword) {
		this.Keyword = Keyword;
	}

	public String getRecordStatus() {
		return RecordStatus;
	}

	public void setRecordStatus(final String RecordStatus) {
		this.RecordStatus = RecordStatus;
	}

	public Date getEffectiveDate() {
		return EffectiveDate;
	}

	public void setEffectiveDate(final Date EffectiveDate) {
		this.EffectiveDate = EffectiveDate;
	}

}