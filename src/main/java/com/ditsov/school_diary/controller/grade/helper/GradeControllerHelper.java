package com.ditsov.school_diary.controller.grade.helper;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.entity.grade.Grade;
import com.ditsov.school_diary.core.factory.common.PageableBeanFactory;
import com.ditsov.school_diary.core.factory.grade.GradeFactory;
import com.ditsov.school_diary.core.service.grade.GradeService;
import com.ditsov.school_diary.model.common.PageableBean;
import com.ditsov.school_diary.model.grade.GradeResponseBean;

@Component
public class GradeControllerHelper {

  @Autowired private GradeService gradeService;

  @Autowired private PageableBeanFactory pageableBeanFactory;

  @Autowired private GradeFactory gradeFactory;

  public PageableBean<GradeResponseBean> listGradesBy(
      final Long studentId,
      final Long courseId,
      final Optional<Integer> page,
      final Optional<Integer> size) {
    Page<Grade> grades =
        gradeService.getByStudentIdAndSchoolCourseId(
            studentId, courseId, page.orElse(0), size.orElse(10));

    return pageableBeanFactory.create(grades, gradeFactory);
  }

  public PageableBean<GradeResponseBean> getPageOfGrades(
      final Optional<Integer> page, final Optional<Integer> size) {
    Page<Grade> grades = gradeService.getByOrderByUpdatedAtDesc(page.orElse(0), size.orElse(10));

    return pageableBeanFactory.create(grades, gradeFactory);
  }
}
