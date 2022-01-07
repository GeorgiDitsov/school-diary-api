package com.ditsov.school_diary.core.factory.school.semester.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.entity.school.semester.SchoolSemester;
import com.ditsov.school_diary.core.factory.common.LabeledValueBeanFactory;
import com.ditsov.school_diary.core.factory.school.semester.SchoolSemesterFactory;
import com.ditsov.school_diary.core.factory.school.year.SchoolYearFactory;
import com.ditsov.school_diary.model.school.semester.CreateSchoolSemesterRequestBean;
import com.ditsov.school_diary.model.school.semester.SchoolSemesterResponseBean;
import com.ditsov.school_diary.model.school.semester.UpdateSchoolSemesterRequestBean;

@Component
public class SchoolSemesterFactoryImpl implements SchoolSemesterFactory {

  @Autowired private LabeledValueBeanFactory labeledValueBeanFactory;

  @Autowired private SchoolYearFactory schoolYearFactory;

  /** @see SchoolSemesterFactory#createSchoolSemester(Long, String) */
  @Override
  public SchoolSemester createSchoolSemester(final Long id, final String name) {
    SchoolSemester schoolSemester = new SchoolSemester();

    schoolSemester.setId(id);
    schoolSemester.setName(name);

    return schoolSemester;
  }

  /**
   * @see SchoolSemesterFactory#convertSchoolSemesterToSchoolSemesterResponseBean(SchoolSemester)
   */
  @Override
  public SchoolSemesterResponseBean convertSchoolSemesterToSchoolSemesterResponseBean(
      final SchoolSemester schoolSemester) {
    SchoolSemesterResponseBean bean = new SchoolSemesterResponseBean();

    bean.setId(schoolSemester.getId());
    bean.setName(schoolSemester.getName());
    bean.setStartDate(schoolSemester.getStartDate());
    bean.setEndDate(schoolSemester.getEndDate());
    bean.setSchoolYear(
        labeledValueBeanFactory.convertSchoolYearToLabeledValueBean(
            schoolSemester.getSchoolYear()));

    return bean;
  }

  /**
   * @see
   *     SchoolSemesterFactory#convertCreateSchoolSemesterRequestBeanToSchoolSemester(CreateSchoolSemesterRequestBean)
   */
  @Override
  public SchoolSemester convertCreateSchoolSemesterRequestBeanToSchoolSemester(
      final CreateSchoolSemesterRequestBean bean) {
    SchoolSemester schoolSemester = new SchoolSemester();

    schoolSemester.setName(bean.getName());
    schoolSemester.setStartDate(bean.getPeriod().getStartDate());
    schoolSemester.setEndDate(bean.getPeriod().getEndDate());
    schoolSemester.setSchoolYear(
        schoolYearFactory.createSchoolYear(bean.getSchoolYear().getValue()));

    return schoolSemester;
  }

  /**
   * @see SchoolSemesterFactory#populateSchoolSemester(SchoolSemester,
   *     UpdateSchoolSemesterRequestBean)
   */
  @Override
  public void populateSchoolSemester(
      final SchoolSemester schoolSemester, final UpdateSchoolSemesterRequestBean bean) {
    Optional.ofNullable(bean.getName()).ifPresent(schoolSemester::setName);
    Optional.ofNullable(bean.getPeriod())
        .ifPresent(
            period -> {
              schoolSemester.setStartDate(period.getStartDate());
              schoolSemester.setEndDate(period.getEndDate());
            });
    Optional.ofNullable(bean.getSchoolYear())
        .ifPresent(
            schoolYear ->
                schoolSemester.setSchoolYear(
                    schoolYearFactory.createSchoolYear(schoolYear.getValue())));
  }
}
