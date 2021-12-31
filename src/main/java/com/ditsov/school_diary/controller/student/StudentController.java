package com.ditsov.school_diary.controller.student;

import java.util.List;
import java.util.Optional;
import javax.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ditsov.school_diary.controller.student.helper.StudentControllerHelper;
import com.ditsov.school_diary.model.student.StudentResponseBean;
import io.swagger.annotations.Api;

@Api(tags = "Student APIs")
@RestController
@RequestMapping("/v1/students")
public class StudentController {

  @Autowired private StudentControllerHelper studentControllerHelper;

  @GetMapping
  @Secured("ROLE_ADMIN")
  public List<StudentResponseBean> listAll(
      @RequestParam(required = false) @Min(0) final Optional<Integer> page,
      @RequestParam(required = false) @Min(1) final Optional<Integer> size) {
    return studentControllerHelper.listAllStudents(page, size);
  }
}
