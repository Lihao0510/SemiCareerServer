drop table if exists sys_roles;
create table sys_roles(
	role_id int not null auto_increment primary key,
	role_name nvarchar(30) not null,
	role_type int(1) not null default 0
);

alter table sys_roles add index index_rolename(role_name);
ALTER TABLE sys_roles ADD UNIQUE (role_name);
ALTER TABLE sys_roles AUTO_INCREMENT = 10000;