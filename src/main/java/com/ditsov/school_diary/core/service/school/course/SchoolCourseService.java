package com.ditsov.school_diary.core.service.school.course;

import java.util.List;
import com.ditsov.school_diary.core.entity.school.course.SchoolCourse;
import com.ditsov.school_diary.core.service.AbstractService;

public interface SchoolCourseService extends AbstractService<SchoolCourse, Long> {

  /**
   * Retrieves school courses ordered by id in descending order.
   *
   * @param page
   * @param size
   * @return
   */
  List<SchoolCourse> getByOrderByIdDesc(final int page, final int size);
}
