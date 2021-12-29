CREATE SEQUENCE IF NOT EXISTS school_year_id_sequence;

CREATE TABLE IF NOT EXISTS school_year (
	school_year_id		bigint NOT NULL DEFAULT nextval('school_year_id_sequence'),
	name				character varying(20) NOT NULL,
	start_date			date NOT NULL,
	end_date			date NOT NULL,
	CONSTRAINT school_year_pk PRIMARY KEY (school_year_id),
	CONSTRAINT school_year_name_uk UNIQUE (name)
);

ALTER SEQUENCE school_year_id_sequence OWNED BY school_year.school_year_id;

CREATE SEQUENCE IF NOT EXISTS school_semester_id_sequence;

CREATE TABLE IF NOT EXISTS school_semester (
	school_semester_id	bigint NOT NULL DEFAULT nextval('school_semester_id_sequence'),
	name				character varying(20) NOT NULL,
	start_date			date NOT NULL,
	end_date			date NOT NULL,
	school_year_id		bigint NOT NULL,
	CONSTRAINT school_semester_pk PRIMARY KEY (school_semester_id),
	CONSTRAINT school_semester_name_uk UNIQUE (name),
	CONSTRAINT school_year_fk FOREIGN KEY (school_year_id) REFERENCES school_year (school_year_id) ON DELETE CASCADE
);

ALTER SEQUENCE school_semester_id_sequence OWNED BY school_semester.school_semester_id;