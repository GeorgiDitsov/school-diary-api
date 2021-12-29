CREATE SEQUENCE IF NOT EXISTS school_course_id_sequence;

CREATE TABLE IF NOT EXISTS school_course (
	school_course_id	bigint NOT NULL DEFAULT nextval('school_course_id_sequence'),
	school_subject_id	bigint NOT NULL,
	teacher_id			bigint NOT NULL,
	school_group_id		bigint NOT NULL,
	CONSTRAINT school_course_pk PRIMARY KEY (school_course_id),
	CONSTRAINT school_subject_fk FOREIGN KEY (school_subject_id) REFERENCES school_subject (school_subject_id) ON DELETE CASCADE,
	CONSTRAINT teacher_fk FOREIGN KEY (teacher_id) REFERENCES teacher (teacher_id) ON DELETE CASCADE, 
	CONSTRAINT school_group_fk FOREIGN KEY (school_group_id) REFERENCES school_group (school_group_id) ON DELETE CASCADE
);

ALTER SEQUENCE school_course_id_sequence OWNED BY school_course.school_course_id;