package com.ditsov.school_diary.core.service.user;

import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.ditsov.school_diary.core.entity.user.User;
import com.ditsov.school_diary.core.service.AbstractService;

public interface UserService extends AbstractService<User, Long>, UserDetailsService {

  /**
   * Retrieves a {@link Page} of users ordered by username.
   *
   * @param page
   * @param size
   * @return
   */
  Page<User> getByOrderByUsername(final int page, final int size);

  /**
   * Retrieves user by username.
   *
   * @param username
   * @return
   */
  User getByUsername(final String username);
}
