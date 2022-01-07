package com.ditsov.school_diary.core.service.teacher;

import java.util.List;
import com.ditsov.school_diary.core.entity.teacher.Teacher;
import com.ditsov.school_diary.core.service.AbstractService;

public interface TeacherService extends AbstractService<Teacher, Long> {

  /**
   * Retrieves teachers ordered by full name.
   *
   * @param page
   * @param size
   * @return
   */
  List<Teacher> getByOrderByFullName(final int page, final int size);

  /**
   * Retrieves all teachers ordered by full name.
   *
   * @return
   */
  List<Teacher> getAllByOrderByFullName();
}
