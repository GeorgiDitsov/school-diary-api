package com.ditsov.school_diary.core.factory.school.course;

import com.ditsov.school_diary.core.entity.school.course.SchoolCourse;
import com.ditsov.school_diary.model.school.course.SchoolCourseRequestBean;
import com.ditsov.school_diary.model.school.course.SchoolCourseResponseBean;

public interface SchoolCourseFactory {

  /**
   * Converts an entity of type {@link SchoolCourse} into a {@link SchoolCourseResponseBean}.
   *
   * @param schoolCourse
   * @return
   */
  SchoolCourseResponseBean convertSchoolCourseToSchoolCourseResponseBean(
      final SchoolCourse schoolCourse);

  /**
   * Converts a {@link SchoolCourseRequestBean} into an entity of type {@link SchoolCourse}.
   *
   * @param bean
   * @return
   */
  SchoolCourse convertSchoolCourseRequestBeanToSchoolCourse(final SchoolCourseRequestBean bean);

  /**
   * Populates an entity of type {@link SchoolCourse} with {@link SchoolCourseRequestBean}.
   *
   * @param schoolCourse
   * @param bean
   */
  void populateSchoolCourse(final SchoolCourse schoolCourse, final SchoolCourseRequestBean bean);
}
