package com.learn.core.domain.datasync;

import lombok.Data;

/**
 * @ClassName DataSyncModel
 * @Description 数据同步model
 * @Author dajie
 * @Date 2021/5/19 4:22 下午
 * @Version V1.0
 **/
@Data
public class DataSendModel {

    /**
     * 设备号
     */
    private String termId;

    /**
     * 发送时间戳
     */
    private long timestamp;

    /**
     * 报文关联接口标识
     */
    public String interfaceFlag;

    /**
     * 任务id，用于后续消息回复
     */
    private String taskId;
    /**
     * 数据类型 数据下发(data)/指令下发(order)/参数下发(params)/软件更新(softUpdate)
     */
    private String dataType;
    /**
     * 报文关联接口
     */
    private String interfaceId;

    /**
     * 数据
     */
    private Object data;

}
