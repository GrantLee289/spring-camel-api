package com.grantlee289.springcamel.beans;

import org.springframework.stereotype.Component;

@Component
public class ApiBean {

  private String message;

  private int customerId;

  private String customerName;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public int getCustomerId() {
    return customerId;
  }

  public void setCustomerId(int customerId) {
    this.customerId = customerId;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  @Override
  public String toString() {
    return customerName + customerId + message;
  }
}
