package com.learn.core.domain;

import lombok.Data;

/**
 * 文件信息
 *
 * @author xkiot
 */

@Data
public class SysFile {
    /**
     * 文件名称
     */
    private String name;

    /**
     * 文件地址
     */
    private String url;

    /**
     * 文件md5
     */
    private String md5;

    /**
     * 文件大小
     */
    private Long size;

}
