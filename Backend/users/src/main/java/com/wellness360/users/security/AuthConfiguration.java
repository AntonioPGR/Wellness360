package com.wellness360.users.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;

import com.wellness360.users.security.filters.ExceptionFilter;
import com.wellness360.users.security.filters.SecurityFilter;

@Configuration
@EnableWebSecurity
public class AuthConfiguration {
  
  @Autowired
  SecurityFilter security_filter;
  @Autowired
  ExceptionFilter exception_filter;

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http_security) throws Exception{
    return http_security
      .csrf(csrf -> csrf.disable())
      .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
      .authorizeHttpRequests(authorize -> authorize
        .requestMatchers(HttpMethod.GET, "users/admin", "users/admin").hasRole("ADMIN")
        .requestMatchers(HttpMethod.PUT, "users/admin").hasRole("ADMIN")
        .requestMatchers(HttpMethod.DELETE, "users/admin").hasRole("ADMIN")
        .requestMatchers(HttpMethod.POST, "users/login", "users").permitAll()
        .anyRequest().authenticated()
      )
      .addFilterBefore(exception_filter, LogoutFilter.class)
      .addFilterBefore(security_filter, UsernamePasswordAuthenticationFilter.class)
      .build();
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration auth_config) throws Exception{
    return auth_config.getAuthenticationManager();
  }

  @Bean
  public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }

}
