package com.ditsov.school_diary.core.service.user;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.ditsov.school_diary.core.entity.user.User;

public interface UserService extends UserDetailsService {

  /**
   * Retrieves all users ordered by username.
   *
   * @param page
   * @param size
   * @return
   */
  List<User> getAllUsersOrderByUsername(final int page, final int size);

  /**
   * Retrieves user by id.
   *
   * @param id
   * @return
   */
  User getUserById(final Long id);

  /**
   * Retrieves user by username.
   *
   * @param username
   * @return
   */
  User getUserByUsername(final String username);

  /**
   * Saves user.
   *
   * @param user
   * @return
   */
  User saveUser(final User user);
}
