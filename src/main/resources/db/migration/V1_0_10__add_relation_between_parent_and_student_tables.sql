CREATE TABLE IF NOT EXISTS parent_student (
	parent_id	bigint NOT NULL,
	student_id	bigint NOT NULL,
	CONSTRAINT parent_student_uk UNIQUE (parent_id, student_id), 
	CONSTRAINT parent_fk FOREIGN KEY (parent_id) REFERENCES parent (parent_id) ON DELETE CASCADE,
	CONSTRAINT student_fk FOREIGN KEY (student_id) REFERENCES student (student_id) ON DELETE NO ACTION
);