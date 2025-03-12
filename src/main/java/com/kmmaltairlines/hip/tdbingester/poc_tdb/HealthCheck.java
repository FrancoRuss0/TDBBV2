package com.kmmaltairlines.hip.tdbingester.poc_tdb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {
	
	// This method will listen to GET requests at /health
    @GetMapping("/health")
    public String healthCheck() {
        return "ok";
    }
	
}
