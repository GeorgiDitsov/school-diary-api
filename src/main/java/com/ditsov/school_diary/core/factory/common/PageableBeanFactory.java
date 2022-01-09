package com.ditsov.school_diary.core.factory.common;

import org.springframework.data.domain.Page;
import com.ditsov.school_diary.core.factory.AbstractFactory;
import com.ditsov.school_diary.model.common.PageableBean;

public interface PageableBeanFactory {

  /**
   * Creates a {@link PageableBean}.
   *
   * @param page
   * @return
   */
  <T, E> PageableBean<T> create(final Page<E> page, final AbstractFactory<T, E> abstractFactory);
}
