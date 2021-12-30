package com.ditsov.school_diary.controller.teacher;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;

@Api(tags = "Teacher APIs")
@RestController
@RequestMapping("/v1/teachers")
public class TeacherController {}
