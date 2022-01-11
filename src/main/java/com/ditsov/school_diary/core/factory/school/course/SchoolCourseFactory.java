package com.ditsov.school_diary.core.factory.school.course;

import java.math.BigDecimal;
import com.ditsov.school_diary.core.entity.school.course.SchoolCourse;
import com.ditsov.school_diary.core.factory.AbstractFactory;
import com.ditsov.school_diary.model.school.course.ExtendedSchoolCourseResponseBean;
import com.ditsov.school_diary.model.school.course.SchoolCourseRequestBean;
import com.ditsov.school_diary.model.school.course.SchoolCourseResponseBean;

public interface SchoolCourseFactory
    extends AbstractFactory<SchoolCourseResponseBean, SchoolCourse> {

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

  /**
   * Converts an entity of type {@link SchoolCourse} into an {@link
   * ExtendedSchoolCourseResponseBean}.
   *
   * @param schoolCourse
   * @param success
   * @return
   */
  ExtendedSchoolCourseResponseBean convertSchoolCourseToExtendedSchoolCourseResponseBean(
      final SchoolCourse schoolCourse, final BigDecimal success);
}
