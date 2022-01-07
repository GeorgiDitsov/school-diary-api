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
import com.ditsov.school_diary.core.service.AbstractService;
import com.ditsov.school_diary.core.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Autowired private UserRepository userRepository;

  /** @see AbstractService#getAll() */
  @Override
  public List<User> getAll() {
    return userRepository.findAll();
  }

  /** @see AbstractService#getById(Object) */
  @Override
  public User getById(final Long id) {
    return userRepository.getById(id);
  }

  /** @see AbstractService#save(Object) */
  @Override
  public void save(final User entity) {
    userRepository.save(entity);
  }

  /** @see AbstractService#deleteById(Object) */
  @Override
  public void deleteById(final Long id) {
    userRepository.deleteById(id);
  }

  /** @see UserDetailsService#loadUserByUsername(String) */
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository
        .findByUsername(username)
        .orElseThrow(
            () -> new UsernameNotFoundException(String.format("User: %s, not found.", username)));
  }

  /** @see UserService#getByOrderByUsername(int, int) */
  @Override
  public List<User> getByOrderByUsername(final int page, final int size) {
    return userRepository.findAll(PageRequest.of(page, size, Sort.by("username"))).toList();
  }

  /** @see UserService#getByUsername(String) */
  @Override
  public User getByUsername(final String username) {
    return userRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new);
  }
}
