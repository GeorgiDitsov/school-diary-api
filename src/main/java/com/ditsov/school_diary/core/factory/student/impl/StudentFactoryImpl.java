package com.ditsov.school_diary.core.factory.student.impl;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.entity.role.Role;
import com.ditsov.school_diary.core.entity.student.Student;
import com.ditsov.school_diary.core.factory.AbstractFactory;
import com.ditsov.school_diary.core.factory.common.LabeledValueBeanFactory;
import com.ditsov.school_diary.core.factory.parent.ParentFactory;
import com.ditsov.school_diary.core.factory.person.PersonFactory;
import com.ditsov.school_diary.core.factory.school.group.SchoolGroupFactory;
import com.ditsov.school_diary.core.factory.student.StudentFactory;
import com.ditsov.school_diary.model.common.LabeledValueBean;
import com.ditsov.school_diary.model.student.CreateStudentRequestBean;
import com.ditsov.school_diary.model.student.StudentResponseBean;
import com.ditsov.school_diary.model.student.UpdateStudentRequestBean;

@Component
public class StudentFactoryImpl implements StudentFactory {

  @Autowired private PersonFactory personFactory;

  @Autowired private LabeledValueBeanFactory labeledValueBeanFactory;

  @Autowired private SchoolGroupFactory schoolGroupFactory;

  @Autowired private ParentFactory parentFactory;

  /** @see AbstractFactory#convertToResponseBean(Object) */
  @Override
  public StudentResponseBean convertToResponseBean(final Student entity) {
    StudentResponseBean bean = new StudentResponseBean();

    personFactory.populatePersonResponseBean(bean, entity);

    Optional.ofNullable(entity.getSchoolGroup())
        .map(labeledValueBeanFactory::convertSchoolGroupToLabeledValueBean)
        .ifPresent(bean::setGroup);
    bean.setParents(
        entity
            .getParents()
            .stream()
            .map(labeledValueBeanFactory::convertPersonToLabeledValueBean)
            .collect(Collectors.toList()));

    return bean;
  }

  /**
   * @see StudentFactory#convertCreateStudentRequestBeanToStudent(CreateStudentRequestBean, Role...)
   */
  @Override
  public Student convertCreateStudentRequestBeanToStudent(
      final CreateStudentRequestBean bean, final Role... roles) {
    Student student = new Student();

    personFactory.populatePerson(student, bean, roles);

    Optional.ofNullable(bean.getGroup())
        .ifPresent(schoolGroup -> populateSchoolGroup(student, schoolGroup));
    populateParents(student, bean.getParents());

    return student;
  }

  private void populateSchoolGroup(
      final Student student, final LabeledValueBean<Long> schoolGroup) {
    student.setSchoolGroup(schoolGroupFactory.createSchoolGroup(schoolGroup.getValue()));
  }

  private void populateParents(final Student student, final Set<LabeledValueBean<Long>> parents) {
    student.setParents(
        parents
            .stream()
            .map(parent -> parentFactory.createParent(parent.getValue()))
            .collect(Collectors.toSet()));
  }

  /** @see StudentFactory#populateStudent(Student, UpdateStudentRequestBean) */
  @Override
  public void populateStudent(final Student student, final UpdateStudentRequestBean bean) {
    personFactory.populatePerson(student, bean);

    Optional.ofNullable(bean.getGroup())
        .ifPresent(schoolGroup -> populateSchoolGroup(student, schoolGroup));
    Optional.ofNullable(bean.getParents()).ifPresent(parents -> populateParents(student, parents));
  }
}
