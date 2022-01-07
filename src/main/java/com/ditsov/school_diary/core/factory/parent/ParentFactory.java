package com.ditsov.school_diary.core.factory.parent;

import com.ditsov.school_diary.core.entity.parent.Parent;
import com.ditsov.school_diary.core.entity.role.Role;
import com.ditsov.school_diary.model.parent.CreateParentRequestBean;
import com.ditsov.school_diary.model.parent.ParentResponseBean;
import com.ditsov.school_diary.model.parent.UpdateParentRequestBean;

public interface ParentFactory {

  /**
   * Creates an entity of type {@link Parent} with the given as parameters fields.
   *
   * @param id
   * @return
   */
  Parent createParent(final Long id);

  /**
   * Converts an entity of type {@link Parent} into a {@link ParentResponseBean}.
   *
   * @param parent
   * @return
   */
  ParentResponseBean convertParentToParentResponseBean(final Parent parent);

  /**
   * Converts a {@link CreateParentRequestBean} into a {@link Parent}.
   *
   * @param bean
   * @param
   * @return
   */
  Parent convertCreateParentRequestBeanToParent(
      final CreateParentRequestBean bean, final Role... roles);

  /**
   * Populates a {@link Parent} with an {@link UpdateParentRequestBean}.
   *
   * @param parent
   * @param bean
   */
  void populateParent(final Parent parent, final UpdateParentRequestBean bean);
}
