create table SYNC_CONFIG
(
    id                bigint
        constraint SYNC_CONFIG_pk
            primary key,
    CONNECTION_ID     bigint,
    SYNC_TYPE         bigint,
    CONFIG_GROUP_NAME varchar,
    REF_NAME          varchar,
    TABLE_NAME        varchar,
    COLUMN_NAME       varchar,
    COLUMN_TYPE       varchar,
    COLUMN_JAVA_TYPE  varchar,
    COLUMN_LENGTH     integer,
    COLUMN_SCALE      integer,
    AUTO_GENERATE     smallint,
    CREATE_TIME       timestamp,
    CREATE_BY         varchar,
    CREATE_BY_ID      bigint,
    UPDATE_TIME       timestamp,
    UPDATE_BY         varchar,
    UPDATE_BY_ID      bigint
);

comment on table SYNC_CONFIG is '数据同步配置实体';

comment on column SYNC_CONFIG.id is '主键';

comment on column SYNC_CONFIG.CONNECTION_ID is '连接信息 id';

comment on column SYNC_CONFIG.CONFIG_GROUP_NAME is '发送端与接收端的配置组名称, 只有同个组的发送端配置和接收端配置组名一致才进行数据处理';

comment on column SYNC_CONFIG.SYNC_TYPE is '同步配置类型';

comment on column SYNC_CONFIG.REF_NAME is '引用名';

comment on column SYNC_CONFIG.TABLE_NAME is '表名';

comment on column SYNC_CONFIG.COLUMN_NAME is '列名';

comment on column SYNC_CONFIG.COLUMN_TYPE is '列数据库数据类型';

comment on column SYNC_CONFIG.COLUMN_JAVA_TYPE is '列的 Java 类型, 全限定类名';

comment on column SYNC_CONFIG.COLUMN_LENGTH is '数据库列长度';

comment on column SYNC_CONFIG.COLUMN_SCALE is '数据库列精度, 小数位数';

comment on column SYNC_CONFIG.AUTO_GENERATE is '是否自动生成, 1-是 2-否';

comment on column SYNC_CONFIG.CREATE_TIME is '创建时间';

comment on column SYNC_CONFIG.CREATE_BY is '创建人';

comment on column SYNC_CONFIG.CREATE_BY_ID is '创建人 Id';

comment on column SYNC_CONFIG.UPDATE_TIME is '修改时间';

comment on column SYNC_CONFIG.UPDATE_BY is '修改人';

comment on column SYNC_CONFIG.UPDATE_BY_ID is '修改人 Id';
