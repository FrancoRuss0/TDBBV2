package com.kmmaltairlines.hip.tdbingester.poc_tdb;

public class BlobData {
	private String name;
	private String content;

	public BlobData(String name, String content) {
		this.name = name;
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public String getContent() {
		return content;
	}
}
