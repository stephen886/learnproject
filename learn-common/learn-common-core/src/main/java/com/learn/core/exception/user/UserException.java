package com.learn.core.exception.user;

import com.learn.core.exception.BaseException;

/**
 * 用户信息异常类
 * 
 * @author xkiot
 */
public class UserException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}
