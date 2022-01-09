package com.ditsov.school_diary.core.service.grade.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.ditsov.school_diary.core.entity.grade.Grade;
import com.ditsov.school_diary.core.repository.grade.GradeRepository;
import com.ditsov.school_diary.core.service.AbstractService;
import com.ditsov.school_diary.core.service.grade.GradeService;

@Service
public class GradeServiceImpl implements GradeService {

  @Autowired private GradeRepository gradeRepository;

  /** @see AbstractService#getAll() */
  @Override
  public List<Grade> getAll() {
    return gradeRepository.findAll();
  }

  /** @see AbstractService#getById(Object) */
  @Override
  public Grade getById(final Long id) {
    return gradeRepository.getById(id);
  }

  /** @see AbstractService#save(Object) */
  @Override
  public void save(final Grade entity) {
    gradeRepository.save(entity);
  }

  /** @see AbstractService#deleteById(Object) */
  @Override
  public void deleteById(final Long id) {
    gradeRepository.deleteById(id);
  }

  /** @see GradeService#getByOrderByUpdatedAtDesc(int, int) */
  @Override
  public Page<Grade> getByOrderByUpdatedAtDesc(final int page, final int size) {
    return gradeRepository.findAll(
        PageRequest.of(page, size, Sort.by(Direction.DESC, "updatedAt")));
  }

  /** @see GradeService#getByStudentIdAndSchoolCourseId(Long, Long, int, int) */
  @Override
  public Page<Grade> getByStudentIdAndSchoolCourseId(
      final Long studentId, final Long courseId, final int page, final int size) {
    return gradeRepository.findAllByStudentIdAndSchoolCourseId(
        studentId, courseId, PageRequest.of(page, size, Sort.by(Direction.DESC, "updatedAt")));
  }
}
