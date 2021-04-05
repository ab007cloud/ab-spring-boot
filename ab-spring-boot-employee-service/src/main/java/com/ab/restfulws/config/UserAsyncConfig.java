package com.ab.restfulws.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class UserAsyncConfig {

	private static final String USER_THREAD_NAME_PREFIX = "userThread-";

	@Bean
	public Executor userTaskExecutor() {
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setMaxPoolSize(2);
		threadPoolTaskExecutor.setCorePoolSize(2);
		threadPoolTaskExecutor.setQueueCapacity(100);
		threadPoolTaskExecutor.setThreadNamePrefix(USER_THREAD_NAME_PREFIX);
		threadPoolTaskExecutor.initialize();
		return threadPoolTaskExecutor;

	}

}
