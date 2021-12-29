CREATE SEQUENCE IF NOT EXISTS school_group_id_sequence;

CREATE TABLE IF NOT EXISTS school_group (
	school_group_id	bigint NOT NULL DEFAULT nextval('school_group_id_sequence'),
	year			smallint NOT NULL,
	letter_index	character varying(1) NOT NULL,
	CONSTRAINT school_group_pk PRIMARY KEY (school_group_id),
	CONSTRAINT school_group_year_ck CHECK (year >= 1 AND year <= 13),
	CONSTRAINT school_group_letter_index CHECK (letter_index ~ $$[A-Z]{1}$$)
);

ALTER TABLE student 
ADD COLUMN school_group_id bigint;

ALTER TABLE student 
ADD CONSTRAINT school_group_fk 
FOREIGN KEY (school_group_id) 
REFERENCES school_group (school_group_id);