package com.ditsov.school_diary.core.service.school.year;

import java.util.List;
import org.springframework.data.domain.Page;
import com.ditsov.school_diary.core.entity.school.year.SchoolYear;
import com.ditsov.school_diary.core.service.AbstractService;

public interface SchoolYearService extends AbstractService<SchoolYear, Long> {

  /**
   * Retrieves a {@link Page} of school years ordered by start date in descending order.
   *
   * @param page
   * @param size
   * @return
   */
  Page<SchoolYear> getByOrderByStartDateDesc(final int page, final int size);

  /**
   * Retrieves all school years ordered by start date in descending order.
   *
   * @return
   */
  List<SchoolYear> getAllByOrderByStartDateDesc();
}
