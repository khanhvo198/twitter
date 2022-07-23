package com.mystic.twitter.configurations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.mystic.twitter.repository.UserRepository;
import com.mystic.twitter.security.JwtFilter;
import com.mystic.twitter.security.UserDetailService;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebSecurityConfiguration {
  private final JwtFilter jwtFilter;
  private final UserRepository userRepository;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      http
              .csrf().disable()
              .authorizeHttpRequests((authz) -> authz
                      .antMatchers("/api/v1/auth/**").permitAll()
                      .anyRequest().authenticated())
              .httpBasic(Customizer.withDefaults())
              .authenticationProvider(authenticationProvider())
              .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

      return http.build();
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  AuthenticationManager auth(AuthenticationConfiguration authenticationConfiguration) throws Exception {
      return authenticationConfiguration.getAuthenticationManager();
  }

  @Bean
  public UserDetailsService userDetailsService() {
      return new UserDetailService(userRepository);
  }


  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
      authProvider.setUserDetailsService(userDetailsService());
      authProvider.setPasswordEncoder(passwordEncoder());
      return authProvider;
  }
}
