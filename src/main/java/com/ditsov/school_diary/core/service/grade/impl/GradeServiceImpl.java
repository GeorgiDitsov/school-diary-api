package com.ditsov.school_diary.core.service.grade.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
import com.ditsov.school_diary.model.grade.GradeStatistics;

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

  /** @see GradeService#getAllBySchoolCourseId(Long) */
  @Override
  public List<Grade> getAllBySchoolCourseId(final Long schoolCourseId) {
    return gradeRepository.findAllBySchoolCourseIdOrderByUpdatedAtDesc(schoolCourseId);
  }

  /** @see GradeService#getAllByStudentIdAndSchoolSemesterId(Long, Long) */
  @Override
  public List<Grade> getAllByStudentIdAndSchoolSemesterId(
      final Long studentId, final Long schoolSemesterId) {
    return gradeRepository.findAllByStudentIdAndSchoolCourseSchoolSemesterIdOrderByUpdatedAtDesc(
        studentId, schoolSemesterId);
  }

  /** @see GradeService#getGradesStatisticsByStudentId(Long) */
  @Override
  public List<GradeStatistics> getGradesStatisticsByStudentId(final Long studentId) {
    return gradeRepository.findGradeStatisticsByStudentId(studentId);
  }

  /** @see GradeService#getGradesStatisticsBySchoolCourseId(Long) */
  @Override
  public List<GradeStatistics> getGradesStatisticsBySchoolCourseId(final Long schoolCourseId) {
    return gradeRepository.findGradeStatisticsBySchoolCourseId(schoolCourseId);
  }

  /** @see GradeService#getSuccessBySchoolCourseId(Long) */
  @Override
  public BigDecimal getSuccessBySchoolCourseId(final Long schoolCourseId) {
    return gradeRepository
        .getSuccessBySchoolCourseId(schoolCourseId)
        .map(success -> success.setScale(2, RoundingMode.HALF_UP))
        .orElse(BigDecimal.ZERO);
  }

  /** @see GradeService#getSuccessByStudentIdAndSchooCourseId(Long, Long) */
  @Override
  public BigDecimal getSuccessByStudentIdAndSchooCourseId(
      final Long studentId, final Long schoolCourseId) {
    return gradeRepository
        .getSuccessByStudentIdAndSchoolCourseId(studentId, schoolCourseId)
        .map(success -> success.setScale(2, RoundingMode.HALF_UP))
        .orElse(BigDecimal.ZERO);
  }

  /** @see GradeService#getSuccessByStudentIdAndSchoolSemesterId(Long, Long) */
  @Override
  public BigDecimal getSuccessByStudentIdAndSchoolSemesterId(
      final Long studentId, final Long schoolSemesterId) {
    return gradeRepository
        .getSuccessByStudentIdAndSchoolSemesterId(studentId, schoolSemesterId)
        .map(success -> success.setScale(2, RoundingMode.HALF_UP))
        .orElse(BigDecimal.ZERO);
  }

  /** @see GradeService#delete(Grade) */
  @Override
  public void delete(final Grade grade) {
    gradeRepository.delete(grade);
  }
}
