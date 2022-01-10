package com.ditsov.school_diary.controller.school.semester.helper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.entity.school.semester.SchoolSemester;
import com.ditsov.school_diary.core.factory.common.LabeledValueBeanFactory;
import com.ditsov.school_diary.core.factory.common.PageableBeanFactory;
import com.ditsov.school_diary.core.factory.school.semester.SchoolSemesterFactory;
import com.ditsov.school_diary.core.service.school.semester.SchoolSemesterService;
import com.ditsov.school_diary.model.common.LabeledValueBean;
import com.ditsov.school_diary.model.common.PageableBean;
import com.ditsov.school_diary.model.school.semester.CreateSchoolSemesterRequestBean;
import com.ditsov.school_diary.model.school.semester.SchoolSemesterResponseBean;
import com.ditsov.school_diary.model.school.semester.UpdateSchoolSemesterRequestBean;

@Component
public class SchoolSemesterControllerHelper {

  @Autowired private SchoolSemesterService schoolSemesterService;

  @Autowired private PageableBeanFactory pageableBeanFactory;

  @Autowired private SchoolSemesterFactory schoolSemesterFactory;

  @Autowired private LabeledValueBeanFactory labeledValueBeanFactory;

  public PageableBean<SchoolSemesterResponseBean> getPageOfSchoolSemesters(
      final Optional<Integer> page, final Optional<Integer> size) {
    Page<SchoolSemester> schoolSemesters =
        schoolSemesterService.getByOrderByStartDateDesc(page.orElse(0), size.orElse(10));

    return pageableBeanFactory.create(schoolSemesters, schoolSemesterFactory);
  }

  public List<LabeledValueBean<Long>> listAllSchoolSemestersAsOptions() {
    List<SchoolSemester> schoolSemesters =
        schoolSemesterService.getAllByOrderByStartDateDesc();

    return schoolSemesters
        .stream()
        .map(labeledValueBeanFactory::convertSchoolSemesterToLabeledValueBean)
        .collect(Collectors.toList());
  }

  public LabeledValueBean<Long> getCurrentSchoolSemester() {
    SchoolSemester current = schoolSemesterService.getCurrentSchoolSemester();

    return labeledValueBeanFactory.convertSchoolSemesterToLabeledValueBean(current);
  }

  public void createSchoolSemester(final CreateSchoolSemesterRequestBean bean) {
    SchoolSemester schoolSemester =
        schoolSemesterFactory.convertCreateSchoolSemesterRequestBeanToSchoolSemester(bean);

    schoolSemesterService.save(schoolSemester);
  }

  public void updateSchoolSemester(
      final Long schoolSemesterId, final UpdateSchoolSemesterRequestBean bean) {
    SchoolSemester schoolSemester = schoolSemesterService.getById(schoolSemesterId);

    schoolSemesterFactory.populateSchoolSemester(schoolSemester, bean);

    schoolSemesterService.save(schoolSemester);
  }

  public void deleteSchoolSemester(final Long schoolSemesterId) {
    schoolSemesterService.deleteById(schoolSemesterId);
  }
}
