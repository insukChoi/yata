create table ACCOUNT
(
    id         bigint auto_increment
        primary key,
    email      varchar(255) not null,
    name       varchar(255) not null,
    password   varchar(255) not null,
    is_deleted tinyint(1)   not null comment 'Delete flag(0:삭제아님/1:삭제)',
    created_at varchar(255) not null,
    updated_at varchar(255) not null
) ENGINE=INNODB CHARSET=UTF8 COLLATE=UTF8_GENERAL_CI COMMENT '유저계정정보';
create table TRAVEL
(
    id              bigint auto_increment primary key,
    account_id      bigint not null,
    title           varchar(255) not null,
    place           varchar(255) not null,
    time_difference varchar(255) not null,
    memo            varchar(255) not null,
    start_date      varchar(255) not null,
    end_date        varchar(255) not null,
    is_deleted      tinyint(1)   not null comment 'Delete flag(0:삭제아님/1:삭제)',
    created_at      varchar(255) not null,
    updated_at      varchar(255) not null
) ENGINE=INNODB CHARSET=UTF8 COLLATE=UTF8_GENERAL_CI COMMENT '여행정보';
create table PLAN
(
    id              bigint auto_increment primary key,
    travel_id       bigint not null,
    time            varchar(255) not null,
    memo            varchar(255) not null,
    link_to         varchar(255) not null,
    is_deleted      tinyint(1)   not null comment 'Delete flag(0:삭제아님/1:삭제)',
    created_at      varchar(255) not null,
    updated_at      varchar(255) not null
) ENGINE=INNODB CHARSET=UTF8 COLLATE=UTF8_GENERAL_CI COMMENT '여행스케줄';