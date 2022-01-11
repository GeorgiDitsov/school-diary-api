package com.ditsov.school_diary.controller.student.helper;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.entity.role.Role;
import com.ditsov.school_diary.core.entity.role.RoleName;
import com.ditsov.school_diary.core.entity.school.course.SchoolCourse;
import com.ditsov.school_diary.core.entity.student.Student;
import com.ditsov.school_diary.core.factory.common.LabeledValueBeanFactory;
import com.ditsov.school_diary.core.factory.common.PageableBeanFactory;
import com.ditsov.school_diary.core.factory.school.course.SchoolCourseFactory;
import com.ditsov.school_diary.core.factory.student.StudentFactory;
import com.ditsov.school_diary.core.service.grade.GradeService;
import com.ditsov.school_diary.core.service.role.RoleService;
import com.ditsov.school_diary.core.service.school.course.SchoolCourseService;
import com.ditsov.school_diary.core.service.student.StudentService;
import com.ditsov.school_diary.model.common.LabeledValueBean;
import com.ditsov.school_diary.model.common.PageableBean;
import com.ditsov.school_diary.model.school.course.ExtendedSchoolCourseResponseBean;
import com.ditsov.school_diary.model.student.CreateStudentRequestBean;
import com.ditsov.school_diary.model.student.StudentResponseBean;
import com.ditsov.school_diary.model.student.UpdateStudentRequestBean;

@Component
public class StudentControllerHelper {

  @Autowired private StudentService studentService;

  @Autowired private PageableBeanFactory pageableBeanFactory;

  @Autowired private StudentFactory studentFactory;

  @Autowired private LabeledValueBeanFactory labeledValueBeanFactory;

  @Autowired private RoleService roleService;

  @Autowired private SchoolCourseService schoolCourseService;

  @Autowired private SchoolCourseFactory schoolCourseFactory;

  @Autowired private GradeService gradeService;

  public PageableBean<StudentResponseBean> getPageOfStudents(
      final Optional<Integer> page, final Optional<Integer> size) {
    Page<Student> students = studentService.getByOrderByFullName(page.orElse(0), size.orElse(10));

    return pageableBeanFactory.create(students, studentFactory);
  }

  public List<LabeledValueBean<Long>> listAllStudentsAsOptions() {
    List<Student> students = studentService.getAllByOrderByFullName();

    return students
        .stream()
        .map(labeledValueBeanFactory::convertPersonToLabeledValueBean)
        .collect(Collectors.toList());
  }

  public List<ExtendedSchoolCourseResponseBean> listAllSchoolCoursesByStudent(
      final Long studentId, final Long schoolSemesterId) {
    Student student = studentService.getById(studentId);

    List<SchoolCourse> schoolCourses =
        student.getSchoolGroup() == null
            ? Arrays.asList()
            : schoolCourseService.getAllBySchoolGroupIdAndSchoolSemesterId(
                student.getSchoolGroup().getId(), schoolSemesterId);

    return schoolCourses
        .stream()
        .map(
            schoolCourse ->
                schoolCourseFactory.convertSchoolCourseToExtendedSchoolCourseResponseBean(
                    schoolCourse, null))
        .collect(Collectors.toList());
  }

  public void createStudent(final CreateStudentRequestBean studentBean) {
    Role studentRole = roleService.getByName(RoleName.ROLE_STUDENT);
    Student student =
        studentFactory.convertCreateStudentRequestBeanToStudent(studentBean, studentRole);

    studentService.save(student);
  }

  public void updateStudent(final Long studentId, final UpdateStudentRequestBean studentBean) {
    Student student = studentService.getById(studentId);

    studentFactory.populateStudent(student, studentBean);

    studentService.save(student);
  }

  public void deleteStudent(final Long studentId) {
    studentService.deleteById(studentId);
  }
}
