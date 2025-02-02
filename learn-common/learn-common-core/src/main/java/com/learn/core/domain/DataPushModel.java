package com.learn.core.domain;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName DataPushModel
 * @Description 数据推送model
 * @Author dajie
 * @Date 2021/6/9 7:57 下午
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataPushModel {

    private String operating;
    private JSONObject data;


}
