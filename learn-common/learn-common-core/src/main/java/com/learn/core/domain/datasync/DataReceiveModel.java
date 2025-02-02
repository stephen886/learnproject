package com.learn.core.domain.datasync;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @ClassName DataReceiveModel
 * @Description 数据接收model
 * @Author dajie
 * @Date 2021/5/19 4:59 下午
 * @Version V1.0
 **/

@Data
public class DataReceiveModel {
    // 非必填
    private String code;
    private String message;
    private String taskId;
    // 必填
    private String termId;
    private String interfaceId;
    private Long timestamp;
    private JSONObject data;

}
