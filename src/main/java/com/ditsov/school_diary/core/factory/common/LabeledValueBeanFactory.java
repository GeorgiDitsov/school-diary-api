package com.ditsov.school_diary.core.factory.common;

import com.ditsov.school_diary.core.entity.person.Person;
import com.ditsov.school_diary.core.entity.school.course.SchoolCourse;
import com.ditsov.school_diary.core.entity.school.group.SchoolGroup;
import com.ditsov.school_diary.core.entity.school.semester.SchoolSemester;
import com.ditsov.school_diary.core.entity.school.subject.SchoolSubject;
import com.ditsov.school_diary.core.entity.school.year.SchoolYear;
import com.ditsov.school_diary.model.common.LabeledValueBean;

public interface LabeledValueBeanFactory {

  /**
   * Converts an entity of type {@link Person} into a {@link LabeledValueBean}.
   *
   * @param person
   * @return
   */
  LabeledValueBean<Long> convertPersonToLabeledValueBean(final Person person);

  /**
   * Converts an entity of type {@link SchoolGroup} into a {@link LabeledValueBean}.
   *
   * @param schoolGroup
   * @return
   */
  LabeledValueBean<Long> convertSchoolGroupToLabeledValueBean(final SchoolGroup schoolGroup);

  /**
   * Converts an entity of type {@link SchoolSubject} into a {@link LabeledValueBean}.
   *
   * @param schoolSubject
   * @return
   */
  LabeledValueBean<Long> convertSchoolSubjectToLabeledValueBean(final SchoolSubject schoolSubject);

  /**
   * Converts an entity of type {@link SchoolSemester} into a {@link LabeledValueBean}.
   *
   * @param schoolSemester
   * @return
   */
  LabeledValueBean<Long> convertSchoolSemesterToLabeledValueBean(
      final SchoolSemester schoolSemester);

  /**
   * Converts an entity of type {@link SchoolYear} into a {@link LabeledValueBean}.
   *
   * @param schoolYear
   * @return
   */
  LabeledValueBean<Long> convertSchoolYearToLabeledValueBean(final SchoolYear schoolYear);

  /**
   * Converts an entity of type {@link SchoolCourse} into a {@link LabeledValueBean}.
   *
   * @param schoolCourse
   * @return
   */
  LabeledValueBean<Long> convertSchoolCourseToLabeledValueBean(final SchoolCourse schoolCourse);
}
