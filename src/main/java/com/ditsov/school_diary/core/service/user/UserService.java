package com.ditsov.school_diary.core.service.user;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.ditsov.school_diary.core.entity.user.User;
import com.ditsov.school_diary.core.service.AbstractService;

public interface UserService extends AbstractService<User, Long>, UserDetailsService {

  /**
   * Retrieves users ordered by username.
   *
   * @param page
   * @param size
   * @return
   */
  List<User> getByOrderByUsername(final int page, final int size);

  /**
   * Retrieves user by username.
   *
   * @param username
   * @return
   */
  User getByUsername(final String username);
}
