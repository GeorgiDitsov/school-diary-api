package com.ditsov.school_diary.core.service.teacher;

import java.util.List;
import org.springframework.data.domain.Page;
import com.ditsov.school_diary.core.entity.teacher.Teacher;
import com.ditsov.school_diary.core.service.AbstractService;

public interface TeacherService extends AbstractService<Teacher, Long> {

  /**
   * Retrieves a {@link Page} of teachers ordered by full name.
   *
   * @param page
   * @param size
   * @return
   */
  Page<Teacher> getByOrderByFullName(final int page, final int size);

  /**
   * Retrieves a {@link Page} of teachers by user id.
   *
   * @param userId
   * @return
   */
  Teacher getByUserId(final Long userId);

  /**
   * Retrieves all teachers ordered by full name.
   *
   * @return
   */
  List<Teacher> getAllByOrderByFullName();
}
