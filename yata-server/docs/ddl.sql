create table ACCOUNT
(
    id         bigint auto_increment
        primary key,
    email      varchar(255) not null,
    name       varchar(255) not null,
    password   varchar(255) not null,
    is_deleted int          not null comment 'Delete flag(0:삭제아님/1:삭제)',
    created_at varchar(255) not null,
    updated_at varchar(255) not null
) ENGINE=INNODB CHARSET=UTF8 COLLATE=UTF8_GENERAL_CI COMMENT '유저계정정보';
