package com.ditsov.school_diary.core.factory.person;

import com.ditsov.school_diary.core.entity.person.Person;
import com.ditsov.school_diary.model.person.PersonResponseBean;

public interface PersonFactory<T extends PersonResponseBean, E extends Person> {

  /**
   * Base converting process of entity which extends {@link Person} into bean which extends {@link
   * PersonResponseBean}.
   *
   * @param person
   * @return
   */
  @SuppressWarnings("unchecked")
  default T convert(final E person) {
    T bean = (T) new PersonResponseBean();

    bean.setId(person.getId());
    bean.setFullName(String.format("%s %s", person.getFirstName(), person.getLastName()));
    bean.setPin(person.getPin());
    bean.setUsername(person.getUser().getUsername());

    return addAditional(bean, person);
  }

  /**
   * Sets additional fields to the bean which extends {@link PersonResponseBean} from the entity
   * which extends {@link Person}.
   *
   * @param person
   * @return
   */
  T addAditional(final T bean, final E person);
}
