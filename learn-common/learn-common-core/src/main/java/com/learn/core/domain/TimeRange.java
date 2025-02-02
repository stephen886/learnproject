package com.learn.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName TimeRange
 * @Description 时间范围
 * @Author dajie
 * @Date 2021/8/20 10:12 上午
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeRange {

    private long startTime;
    private long endTime;

}
