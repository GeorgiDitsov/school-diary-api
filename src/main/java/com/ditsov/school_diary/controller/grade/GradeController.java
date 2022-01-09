package com.ditsov.school_diary.controller.grade;

import java.util.Optional;
import javax.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ditsov.school_diary.controller.grade.helper.GradeControllerHelper;
import com.ditsov.school_diary.model.common.PageableBean;
import com.ditsov.school_diary.model.grade.GradeResponseBean;
import io.swagger.annotations.Api;

@Api(tags = "Grade APIs")
@RestController
@RequestMapping("/v1/grades")
public class GradeController {

  @Autowired private GradeControllerHelper gradeControllerHelper;

  @Secured({"ROLE_TEACHER", "ROLE_STUDENT", "ROLE_PARENT"})
  @GetMapping
  public PageableBean<GradeResponseBean> listGradesBy(
      @RequestParam @Min(1) final Long studentId,
      @RequestParam @Min(1) final Long courseId,
      @RequestParam(required = false) @Min(0) final Optional<Integer> page,
      @RequestParam(required = false) @Min(1) final Optional<Integer> size) {
    return gradeControllerHelper.listGradesBy(studentId, courseId, page, size);
  }

  @Secured("ROLE_ADMIN")
  @GetMapping("/admin")
  public PageableBean<GradeResponseBean> getPageOfGrades(
      @RequestParam(required = false) @Min(0) final Optional<Integer> page,
      @RequestParam(required = false) @Min(1) final Optional<Integer> size) {
    return gradeControllerHelper.getPageOfGrades(page, size);
  }
}
