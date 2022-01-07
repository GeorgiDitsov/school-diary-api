package com.ditsov.school_diary.core.factory.person;

import com.ditsov.school_diary.core.entity.person.Person;
import com.ditsov.school_diary.core.entity.role.Role;
import com.ditsov.school_diary.model.person.CreatePersonRequestBean;
import com.ditsov.school_diary.model.person.PersonResponseBean;
import com.ditsov.school_diary.model.person.UpdatePersonRequestBean;

public interface PersonFactory {

  /**
   * Populates a {@link PersonResponseBean} with {@link Person}.
   *
   * @param bean
   * @param person
   * @return
   */
  void populatePersonResponseBean(final PersonResponseBean bean, final Person person);

  /**
   * Populates a {@link Person} with {@link CreatePersonRequestBean}.
   *
   * @param person
   * @param bean
   * @param roles
   */
  void populatePerson(final Person person, final CreatePersonRequestBean bean, final Role... roles);

  /**
   * Populates a {@link Person} with non-null values from {@link UpdatePersonRequestBean}.
   *
   * @param person
   * @param bean
   */
  void populatePerson(final Person person, final UpdatePersonRequestBean bean);
}
