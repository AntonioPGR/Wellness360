package com.wellness360.nutrition.security.filters;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.wellness360.nutrition.api.AuthClient;
import com.wellness360.nutrition.api.dto.AuthReturnDTO;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

  @Autowired
  AuthClient login_client;

  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    String jwt_token = recoverToken(request);
    if(jwt_token != null){
      AuthReturnDTO dto = login_client.authenticateAngGetUuid(jwt_token);
      UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
        dto.uuid(), 
        null,  
        List.of(new SimpleGrantedAuthority("ROLE_"+dto.role()))
      );
      SecurityContextHolder.getContext().setAuthentication(auth);
    }
    filterChain.doFilter(request, response);
  }

  private String recoverToken(HttpServletRequest request){
    String auth_header = request.getHeader("Authorization");
    if(auth_header == null) return null;
    return auth_header.replace("Bearer ", "");
  }

}
