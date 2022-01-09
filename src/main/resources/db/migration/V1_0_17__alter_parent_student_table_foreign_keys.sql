ALTER TABLE parent_student 
DROP CONSTRAINT parent_fk, 
ADD CONSTRAINT parent_fk 
FOREIGN KEY (parent_id) 
REFERENCES parent (parent_id) ON DELETE NO ACTION;

ALTER TABLE parent_student 
DROP CONSTRAINT student_fk, 
ADD CONSTRAINT student_fk 
FOREIGN KEY (student_id) 
REFERENCES student (student_id) ON DELETE RESTRICT;