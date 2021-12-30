package com.ditsov.school_diary.core.factory.user;

import com.ditsov.school_diary.core.entity.user.User;
import com.ditsov.school_diary.model.user.BasicUserResponseBean;
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
   * Converts an {@link UpdateUserRequestBean} into an {@link User}.
   *
   * @param bean
   * @return
   */
  User convertUpdateUserRequestBeanToUser(final UpdateUserRequestBean bean);
}
