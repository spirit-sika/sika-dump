package cc.sika.dump.domain.po;

import cc.sika.dump.consts.DbTypeEnum;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serial;

/**
 * 数据库连接信息实体
 *
 * @author 小吴来哩
 * @since 2025-12
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("CONNECT_INFO")
public class DbConnectInfo extends BaseEntityInfo {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 连接信息 Id
     */
    @TableId("id")
    private Long id;

    /**
     * 连接信息名称 CONNECT_NAME
     */
    @TableField("CONNECT_NAME")
    private String connectName;

    /**
     * 连接描述(备注) CONNECT_DESC
     */
    @TableField("CONNECT_DESC")
    private String connectDesc;

    /**
     * 库名称 DB_NAME
     */
    @TableField("DB_NAME")
    private String dbName;

    /**
     * scheme SCHEME
     */
    @TableField("SCHEME")
    private String scheme;

    /**
     * 数据库服务器地址 HOST
     */
    @TableField("HOST")
    private String host;

    /**
     * 数据库服务器端口, 存在特殊情况例如3306:3307, 不能直接使用short PORT
     */
    @TableField("PORT")
    private String port;

    /**
     * Oracle 使用的服务名或sId SERVER_SID
     */
    @TableField("SERVER_SID")
    private String serverSid;

    /**
     * 数据库服务器登录用户名 SERVER_LOGIN_USERNAME
     */
    @TableField("SERVER_LOGIN_USERNAME")
    private String serverLoginUsername;

    /**
     * 数据库服务器登录密码 SERVER_LOGIN_PASSWORD
     */
    @TableField("SERVER_LOGIN_PASSWORD")
    private String serverLoginPassword;

    /**
     * 数据库连接 url SERVER_CONNECT_URL
     */
    @TableField("SERVER_CONNECT_URL")
    private String serverConnectUrl;

     /**
     * 数据库服务器类型 SERVER_TYPE
     *
     * @see DbTypeEnum 可用数据库类型枚举
     */
     @TableField("SERVER_TYPE")
    private String serverType;

    /**
     * 服务器版本号 SERVER_VERSION
     */
    @TableField("SERVER_VERSION")
    private String serverVersion;


}
