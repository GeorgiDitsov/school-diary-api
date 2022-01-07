package com.ditsov.school_diary.controller.school.subject.helper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.entity.school.subject.SchoolSubject;
import com.ditsov.school_diary.core.factory.common.LabeledValueBeanFactory;
import com.ditsov.school_diary.core.factory.school.subject.SchoolSubjectFactory;
import com.ditsov.school_diary.core.service.school.subject.SchoolSubjectService;
import com.ditsov.school_diary.model.common.LabeledValueBean;
import com.ditsov.school_diary.model.school.subject.CreateSchoolSubjectRequestBean;
import com.ditsov.school_diary.model.school.subject.UpdateSchoolSubjectRequestBean;

@Component
public class SchoolSubjectControllerHelper {

  @Autowired private SchoolSubjectService schoolSubjectService;

  @Autowired private LabeledValueBeanFactory labeledValueBeanFactory;

  @Autowired private SchoolSubjectFactory schoolSubjectFactory;

  public List<LabeledValueBean<Long>> listSchoolSubjects(
      final Optional<Integer> page, final Optional<Integer> size) {
    List<SchoolSubject> schoolSubjects =
        schoolSubjectService.getByOrderByName(page.orElse(0), size.orElse(10));

    return schoolSubjects
        .stream()
        .map(labeledValueBeanFactory::convertSchoolSubjectToLabeledValueBean)
        .collect(Collectors.toList());
  }

  public void createSchoolSubject(final CreateSchoolSubjectRequestBean bean) {
    SchoolSubject schoolSubject =
        schoolSubjectFactory.convertCreateSchoolSubjectToSchoolSubject(bean);

    schoolSubjectService.save(schoolSubject);
  }

  public void updateSchoolSubject(
      final Long schoolSubjectId, final UpdateSchoolSubjectRequestBean bean) {
    SchoolSubject schoolSubject = schoolSubjectService.getById(schoolSubjectId);

    schoolSubjectFactory.populateSchoolSubject(schoolSubject, bean);

    schoolSubjectService.save(schoolSubject);
  }

  public void deleteSchoolSubject(final Long schoolSubjectId) {
    schoolSubjectService.deleteById(schoolSubjectId);
  }
}
