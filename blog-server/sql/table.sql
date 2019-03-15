create table user_info
(
	id varchar(32) default '' comment '主键'
		primary key,
	username varchar(50) not null comment '用户名',
	account varchar(50) not null comment '账号',
	password varchar(50) not null comment '密码',
	create_time datetime default CURRENT_TIMESTAMP not null comment '创建时间',
	create_user_id varchar(32) not null comment '创建人id',
	modify_time datetime default CURRENT_TIMESTAMP not null comment '修改时间',
	modify_user_id varchar(32) not null comment '修改人id'
)
comment '用户信息表'
;

INSERT INTO `blog-server`.user_info (id, username, account, password, create_time, create_user_id, modify_time, modify_user_id) VALUES (1, 'maple', 'maple', '1', '2019-03-14 20:21:26', 0, '2019-03-14 20:21:26', 0)

create table role_info
(
	id varchar(32) default '' comment '主键'
		primary key,
	role_name varchar(50) not null comment '角色名称',
	create_time datetime default CURRENT_TIMESTAMP not null comment '创建时间',
	create_user_id varchar(32) not null comment '创建人id',
	modify_time datetime default CURRENT_TIMESTAMP not null comment '修改时间',
	modify_user_id varchar(32) not null comment '修改人id'
)
comment '角色信息表'
;

create table menu_info
(
	id varchar(32) default '' comment '主键'
		primary key,
	menu_name varchar(50) not null comment '菜单名称',
	parent_id bigint default 0 not null comment '父菜单id',
	icon varchar(100) not null comment '菜单图标',
	create_time datetime default CURRENT_TIMESTAMP not null comment '创建时间',
	create_user_id varchar(32) not null comment '创建人id',
	modify_time datetime default CURRENT_TIMESTAMP not null comment '修改时间',
	modify_user_id varchar(32) not null comment '修改人id'
)
comment '菜单信息表'
;

