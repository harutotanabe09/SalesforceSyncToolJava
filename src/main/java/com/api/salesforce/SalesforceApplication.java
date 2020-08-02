package com.api.salesforce;

import com.sforce.async.AsyncApiException;
import com.sforce.ws.ConnectionException;
import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SalesforceApplication {
  public static void main(String[] args)
      throws AsyncApiException, ConnectionException, IOException {
    SpringApplication.run(SalesforceApplication.class, args);
    System.out.println("start");
    BulkSalesforceJob example = new BulkSalesforceJob();
    // Replace arguments below with your credentials and test file name
    // The first parameter indicates that we are loading Account records
    example.run("Account", "ex7477tanabe+01@gmail.com", "tanabe1678", "import.csv");
    System.out.println("end");
  }
}
