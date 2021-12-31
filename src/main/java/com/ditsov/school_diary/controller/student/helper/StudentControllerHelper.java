package com.ditsov.school_diary.controller.student.helper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.entity.student.Student;
import com.ditsov.school_diary.core.factory.student.StudentFactory;
import com.ditsov.school_diary.core.service.student.StudentService;
import com.ditsov.school_diary.model.student.StudentResponseBean;

@Component
public class StudentControllerHelper {

  @Autowired private StudentService studentService;

  @Autowired private StudentFactory studentFactory;

  public List<StudentResponseBean> listAllStudents(
      final Optional<Integer> page, final Optional<Integer> size) {
    List<Student> students =
        studentService.getAllStudentsOrderByFullName(page.orElse(0), size.orElse(10));

    return students.stream().map(studentFactory::convert).collect(Collectors.toList());
  }
}
