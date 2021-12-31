package com.ditsov.school_diary.core.service.student;

import java.util.List;
import com.ditsov.school_diary.core.entity.student.Student;

public interface StudentService {

  /**
   * Retrieves all students ordered by full name.
   *
   * @param page
   * @param size
   * @return
   */
  List<Student> getAllStudentsOrderByFullName(final int page, final int size);
}
