package com.learn.core.domain;

import lombok.Data;

/**
 * @ClassName MsgSubscribeModel
 * @Description 消息订阅模型
 * @Author dajie
 * @Date 2021/5/20 10:11 上午
 * @Version V1.0
 **/
@Data
public class SubscribeModel {

    private String code;
    private String message;
    private String termId;
    private String interfaceId;
    private String productId;
    private long timestamp;
    private Object data;
}
