package com.ditsov.school_diary.core.factory.school.subject;

import com.ditsov.school_diary.core.entity.school.subject.SchoolSubject;
import com.ditsov.school_diary.model.school.subject.CreateSchoolSubjectRequestBean;
import com.ditsov.school_diary.model.school.subject.UpdateSchoolSubjectRequestBean;

public interface SchoolSubjectFactory {

  /**
   * Creates an {@link SchoolSubject} with the given as parameters fields.
   *
   * @param id
   * @param name
   * @return
   */
  SchoolSubject createSchoolSubject(final Long id, final String name);

  /**
   * Converts a {@link CreateSchoolSubjectRequestBean} into a {@link SchoolSubject}.
   *
   * @param bean
   * @return
   */
  SchoolSubject convertCreateSchoolSubjectToSchoolSubject(
      final CreateSchoolSubjectRequestBean bean);

  /**
   * Populates a {@link SchoolSubject} with an {@link UpdateSchoolSubjectRequestBean}.
   *
   * @param schoolSubject
   * @param bean
   */
  void populateSchoolSubject(
      final SchoolSubject schoolSubject, final UpdateSchoolSubjectRequestBean bean);
}
