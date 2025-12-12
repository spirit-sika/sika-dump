create table PLUGIN_CONFIG
(
    id             bigint
        constraint PLUGIN_CONFIG_pk
            primary key,
    SYNC_CONFIG_ID bigint,
    PLUGIN_TYPE    int2,
    PLUGIN_NAME    varchar,
    PLUGIN_DESC    varchar,
    PLUGIN_CLASS   varchar,
    CREATE_TIME    timestamp,
    CREATE_BY      varchar,
    CREATE_BY_ID   bigint,
    UPDATE_TIME    timestamp,
    UPDATE_BY      varchar,
    UPDATE_BY_ID   bigint
);

comment on table PLUGIN_CONFIG is '插件配置表';

comment on column PLUGIN_CONFIG.id is '主键';

comment on column PLUGIN_CONFIG.SYNC_CONFIG_ID is '插件对应的同步配置 id';

comment on column PLUGIN_CONFIG.PLUGIN_TYPE is '插件类型';

comment on column PLUGIN_CONFIG.PLUGIN_NAME is '插件名称';

comment on column PLUGIN_CONFIG.PLUGIN_DESC is '插件描述';

comment on column PLUGIN_CONFIG.PLUGIN_CLASS is '插件类名, 全限定类名';

comment on column PLUGIN_CONFIG.CREATE_TIME is '创建时间';

comment on column PLUGIN_CONFIG.CREATE_BY is '创建人';

comment on column PLUGIN_CONFIG.CREATE_BY_ID is '创建人 Id';

comment on column PLUGIN_CONFIG.UPDATE_TIME is '修改时间';

comment on column PLUGIN_CONFIG.UPDATE_BY is '修改人';

comment on column PLUGIN_CONFIG.UPDATE_BY_ID is '修改人 Id';