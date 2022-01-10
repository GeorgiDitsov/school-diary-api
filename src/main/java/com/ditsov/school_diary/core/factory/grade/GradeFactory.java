package com.ditsov.school_diary.core.factory.grade;

import com.ditsov.school_diary.core.entity.grade.Grade;
import com.ditsov.school_diary.core.entity.school.course.SchoolCourse;
import com.ditsov.school_diary.core.entity.student.Student;
import com.ditsov.school_diary.core.entity.teacher.Teacher;
import com.ditsov.school_diary.core.factory.AbstractFactory;
import com.ditsov.school_diary.model.grade.GradeResponseBean;

public interface GradeFactory extends AbstractFactory<GradeResponseBean, Grade> {

  /**
   * Creates an entity of type {@link Grade} with the given as parameters fields.
   *
   * @param value
   * @param student
   * @param schoolCourse
   * @param teacher
   * @return
   */
  Grade createGrade(
      final Double value,
      final Student student,
      final SchoolCourse schoolCourse,
      final Teacher teacher);

  /**
   * Populates an entity of type {@link Grade}.
   *
   * @param grade
   * @param value
   * @param teacher
   */
  void populateGrade(final Grade grade, final Double value, final Teacher teacher);
}
