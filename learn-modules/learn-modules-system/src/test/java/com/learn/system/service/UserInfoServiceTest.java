//package com.learn.system.service;
//
//import com.learn.domain.UserInfo;
//import com.learn.kafka.utils.KafkaMsgUtils;
//import com.learn.mapper.UserInfoMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @ClassName UserInfoServiceTest
// * @Description
// * @Author qsx
// * @Date 2021/11/2 23:14
// * @Version V1.0
// **/
//@SpringBootTest
//@Slf4j
//@RunWith(SpringRunner.class)
//public class UserInfoServiceTest {
//    @Autowired
//    private UserInfoMapper userInfoMapper;
//    @Autowired
//    private KafkaMsgUtils kafkaMsgUtils;
//
//    @Test
//    public void selectUser(){
//        UserInfo userInfo = userInfoMapper.selectById("1");
//        log.info(userInfo.toString());
//
//        Map<String,Object> map = new HashMap<>();
//        map.put("id",2);
//        List<UserInfo> userInfoByMap = userInfoMapper.selectByMap(map);
//
//        UserInfo nameInfo = userInfoMapper.selectByName("lisi");
//        log.info(nameInfo.toString());
//
//    }
//
//    @Test
//    public void testKafka() throws Exception {
//        kafkaMsgUtils.sendMsg("test-topic","hello world!");
//    }
//
//}
