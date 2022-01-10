package com.ditsov.school_diary.core.service.school.semester.impl;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.ditsov.school_diary.core.entity.school.semester.SchoolSemester;
import com.ditsov.school_diary.core.repository.school.semester.SchoolSemesterRepository;
import com.ditsov.school_diary.core.service.AbstractService;
import com.ditsov.school_diary.core.service.school.semester.SchoolSemesterService;

@Service
public class SchoolSemesterServiceImpl implements SchoolSemesterService {

  @Autowired private SchoolSemesterRepository schoolSemesterRepository;

  /** @see AbstractService#getAll() */
  @Override
  public List<SchoolSemester> getAll() {
    return schoolSemesterRepository.findAll();
  }

  /** @see AbstractService#getById(Object) */
  @Override
  public SchoolSemester getById(final Long id) {
    return schoolSemesterRepository.getById(id);
  }

  /** @see AbstractService#save(Object) */
  @Override
  public void save(final SchoolSemester entity) {
    schoolSemesterRepository.save(entity);
  }

  /** @see AbstractService#deleteById(Object) */
  @Override
  public void deleteById(final Long id) {
    schoolSemesterRepository.deleteById(id);
  }

  /** @see SchoolSemesterService#getByOrderByStartDateDesc(int, int) */
  @Override
  public Page<SchoolSemester> getByOrderByStartDateDesc(final int page, final int size) {
    return schoolSemesterRepository.findAll(
        PageRequest.of(page, size, Sort.by(Direction.DESC, "startDate")));
  }

  /** @see SchoolSemesterService#getAllByOrderByStartDateDesc() */
  @Override
  public List<SchoolSemester> getAllByOrderByStartDateDesc() {
    return schoolSemesterRepository.findAll(Sort.by(Direction.DESC, "startDate"));
  }

  /** @see SchoolSemesterService#getCurrentSchoolSemester() */
  @Override
  public SchoolSemester getCurrentSchoolSemester() {
    return schoolSemesterRepository
        .findByDate(LocalDate.now())
        .orElseThrow(EntityNotFoundException::new);
  }
}
