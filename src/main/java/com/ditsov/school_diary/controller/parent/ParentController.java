package com.ditsov.school_diary.controller.parent;

import java.util.List;
import java.util.Optional;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ditsov.school_diary.controller.parent.helper.ParentControllerHelper;
import com.ditsov.school_diary.model.common.LabeledValueBean;
import com.ditsov.school_diary.model.parent.CreateParentRequestBean;
import com.ditsov.school_diary.model.parent.ParentResponseBean;
import com.ditsov.school_diary.model.parent.UpdateParentRequestBean;
import io.swagger.annotations.Api;

@Api(tags = "Parent APIs")
@Secured("ROLE_ADMIN")
@RestController
@RequestMapping("/v1/parents")
public class ParentController {

  @Autowired private ParentControllerHelper parentControllerHelper;

  @GetMapping
  public List<ParentResponseBean> listParents(
      @RequestParam(required = false) @Min(0) final Optional<Integer> page,
      @RequestParam(required = false) @Min(1) final Optional<Integer> size) {
    return parentControllerHelper.listParents(page, size);
  }

  @GetMapping("/options")
  public List<LabeledValueBean<Long>> listAllParentsAsOptions() {
    return parentControllerHelper.listAllParentsAsOptions();
  }

  @PostMapping
  public void createParent(@RequestBody @Valid final CreateParentRequestBean parentBean) {
    parentControllerHelper.createParent(parentBean);
  }

  @PatchMapping("/{id}")
  public void updateParent(
      @PathVariable(name = "id") @Min(1) final Long parentId,
      @RequestBody @Valid final UpdateParentRequestBean parentBean) {
    parentControllerHelper.updateParent(parentId, parentBean);
  }

  @DeleteMapping("/{id}")
  public void deleteParent(@PathVariable(name = "id") @Min(1) final Long parentId) {
    parentControllerHelper.deleteParent(parentId);
  }
}
