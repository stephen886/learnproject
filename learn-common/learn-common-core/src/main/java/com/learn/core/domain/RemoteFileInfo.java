package com.learn.core.domain;

import lombok.Data;

/**
 * @ClassName RemoteFileInfo
 * @Description
 * @Author dajie
 * @Date 2021/5/7 7:27 下午
 * @Version V1.0
 **/

@Data
public class RemoteFileInfo {

    private String id;
    private String document;
    private String fileType;
    private String url;

}
