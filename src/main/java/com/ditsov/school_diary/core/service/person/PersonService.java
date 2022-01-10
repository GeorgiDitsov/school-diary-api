package com.ditsov.school_diary.core.service.person;

import com.ditsov.school_diary.core.entity.person.Person;

public interface PersonService {

  /**
   * Retrieves a person by user id.
   *
   * @param userId
   * @return
   */
  Person getByUserId(final Long userId);
}
