package cc.sika.dump.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @author 小吴来哩
 * @since 2025-12
 */
@Component
@ConfigurationProperties(prefix = "thread.pool")
@Data
public class ThreadPoolProperties {

    /**
     * 核心线程数
     */
    private int corePoolSize = Runtime.getRuntime().availableProcessors();

    /**
     * 最大线程数
     */
    private int maxPoolSize = Runtime.getRuntime().availableProcessors() + 10;

    /**
     * 空闲线程存活时间（秒）
     */
    private long keepAliveTime = 60L;

    /**
     * 任务队列容量
     */
    private int queueCapacity = 100;

    /**
     * 线程名前缀
     */
    private String threadNamePrefix = "sika-dump-";

}