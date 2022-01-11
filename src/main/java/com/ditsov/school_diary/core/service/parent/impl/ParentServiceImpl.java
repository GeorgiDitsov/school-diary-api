package com.ditsov.school_diary.core.service.parent.impl;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.ditsov.school_diary.core.entity.parent.Parent;
import com.ditsov.school_diary.core.entity.student.Student;
import com.ditsov.school_diary.core.repository.parent.ParentRepository;
import com.ditsov.school_diary.core.service.AbstractService;
import com.ditsov.school_diary.core.service.parent.ParentService;

@Service
public class ParentServiceImpl implements ParentService {

  @Autowired private ParentRepository parentRepository;

  /** @see AbstractService#getAll() */
  @Override
  public List<Parent> getAll() {
    return parentRepository.findAll();
  }

  /** @see AbstractService#getById(Object) */
  @Override
  public Parent getById(final Long id) {
    return parentRepository.getById(id);
  }

  /** @see AbstractService#save(Object) */
  @Override
  public void save(final Parent entity) {
    parentRepository.save(entity);
  }

  /** @see AbstractService#deleteById(Object) */
  @Override
  public void deleteById(final Long id) {
    parentRepository.deleteById(id);
  }

  /** @see ParentService#getByOrderByFullName(int, int) */
  @Override
  public Page<Parent> getByOrderByFullName(final int page, final int size) {
    return parentRepository.findAll(PageRequest.of(page, size, Sort.by("firstName", "lastName")));
  }

  /** @see ParentService#getAllByOrderByFullName() */
  @Override
  public List<Parent> getAllByOrderByFullName() {
    return parentRepository.findAll(Sort.by("firstName", "lastName"));
  }

  /** @see ParentService#getByUserId(Long) */
  @Override
  public Parent getByUserId(final Long userId) {
    return parentRepository.findByUserId(userId).orElseThrow(EntityNotFoundException::new);
  }

  /** @see ParentService#getStudentByParentAndId(Parent, Long) */
  @Override
  public Student getStudentByParentAndId(final Parent parent, final Long childId) {
    return parent
        .getChildren()
        .stream()
        .filter(child -> child.getId().equals(childId))
        .findFirst()
        .orElseThrow(EntityNotFoundException::new);
  }
}
