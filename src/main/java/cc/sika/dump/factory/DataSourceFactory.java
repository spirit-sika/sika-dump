package cc.sika.dump.factory;


import cc.sika.dump.consts.DbTypeEnum;
import cn.hutool.core.text.CharSequenceUtil;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Locale;

/**
 * 数据库连接工厂, 可根据不同的数据库类型获取 DataSource 与 连接 url
 *
 * @author 小吴来哩
 * @since 2025-12
 */
@SuppressWarnings("unused")
public class DataSourceFactory {

    private static final String MYSQL_URL_PATTERN = "jdbc:mysql://{}:{}/{}";
    private static final String POSTGRESQL_URL_PATTERN = "jdbc:postgresql://{}:{}/{}";
    private static final String ORACLE_URL_PATTERN = "jdbc:oracle:thin:@{}:{}:{}";
    private static final String SQLSERVER_URL_PATTERN = "jdbc:sqlserver://{}:{};databaseName={}";
    private static final String DAMENG_URL_PATTERN = "jdbc:dm://{}:{}/{}";

    public static DataSource getDataSource(String dbType, String url, String username, String password) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        String upperCase = dbType.toUpperCase(Locale.ENGLISH);

        switch (DbTypeEnum.valueOf(upperCase)) {
            case MYSQL -> {
                dataSource.setDriverClassName(DbTypeEnum.MYSQL.driverClass());
                return dataSource;
            }
            case ORACLE -> {
                dataSource.setDriverClassName(DbTypeEnum.ORACLE.driverClass());
                return dataSource;
            }
            case POSTGRESQL -> {
                dataSource.setDriverClassName(DbTypeEnum.POSTGRESQL.driverClass());
                return dataSource;
            }
            case DAMENG -> {
                dataSource.setDriverClassName(DbTypeEnum.DAMENG.driverClass());
                return dataSource;
            }
            case SQLSERVER -> {
                dataSource.setDriverClassName(DbTypeEnum.SQLSERVER.driverClass());
                return dataSource;
            }
            default -> throw new IllegalArgumentException("Unsupported database type: " + dbType);
        }
    }

    public static String getURL(String dbType, String host, Integer port, String dbName) {
        String upperCase = dbType.toUpperCase(Locale.ENGLISH);
        return switch (DbTypeEnum.valueOf(upperCase)) {
            case MYSQL -> CharSequenceUtil.format(MYSQL_URL_PATTERN, host, port, dbName);
            case POSTGRESQL -> CharSequenceUtil.format(POSTGRESQL_URL_PATTERN, host, port, dbName);
            case ORACLE ->
                // jdbc:oracle:thin:@[host]:[port]:[SID]
                // jdbc:oracle:thin:@//[host]:[port]/[service_name]
                    CharSequenceUtil.format(ORACLE_URL_PATTERN, host, port, dbName);
            case SQLSERVER -> CharSequenceUtil.format(SQLSERVER_URL_PATTERN, host, port, dbName);
            case DAMENG -> CharSequenceUtil.format(DAMENG_URL_PATTERN, host, port, dbName);
        };
    }

    private DataSourceFactory() {
        // do nothing
    }
}
