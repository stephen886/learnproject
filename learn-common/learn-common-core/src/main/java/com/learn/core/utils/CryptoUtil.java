package com.learn.core.utils;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.FileUtil;
import com.learn.core.config.ConfigData;
import com.learn.core.constant.Constants;


import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * @ClassName CryptUtil
 * @Description
 * @Author dajie
 * @Date 2021/5/14 3:45 下午
 * @Version V1.0
 **/
public class CryptoUtil {


    public static final byte[] DES_KEY = Base64.decode("9xB/tgHjwcKtEMTsQLx1QN9zAq2tCKFF");
    public static final byte[] SM4_KEY = Base64.decode("eKzZrrliF1RdV8e+/U6lZw==");
    private final static Set<String> ENCRYPT_FILE_EXT;
    private static ConfigData configData;

    static {
        configData = SpringUtils.getBean(ConfigData.class);
        Set<String> temp = new HashSet<>();
        temp.add(Constants.ENCRYPT_FILE_NAME_EXT_CN);
        temp.add(Constants.ENCRYPT_FILE_NAME_EXT);
        ENCRYPT_FILE_EXT = Collections.unmodifiableSet(temp);
    }

    public static CipherInputStream encryptInputStream(InputStream inputStream, CryptoType cryptoType) throws Exception {
        Cipher cipher = Cipher.getInstance(cryptoType.getEncryptType());
        cipher.init(Cipher.ENCRYPT_MODE, cryptoType.getSecretKey());
        return new CipherInputStream(inputStream, cipher);
    }

    public static CipherInputStream decryptInputStream(InputStream inputStream, CryptoType cryptoType) throws Exception {
        Cipher cipher = Cipher.getInstance(cryptoType.getEncryptType());
        cipher.init(Cipher.DECRYPT_MODE, cryptoType.getSecretKey());
        return new CipherInputStream(inputStream, cipher);
    }

    public static CipherOutputStream encryptOutputStream(OutputStream outputStream, CryptoType cryptoType) throws Exception {
        Cipher cipher = Cipher.getInstance(cryptoType.getEncryptType());
        cipher.init(Cipher.ENCRYPT_MODE, cryptoType.getSecretKey());
        return new CipherOutputStream(outputStream, cipher);
    }

    public static CipherOutputStream decryptOutputStream(OutputStream outputStream, CryptoType cryptoType) throws Exception {
        Cipher cipher = Cipher.getInstance(cryptoType.getEncryptType());
        cipher.init(Cipher.DECRYPT_MODE, cryptoType.getSecretKey());
        return new CipherOutputStream(outputStream, cipher);
    }

    public static CryptoType getCryptoTypeFromFileName(String fileName) {
        String extName = FileUtil.extName(fileName);
        if (Constants.ENCRYPT_FILE_NAME_EXT_CN_NO_DOT.equals(extName)) {
            return CryptoType.SM4;
        } else if (Constants.ENCRYPT_FILE_NAME_EXT_NO_DOT.equals(extName)) {
            return CryptoType.DES;
        }
        throw new IllegalArgumentException("文件未加密或不支持加密类型");
    }

    public static CryptoType getCryptoType() {
        String encryptType = configData.encryptMode;
        if ("SM4".equals(encryptType.toUpperCase(Locale.ROOT))) {
            return CryptoType.SM4;
        }
        return CryptoType.DES;
    }

    public static String getCryptoExt() {
        String encryptType = configData.encryptMode;
        if ("SM4".equals(encryptType.toUpperCase(Locale.ROOT))) {
            return ".encx";
        }
        return ".enc";

    }

}
