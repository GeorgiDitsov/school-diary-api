package com.ditsov.school_diary.core.service.parent;

import java.util.List;
import org.springframework.data.domain.Page;
import com.ditsov.school_diary.core.entity.parent.Parent;
import com.ditsov.school_diary.core.entity.student.Student;
import com.ditsov.school_diary.core.service.AbstractService;

public interface ParentService extends AbstractService<Parent, Long> {

  /**
   * Retrieves a {@link Page} of parents ordered by full name.
   *
   * @param page
   * @param size
   * @return
   */
  Page<Parent> getByOrderByFullName(final int page, final int size);

  /**
   * Retrieves all parents ordered by full name.
   *
   * @return
   */
  List<Parent> getAllByOrderByFullName();

  /**
   * Retrieves a parent by user id.
   *
   * @param userId
   * @return
   */
  Parent getByUserId(final Long userId);

  /**
   * Retrieves a student by their parent and id.
   *
   * @param parent
   * @param childId
   */
  Student getStudentByParentAndId(final Parent parent, final Long childId);
}
