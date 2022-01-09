package com.ditsov.school_diary.controller.school.year.helper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.entity.school.year.SchoolYear;
import com.ditsov.school_diary.core.factory.common.LabeledValueBeanFactory;
import com.ditsov.school_diary.core.factory.common.PageableBeanFactory;
import com.ditsov.school_diary.core.factory.school.year.SchoolYearFactory;
import com.ditsov.school_diary.core.service.school.year.SchoolYearService;
import com.ditsov.school_diary.model.common.LabeledValueBean;
import com.ditsov.school_diary.model.common.PageableBean;
import com.ditsov.school_diary.model.school.year.CreateSchoolYearRequestBean;
import com.ditsov.school_diary.model.school.year.SchoolYearResponseBean;
import com.ditsov.school_diary.model.school.year.UpdateSchoolYearRequestBean;

@Component
public class SchoolYearControllerHelper {

  @Autowired private SchoolYearService schoolYearService;

  @Autowired private PageableBeanFactory pageableBeanFactory;

  @Autowired private SchoolYearFactory schoolYearFactory;

  @Autowired private LabeledValueBeanFactory labeledValueBeanFactory;

  public PageableBean<SchoolYearResponseBean> getPageOfSchoolYears(
      final Optional<Integer> page, final Optional<Integer> size) {
    Page<SchoolYear> schoolYears =
        schoolYearService.getByOrderByStartDateDesc(page.orElse(0), size.orElse(10));

    return pageableBeanFactory.create(schoolYears, schoolYearFactory);
  }

  public List<LabeledValueBean<Long>> listAllSchoolYearsAsOptions() {
    List<SchoolYear> schoolYears = schoolYearService.getAllByOrderByStartDateDesc();

    return schoolYears
        .stream()
        .map(labeledValueBeanFactory::convertSchoolYearToLabeledValueBean)
        .collect(Collectors.toList());
  }

  public void createSchoolYear(final CreateSchoolYearRequestBean schoolYearBean) {
    SchoolYear schoolYear =
        schoolYearFactory.convertCreateSchoolYearRequestBeanToSchoolYear(schoolYearBean);

    schoolYearService.save(schoolYear);
  }

  public void updateSchoolYear(
      final Long schoolYearId, final UpdateSchoolYearRequestBean schoolYearBean) {
    SchoolYear schoolYear = schoolYearService.getById(schoolYearId);

    schoolYearFactory.populateSchoolYear(schoolYear, schoolYearBean);

    schoolYearService.save(schoolYear);
  }

  public void deleteSchoolYear(final Long schoolYearId) {
    schoolYearService.deleteById(schoolYearId);
  }
}
