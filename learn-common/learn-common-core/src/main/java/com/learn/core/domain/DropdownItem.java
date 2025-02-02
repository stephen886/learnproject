package com.learn.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName DropdownItem
 * @Description 自定义下拉返回内容
 * @Author dajie
 * @Date 2021/8/6 2:33 下午
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DropdownItem {

    private String id;
    private String value;
    private boolean checked;

}
