package com.ditsov.school_diary.controller.school.subject;

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
import com.ditsov.school_diary.controller.school.subject.helper.SchoolSubjectControllerHelper;
import com.ditsov.school_diary.model.common.LabeledValueBean;
import com.ditsov.school_diary.model.school.subject.CreateSchoolSubjectRequestBean;
import com.ditsov.school_diary.model.school.subject.UpdateSchoolSubjectRequestBean;
import io.swagger.annotations.Api;

@Api(tags = "School Subject APIs")
@Secured("ROLE_ADMIN")
@RestController
@RequestMapping("/v1/school-subjects")
public class SchoolSubjectController {

  @Autowired private SchoolSubjectControllerHelper schoolSubjectControllerHelper;

  @GetMapping
  public List<LabeledValueBean<Long>> listAllSchoolSubjects() {
    return schoolSubjectControllerHelper.listAllSchoolSubjects();
  }

  @GetMapping("/{id}/teachers")
  public List<LabeledValueBean<Long>> listTeachersBySchoolSubject(
      @PathVariable(name = "id") @Min(1) final Long schoolSubjectId) {
    return schoolSubjectControllerHelper.listTeachersBySchoolSubject(schoolSubjectId);
  }

  @PostMapping
  public void createSchoolSubject(@RequestBody @Valid final CreateSchoolSubjectRequestBean bean) {
    schoolSubjectControllerHelper.createSchoolSubject(bean);
  }

  @PatchMapping("/{id}")
  public void updateSchoolSubject(
      @PathVariable(name = "id") @Min(1) final Long schoolSubjectId,
      @RequestBody @Valid final UpdateSchoolSubjectRequestBean bean) {
    schoolSubjectControllerHelper.updateSchoolSubject(schoolSubjectId, bean);
  }

  @DeleteMapping("/{id}")
  public void deleteSchoolSubject(@PathVariable(name = "id") @Min(1) final Long schoolSubjectId) {
    schoolSubjectControllerHelper.deleteSchoolSubject(schoolSubjectId);
  }
}
