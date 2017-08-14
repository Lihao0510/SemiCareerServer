drop table sys_users;
create table sys_users(
	user_id int not null primary key auto_increment,
	user_name nvarchar(20) not null,
	user_phone varchar(20) not null,
	user_pwd varchar(16) not null,
	user_email varchar(30) null
);

ALTER TABLE sys_users ADD UNIQUE (user_name, user_phone, user_email);
ALTER TABLE sys_users ADD COLUMN user_desc VARCHAR(30) NULL;
ALTER TABLE sys_users ADD COLUMN create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP;
ALTER TABLE sys_users MODIFY COLUMN user_pwd varchar(50) not null;



