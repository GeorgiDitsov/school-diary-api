package com.ditsov.school_diary.core.service;

import java.util.List;

public interface AbstractService<E, ID> {

  /**
   * Retrieves all entities.
   *
   * @return
   */
  List<E> getAll();

  /**
   * Retrieves entity by id.
   *
   * @param id
   * @return
   */
  E getById(final ID id);

  /**
   * Saves the entity.
   *
   * @param entity
   */
  void save(final E entity);

  /**
   * Deletes the entity by id.
   *
   * @param id
   */
  void deleteById(final ID id);
}
