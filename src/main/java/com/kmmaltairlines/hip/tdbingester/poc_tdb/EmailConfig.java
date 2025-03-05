package com.kmmaltairlines.hip.tdbingester.poc_tdb;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "mail")
public class EmailConfig {
    
    private String to;
    private String sendUser;  // Aggiungi il campo per `send.user`

    // Getter e setter per `to`
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    // Getter e setter per `send.user`
    public String getSendUser() {
        return sendUser;
    }

    public void setSendUser(String sendUser) {
        this.sendUser = sendUser;
    }
}
