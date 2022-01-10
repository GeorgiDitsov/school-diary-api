package com.ditsov.school_diary.controller.person;

import java.util.List;
import javax.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ditsov.school_diary.controller.person.helper.PersonControllerHelper;
import com.ditsov.school_diary.model.person.PersonResponseBean;
import io.swagger.annotations.Api;

@Api(tags = "Person APIs")
@RestController
@RequestMapping("/v1/people")
public class PersonController {

  @Autowired private PersonControllerHelper personControllerHelper;

  @Secured({"ROLE_TEACHER", "ROLE_STUDENT", "ROLE_PARENT"})
  @GetMapping
  public List<PersonResponseBean> listPeopleBy(@RequestParam @Min(1) final Long userId) {
    return personControllerHelper.listPeopleBy(userId);
  }
}
