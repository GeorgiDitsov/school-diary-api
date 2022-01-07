package com.ditsov.school_diary.core.factory.grade;

import com.ditsov.school_diary.core.entity.grade.Grade;
import com.ditsov.school_diary.model.grade.GradeResponseBean;

public interface GradeFactory {

  /**
   * Converts an entity of type {@link Grade} into a {@link GradeResponseBean}.
   *
   * @param grade
   * @return
   */
  GradeResponseBean convertGradeToGradeResponseBean(final Grade grade);
}
