package cc.sika.dump.domain;

import cc.sika.dump.consts.SyncConfigTypeEnum;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serial;

/**
 * 数据同步配置实体
 *
 * @author 小吴来哩
 * @since 2025-12
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("SYNC_CONFIG")
public class SyncConfig extends BaseEntityInfo {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("id")
    private Long id;

    /**
     * 连接信息 id CONNECTION_ID
     */
    @TableField("CONNECTION_ID")
    private Long connectionId;

    /**
     * 同步配置类型 SYNC_TYPE
     *
     * @see SyncConfigTypeEnum 类型枚举
     */
    @TableField("SYNC_TYPE")
    private Integer syncType;

    /**
     * 引用名 REF_NAME
     */
    @TableField("REF_NAME")
    private String refName;

    /**
     * 表名 TABLE_NAME
     */
    @TableField("TABLE_NAME")
    private String tableName;

    /**
     * l COLUMN_NAME
     */
    @TableField("COLUMN_NAME")
    private String columnName;

    /**
     * 列数据库数据类型 COLUMN_TYPE
     */
    @TableField("COLUMN_TYPE")
    private String columnType;

    /**
     * 列的 Java 类型, 全限定类名 COLUMN_JAVA_TYPE
     */
    @TableField("COLUMN_JAVA_TYPE")
    private String columnJavaType;

    /**
     * 数据库列长度 COLUMN_LENGTH
     */
    @TableField("COLUMN_LENGTH")
    private Integer columnLength;

    /**
     * 数据库列精度, 小数位数 COLUMN_SCALE
     */
    @TableField("COLUMN_SCALE")
    private Integer columnScale;

    /**
     * 是否自动生成, 1-是 2-否 AUTO_GENERATE
     */
    @TableField("AUTO_GENERATE")
    private Integer autoGenerate;

}
