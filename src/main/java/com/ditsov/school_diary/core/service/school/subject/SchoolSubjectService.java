package com.ditsov.school_diary.core.service.school.subject;

import java.util.List;
import com.ditsov.school_diary.core.entity.school.subject.SchoolSubject;
import com.ditsov.school_diary.core.service.AbstractService;

public interface SchoolSubjectService extends AbstractService<SchoolSubject, Long> {

  /**
   * Retrieves school subjects ordered by name.
   *
   * @param page
   * @param size
   * @return
   */
  List<SchoolSubject> getByOrderByName(final int page, final int size);

  /**
   * Retrieves all school subjects ordered by name.
   *
   * @return
   */
  List<SchoolSubject> getAllByOrderByName();
}
