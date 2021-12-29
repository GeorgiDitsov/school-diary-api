package com.ditsov.school_diary.controller.authentication.helper;

import static com.ditsov.school_diary.util.JsonWebTokenUtil.generateKey;
import static com.ditsov.school_diary.util.JsonWebTokenUtil.generateToken;
import java.security.Key;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.config.properties.ApplicationProperties;
import com.ditsov.school_diary.core.entity.user.User;
import com.ditsov.school_diary.core.factory.authentication.AuthenticationFactory;
import com.ditsov.school_diary.core.factory.user.UserFactory;
import com.ditsov.school_diary.core.service.authentication.AuthenticationService;
import com.ditsov.school_diary.model.authentication.AuthenticationRequestBean;
import com.ditsov.school_diary.model.authentication.AuthenticationResponseBean;
import com.ditsov.school_diary.model.user.BasicUserResponseBean;

@Component
public class AuthenticationControllerHelper {

  @Autowired private AuthenticationFactory authenticationFactory;

  @Autowired private AuthenticationService authenticationService;

  @Autowired private ApplicationProperties applicationProperties;

  @Autowired private UserFactory userFactory;

  public AuthenticationResponseBean login(final AuthenticationRequestBean authenticationRequestBean)
      throws Exception {
    UsernamePasswordAuthenticationToken authentication =
        authenticationFactory.convertAuthenticationRequestBeanToUsernamePasswordAuthenticationToken(
            authenticationRequestBean);

    User user = authenticationService.authenticate(authentication);

    Key secretKey =
        generateKey(
            applicationProperties.getSecurity().getJwt().getSecretKey().getKeyStore().getLocation(),
            applicationProperties.getSecurity().getJwt().getSecretKey().getKeyStore().getType(),
            applicationProperties.getSecurity().getJwt().getSecretKey().getKeyStore().getAlias(),
            applicationProperties
                .getSecurity()
                .getJwt()
                .getSecretKey()
                .getKeyStore()
                .getPassword());

    String jwt =
        generateToken(
            user,
            applicationProperties.getName(),
            applicationProperties.getSecurity().getJwt().getExpiration(),
            secretKey);

    return authenticationFactory.createAuthenticationResponseBean(jwt);
  }

  public BasicUserResponseBean getAuthenticatedUser() {
    User authenticatedUser = authenticationService.getCurrentAuthenticatedUser();

    return userFactory.convertUserToBasicUserResponseBean(authenticatedUser);
  }
}
