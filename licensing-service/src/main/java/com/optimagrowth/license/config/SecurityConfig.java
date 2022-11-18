package com.optimagrowth.license.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {

  @Bean
  public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {
    http.antMatcher("/v2/**")
        .authorizeRequests()
        .anyRequest().permitAll();
    return http.build();
  }

}
