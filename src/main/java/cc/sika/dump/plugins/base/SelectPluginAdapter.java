package cc.sika.dump.plugins.base;

import cc.sika.dump.domain.SyncConfig;

import java.util.Collection;
import java.util.List;

/**
 * 查找处理插件
 *
 * @author 小吴来哩
 * @since 2025-12
 */
public abstract class SelectPluginAdapter<T> implements SendPlugin<T> {

    @Override
    public String getName() {
        return "查找处理插件";
    }

    @Override
    public String getDescription() {
        return "查找处理插件, 用于处理数据查找前后增强逻辑";
    }

    @Override
    public void beforeSelect(List<SyncConfig> syncConfigList) {

    }

    @Override
    public void afterSelect(List<SyncConfig> syncConfigList, Collection<T> dataCollection) {

    }
}
