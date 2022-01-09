package com.ditsov.school_diary.core.factory.grade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.entity.grade.Grade;
import com.ditsov.school_diary.core.factory.AbstractFactory;
import com.ditsov.school_diary.core.factory.common.LabeledValueBeanFactory;
import com.ditsov.school_diary.core.factory.grade.GradeFactory;
import com.ditsov.school_diary.model.grade.GradeResponseBean;

@Component
public class GradeFactoryImpl implements GradeFactory {

  @Autowired private LabeledValueBeanFactory labeledValueBeanFactory;

  /** @see AbstractFactory#convertToResponseBean(Object) */
  @Override
  public GradeResponseBean convertToResponseBean(final Grade entity) {
    GradeResponseBean bean = new GradeResponseBean();

    bean.setId(entity.getId());
    bean.setValue(entity.getValue());
    bean.setCreatedAt(entity.getCreatedAt());
    bean.setUpdatedAt(entity.getUpdatedAt());
    bean.setStudent(labeledValueBeanFactory.convertPersonToLabeledValueBean(entity.getStudent()));
    bean.setCourse(
        labeledValueBeanFactory.convertSchoolCourseToLabeledValueBean(entity.getSchoolCourse()));

    return bean;
  }
}
