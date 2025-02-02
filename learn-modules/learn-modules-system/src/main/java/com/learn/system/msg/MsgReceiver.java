package com.learn.system.msg;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName MsgReceiver
 * @Description
 * @Author qsx
 * @Date 2021/11/7 22:51
 * @Version V1.0
 **/
@Component
@Slf4j
public class MsgReceiver {

//    @KafkaListener(topics = "test-topic",errorHandler = "consumerAwareErrorHandler")
    public void onMessage(ConsumerRecord<String,Object> message) throws Exception{
        log.info(message.key() + " " + message.topic() + " " + message.value() );
    }
}
