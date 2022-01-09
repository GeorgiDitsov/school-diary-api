package com.ditsov.school_diary.core.factory.school.semester;

import com.ditsov.school_diary.core.entity.school.semester.SchoolSemester;
import com.ditsov.school_diary.core.factory.AbstractFactory;
import com.ditsov.school_diary.model.school.semester.CreateSchoolSemesterRequestBean;
import com.ditsov.school_diary.model.school.semester.SchoolSemesterResponseBean;
import com.ditsov.school_diary.model.school.semester.UpdateSchoolSemesterRequestBean;

public interface SchoolSemesterFactory
    extends AbstractFactory<SchoolSemesterResponseBean, SchoolSemester> {

  /**
   * Creates an entity of type {@link SchoolSemester} with the given as parameters fields.
   *
   * @param id
   * @param name
   * @return
   */
  SchoolSemester createSchoolSemester(final Long id, final String name);

  /**
   * Converts a {@link CreateSchoolSemesterRequestBean} into a {@link SchoolSemester}.
   *
   * @param bean
   * @return
   */
  SchoolSemester convertCreateSchoolSemesterRequestBeanToSchoolSemester(
      final CreateSchoolSemesterRequestBean bean);

  /**
   * Populates a {@link SchoolSemester} with an {@link UpdateSchoolSemesterRequestBean}.
   *
   * @param schoolSemester
   * @param bean
   */
  void populateSchoolSemester(
      final SchoolSemester schoolSemester, final UpdateSchoolSemesterRequestBean bean);
}
