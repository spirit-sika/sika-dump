package cc.sika.dump.consts;

import lombok.Getter;

/**
 * @author 小吴来哩
 * @since 2025-12
 */
@Getter
public enum DbType {
    MYSQL("MYSQL", "com.mysql.cj.jdbc.Driver"),
    POSTGRESQL("POSTGRESQL", "org.postgresql.Driver"),
    ORACLE("ORACLE", "oracle.jdbc.OracleDriver"),
    SQLSERVER("SQLSERVER", "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
    DAMENG("DAMENG", "dm.jdbc.driver.DmDriver");

    private final String dbName;
    private final String driverClassName;

    DbType(String dbName, String driverClassName) {
        this.dbName = dbName;
        this.driverClassName = driverClassName;
    }

    @Override
    public String toString() {
        return this.dbName;
    }

    public String dbName() {
        return this.dbName;
    }

    public String driverClass() {
        return this.driverClassName;
    }

}
