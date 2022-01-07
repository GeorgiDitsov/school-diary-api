package com.ditsov.school_diary.core.factory.teacher;

import com.ditsov.school_diary.core.entity.role.Role;
import com.ditsov.school_diary.core.entity.teacher.Teacher;
import com.ditsov.school_diary.model.teacher.CreateTeacherRequestBean;
import com.ditsov.school_diary.model.teacher.TeacherResponseBean;
import com.ditsov.school_diary.model.teacher.UpdateTeacherRequestBean;

public interface TeacherFactory {

  /**
   * Creates an entity of type {@link Teacher} with the given as parameters fields.
   *
   * @param id
   * @return
   */
  Teacher createTeacher(final Long id);

  /**
   * Converts an entity of type {@link Teacher} into a {@link TeacherResponseBean}.
   *
   * @param teacher
   * @return
   */
  TeacherResponseBean convertTeacherToTeacherResponseBean(final Teacher teacher);

  /**
   * Converts a {@link CreateTeacherRequestBean} into an entity of type {@link Teacher}.
   *
   * @param teacherBean
   * @param roles
   * @return
   */
  Teacher convertCreateTeacherRequestBeanToTeacher(
      final CreateTeacherRequestBean teacherBean, final Role... roles);

  /**
   * Populates a {@link Teacher} with an {@link UpdateTeacherRequestBean}.
   *
   * @param teacher
   * @param teacherBean
   */
  void populateTeacher(final Teacher teacher, final UpdateTeacherRequestBean teacherBean);
}
