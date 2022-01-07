package com.ditsov.school_diary.core.factory.school.group;

import com.ditsov.school_diary.core.entity.school.group.SchoolGroup;
import com.ditsov.school_diary.model.school.group.CreateSchoolGroupRequestBean;
import com.ditsov.school_diary.model.school.group.UpdateSchoolGroupRequestBean;

public interface SchoolGroupFactory {

  /**
   * Creates an {@link SchoolGroup} with the given as parameters fields.
   *
   * @param id
   * @return
   */
  SchoolGroup createSchoolGroup(final Long id);

  /**
   * Converts a {@link CreateSchoolGroupRequestBean} into a {@link SchoolGroup}.
   *
   * @param bean
   * @return
   */
  SchoolGroup convertCreateSchoolGroupRequestBeanToSchoolGroup(
      final CreateSchoolGroupRequestBean bean);

  /**
   * Populates a {@link SchoolGroup} with {@link UpdateSchoolGroupRequestBean}.
   *
   * @param schoolGroup
   * @param bean
   */
  void populateSchoolGroup(final SchoolGroup schoolGroup, final UpdateSchoolGroupRequestBean bean);
}
