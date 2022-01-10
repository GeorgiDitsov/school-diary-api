package com.ditsov.school_diary.core.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.ditsov.school_diary.core.entity.school.course.SchoolCourse;
import com.ditsov.school_diary.core.entity.student.Student;
import com.ditsov.school_diary.core.entity.teacher.Teacher;
import com.ditsov.school_diary.core.entity.user.User;
import com.ditsov.school_diary.core.service.authentication.AuthenticationService;
import com.ditsov.school_diary.core.service.school.course.SchoolCourseService;
import com.ditsov.school_diary.core.service.student.StudentService;
import com.ditsov.school_diary.core.service.teacher.TeacherService;
import com.ditsov.school_diary.core.validator.constraint.Grade;
import com.ditsov.school_diary.model.grade.CreateGradeRequestBean;

public class GradeValidator implements ConstraintValidator<Grade, CreateGradeRequestBean> {

  @Autowired private AuthenticationService authenticationService;

  @Autowired private StudentService studentService;

  @Autowired private SchoolCourseService schoolCourseService;

  @Autowired private TeacherService teacherService;

  @Override
  public boolean isValid(CreateGradeRequestBean value, ConstraintValidatorContext context) {
    User teacherUser = authenticationService.getCurrentAuthenticatedUser();
    Teacher teacher = teacherService.getByUserId(teacherUser.getId());
    SchoolCourse schoolCourse = schoolCourseService.getById(value.getSchoolCourseId());
    Student student = studentService.getById(value.getStudentId());

    return schoolCourse.getSchoolGroup().getStudents().contains(student)
        && schoolCourse.getTeacher().equals(teacher);
  }
}
