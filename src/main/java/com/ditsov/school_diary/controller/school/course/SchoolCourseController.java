package com.ditsov.school_diary.controller.school.course;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ditsov.school_diary.controller.school.course.helper.SchoolCourseControllerHelper;
import com.ditsov.school_diary.model.common.LabeledValueBean;
import com.ditsov.school_diary.model.common.PageableBean;
import com.ditsov.school_diary.model.school.course.CreateSchoolCourseRequestBean;
import com.ditsov.school_diary.model.school.course.SchoolCourseResponseBean;
import com.ditsov.school_diary.model.school.course.UpdateSchoolCourseRequestBean;
import io.swagger.annotations.Api;

@Api(tags = "School Course APIs")
@RestController
@RequestMapping("/v1/school-courses")
public class SchoolCourseController {

  @Autowired private SchoolCourseControllerHelper schoolCourseControllerHelper;

  @Secured("ROLE_ADMIN")
  @GetMapping
  public PageableBean<SchoolCourseResponseBean> getPageOfSchoolCourses(
      @RequestParam(required = false) @Min(0) final Optional<Integer> page,
      @RequestParam(required = false) @Min(1) final Optional<Integer> size) {
    return schoolCourseControllerHelper.getPageOfSchoolCourses(page, size);
  }

  @Secured({"ROLE_TEACHER", "ROLE_STUDENT"})
  @GetMapping("/all")
  public List<SchoolCourseResponseBean> listAllSchoolCoursesBy(
      @RequestParam(required = false) @Min(1) final Optional<Long> teacherId,
      @RequestParam(required = false) @Min(1) final Optional<Long> schoolGroupId,
      @RequestParam @Min(1) final Long schoolSemesterId) {
    return schoolCourseControllerHelper.listAllSchoolCoursesBy(teacherId, schoolGroupId, schoolSemesterId);
  }

  @Secured("ROLE_TEACHER")
  @GetMapping("/{id}/students")
  public List<LabeledValueBean<Long>> listAllStudentsBySchoolCourse(
      @PathVariable(name = "id") @Min(1) final Long schoolCourseId) {
    return schoolCourseControllerHelper.listAllStudentsBySchoolCourse(schoolCourseId);
  }

  @Secured("ROLE_ADMIN")
  @PostMapping
  public void createSchoolCourse(
      @RequestBody @Valid final CreateSchoolCourseRequestBean schoolCourseBean) {
    schoolCourseControllerHelper.createSchoolCourse(schoolCourseBean);
  }

  @Secured("ROLE_ADMIN")
  @PatchMapping("/{id}")
  public void updateSchoolCourse(
      @PathVariable(name = "id") @Min(1) final Long schoolCourseId,
      @RequestBody @Valid final UpdateSchoolCourseRequestBean schoolCourseBean) {
    schoolCourseControllerHelper.updateSchoolCourse(schoolCourseId, schoolCourseBean);
  }

  @Secured("ROLE_ADMIN")
  @DeleteMapping("/{id}")
  public void deleteSchoolCourse(@PathVariable(name = "id") @Min(1) final Long schoolCourseId) {
    schoolCourseControllerHelper.deleteSchoolCourse(schoolCourseId);
  }
}
