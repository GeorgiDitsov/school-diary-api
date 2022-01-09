package com.ditsov.school_diary.core.service.student.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.ditsov.school_diary.core.entity.student.Student;
import com.ditsov.school_diary.core.repository.student.StudentRepository;
import com.ditsov.school_diary.core.service.AbstractService;
import com.ditsov.school_diary.core.service.student.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired private StudentRepository studentRepository;

  /** @see AbstractService#getAll() */
  @Override
  public List<Student> getAll() {
    return studentRepository.findAll();
  }

  /** @see AbstractService#getById(Object) */
  @Override
  public Student getById(final Long id) {
    return studentRepository.getById(id);
  }

  /** @see AbstractService#save(Object) */
  @Override
  public void save(final Student entity) {
    studentRepository.save(entity);
  }

  /** @see AbstractService#deleteById(Object) */
  @Override
  public void deleteById(final Long id) {
    studentRepository.deleteById(id);
  }

  /** @see StudentService#getByOrderByFullName(int, int) */
  @Override
  public Page<Student> getByOrderByFullName(final int page, final int size) {
    return studentRepository.findAll(PageRequest.of(page, size, Sort.by("firstName", "lastName")));
  }

  /** @see StudentService#getAllByOrderByFullName() */
  @Override
  public List<Student> getAllByOrderByFullName() {
    return studentRepository.findAll(Sort.by("firstName", "lastName"));
  }
}
