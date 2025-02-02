package com.learn.core.domain.datasync;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName DataSyncModel
 * @Description 数据同步model
 * @Author dajie
 * @Date 2021/5/26 4:31 下午
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataSyncModel {

    /**
     * 接口id
     */
    private String interfaceId;

    /**
     * 同步的数据
     */
    private List<DataSyncItem> dataSyncItems;

    /**
     * 额外的id，将会直接保存至DataSyncInfo表中，用于查询
     */
    private String extraId;

    /**
     * 附加数据，将会直接保存至DataSyncInfo表中
     */
    private JSONObject additionalData;

    public DataSyncModel(String interfaceId, List<DataSyncItem> dataSyncItems, JSONObject additionalData) {
        this.interfaceId = interfaceId;
        this.dataSyncItems = dataSyncItems;
        this.additionalData = additionalData;
    }


}
