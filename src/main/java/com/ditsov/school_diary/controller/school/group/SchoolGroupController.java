package com.ditsov.school_diary.controller.school.group;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ditsov.school_diary.controller.school.group.helper.SchoolGroupControllerHelper;
import com.ditsov.school_diary.model.common.LabeledValueBean;
import com.ditsov.school_diary.model.school.group.CreateSchoolGroupRequestBean;
import com.ditsov.school_diary.model.school.group.UpdateSchoolGroupRequestBean;
import io.swagger.annotations.Api;

@Api(tags = "School Group APIs")
@Secured("ROLE_ADMIN")
@RestController
@RequestMapping("/v1/school-groups")
public class SchoolGroupController {

  @Autowired private SchoolGroupControllerHelper schoolGroupControllerHelper;

  @GetMapping
  public List<LabeledValueBean<Long>> listAllSchoolGroups() {
    return schoolGroupControllerHelper.listAllSchoolGroups();
  }

  @PostMapping
  public void createSchoolGroup(@RequestBody @Valid final CreateSchoolGroupRequestBean bean) {
    schoolGroupControllerHelper.createSchoolGroup(bean);
  }

  @PatchMapping("/{id}")
  public void updateSchoolGroup(
      @PathVariable(name = "id") @Min(1) final Long schoolGroupId,
      @RequestBody @Valid final UpdateSchoolGroupRequestBean bean) {
    schoolGroupControllerHelper.updateSchoolGroup(schoolGroupId, bean);
  }

  @DeleteMapping("/{id}")
  public void deleteSchoolGroup(@PathVariable(name = "id") @Min(1) final Long schoolGroupId) {
    schoolGroupControllerHelper.deleteSchoolGroup(schoolGroupId);
  }
}
