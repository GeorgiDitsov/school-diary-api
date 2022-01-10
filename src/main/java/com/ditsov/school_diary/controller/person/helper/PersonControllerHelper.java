package com.ditsov.school_diary.controller.person.helper;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.entity.person.Person;
import com.ditsov.school_diary.core.factory.person.PersonFactory;
import com.ditsov.school_diary.core.service.person.PersonService;
import com.ditsov.school_diary.model.person.PersonResponseBean;

@Component
public class PersonControllerHelper {

  @Autowired private PersonService personService;

  @Autowired private PersonFactory personFactory;

  public List<PersonResponseBean> listPeopleBy(final Long userId) {
    Person person = personService.getByUserId(userId);
    PersonResponseBean bean = new PersonResponseBean();

    personFactory.populatePersonResponseBean(bean, person);

    return Arrays.asList(bean);
  }
}
