package com.twolight.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    public static final int TIME_OUT = 3600_000 * 24 * 7;

    @Autowired
    private RedisTemplate<String, String> redis;

    public void saveAuthorization(long userId, String authentication) {
        redis.boundValueOps(String.valueOf(userId)).set(authentication, TIME_OUT, TimeUnit.MILLISECONDS);
    }

    public String getAuthorization(long userId) {
        return redis.boundValueOps(String.valueOf(userId)).get();
    }

    public void refreshAuthorizationExpired(long userId) {
        redis.boundValueOps(String.valueOf(userId)).expire(TIME_OUT, TimeUnit.MILLISECONDS);
    }

    public void deleteAuthorization(long userId) {
        redis.delete(String.valueOf(userId));
    }
}
