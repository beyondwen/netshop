package com.wenhao.netshop.utils;

import com.wenhao.netshop.domain.User;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by lw on 2016/10/31.
 */
public class RedisDao {

    private JedisPool jedisPool;

    public RedisDao(String hostName, int port) {
        this.jedisPool = new JedisPool(hostName, port);
    }

    Schema<User> schema = RuntimeSchema.createFrom(User.class);

    public User get(Long id) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            try {
                String key = "user" + id;
                byte[] bytes = jedis.get(key.getBytes());
                if (bytes != null) {
                    User user = schema.newMessage();
                    ProtostuffIOUtil.mergeFrom(bytes, user, schema);
                    return user;
                }
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public String put(User user) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            try {
                String key = "user" + user.getId();
                byte[] bytes = ProtostuffIOUtil.toByteArray(user, schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                int timeOut = 60 * 60;
                String result = jedis.setex(key.getBytes(), timeOut, bytes);
                return result;
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
