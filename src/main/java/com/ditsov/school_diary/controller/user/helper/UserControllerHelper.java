package com.ditsov.school_diary.controller.user.helper;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.entity.user.User;
import com.ditsov.school_diary.core.factory.common.PageableBeanFactory;
import com.ditsov.school_diary.core.factory.user.UserFactory;
import com.ditsov.school_diary.core.service.user.UserService;
import com.ditsov.school_diary.model.common.PageableBean;
import com.ditsov.school_diary.model.user.BasicUserResponseBean;
import com.ditsov.school_diary.model.user.UpdateUserRequestBean;

@Component
public class UserControllerHelper {

  @Autowired private UserService userService;

  @Autowired private PageableBeanFactory pageableBeanFactory;

  @Autowired private UserFactory userFactory;

  public PageableBean<BasicUserResponseBean> getPageOfUsers(
      final Optional<Integer> page, final Optional<Integer> size) {
    Page<User> users = userService.getByOrderByUsername(page.orElse(0), size.orElse(10));

    return pageableBeanFactory.create(users, userFactory);
  }

  public BasicUserResponseBean getUser(final Long userId) {
    User user = userService.getById(userId);

    return userFactory.convertToResponseBean(user);
  }

  public void updateUser(final Long userId, final UpdateUserRequestBean userRequestBean) {
    User user = userService.getById(userId);

    userFactory.populateUser(user, userRequestBean);

    userService.save(user);
  }
}
