package datalayerupdate.webservice;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface DataLayerUpdate {

 @WebMethod public String getDate(String url);


}
