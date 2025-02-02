package com.learn.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName ShareInfo
 * @Description 分享信息
 * @Author dajie
 * @Date 2021/6/30 11:35 上午
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShareInfo {

    private String userName;
    private String interfaceId;
    private long expireDate;
    private List<String> urlWhitelist;

}
