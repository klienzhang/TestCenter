package com.berserker.server.util;

import com.berserker.server.util.RedisGeneratorDao;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import java.io.ObjectInput;
import java.io.Serializable;

/**
 * Created by klien on 2016/10/10.
 */
@Component
public class RedisUtil<T extends Serializable> extends RedisGeneratorDao<String, T> {

    public void set(final String key, Object object) {
        final byte[] vbytes = SerializeUtil.serialize(object);
        redisTemplate.execute(new RedisCallback<Object>() {
            public Object doInRedis(RedisConnection connection)
                    throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                connection.set(serializer.serialize(key),vbytes);
                return null;
            }
        });
    }

    public <T> T get(final String keyId, Class<T> type) {
        T result = redisTemplate.execute(new RedisCallback<T>() {
            public T doInRedis(RedisConnection connection)
                    throws DataAccessException {
                byte[] key = redisTemplate.getStringSerializer().serialize(keyId);
                if (connection.exists(key)) {
                    byte[] valuebytes = connection.get(key);
                    @SuppressWarnings("unchecked")
                    T value = (T) SerializeUtil.unserialize(valuebytes);
                    return value;
                }
                return null;
            }
        });
        return result;
    }
}
