package com.ditsov.school_diary.core.service.grade;

import java.util.List;
import org.springframework.data.domain.Page;
import com.ditsov.school_diary.core.entity.grade.Grade;
import com.ditsov.school_diary.core.service.AbstractService;
import com.ditsov.school_diary.model.grade.CreateGradeRequestBean;
import com.ditsov.school_diary.model.grade.GradeStatistics;

public interface GradeService extends AbstractService<Grade, Long> {

  /**
   * Retrieves a {@link Page} of grades ordered by updated at date.
   *
   * @param page
   * @param size
   * @return
   */
  Page<Grade> getByOrderByUpdatedAtDesc(final int page, final int size);

  /**
   * Retrieves all grades by school course.
   *
   * @param schoolCourseId
   * @return
   */
  List<Grade> getAllBySchoolCourseId(final Long schoolSemesterId);

  /**
   * Creates and saves a new grade.
   *
   * @param gradeBean
   */
  void createGrade(final CreateGradeRequestBean gradeBean);

  /**
   * Retrieves grades statistics by student id.
   *
   * @param studentId
   * @return
   */
  List<GradeStatistics> getGradesStatisticsByStudentId(final Long studentId);

  /**
   * Retrieves grades statistics by school course id.
   *
   * @param schoolCourseId
   * @return
   */
  List<GradeStatistics> getGradesStatisticsBySchoolCourseId(final Long schoolCourseId);
}
