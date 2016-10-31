package com.wenhao.netshop.dao.impl;

import com.wenhao.netshop.dao.AbstractBaseRedisDao;
import com.wenhao.netshop.dao.IUserDao;
import com.wenhao.netshop.domain.User;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lw on 2016/10/31.
 */

@Repository
public class UserImpl extends AbstractBaseRedisDao implements IUserDao {
    public Boolean add(final User user) {
        Boolean re = (Boolean) redisTemplate.execute(new RedisCallback() {
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                String key = "user" + user.getId();
                Schema<User> schema = RuntimeSchema.createFrom(User.class);
                byte[] bytes = ProtostuffIOUtil.toByteArray(user, schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                connection.set(key.getBytes(), bytes);
                return true;
            }
        });
        return re;
    }

    public Boolean add(List<User> users) {
        return null;
    }

    public void delete(Long id) {

    }

    public void update(User user) {

    }

    public User get(final Long id) {
        User user = (User) redisTemplate.execute(new RedisCallback() {
            public User doInRedis(RedisConnection connection) throws DataAccessException {
                String key = "user" + id;
                Schema<User> schema = RuntimeSchema.createFrom(User.class);
                byte[] bytes = connection.get(key.getBytes());
                if (bytes != null) {
                    User user = schema.newMessage();
                    ProtostuffIOUtil.mergeFrom(bytes, user, schema);
                    return user;
                } else {
                    return null;
                }
            }
        });
        return user;
    }

    public List<User> getAll() {
        return null;
    }
}
