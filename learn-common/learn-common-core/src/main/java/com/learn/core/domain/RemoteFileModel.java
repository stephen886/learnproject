package com.learn.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName RemoteFileModel
 * @Description 远程文件实体
 * @Author dajie
 * @Date 2021/6/23 4:55 下午
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RemoteFileModel {

    private String url;
    private String fileName;

}
