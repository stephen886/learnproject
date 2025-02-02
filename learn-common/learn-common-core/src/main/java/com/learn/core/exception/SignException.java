package com.learn.core.exception;

/***
 * 验签错误
 * 签名验证异常
 */
public class SignException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public SignException(String message) {
        super(message);
    }
}
