package com.kmmaltairlines.hip.tdbingester.exceptions;

/**
 * This exception is thrown when the bytes specified within the done file does
 * not match the exact amount of bytes of the .enc file prior to being
 * decrypted.
 * 
 * @author James Scicluna
 */
public class FileSizeMismatchException extends TravelDataBatchException {

	private static final long serialVersionUID = 4190414923026144740L;

	public FileSizeMismatchException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileSizeMismatchException(String message) {
		super(message);
	}

}
