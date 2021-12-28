package com.ditsov.school_diary.core.factory.authentication;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import com.ditsov.school_diary.model.authentication.AuthenticationRequestBean;
import com.ditsov.school_diary.model.authentication.AuthenticationResponseBean;

public interface AuthenticationFactory {

  /**
   * Converts an {@link AuthenticationRequestBean} into {@link UsernamePasswordAuthenticationToken}.
   *
   * @param authenticationRequestBean
   * @return
   */
  UsernamePasswordAuthenticationToken
      convertAuthenticationRequestBeanToUsernamePasswordAuthenticationToken(
          final AuthenticationRequestBean authenticationRequestBean);

  /**
   * Creates an {@link AuthenticationResponseBean}.
   *
   * @param token
   * @return
   */
  AuthenticationResponseBean createAuthenticationResponseBean(final String token);
}
