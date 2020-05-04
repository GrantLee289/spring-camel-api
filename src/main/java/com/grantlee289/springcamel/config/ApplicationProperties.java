package com.grantlee289.springcamel.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {

  @Value("${message.service}")
  private String messageService;

  @Value("${message.service.response}")
  private String messageServiceResponse;

  @Value("${message.service.transformer}")
  private String messageServiceTransformer;

  @Value("${com.grantlee289.path}")
  private String contextPath;

  @Value("${server.port}")
  private String serverPort;

  @Value("${endpoint.to}")
  private String messageEndpoint;

  public String getMessageService() {
    return messageService;
  }

  public String getMessageServiceResponse() {
    return messageServiceResponse;
  }

  public String getMessageServiceTransformer() {
    return messageServiceTransformer;
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
