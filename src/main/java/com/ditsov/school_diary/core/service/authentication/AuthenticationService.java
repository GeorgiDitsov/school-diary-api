package com.ditsov.school_diary.core.service.authentication;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import com.ditsov.school_diary.core.entity.user.User;

public interface AuthenticationService {

  /**
   * Attempts an authentication request with the provided {@link
   * UsernamePasswordAuthenticationToken}.
   *
   * @param authenticationToken
   * @return If the authentication is successfully done - the authenticated {@link User}.
   */
  User authenticate(final UsernamePasswordAuthenticationToken authenticationToken);

  /**
   * Retrieves if present the current authenticated {@link User}.
   *
   * @return
   */
  User getCurrentAuthenticatedUser();
}
