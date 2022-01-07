package com.ditsov.school_diary.core.factory.school.year.impl;

import java.util.Optional;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.entity.school.year.SchoolYear;
import com.ditsov.school_diary.core.factory.school.year.SchoolYearFactory;
import com.ditsov.school_diary.model.school.year.CreateSchoolYearRequestBean;
import com.ditsov.school_diary.model.school.year.SchoolYearResponseBean;
import com.ditsov.school_diary.model.school.year.UpdateSchoolYearRequestBean;

@Component
public class SchoolYearFactoryImpl implements SchoolYearFactory {

  /** @see SchoolYearFactory#createSchoolYear(Long) */
  @Override
  public SchoolYear createSchoolYear(final Long id) {
    SchoolYear schoolYear = new SchoolYear();

    schoolYear.setId(id);

    return schoolYear;
  }

  /** @see SchoolYearFactory#convertSchoolYearToSchoolYearResponseBean(SchoolYear) */
  @Override
  public SchoolYearResponseBean convertSchoolYearToSchoolYearResponseBean(
      final SchoolYear schoolYear) {
    SchoolYearResponseBean bean = new SchoolYearResponseBean();

    bean.setId(schoolYear.getId());
    bean.setName(schoolYear.getName());
    bean.setStartDate(schoolYear.getStartDate());
    bean.setEndDate(schoolYear.getEndDate());

    return bean;
  }

  /**
   * @see
   *     SchoolYearFactory#convertCreateSchoolYearRequestBeanToSchoolYear(CreateSchoolYearRequestBean)
   */
  @Override
  public SchoolYear convertCreateSchoolYearRequestBeanToSchoolYear(
      final CreateSchoolYearRequestBean bean) {
    SchoolYear schoolYear = new SchoolYear();

    schoolYear.setName(bean.getName());
    schoolYear.setStartDate(bean.getPeriod().getStartDate());
    schoolYear.setEndDate(bean.getPeriod().getEndDate());

    return schoolYear;
  }

  /** @see SchoolYearFactory#populateSchoolYear(SchoolYear, UpdateSchoolYearRequestBean) */
  @Override
  public void populateSchoolYear(
      final SchoolYear schoolYear, final UpdateSchoolYearRequestBean bean) {
    Optional.ofNullable(bean.getName()).ifPresent(schoolYear::setName);
    Optional.ofNullable(bean.getPeriod())
        .ifPresent(
            period -> {
              schoolYear.setStartDate(period.getStartDate());
              schoolYear.setEndDate(period.getEndDate());
            });
  }
}
