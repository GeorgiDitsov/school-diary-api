package com.ditsov.school_diary.core.service.school.year.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.ditsov.school_diary.core.entity.school.year.SchoolYear;
import com.ditsov.school_diary.core.repository.school.year.SchoolYearRepository;
import com.ditsov.school_diary.core.service.AbstractService;
import com.ditsov.school_diary.core.service.school.year.SchoolYearService;

@Service
public class SchoolYearServiceImpl implements SchoolYearService {

  @Autowired private SchoolYearRepository schoolYearRepository;

  /** @see AbstractService#getAll() */
  @Override
  public List<SchoolYear> getAll() {
    return schoolYearRepository.findAll();
  }

  /** @see AbstractService#getById(Object) */
  @Override
  public SchoolYear getById(final Long id) {
    return schoolYearRepository.getById(id);
  }

  /** @see AbstractService#save(Object) */
  @Override
  public void save(final SchoolYear entity) {
    schoolYearRepository.save(entity);
  }

  /** @see AbstractService#deleteById(Object) */
  @Override
  public void deleteById(final Long id) {
    schoolYearRepository.deleteById(id);
  }

  /** @see SchoolYearService#getByOrderByStartDateDesc(int, int) */
  @Override
  public List<SchoolYear> getByOrderByStartDateDesc(final int page, final int size) {
    return schoolYearRepository
        .findAll(PageRequest.of(page, size, Sort.by(Direction.DESC, "startDate")))
        .toList();
  }

  /** @see SchoolYearService#getAllByOrderByStartDateDesc() */
  @Override
  public List<SchoolYear> getAllByOrderByStartDateDesc() {
    return schoolYearRepository.findAll(Sort.by(Direction.DESC, "startDate"));
  }
}
