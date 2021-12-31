package com.ditsov.school_diary.core.service.student.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ditsov.school_diary.core.entity.student.Student;
import com.ditsov.school_diary.core.service.student.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

  /** @see StudentService#getAllStudentsOrderByFullName(int, int) */
  @Override
  public List<Student> getAllStudentsOrderByFullName(final int page, final int size) {
    return null;
  }
}
