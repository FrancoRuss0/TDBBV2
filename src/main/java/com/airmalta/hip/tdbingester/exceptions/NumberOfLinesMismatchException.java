package com.airmalta.hip.tdbingester.exceptions;

/**
 * This exception is thrown when the number of lines read from a TDB data file
 * does not equal that which is specified in the .done file for the .enc file from which
 * the data file was extracted from.
 * 
 * Example:
 * 
 * .done file specifies 5000 lines but .dat file only contains 4998.
 * 
 * @author James Scicluna
 */
public class NumberOfLinesMismatchException extends TravelDataBatchException{

	private static final long serialVersionUID = -8298009095817091783L;

	public NumberOfLinesMismatchException(String message, Throwable cause) {
		super(message, cause);
	}

	public NumberOfLinesMismatchException(String message) {
		super(message);
	}
	
}
