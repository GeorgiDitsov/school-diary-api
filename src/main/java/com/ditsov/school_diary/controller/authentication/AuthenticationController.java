package com.ditsov.school_diary.controller.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ditsov.school_diary.controller.authentication.helper.AuthenticationControllerHelper;
import com.ditsov.school_diary.model.authentication.AuthenticationRequestBean;
import com.ditsov.school_diary.model.authentication.AuthenticationResponseBean;
import com.ditsov.school_diary.model.user.BasicUserResponseBean;
import io.swagger.annotations.Api;

@Api(tags = {"Authentication API"})
@RestController
public class AuthenticationController {

  @Autowired private AuthenticationControllerHelper authenticationControllerHelper;

  @PostMapping("/authenticate")
  public AuthenticationResponseBean login(
      @RequestBody @Validated final AuthenticationRequestBean login) throws Exception {
    return authenticationControllerHelper.login(login);
  }

  @GetMapping("/authenticated-user")
  public BasicUserResponseBean getAuthenticatedUser() {
    return authenticationControllerHelper.getAuthenticatedUser();
  }
}
