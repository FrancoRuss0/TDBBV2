package com.airmalta.hip.tdbingester.exceptions;

import com.airmalta.hip.tdbingester.filepojos.DoneFile;

/**
 * This exception is thrown when attempting to read a .enc file which does not exist
 * after having read a .done file. It is always assumed that a .done file will be written
 * after the .enc file has been fully uploaded to the SFTP server.
 * 
 * @author Justin Saliba
 */
public class EncFileDoesNotExistException extends TravelDataBatchException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1327203392298755801L;
	
	private DoneFile doneFile;
	private String expectedEncFileName;

	public EncFileDoesNotExistException(String expectedEncFileName, DoneFile doneFile, Throwable cause) {
		super(String.format("Could not retrieve file %s since it does not exist", expectedEncFileName), cause);
		this.expectedEncFileName = expectedEncFileName;
		this.doneFile = doneFile;
	}
	
	public EncFileDoesNotExistException(String expectedEncFileName, DoneFile doneFile) {
		super(String.format("Could not retrieve file %s since it does not exist", expectedEncFileName));
		this.expectedEncFileName = expectedEncFileName;
		this.doneFile = doneFile;
	}

	public DoneFile getDoneFile() {
		return doneFile;
	}

	public String getExpectedEncFileName() {
		return expectedEncFileName;
	}
	
}
