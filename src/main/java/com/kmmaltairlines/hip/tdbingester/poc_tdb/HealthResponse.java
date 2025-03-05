package com.kmmaltairlines.hip.tdbingester.poc_tdb;

public class HealthResponse {
	
	private String message;

    // Constructor
    public HealthResponse(String message) {
        this.message = message;
    }

    // Getter
    public String getMessage() {
        return message;
    }

    // Setter
    public void setMessage(String message) {
        this.message = message;
    }
}
