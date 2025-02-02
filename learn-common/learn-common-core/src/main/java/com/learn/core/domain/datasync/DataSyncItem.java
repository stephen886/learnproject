package com.learn.core.domain.datasync;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName DataSyncItem
 * @Description 同步数据项
 * @Author dajie
 * @Date 2021/5/26 4:32 下午
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataSyncItem {

    /**
     * 数据id
     */
    private String dataId;

    /**
     * 额外数据，将直接发送至设备
     * 处理模式为 data.pullAll(extraData)
     */
    private JSONObject extraData;
    /**
     * 设备号
     */
    private String termId;
    /**
     * 操作类型,add-新增,del-删除
     */
    private String type;


}
