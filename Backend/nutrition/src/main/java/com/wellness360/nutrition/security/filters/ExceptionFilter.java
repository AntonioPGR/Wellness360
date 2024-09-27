package com.wellness360.nutrition.security.filters;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wellness360.nutrition.packages.validation.dtos.ExceptionReturnDTO;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExceptionFilter extends OncePerRequestFilter{

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) 
  throws ServletException, IOException {
    try{
      filterChain.doFilter(request, response);
    } catch (Exception e) {
      ExceptionReturnDTO dto = new ExceptionReturnDTO(e.getMessage());
      String json = writeObjectASJson(dto);
      configurateUnauthorizedResponse(response, json);
    }
  }

  private String writeObjectASJson(Object obj) throws JsonProcessingException{
    if(obj != null){
      ObjectMapper mapper = new ObjectMapper();
      return mapper.writeValueAsString(obj);
    }
    return null;
  }

  private void configurateUnauthorizedResponse(HttpServletResponse response, String json) 
  throws IOException{
      response.setStatus(HttpStatus.UNAUTHORIZED.value());
      response.getWriter().write(json);
      response.setContentType("Application/json");

  }

}
