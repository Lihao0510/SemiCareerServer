drop table if exists user_role_conn;

create table user_role_conn(
	role_id int not null,
	user_id int not null,
	conn_desc varchar(50) null,
	conn_type int(1) not null default 0,
	primary key (role_id, user_id)
);

alter table user_role_conn add constraint fk_user_role_conn_role_id foreign key(role_id) references sys_roles(role_id);
alter table user_role_conn add constraint fk_user_role_conn_user_id foreign key(user_id) references sys_users(user_id);