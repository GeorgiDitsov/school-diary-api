package com.ditsov.school_diary.core.service.teacher.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.ditsov.school_diary.core.entity.teacher.Teacher;
import com.ditsov.school_diary.core.repository.teacher.TeacherRepository;
import com.ditsov.school_diary.core.service.AbstractService;
import com.ditsov.school_diary.core.service.teacher.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

  @Autowired private TeacherRepository teacherRepository;

  /** @see AbstractService#getAll() */
  @Override
  public List<Teacher> getAll() {
    return teacherRepository.findAll();
  }

  /** @see AbstractService#getById(Object) */
  @Override
  public Teacher getById(final Long id) {
    return teacherRepository.getById(id);
  }

  /** @see AbstractService#save(Object) */
  @Override
  public void save(final Teacher entity) {
    teacherRepository.save(entity);
  }

  /** @see AbstractService#deleteById(Object) */
  @Override
  public void deleteById(final Long id) {
    teacherRepository.deleteById(id);
  }

  /** @see TeacherService#getByOrderByFullName(int, int) */
  @Override
  public Page<Teacher> getByOrderByFullName(final int page, final int size) {
    return teacherRepository.findAll(PageRequest.of(page, size, Sort.by("firstName", "lastName")));
  }

  /** @see TeacherService#getAllByOrderByFullName() */
  @Override
  public List<Teacher> getAllByOrderByFullName() {
    return teacherRepository.findAll(Sort.by("firstName", "lastName"));
  }
}
