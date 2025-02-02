package com.learn.common.redis.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisClusterConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class RedisLock {

    private static final Long SUCCESS = 1L;
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisLock.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    public boolean tryLock(String lockKey, String value, int expireTime){
        try {
            // 使用lua脚本执行，避免多次与redis交互，确保锁仅能被一人获取
            String script = "if redis.call('setNx',KEYS[1],ARGV[1]) then if redis.call('get',KEYS[1])==ARGV[1] then return redis.call('pexpire',KEYS[1],ARGV[2]) else return 0 end end";
            RedisScript<Long> redisScript = new DefaultRedisScript<>(script, Long.class);
//            Object result = redisTemplate.execute(redisScript, Collections.singletonList(lockKey), value, expireTime +"");
            Object result = redisTemplate.execute(new RedisCallback<Long>() {
                @Override
                public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
                    Object nativeConnection = redisConnection.getNativeConnection();

                    if (nativeConnection instanceof JedisClusterConnection){

                    }else if (nativeConnection instanceof RedisProperties.Jedis){

                    }

                    return null;
                }
            });




            return SUCCESS.equals(result);
        } catch (Exception e) {
            LOGGER.error(e.toString());
        }
        return false;
    }

    public boolean releaseLock(String lockKey, String value){
        try {
            // 使用lua脚本执行，避免多次与redis交互
            String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
            RedisScript<Long> redisScript = new DefaultRedisScript<>(script, Long.class);
            Object result = redisTemplate.execute(redisScript, Collections.singletonList(lockKey), value);
            return SUCCESS.equals(result);
        }catch (Exception e){
            LOGGER.error(e.toString());
        }
        return false;
    }


}
