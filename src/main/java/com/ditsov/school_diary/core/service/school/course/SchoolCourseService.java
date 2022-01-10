package com.ditsov.school_diary.core.service.school.course;

import java.util.List;
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

  /**
   * Retrieves all school courses by teacher id and school semester id.
   *
   * @param teacherId
   * @param schoolSemesterId
   * @return
   */
  List<SchoolCourse> getAllByTeacherIdAndSchoolSemesterId(final Long teacherId, final Long schoolSemesterId);

  /**
   * Retrieves all school courses by school group and school semester id.
   *
   * @param schoolGroupId
   * @param schoolSemesterId
   * @return
   */
  List<SchoolCourse> getAllBySchoolGroupIdAndSchoolSemesterId(
      final Long schoolGroupId, final Long schoolSemesterId);
}
