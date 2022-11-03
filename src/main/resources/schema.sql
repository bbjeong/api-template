create table CONFIG
(
    DOMAIN varchar(20) not null,
    CONFIG_KEY VARCHAR(40) not null,
    CONFIG_VAL varchar(500) not null,
    DETAIL varchar(50) not null,
    CREATED_DATETIME timestamp not null,
    MODIFIED_DATETIME timestamp null,
    constraint CONFIG_pk
        primary key (DOMAIN, CONFIG_KEY)
)
comment '설정';