package com.wellness360.nutrition.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

import com.wellness360.nutrition.security.filters.ExceptionFilter;
import com.wellness360.nutrition.security.filters.SecurityFilter;

@Configuration
@EnableWebSecurity
public class AuthConfiguration {
  
  @Autowired
  SecurityFilter security_filter;
  @Autowired
  ExceptionFilter exception_filter;

  @Value("${path.category}")
  private String category_path;
  @Value("${path.food}")
  private String food_path;
  @Value("${path.recipe}")
  private String recipe_path;

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http_security) throws Exception{
    return http_security
      .csrf(csrf -> csrf.disable())
      .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
      .authorizeHttpRequests(authorize -> authorize
        .requestMatchers(HttpMethod.POST, category_path, food_path).hasRole("ADMIN")
        .requestMatchers(HttpMethod.PUT, category_path, food_path).hasRole("ADMIN")
        .requestMatchers(HttpMethod.DELETE, category_path, food_path).hasRole("ADMIN")
        .requestMatchers(HttpMethod.GET, category_path, category_path + "/*", food_path, food_path + "/*").permitAll()
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
