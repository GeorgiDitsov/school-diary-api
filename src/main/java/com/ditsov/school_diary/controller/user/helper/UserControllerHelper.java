package com.ditsov.school_diary.controller.user.helper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.entity.user.User;
import com.ditsov.school_diary.core.factory.user.UserFactory;
import com.ditsov.school_diary.core.service.user.UserService;
import com.ditsov.school_diary.model.user.BasicUserResponseBean;
import com.ditsov.school_diary.model.user.UpdateUserRequestBean;

@Component
public class UserControllerHelper {

  @Autowired private UserService userService;

  @Autowired private UserFactory userFactory;

  public List<BasicUserResponseBean> listAllUsers(
      final Optional<Integer> page, final Optional<Integer> size) {
    List<User> users = userService.getAllUsersOrderByUsername(page.orElse(0), size.orElse(10));

    return users
        .stream()
        .map(userFactory::convertUserToBasicUserResponseBean)
        .collect(Collectors.toList());
  }

  public BasicUserResponseBean getUser(final Long userId) {
    User user = userService.getUserById(userId);

    return userFactory.convertUserToBasicUserResponseBean(user);
  }

  public BasicUserResponseBean updateUser(
      final Long userId, final UpdateUserRequestBean userRequestBean) {
    User user = userService.getUserById(userId);

    return null;
  }
}
