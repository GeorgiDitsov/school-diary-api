package com.ditsov.school_diary.controller.school.group.helper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.entity.school.group.SchoolGroup;
import com.ditsov.school_diary.core.factory.common.LabeledValueBeanFactory;
import com.ditsov.school_diary.core.factory.school.group.SchoolGroupFactory;
import com.ditsov.school_diary.core.service.school.group.SchoolGroupService;
import com.ditsov.school_diary.model.common.LabeledValueBean;
import com.ditsov.school_diary.model.school.group.CreateSchoolGroupRequestBean;
import com.ditsov.school_diary.model.school.group.UpdateSchoolGroupRequestBean;

@Component
public class SchoolGroupControllerHelper {

  @Autowired private SchoolGroupService schoolGroupService;

  @Autowired private LabeledValueBeanFactory labeledValueBeanFactory;

  @Autowired private SchoolGroupFactory schoolGroupFactory;

  public List<LabeledValueBean<Long>> listSchoolGroups(
      final Optional<Integer> page, final Optional<Integer> size) {
    List<SchoolGroup> groups =
        schoolGroupService.getByOrderByName(page.orElse(0), page.orElse(10));

    return groups
        .stream()
        .map(labeledValueBeanFactory::convertSchoolGroupToLabeledValueBean)
        .collect(Collectors.toList());
  }

  public void createSchoolGroup(final CreateSchoolGroupRequestBean bean) {
    SchoolGroup schoolGroup =
        schoolGroupFactory.convertCreateSchoolGroupRequestBeanToSchoolGroup(bean);

    schoolGroupService.save(schoolGroup);
  }

  public void updateSchoolGroup(final Long schoolGroupId, final UpdateSchoolGroupRequestBean bean) {
    SchoolGroup schoolGroup = schoolGroupService.getById(schoolGroupId);

    schoolGroupFactory.populateSchoolGroup(schoolGroup, bean);

    schoolGroupService.save(schoolGroup);
  }

  public void deleteSchoolGroup(final Long schoolGroupId) {
    schoolGroupService.deleteById(schoolGroupId);
  }
}
