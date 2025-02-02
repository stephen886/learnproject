package com.learn.kafka.bean;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.PartitionInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @ClassName KafkaConfig
 * @Description
 * @Author qsx
 * @Date 2021/11/7 22:03
 * @Version V1.0
 **/
@Configuration
@Slf4j
public class KafkaConfig {

    // 新建一个异常处理器，用@Bean注入
    @Bean
    public ConsumerAwareListenerErrorHandler consumerAwareErrorHandler() {
        return (message, exception, consumer) -> {
            Map<String, List<PartitionInfo>> map = consumer.listTopics();
            StringBuffer sb = new StringBuffer();
            sb.append("consume message error : topic ");
            if (map != null && map.entrySet() != null){
                Iterator<Map.Entry<String, List<PartitionInfo>>> iterator = map.entrySet().iterator();
                while (iterator.hasNext()){
                    Map.Entry<String, List<PartitionInfo>> entry = iterator.next();
                    sb.append(entry.getKey()).append(" partition : [");
                    List<PartitionInfo> list = entry.getValue();
                    for (PartitionInfo info : list) {
                        sb.append(" ").append(info.partition()).append(" ");
                    }
                    sb.append("] ");
                }
            }
            log.error(sb.toString());
            return null;
        };
    }

}
