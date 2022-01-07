package com.ditsov.school_diary.core.service.school.group;

import java.util.List;
import com.ditsov.school_diary.core.entity.school.group.SchoolGroup;
import com.ditsov.school_diary.core.service.AbstractService;

public interface SchoolGroupService extends AbstractService<SchoolGroup, Long> {

  /**
   * Retrieves school groups order by name.
   *
   * @param page
   * @param size
   * @return
   */
  List<SchoolGroup> getByOrderByName(final int page, final int size);
}
