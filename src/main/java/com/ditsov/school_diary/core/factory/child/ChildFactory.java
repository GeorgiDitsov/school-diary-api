package com.ditsov.school_diary.core.factory.child;

import com.ditsov.school_diary.core.entity.student.Student;
import com.ditsov.school_diary.model.child.ChildResponseBean;

public interface ChildFactory {

  /**
   * Converts an entity of type {@link Student} into a {@link ChildResponseBean}.
   *
   * @param student
   * @return
   */
  ChildResponseBean convertStudentToChildResponseBean(final Student student);
}
