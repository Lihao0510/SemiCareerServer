drop table if exists role_auth_conn;

create table role_auth_conn(
	role_id int not null,
	auth_id int not null,
	conn_desc varchar(50) null,
	conn_type int(1) not null default 0,
	primary key (role_id, auth_id)
);

alter table role_auth_conn add constraint fk_role_auth_conn_role_id foreign key(role_id) references sys_roles(role_id);
alter table role_auth_conn add constraint fk_role_auth_conn_auth_id foreign key(auth_id) references sys_auths(auth_id); 