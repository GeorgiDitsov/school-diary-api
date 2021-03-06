package com.ditsov.school_diary.controller.teacher.helper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.entity.role.Role;
import com.ditsov.school_diary.core.entity.role.RoleName;
import com.ditsov.school_diary.core.entity.school.course.SchoolCourse;
import com.ditsov.school_diary.core.entity.teacher.Teacher;
import com.ditsov.school_diary.core.factory.common.LabeledValueBeanFactory;
import com.ditsov.school_diary.core.factory.common.PageableBeanFactory;
import com.ditsov.school_diary.core.factory.school.course.SchoolCourseFactory;
import com.ditsov.school_diary.core.factory.teacher.TeacherFactory;
import com.ditsov.school_diary.core.service.grade.GradeService;
import com.ditsov.school_diary.core.service.role.RoleService;
import com.ditsov.school_diary.core.service.school.course.SchoolCourseService;
import com.ditsov.school_diary.core.service.teacher.TeacherService;
import com.ditsov.school_diary.model.common.LabeledValueBean;
import com.ditsov.school_diary.model.common.PageableBean;
import com.ditsov.school_diary.model.school.course.ExtendedSchoolCourseResponseBean;
import com.ditsov.school_diary.model.teacher.CreateTeacherRequestBean;
import com.ditsov.school_diary.model.teacher.TeacherResponseBean;
import com.ditsov.school_diary.model.teacher.UpdateTeacherRequestBean;

@Component
public class TeacherControllerHelper {

  @Autowired private TeacherService teacherService;

  @Autowired private PageableBeanFactory pageableBeanFactory;

  @Autowired private TeacherFactory teacherFactory;

  @Autowired private LabeledValueBeanFactory labeledValueBeanFactory;

  @Autowired private RoleService roleService;

  @Autowired private SchoolCourseService schoolCourseService;

  @Autowired private SchoolCourseFactory schoolCourseFactory;

  @Autowired private GradeService gradeService;

  public PageableBean<TeacherResponseBean> getPageOfTeachers(
      final Optional<Integer> page, final Optional<Integer> size) {
    Page<Teacher> teachers = teacherService.getByOrderByFullName(page.orElse(0), size.orElse(10));

    return pageableBeanFactory.create(teachers, teacherFactory);
  }

  public List<LabeledValueBean<Long>> listAllTeachersAsOptions() {
    List<Teacher> teachers = teacherService.getAllByOrderByFullName();

    return teachers
        .stream()
        .map(labeledValueBeanFactory::convertPersonToLabeledValueBean)
        .collect(Collectors.toList());
  }

  public List<LabeledValueBean<Long>> listAllSchoolSubjectsByTeacher(final Long teacherId) {
    Teacher teacher = teacherService.getById(teacherId);

    return teacher
        .getSchoolSubjects()
        .stream()
        .map(labeledValueBeanFactory::convertSchoolSubjectToLabeledValueBean)
        .collect(Collectors.toList());
  }

  public List<ExtendedSchoolCourseResponseBean> listAllSchoolCoursesByTeacher(
      final Long teacherId, final Long schoolSemesterId) {
    List<SchoolCourse> schoolCourses =
        schoolCourseService.getAllByTeacherIdAndSchoolSemesterId(teacherId, schoolSemesterId);

    return schoolCourses
        .stream()
        .map(
            schoolCourse ->
                schoolCourseFactory.convertSchoolCourseToExtendedSchoolCourseResponseBean(
                    schoolCourse, gradeService.getSuccessBySchoolCourseId(schoolCourse.getId())))
        .collect(Collectors.toList());
  }

  public void createTeacher(final CreateTeacherRequestBean teacherBean) {
    Role roleTeacher = roleService.getByName(RoleName.ROLE_TEACHER);
    Teacher teacher =
        teacherFactory.convertCreateTeacherRequestBeanToTeacher(teacherBean, roleTeacher);

    teacherService.save(teacher);
  }

  public void updateTeacher(final Long teacherId, final UpdateTeacherRequestBean teacherBean) {
    Teacher teacher = teacherService.getById(teacherId);

    teacherFactory.populateTeacher(teacher, teacherBean);

    teacherService.save(teacher);
  }

  public void deleteTeacher(final Long teacherId) {
    teacherService.deleteById(teacherId);
  }

  public TeacherResponseBean getTeacherByUser(final Long userId) {
    return null;
  }
}
