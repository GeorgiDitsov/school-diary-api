CREATE TABLE IF NOT EXISTS person (
	person_id	bigint NOT NULL DEFAULT nextval('person_id_sequence'),
	first_name	character varying(25) NOT NULL,
	last_name	character varying(25) NOT NULL,
	pin			character varying(10) NOT NULL,
	user_id		bigint DEFAULT NULL,
	CONSTRAINT person_pk PRIMARY KEY (person_id),
	CONSTRAINT person_pin_uk UNIQUE (pin),
	CONSTRAINT person_user_uk UNIQUE (user_id),
	CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES public.user (user_id) ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS teacher (
	teacher_id	bigint NOT NULL,
	CONSTRAINT teacher_pk PRIMARY KEY (teacher_id),
	CONSTRAINT person_fk FOREIGN KEY (teacher_id) REFERENCES person (person_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS student (
	student_id	bigint NOT NULL,
	CONSTRAINT student_pk PRIMARY KEY (student_id),
	CONSTRAINT person_fk FOREIGN KEY (student_id) REFERENCES person (person_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS parent (
	parent_id	bigint NOT NULL,
	CONSTRAINT parent_pk PRIMARY KEY (parent_id),
	CONSTRAINT person_fk FOREIGN KEY (parent_id) REFERENCES person (person_id) ON DELETE CASCADE
);