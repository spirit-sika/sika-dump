package cc.sika.dump.plugins.base;

import cc.sika.dump.consts.PluginType;

/**
 * 数据泵插件接口
 *
 * @author 小吴来哩
 * @since 2025-12
 */
public interface DumpPlugin {

    /**
     * 获取插件名称
     *
     * @return 插件名称
     */
    String getName();

    /**
     * 获取插件类型
     *
     * @return PluginType
     * @see cc.sika.dump.consts.PluginType 插件类型枚举
     */
    PluginType getType();

    /**
     * 插件功能描述说明
     *
     * @return 插件功能描述说明
     */
    default String getDescription() {
        return "";
    }

}
