ALTER TABLE school_course ADD COLUMN school_semester_id bigint NOT NULL;

ALTER TABLE school_course 
ADD CONSTRAINT school_semester_fk 
FOREIGN KEY (school_semester_id) 
REFERENCES school_semester (school_semester_id) ON DELETE CASCADE;