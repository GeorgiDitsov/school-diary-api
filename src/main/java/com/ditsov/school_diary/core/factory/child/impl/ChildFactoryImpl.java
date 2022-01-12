package com.ditsov.school_diary.core.factory.child.impl;

import java.util.Optional;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.entity.student.Student;
import com.ditsov.school_diary.core.factory.child.ChildFactory;
import com.ditsov.school_diary.model.child.ChildResponseBean;

@Component
public class ChildFactoryImpl implements ChildFactory {

  /** @see ChildFactory#convertStudentToChildResponseBean(Student) */
  @Override
  public ChildResponseBean convertStudentToChildResponseBean(final Student student) {
    ChildResponseBean bean = new ChildResponseBean();

    bean.setId(student.getId());
    bean.setFullName(String.format("%s %s", student.getFirstName(), student.getLastName()));
    bean.setPin(String.format("%s****", student.getPin().substring(0, 6)));
    Optional.ofNullable(student.getSchoolGroup())
        .ifPresent(
            schoolGroup ->
                bean.setGroup(
                    String.format("%s%s", schoolGroup.getId().toString(), schoolGroup.getIndex())));

    return bean;
  }
}
