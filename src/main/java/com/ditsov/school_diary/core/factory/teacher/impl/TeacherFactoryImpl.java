package com.ditsov.school_diary.core.factory.teacher.impl;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.entity.role.Role;
import com.ditsov.school_diary.core.entity.teacher.Teacher;
import com.ditsov.school_diary.core.factory.common.LabeledValueBeanFactory;
import com.ditsov.school_diary.core.factory.person.PersonFactory;
import com.ditsov.school_diary.core.factory.school.subject.SchoolSubjectFactory;
import com.ditsov.school_diary.core.factory.teacher.TeacherFactory;
import com.ditsov.school_diary.model.common.LabeledValueBean;
import com.ditsov.school_diary.model.teacher.CreateTeacherRequestBean;
import com.ditsov.school_diary.model.teacher.TeacherResponseBean;
import com.ditsov.school_diary.model.teacher.UpdateTeacherRequestBean;

@Component
public class TeacherFactoryImpl implements TeacherFactory {

  @Autowired private PersonFactory personFactory;

  @Autowired private LabeledValueBeanFactory labeledValueBeanFactory;

  @Autowired private SchoolSubjectFactory schoolSubjectFactory;

  /** @see TeacherFactory#createTeacher(Long) */
  @Override
  public Teacher createTeacher(final Long id) {
    Teacher teacher = new Teacher();

    teacher.setId(id);

    return teacher;
  }

  /** @see TeacherFactory#convertTeacherToTeacherResponseBean(Teacher) */
  @Override
  public TeacherResponseBean convertTeacherToTeacherResponseBean(final Teacher teacher) {
    TeacherResponseBean bean = new TeacherResponseBean();

    personFactory.populatePersonResponseBean(bean, teacher);

    bean.setSubjects(
        teacher
            .getSchoolSubjects()
            .stream()
            .map(labeledValueBeanFactory::convertSchoolSubjectToLabeledValueBean)
            .collect(Collectors.toList()));

    return bean;
  }

  /**
   * @see TeacherFactory#convertCreateTeacherRequestBeanToTeacher(CreateTeacherRequestBean, Role...)
   */
  @Override
  public Teacher convertCreateTeacherRequestBeanToTeacher(
      final CreateTeacherRequestBean teacherBean, final Role... roles) {
    Teacher teacher = new Teacher();

    personFactory.populatePerson(teacher, teacherBean, roles);

    populateSchoolSubjects(teacher, teacherBean.getSubjects());

    return teacher;
  }

  private void populateSchoolSubjects(
      final Teacher teacher, final Set<LabeledValueBean<Long>> schoolSubjects) {
    teacher.setSchoolSubjects(
        schoolSubjects
            .stream()
            .map(
                schoolSubject ->
                    schoolSubjectFactory.createSchoolSubject(
                        schoolSubject.getValue(), schoolSubject.getLabel()))
            .collect(Collectors.toSet()));
  }

  /** @see TeacherFactory#populateTeacher(Teacher, UpdateTeacherRequestBean) */
  @Override
  public void populateTeacher(final Teacher teacher, final UpdateTeacherRequestBean teacherBean) {
    personFactory.populatePerson(teacher, teacherBean);

    Optional.ofNullable(teacherBean.getSubjects())
        .ifPresent(subjects -> populateSchoolSubjects(teacher, subjects));
  }
}
