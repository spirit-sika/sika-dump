package cc.sika.dump.plugins.filter;

import java.util.Collection;
import java.util.Comparator;

/**
 * 可排序过滤器接口, 处理顺序由 order 值决定
 *
 * @param <T> 过滤器处理的数据类型
 * @author 小吴来哩
 * @since 2025-12
 */
public interface OrderableFilter<T> extends Comparable<OrderableFilter<T>>, Comparator<OrderableFilter<T>> {

    /**
     * 过滤器排列顺序
     * @return 排列顺序
     */
    int getOrder();

    void doFilter(Collection<T> collection);

    /**
     * 默认排序规则：根据 order 值升序排列
     *
     * @param other 要比较的另一个 OrderableFilter 实例
     * @return 比较结果
     */
    @Override
    default int compareTo(OrderableFilter other) {
        return Integer.compare(this.getOrder(), other.getOrder());
    }

    @Override
    default int compare(OrderableFilter o1, OrderableFilter o2) {
        return Integer.compare(o1.getOrder(), o2.getOrder());
    }
}
