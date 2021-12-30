package com.ditsov.school_diary.core.factory.authentication;

import java.time.LocalDateTime;
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
   * @param expiresAt
   * @return
   */
  AuthenticationResponseBean createAuthenticationResponseBean(
      final String token, final LocalDateTime expiresAt);
}
