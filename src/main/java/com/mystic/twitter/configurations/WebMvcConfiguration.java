package com.mystic.twitter.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfiguration implements WebMvcConfigurer {

  final String hostName = "localhost:3000";

  // @Override
  // public void addCorsMappings(CorsRegistry registry) {
  // registry.addMapping("/api/v1/**")
  // .allowedOrigins("http://" + hostName)
  // .allowedMethods("HEAD", "OPTIONS", "GET", "POST", "PUT", "PATCH", "DELETE")
  // .exposedHeaders("page-total-count")
  // .allowedHeaders("*");
  // }
}