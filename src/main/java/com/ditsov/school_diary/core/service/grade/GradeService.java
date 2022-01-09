package com.ditsov.school_diary.core.service.grade;

import org.springframework.data.domain.Page;
import com.ditsov.school_diary.core.entity.grade.Grade;
import com.ditsov.school_diary.core.service.AbstractService;

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
   * Retrieves a {@link Page} of grades by student and school course.
   *
   * @param studentId
   * @param courseId
   * @param page
   * @param size
   * @return
   */
  Page<Grade> getByStudentIdAndSchoolCourseId(
      final Long studentId, final Long courseId, final int page, final int size);
}
