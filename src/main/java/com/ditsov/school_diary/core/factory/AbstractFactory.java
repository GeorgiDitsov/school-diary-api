package com.ditsov.school_diary.core.factory;

public interface AbstractFactory<T, E> {

  /**
   * Converts an entity into a response bean.
   *
   * @param entity
   * @return
   */
  T convertToResponseBean(final E entity);
}
