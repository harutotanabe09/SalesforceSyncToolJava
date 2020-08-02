package com.api.salesforce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SalesforceApplication {
  public static void main(String[] args) {
    SpringApplication.run(SalesforceApplication.class, args);
  }
}
