package com.airmalta.hip.tdbingester.filepojos;

import java.sql.Date;

public class EPR_OAC {
	private String PCC_Cd;
	private String User_Id;
	private String Default_Ticketing_Carrier;
	private String Personal_City_Code;
	private String Personal_Account_Code;
	private String Station_Code;
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

	public String getDefault_Ticketing_Carrier() {
		return Default_Ticketing_Carrier;
	}

	public void setDefault_Ticketing_Carrier(final String Default_Ticketing_Carrier) {
		this.Default_Ticketing_Carrier = Default_Ticketing_Carrier;
	}

	public String getPersonal_City_Code() {
		return Personal_City_Code;
	}

	public void setPersonal_City_Code(final String Personal_City_Code) {
		this.Personal_City_Code = Personal_City_Code;
	}

	public String getPersonal_Account_Code() {
		return Personal_Account_Code;
	}

	public void setPersonal_Account_Code(final String Personal_Account_Code) {
		this.Personal_Account_Code = Personal_Account_Code;
	}

	public String getStation_Code() {
		return Station_Code;
	}

	public void setStation_Code(final String Station_Code) {
		this.Station_Code = Station_Code;
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