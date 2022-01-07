package com.ditsov.school_diary.core.service.parent;

import java.util.List;
import com.ditsov.school_diary.core.entity.parent.Parent;
import com.ditsov.school_diary.core.service.AbstractService;

public interface ParentService extends AbstractService<Parent, Long> {

  /**
   * Retrieves parents ordered by full name.
   *
   * @param page
   * @param size
   * @return
   */
  List<Parent> getByOrderByFullName(final int page, final int size);

  /**
   * Retrieves all parents ordered by full name.
   *
   * @return
   */
  List<Parent> getAllByOrderByFullName();
}
