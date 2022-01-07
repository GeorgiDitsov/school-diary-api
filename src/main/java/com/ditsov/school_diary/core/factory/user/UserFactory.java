package com.ditsov.school_diary.core.factory.user;

import java.util.Collection;
import com.ditsov.school_diary.core.entity.role.Role;
import com.ditsov.school_diary.core.entity.user.User;
import com.ditsov.school_diary.model.user.BasicUserResponseBean;
import com.ditsov.school_diary.model.user.CreateUserRequestBean;
import com.ditsov.school_diary.model.user.UpdateUserRequestBean;

public interface UserFactory {

  /**
   * Converts an {@link User} into a {@link BasicUserResponseBean}.
   *
   * @param user
   * @return
   */
  BasicUserResponseBean convertUserToBasicUserResponseBean(final User user);

  /**
   * Converts a {@link CreateUserRequestBean} into an {@link User} with assigned {@link Role}s.
   *
   * @param bean
   * @param roles
   * @return
   */
  User convertCreateUserRequestBeanToUser(final CreateUserRequestBean bean, final Role... roles);

  /**
   * Populates an {@link User} with {@link UpdateUserRequestBean}.
   *
   * @param user
   * @param bean
   */
  void populateUser(final User user, final UpdateUserRequestBean bean);

  /**
   * Creates an {@link User} by the given as parameters fields.
   *
   * @param username
   * @param password
   * @param email
   * @param roles
   * @return
   */
  User createUser(
      final String username,
      final String password,
      final String email,
      final Collection<Role> roles);
}
