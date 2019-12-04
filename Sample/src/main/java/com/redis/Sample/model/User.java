package com.redis.Sample.model;

import com.redis.Sample.config.CacheConfigurationProperties;
import lombok.Data;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@RedisHash(value = "user")
public class User implements Serializable {
    @Id
    private String id;
    private String name;
    private String salary;
    @TimeToLive
    private long timeToLive;
    private LocalDateTime timeStamp = LocalDateTime.now();
}
