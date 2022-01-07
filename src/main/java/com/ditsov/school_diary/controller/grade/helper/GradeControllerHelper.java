package com.ditsov.school_diary.controller.grade.helper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.entity.grade.Grade;
import com.ditsov.school_diary.core.factory.grade.GradeFactory;
import com.ditsov.school_diary.core.service.grade.GradeService;
import com.ditsov.school_diary.model.grade.GradeResponseBean;

@Component
public class GradeControllerHelper {

  @Autowired private GradeService gradeService;

  @Autowired private GradeFactory gradeFactory;

  public List<GradeResponseBean> listGradesBy(final Long studentId, final Long courseId) {
    List<Grade> grades = gradeService.getByStudentIdAndSchoolCourseId(studentId, courseId);

    return grades
        .stream()
        .map(gradeFactory::convertGradeToGradeResponseBean)
        .collect(Collectors.toList());
  }

  public List<GradeResponseBean> listGrades(
      final Optional<Integer> page, final Optional<Integer> size) {
    List<Grade> grades = gradeService.getByOrderByUpdatedAtDesc(page.orElse(0), size.orElse(10));

    return grades
        .stream()
        .map(gradeFactory::convertGradeToGradeResponseBean)
        .collect(Collectors.toList());
  }
}
