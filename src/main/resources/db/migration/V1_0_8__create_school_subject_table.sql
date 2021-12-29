CREATE SEQUENCE IF NOT EXISTS school_subject_id_sequence;

CREATE TABLE IF NOT EXISTS school_subject (
	school_subject_id	bigint NOT NULL DEFAULT nextval('school_subject_id_sequence'),
	name				character varying(50) NOT NULL,
	CONSTRAINT school_subject_pk PRIMARY KEY (school_subject_id),
	CONSTRAINT school_subject_name_uk UNIQUE (name),
	CONSTRAINT school_subject_name_ck CHECK (name ~ $$[A-Za-z0-9]+$$)
);

CREATE TABLE IF NOT EXISTS teacher_school_subject (
	teacher_id bigint NOT NULL,
    school_subject_id bigint NOT NULL,
    CONSTRAINT teacher_school_subject_uk UNIQUE (teacher_id, school_subject_id),
    CONSTRAINT teacher_fk FOREIGN KEY (teacher_id) REFERENCES teacher (teacher_id) ON DELETE CASCADE,
    CONSTRAINT school_subject_fk FOREIGN KEY (school_subject_id) REFERENCES school_subject (school_subject_id) ON DELETE CASCADE
);