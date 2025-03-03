package com.airmalta.hip.tdbingester.filepojos;

public class DoneFileEntry {
	
	private String filename;
	private int records;
	
	// Used for DataWeave initialisation only
	public DoneFileEntry() {}

	public DoneFileEntry(String filename, int records) {
		super();
		this.filename = filename;
		this.records = records;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getRecords() {
		return records;
	}

	public void setRecords(int records) {
		this.records = records;
	}

	@Override
	public String toString() {
		return "DoneFileEntry [filename=" + filename + ", records=" + records + "]";
	}
  
	
}
