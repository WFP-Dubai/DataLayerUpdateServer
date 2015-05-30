package datalayerupdate.webservice;

import javax.xml.ws.Endpoint;

public class DataLayerUpdatePublisher {

  public static void main(final String[] args) {
    Endpoint.publish("http://localhost:8082/DataLayerUpdateServer",new DataLayerUpdateImpl());
   }
}
