package com.wellness360.nutrition.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.wellness360.nutrition.packages.crud.validations.UnauthorizedOperation;


@Service
public class JwtTokenService {

  @Value("${security.jwt.token_secret}")
  private String secret;
  private String issuer = "Wellness360 - User";
  
  public String generateToken(String data){
    try{
      Algorithm alg = Algorithm.HMAC256(secret);
      return JWT.create()
        .withIssuer(issuer)
        .withSubject(data)
        .withExpiresAt(getExpiresAt())
        .sign(alg);
    } catch (JWTCreationException e) {
      throw new UnauthorizedOperation("Error generating jwt token:" + e.getMessage());
    }
  }

  public String getDataFromToken(String token){
    try{
      Algorithm alg = Algorithm.HMAC256(secret);
      return JWT.require(alg)
        .withIssuer(issuer)
        .build()
        .verify(token)
        .getSubject();
    } catch ( JWTVerificationException e ){
      throw new UnauthorizedOperation("Invalid jwt token");
    }
  }

  private Instant getExpiresAt(){
    return LocalDateTime.now().plusDays(1).toInstant(ZoneOffset.of("-03:00"));
  }

}
