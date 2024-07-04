package com.dailyjournal.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.CompletableFuture;

@Configuration(proxyBeanMethods = false)
@RequiredArgsConstructor
public class DataInitializer {

    private final DataInitializerTask dataInitializerTask;

    @Bean
    public ApplicationRunner runner() {
        return args -> CompletableFuture.runAsync(dataInitializerTask::initialize);
    }

}
