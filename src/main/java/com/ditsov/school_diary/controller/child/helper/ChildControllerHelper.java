package com.ditsov.school_diary.controller.child.helper;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ditsov.school_diary.core.entity.parent.Parent;
import com.ditsov.school_diary.core.entity.school.semester.SchoolSemester;
import com.ditsov.school_diary.core.entity.student.Student;
import com.ditsov.school_diary.core.entity.user.User;
import com.ditsov.school_diary.core.factory.child.ChildFactory;
import com.ditsov.school_diary.core.service.authentication.AuthenticationService;
import com.ditsov.school_diary.core.service.grade.GradeService;
import com.ditsov.school_diary.core.service.parent.ParentService;
import com.ditsov.school_diary.core.service.school.semester.SchoolSemesterService;
import com.ditsov.school_diary.model.child.ChildResponseBean;

@Component
public class ChildControllerHelper {

  @Autowired private AuthenticationService authenticationService;

  @Autowired private ParentService parentService;

  @Autowired private SchoolSemesterService schoolSemesterService;

  @Autowired private ChildFactory childFactory;

  @Autowired private GradeService gradeService;

  public List<ChildResponseBean> listAllChildren() {
    User parentUser = authenticationService.getCurrentAuthenticatedUser();
    Parent parent = parentService.getByUserId(parentUser.getId());
    SchoolSemester schoolSemester = schoolSemesterService.getCurrentSchoolSemester();

    return parent
        .getChildren()
        .stream()
        .map(
            child -> {
              ChildResponseBean bean = childFactory.convertStudentToChildResponseBean(child);

              bean.setSuccess(
                  gradeService.getSuccessByStudentIdAndSchoolSemesterId(
                      child.getId(), schoolSemester.getId()));

              return bean;
            })
        .collect(Collectors.toList());
  }

  public ChildResponseBean getChild(final Long childId) {
    User parentUser = authenticationService.getCurrentAuthenticatedUser();
    Parent parent = parentService.getByUserId(parentUser.getId());
    Student student = parentService.getStudentByParentAndId(parent, childId);

    return childFactory.convertStudentToChildResponseBean(student);
  }
}
