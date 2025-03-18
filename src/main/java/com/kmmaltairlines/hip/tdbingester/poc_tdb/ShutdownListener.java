package com.kmmaltairlines.hip.tdbingester.poc_tdb;

import org.springframework.context.event.EventListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class ShutdownListener {

	private static final Logger logger = LoggerFactory.getLogger(ShutdownListener.class);

	@EventListener
	public void onShutdown(ContextClosedEvent event) {
		logger.info("ActiatorPocApplication shutdown");
	}
}