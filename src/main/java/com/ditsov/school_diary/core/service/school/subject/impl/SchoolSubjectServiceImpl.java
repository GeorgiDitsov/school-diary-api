package com.ditsov.school_diary.core.service.school.subject.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.ditsov.school_diary.core.entity.school.subject.SchoolSubject;
import com.ditsov.school_diary.core.repository.school.subject.SchoolSubjectRepository;
import com.ditsov.school_diary.core.service.AbstractService;
import com.ditsov.school_diary.core.service.school.subject.SchoolSubjectService;

@Service
public class SchoolSubjectServiceImpl implements SchoolSubjectService {

  @Autowired private SchoolSubjectRepository schoolSubjectRepository;

  /** @see AbstractService#getAll() */
  @Override
  public List<SchoolSubject> getAll() {
    return schoolSubjectRepository.findAll(Sort.by("name"));
  }

  /** @see AbstractService#getById(Object) */
  @Override
  public SchoolSubject getById(final Long id) {
    return schoolSubjectRepository.getById(id);
  }

  /** @see AbstractService#save(Object) */
  @Override
  public void save(final SchoolSubject entity) {
    schoolSubjectRepository.save(entity);
  }

  /** @see AbstractService#deleteById(Object) */
  @Override
  public void deleteById(final Long id) {
    schoolSubjectRepository.deleteById(id);
  }

  /** @see SchoolSubjectService#getByOrderByName(int, int) */
  @Override
  public List<SchoolSubject> getByOrderByName(final int page, final int size) {
    return schoolSubjectRepository.findAll(PageRequest.of(page, size, Sort.by("name"))).toList();
  }

  /** @see SchoolSubjectService#getAllByOrderByName() */
  @Override
  public List<SchoolSubject> getAllByOrderByName() {
    return schoolSubjectRepository.findAll(Sort.by("name"));
  }
}
