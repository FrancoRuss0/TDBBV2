package com.kmmaltairlines.hip.tdbingester.exceptions;

/**
 * This exception is thrown when a file specified in a .done file is not present
 * within the corresponding .enc file.
 * 
 * @author James Scicluna
 */
public class MissingDatFilesException extends TravelDataBatchException {

	private static final long serialVersionUID = 5715032718779398597L;

	public MissingDatFilesException(String message, Throwable cause) {
		super(message, cause);
	}

	public MissingDatFilesException(String message) {
		super(message);
	}

}