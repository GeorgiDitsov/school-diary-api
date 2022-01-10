package com.ditsov.school_diary.controller.grade.helper;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.xml.bind.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.entity.grade.Grade;
import com.ditsov.school_diary.core.entity.school.course.SchoolCourse;
import com.ditsov.school_diary.core.entity.student.Student;
import com.ditsov.school_diary.core.entity.teacher.Teacher;
import com.ditsov.school_diary.core.entity.user.User;
import com.ditsov.school_diary.core.factory.common.PageableBeanFactory;
import com.ditsov.school_diary.core.factory.grade.GradeFactory;
import com.ditsov.school_diary.core.service.authentication.AuthenticationService;
import com.ditsov.school_diary.core.service.grade.GradeService;
import com.ditsov.school_diary.core.service.school.course.SchoolCourseService;
import com.ditsov.school_diary.core.service.student.StudentService;
import com.ditsov.school_diary.core.service.teacher.TeacherService;
import com.ditsov.school_diary.model.common.PageableBean;
import com.ditsov.school_diary.model.grade.CreateGradeRequestBean;
import com.ditsov.school_diary.model.grade.GradeRequestBean;
import com.ditsov.school_diary.model.grade.GradeResponseBean;
import com.ditsov.school_diary.model.grade.GradeStatistics;

@Component
public class GradeControllerHelper {

  @Autowired private GradeService gradeService;

  @Autowired private PageableBeanFactory pageableBeanFactory;

  @Autowired private GradeFactory gradeFactory;

  @Autowired private AuthenticationService authenticationService;

  @Autowired private StudentService studentService;

  @Autowired private SchoolCourseService schoolCourseService;

  @Autowired private TeacherService teacherService;

  public List<GradeResponseBean> listAllGradesBy(final Long schoolCourseId) {
    List<Grade> grades = gradeService.getAllBySchoolCourseId(schoolCourseId);

    return grades.stream().map(gradeFactory::convertToResponseBean).collect(Collectors.toList());
  }

  public PageableBean<GradeResponseBean> getPageOfGrades(
      final Optional<Integer> page, final Optional<Integer> size) {
    Page<Grade> grades = gradeService.getByOrderByUpdatedAtDesc(page.orElse(0), size.orElse(10));

    return pageableBeanFactory.create(grades, gradeFactory);
  }

  public void createGrade(final CreateGradeRequestBean gradeBean) {
    User teacherUser = authenticationService.getCurrentAuthenticatedUser();
    Teacher teacher = teacherService.getByUserId(teacherUser.getId());
    Student student = studentService.getById(gradeBean.getStudentId());
    SchoolCourse schoolCourse = schoolCourseService.getById(gradeBean.getSchoolCourseId());

    Grade grade = gradeFactory.createGrade(gradeBean.getValue(), student, schoolCourse, teacher);

    gradeService.save(grade);
  }

  public void updateGrade(final Long gradeId, final GradeRequestBean gradeBean)
      throws ValidationException {
    User teacherUser = authenticationService.getCurrentAuthenticatedUser();
    Teacher teacher = teacherService.getByUserId(teacherUser.getId());
    Grade grade = gradeService.getById(gradeId);

    if (grade.getSchoolCourse().getTeacher().equals(teacher)) {
      gradeFactory.populateGrade(grade, gradeBean.getValue(), teacher);

      gradeService.save(grade);
    } else {
      throw new ValidationException(
          "Current authenticated user doesn't has rights about this grade.");
    }
  }

  public List<GradeStatistics> listGradesStatisticsBy(
      final Optional<Long> studentId, final Optional<Long> schoolCourseId) {
    if (studentId.isPresent()) {
      return gradeService.getGradesStatisticsByStudentId(studentId.get());
    }

    if (schoolCourseId.isPresent()) {
      return gradeService.getGradesStatisticsBySchoolCourseId(schoolCourseId.get());
    }

    return Arrays.asList();
  }
}
