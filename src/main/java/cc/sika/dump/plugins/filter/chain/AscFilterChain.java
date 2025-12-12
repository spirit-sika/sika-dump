package cc.sika.dump.plugins.filter.chain;

import cc.sika.dump.plugins.filter.OrderableFilter;
import lombok.Getter;

import java.util.Collection;
import java.util.List;

/**
 * 正序过滤器链, 由多个OrderableFilter构建而成
 * <p>
 * 在升序过滤器链中, 过滤器的order越小越早执行
 *
 * @param <T> 过滤器链中每个过滤器处理的泛型
 * @author 小吴来哩
 * @since 2025-12
 */
@Getter
public class AscFilterChain<T> {

    private final Collection<OrderableFilter<T>> filters;
    private final List<OrderableFilter<T>> chian;
    private int position;

    public AscFilterChain(Collection<OrderableFilter<T>> filters) {
        if (filters == null || filters.isEmpty()) {
            throw new IllegalArgumentException("filters can not be empty");
        }
        this.filters = filters;
        this.chian = filters.stream().sorted().toList();
        this.position = 0;
    }

    void doFilter(Collection<T> dataCollection) {
        chian.get(position++).doFilter(dataCollection);
    }

}
