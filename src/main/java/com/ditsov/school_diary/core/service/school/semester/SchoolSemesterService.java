package com.ditsov.school_diary.core.service.school.semester;

import java.util.List;
import com.ditsov.school_diary.core.entity.school.semester.SchoolSemester;
import com.ditsov.school_diary.core.service.AbstractService;

public interface SchoolSemesterService extends AbstractService<SchoolSemester, Long> {

  /**
   * Retrieves school semesters ordered by start date in descending order.
   *
   * @param page
   * @param size
   * @return
   */
  List<SchoolSemester> getByOrderByStartDateDesc(final int page, final int size);

  /**
   * Retrieves all school semesters ordered by start date in descending order.
   *
   * @return
   */
  List<SchoolSemester> getAllByOrderByStartDateDesc();
}
