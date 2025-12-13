package cc.sika.dump.domain.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serial;

/**
 *
 * @author 小吴来哩
 * @since 2025-12
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("PLUGIN_CONFIG")
public class PluginConfig extends BaseEntityInfo {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("id")
    private Long id;

    /**
     * 插件对应的同步配置 id SYNC_CONFIG_ID
     */
    @TableField("SYNC_CONFIG_ID")
    private Long syncConfigId;

    /**
     * 插件类型 PLUGIN_TYPE
     *
     * @see cc.sika.dump.consts.PluginType 插件类型枚举
     */
    @TableField("PLUGIN_TYPE")
    private Integer pluginType;

    /**
     * 插件名称 PLUGIN_NAME
     */
    @TableField("PLUGIN_NAME")
    private String pluginName;

    /**
     * 插件描述 PLUGIN_DESC
     */
    @TableField("PLUGIN_DESC")
    private String pluginDesc;

    /**
     * 插件类名, 全限定类型或Ioc名称 PLUGIN_CLASS
     */
    @TableField("PLUGIN_CLASS")
    private String pluginClass;
}
