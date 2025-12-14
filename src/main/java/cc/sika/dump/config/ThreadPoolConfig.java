package cc.sika.dump.config;

import cc.sika.dump.config.properties.ThreadPoolProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
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

    @Bean(name = "sikaThreadPool")
    public ThreadPoolTaskExecutor sikaThreadPool() {
        // 创建 ThreadPoolTaskExecutor
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        // 设置核心参数
        executor.setCorePoolSize(threadPoolProperties.getCorePoolSize());
        executor.setMaxPoolSize(threadPoolProperties.getMaxPoolSize());
        executor.setQueueCapacity(threadPoolProperties.getQueueCapacity());
        executor.setKeepAliveSeconds((int) threadPoolProperties.getKeepAliveTime());

        // 设置线程名称前缀
        executor.setThreadNamePrefix(threadPoolProperties.getThreadNamePrefix());

        // 设置线程工厂（可选，如果需要记录日志）
        executor.setThreadFactory(new ThreadFactory() {
            private final AtomicInteger threadNumber = new AtomicInteger(1);

            @Override
            public Thread newThread(@NonNull Runnable r) {
                Thread thread = new Thread(r, threadPoolProperties.getThreadNamePrefix() + threadNumber.getAndIncrement());
                thread.setDaemon(false);
                log.info("创建新线程：{}", thread.getName());
                return thread;
            }
        });

        // 设置拒绝策略：AbortPolicy，队列满了并且线程数达到 maxPoolSize，抛出 RejectedExecutionException
        // ThreadPoolTaskExecutor 使用的是 TaskRejectedException
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());

        // 设置等待所有任务完成再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);

        // 设置等待任务完成的最大时间（秒）
        executor.setAwaitTerminationSeconds(30);

        // 允许核心线程超时回收
        executor.setAllowCoreThreadTimeOut(false);

        // 初始化线程池
        executor.initialize();

        log.info("线程池 [sikaThreadPool] 初始化完成 => " +
                        "corePoolSize={}, maxPoolSize={}, queueCapacity={}, keepAliveTime={}s",
                threadPoolProperties.getCorePoolSize(),
                threadPoolProperties.getMaxPoolSize(),
                threadPoolProperties.getQueueCapacity(),
                threadPoolProperties.getKeepAliveTime());

        return executor;
    }
}