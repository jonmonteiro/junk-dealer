create table users(
    id bigint not null auto_increment,
	name varchar(100) not null,
    login varchar(100) not null,
	cellphone varchar(20) not null,
	email varchar(100),
	active boolean not null,
    password varchar(255) not null,    
    primary key(id)
);

CREATE TABLE userprofile(
	id bigint NOT NULL auto_increment,
	name varchar(255),
	description varchar(255),
	PRIMARY KEY (id)
);

CREATE TABLE users_userprofile(
	user_id bigint NOT NULL,
	userprofle_id bigint NOT NULL,	
	PRIMARY key(user_id, userprofle_id),
	CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id),
	CONSTRAINT fk_userprofile FOREIGN KEY (perfilusu_id) REFERENCES userprofile(id)
);