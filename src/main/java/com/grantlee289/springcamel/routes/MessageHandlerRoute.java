package com.grantlee289.springcamel.routes;

import com.grantlee289.springcamel.config.ApplicationProperties;
import com.grantlee289.springcamel.transformers.MessageTransformer;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MessageHandlerRoute extends RouteBuilder {

  ApplicationProperties applicationProperties;

  public MessageHandlerRoute(ApplicationProperties applicationProperties) {
    this.applicationProperties = applicationProperties;
  }

  @Override
  public void configure() throws Exception {
    from(applicationProperties.getMessageService())
        .routeId("message-handler")
        .tracing()
        .log(LoggingLevel.INFO, "Received: ${body.message}")
        .log(LoggingLevel.INFO, "From: ${body.customerName}: ${body.customerId}")
        .to(applicationProperties.getMessageEndpoint())
        .process(new MessageTransformer())
        .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200));
  }
}
