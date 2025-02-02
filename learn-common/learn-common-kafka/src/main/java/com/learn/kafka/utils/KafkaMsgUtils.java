package com.learn.kafka.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @ClassName KafkaUtils
 * @Description
 * @Author qsx
 * @Date 2021/11/7 16:45
 * @Version V1.0
 **/
@Component
public class KafkaMsgUtils {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    /**
     * 发送消息
     *
     * @param topic 主题
     * @param data  消息内容
     * @return
     * @throws Exception
     */
    public ListenableFuture<SendResult<String, Object>> sendMsg(String topic, Object data) throws Exception {
        return kafkaTemplate.send(topic, data);
    }

    /**
     * 指定key发送消息
     *
     * @param topic 主题
     * @param key   键值，相同的key会发送到同一个partition分区中
     * @param data  消息内容
     * @return
     * @throws Exception
     */
    public ListenableFuture<SendResult<String, Object>> sendMsg(String topic, String key, Object data) throws Exception {
        return kafkaTemplate.send(topic, key, data);
    }

    /**
     * 指定partition（分区）和key发送消息
     *
     * @param topic     主题
     * @param partition 分区
     * @param key       键值
     * @param data      消息内容
     * @return
     * @throws Exception
     */
    public ListenableFuture<SendResult<String, Object>> sendMsg(String topic, Integer partition, String key, Object data) throws Exception {
        return kafkaTemplate.send(topic, partition, key, data);
    }

    /**
     * 指定partition（分区）、时间戳和key发送消息
     *
     * @param topic     主题
     * @param partition 分区
     * @param timestamp 时间戳
     * @param key       键值
     * @param data      消息内容
     * @return
     * @throws Exception
     */
    public ListenableFuture<SendResult<String, Object>> sendMsg(String topic, Integer partition, Long timestamp, String key, Object data) throws Exception {
        return kafkaTemplate.send(topic, partition, timestamp, key, data);
    }


}
