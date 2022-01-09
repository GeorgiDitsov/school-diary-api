ALTER TABLE school_semester 
DROP CONSTRAINT school_year_fk, 
ADD CONSTRAINT school_year_fk 
FOREIGN KEY (school_year_id) 
REFERENCES school_year (school_year_id) ON DELETE RESTRICT;

ALTER TABLE school_course 
DROP CONSTRAINT school_semester_fk, 
ADD CONSTRAINT school_semester_fk 
FOREIGN KEY (school_semester_id) 
REFERENCES school_semester (school_semester_id) ON DELETE RESTRICT;

ALTER TABLE user_role 
DROP CONSTRAINT user_fk, 
ADD CONSTRAINT user_fk 
FOREIGN KEY (user_id) 
REFERENCES public.user (user_id) ON DELETE RESTRICT;

ALTER TABLE user_role 
DROP CONSTRAINT role_fk, 
ADD CONSTRAINT role_fk 
FOREIGN KEY (role_id) 
REFERENCES role (role_id) ON DELETE RESTRICT;

ALTER TABLE person 
DROP CONSTRAINT user_fk,
ADD CONSTRAINT user_fk 
FOREIGN KEY (user_id) 
REFERENCES public.user (user_id) ON DELETE RESTRICT;

ALTER TABLE grade 
DROP CONSTRAINT student_fk, 
ADD CONSTRAINT student_fk 
FOREIGN KEY (student_id) 
REFERENCES student (student_id) ON DELETE RESTRICT;

ALTER TABLE grade 
DROP CONSTRAINT school_course_fk, 
ADD CONSTRAINT school_course_fk 
FOREIGN KEY (school_course_id) 
REFERENCES school_course (school_course_id) ON DELETE RESTRICT;

ALTER TABLE student 
DROP CONSTRAINT school_group_fk, 
ADD CONSTRAINT school_group_fk 
FOREIGN KEY (school_group_id) 
REFERENCES school_group (school_group_id) ON DELETE RESTRICT;