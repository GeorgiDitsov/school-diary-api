package com.ditsov.school_diary.core.factory.common.impl;

import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.entity.person.Person;
import com.ditsov.school_diary.core.entity.school.course.SchoolCourse;
import com.ditsov.school_diary.core.entity.school.group.SchoolGroup;
import com.ditsov.school_diary.core.entity.school.semester.SchoolSemester;
import com.ditsov.school_diary.core.entity.school.subject.SchoolSubject;
import com.ditsov.school_diary.core.entity.school.year.SchoolYear;
import com.ditsov.school_diary.core.factory.common.LabeledValueBeanFactory;
import com.ditsov.school_diary.model.common.LabeledValueBean;

@Component
public class LabeledValueBeanFactoryImpl implements LabeledValueBeanFactory {

  /** @see LabeledValueBeanFactory#convertPersonToLabeledValueBean(Person) */
  @Override
  public LabeledValueBean<Long> convertPersonToLabeledValueBean(final Person person) {
    return create(getPersonInfo(person), person.getId());
  }

  private String getPersonInfo(final Person person) {
    return String.format("%s %s, %s", person.getFirstName(), person.getLastName(), person.getPin());
  }

  /** @see LabeledValueBeanFactory#convertSchoolGroupToLabeledValueBean(SchoolGroup) */
  @Override
  public LabeledValueBean<Long> convertSchoolGroupToLabeledValueBean(
      final SchoolGroup schoolGroup) {
    return create(getSchoolGroupInfo(schoolGroup), schoolGroup.getId());
  }

  private String getSchoolGroupInfo(final SchoolGroup schoolGroup) {
    return schoolGroup.getYear().toString() + schoolGroup.getIndex();
  }

  /** @see LabeledValueBeanFactory#convertSchoolSubjectToLabeledValueBean(SchoolSubject) */
  @Override
  public LabeledValueBean<Long> convertSchoolSubjectToLabeledValueBean(
      final SchoolSubject schoolSubject) {
    return create(schoolSubject.getName(), schoolSubject.getId());
  }

  /** @see LabeledValueBeanFactory#convertSchoolSemesterToLabeledValueBean(SchoolSemester) */
  @Override
  public LabeledValueBean<Long> convertSchoolSemesterToLabeledValueBean(
      final SchoolSemester schoolSemester) {
    return create(schoolSemester.getName(), schoolSemester.getId());
  }

  /** @see LabeledValueBeanFactory#convertSchoolYearToLabeledValueBean(SchoolYear) */
  @Override
  public LabeledValueBean<Long> convertSchoolYearToLabeledValueBean(final SchoolYear schoolYear) {
    return create(schoolYear.getName(), schoolYear.getId());
  }

  /** @see LabeledValueBeanFactory#convertSchoolCourseToLabeledValueBean(SchoolCourse) */
  @Override
  public LabeledValueBean<Long> convertSchoolCourseToLabeledValueBean(
      final SchoolCourse schoolCourse) {
    return create(schoolCourse.getSchoolSubject().getName(), schoolCourse.getId());
  }

  /**
   * Creates a {@link LabeledValueBean}.
   *
   * @param label
   * @param value
   * @return
   */
  private <V> LabeledValueBean<V> create(final String label, final V value) {
    LabeledValueBean<V> bean = new LabeledValueBean<>();

    bean.setLabel(label);
    bean.setValue(value);

    return bean;
  }
}
