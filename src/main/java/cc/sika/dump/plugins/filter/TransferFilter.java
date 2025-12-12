package cc.sika.dump.plugins.filter;

import java.util.Collection;

/**
 * 数据发送过滤器
 *
 * @author 小吴来哩
 * @since 2025-12
 */
public class TransferFilter<T> implements OrderableFilter<T> {

    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public void doFilter(Collection<T> collection) {

    }
}
