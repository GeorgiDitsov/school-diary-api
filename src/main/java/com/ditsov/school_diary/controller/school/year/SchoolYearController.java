package com.ditsov.school_diary.controller.school.year;

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
import com.ditsov.school_diary.controller.school.year.helper.SchoolYearControllerHelper;
import com.ditsov.school_diary.model.common.LabeledValueBean;
import com.ditsov.school_diary.model.school.year.CreateSchoolYearRequestBean;
import com.ditsov.school_diary.model.school.year.SchoolYearResponseBean;
import com.ditsov.school_diary.model.school.year.UpdateSchoolYearRequestBean;
import io.swagger.annotations.Api;

@Api(tags = "School Year APIs")
@Secured("ROLE_ADMIN")
@RestController
@RequestMapping("/v1/school-years")
public class SchoolYearController {

  @Autowired private SchoolYearControllerHelper schoolYearControllerHelper;

  @GetMapping
  public List<SchoolYearResponseBean> listSchoolYears(
      @RequestParam(required = false) @Min(0) final Optional<Integer> page,
      @RequestParam(required = false) @Min(1) final Optional<Integer> size) {
    return schoolYearControllerHelper.listSchoolYears(page, size);
  }

  @GetMapping("/options")
  public List<LabeledValueBean<Long>> listAllSchoolYearsAsOptions() {
    return schoolYearControllerHelper.listAllSchoolYearsAsOptions();
  }

  @PostMapping
  public void createSchoolYear(@RequestBody @Valid final CreateSchoolYearRequestBean schoolYearBean) {
    schoolYearControllerHelper.createSchoolYear(schoolYearBean);
  }

  @PatchMapping("/{id}")
  public void updateSchoolYear(
      @PathVariable(name = "id") @Min(1) final Long schoolYearId,
      @RequestBody @Valid final UpdateSchoolYearRequestBean schoolYearBean) {
    schoolYearControllerHelper.updateSchoolYear(schoolYearId, schoolYearBean);
  }

  @DeleteMapping("/{id}")
  public void deleteSchoolYear(@PathVariable(name = "id") @Min(1) final Long schoolYearId) {
    schoolYearControllerHelper.deleteSchoolYear(schoolYearId);
  }
}
