package com.ditsov.school_diary.core.factory.school.year;

import com.ditsov.school_diary.core.entity.school.year.SchoolYear;
import com.ditsov.school_diary.core.factory.AbstractFactory;
import com.ditsov.school_diary.model.school.year.CreateSchoolYearRequestBean;
import com.ditsov.school_diary.model.school.year.SchoolYearResponseBean;
import com.ditsov.school_diary.model.school.year.UpdateSchoolYearRequestBean;

public interface SchoolYearFactory extends AbstractFactory<SchoolYearResponseBean, SchoolYear> {

  /**
   * Creates a {@link SchoolYear} with the given as parameters fields.
   *
   * @param id
   * @return
   */
  SchoolYear createSchoolYear(final Long id);

  /**
   * Converts a {@link CreateSchoolYearRequestBean} into a {@link SchoolYear}.
   *
   * @param bean
   * @return
   */
  SchoolYear convertCreateSchoolYearRequestBeanToSchoolYear(final CreateSchoolYearRequestBean bean);

  /**
   * Populates a {@link SchoolYear} with an {@link UpdateSchoolYearRequestBean}.
   *
   * @param schoolYear
   * @param bean
   */
  void populateSchoolYear(final SchoolYear schoolYear, final UpdateSchoolYearRequestBean bean);
}
