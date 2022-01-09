ALTER TABLE grade 
ADD COLUMN created_by bigint NOT NULL, 
ADD COLUMN updated_by bigint NOT NULL, 
ADD CONSTRAINT created_by_teacher_fk 
FOREIGN KEY (created_by) 
REFERENCES teacher (teacher_id) ON DELETE RESTRICT, 
ADD CONSTRAINT updated_by_teacher_fk 
FOREIGN KEY (updated_by) 
REFERENCES teacher (teacher_id) ON DELETE RESTRICT;