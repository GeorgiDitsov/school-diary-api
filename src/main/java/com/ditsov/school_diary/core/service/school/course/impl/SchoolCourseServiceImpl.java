package com.ditsov.school_diary.core.service.school.course.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.ditsov.school_diary.core.entity.school.course.SchoolCourse;
import com.ditsov.school_diary.core.repository.school.course.SchoolCourseRepository;
import com.ditsov.school_diary.core.service.AbstractService;
import com.ditsov.school_diary.core.service.school.course.SchoolCourseService;

@Service
public class SchoolCourseServiceImpl implements SchoolCourseService {

  @Autowired private SchoolCourseRepository schoolCourseRepository;

  /** @see AbstractService#getAll() */
  @Override
  public List<SchoolCourse> getAll() {
    return schoolCourseRepository.findAll();
  }

  /** @see AbstractService#getById(Object) */
  @Override
  public SchoolCourse getById(final Long id) {
    return schoolCourseRepository.getById(id);
  }

  /** @see AbstractService#save(Object) */
  @Override
  public void save(final SchoolCourse entity) {
    schoolCourseRepository.save(entity);
  }

  /** @see AbstractService#deleteById(Object) */
  @Override
  public void deleteById(final Long id) {
    schoolCourseRepository.deleteById(id);
  }

  /** @see SchoolCourseService#getByOrderByIdDesc(int, int) */
  @Override
  public Page<SchoolCourse> getByOrderByIdDesc(final int page, final int size) {
    return schoolCourseRepository.findAll(
        PageRequest.of(page, size, Sort.by(Direction.DESC, "id")));
  }
}
