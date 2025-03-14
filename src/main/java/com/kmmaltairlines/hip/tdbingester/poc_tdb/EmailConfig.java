package com.kmmaltairlines.hip.tdbingester.poc_tdb;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kmmaltairlines.mail.EmailRequest;

@Configuration
public class EmailConfig {
 
 @Value("${mail.to}")
 private String emailIncoming;
 
 @Bean
 public EmailRequest emailRequest() {
  EmailRequest emailRequest = new EmailRequest();
  emailRequest.setSubject("Subject");
  emailRequest.setMessage("test");
  
  Set<String> recipientSet = Arrays.stream(emailIncoming.split(","))
    .map(String::trim)
    .collect(Collectors.toSet());
  
  emailRequest.setRecipients(recipientSet);
  
  return emailRequest;
 }
 
}
 