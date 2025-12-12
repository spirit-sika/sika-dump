create table CONNECT_INFO
(
    id                    bigint
        constraint CONNECT_INFO_pk
            primary key,
    CONNECT_NAME          varchar,
    CONNECT_DESC          varchar,
    DB_NAME               varchar,
    SCHEME                varchar,
    HOST                  varchar,
    PORT                  varchar,
    SERVER_SID            varchar,
    SERVER_LOGIN_USERNAME varchar,
    SERVER_LOGIN_PASSWORD varchar,
    SERVER_CONNECT_URL    varchar,
    SERVER_TYPE           varchar,
    SERVER_VERSION        varchar,
    CREATE_TIME           timestamp,
    CREATE_BY             varchar,
    CREATE_BY_ID          bigint,
    UPDATE_TIME           timestamp,
    UPDATE_BY             varchar,
    UPDATE_BY_ID          bigint
);

comment on table CONNECT_INFO is '数据库连接信息表';

comment on column CONNECT_INFO.id is '主键';

comment on column CONNECT_INFO.CONNECT_NAME is '连接信息名称';

comment on column CONNECT_INFO.CONNECT_DESC is '连接描述';

comment on column CONNECT_INFO.DB_NAME is '库名称';

comment on column CONNECT_INFO.SCHEME is 'scheme';

comment on column CONNECT_INFO.HOST is '主机地址';

comment on column CONNECT_INFO.PORT is '服务器端口';

comment on column CONNECT_INFO.SERVER_SID is 'Oracle用的Sid';

comment on column CONNECT_INFO.SERVER_LOGIN_USERNAME is '数据库服务器登录用户名';

comment on column CONNECT_INFO.SERVER_LOGIN_PASSWORD is '数据库服务器登录密码(密文)';

comment on column CONNECT_INFO.SERVER_CONNECT_URL is '数据库连接url';

comment on column CONNECT_INFO.SERVER_TYPE is '数据库服务器类型';

comment on column CONNECT_INFO.SERVER_VERSION is '服务器版本号';

comment on column CONNECT_INFO.CREATE_TIME is '创建时间';

comment on column CONNECT_INFO.CREATE_BY is '创建人';

comment on column CONNECT_INFO.CREATE_BY_ID is '创建人 Id';

comment on column CONNECT_INFO.UPDATE_TIME is '修改时间';

comment on column CONNECT_INFO.UPDATE_BY is '修改人';

comment on column CONNECT_INFO.UPDATE_BY_ID is '修改人 Id';

