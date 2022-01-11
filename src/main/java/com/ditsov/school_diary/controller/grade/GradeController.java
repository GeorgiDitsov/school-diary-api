package com.ditsov.school_diary.controller.grade;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.xml.bind.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ditsov.school_diary.controller.grade.helper.GradeControllerHelper;
import com.ditsov.school_diary.model.common.PageableBean;
import com.ditsov.school_diary.model.grade.CreateGradeRequestBean;
import com.ditsov.school_diary.model.grade.GradeRequestBean;
import com.ditsov.school_diary.model.grade.GradeResponseBean;
import com.ditsov.school_diary.model.grade.GradeStatistics;
import io.swagger.annotations.Api;

@Api(tags = "Grade APIs")
@RestController
@RequestMapping("/v1/grades")
public class GradeController {

  @Autowired private GradeControllerHelper gradeControllerHelper;

  @Secured({"ROLE_TEACHER", "ROLE_STUDENT", "ROLE_PARENT"})
  @GetMapping
  public List<GradeResponseBean> listAllGradesBy(@RequestParam @Min(1) final Long schoolCourseId) {
    return gradeControllerHelper.listAllGradesBy(schoolCourseId);
  }

  @Secured("ROLE_ADMIN")
  @GetMapping("/by-pages")
  public PageableBean<GradeResponseBean> getPageOfGrades(
      @RequestParam(required = false) @Min(0) final Optional<Integer> page,
      @RequestParam(required = false) @Min(1) final Optional<Integer> size) {
    return gradeControllerHelper.getPageOfGrades(page, size);
  }

  @Secured({"ROLE_TEACHER"})
  @GetMapping("/school-course-statistics")
  public List<GradeStatistics> listGradesStatisticsBy(
      @RequestParam @Min(1) final Long schoolCourseId) {
    return gradeControllerHelper.listGradesStatisticsBy(schoolCourseId);
  }

  @Secured({"ROLE_STUDENT", "ROLE_PARENT"})
  @GetMapping("/student-statistics")
  public List<GradeStatistics> listGradesStatisticsBy(
      @RequestParam @Min(1) final Long studentId,
      @RequestParam @Min(1) final Long schoolSemesterId) {
    return gradeControllerHelper.listGradesStatisticsBy(studentId, schoolSemesterId);
  }

  @Secured("ROLE_TEACHER")
  @PostMapping
  public void createGrade(@RequestBody @Valid final CreateGradeRequestBean gradeBean) {
    gradeControllerHelper.createGrade(gradeBean);
  }

  @Secured("ROLE_TEACHER")
  @PutMapping("/{id}")
  public void updateGrade(
      @PathVariable(name = "id") @Min(1) final Long gradeId,
      @RequestBody @Valid final GradeRequestBean gradeBean)
      throws ValidationException {
    gradeControllerHelper.updateGrade(gradeId, gradeBean);
  }

  @Secured("ROLE_TEACHER")
  @DeleteMapping("/{id}")
  public void deleteGrade(@PathVariable(name = "id") @Min(1) final Long gradeId)
      throws ValidationException {
    gradeControllerHelper.deleteGrade(gradeId);
  }
}
