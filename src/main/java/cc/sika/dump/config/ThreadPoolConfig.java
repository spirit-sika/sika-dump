package cc.sika.dump.config;

import cc.sika.dump.config.properties.ThreadPoolProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author 小吴来哩
 * @since 2025-12
 */
@Configuration
@Slf4j
@RequiredArgsConstructor
public class ThreadPoolConfig {

    private final ThreadPoolProperties threadPoolProperties;

    @Bean(name = "taskExecutor")
    public ThreadPoolExecutor taskExecutor() {
        // 有界阻塞队列
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(threadPoolProperties.getQueueCapacity());

        // 自定义线程工厂，设置线程名称前缀
        ThreadFactory threadFactory = new ThreadFactory() {
            private final AtomicInteger threadNumber = new AtomicInteger(1);

            @Override
            public Thread newThread(@NonNull Runnable r) {
                Thread thread = new Thread(r, threadPoolProperties.getThreadNamePrefix() + threadNumber.getAndIncrement());
                thread.setDaemon(false); // 设置为非守护线程
                log.info("创建新线程：{}", thread.getName());
                return thread;
            }
        };

        // 拒绝策略：AbortPolicy，队列满了并且线程数达到 maxPoolSize，抛出 RejectedExecutionException
        RejectedExecutionHandler rejectionHandler = new ThreadPoolExecutor.AbortPolicy();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                threadPoolProperties.getCorePoolSize(),
                threadPoolProperties.getMaxPoolSize(),
                threadPoolProperties.getKeepAliveTime(),
                TimeUnit.SECONDS,
                workQueue,
                threadFactory,
                rejectionHandler
        );

        log.info("线程池 [taskExecutor] 初始化完成 => " +
                        "corePoolSize={}, maxPoolSize={}, queueCapacity={}, keepAliveTime={}s",
                threadPoolProperties.getCorePoolSize(),
                threadPoolProperties.getMaxPoolSize(),
                threadPoolProperties.getQueueCapacity(),
                threadPoolProperties.getKeepAliveTime());
        return executor;
    }
}