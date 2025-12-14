package cc.sika.dump.plugins.base;

import cc.sika.dump.consts.PluginType;
import cc.sika.dump.domain.po.SyncConfig;

import java.util.Collection;
import java.util.List;

/**
 * 发送端插件
 *
 * @author 小吴来哩
 * @since 2025-12
 */
@SuppressWarnings("unused")
public interface SendPlugin<T> extends DumpPlugin {

    @Override
    default PluginType getType() {
        return PluginType.SEND_PLUGIN;
    }

    /**
     * 数据查询前的处理钩子
     *
     * @param syncConfigList 同步配置集合, 只包含发送端配置
     */
    void beforeSelect(List<SyncConfig> syncConfigList);

    /**
     * 数据查询后的处理钩子
     *
     * @param syncConfigList 同步配置集合, 只包含发送端配置
     * @param dataCollection 查询到的结果集合
     */
    void afterSelect(List<SyncConfig> syncConfigList, Collection<T> dataCollection);

}
