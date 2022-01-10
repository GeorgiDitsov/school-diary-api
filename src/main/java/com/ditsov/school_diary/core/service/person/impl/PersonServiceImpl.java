package com.ditsov.school_diary.core.service.person.impl;

import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ditsov.school_diary.core.entity.person.Person;
import com.ditsov.school_diary.core.repository.person.PersonRepository;
import com.ditsov.school_diary.core.service.person.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

  @Autowired private PersonRepository personRepository;

  /** @see PersonService#getByUserId(Long) */
  @Override
  public Person getByUserId(final Long userId) {
    return personRepository.findByUserId(userId).orElseThrow(EntityNotFoundException::new);
  }
}
