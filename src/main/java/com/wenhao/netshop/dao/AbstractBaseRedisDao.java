package com.wenhao.netshop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by lw on 2016/10/31.
 */
public class AbstractBaseRedisDao<K, V> {

    @Autowired
    protected RedisTemplate<K, V> redisTemplate;

    public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
