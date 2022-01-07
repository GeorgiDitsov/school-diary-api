package com.ditsov.school_diary.core.service.school.group.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.ditsov.school_diary.core.entity.school.group.SchoolGroup;
import com.ditsov.school_diary.core.repository.school.group.SchoolGroupRepository;
import com.ditsov.school_diary.core.service.AbstractService;
import com.ditsov.school_diary.core.service.school.group.SchoolGroupService;

@Service
public class SchoolGroupServiceImpl implements SchoolGroupService {

  @Autowired private SchoolGroupRepository schoolGroupRepository;

  /** @see AbstractService#getAll() */
  @Override
  public List<SchoolGroup> getAll() {
    return schoolGroupRepository.findAll();
  }

  /** @see AbstractService#getById(Object) */
  @Override
  public SchoolGroup getById(final Long id) {
    return schoolGroupRepository.getById(id);
  }

  /** @see AbstractService#save(Object) */
  @Override
  public void save(final SchoolGroup entity) {
    schoolGroupRepository.save(entity);
  }

  /** @see AbstractService#deleteById(Object) */
  @Override
  public void deleteById(final Long id) {
    schoolGroupRepository.deleteById(id);
  }

  /** @see SchoolGroupService#getByOrderByName(int, int) */
  @Override
  public List<SchoolGroup> getByOrderByName(final int page, final int size) {
    return schoolGroupRepository
        .findAll(PageRequest.of(page, size, Sort.by("year", "index")))
        .toList();
  }
}
