package com.ditsov.school_diary.controller.school.semester;

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
import com.ditsov.school_diary.controller.school.semester.helper.SchoolSemesterControllerHelper;
import com.ditsov.school_diary.model.common.LabeledValueBean;
import com.ditsov.school_diary.model.school.semester.CreateSchoolSemesterRequestBean;
import com.ditsov.school_diary.model.school.semester.SchoolSemesterResponseBean;
import com.ditsov.school_diary.model.school.semester.UpdateSchoolSemesterRequestBean;
import io.swagger.annotations.Api;

@Api(tags = "School Semester APIs")
@Secured("ROLE_ADMIN")
@RestController
@RequestMapping("/v1/school-semesters")
public class SchoolSemesterController {

  @Autowired private SchoolSemesterControllerHelper schoolSemesterControllerHelper;

  @GetMapping
  public List<SchoolSemesterResponseBean> listSchoolSemesters(
      @RequestParam(required = false) @Min(0) final Optional<Integer> page,
      @RequestParam(required = false) @Min(1) final Optional<Integer> size) {
    return schoolSemesterControllerHelper.listSchoolSemesters(page, size);
  }

  @GetMapping("/options")
  public List<LabeledValueBean<Long>> listAllSchoolSemestersAsOptions() {
    return schoolSemesterControllerHelper.listAllSchoolSemestersAsOptions();
  }

  @PostMapping
  public void createSchoolSemester(@RequestBody @Valid final CreateSchoolSemesterRequestBean bean) {
    schoolSemesterControllerHelper.createSchoolSemester(bean);
  }

  @PatchMapping("/{id}")
  public void updateSchoolSemester(
      @PathVariable(name = "id") @Min(1) final Long schoolGroupId,
      @RequestBody @Valid final UpdateSchoolSemesterRequestBean bean) {
    schoolSemesterControllerHelper.updateSchoolSemester(schoolGroupId, bean);
  }

  @DeleteMapping("/{id}")
  public void deleteSchoolSemester(@PathVariable(name = "id") @Min(1) final Long schoolGroupId) {
    schoolSemesterControllerHelper.deleteSchoolSemester(schoolGroupId);
  }
}
