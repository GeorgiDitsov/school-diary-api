CREATE SEQUENCE IF NOT EXISTS grade_id_sequence;

CREATE TABLE IF NOT EXISTS grade (
	grade_id			bigint NOT NULL DEFAULT nextval('grade_id_sequence'),
	"value"				real NOT NULL,
	created_at			date NOT NULL,
	updated_at			date NOT NULL,
	student_id			bigint NOT NULL,
	school_course_id	bigint NOT NULL,
	CONSTRAINT grade_pk PRIMARY KEY (grade_id),
	CONSTRAINT grade_value_ck CHECK ("value" >= 2.00 AND "value" <= 6.00),
	CONSTRAINT student_fk FOREIGN KEY (student_id) REFERENCES student (student_id),
	CONSTRAINT school_course_fk FOREIGN KEY (school_course_id) REFERENCES school_course (school_course_id)
);

ALTER SEQUENCE grade_id_sequence OWNED BY grade.grade_id;