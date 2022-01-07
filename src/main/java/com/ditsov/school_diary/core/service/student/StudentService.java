package com.ditsov.school_diary.core.service.student;

import java.util.List;
import com.ditsov.school_diary.core.entity.student.Student;
import com.ditsov.school_diary.core.service.AbstractService;

public interface StudentService extends AbstractService<Student, Long> {

  /**
   * Retrieves students ordered by full name.
   *
   * @param page
   * @param size
   * @return
   */
  List<Student> getByOrderByFullName(final int page, final int size);

  /**
   * Retrieves all students ordered by full name.
   *
   * @return
   */
  List<Student> getAllByOrderByFullName();
}
