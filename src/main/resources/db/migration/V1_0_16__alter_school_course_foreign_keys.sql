ALTER TABLE school_course 
DROP CONSTRAINT school_subject_fk, 
ADD CONSTRAINT school_subject_fk FOREIGN KEY (school_subject_id) REFERENCES school_subject (school_subject_id) ON DELETE RESTRICT;

ALTER TABLE school_course 
DROP CONSTRAINT teacher_fk, 
ADD CONSTRAINT teacher_fk FOREIGN KEY (teacher_id) REFERENCES teacher (teacher_id) ON DELETE NO ACTION;

ALTER TABLE school_course 
DROP CONSTRAINT school_group_fk, 
ADD CONSTRAINT school_group_fk FOREIGN KEY (school_group_id) REFERENCES school_group (school_group_id) ON DELETE RESTRICT;