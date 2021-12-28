package com.ditsov.school_diary.core.factory.authentication.impl;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.factory.authentication.AuthenticationFactory;
import com.ditsov.school_diary.model.authentication.AuthenticationRequestBean;
import com.ditsov.school_diary.model.authentication.AuthenticationResponseBean;

@Component
public class AuthenticationFactoryImpl implements AuthenticationFactory {

  /**
   * @see
   *     AuthenticationFactory#convertAuthenticationRequestBeanToUsernamePasswordAuthenticationToken(AuthenticationRequestBean)
   */
  @Override
  public UsernamePasswordAuthenticationToken
      convertAuthenticationRequestBeanToUsernamePasswordAuthenticationToken(
          final AuthenticationRequestBean authenticationRequestBean) {
    return new UsernamePasswordAuthenticationToken(
        authenticationRequestBean.getUsername(), authenticationRequestBean.getPassword());
  }

  /** @see AuthenticationFactory#createAuthenticationResponseBean(String) */
  @Override
  public AuthenticationResponseBean createAuthenticationResponseBean(final String token) {
    AuthenticationResponseBean bean = new AuthenticationResponseBean();

    bean.setToken(token);

    return bean;
  }
}
