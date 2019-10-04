package com.spring.demo.configuration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Configuration;

/**
 * Example Configuration for Caching
 *
 * @author Lilian Petitpas <lilian.petitpas@outlook.com>
 */
@Configuration
@EnableCaching
public class CacheConfiguration {

    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("schedules");
    }

}
