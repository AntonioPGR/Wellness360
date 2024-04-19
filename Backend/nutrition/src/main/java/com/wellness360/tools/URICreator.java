package com.wellness360.tools;

import java.net.URI;
import java.net.URISyntaxException;

public class URICreator {
  
  String base_url = "http://localhost:8080/";

  public URI createUriToCreatedElement(String endpoint_url, String specific_path) throws URISyntaxException{
    String uri_path = base_url + endpoint_url + specific_path;
    return new URI(uri_path);
  }

}
