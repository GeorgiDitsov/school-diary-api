package com.ditsov.school_diary.controller.student;

import java.math.BigDecimal;
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
import com.ditsov.school_diary.controller.student.helper.StudentControllerHelper;
import com.ditsov.school_diary.model.common.LabeledValueBean;
import com.ditsov.school_diary.model.common.PageableBean;
import com.ditsov.school_diary.model.school.course.ExtendedSchoolCourseResponseBean;
import com.ditsov.school_diary.model.student.CreateStudentRequestBean;
import com.ditsov.school_diary.model.student.StudentResponseBean;
import com.ditsov.school_diary.model.student.UpdateStudentRequestBean;
import io.swagger.annotations.Api;

@Api(tags = "Student APIs")
@RestController
@RequestMapping("/v1/students")
public class StudentController {

  @Autowired private StudentControllerHelper studentControllerHelper;

  @Secured("ROLE_ADMIN")
  @GetMapping
  public PageableBean<StudentResponseBean> getPageOfStudents(
      @RequestParam(required = false) @Min(0) final Optional<Integer> page,
      @RequestParam(required = false) @Min(1) final Optional<Integer> size) {
    return studentControllerHelper.getPageOfStudents(page, size);
  }

  @Secured("ROLE_ADMIN")
  @GetMapping("/options")
  public List<LabeledValueBean<Long>> listAllStudentsAsOptions() {
    return studentControllerHelper.listAllStudentsAsOptions();
  }

  @Secured({"ROLE_STUDENT", "ROLE_PARENT"})
  @GetMapping("/{id}/school-courses")
  public List<ExtendedSchoolCourseResponseBean> listAllSchoolCoursesByStudent(
      @PathVariable(name = "id") @Min(1) final Long studentId,
      @RequestParam @Min(1) final Long schoolSemesterId) {
    return studentControllerHelper.listAllSchoolCoursesByStudent(studentId, schoolSemesterId);
  }

  @Secured({"ROLE_STUDENT", "ROLE_PARENT"})
  @GetMapping("/{id}/success")
  public BigDecimal getSuccessByStudentAndSchoolSemester(
      @PathVariable(name = "id") @Min(1) final Long studentId,
      @RequestParam @Min(1) final Long schoolSemesterId) {
    return studentControllerHelper.getSuccessByStudentAndSchoolSemester(
        studentId, schoolSemesterId);
  }

  @Secured("ROLE_ADMIN")
  @PostMapping
  public void createStudent(@RequestBody @Valid final CreateStudentRequestBean studentBean) {
    studentControllerHelper.createStudent(studentBean);
  }

  @Secured("ROLE_ADMIN")
  @PatchMapping("/{id}")
  public void updateStudent(
      @PathVariable(name = "id") @Min(1) final Long studentId,
      @RequestBody @Valid final UpdateStudentRequestBean studentBean) {
    studentControllerHelper.updateStudent(studentId, studentBean);
  }

  @Secured("ROLE_ADMIN")
  @DeleteMapping("/{id}")
  public void deleteStudent(@PathVariable(name = "id") @Min(1) final Long studentId) {
    studentControllerHelper.deleteStudent(studentId);
  }
}
