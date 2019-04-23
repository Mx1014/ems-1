package com.qhit.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;


@Component
public class RedisManger {
    @Autowired
//    spring-data-redis 中的核心操作类是 RedisTemplate
    private RedisTemplate<String, String> redisTemplate;

    public boolean set(String key, String value) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

}
