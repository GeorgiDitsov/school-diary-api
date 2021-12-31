package com.ditsov.school_diary.controller.authentication;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ditsov.school_diary.controller.authentication.helper.AuthenticationControllerHelper;
import com.ditsov.school_diary.model.authentication.AuthenticationRequestBean;
import com.ditsov.school_diary.model.authentication.AuthenticationResponseBean;
import com.ditsov.school_diary.model.user.BasicUserResponseBean;
import io.swagger.annotations.Api;

@Api(tags = "Authentication APIs")
@RestController
public class AuthenticationController {

  @Autowired private AuthenticationControllerHelper authenticationControllerHelper;

  @PostMapping("/authenticate")
  public AuthenticationResponseBean login(@RequestBody @Valid final AuthenticationRequestBean login)
      throws Exception {
    return authenticationControllerHelper.login(login);
  }

  @GetMapping("/authenticated-user")
  public BasicUserResponseBean getAuthenticatedUser() {
    return authenticationControllerHelper.getAuthenticatedUser();
  }
}
