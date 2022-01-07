package com.ditsov.school_diary.core.service.grade;

import java.util.List;
import com.ditsov.school_diary.core.entity.grade.Grade;
import com.ditsov.school_diary.core.service.AbstractService;

public interface GradeService extends AbstractService<Grade, Long> {

  /**
   * Retrieves grades ordered by updated at date.
   *
   * @param page
   * @param size
   * @return
   */
  List<Grade> getByOrderByUpdatedAtDesc(final int page, final int size);

  /**
   * Retrieves grades by student and school course.
   *
   * @param studentId
   * @param courseId
   * @return
   */
  List<Grade> getByStudentIdAndSchoolCourseId(final Long studentId, final Long courseId);
}
