package com.airmalta.hip.tdbingester.exceptions;

/**
 * An abstract exception class from which all Travel Data Batch Ingester
 * exceptions should inherit from.
 * 
 * @author James Scicluna
 */
public abstract class TravelDataBatchException extends RuntimeException {

	private static final long serialVersionUID = -4175500452784745319L;

	public TravelDataBatchException(String message, Throwable cause) {
		super(message, cause);
	}

	public TravelDataBatchException(String message) {
		super(message);
	}
	
}
