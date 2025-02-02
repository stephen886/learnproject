package com.learn.core.domain;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;

/**
 * @ClassName ExportRequestModel
 * @Description excel导出请求模型
 * @Author dajie
 * @Date 2021/5/6 11:27 上午
 * @Version V1.0
 **/

@Data
public class ExportRequestModel<T> {

    /**
     * 查询参数
     */
    private T queryParams;
    /**
     * excel标题
     */
    private String excelTitle;
    /**
     * 表头信息
     */
    private JSONArray headColumns;
    /**
     * 排序字段
     */
    private String orderByColumn;
    /**
     * 是否升序
     */
    private String isAsc;

}
