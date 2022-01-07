package com.ditsov.school_diary.core.factory.school.group.impl;

import java.util.Optional;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.entity.school.group.SchoolGroup;
import com.ditsov.school_diary.core.factory.school.group.SchoolGroupFactory;
import com.ditsov.school_diary.model.school.group.CreateSchoolGroupRequestBean;
import com.ditsov.school_diary.model.school.group.UpdateSchoolGroupRequestBean;

@Component
public class SchoolGroupFactoryImpl implements SchoolGroupFactory {

  /** @see SchoolGroupFactory#createSchoolGroup(Long) */
  @Override
  public SchoolGroup createSchoolGroup(final Long id) {
    SchoolGroup schoolGroup = new SchoolGroup();

    schoolGroup.setId(id);

    return schoolGroup;
  }

  /**
   * @see
   *     SchoolGroupFactory#convertCreateSchoolGroupRequestBeanToSchoolGroup(CreateSchoolGroupRequestBean)
   */
  @Override
  public SchoolGroup convertCreateSchoolGroupRequestBeanToSchoolGroup(
      final CreateSchoolGroupRequestBean bean) {
    SchoolGroup schoolGroup = new SchoolGroup();

    schoolGroup.setYear(bean.getYear());
    schoolGroup.setIndex(bean.getIndex());

    return schoolGroup;
  }

  /** @see SchoolGroupFactory#populateSchoolGroup(SchoolGroup, UpdateSchoolGroupRequestBean) */
  @Override
  public void populateSchoolGroup(
      final SchoolGroup schoolGroup, final UpdateSchoolGroupRequestBean bean) {
    Optional.ofNullable(bean.getYear()).ifPresent(schoolGroup::setYear);
    Optional.ofNullable(bean.getIndex()).ifPresent(schoolGroup::setIndex);
  }
}
