package com.wellness360.nutrition.api;

import org.apache.logging.log4j.util.InternalException;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.wellness360.nutrition.api.dto.AuthReturnDTO;

@Service
public class AuthClient {
  
  final WebClient client;

  public AuthClient(){
    client = WebClient.builder()
      .baseUrl("http://localhost:8082/users")
      .build();
  }

  public AuthReturnDTO authenticateAngGetUuid(String jwt){
    try{
      AuthReturnDTO dto = client.post()
        .uri("/authenticate")
        .header(HttpHeaders.AUTHORIZATION, "Bearer " + jwt)
        .retrieve()
        .bodyToMono(AuthReturnDTO.class)
        .block();
      return dto;
    } catch(Exception e) {
      throw new InternalException("Could not authenticate thanks to a communication failure to user service");
    }
  }

}
