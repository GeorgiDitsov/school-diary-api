package com.ditsov.school_diary.core.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.ditsov.school_diary.core.entity.school.subject.SchoolSubject;
import com.ditsov.school_diary.core.entity.teacher.Teacher;
import com.ditsov.school_diary.core.service.school.subject.SchoolSubjectService;
import com.ditsov.school_diary.core.service.teacher.TeacherService;
import com.ditsov.school_diary.core.validator.constraint.SchoolCourse;
import com.ditsov.school_diary.model.school.course.SchoolCourseRequestBean;

public class SchoolCourseValidator
    implements ConstraintValidator<SchoolCourse, SchoolCourseRequestBean> {

  private boolean nullable;

  @Autowired private TeacherService teacherService;

  @Autowired private SchoolSubjectService schoolSubjectService;

  @Override
  public void initialize(SchoolCourse constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
    this.nullable = constraintAnnotation.nullable();
  }

  @Override
  public boolean isValid(SchoolCourseRequestBean value, ConstraintValidatorContext context) {
    return nullable && (value.getTeacher() == null || value.getSubject() == null)
        ? true
        : isValid(value);
  }

  /**
   * Valid {@link SchoolCourseRequestBean} means there is a relation between:
   *
   * <ul>
   *   <li>{@link SchoolCourseRequestBean#getTeacher()}
   *   <li>{@link SchoolCourseRequestBean#getSubject()}
   * </ul>
   *
   * @param schoolCourseBean
   * @return
   */
  private boolean isValid(final SchoolCourseRequestBean schoolCourseBean) {
    Teacher teacher = teacherService.getById(schoolCourseBean.getTeacher().getValue());
    SchoolSubject schoolSubject =
        schoolSubjectService.getById(schoolCourseBean.getSubject().getValue());

    return teacher.getSchoolSubjects().contains(schoolSubject);
  }
}
