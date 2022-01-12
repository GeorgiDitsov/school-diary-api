package com.ditsov.school_diary.core.factory.grade.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.entity.grade.Grade;
import com.ditsov.school_diary.core.entity.school.course.SchoolCourse;
import com.ditsov.school_diary.core.entity.student.Student;
import com.ditsov.school_diary.core.entity.teacher.Teacher;
import com.ditsov.school_diary.core.factory.AbstractFactory;
import com.ditsov.school_diary.core.factory.common.LabeledValueBeanFactory;
import com.ditsov.school_diary.core.factory.grade.GradeFactory;
import com.ditsov.school_diary.model.grade.GradeResponseBean;

@Component
public class GradeFactoryImpl implements GradeFactory {

  @Autowired private LabeledValueBeanFactory labeledValueBeanFactory;

  /** @see AbstractFactory#convertToResponseBean(Object) */
  @Override
  public GradeResponseBean convertToResponseBean(final Grade entity) {
    GradeResponseBean bean = new GradeResponseBean();

    bean.setId(entity.getId());
    bean.setValue(entity.getValue().setScale(2, RoundingMode.HALF_UP));
    bean.setCreatedAt(entity.getCreatedAt());
    bean.setUpdatedAt(entity.getUpdatedAt());
    bean.setStudent(
        labeledValueBeanFactory.convertPersonToAnonLabeledValueBean(entity.getStudent()));
    bean.setSubject(
        labeledValueBeanFactory.convertSchoolSubjectToLabeledValueBean(
            entity.getSchoolCourse().getSchoolSubject()));
    bean.setTeacher(
        labeledValueBeanFactory.convertPersonToAnonLabeledValueBean(entity.getUpdatedBy()));

    return bean;
  }

  /** @see GradeFactory#createGrade(BigDecimal, Student, SchoolCourse, Teacher) */
  @Override
  public Grade createGrade(
      final BigDecimal value,
      final Student student,
      final SchoolCourse schoolCourse,
      final Teacher teacher) {
    Grade grade = new Grade();

    grade.setValue(value);
    grade.setStudent(student);
    grade.setSchoolCourse(schoolCourse);
    grade.setCreatedBy(teacher);
    grade.setUpdatedBy(teacher);

    return grade;
  }

  /** @see GradeFactory#populateGrade(Grade, BigDecimal, Teacher) */
  @Override
  public void populateGrade(final Grade grade, final BigDecimal value, final Teacher teacher) {
    grade.setValue(value);
    grade.setUpdatedBy(teacher);
  }
}
