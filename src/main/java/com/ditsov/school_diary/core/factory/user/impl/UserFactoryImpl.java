package com.ditsov.school_diary.core.factory.user.impl;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.entity.role.Role;
import com.ditsov.school_diary.core.entity.user.User;
import com.ditsov.school_diary.core.factory.user.UserFactory;
import com.ditsov.school_diary.model.user.BasicUserResponseBean;
import com.ditsov.school_diary.model.user.CreateUserRequestBean;
import com.ditsov.school_diary.model.user.UpdateUserRequestBean;

@Component
public class UserFactoryImpl implements UserFactory {

  @Autowired private PasswordEncoder passwordEncoder;

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

  /** @see UserFactory#convertCreateUserRequestBeanToUser(CreateUserRequestBean, Role...) */
  @Override
  public User convertCreateUserRequestBeanToUser(
      final CreateUserRequestBean bean, final Role... roles) {
    User user = new User();

    user.setUsername(bean.getUsername());
    user.setEmail(bean.getEmail());
    user.setPassword(passwordEncoder.encode(bean.getPassword()));
    for (Role role : roles) {
      user.getRoles().add(role);
    }

    return user;
  }

  /** @see UserFactory#populateUser(User, UpdateUserRequestBean) */
  @Override
  public void populateUser(final User user, final UpdateUserRequestBean bean) {
    Optional.ofNullable(bean.getUsername()).ifPresent(user::setUsername);
    Optional.ofNullable(bean.getEmail()).ifPresent(user::setEmail);
    Optional.ofNullable(bean.getPassword())
        .ifPresent(password -> user.setPassword(passwordEncoder.encode(password)));
  }

  /** @see UserFactory#createUser(String, String, String, Collection) */
  @Override
  public User createUser(
      final String username,
      final String password,
      final String email,
      final Collection<Role> roles) {
    User user = new User();

    user.setUsername(username);
    user.setPassword(password);
    user.setEmail(email);
    user.setRoles(roles.stream().collect(Collectors.toSet()));

    return user;
  }
}
