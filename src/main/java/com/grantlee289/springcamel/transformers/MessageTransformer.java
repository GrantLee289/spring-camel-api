package com.grantlee289.springcamel.transformers;

import com.grantlee289.springcamel.beans.ApiBean;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MessageTransformer implements Processor {

  public static final Logger LOGGER = LoggerFactory.getLogger(MessageTransformer.class);

  @Override
  public void process(Exchange exchange) throws Exception {
    ApiBean messageBean = exchange.getIn().getBody(ApiBean.class);
    if (messageBean.getCustomerName().equalsIgnoreCase("Benoit")) {
      exchange.getIn().setBody("Balls!");
    } else {
      exchange.getIn().setBody("Thanks " + messageBean.getCustomerName() + "(" + messageBean.getCustomerId() + ") - your message has been received");
    }
  }
}
