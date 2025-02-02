package com.learn.core.domain.datasync;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName DataDistributionModel
 * @Description 数据下发model
 * @Author dajie
 * @Date 2021/5/26 5:53 下午
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class DataDistributionModel extends DataSendModel {

    /**
     * 批次id
     */
    private String batchId;

    /**
     * 当前数据序号
     */
    private int num;

    /**
     * 数据总数
     */
    private int total;

    /**
     * 下发类型 add-新增,del-删除
     */
    private String distributionType;

}
