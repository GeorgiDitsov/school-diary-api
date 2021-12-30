package com.ditsov.school_diary.controller.user;

import java.util.List;
import java.util.Optional;
import javax.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ditsov.school_diary.controller.user.helper.UserControllerHelper;
import com.ditsov.school_diary.model.user.BasicUserResponseBean;
import com.ditsov.school_diary.model.user.UpdateUserRequestBean;
import io.swagger.annotations.Api;

@Api(tags = "User APIs")
@RestController
@RequestMapping("/v1/users")
public class UserController {

  @Autowired private UserControllerHelper userControllerHelper;

  @GetMapping
  @Secured("ROLE_ADMIN")
  public List<BasicUserResponseBean> listAllUsers(
      @RequestParam(required = false) @Min(0) final Optional<Integer> page,
      @RequestParam(required = false) @Min(1) final Optional<Integer> size) {
    return userControllerHelper.listAllUsers(page, size);
  }

  @GetMapping("/{id}")
  @Secured("ROLE_ADMIN")
  public BasicUserResponseBean getUser(@PathVariable(name = "id") @Min(1) final Long userId) {
    return userControllerHelper.getUser(userId);
  }

  @PatchMapping("/{id}")
  @Secured("ROLE_ADMIN")
  public BasicUserResponseBean updateUser(
      @PathVariable(name = "id") @Min(1) final Long userId,
      @RequestBody @Validated final UpdateUserRequestBean userRequestBean) {
    return userControllerHelper.updateUser(userId, userRequestBean);
  }
}
