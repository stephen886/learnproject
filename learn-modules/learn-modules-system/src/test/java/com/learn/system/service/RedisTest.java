package com.learn.system.service;

import com.learn.common.redis.utils.RedisLock;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class RedisTest {

    @Autowired
    private RedisLock redisLock;

    @Test
    public void testLock(){
        boolean res = redisLock.tryLock("hello world!","1",100000);
        log.debug(String.valueOf(res));
    }

    @Test
    public void testReleaseLock(){
        boolean res = redisLock.releaseLock("hello world!","1");
        log.debug(String.valueOf(res));
    }
}
