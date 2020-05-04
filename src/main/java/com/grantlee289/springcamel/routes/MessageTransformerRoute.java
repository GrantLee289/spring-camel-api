package com.grantlee289.springcamel.routes;

import com.grantlee289.springcamel.config.ApplicationProperties;
import com.grantlee289.springcamel.transformers.MessageResponseTransformer;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
public class MessageTransformerRoute extends RouteBuilder {

  ApplicationProperties applicationProperties;
  String date;

  public MessageTransformerRoute(ApplicationProperties applicationProperties) {
    this.applicationProperties = applicationProperties;
    String format = "ddMMyyyy";
    SimpleDateFormat sdf = new SimpleDateFormat(format);
    date = sdf.format(new Date());
  }

  @Override
  public void configure() throws Exception {
    from(applicationProperties.getMessageServiceTransformer())
        .routeId("transformer-handler")
        .log(LoggingLevel.INFO, "Received: ${body.message}")
        .log(LoggingLevel.INFO, "From: ${body.customerName}: ${body.customerId}")
        .process(new MessageResponseTransformer())
        .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200))
        .setHeader(Exchange.FILE_NAME, constant(UUID.randomUUID() + "(" + date + ").json"))
        .marshal()
        .json()
        .to(applicationProperties.getMessageEndpoint())
        .setBody(exchangeProperty("response"));
  }
}
