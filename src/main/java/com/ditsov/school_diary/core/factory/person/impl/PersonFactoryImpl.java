package com.ditsov.school_diary.core.factory.person.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.entity.person.Person;
import com.ditsov.school_diary.core.entity.role.Role;
import com.ditsov.school_diary.core.factory.person.PersonFactory;
import com.ditsov.school_diary.core.factory.user.UserFactory;
import com.ditsov.school_diary.model.person.CreatePersonRequestBean;
import com.ditsov.school_diary.model.person.PersonResponseBean;
import com.ditsov.school_diary.model.person.UpdatePersonRequestBean;

@Component
public class PersonFactoryImpl implements PersonFactory {

  @Autowired private UserFactory userFactory;

  /** @see PersonFactory#populatePersonResponseBean(PersonResponseBean, Person) */
  @Override
  public void populatePersonResponseBean(final PersonResponseBean bean, final Person person) {
    bean.setId(person.getId());
    bean.setFirstName(person.getFirstName());
    bean.setLastName(person.getLastName());
    bean.setPin(person.getPin());
    bean.setUsername(person.getUser().getUsername());
  }

  /** @see PersonFactory#populatePerson(Person, CreatePersonRequestBean, Role...) */
  @Override
  public void populatePerson(
      final Person person, final CreatePersonRequestBean bean, final Role... roles) {
    person.setFirstName(bean.getFirstName());
    person.setLastName(bean.getLastName());
    person.setPin(bean.getPin());
    person.setUser(userFactory.convertCreateUserRequestBeanToUser(bean.getUser(), roles));
  }

  /** @see PersonFactory#populatePerson(Person, UpdatePersonRequestBean) */
  @Override
  public void populatePerson(final Person person, final UpdatePersonRequestBean bean) {
    Optional.ofNullable(bean.getFirstName()).ifPresent(person::setFirstName);
    Optional.ofNullable(bean.getLastName()).ifPresent(person::setLastName);
    Optional.ofNullable(bean.getPin()).ifPresent(person::setPin);
  }
}
