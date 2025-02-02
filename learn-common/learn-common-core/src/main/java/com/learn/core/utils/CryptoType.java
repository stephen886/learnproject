package com.learn.core.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;

/**
 * @ClassName CryptoType
 * @Description 加密模式
 * @Author dajie
 * @Date 2021/8/12 5:10 下午
 */

@Getter
@AllArgsConstructor
public enum CryptoType {

    /**
     * 国密SM4对称加密
     */
    SM4("SM4/ECB/PKCS5Padding", new SecretKeySpec(CryptoUtil.SM4_KEY, "SM4")),

    /**
     * 3DES对称加密
     */
    DES("DESede", new SecretKeySpec(CryptoUtil.DES_KEY, "DESede"));

    static {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    }

    private final String encryptType;
    private final SecretKey secretKey;


}
