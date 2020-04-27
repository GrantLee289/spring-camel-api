package com.grantlee289.springcamel.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {

  @Value("${message.service}")
  private String messageService;

  @Value("${com.grantlee289.path}")
  private String contextPath;

  @Value("${server.port}")
  private String serverPort;

  @Value("${endpoint.to}")
  private String messageEndpoint;

  public String getMessageService() {
    return messageService;
  }

  public String getContextPath() {
    return contextPath;
  }

  public String getServerPort() {
    return serverPort;
  }

  public String getMessageEndpoint() {
    return messageEndpoint;
  }
}
