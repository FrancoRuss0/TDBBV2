package com.kmmaltairlines.hip.tdbingester.filepojos;

public class ResODFlight extends PNRRecord {

	private String ID;
	private Short SegmentNbr;
	private String AirlineOrigTerminal;
	private String AirlineDestTerminal;
	private String TravelerOrigTerminal;
	private String TravelerDestTerminal;
	private String AirlineOrigCntry;
	private String AirlineDestCntry;
	private String TravelerOrigCntry;
	private String TravelerDestCntry;

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

	public String getAirlineOrigTerminal() {
		return AirlineOrigTerminal;
	}

	public void setAirlineOrigTerminal(final String AirlineOrigTerminal) {
		this.AirlineOrigTerminal = AirlineOrigTerminal;
	}

	public String getAirlineDestTerminal() {
		return AirlineDestTerminal;
	}

	public void setAirlineDestTerminal(final String AirlineDestTerminal) {
		this.AirlineDestTerminal = AirlineDestTerminal;
	}

	public String getTravelerOrigTerminal() {
		return TravelerOrigTerminal;
	}

	public void setTravelerOrigTerminal(final String TravelerOrigTerminal) {
		this.TravelerOrigTerminal = TravelerOrigTerminal;
	}

	public String getTravelerDestTerminal() {
		return TravelerDestTerminal;
	}

	public void setTravelerDestTerminal(final String TravelerDestTerminal) {
		this.TravelerDestTerminal = TravelerDestTerminal;
	}

	public String getAirlineOrigCntry() {
		return AirlineOrigCntry;
	}

	public void setAirlineOrigCntry(final String AirlineOrigCntry) {
		this.AirlineOrigCntry = AirlineOrigCntry;
	}

	public String getAirlineDestCntry() {
		return AirlineDestCntry;
	}

	public void setAirlineDestCntry(final String AirlineDestCntry) {
		this.AirlineDestCntry = AirlineDestCntry;
	}

	public String getTravelerOrigCntry() {
		return TravelerOrigCntry;
	}

	public void setTravelerOrigCntry(final String TravelerOrigCntry) {
		this.TravelerOrigCntry = TravelerOrigCntry;
	}

	public String getTravelerDestCntry() {
		return TravelerDestCntry;
	}

	public void setTravelerDestCntry(final String TravelerDestCntry) {
		this.TravelerDestCntry = TravelerDestCntry;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		ResODFlight other = (ResODFlight) obj;
		if (SegmentNbr == null) {
			if (other.SegmentNbr != null)
				return false;
		} else if (!SegmentNbr.equals(other.SegmentNbr))
			return false;
		return true;
	}

}