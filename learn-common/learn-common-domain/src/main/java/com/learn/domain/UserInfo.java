package com.learn.domain;

import lombok.Data;

@Data
public class UserInfo {
    private Integer id;

    private String loginId;

    private String userName;

    private String userPwd;

}