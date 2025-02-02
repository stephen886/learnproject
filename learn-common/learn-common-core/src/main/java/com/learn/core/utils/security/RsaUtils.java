package com.learn.core.utils.security;

import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;

/**
 * RSA加密解密
 *
 * @author ruoyi
 **/
public class RsaUtils {
    // Rsa 私钥
    public static String PRIVATE_KEY = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAJSiCvJY97SBZArovC5+GJSQivMbdVf14iHEQSOf5ZYwMCZC1e3EiK5eN0NCCzFJICKY6dtOW0kul4g9Wj4qUdo3vtc3EjoMn21NWFvCZ0uCaUlXL897vw9bk4jzuSZrpvgxfNe6NPnA4a6YySEZ5f4SFzW/eiy8t1KBHpcFSI7VAgMBAAECgYEAgOEdctT4PLlxgRAblIjcUX4gLfriPhpEMZlWDkjor9kq9xI/I8Ol7ORfMN/EisDor3c+WF5SQ1u2I3lnlb3maGfOqnfhTnJL2dO9ajAoSNRIU3cFMVY0rGiQTkTDikmCXKEjv5ta0w6u663oLd1h4MY0+BVBpJIRVDLcbMx2m2ECQQDcsEGbcLlztX0O9GQ8hfKS+BzovlYA4G3dViDBRgVoWb0CDXLzaTjHAQzlDSuC6lFpP5fHlUYaCu6WRq6cjTg9AkEArGpHya5UsJlohZt9eBfX3zJbvYYZ0jOc7t9olGVpSzcKF9ddCDtu1gAjJY0ZstMVp6ZM9KgG58UgIZom1YKCeQJBANPV7GQEpD9Jaq28MatW+C3TNAzFB1D4HP1k+zQKvo4X9bHOrxSvX+zGOVZ0edvEiDj67fqKcyv0amidmGZ1uBECQCN4nhpNBllqxkkuiyqo5R2jM6KTMz6+pZuzVMWq83Wo9iefhCFMcOoQDysLk2zp5nueSBjRdNI8CPdAypqEhikCQQCCIAgyO3RErIfyi0a+z6vX0yL6NsLcNri4o/BkTd95XGVyAr/biOSfftHWo7zTuVBcMGqT14bqET/HLwvDv1+M";

    public static String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCUogryWPe0gWQK6LwufhiUkIrzG3VX9eIhxEEjn+WWMDAmQtXtxIiuXjdDQgsxSSAimOnbTltJLpeIPVo+KlHaN77XNxI6DJ9tTVhbwmdLgmlJVy/Pe78PW5OI87kma6b4MXzXujT5wOGumMkhGeX+Ehc1v3osvLdSgR6XBUiO1QIDAQAB";

    private static final RSA RSA;

    static {
        RSA = new RSA(PRIVATE_KEY, PUBLIC_KEY);
    }

    public static String decrypt(String base64) {
        return RSA.decryptStr(base64, KeyType.PrivateKey);
    }

    public static String encrypt(String text) {
        return RSA.encryptBcd(text, KeyType.PrivateKey);
    }

}
