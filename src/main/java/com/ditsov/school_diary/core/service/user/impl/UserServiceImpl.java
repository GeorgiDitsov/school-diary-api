package com.ditsov.school_diary.core.service.user.impl;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.ditsov.school_diary.core.entity.user.User;
import com.ditsov.school_diary.core.repository.user.UserRepository;
import com.ditsov.school_diary.core.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Autowired private UserRepository userRepository;

  /** @see UserDetailsService#loadUserByUsername(String) */
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository
        .findByUsername(username)
        .orElseThrow(
            () -> new UsernameNotFoundException(String.format("User: %s, not found.", username)));
  }

  /** @see UserService#getAllUsersOrderByUsername(int, int) */
  @Override
  public List<User> getAllUsersOrderByUsername(final int page, final int size) {
    return userRepository.findAll(PageRequest.of(page, size, Sort.by("username"))).toList();
  }

  /** @see UserService#getUserById(Long) */
  @Override
  public User getUserById(final Long id) {
    return userRepository.getById(id);
  }

  /** @see UserService#getUserByUsername(String) */
  @Override
  public User getUserByUsername(final String username) {
    return userRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new);
  }
}
