package com.ditsov.school_diary.core.service.authentication.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.ditsov.school_diary.core.entity.user.User;
import com.ditsov.school_diary.core.service.authentication.AuthenticationService;
import com.ditsov.school_diary.core.service.user.UserService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

  @Autowired private AuthenticationManager authenticationManager;

  @Autowired private UserService userService;

  /** @see AuthenticationService#authenticate(UsernamePasswordAuthenticationToken) */
  @Override
  public User authenticate(final UsernamePasswordAuthenticationToken authenticationToken) {
    Authentication authentication = authenticationManager.authenticate(authenticationToken);

    return (User) authentication.getPrincipal();
  }

  /** @see AuthenticationService#getCurrentAuthenticatedUser() */
  @Override
  public User getCurrentAuthenticatedUser() {
    String username =
        (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    return userService.getUserByUsername(username);
  }
}
