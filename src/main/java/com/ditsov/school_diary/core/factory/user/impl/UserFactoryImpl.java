package com.ditsov.school_diary.core.factory.user.impl;

import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.entity.user.User;
import com.ditsov.school_diary.core.factory.user.UserFactory;
import com.ditsov.school_diary.model.user.BasicUserResponseBean;

@Component
public class UserFactoryImpl implements UserFactory {

  /** @see UserFactory#convertUserToBasicUserResponseBean(User) */
  @Override
  public BasicUserResponseBean convertUserToBasicUserResponseBean(final User user) {
    BasicUserResponseBean bean = new BasicUserResponseBean();

    bean.setId(user.getId());
    bean.setUsername(user.getUsername());
    bean.setEmail(user.getEmail());
    bean.setActive(user.getActive());
    bean.setRoles(
        user.getRoles()
            .stream()
            .map(role -> role.getName().getAuthority())
            .collect(Collectors.toList()));

    return bean;
  }
}
