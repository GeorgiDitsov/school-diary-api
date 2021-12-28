CREATE TABLE IF NOT EXISTS public.user (
	user_id		bigint NOT NULL DEFAULT nextval('user_id_sequence'),
	username	character varying(20) NOT NULL,
	password	character varying(60) NOT NULL,
	email		character varying(40) NOT NULL,
	active		boolean NOT NULL DEFAULT true,
	CONSTRAINT user_pk PRIMARY KEY (user_id),
	CONSTRAINT user_username_uk UNIQUE (username),
	CONSTRAINT user_email_uk UNIQUE (email)
);

CREATE TABLE IF NOT EXISTS role (
	role_id		bigint NOT NULL DEFAULT nextval('role_id_sequence'),
	name		character varying(20) NOT NULL,
	description	character varying(100) NOT NULL,
	CONSTRAINT role_pk PRIMARY KEY (role_id),
	CONSTRAINT role_name_uk UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS user_role (
	user_id bigint NOT NULL,
	role_id bigint NOT NULL,
	CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES public.user (user_id) ON DELETE CASCADE,
	CONSTRAINT role_fk FOREIGN KEY (role_id) REFERENCES role (role_id) ON DELETE NO ACTION
);