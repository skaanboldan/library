package com.project.library.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AppConfig {

    @Value("${task.executor.corePoolSize}")
    private int corePoolSize;

    @Value("${task.executor.maxPoolSize}")
    private int maxPoolSize;

    @Value("${task.executor.queueCapacity}")
    private int queueCapacity;

    @Value("${task.executor.threadNamePrefix}")
    private String threadNamePrefix;


    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix(threadNamePrefix);
        executor.initialize();
        return executor;
    }
}
