package cc.sika.dump.plugins.base;

import cc.sika.dump.consts.PluginType;
import cc.sika.dump.domain.SyncConfig;

import java.util.Collection;
import java.util.List;

/**
 * 接收端插件
 *
 * @author 小吴来哩
 * @since 2025-12
 */
public interface ReceivePlugin<T> extends DumpPlugin {

    @Override
    default PluginType getType() {
        return PluginType.RECEIVE_PLUGIN;
    }

    /**
     * 数据持久化前的处理钩子
     *
     * @param syncConfigList 同步配置集合, 只包含接收端配置
     * @param dataCollection 数据集合
     */
    void beforePersistence(List<SyncConfig> syncConfigList, Collection<T> dataCollection);

    /**
     * 数据持久化后的处理钩子
     *
     * @param syncConfigList 同步配置集合, 只包含接收端配置
     * @param dataCollection 数据集合, beforePersistence处理后的数据
     */
    void afterPersistence(List<SyncConfig> syncConfigList, Collection<T> dataCollection);

}
