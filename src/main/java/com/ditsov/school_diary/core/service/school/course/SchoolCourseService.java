package com.ditsov.school_diary.core.service.school.course;

import org.springframework.data.domain.Page;
import com.ditsov.school_diary.core.entity.school.course.SchoolCourse;
import com.ditsov.school_diary.core.service.AbstractService;

public interface SchoolCourseService extends AbstractService<SchoolCourse, Long> {

  /**
   * Retrieves a {@link Page} of school courses ordered by id in descending order.
   *
   * @param page
   * @param size
   * @return
   */
  Page<SchoolCourse> getByOrderByIdDesc(final int page, final int size);
}
