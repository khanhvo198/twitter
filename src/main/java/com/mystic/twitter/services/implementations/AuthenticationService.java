package com.mystic.twitter.services.implementations;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mystic.twitter.dtos.UserDTO;
import com.mystic.twitter.exceptions.ApiRequestException;
import com.mystic.twitter.models.User;
import com.mystic.twitter.repository.UserRepository;
import com.mystic.twitter.role.Role;
import com.mystic.twitter.security.JwtService;
import com.mystic.twitter.security.UserDetailService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  
  private final UserRepository userRepo;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final UserDetailService userService;
  private final AuthenticationManager authenticationManager;
  private final ModelMapper modelMapper;



  public Map<String, Object> login(String email, String password) {
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email,password));
    } catch (Exception e) {
      throw new ApiRequestException("Incorrect username or password", HttpStatus.FORBIDDEN);
    }
    User user =  userRepo.findUserByEmail(email).orElseThrow(() 
                      -> new ApiRequestException("User not found", HttpStatus.NOT_FOUND));
    String token = jwtService.generateToken(email, "USER");
    Map<String, Object> data = new HashMap<>();
    data.put("token", token);
    data.put("user", modelMapper.map(user, UserDTO.class));
    return data;
  }            



  public String registration(String email, String password, String firstName, String lastName  ) {
    Optional<User> existingUser = userRepo.findUserByEmail(email);
    
    if(existingUser.isPresent()) {
      String message = "Email has already been taken";
      throw new ApiRequestException(message, HttpStatus.FORBIDDEN);
    } else {
      User user = new User();
      user.setEmail(email);
      user.setFirstName(firstName);
      user.setLastName(lastName);
      user.setRole(Role.USER);
      user.setPassword(passwordEncoder.encode(password));
      userRepo.save(user);
      return "Registration success";
    }
  }
}
