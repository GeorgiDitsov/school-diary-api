package com.ditsov.school_diary.core.factory.student.impl;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.entity.parent.Parent;
import com.ditsov.school_diary.core.entity.school.group.SchoolGroup;
import com.ditsov.school_diary.core.entity.student.Student;
import com.ditsov.school_diary.core.factory.common.LabeledValueFactory;
import com.ditsov.school_diary.core.factory.person.PersonFactory;
import com.ditsov.school_diary.core.factory.student.StudentFactory;
import com.ditsov.school_diary.model.student.StudentResponseBean;

@Component
public class StudentFactoryImpl implements StudentFactory {

  @Autowired private LabeledValueFactory labeledValueFactory;

  /**
   * @see PersonFactory#addAditional(com.ditsov.school_diary.model.person.PersonResponseBean,
   *     com.ditsov.school_diary.core.entity.person.Person)
   */
  @Override
  public StudentResponseBean addAditional(final StudentResponseBean bean, final Student person) {
    if (person.getSchoolGroup() != null) {
      bean.setGroup(
          labeledValueFactory.create(
              this.getGroupName(person.getSchoolGroup()), person.getSchoolGroup().getId()));
    }

    if (!person.getParents().isEmpty()) {
      bean.setParents(
          person
              .getParents()
              .stream()
              .map(parent -> labeledValueFactory.create(getParentName(parent), parent.getId()))
              .collect(Collectors.toList()));
    }

    return bean;
  }

  private String getGroupName(final SchoolGroup schoolGroup) {
    return schoolGroup.getYear().toString() + schoolGroup.getIndex();
  }

  private String getParentName(final Parent parent) {
    return String.format("%s %s", parent.getFirstName(), parent.getLastName());
  }
}
