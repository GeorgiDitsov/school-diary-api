package com.ditsov.school_diary.core.factory.school.course.impl;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.entity.school.course.SchoolCourse;
import com.ditsov.school_diary.core.factory.common.LabeledValueBeanFactory;
import com.ditsov.school_diary.core.factory.school.course.SchoolCourseFactory;
import com.ditsov.school_diary.core.factory.school.group.SchoolGroupFactory;
import com.ditsov.school_diary.core.factory.school.semester.SchoolSemesterFactory;
import com.ditsov.school_diary.core.factory.school.subject.SchoolSubjectFactory;
import com.ditsov.school_diary.core.factory.teacher.TeacherFactory;
import com.ditsov.school_diary.model.school.course.ExtendedSchoolCourseResponseBean;
import com.ditsov.school_diary.model.school.course.SchoolCourseRequestBean;
import com.ditsov.school_diary.model.school.course.SchoolCourseResponseBean;

@Component
public class SchoolCourseFactoryImpl implements SchoolCourseFactory {

  @Autowired private LabeledValueBeanFactory labeledValueBeanFactory;

  @Autowired private SchoolSubjectFactory schoolSubjectFactory;

  @Autowired private TeacherFactory teacherFactory;

  @Autowired private SchoolGroupFactory schoolGroupFactory;

  @Autowired private SchoolSemesterFactory schoolSemesterFactory;

  /** @see SchoolCourseFactory#convertToResponseBean(SchoolCourse) */
  @Override
  public SchoolCourseResponseBean convertToResponseBean(final SchoolCourse entity) {
    SchoolCourseResponseBean bean = new SchoolCourseResponseBean();

    populateSchoolCourseBean(bean, entity);

    return bean;
  }

  private void populateSchoolCourseBean(
      final SchoolCourseResponseBean bean, final SchoolCourse schoolCourse) {
    bean.setId(schoolCourse.getId());
    bean.setSubject(
        labeledValueBeanFactory.convertSchoolSubjectToLabeledValueBean(
            schoolCourse.getSchoolSubject()));
    bean.setTeacher(
        labeledValueBeanFactory.convertPersonToLabeledValueBean(schoolCourse.getTeacher()));
    bean.setGroup(
        labeledValueBeanFactory.convertSchoolGroupToLabeledValueBean(
            schoolCourse.getSchoolGroup()));
    bean.setSemester(
        labeledValueBeanFactory.convertSchoolSemesterToLabeledValueBean(
            schoolCourse.getSchoolSemester()));
  }

  /**
   * @see SchoolCourseFactory#convertSchoolCourseRequestBeanToSchoolCourse(SchoolCourseRequestBean)
   */
  @Override
  public SchoolCourse convertSchoolCourseRequestBeanToSchoolCourse(
      final SchoolCourseRequestBean bean) {
    return null;
  }

  /** @see SchoolCourseFactory#populateSchoolCourse(SchoolCourse, SchoolCourseRequestBean) */
  @Override
  public void populateSchoolCourse(
      final SchoolCourse schoolCourse, final SchoolCourseRequestBean bean) {
    if (bean.getSubject() != null) {
      schoolCourse.setSchoolSubject(
          schoolSubjectFactory.createSchoolSubject(
              bean.getSubject().getValue(), bean.getSubject().getLabel()));
    }

    if (bean.getTeacher() != null) {
      schoolCourse.setTeacher(teacherFactory.createTeacher(bean.getTeacher().getValue()));
    }

    if (bean.getGroup() != null) {
      schoolCourse.setSchoolGroup(schoolGroupFactory.createSchoolGroup(bean.getGroup().getValue()));
    }

    if (bean.getSemester() != null) {
      schoolCourse.setSchoolSemester(
          schoolSemesterFactory.createSchoolSemester(
              bean.getSemester().getValue(), bean.getSemester().getLabel()));
    }
  }

  /**
   * @see SchoolCourseFactory#convertSchoolCourseToExtendedSchoolCourseResponseBean(SchoolCourse,
   *     BigDecimal)
   */
  @Override
  public ExtendedSchoolCourseResponseBean convertSchoolCourseToExtendedSchoolCourseResponseBean(
      final SchoolCourse schoolCourse, final BigDecimal success) {
    ExtendedSchoolCourseResponseBean bean = new ExtendedSchoolCourseResponseBean();

    populateSchoolCourseBean(bean, schoolCourse);
    bean.setTeacher(
        labeledValueBeanFactory.convertPersonToAnonLabeledValueBean(schoolCourse.getTeacher()));
    bean.setSuccess(success);

    return bean;
  }
}
