package datalayerupdate.webservice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.jws.WebService;

@WebService(endpointInterface="datalayerupdate.webservice.DataLayerUpdate")
public class DataLayerUpdateImpl implements DataLayerUpdate {

  @Override
  public String getDate(final String url) {
    String returnDate = null;
    try {
      if (url.matches(".*hdx.*")) {
        returnDate = scrapeHDX(new URL(url));
      } else if (url.matches(".*humanitarianresponse.*")){
        returnDate = scrapeHR(new URL(url));
      }
    } catch (final IOException e){
      e.printStackTrace();
    }

    return returnDate;
   }


  public static String scrapeHDX(final URL hdxURL) throws IOException {

    String sCurrentLine = "";
    BufferedReader br = null;
    final String pattern = "(.*<.*>)(.*)(</td>)";

    try {
      br = new BufferedReader(new InputStreamReader(hdxURL.openStream()));

      while ((sCurrentLine = br.readLine()) != null) {
        if (sCurrentLine.matches(".*dataset-details.*20.*")){
          sCurrentLine = sCurrentLine.replaceAll(pattern, "$2");
          break;
        }
      }
    } catch (final FileNotFoundException e) {
      e.printStackTrace();
    }
    return sCurrentLine;
  }

  public static String scrapeHR(final URL hrURL) throws IOException {

    String sCurrentLine = null;
    BufferedReader br = null;
    final String pattern = "(<.*>)(\\d{2}\\s*\\w*\\s*\\d{4})(<.*>)";

    try {
      br = new BufferedReader(new InputStreamReader(hrURL.openStream()));

      while ((sCurrentLine = br.readLine()) != null) {
        if (sCurrentLine.matches(".*Dataset Date.*")){
          sCurrentLine = sCurrentLine.replaceAll(pattern, "$2");
          break;
        }
      }
    } catch (final FileNotFoundException e) {
      e.printStackTrace();
    }
    return sCurrentLine;

  }





}

