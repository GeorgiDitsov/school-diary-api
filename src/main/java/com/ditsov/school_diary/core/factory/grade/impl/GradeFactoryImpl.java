package com.ditsov.school_diary.core.factory.grade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.entity.grade.Grade;
import com.ditsov.school_diary.core.factory.common.LabeledValueBeanFactory;
import com.ditsov.school_diary.core.factory.grade.GradeFactory;
import com.ditsov.school_diary.model.grade.GradeResponseBean;

@Component
public class GradeFactoryImpl implements GradeFactory {

  @Autowired private LabeledValueBeanFactory labeledValueBeanFactory;

  /** @see GradeFactory#convertGradeToGradeResponseBean(Grade) */
  @Override
  public GradeResponseBean convertGradeToGradeResponseBean(final Grade grade) {
    GradeResponseBean bean = new GradeResponseBean();

    bean.setId(grade.getId());
    bean.setValue(grade.getValue());
    bean.setCreatedAt(grade.getCreatedAt());
    bean.setUpdatedAt(grade.getUpdatedAt());
    bean.setStudent(labeledValueBeanFactory.convertPersonToLabeledValueBean(grade.getStudent()));
    bean.setCourse(
        labeledValueBeanFactory.convertSchoolCourseToLabeledValueBean(grade.getSchoolCourse()));

    return bean;
  }
}
