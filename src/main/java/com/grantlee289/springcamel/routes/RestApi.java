package com.grantlee289.springcamel.routes;

import com.grantlee289.springcamel.beans.ApiBean;
import com.grantlee289.springcamel.config.ApplicationProperties;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class RestApi extends RouteBuilder {

  ApplicationProperties applicationProperties;

  public RestApi(ApplicationProperties applicationProperties) {
    this.applicationProperties = applicationProperties;
  }

  @Override
  public void configure() throws Exception {

    restConfiguration()
        .contextPath(applicationProperties.getContextPath())
        .port(applicationProperties.getServerPort())
        .enableCORS(true)
        .apiContextPath("/api-doc")
        .apiProperty("api.title", "Test REST API")
        .apiProperty("api.version", "v1")
        .apiContextRouteId("doc-api")
        .component("servlet")
        .bindingMode(RestBindingMode.json);

    rest("/spring-camel-api/")
        .id("api-route")
        .consumes("application/json")
        .post("/messages")
        .bindingMode(RestBindingMode.json_xml)
        .type(ApiBean.class)
        .to(applicationProperties.getMessageServiceTransformer());
  }
}
