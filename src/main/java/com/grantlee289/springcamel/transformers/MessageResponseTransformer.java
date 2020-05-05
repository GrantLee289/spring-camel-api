package com.grantlee289.springcamel.transformers;

import com.grantlee289.springcamel.beans.ApiBean;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MessageResponseTransformer implements Processor {

  public static final Logger LOGGER = LoggerFactory.getLogger(MessageResponseTransformer.class);

  @Override
  public void process(Exchange exchange) {
    ApiBean messageBean = exchange.getIn().getBody(ApiBean.class);
    if (messageBean.getCustomerName().equalsIgnoreCase("Benoit")) {
      exchange.setProperty("response", "Merci " + messageBean.getCustomerName() + "(" + messageBean.getCustomerId() + ") - votre message a été reçu");
    } else {
      exchange.setProperty("response", "Thanks " + messageBean.getCustomerName() + "(" + messageBean.getCustomerId() + ") - your message has been received");
    }
  }
}
