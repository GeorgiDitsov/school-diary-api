package com.ditsov.school_diary.controller.parent.helper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.entity.parent.Parent;
import com.ditsov.school_diary.core.entity.role.Role;
import com.ditsov.school_diary.core.entity.role.RoleName;
import com.ditsov.school_diary.core.factory.common.LabeledValueBeanFactory;
import com.ditsov.school_diary.core.factory.common.PageableBeanFactory;
import com.ditsov.school_diary.core.factory.parent.ParentFactory;
import com.ditsov.school_diary.core.service.parent.ParentService;
import com.ditsov.school_diary.core.service.role.RoleService;
import com.ditsov.school_diary.model.common.LabeledValueBean;
import com.ditsov.school_diary.model.common.PageableBean;
import com.ditsov.school_diary.model.parent.CreateParentRequestBean;
import com.ditsov.school_diary.model.parent.ParentResponseBean;
import com.ditsov.school_diary.model.parent.UpdateParentRequestBean;

@Component
public class ParentControllerHelper {

  @Autowired private ParentService parentService;

  @Autowired private PageableBeanFactory pageableBeanFactory;

  @Autowired private ParentFactory parentFactory;

  @Autowired private LabeledValueBeanFactory labeledValueBeanFactory;

  @Autowired private RoleService roleService;

  public PageableBean<ParentResponseBean> getPageOfParents(
      final Optional<Integer> page, final Optional<Integer> size) {
    Page<Parent> parents = parentService.getByOrderByFullName(page.orElse(0), size.orElse(10));

    return pageableBeanFactory.create(parents, parentFactory);
  }

  public List<LabeledValueBean<Long>> listAllParentsAsOptions() {
    List<Parent> parents = parentService.getAllByOrderByFullName();

    return parents
        .stream()
        .map(labeledValueBeanFactory::convertPersonToLabeledValueBean)
        .collect(Collectors.toList());
  }

  public void createParent(final CreateParentRequestBean parentBean) {
    Role parentRole = roleService.getByName(RoleName.ROLE_PARENT);
    Parent parent = parentFactory.convertCreateParentRequestBeanToParent(parentBean, parentRole);

    parentService.save(parent);
  }

  public void updateParent(final Long parentId, final UpdateParentRequestBean parentBean) {
    Parent parent = parentService.getById(parentId);

    parentFactory.populateParent(parent, parentBean);

    parentService.save(parent);
  }

  public void deleteParent(final Long parentId) {
    parentService.deleteById(parentId);
  }
}
