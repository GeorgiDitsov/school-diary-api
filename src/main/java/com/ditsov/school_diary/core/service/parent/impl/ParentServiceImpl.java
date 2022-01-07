package com.ditsov.school_diary.core.service.parent.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.ditsov.school_diary.core.entity.parent.Parent;
import com.ditsov.school_diary.core.repository.parent.ParentRepository;
import com.ditsov.school_diary.core.service.AbstractService;
import com.ditsov.school_diary.core.service.parent.ParentService;

@Service
public class ParentServiceImpl implements ParentService {

  @Autowired private ParentRepository parentRepository;

  /** @see AbstractService#getAll() */
  @Override
  public List<Parent> getAll() {
    return parentRepository.findAll();
  }

  /** @see AbstractService#getById(Object) */
  @Override
  public Parent getById(final Long id) {
    return parentRepository.getById(id);
  }

  /** @see AbstractService#save(Object) */
  @Override
  public void save(final Parent entity) {
    parentRepository.save(entity);
  }

  /** @see AbstractService#deleteById(Object) */
  @Override
  public void deleteById(final Long id) {
    parentRepository.deleteById(id);
  }

  /** @see ParentService#getByOrderByFullName(int, int) */
  @Override
  public List<Parent> getByOrderByFullName(final int page, final int size) {
    return parentRepository
        .findAll(PageRequest.of(page, size, Sort.by("firstName", "lastName")))
        .toList();
  }

  /** @see ParentService#getAllByOrderByFullName() */
  @Override
  public List<Parent> getAllByOrderByFullName() {
    return parentRepository.findAll(Sort.by("firstName", "lastName"));
  }
}
