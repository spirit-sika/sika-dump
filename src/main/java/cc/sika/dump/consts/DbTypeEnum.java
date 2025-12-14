package cc.sika.dump.consts;

import lombok.Getter;

/**
 * @author 小吴来哩
 * @since 2025-12
 */
@Getter
@SuppressWarnings("unused")
public enum DbTypeEnum {
    MYSQL("MYSQL", "com.mysql.cj.jdbc.Driver"),
    POSTGRESQL("POSTGRESQL", "org.postgresql.Driver"),
    ORACLE("ORACLE", "oracle.jdbc.OracleDriver"),
    SQLSERVER("SQLSERVER", "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
    DAMENG("DAMENG", "dm.jdbc.driver.DmDriver");

    private final String name;
    private final String driverClassName;

    DbTypeEnum(String name, String driverClassName) {
        this.name = name;
        this.driverClassName = driverClassName;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String dbName() {
        return this.name;
    }

    public String driverClass() {
        return this.driverClassName;
    }

}
