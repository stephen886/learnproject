package com.learn.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.domain.UserInfo;
import com.learn.mapper.UserInfoMapper;
import com.learn.system.service.IUserInfoService;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserInfoServiceImpl
 * @Description
 * @Author qsx
 * @Date 2021/11/3 22:46
 * @Version V1.0
 **/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {
}
