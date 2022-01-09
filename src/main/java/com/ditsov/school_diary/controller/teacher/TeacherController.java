package com.ditsov.school_diary.controller.teacher;

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
import com.ditsov.school_diary.controller.teacher.helper.TeacherControllerHelper;
import com.ditsov.school_diary.model.common.LabeledValueBean;
import com.ditsov.school_diary.model.common.PageableBean;
import com.ditsov.school_diary.model.teacher.CreateTeacherRequestBean;
import com.ditsov.school_diary.model.teacher.TeacherResponseBean;
import com.ditsov.school_diary.model.teacher.UpdateTeacherRequestBean;
import io.swagger.annotations.Api;

@Api(tags = "Teacher APIs")
@Secured("ROLE_ADMIN")
@RestController
@RequestMapping("/v1/teachers")
public class TeacherController {

  @Autowired private TeacherControllerHelper teacherControllerHelper;

  @GetMapping
  public PageableBean<TeacherResponseBean> getPageOfTeachers(
      @RequestParam(required = false) @Min(1) final Optional<Integer> page,
      @RequestParam(required = false) @Min(1) final Optional<Integer> size) {
    return teacherControllerHelper.getPageOfTeachers(page, size);
  }

  @GetMapping("/options")
  public List<LabeledValueBean<Long>> listAllTeachersAsOptions() {
    return teacherControllerHelper.listAllTeachersAsOptions();
  }

  @PostMapping
  public void createTeacher(@RequestBody @Valid final CreateTeacherRequestBean teacherBean) {
    teacherControllerHelper.createTeacher(teacherBean);
  }

  @PatchMapping("/{id}")
  public void updateTeacher(
      @PathVariable(name = "id") @Min(1) final Long teacherId,
      @RequestBody @Valid final UpdateTeacherRequestBean teacherBean) {
    teacherControllerHelper.updateTeacher(teacherId, teacherBean);
  }

  @DeleteMapping("/{id}")
  public void deleteTeacher(@PathVariable(name = "id") @Min(1) final Long teacherId) {
    teacherControllerHelper.deleteTeacher(teacherId);
  }
}
