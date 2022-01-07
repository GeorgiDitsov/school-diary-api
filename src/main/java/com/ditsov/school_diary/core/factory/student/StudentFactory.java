package com.ditsov.school_diary.core.factory.student;

import com.ditsov.school_diary.core.entity.role.Role;
import com.ditsov.school_diary.core.entity.student.Student;
import com.ditsov.school_diary.model.student.CreateStudentRequestBean;
import com.ditsov.school_diary.model.student.StudentResponseBean;
import com.ditsov.school_diary.model.student.UpdateStudentRequestBean;

public interface StudentFactory {

  /**
   * Converts an entity of type {@link Student} into {@link StudentResponseBean}.
   *
   * @param student
   * @return
   */
  StudentResponseBean convertStudentToStudentResponseBean(final Student student);

  /**
   * Converts a {@link CreateStudentRequestBean} into a {@link Student}.
   *
   * @param bean
   * @param roles
   * @return
   */
  Student convertCreateStudentRequestBeanToStudent(
      final CreateStudentRequestBean bean, final Role... roles);

  /**
   * Populates a {@link Student} with {@link UpdateStudentRequestBean}.
   *
   * @param student
   * @param bean
   */
  void populateStudent(final Student student, final UpdateStudentRequestBean bean);
}
