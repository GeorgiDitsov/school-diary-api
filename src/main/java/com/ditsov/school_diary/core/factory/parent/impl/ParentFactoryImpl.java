package com.ditsov.school_diary.core.factory.parent.impl;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.entity.parent.Parent;
import com.ditsov.school_diary.core.entity.role.Role;
import com.ditsov.school_diary.core.factory.common.LabeledValueBeanFactory;
import com.ditsov.school_diary.core.factory.parent.ParentFactory;
import com.ditsov.school_diary.core.factory.person.PersonFactory;
import com.ditsov.school_diary.model.parent.CreateParentRequestBean;
import com.ditsov.school_diary.model.parent.ParentResponseBean;
import com.ditsov.school_diary.model.parent.UpdateParentRequestBean;

@Component
public class ParentFactoryImpl implements ParentFactory {

  @Autowired private PersonFactory personFactory;

  @Autowired private LabeledValueBeanFactory labeledValueBeanFactory;

  /** @see ParentFactory#createParent(Long) */
  @Override
  public Parent createParent(final Long id) {
    Parent parent = new Parent();

    parent.setId(id);

    return parent;
  }

  /** @see ParentFactory#convertToResponseBean(Parent) */
  @Override
  public ParentResponseBean convertToResponseBean(final Parent entity) {
    ParentResponseBean bean = new ParentResponseBean();

    personFactory.populatePersonResponseBean(bean, entity);

    bean.setChildren(
        entity
            .getChildren()
            .stream()
            .map(labeledValueBeanFactory::convertPersonToLabeledValueBean)
            .collect(Collectors.toList()));

    return bean;
  }

  /** @see ParentFactory#convertCreateParentRequestBeanToParent(CreateParentRequestBean, Role...) */
  @Override
  public Parent convertCreateParentRequestBeanToParent(
      final CreateParentRequestBean bean, final Role... roles) {
    Parent parent = new Parent();

    personFactory.populatePerson(parent, bean, roles);

    return parent;
  }

  /** @see ParentFactory#populateParent(Parent, UpdateParentRequestBean) */
  @Override
  public void populateParent(final Parent parent, final UpdateParentRequestBean bean) {
    personFactory.populatePerson(parent, bean);
  }
}
