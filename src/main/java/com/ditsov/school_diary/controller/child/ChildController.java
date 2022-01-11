package com.ditsov.school_diary.controller.child;

import java.util.List;
import javax.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ditsov.school_diary.controller.child.helper.ChildControllerHelper;
import com.ditsov.school_diary.model.child.ChildResponseBean;
import io.swagger.annotations.Api;

@Api(tags = "Child APIs")
@Secured("ROLE_PARENT")
@RestController
@RequestMapping("/v1/children")
public class ChildController {

  @Autowired private ChildControllerHelper childControllerHelper;

  @GetMapping
  public List<ChildResponseBean> listAllChildren() {
    return childControllerHelper.listAllChildren();
  }

  @GetMapping("/{id}")
  public ChildResponseBean getChild(@PathVariable(name = "id") @Min(1) final Long childId) {
    return childControllerHelper.getChild(childId);
  }
}
