create table user_info
(
	id bigint auto_increment comment '主键'
		primary key,
	username varchar(50) not null comment '用户名',
	account varchar(50) not null comment '账号',
	password varchar(50) not null comment '密码',
	create_time datetime default CURRENT_TIMESTAMP not null,
	create_user_id bigint not null comment '创建人id',
	modify_time datetime default CURRENT_TIMESTAMP not null,
	modify_user_id bigint not null
)
comment '用户信息表'
;

INSERT INTO `blog-server`.user_info (id, username, account, password, create_time, create_user_id, modify_time, modify_user_id) VALUES (1, 'maple', 'maple', '1', '2019-03-14 20:21:26', 0, '2019-03-14 20:21:26', 0);