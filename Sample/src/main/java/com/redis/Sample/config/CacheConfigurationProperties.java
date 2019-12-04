package com.redis.Sample.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties()
@Data
public class CacheConfigurationProperties {
    @Value("${spring.cache.redis.ttl}")
    private long timeoutSeconds;
    private int redisPort = 6379;
    private String redisHost = "localhost";
    // Mapping of cacheNames to expira-after-write timeout in seconds
    private Map<String, Long> cacheExpirations = new HashMap<>();

    public long getTimeoutSeconds() {
        return timeoutSeconds;
    }
}
