package com.airmalta.hip.tdbingester.exceptions;

/**
 * This exception is thrown when a dataweave transformation script does not
 * exist for a file which was found in the .enc file. The name of the dataweave
 * script must always have the name of the TDB entity. For example, if a TDB
 * entity is called ResFlightAirExtra, then the dataweave file must be present
 * at <strong>transformations/ResFlightAirExtra.dwl</strong> within the
 * application's classpath at runtime. 
 * <br/>
 * <br/>
 * Note that the dataweave file lookup logic is case sensitive.
 * <br/>
 * <br/>
 * This exception does not halt the processing of the TDB batch job, but rather
 * halts processing of the unknown file.
 * 
 * @author James Scicluna
 */
public class UnknownFileTypeException extends TravelDataBatchException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1864725509808964505L;

	public UnknownFileTypeException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnknownFileTypeException(String message) {
		super(message);
	}
	
}
