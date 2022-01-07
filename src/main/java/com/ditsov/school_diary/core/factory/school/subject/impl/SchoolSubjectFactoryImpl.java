package com.ditsov.school_diary.core.factory.school.subject.impl;

import java.util.Optional;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.entity.school.subject.SchoolSubject;
import com.ditsov.school_diary.core.factory.school.subject.SchoolSubjectFactory;
import com.ditsov.school_diary.model.school.subject.CreateSchoolSubjectRequestBean;
import com.ditsov.school_diary.model.school.subject.UpdateSchoolSubjectRequestBean;

@Component
public class SchoolSubjectFactoryImpl implements SchoolSubjectFactory {

  /** @see SchoolSubjectFactory#createSchoolSubject(Long, String) */
  @Override
  public SchoolSubject createSchoolSubject(final Long id, final String name) {
    SchoolSubject schoolSubject = new SchoolSubject();

    schoolSubject.setId(id);
    schoolSubject.setName(name);

    return schoolSubject;
  }

  /**
   * @see
   *     SchoolSubjectFactory#convertCreateSchoolSubjectToSchoolSubject(CreateSchoolSubjectRequestBean)
   */
  @Override
  public SchoolSubject convertCreateSchoolSubjectToSchoolSubject(
      final CreateSchoolSubjectRequestBean bean) {
    SchoolSubject schoolSubject = new SchoolSubject();

    schoolSubject.setName(bean.getName());

    return schoolSubject;
  }

  /**
   * @see SchoolSubjectFactory#populateSchoolSubject(SchoolSubject, UpdateSchoolSubjectRequestBean)
   */
  @Override
  public void populateSchoolSubject(
      final SchoolSubject schoolSubject, final UpdateSchoolSubjectRequestBean bean) {
    Optional.ofNullable(bean.getName()).ifPresent(schoolSubject::setName);
  }
}
