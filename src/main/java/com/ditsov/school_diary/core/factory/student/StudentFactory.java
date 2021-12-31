package com.ditsov.school_diary.core.factory.student;

import com.ditsov.school_diary.core.entity.student.Student;
import com.ditsov.school_diary.core.factory.person.PersonFactory;
import com.ditsov.school_diary.model.student.StudentResponseBean;

public interface StudentFactory extends PersonFactory<StudentResponseBean, Student> {}
