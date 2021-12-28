package com.ditsov.school_diary.core.service.authentication.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import com.ditsov.school_diary.core.entity.user.User;
import com.ditsov.school_diary.core.service.authentication.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

  @Autowired private AuthenticationManager authenticationManager;

  /** @see AuthenticationService#authenticate(UsernamePasswordAuthenticationToken) */
  @Override
  public User authenticate(final UsernamePasswordAuthenticationToken authenticationToken) {
    Authentication authentication = authenticationManager.authenticate(authenticationToken);

    return (User) authentication.getPrincipal();
  }
}
