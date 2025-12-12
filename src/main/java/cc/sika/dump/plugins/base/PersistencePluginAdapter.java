package cc.sika.dump.plugins.base;

import cc.sika.dump.domain.SyncConfig;

import java.util.Collection;
import java.util.List;

/**
 * 数据持久插件
 *
 * @author 小吴来哩
 * @since 2025-12
 */
public abstract class PersistencePluginAdapter<T> implements ReceivePlugin<T> {
    @Override
    public void beforePersistence(List<SyncConfig> syncConfigList, Collection<T> dataCollection) {

    }

    @Override
    public void afterPersistence(List<SyncConfig> syncConfigList, Collection<T> dataCollection) {

    }

    @Override
    public String getName() {
        return "数据持久化插件";
    }

    @Override
    public String getDescription() {
        return "数据持久化插件, 用于对数据入库前后增强逻辑处理";
    }
}
