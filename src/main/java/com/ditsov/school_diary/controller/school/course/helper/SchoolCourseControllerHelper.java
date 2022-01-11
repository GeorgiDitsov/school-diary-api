package com.ditsov.school_diary.controller.school.course.helper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.entity.school.course.SchoolCourse;
import com.ditsov.school_diary.core.factory.common.LabeledValueBeanFactory;
import com.ditsov.school_diary.core.factory.common.PageableBeanFactory;
import com.ditsov.school_diary.core.factory.school.course.SchoolCourseFactory;
import com.ditsov.school_diary.core.service.school.course.SchoolCourseService;
import com.ditsov.school_diary.model.common.LabeledValueBean;
import com.ditsov.school_diary.model.common.PageableBean;
import com.ditsov.school_diary.model.school.course.CreateSchoolCourseRequestBean;
import com.ditsov.school_diary.model.school.course.SchoolCourseRequestBean;
import com.ditsov.school_diary.model.school.course.SchoolCourseResponseBean;
import com.ditsov.school_diary.model.school.course.UpdateSchoolCourseRequestBean;

@Component
public class SchoolCourseControllerHelper {

  @Autowired private SchoolCourseService schoolCourseService;

  @Autowired private PageableBeanFactory pageableBeanFactory;

  @Autowired private SchoolCourseFactory schoolCourseFactory;

  @Autowired private LabeledValueBeanFactory labeledValueBeanFactory;


  public PageableBean<SchoolCourseResponseBean> getPageOfSchoolCourses(
      final Optional<Integer> page, final Optional<Integer> size) {
    Page<SchoolCourse> schoolCourses =
        schoolCourseService.getByOrderByIdDesc(page.orElse(0), page.orElse(10));

    return pageableBeanFactory.create(schoolCourses, schoolCourseFactory);
  }

  public List<LabeledValueBean<Long>> listAllStudentsBySchoolCourse(final Long schoolCourseId) {
    SchoolCourse schoolCourse = schoolCourseService.getById(schoolCourseId);

    return schoolCourse
        .getSchoolGroup()
        .getStudents()
        .stream()
        .map(labeledValueBeanFactory::convertPersonToAnonLabeledValueBean)
        .collect(Collectors.toList());
  }

  public void createSchoolCourse(final CreateSchoolCourseRequestBean schoolCourseBean) {
    createOrUpdateSchoolCourse(new SchoolCourse(), schoolCourseBean);
  }

  public void updateSchoolCourse(
      final Long schoolCourseId, final UpdateSchoolCourseRequestBean schoolCourseBean) {
    createOrUpdateSchoolCourse(schoolCourseService.getById(schoolCourseId), schoolCourseBean);
  }

  private void createOrUpdateSchoolCourse(
      final SchoolCourse schoolCourse, final SchoolCourseRequestBean schoolCourseBean) {
    schoolCourseFactory.populateSchoolCourse(schoolCourse, schoolCourseBean);

    schoolCourseService.save(schoolCourse);
  }

  public void deleteSchoolCourse(final Long schoolCourseId) {
    schoolCourseService.deleteById(schoolCourseId);
  }
}
