package com.example.coursecurrency.config;


import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.github.benmanes.caffeine.cache.Caffeine.from;
import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;

@Configuration
@EnableCaching
public class CaffeineCacheConfig {

    @Bean
    CacheManager cacheManager(CacheProperties cacheProperties) {
        var caches = ofNullable(cacheProperties.specifications())
                .map(cacheSpecifications -> cacheSpecifications.stream()
                        .map(specification -> new CaffeineCache(specification.name(), from(specification.spec()).build()))
                        .toList())
                .orElse(emptyList());

        var cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(caches);
        return cacheManager;
    }
}
