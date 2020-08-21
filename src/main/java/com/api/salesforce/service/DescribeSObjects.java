package com.api.salesforce.service;

import com.sforce.soap.partner.*;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;
import org.springframework.stereotype.Service;

@Service
public class DescribeSObjects {
  /** */
  public void describeSObjectsSample(String userName, String password, String apiVersion) {
    try {
      PartnerConnection connection = login(userName, password, apiVersion);
      // Call describeSObjectResults and pass it an array with
      // the names of the objects to describe.
      DescribeSObjectResult[] describeSObjectResults =
          connection.describeSObjects(new String[] {"account"});
      // Iterate through the list of describe sObject results
      for (int i = 0; i < describeSObjectResults.length; i++) {
        DescribeSObjectResult desObj = describeSObjectResults[i];
        // Get the name of the sObject
        String objectName = desObj.getName();
        System.out.println("sObject name: " + objectName);
        // For each described sObject, get the fields
        Field[] fields = desObj.getFields();
        // Get some other properties
        if (desObj.getActivateable()) System.out.println("\tActivateable");
        // Iterate through the fields to get properties for each field
        for (int j = 0; j < fields.length; j++) {
          Field field = fields[j];
          System.out.println("\tField: " + field.getName());
          System.out.println("\tgetInlineHelpText: " + field.getInlineHelpText());
          System.out.println("\t\tLabel: " + field.getLabel());
          if (field.isCustom()) System.out.println("\t\tThis is a custom field.");
          System.out.println("\t\tType: " + field.getType());
          if (field.getLength() > 0) System.out.println("\t\tLength: " + field.getLength());
          if (field.getPrecision() > 0)
            System.out.println("\t\tPrecision: " + field.getPrecision());
          // Determine whether this is a picklist field
          if (field.getType() == FieldType.picklist) {
            // Determine whether there are picklist values
            PicklistEntry[] picklistValues = field.getPicklistValues();
            if (picklistValues != null && picklistValues[0] != null) {
              System.out.println("\t\tPicklist values = ");
              for (int k = 0; k < picklistValues.length; k++) {
                System.out.println("\t\t\tItem: " + picklistValues[k].getLabel());
              }
            }
          }
          // Determine whether this is a reference field
          if (field.getType() == FieldType.reference) {
            // Determine whether this field refers to another object
            String[] referenceTos = field.getReferenceTo();
            if (referenceTos != null && referenceTos[0] != null) {
              System.out.println("\t\tField references the following objects:");
              for (int k = 0; k < referenceTos.length; k++) {
                System.out.println("\t\t\t" + referenceTos[k]);
              }
            }
          }
        }
      }
    } catch (ConnectionException ce) {
      ce.printStackTrace();
    }
  }

  private PartnerConnection login(String username, String password, String authEndPoint) {
    PartnerConnection connect = null;
    try {
      ConnectorConfig config = new ConnectorConfig();
      config.setUsername(username);
      config.setPassword(password);
      config.setAuthEndpoint(authEndPoint);
      config.setTraceMessage(true);
      connect = new PartnerConnection(config);
    } catch (ConnectionException ce) {
      ce.printStackTrace();
    }
    return connect;
  }
}
