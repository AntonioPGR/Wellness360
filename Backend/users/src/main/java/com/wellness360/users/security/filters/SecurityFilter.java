package com.wellness360.users.security.filters;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.wellness360.users.app.users.user_basic.UserBasicEntity;
import com.wellness360.users.app.users.user_basic.UserBasicRepository;
import com.wellness360.users.security.JwtTokenService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

  @Autowired
  JwtTokenService jwt_service;
  @Autowired
  UserBasicRepository user_repository;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    String token = recoverToken(request);
    if(token != null){
      String username = jwt_service.getDataFromToken(token);
      UserBasicEntity user = user_repository.findByUsername(username)
        .orElseThrow(() -> new EntityNotFoundException("Could not find user with correspondent token"));
      UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
      SecurityContextHolder.getContext().setAuthentication(authentication);
    }
    filterChain.doFilter(request, response);
  }

  private String recoverToken(HttpServletRequest request){
    String auth_header = request.getHeader("Authorization");
    if(auth_header == null) return null;
    return auth_header.replace("Bearer ", "");
  }

}
