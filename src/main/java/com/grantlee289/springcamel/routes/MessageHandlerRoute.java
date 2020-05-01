package com.grantlee289.springcamel.routes;

import com.grantlee289.springcamel.beans.ApiBean;
import com.grantlee289.springcamel.config.ApplicationProperties;
import com.grantlee289.springcamel.transformers.MessageResponseTransformer;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MessageHandlerRoute extends RouteBuilder {

  ApplicationProperties applicationProperties;
  ApiBean apiBean;

  public MessageHandlerRoute(ApplicationProperties applicationProperties, ApiBean apiBean) {
    this.applicationProperties = applicationProperties;
    this.apiBean = apiBean;
  }

  @Override
  public void configure() throws Exception {
    from(applicationProperties.getMessageService())
        .routeId("message-handler")
        .tracing()
        .log(LoggingLevel.INFO, "Received: ${body.message}")
        .log(LoggingLevel.INFO, "From: ${body.customerName}: ${body.customerId}")
        .to(applicationProperties.getMessageEndpoint()+ "/" + apiBean.getCustomerId() + ".json")
        .process(new MessageResponseTransformer())
        .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200));
  }
}
