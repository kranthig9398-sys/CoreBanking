package com.cb.config;

import java.util.concurrent.TimeUnit;

import javax.persistence.Basic;

import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;

@Configuration
public class CBCaffeineCacheManagerConfig {

	@Bean
	public CacheManager cacheManager() {
		CaffeineCacheManager caffeineCache=new CaffeineCacheManager();

		caffeineCache.setCaffeine(Caffeine.newBuilder().maximumSize(500).expireAfterWrite(5, TimeUnit.MINUTES));
		return caffeineCache;
	}

}
